package com.coldmorning.online.education.coupon.service;

import com.coldmorning.online.education.auth.service.AuthService;
import com.coldmorning.online.education.coupon.model.Coupon;
import com.coldmorning.online.education.coupon.service.impl.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


public interface CouponService  {
    public Coupon getCoupon(Long id);
    public Coupon createCoupon();
    public Coupon updateCoupon();
    public Coupon deleteCoupon();
}
