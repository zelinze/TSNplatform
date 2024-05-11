package com.example.tsn.system.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "user", schema = "public") // Use 'users' as table name, within 'public' schema
@Data
@NoArgsConstructor
public class UserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false, unique = true)
    private String username; // 'account' renamed to 'username' for clarity

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String inviteUserId; // To track who invited this user, if applicable

    @Column
    private Boolean isAdmin = false; // Default to false, renamed to 'isAdmin' for clarity

    // Lombok will generate getters, setters, and a no-args constructor
}
