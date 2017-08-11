package com.airline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by rajashrk on 8/11/17.
 */
public class RateCalculatorTest {

    private FlightTestData data;

    @Before
    public void setUp() throws Exception {
        data = new FlightTestData();
    }

    @Test
    public void shouldReturnCorrectPrice() throws Exception {
        Double expectedValueForEconomyClass = 12000.0;
        Double expectedValueForBusinessClass = 26000.0;
        Double expectedValueForFirstClass = 40000.0;
        Assert.assertEquals(expectedValueForEconomyClass,new RateCalculator().getPrice(data.flight1,"Economy",2));
        Assert.assertEquals(expectedValueForBusinessClass,new RateCalculator().getPrice(data.flight1,"business",2));
        Assert.assertEquals(expectedValueForFirstClass,new RateCalculator().getPrice(data.flight1,"first",2));
    }


    @Test
    public void shouldReturnCorrectPriceMap() throws Exception {
        Double expectedFlightPriceValue = 12000.0;
        Map<String, Double> priceMap = new RateCalculator().getPriceMap(data.flights, "Economy", 2);
        Assert.assertEquals(expectedFlightPriceValue, priceMap.get("F1"));
        Assert.assertEquals(expectedFlightPriceValue, priceMap.get("F2"));
        Assert.assertEquals(expectedFlightPriceValue, priceMap.get("F3"));
    }
}
