package com.example.bookshop.pojosdto;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private String name;
    private String login;
    private String password;
    private RoleDto role;
    private String email;
    private Double phone;
    private String address;

    public UserDto(String name, String login, RoleDto role){
        this.name = name;
        this.login = login;
        this.role = role;
    }
}
