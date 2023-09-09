package com.Speakingclock.Speaking.clock.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class SpeakingClockModel {
	
	private int hours;
    private int minutes;
    private String result;


}
