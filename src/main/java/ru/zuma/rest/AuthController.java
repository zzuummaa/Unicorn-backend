package ru.zuma.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.zuma.auth.MyBasicAuthenticationEntryPoint;
import ru.zuma.database.UserRepository;
import ru.zuma.rest.model.ExceptionResponse;
import ru.zuma.rest.model.OkResponse;
import ru.zuma.rest.model.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AuthController {
    private final UserRepository userRepository;
    private final MyBasicAuthenticationEntryPoint entryPoint;

    @Autowired
    public AuthController(UserRepository userRepository, MyBasicAuthenticationEntryPoint entryPoint) {
        this.userRepository = userRepository;
        this.entryPoint = entryPoint;
    }

    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    @PreAuthorize("permitAll()")
    public ResponseEntity register(@RequestBody User user, HttpServletResponse response) throws IOException {
        if (user.getAndroidId() == null) {
            return new ExceptionResponse("Invalid JSON format").toEntity();
        }

        ru.zuma.database.User founded = userRepository.findFirstByAndroidId(user.getAndroidId());
        if (founded != null) {
            return new ExceptionResponse("Android ID already registered").toEntity();
        }

        ru.zuma.database.User databaseUser = new ru.zuma.database.User();
        String accessToken = UUID.randomUUID().toString();
        databaseUser.setAccessToken(accessToken);
        databaseUser.setAndroidId(user.getAndroidId());
        userRepository.save(databaseUser);

        response.addHeader(entryPoint.getAccessTokenHeader(), accessToken);
        return new OkResponse().toEntity();
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    @PreAuthorize("permitAll()")
    public ResponseEntity login(@RequestBody User user, HttpServletResponse response) throws IOException {
        if (user.getAndroidId() == null) {
            return new ExceptionResponse("Invalid JSON format").toEntity();
        }

        ru.zuma.database.User founded = userRepository.findFirstByAndroidId(user.getAndroidId());
        if (founded == null) {
            return new ExceptionResponse("Unknown android ID").toEntity();
        }

        response.addHeader(entryPoint.getAccessTokenHeader(), founded.getAccessToken());
        return new OkResponse().toEntity();
    }
}
