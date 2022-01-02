package com.beam.assignment.service;

import com.beam.assignment.model.Location;
import com.beam.assignment.repository.LocationRepository;
import com.beam.assignment.response.LocationResponse;
import com.vividsolutions.jts.awt.PointShapeFactory;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public void saveLocation(Double lat, Double lon) {
        System.out.println("lat long : " + lat + " lon" + lon + "locationRepo : " + locationRepository);
        locationRepository.save(new Location(new Point(new Coordinate(lat, lon), new PrecisionModel(), 4326)));
    }

    public List<LocationResponse> getLocationsWithInRadius(Double lat, Double lon, Double radius) {
        List<Location> points = locationRepository.getAllPointsWithInRadius(lat,lon,radius*1000);
        return points.stream().map(p -> new LocationResponse(p.getGeom().getX(), p.getGeom().getY())).collect(Collectors.toList());
    }
}
