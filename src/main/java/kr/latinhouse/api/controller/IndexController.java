package kr.latinhouse.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/")
public class IndexController {
    @ApiIgnore
    @GetMapping("/")
    public String index() {
        return "redirect:" + "/swagger-ui.html";
    }
}