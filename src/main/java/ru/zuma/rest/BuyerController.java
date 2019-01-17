package ru.zuma.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.zuma.rest.model.BuyerAccountInfo;

import javax.servlet.http.HttpServletResponse;

@Controller
public class BuyerController {
    @RequestMapping(value = "/buyer/account/info/get", method = RequestMethod.GET)
    public ResponseEntity<BuyerAccountInfo> getInfo(/*@RequestParam("cookie") Cookie cookie,*/ HttpServletResponse response) {
        return new ResponseEntity<>(new BuyerAccountInfo(12345,"anton","yuryevich","Mamontov",
                "anton_mamont@bk.ru","+79294522166","Госпитальный пер. д.4","Бауманская"), HttpStatus.OK);
    }
}
