package com.example.springcoredemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcoredemoApplication {
	@Bean
	public HappyFortuneService happyFortuneService(){
		return new HappyFortuneService();
	}

//  retrieve the TrackCoach
//	@Bean
//	public TrackCoach trackCoach() {
//		return new TrackCoach(happyFortuneService());
//	}
//
//	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringcoredemoApplication.class);
//		Coach theCoach = context.getBean("trackCoach", Coach.class);
//		System.out.println(theCoach.getDailyWorkout());
//		System.out.println(theCoach.getDailyFortune());
//		context.close();
//	}

	// retrieve the CricketCoach
	@Bean
	public CricketCoach cricketCoach() {
		return new CricketCoach(happyFortuneService());
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringcoredemoApplication.class);
		Coach theCoach = context.getBean("cricketCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		context.close();
	}

	}



