package com.Speakingclock.Speaking.clock.serviceImpl;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Speakingclock.Speaking.clock.exception.GlobalExceptionHandler;
import com.Speakingclock.Speaking.clock.model.SpeakingClockModel;
import com.Speakingclock.Speaking.clock.util.SpeakingClockConstants;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SpeakingclockService {
	
    /**
     * Initializes a newly created {@code SpeakingClock} object so that initializes
     * the hours, minutes and result.
     *
     * @param  hour the initial string hour entered.
     * @throws Exception 
     */
    public String formatTime(String hour) throws Exception {

    	
    	log.info("initiating time formatting for {}",hour );
        try {
        	SpeakingClockModel speakingClockModel = new SpeakingClockModel();
        	String[] hours = hour.trim().split(":");
        	speakingClockModel.setHours(Integer.parseInt(hours[0]));
        	speakingClockModel.setMinutes(Integer.parseInt(hours[1]));
        	return solve(speakingClockModel);
        	
        } catch (NumberFormatException e) {
        	log.info("An exception occurred while converting to integer {}", e.getMessage());
            throw new NumberFormatException(SpeakingClockConstants.ERROR_MESSAGE);
        }
        catch (Exception e) {
        	log.info("An exception occurred while converting to integer {}", e.getMessage());
            throw new Exception(SpeakingClockConstants.GENERIC_ERROR_MESSAGE);
        }
    }

    /**
     * Calls the method {@link #convertToWords} in order to convert the {@code int}
     * hours and minute and prints it in words.
     */
    public String solve(SpeakingClockModel speakingClockModel) {

    	log.info("converting time into words");
        String hourInWords = convertToWords(speakingClockModel.getHours(), speakingClockModel.getMinutes());

        if (hourInWords.equals("")) {
        	log.info(SpeakingClockConstants.NOT_POSSIBLE);
           return SpeakingClockConstants.NOT_POSSIBLE;
        } else {
           return hourInWords;          
        }
    }

    /**
     * Converts given a {@code int} hour and minutes to a hour in words.
     *
     * @param hour      {@code int} hour
     * @param minutes   {@code int} minutes
     * @return          the {@code String} hour
     */
    private String convertToWords(int hour, int minutes) {

        StringBuilder result = new StringBuilder();

        if (minutes == 0) {

            if (hour == 12) {
            	log.info(SpeakingClockConstants.ITS_MIDDAY);
                return result.append(SpeakingClockConstants.ITS_MIDDAY).toString();
            }

            if (hour == 24) {
            	log.info(SpeakingClockConstants.ITS_MIDNIGHT);
                return result.append(SpeakingClockConstants.ITS_MIDNIGHT).toString();
            }

            result.append(SpeakingClockConstants.ITS).append(SpeakingClockConstants.ONES[hour % 12]);
            log.info(result.toString());

        } else if (minutes % 10 == 0) {
            result.append(SpeakingClockConstants.ITS).append(SpeakingClockConstants.ONES[hour % 12]).append(SpeakingClockConstants.TENS[minutes / 10]);
        } else if (minutes < 10 || minutes > 20) {
            result.append(SpeakingClockConstants.ITS).append(SpeakingClockConstants.ONES[hour % 12]).append(SpeakingClockConstants.TENS[minutes / 10]).append(SpeakingClockConstants.ONES[minutes % 10]);
        } else {
            // minutes > 10 && minutes < 20
            result.append(SpeakingClockConstants.ITS).append(SpeakingClockConstants.ONES[hour % 12]).append(SpeakingClockConstants.ONES[minutes]);
        }

        log.info(result.toString());
        return result.toString();
    }
}
