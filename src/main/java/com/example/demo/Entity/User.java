package com.example.demo.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = User.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
public class User {

    public static final String TABLE_NAME = "login_info";
    public static final String COLUMN_PREFIX = "u_";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = COLUMN_PREFIX + "id")
    private UUID id;
    private String login;
    private String username;
    private String email;
    private String password;

}
