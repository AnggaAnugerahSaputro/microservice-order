package org.binar.microservce.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderEntity {

    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String  orderId;

    @Column(name = "username")
    private String username;

    @Column(name = "filmName")
    private String filmName;

    @Column(name = "studioName")
    private String studioName;

    @Column(name = "showDate")
    private LocalDate showDate;

    @Column(name = "startTime")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+7")
    private LocalTime startTime;

    @Column(name = "endTime")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+7")
    private LocalTime endTime;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "schedule_id")
    private Integer scheduleId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderIumber")
    private Set<OrderDetailEntity> ordersDetail;

}
