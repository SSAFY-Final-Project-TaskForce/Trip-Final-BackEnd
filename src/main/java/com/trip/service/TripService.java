package com.trip.service;

import org.springframework.http.ResponseEntity;

import com.trip.vo.TripRequest.SearchFilter;
import com.trip.vo.TripRequest.TripPlan;

public interface TripService {
	
	ResponseEntity<?> searchAttraction(SearchFilter searchFilter);

	ResponseEntity<?> addTripPlan(TripPlan tripPlan, String userEmail);

	ResponseEntity<?> getTripPlan(String userEmail);

	ResponseEntity<?> selectTripPlan(String planId, String userEmail);

	ResponseEntity<?> unselectTripPlan(String planId, String name);

	ResponseEntity<?> getTripDetail(String planId);
	
}