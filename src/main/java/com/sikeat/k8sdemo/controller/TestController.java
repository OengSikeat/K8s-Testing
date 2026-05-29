package com.sikeat.k8sdemo.controller;


import com.sikeat.k8sdemo.dto.UserRequest;
import com.sikeat.k8sdemo.dto.UserResponse;
import com.sikeat.k8sdemo.entity.User;
import com.sikeat.k8sdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    private final UserRepository userRepository;

    @GetMapping("/test")
    public String test() {
        return "test";
    }
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User user = User.builder()
                .username(userRequest.getUserName())
                .description(userRequest.getDescription())
                .build();
        UserResponse response = userRepository.save(user).toResponse();
        return  ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users.stream().map(User::toResponse).toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        UserResponse resp = userRepository.findById(id).orElseThrow().toResponse();
        return ResponseEntity.ok(resp);
    }
}
