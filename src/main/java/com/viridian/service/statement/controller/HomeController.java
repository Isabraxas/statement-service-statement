package com.viridian.service.statement.controller;

import org.apache.cayenne.configuration.server.ServerRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    ServerRuntime mainServerRuntime;

    @RequestMapping("/")
    public String home(
        @RequestParam(required = false) String localUrl,
        @RequestParam(required = false) String remoteUrl
    ) {

        return "Available commands:\n\n" +
            "Account Endpoints:\n" +
            "  http /statement\n\tList all statement\n\n" +
            "  http /statement/{number}\n\tGet transactions for one account\n\n" +
            "  http POST /statement?quantity=1\n\tcreates many dummy statement\n\n";
    }

}
