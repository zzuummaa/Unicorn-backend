package ru.zuma.rest;

import org.springframework.beans.factory.annotation.Autowired;
import ru.zuma.auth.MyBasicAuthenticationEntryPoint;
import ru.zuma.database.UserRepository;
import ru.zuma.rest.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthController {

    private long cookieVal = (long) (Math.random() * Long.MAX_VALUE/2);

    private final UserRepository userRepository;
    private final MyBasicAuthenticationEntryPoint entryPoint;

    @Autowired
    public AuthController(UserRepository userRepository, MyBasicAuthenticationEntryPoint entryPoint) {
        this.userRepository = userRepository;
        this.entryPoint = entryPoint;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handle(Exception ex,
                                         HttpServletRequest request, HttpServletResponse response) {
        if (ex instanceof NullPointerException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody User user, HttpServletResponse response) {
        if (user == null || user.getAndroidId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ru.zuma.database.User founded = userRepository.findFirstByAndroidId(user.getAndroidId());
        if (founded != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        ru.zuma.database.User databaseUser = new ru.zuma.database.User();
        String accessToken = UUID.randomUUID().toString();
        databaseUser.setAccessToken(accessToken);
        databaseUser.setAndroidId(user.getAndroidId());
        userRepository.save(databaseUser);

        response.addHeader(entryPoint.getAccessTokenHeader(), accessToken);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user, HttpServletResponse response) {
        if (user == null || user.getAndroidId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ru.zuma.database.User founded = userRepository.findFirstByAndroidId(user.getAndroidId());
        if (founded == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        response.addHeader(entryPoint.getAccessTokenHeader(), founded.getAccessToken());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
