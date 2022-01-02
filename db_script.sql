create database scooters;

\c scooters;

CREATE TABLE locations ( id SERIAL PRIMARY KEY, geom GEOMETRY(Point, 4326) );