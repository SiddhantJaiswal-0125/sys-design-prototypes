package com.siddhant.protorypes.MasterReplicaDB.controller;

import com.siddhant.protorypes.MasterReplicaDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // WRITE: POST → MASTER
    @PostMapping
    public String createUser(@RequestBody UserRequest request) {
        return userService.createUser(request.name, request.email);
    }

    // READ: GET → REPLICA
    @GetMapping
    public List<Map<String, Object>> getUsers() {
        return userService.getAllUsers();
    }

    static class UserRequest {
        public String name;
        public String email;
    }
}
