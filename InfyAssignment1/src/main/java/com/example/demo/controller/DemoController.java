package com.example.demo.controller;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DemoController {

	private ZonedDateTime dateAndDay = ZonedDateTime.now();

	@GetMapping("whatIsToday")
	public ResponseEntity<ZonedDateTime> getDateAndDay() {
		return new ResponseEntity<>(dateAndDay, HttpStatus.OK);
	}

	@GetMapping("whatIsDayOfTheWeek")
	public ResponseEntity<DayOfWeek> getWeekDay() {
		return new ResponseEntity<DayOfWeek>(dateAndDay.getDayOfWeek(), HttpStatus.OK);
	}
}
