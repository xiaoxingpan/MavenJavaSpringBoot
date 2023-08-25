package com.example.springcoredemo;

public class TrackCoach  implements Coach {
    private IFortuneService fortuneService;

    public TrackCoach(IFortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }
}
