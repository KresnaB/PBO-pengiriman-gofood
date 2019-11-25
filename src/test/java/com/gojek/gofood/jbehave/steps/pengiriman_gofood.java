package com.gojek.gofood.jbehave.steps;

import com.gojek.gofood.model.*;
import com.gojek.gofood.service.*;

import org.jbehave.core.annotations.*;
import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class pengiriman_gofood {
	List<Driver> drivers;
	List<String> proposedDrivers;
	driverService DriverService;
	
	@Given("a list of drivers : $givenDrivers")
	public void givenListOfDrivers(List<String> givenDrivers) {
		drivers = new ArrayList<Driver>();
		for (String e : givenDrivers) {
			drivers.add(new Driver(e));
		}
	}
	
	@When("The distances between these drivers and the merchant location are : $distance")
	public void whenDintanceBetweenDriversAndMerchant (List<Float> distance) {
		int i = 0;
		for(Driver e : drivers){
			e.setDistance(distance.get(i));
			i++;
		}
		DriverService = new driverService(drivers);
		proposedDrivers = DriverService.getNearestDriverName();
	}
	
	@Then("The sistem should pick : $nearestDriver")
	public void shouldFindTheseDriver(List<String> nearestDriver) {
		assertThat(proposedDrivers).isEqualTo(nearestDriver);
	}
}
