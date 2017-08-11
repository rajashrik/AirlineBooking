package com.airline;

import org.junit.Before;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by rajashrk on 8/11/17.
 */
public class FlightTestData {

    Plane plane;
    Calendar departure;
    List<Flight> flights = new ArrayList<Flight>();
    Flight flight1;
    Flight flight2;
    Flight flight3;
    SearchDetails searchDetails;

    public FlightTestData() throws Exception {

        plane = new Plane("Airbus A319 V2",70);
        departure = new GregorianCalendar(2017,0,1,1,2,3);

        List<TravelClass> travelClassesList = new ArrayList<TravelClass>();
        TravelClass travelClassEconomy = new TravelClass(ClassType.ECONOMY,10,6000.0);
        TravelClass travelClassBusiness = new TravelClass(ClassType.BUSINESS,10,13000.0);
        TravelClass travelClassFirst = new TravelClass(ClassType.FIRST,10,20000.0);
        travelClassesList.add(travelClassBusiness);
        travelClassesList.add(travelClassEconomy);
        travelClassesList.add(travelClassFirst);

        flight1 = new Flight("Pune", "Kolkata",plane,"F1",departure,departure,travelClassesList);
        flight2 = new Flight("Pune", "Kolkata",plane,"F2",departure,departure,travelClassesList);
        flight3 = new Flight("Hyderabad", "Nashik",plane,"F3",departure,departure,travelClassesList);

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        searchDetails = new SearchDetails();
        searchDetails.setTo("Kolkata");
        searchDetails.setFrom("Pune");
        searchDetails.setDepartureDate("2017-01-01");
        searchDetails.setNumberOfPassengers(10);
        searchDetails.setClassType("Economy");
    }
}
