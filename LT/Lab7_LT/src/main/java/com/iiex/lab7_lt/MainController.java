package com.iiex.lab7_lt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
//    @Autowired private UserServi
    @GetMapping("")
    public String ShowHome(){
        return "index";
    }
}
