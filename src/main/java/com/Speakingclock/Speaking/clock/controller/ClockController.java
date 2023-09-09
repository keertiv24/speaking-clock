package com.Speakingclock.Speaking.clock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Speakingclock.Speaking.clock.serviceImpl.SpeakingclockService;

@RestController
public class ClockController {
	
	@Autowired
	private SpeakingclockService speakingclockService;
	
	@GetMapping("/getTime/{hours}")
	public ResponseEntity<String> getTime(@PathVariable String hours) throws Exception
	{
		return new ResponseEntity<String>(speakingclockService.formatTime(hours), HttpStatus.OK);
		
	}

}
