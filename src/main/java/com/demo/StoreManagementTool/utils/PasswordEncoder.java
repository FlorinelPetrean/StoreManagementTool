package com.demo.StoreManagementTool.utils;

import org.mindrot.jbcrypt.*;
import org.springframework.stereotype.Component;


@Component
public class PasswordEncoder {
    public PasswordEncoder() {
    }


    public static String encodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
