package com.example.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    //define a private field for dependency
    private IFortuneService fortuneService;

    // define a constructor for dependency
    public CricketCoach(IFortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        // use my fortuneService to get a fortune
        return "Just do it: " + fortuneService.getFortune();
    }
}
