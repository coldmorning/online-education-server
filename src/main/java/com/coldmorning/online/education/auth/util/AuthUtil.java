package com.coldmorning.online.education.auth.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthUtil {
    public static String BCryptPassword(String str){;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(str);
        return encodedPassword;
    }
}
