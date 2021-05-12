package fr.insee.sabianedata.ws.model.pearl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "Context")
public class Context {

    @JacksonXmlElementWrapper(localName="OrganisationUnits")
    private ArrayList<OrganisationUnitDto> organisationUnits;

    public ArrayList<OrganisationUnitDto> getOrganisationUnits() {
        return organisationUnits;
    }

    public void setOrganisationUnits(ArrayList<OrganisationUnitDto> organisationUnits) {
        this.organisationUnits = organisationUnits;
    }

    public Context() {
    }
}
