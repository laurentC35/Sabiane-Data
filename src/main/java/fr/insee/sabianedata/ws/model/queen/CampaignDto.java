package fr.insee.sabianedata.ws.model.queen;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "Campaign")
public class CampaignDto {

    @JacksonXmlProperty(localName="Id")
    private String id;

    @JacksonXmlProperty(localName="Label")
    private String label;

    @JacksonXmlProperty(localName = "questionnaireIds")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<String> questionnaireIds;

    @JacksonXmlProperty(localName="Metadata")
    private MetadataDto metadata;

    public CampaignDto() {
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

    public ArrayList<String> getQuestionnaireIds() {
        return questionnaireIds;
    }

    public void setQuestionnaireIds(ArrayList<String> questionnaireIds) {
        this.questionnaireIds = questionnaireIds;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "CampaignDto{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", questionnairesId=" + questionnaireIds +
                ", metadata=" + metadata +
                '}';
    }
}
