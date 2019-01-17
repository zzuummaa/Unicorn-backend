package ru.zuma.auth;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderMOC implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return "encode_moc";
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return true;
    }
}
