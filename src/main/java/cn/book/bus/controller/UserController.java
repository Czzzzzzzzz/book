package cn.book.bus.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 追风
 * @since 2019-12-16
 */
@Controller
public class UserController {


    @RequestMapping(value = "login")
    public String Login(){

        return "login";
    }

    @RequestMapping(value = "signin")
    public String SignIn(){

        return "signin";
    }
}

