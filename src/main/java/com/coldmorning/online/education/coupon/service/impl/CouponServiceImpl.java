package com.coldmorning.online.education.coupon.service.impl;

import com.coldmorning.online.education.auth.model.User;
import com.coldmorning.online.education.auth.repository.AuthRepository;
import com.coldmorning.online.education.coupon.model.Coupon;
import com.coldmorning.online.education.coupon.repository.CoupRepository;
import com.coldmorning.online.education.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CoupRepository coupRepository;

    @Override
    public Coupon getCoupon(Long id){
        Optional<Coupon> coupon = coupRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        return null;
    }
    @Override
    public Coupon createCoupon(){
        return null;
    }

    @Override
    public Coupon updateCoupon(){
        return null;
    }

    @Override
    public Coupon deleteCoupon(){
        return null;
    }

}
