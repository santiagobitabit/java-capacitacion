package com.bitabit.test_react;

import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api")
public class testReactController {

   @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/test")
    public String test(@RequestBody TestRequest body) {
        System.out.println(body.getMessage());
        return body.getMessage();
    }

    @PostMapping("/test_form")
    public String test_form(@ModelAttribute TestRequest body) {
       String response = body.getMessage();
        System.out.println(response);
        return response;
    }

    @GetMapping("/test_path/{message}")
    public String test_form(@PathVariable("message")  String message) {

        return message;
    }

    @GetMapping("/test_query")
    public String test_query(@RequestParam("message")  String message) {

        return message;
    }
}
