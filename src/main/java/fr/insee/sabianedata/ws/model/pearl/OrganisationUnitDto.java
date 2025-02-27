package fr.insee.sabianedata.ws.model.pearl;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;


@JacksonXmlRootElement(localName = "OrganisationUnit")
public class OrganisationUnitDto {

    @JacksonXmlProperty(localName="OrganisationUnit")
    private String organisationUnit;
    @JacksonXmlProperty(localName="OrganisationUnitLabel")
    private String organisationUnitLabel;
    @JacksonXmlProperty(localName="Type")
    private String type;

    @JacksonXmlElementWrapper(localName="Users")
    private ArrayList<UserDto> users;

    @JacksonXmlElementWrapper(localName="OrganisationUnitRefs")
    @JacksonXmlProperty(localName = "OrganisationUnitRef")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<String> organisationUnitRef;

    public String getOrganisationUnit() {
        return organisationUnit;
    }

    public void setOrganisationUnit(String organisationUnit) {
        this.organisationUnit = organisationUnit;
    }

    public String getOrganisationUnitLabel() {
        return organisationUnitLabel;
    }

    public void setOrganisationUnitLabel(String organisationUnitLabel) {
        this.organisationUnitLabel = organisationUnitLabel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<UserDto> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserDto> users) {
        this.users = users;
    }

    public ArrayList<String> getOrganisationUnitRef() {
        return organisationUnitRef;
    }

    public void setOrganisationUnitRef(ArrayList<String> organisationUnitRef) {
        this.organisationUnitRef = organisationUnitRef;
    }

    public OrganisationUnitDto() {
    }
}
