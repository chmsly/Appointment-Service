package com.dsd.reservationsystem.service;

import com.dsd.reservationsystem.database.Db;
import com.dsd.reservationsystem.models.Appointment;
import com.dsd.reservationsystem.models.DaySchedule;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TimeSlotsService {
    private final Db database;
    ArrayList<String> timeSlotCodes = new ArrayList<>(Arrays.asList("TS79", "TS911", "TS111", "TS13", "TS35", "TS57"));

    public TimeSlotsService(Db database) {
        this.database = database;
    }

    //date will be provided in 03022024 two-digit month, two-digit month and four digit year
    public Map<String, Boolean> getTimeSlotsAvailabilityForDay(String dateStr) throws Exception {
        Map<String, Boolean> timeSlotsAvailability = new HashMap<String, Boolean>() {{
            put("TS79", true);
            put("TS911", true);
            put("TS111", true);
            put("TS13", true);
            put("TS35", true);
            put("TS57", true);
        }};

        DaySchedule dayTimeSlots = this.database.getTimeSlotsForDay(dateStr);


        //get set of key:value from Map and loop through it
        for (Map.Entry<String, Appointment> timeSlot : dayTimeSlots.appointments().entrySet()) {
            String key = timeSlot.getKey();
            Object timeSlotData = timeSlot.getValue();

            //check if timecode exists, if exists then time slot is taken
            if (timeSlotData != null) {
                timeSlotsAvailability.put(key, false);
            }
        }
        return timeSlotsAvailability;
    }

    public boolean isTimeSlotAvailable(String day, String timeSlot) {
        try {
            Map<String, Boolean> timeSlots = getTimeSlotsAvailabilityForDay(day);
            return timeSlots.get(timeSlot);
        } catch (Exception e) {
            return false;
        }
    }
}
