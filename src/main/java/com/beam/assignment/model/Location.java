package com.beam.assignment.model;



import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @Column(name = "geom")
    private Point geom;

    public Location() {}

    public Location(Point geom) {
        this.geom = geom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getGeom() {
        return geom;
    }

    public void setGeom(Point geom) {
        this.geom = geom;
    }
}
