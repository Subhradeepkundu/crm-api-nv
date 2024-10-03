package com.teetime.crm.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/")
    fun sayHello(): String {
        return "Hello, World!!"
    }
}