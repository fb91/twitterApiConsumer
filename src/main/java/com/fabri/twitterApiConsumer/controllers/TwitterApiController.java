package com.fabri.twitterApiConsumer.controllers;

import com.fabri.twitterApiConsumer.services.TweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwitterApiController {

    @Autowired
    TweetsService tweetsService;

    @RequestMapping(value = "retrieveJoke", method = RequestMethod.POST)
    public String retrieveJoke() {
        return tweetsService.retrieveRandomTweet();
    }

}
