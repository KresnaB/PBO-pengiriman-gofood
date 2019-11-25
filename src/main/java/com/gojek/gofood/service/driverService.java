package com.gojek.gofood.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.gojek.gofood.model.*;

public class driverService {
	private List<Driver> driversList;
	
	public driverService(List<Driver> pl) {
		driversList = pl;
	}
	
	public List<String> getNearestDriverName() {
		ArrayList<String> result= new ArrayList<String>() ;
		float temp = 50;
		for (Driver e : driversList) {
			if (e.getDistance()<temp) {
				temp = e.getDistance();
				result.add(e.getName()) ;
			}
		}
		return result;
	}

}
