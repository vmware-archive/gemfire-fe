package io.pivotal.bds.gemfire.fraud.server.conf;

import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeoConfig {
    
    private static final Logger LOG = LoggerFactory.getLogger(GeoConfig.class);
    
    @Bean
    public CoordinateReferenceSystem latLonCRS() {
        LOG.info("latLonCRS");
        return DefaultGeographicCRS.WGS84;
    }
    
    @Bean
    public CoordinateReferenceSystem cartCRS() throws Exception {
        LOG.info("cartCRS");
        return CRS.decode("EPSG:26917");
    }
    
    @Bean
    public MathTransform latLonToCart(CoordinateReferenceSystem latLonCRS,CoordinateReferenceSystem cartCRS) throws Exception {
        LOG.info("latLonToCart");
        return CRS.findMathTransform(latLonCRS, cartCRS);
    }

}
