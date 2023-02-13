package com.example.bookshop.pojos;

import com.example.bookshop.pojos.enums.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
public class StatusObj implements Serializable {
    private StatusType statusType;

    public StatusObj(){
        this.statusType = StatusType.NEW;
    }
}
