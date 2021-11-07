package com.coldmorning.online.education.coupon.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
// 折價卷
@Table(name = "coupon")
public class Coupon {
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "username")
    private String name;

    @Column(name = "startDate")
    private String startDate;
    @Column(name = "endDate")
    private String endDate;

    //20% off , 25% off, -$100, -$200
    @Column(name = "type")
    private String type;
    @Column(name = "value")
    private double value;
}
