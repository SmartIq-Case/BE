package com.smartIq.vehicledealership.vehicledealership.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordEncoder {

    // TODO : encode method.
    // TODO : matches method.


    /**
     * SHA-256 Kullanarak verilen şifreyi çevirir.
     *
     * @param password
     * @return
     */
    public String encode(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Verilen düz şifreyi SHA256 versiyonu ile karşılaştırmak için kullanılır.
     * Verilen şifrelenmemiş şifreyi, SHA-256 ile şifreleyip
     * Verilen şifrelenmiş şifre ile karşılaştırır.
     * @param rawPassword
     * @param cryptedPassword
     * @return
     */
    public void matches(
            String rawPassword,
            String cryptedPassword) throws RuntimeException {
        String hashedUserInputPassword = encode(rawPassword);
        if (hashedUserInputPassword.equals(cryptedPassword)) {
            //That means passwords are same.
            //Do nothing.
        } else {
            //That means passwords are different.
            //Throw error.
            throw new RuntimeException("The password for the Account is incorrect.");
        }
    }


}
