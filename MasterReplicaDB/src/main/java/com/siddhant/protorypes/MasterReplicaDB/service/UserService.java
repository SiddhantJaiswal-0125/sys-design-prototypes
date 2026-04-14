package com.siddhant.protorypes.MasterReplicaDB.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final JdbcTemplate masterJdbc;
    private final JdbcTemplate replicaJdbc;

    public UserService(@Qualifier("masterJdbcTemplate") JdbcTemplate masterJdbc,
                       @Qualifier("replicaJdbcTemplate") JdbcTemplate replicaJdbc) {
        this.masterJdbc = masterJdbc;
        this.replicaJdbc = replicaJdbc;
    }

    public String createUser(String name, String email) {
        masterJdbc.update("INSERT INTO users (name, email) VALUES (?, ?)", name, email);
        return "User created in MASTER DB";
    }

    public List<Map<String, Object>> getAllUsers() {
        return replicaJdbc.queryForList("SELECT * FROM users");
    }

    // 🔥 NEW SYNC - NO SET SESSION, NO SEMICOLONS
    @Scheduled(fixedRate = 10000)
    public void syncMasterToReplica() {
        System.out.println("🔄 SYNC START");
        try {
            // TRUNCATE ONLY (single statement)
            replicaJdbc.update("TRUNCATE TABLE users");

            // Get master data
            List<Map<String, Object>> data = masterJdbc.queryForList("SELECT * FROM users");

            // Insert one by one
            for (Map<String, Object> row : data) {

                replicaJdbc.update("INSERT INTO users (name, email) VALUES (?, ?)",   row.get("name"), row.get("email") );
            }

            System.out.println("✅ SYNC OK: " + data.size() + " rows");
        } catch (Exception e) {
            System.err.println("❌ SYNC ERROR: " + e.getMessage());
        }
    }
}
