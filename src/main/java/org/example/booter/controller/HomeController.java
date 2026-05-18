package org.example.booter.controller;

import io.micrometer.common.util.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String home(@RequestParam(value = "name", required = false) String name) {
        String greeting = "";
        if (StringUtils.isBlank(name)) {
            greeting = "Hello Home";
        } else {
            greeting = "Hello " + name;
        }
        return "<h1>" + greeting + "</h1>";
    }
}
