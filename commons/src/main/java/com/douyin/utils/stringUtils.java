package com.example.utils;

import java.text.SimpleDateFormat;

public class stringUtils {
    private static SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");

    public static Integer parse(String token) {
        if (token == null || "0".equals(token) || "".equals(token)) {
            return 0;
        } else {
            boolean verify = jwt.verify(token);
            if (!verify) {
                throw new RuntimeException("token is wrong or expired");
            }
            String s = jwt.parseJWT(token);
            return Integer.parseInt(s);
        }
    }

    public static String parseTime(Object t) {
        return formatter.format(t);
    }
}
