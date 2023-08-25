package com.example.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
//    removed the constructor and replaced it with a setter method for injecting the Coach dependency
//    public DemoController(Coach theCoach) {
//        myCoach = theCoach;
//    }
    public void setMyCoach(Coach myCoach) {
        this.myCoach = myCoach;
    }
    // any method name can be used

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
