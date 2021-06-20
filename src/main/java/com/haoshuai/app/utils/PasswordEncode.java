package com.haoshuai.app.utils;

import org.apache.commons.codec.digest.DigestUtils;

//Md5加密
public class PasswordEncode {
    public String encode(String password) {
        String md5_password = null;
        md5_password = DigestUtils.md5Hex(password);
        return md5_password;
    }
}
