package com.airline;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by rajashrk on 8/9/17.
 */
public class SearchDetails {
   private String from;
   private String to;
   private Calendar departureDate;
   private Integer numberOfPassengers;
   private String classType;

    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setDepartureDate(String departureDateString) throws Exception {
        if (departureDateString.isEmpty()) {
            this.departureDate = null;
        } else {
            Calendar departureDate = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            departureDate.setTime(sdf.parse(departureDateString));
            this.departureDate = departureDate;
        }
    }

    public Calendar getDepartureDate() {
        return departureDate;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
