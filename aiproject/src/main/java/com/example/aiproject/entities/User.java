package com.example.aiproject.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    // Default constructor
    public User() {}

    // Constructor with all fields except id (as it's usually auto-generated)
    public User(String username, String password, Role role, boolean unlocked) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.unlocked = unlocked;
    }

    // Constructor with all fields including id (useful for creating instances from database data)
    public User(Long id, String username, String password, Role role, boolean unlocked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.unlocked = unlocked;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean unlocked;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
