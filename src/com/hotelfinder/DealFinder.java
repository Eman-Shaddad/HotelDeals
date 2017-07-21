package com.hotelfinder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;

public class DealFinder {

	private String searchFilter;
	
	/*
	 * This method finds the hotel deals based on the user request.
	 * The deals will be filtered based on the criteria specified by the user.
	 */
	public Deals findDeals(HttpServletRequest request) throws Exception {
		
		searchFilter = extarctSearchFilter(request);
		return new Deals(readJsonData());	
	}

	/*
	 * This methods constructs the search parameters which will be appended to the 
	 * request URL.
	 */
	private String extarctSearchFilter(HttpServletRequest request) {
	
		String destinationName = (String) request.getParameter("destinationName");
		String minTripStartDate = (String) request.getParameter("minTripStartDate");
		String maxTripStartDate = (String) request.getParameter("maxTripStartDate");
		String lengthOfStay = (String) request.getParameter("lengthOfStay");
		String minStarRating = (String) request.getParameter("minStarRating");
		String maxStarRating = (String) request.getParameter("maxStarRating");
		String minTotalRate = (String) request.getParameter("minTotalRate");
		String maxTotalRate = (String) request.getParameter("maxTotalRate");
		String minGuestRating = (String) request.getParameter("minGuestRating");
		String maxGuestRating = (String) request.getParameter("maxGuestRating");
		
		StringBuilder searchFilter = new StringBuilder();
		
		if(destinationName != null && !destinationName.equals("")) {
			searchFilter.append("&destinationName=");
			searchFilter.append(destinationName);
		}
		
		if(minTripStartDate != null && !minTripStartDate.equals("")) {
			searchFilter.append("&minTripStartDate=");
			searchFilter.append(minTripStartDate);
		}
		
		if(maxTripStartDate != null && !maxTripStartDate.equals("")) {
			searchFilter.append("&maxTripStartDate=");
			searchFilter.append(maxTripStartDate);
		}
		
		if(lengthOfStay != null && !lengthOfStay.equals("")) {
			searchFilter.append("&lengthOfStay=");
			searchFilter.append(lengthOfStay);
		}
		
		if(minStarRating != null && !minStarRating.equals("")) {
			searchFilter.append("&minStarRating=");
			searchFilter.append(minStarRating);
		}
		
		if(maxStarRating != null && !maxStarRating.equals("")) {
			searchFilter.append("&maxStarRating=");
			searchFilter.append(maxStarRating);
		}
		
		if(minTotalRate != null && !minTotalRate.equals("")) {
			searchFilter.append("&minTotalRate=");
			searchFilter.append(minTotalRate);
		}
		
		if(maxTotalRate != null && !maxTotalRate.equals("")) {
			searchFilter.append("&maxTotalRate=");
			searchFilter.append(maxTotalRate);
		}
		
		if(minGuestRating != null && !minGuestRating.equals("")) {
			searchFilter.append("&minGuestRating=");
			searchFilter.append(minGuestRating);
		}
		
		if(maxGuestRating != null && !maxGuestRating.equals("")) {
			searchFilter.append("&maxGuestRating=");
			searchFilter.append(maxGuestRating);
		}
		
		return searchFilter.toString();
	}

	/*
	 * This method reads data from the JSON API to retrieve the hotel deals information
	 * based on the user filter options
	 */
	private JsonObject readJsonData() throws Exception {
		
		String url = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
		url = url + searchFilter;
		URL oracle;
		JsonObject result = null;
		try {
			oracle = new URL(url);
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			JsonReader reader = Json.createReader(in);
			result = reader.readObject();
			
		} catch (MalformedURLException e) {
			throw new Exception("Failed to connect to server - " + e.getMessage());
		} catch (IOException e) {
			throw new Exception("Failed to read data - " + e.getMessage());
		}
		return result;
		
	}
}
