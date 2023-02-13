package com.example.bookshop.entity;

import com.example.bookshop.pojos.enums.StatusType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="BookingStatus")
public class Status implements Serializable {
    @Id
    @Column(name="status_booking_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long statusId;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusType statusType;

}
