package com.example.springprojectmain.controllers;

import com.example.springprojectmain.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserServices userService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PatchMapping("/{id}/reset-password")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> resetPassword(@PathVariable Long id, @RequestBody String newPassword) {
        return ResponseEntity.ok(userService.resetPassword(id, newPassword));
    }

    @PatchMapping("/{id}/toggle-unlock")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> toggleUnlocked(@PathVariable Long id) {
        return ResponseEntity.ok(userService.toggleUnlocked(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}