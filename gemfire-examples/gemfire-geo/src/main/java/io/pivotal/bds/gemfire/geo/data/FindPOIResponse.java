package io.pivotal.bds.gemfire.geo.data;

import java.util.List;
import java.util.Map;

public class FindPOIResponse {

    private Map<FindPOIRequest, List<PointOfInterestKey>> response;

    public FindPOIResponse() {
    }

    public FindPOIResponse(Map<FindPOIRequest, List<PointOfInterestKey>> response) {
        this.response = response;
    }

    public Map<FindPOIRequest, List<PointOfInterestKey>> getResponse() {
        return response;
    }

    public void setResponse(Map<FindPOIRequest, List<PointOfInterestKey>> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "FindPOIResponse [response=" + response + "]";
    }
}
