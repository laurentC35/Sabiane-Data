package fr.insee.sabianedata.ws.model.queen;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "Metadata")
public class MetadataDto {

    @JacksonXmlProperty(localName="InseeContext")
    private String inseeContext;

    @JacksonXmlElementWrapper(localName="Variables")
    private ArrayList<Variable> variables;

    public String getInseeContext() {
        return inseeContext;
    }

    public void setInseeContext(String inseeContext) {
        this.inseeContext = inseeContext;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public MetadataDto() {
    }
}
