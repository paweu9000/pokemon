package com.example.demo.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserData {

    public static final String TABLE_NAME = "login_info";
    public static final String COLUMN_PREFIX = "u_";

    @Id
    @GeneratedValue
    @Column(name = COLUMN_PREFIX + "id", unique = true)
    private UUID id;
    @Column(unique = true)
    @NonNull
    @NotBlank(message = "login cannot be blank")
    private String login;
    @Column(unique = true)
    @NonNull
    @NotBlank(message = "username cannot be blank")
    private String username;
    @Column(unique = true)
    @NonNull
    @NotBlank(message = "email cannot be blank")
    private String email;
    @Column(nullable = false)
    @NonNull
    @NotBlank(message = "password cannot be blank")
    private String password;

}
