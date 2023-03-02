package com.example.bookshop.pojosdto;

import com.example.bookshop.pojosdto.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
public class StatusDto implements Serializable {
    private StatusType statusType;

    public StatusDto(){
        this.statusType = StatusType.NEW;
    }
}
