package com.siddhant.protorypes.MasterReplicaDB.service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
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

    // POST/WRITE → MASTER DB
    public String createUser(String name, String email) {
        masterJdbc.update("INSERT INTO users (name, email) VALUES (?, ?)", name, email);
        return "User created in MASTER DB";
    }

    // GET/READ → REPLICA DB
    public List<Map<String, Object>> getAllUsers() {
        return replicaJdbc.queryForList("SELECT * FROM users");
    }
}
