package ru.zuma.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.zuma.AppProperties;
import ru.zuma.database.*;
import ru.zuma.rest.model.DailyUnicorn;
import ru.zuma.rest.model.ExceptionResponse;
import ru.zuma.rest.model.OkResponse;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UnicornController {

    private final AppProperties appProperties;

    private final UserUnicornRepository userUnicornRepository;
    private final UnicornRepository unicornRepository;

    @Autowired
    public UnicornController(UserUnicornRepository userUnicornRepository,
                             AppProperties appProperties,
                             UnicornRepository unicornRepository) {
        this.userUnicornRepository = userUnicornRepository;
        this.appProperties = appProperties;
        this.unicornRepository = unicornRepository;
    }

    @RequestMapping(value = "/daily", method = RequestMethod.GET)
    public ResponseEntity getDaily(HttpServletResponse response) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MMdd"));
        DailyUnicorn dailyUnicorn = new DailyUnicorn(date, appProperties.getImageServerURL() + date + ".jpg");
        return ResponseEntity.status(HttpStatus.OK).body(dailyUnicorn);
    }

    @RequestMapping(value = "/collection", method = RequestMethod.POST)
    public ResponseEntity saveDaily(HttpServletResponse response) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MMdd"));
        Unicorn unicorn = unicornRepository.findByDate(date);
        if (unicorn == null) {
            return new ExceptionResponse("Daily unicorn not found").toEntity();
        }

        UserUnicorn userUnicorn = new UserUnicorn(user, unicorn);
        userUnicornRepository.save(userUnicorn);

        return new OkResponse().toEntity();
    }

    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public ResponseEntity getCollection(HttpServletResponse response) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<UserUnicorn> userUnicorns = userUnicornRepository.findByUserUnicornId_User(user);
        if (userUnicorns == null) {
            return new ExceptionResponse("Daily unicorn not found").toEntity();
        }

        List<ru.zuma.rest.model.Unicorn> unicorns = new ArrayList<>();
        for (UserUnicorn userUnicorn: userUnicorns) {
            String date = userUnicorn.getUserUnicornId().getUnicorn().getDate();
            String url  = appProperties.getImageServerURL() + date + ".jpg";
            unicorns.add(new ru.zuma.rest.model.Unicorn(date, url));
        }

        return ResponseEntity.status(HttpStatus.OK).body(unicorns);
    }
}
