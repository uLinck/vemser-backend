package br.com.dbc.vemser.pessoaapi.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGeneration {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("123");
        System.out.println(password); // $2a$10$gMSZANCwTBEqgbqujXITY.4VIoqy5c9XmfShdGmmQ1Rsk8C/Ab43K

        String minhaSenhaCrypt = "$2a$10$gMSZANCwTBEqgbqujXITY.4VIoqy5c9XmfShdGmmQ1Rsk8C/Ab43K";
        boolean matches = bCryptPasswordEncoder.matches("123", minhaSenhaCrypt);
        System.out.println(matches);
    }
}
