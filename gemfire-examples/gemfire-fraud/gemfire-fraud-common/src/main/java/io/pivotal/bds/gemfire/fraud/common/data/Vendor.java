package io.pivotal.bds.gemfire.fraud.common.data;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.vividsolutions.jts.geom.Coordinate;

import io.pivotal.bds.gemfire.fraud.common.util.VendorStatusCodec;
import io.pivotal.bds.gemfire.fraud.common.util.VendorTypeCodec;

@Table(name = "vendor", keyspace = "gemfire")
public class Vendor {

    @PartitionKey
    @Column(name = "vendor_id")
    private String vendorId;

    @Column(name = "vendor_type", codec = VendorTypeCodec.class)
    private VendorType vendorType;

    @Column(name = "vendor_status", codec = VendorStatusCodec.class)
    private VendorStatus vendorStatus;

    @Column(name = "vendor_x")
    private double x;

    @Column(name = "vendor_y")
    private double y;

    public Vendor() {
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public VendorType getVendorType() {
        return vendorType;
    }

    public void setVendorType(VendorType vendorType) {
        this.vendorType = vendorType;
    }

    public VendorStatus getVendorStatus() {
        return vendorStatus;
    }

    public void setVendorStatus(VendorStatus vendorStatus) {
        this.vendorStatus = vendorStatus;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Coordinate getLocation() {
        return new Coordinate(x, y);
    }

    public void setLocation(Coordinate location) {
        this.x = location.x;
        this.y = location.y;
    }

    @Override
    public String toString() {
        return "Vendor [vendorId=" + vendorId + ", vendorType=" + vendorType + ", vendorStatus=" + vendorStatus + ", x=" + x
                + ", y=" + y + "]";
    }

}
