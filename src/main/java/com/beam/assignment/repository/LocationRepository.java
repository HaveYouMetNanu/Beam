package com.beam.assignment.repository;

import com.beam.assignment.model.Location;
import com.vividsolutions.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("from Location where ST_DistanceSphere(geom, ST_MakePoint(?1, ?2)) <= ?3")
    List<Location> getAllPointsWithInRadius(Double lat, Double lon, Double radius);
}
