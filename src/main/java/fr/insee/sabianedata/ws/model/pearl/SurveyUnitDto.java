package fr.insee.sabianedata.ws.model.pearl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "SurveyUnit")
public class SurveyUnitDto {

    @JacksonXmlProperty(localName="Id")
    private String id;
    @JacksonXmlElementWrapper(localName="Persons")
    private ArrayList<Person> persons;
    @JacksonXmlProperty(localName="Address")
    private AdressDto address;
    @JacksonXmlProperty(localName="OrganizationUnitId")
    private String organizationUnitId;
    @JacksonXmlProperty(localName="GeographicalLocationId")
    private String geographicalLocationId;
    @JacksonXmlProperty(localName="Priority")
    private boolean priority;
    @JacksonXmlProperty(localName="Campaign")
    private String campaign;
    @JacksonXmlProperty(localName="SampleIdentifiers")
    private SampleIdentifiersDto sampleIdentifiers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public AdressDto getAddress() {
        return address;
    }

    public void setAddress(AdressDto address) {
        this.address = address;
    }

    public String getGeographicalLocationId() {
        return geographicalLocationId;
    }

    public void setGeographicalLocationId(String geographicalLocationId) {
        this.geographicalLocationId = geographicalLocationId;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public SampleIdentifiersDto getSampleIdentifiers() {
        return sampleIdentifiers;
    }

    public void setSampleIdentifiers(SampleIdentifiersDto sampleIdentifiers) {
        this.sampleIdentifiers = sampleIdentifiers;
    }

    public String getOrganizationUnitId() {
        return organizationUnitId;
    }

    public void setOrganizationUnitId(String organizationUnitId) {
        this.organizationUnitId = organizationUnitId;
    }

    public SurveyUnitDto() {
    }

    public String toString(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
