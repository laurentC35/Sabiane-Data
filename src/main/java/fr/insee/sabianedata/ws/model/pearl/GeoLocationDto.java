package fr.insee.sabianedata.ws.model.pearl;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "GeographicalLocation")
public class GeoLocationDto {

    @JacksonXmlProperty(localName="Id")
    private String id;
    @JacksonXmlProperty(localName="Label")
    private String label;

    public GeoLocationDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
