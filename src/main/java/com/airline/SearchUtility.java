package com.airline;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by rajashrk on 8/9/17.
 */
public final class SearchUtility {

    public static List<Flight> bySourceAndDestination(List<Flight> flights, SearchDetails searchDetails){
        List<Flight> matchingFlights = flights.stream()
            .filter(flight ->
                flight.getDestination().equals(searchDetails.getTo()) && flight.getSource().equals(searchDetails.getFrom()))
            .collect(Collectors.toList());

       return matchingFlights;
    }

    public static List<Flight> byDepartureDate(List<Flight> flights, SearchDetails searchDetails){

        Predicate<Flight> dateEqualityPredicate = new Predicate<Flight>() {
            @Override
            public boolean test(Flight flight) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                return dateFormat.format(flight.getDepartureTime().getTime()).equals(dateFormat.format(searchDetails.getDepartureDate().getTime()));
            }
        };

        List<Flight> matchingFlights = flights.stream()
            .filter(dateEqualityPredicate)
            .collect(Collectors.toList());

        return matchingFlights;
    }
}



