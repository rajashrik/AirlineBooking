package com.airline;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rajashrk on 8/9/17.
 */
public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private String number;
    private Calendar departureTime;
    private Calendar arrivalTime;
    private Map<ClassType, TravelClass> classTypesMap = new HashMap<>();

    public Flight(String source, String destination, Plane plane, String number, Calendar departureTime, Calendar arrivalTime, List<TravelClass> classTypes) {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        for(TravelClass travelClass: classTypes){
            classTypesMap.put(travelClass.getClassType(), travelClass);
        }
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getNumber() {
        return number;
    }


    public Calendar getDepartureTime() {
        return departureTime;
    }

    public Calendar getArrivalTime() {
        return arrivalTime;
    }

    public boolean bookFlight(String classType, Integer numberOfSeatsTobeBooked) {
        return getTravelClassFromClassType(classType).bookSeat(numberOfSeatsTobeBooked);
    }

    public Double getBasePrice(String classType) {
        TravelClass travelClass = getTravelClassFromClassType(classType);
        return travelClass.getBasePrice();
    }

    private TravelClass getTravelClassFromClassType(String classType) {
        ClassType type = ClassType.valueOf(classType.toUpperCase());
        TravelClass travelClass = classTypesMap.get(type);
        return travelClass;
    }
}
