package com.example.bookshop.pojos;

import com.example.bookshop.entity.Role;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserObj implements Serializable {

    private String name;
    private String login;
    private String password;
    private RoleObj role;
    private String email;
    private Double phone;
    private String address;

    public UserObj (String name, String login, RoleObj role){
        this.name = name;
        this.login = login;
        this.role = role;
    }
}
