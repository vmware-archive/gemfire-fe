package io.pivotal.bds.gemfire.geo.data;

import io.pivotal.bds.gemfire.key.ColocationID;

public class CreatePOIRequest implements ColocationID<Long> {

    private PointOfInterestKey pointOfInterestKey;
    private PointOfInterest pointOfInterest;

    public CreatePOIRequest() {
    }

    public CreatePOIRequest(PointOfInterestKey pointOfInterestKey, PointOfInterest pointOfInterest) {
        this.pointOfInterestKey = pointOfInterestKey;
        this.pointOfInterest = pointOfInterest;
    }

    public PointOfInterestKey getPointOfInterestKey() {
        return pointOfInterestKey;
    }

    public void setPointOfInterestKey(PointOfInterestKey pointOfInterestKey) {
        this.pointOfInterestKey = pointOfInterestKey;
    }

    public PointOfInterest getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(PointOfInterest pointOfInterest) {
        this.pointOfInterest = pointOfInterest;
    }

    @Override
    public Long getColocationId() {
        return pointOfInterestKey.getColocationId();
    }

    @Override
    public String toString() {
        return "CreatePOIRequest [pointOfInterestKey=" + pointOfInterestKey + ", pointOfInterest=" + pointOfInterest + "]";
    }

}
