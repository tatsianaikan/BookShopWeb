package com.example.bookshop.pojosdto;

import com.example.bookshop.pojosdto.enums.RoleType;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
public class RoleDto implements Serializable {
    private RoleType roleType;

    public RoleDto(RoleType roleType){
        this.roleType = roleType;
    }

    public RoleType getRoleType(){
        return roleType;
    }
}
