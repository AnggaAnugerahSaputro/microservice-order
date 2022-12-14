package org.binar.microservce.orderservice.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orderDetail")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderDetailId")
    private Integer ordersDetailId;

    @Column(name = "orderId")
    private String orderId;

    @Column(name = "seatRow")
    private String seatRow;

    public OrderDetailEntity(String rowSeats) {
        this.seatRow = rowSeats;
    }

    public OrderDetailEntity() {
    }

}
