package com.example.bookshop.pojosdto;

import com.example.bookshop.pojosdto.enums.RoleType;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long userId;
    private String name;
    private String login;
    private String password;
    private RoleType role;
    private String email;
    private Double phone;
    private String address;

    public UserDto(String name, String login, RoleDto role){
        this.name = name;
        this.login = login;
        this.role = role.getRoleType();
    }
    public UserDto(String name, String email, String login, String address){
        this.name = name;
        this.email = email;
        this.login = login;
        this.address = address;
    }
}
