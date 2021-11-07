package com.coldmorning.online.education.coupon.repository;

import com.coldmorning.online.education.auth.model.User;
import com.coldmorning.online.education.coupon.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CoupRepository extends JpaRepository<Coupon, Long> {
}
