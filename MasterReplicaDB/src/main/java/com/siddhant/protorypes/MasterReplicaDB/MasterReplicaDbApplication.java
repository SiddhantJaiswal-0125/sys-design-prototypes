package com.siddhant.protorypes.MasterReplicaDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  // 🔥 Enables @Scheduled jobs

public class MasterReplicaDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterReplicaDbApplication.class, args);

	}

}
