package ru.zuma.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.zuma.database.Unicorn;
import ru.zuma.database.UnicornRepository;
import ru.zuma.rest.model.OkResponse;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {

    private final UnicornRepository unicornRepository;

    @Autowired
    public AdminController(UnicornRepository unicornRepository) {
        this.unicornRepository = unicornRepository;
    }

    @RequestMapping(value = "/admin/unicorns/update", method = RequestMethod.POST)
    public ResponseEntity updateUnicorns(HttpServletResponse response) {
        List<Unicorn> unicorns = new ArrayList<>();

        LocalDate date = LocalDate.of(1991, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(1992, Month.JANUARY, 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMdd");
        for (; date.isBefore(endDate); date = date.plusDays(1)) {
            Date d = java.sql.Date.valueOf(date);
            unicorns.add(new Unicorn(dateFormat.format(d)));
        }
        unicornRepository.saveAll(unicorns);

        return new OkResponse().toEntity();
    }
}
