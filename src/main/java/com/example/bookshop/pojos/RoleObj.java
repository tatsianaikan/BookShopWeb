package com.example.bookshop.pojos;

import com.example.bookshop.pojos.enums.RoleType;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
public class RoleObj implements Serializable {
    private RoleType roleType;

    public RoleObj(RoleType roleType){
        this.roleType = roleType;
    }
}
