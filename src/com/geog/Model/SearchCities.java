package com.geog.Model;
import javax.faces.bean.*;

@ManagedBean
public class SearchCities {
	private String compareOperators;
	private int population;
	private boolean isCoastal;
	private String countryCode;
	
	public SearchCities() {}
	
	public String getCompareOperators() {		
		return compareOperators;
	}
	public void setCompareOperators(String compareOperators) {
		this.compareOperators = compareOperators;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public boolean getIsCoastal() {
		return isCoastal;
	}
	public void setIsCoastal(boolean isCoastal) {
		this.isCoastal = isCoastal;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
} // SearchCities
