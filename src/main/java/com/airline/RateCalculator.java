package com.airline;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by rajashrk on 8/11/17.
 */
public class RateCalculator {

    public Double getPrice(TravelClass travelClass, Integer numberOfSeatsToBook) {
        Double basePrice = travelClass.getBasePrice();
        if(travelClass.getClassType() == ClassType.ECONOMY) {
            double ratio = (double)travelClass.getAvailableSeats() / travelClass.getTotalSeats();
            if(ratio <= 0.1) {
                basePrice = basePrice * 1.6;
            } else if(ratio <= 0.6) {
                basePrice = basePrice * 1.3;
            }
        }
        return basePrice * numberOfSeatsToBook;
    }


    public Map<String, Double> getPriceMap(List<Flight> flights, String classType, int numberOfSeats) {
        return flights.stream().collect(
                Collectors.toMap(Flight::getNumber,
                        flight -> getPrice(flight.getTravelClassFromClassType(classType), numberOfSeats)));
    }

}
