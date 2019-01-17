package ru.zuma.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import ru.zuma.rest.model.ExceptionResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    private String accessTokenHeader = "WWW-Authenticate";

    @Override
    public void commence
            (HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException {
        response.addHeader(accessTokenHeader, "Basic realm=\"" + getRealmName() + "\"");
        new ExceptionResponse(HttpStatus.UNAUTHORIZED, authEx.getMessage()).write(response);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("Baeldung");
        super.afterPropertiesSet();
    }

    public String getAccessTokenHeader() {
        return accessTokenHeader;
    }
}