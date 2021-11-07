package com.coldmorning.online.education.coupon.controller;

import com.coldmorning.online.education.coupon.model.Coupon;
import com.coldmorning.online.education.coupon.model.request.CoupRequest;
import com.coldmorning.online.education.coupon.repository.CoupRepository;
import com.coldmorning.online.education.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value ="/api/v1/coupon")
public class CouponController {



    @GetMapping(value = "{id}")
    public ResponseEntity<?> getCoupon(@PathVariable("id")  String id) {

        return  ResponseEntity.ok("Test");
    }


    @PostMapping(value = "")
    public ResponseEntity<?> createCoupon(@Valid @RequestBody CoupRequest request){

        return  ResponseEntity.ok("Test");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> updateCoupon(){

        return  ResponseEntity.ok("Test");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteCoupon(){

        return  ResponseEntity.ok("Test");
    }

}
