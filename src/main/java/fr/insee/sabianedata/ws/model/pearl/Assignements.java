package fr.insee.sabianedata.ws.model.pearl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "Assignements")
public class Assignements {

    @JacksonXmlProperty(localName = "Assignement")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Assignement> assignements;

    public Assignements() {
    }

    public List<Assignement> getAssignements() {
        return assignements;
    }

    public void setAssignements(List<Assignement> assignements) {
        this.assignements = assignements;
    }
}
