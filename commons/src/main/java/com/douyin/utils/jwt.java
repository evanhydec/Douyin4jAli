package com.douyin.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jwt {
    //设置过期时间
    private static final long EXPIRE_TIME = 240 * 60 * 1000;    //4h
//    private static final long EXPIRE_TIME = 10 * 1000;    //10s
    //token秘钥
    private static final String TOKEN_SECRET = "f26e587c28064d0e855e72c0a6a0e618";
    //加密算法
    private static Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

    public static String sign(String username, String permission) {
        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

            //设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带username,password信息，生成签名
            return JWT.create()
                    .withHeader(header)
                    .withClaim("loginName", username)
                    .withClaim("permission", permission)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @desc 验证token，通过返回true
     * @params [token]需要校验的串
     **/
    public static boolean verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @desc 解密token，返回username
     * @params [token]需要校验的串
     **/
    public static String parseJWT(String token) {
        DecodedJWT decodeToken = JWT.decode(token);
        return decodeToken.getClaim("loginName").asString();
    }

    /**
     * @desc 判断token是否过期
     * @author lj
     */
    public static boolean isJwtExpired(String token) {
        try {
            DecodedJWT decodeToken = JWT.decode(token);
            return decodeToken.getExpiresAt().before(new Date());
        } catch (Exception e) {
            return true;
        }
    }
}
