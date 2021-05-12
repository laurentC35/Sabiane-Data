package fr.insee.sabianedata.ws.model.pearl;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "GeographicalLocations")
public class GeoLocations {

    @JacksonXmlProperty(localName = "GeographicalLocation")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<GeoLocationDto> geoLocations;

    public GeoLocations() {
    }

    public List<GeoLocationDto> getGeoLocations() {
        return geoLocations;
    }

    public void setGeoLocations(List<GeoLocationDto> geoLocations) {
        this.geoLocations = geoLocations;
    }
}
