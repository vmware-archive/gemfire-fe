package io.pivotal.bds.gemfire.geojson.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;

import io.pivotal.bds.gemfire.geojson.data.Boundary;

@Configuration
public class BoundaryConfig {

    private static final double minLat = -90.0;
    private static final double maxLat = 90.0;
    private static final double minLon = -180.0;
    private static final double maxLon = 180.0;
    private static final GeometryFactory factory = new GeometryFactory();

    private static final Logger LOG = LoggerFactory.getLogger(BoundaryConfig.class);

    @Bean
    public Boundary rootBoundary() {
        LOG.info("rootBoundary");
        // create boundary that covers entire world
        Coordinate[] newCoords = new Coordinate[5];

        newCoords[0] = new Coordinate(minLon, minLat);
        newCoords[1] = new Coordinate(minLon, maxLat);
        newCoords[2] = new Coordinate(maxLon, maxLat);
        newCoords[3] = new Coordinate(maxLon, minLat);
        newCoords[4] = new Coordinate(minLon, minLat);

        Polygon poly = factory.createPolygon(newCoords);
        Boundary bound = new Boundary(poly);

        // do initial split
        bound.split();

        return bound;
    }
}
