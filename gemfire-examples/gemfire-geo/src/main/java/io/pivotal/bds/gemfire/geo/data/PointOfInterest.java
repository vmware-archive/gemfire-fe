package io.pivotal.bds.gemfire.geo.data;

import com.vividsolutions.jts.geom.Point;

public class PointOfInterest {

    private PointOfInterestKey key;
    private Point location;
    private String name;
    private String description;

    public PointOfInterest() {
    }

    public PointOfInterest(PointOfInterestKey key, Point location, String name, String description) {
        this.key = key;
        this.location = location;
        this.name = name;
        this.description = description;
    }

    public PointOfInterestKey getKey() {
        return key;
    }

    public void setKey(PointOfInterestKey key) {
        this.key = key;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PointOfInterest [key=" + key + ", location=" + location + ", name=" + name + ", description=" + description + "]";
    }

}
