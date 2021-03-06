package org.springredis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class IndexController {

    @GetMapping("/swagger")
    @ApiIgnore
    public String getIndexPage() {
        return "redirect:/swagger-ui.html";
    }

    @GetMapping("/monitor")
    public String redirectToMonitor() {
        return "redirect:/index.html";
    }
}
