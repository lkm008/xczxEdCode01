package com.xuecheng.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 获取加密后的密码
 *
 * @author <a href="https://echocow.cn">EchoCow</a>
 * @date 19-7-13 下午4:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PasswordTest {

    @Test
    public void password() {
        // System.out.println(new BCryptPasswordEncoder().encode("oauth2"));
        // System.out.println(new BCryptPasswordEncoder().encode("XcWebApp"));
        System.out.println(new BCryptPasswordEncoder().encode("app"));
    }

}
