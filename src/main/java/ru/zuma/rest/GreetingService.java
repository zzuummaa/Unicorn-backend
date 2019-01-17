package ru.zuma.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zuma.database.User;

@RestController
@RequestMapping("/protected/greeting")
public class GreetingService {

    @RequestMapping
    public ResponseEntity get() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok("G'day, " + user.getAccessToken());
    }
}