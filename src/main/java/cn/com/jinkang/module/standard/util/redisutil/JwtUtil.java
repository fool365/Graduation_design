package cn.com.jinkang.module.standard.util.redisutil;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {

    // Token过期时间1秒
    public static final long EXPIRE_TIME = 5 * 1000;
    // 刷新时间5秒
    public static final long REFRESH_TIME = 5 * 1000;

    public static final String SECRET = "12345678";

    /**
     * 校验token是否正确
     *
     * @param token
     * @param username
     * @param secret
     * @return
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            // 设置加密算法
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
            // 效验TOKEN
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 生成token
     *
     * @param username
     * @return
     */
    public static String creat(String username) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        String token = JWT.create().withClaim("username", username).withExpiresAt(date).sign(algorithm);
        return token;
    }

    /**
     * 生成refreshToken
     *
     * @param username
     * @return
     */
    public static String creatRefresh(String username) {
        Date date = new Date(System.currentTimeMillis() + REFRESH_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        String refreshToken = JWT.create().withClaim("username", username).withExpiresAt(date).sign(algorithm);
        return refreshToken;
    }

    /**
     * 获得用户名
     *
     * @param token
     * @return 用户名
     */
    public static String getUserNameByToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("username").asString();
    }

    /**
     * 判断是否过期
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().before(new Date());
    }

    /**
     * 获取过期时间
     *
     * @param token
     * @return
     */
    public static Date getExpiresDate(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt();
    }

}
