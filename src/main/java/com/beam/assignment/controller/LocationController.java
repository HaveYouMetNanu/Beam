package com.beam.assignment.controller;

import com.beam.assignment.model.Location;
import com.beam.assignment.repository.LocationRepository;
import com.beam.assignment.response.LocationResponse;
import com.beam.assignment.service.LocationService;
import com.vividsolutions.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<String> putLocation(@RequestParam(name = "lat") double lat,
                                      @RequestParam(name = "lon") double lon)
    {
        System.out.println("putCalled: lat= "+lat+" lon= "+lon);
        locationService.saveLocation(lat, lon);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LocationResponse>> getPointsWithinRange(@RequestParam(name = "lat") double lat,
                                                                       @RequestParam(name = "lon") double lon,
                                                                       @RequestParam(name = "radius") double radius) {
      List<LocationResponse> locationResponses = locationService.getLocationsWithInRadius(lat, lon, radius);
      return new ResponseEntity(locationResponses, HttpStatus.OK);
    }
}
