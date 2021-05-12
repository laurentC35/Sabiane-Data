package fr.insee.sabianedata.ws.model.queen;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "QuestionnaireModel")
public class QuestionnaireModel {

    @JacksonXmlProperty(localName="Id")
    private String idQuestionnaireModel;

    @JacksonXmlProperty(localName="Label")
    private String label;

    @JacksonXmlProperty(localName="CampaignId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String campaignId;

    @JacksonXmlElementWrapper(localName="RequiredNomenclatures")
    @JacksonXmlProperty(localName = "Nomenclature")
    private ArrayList<String> requiredNomenclatureIds;

    @JacksonXmlProperty(localName="FileName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fileName;

    public QuestionnaireModel() {
    }

    public String getIdQuestionnaireModel() {
        return idQuestionnaireModel;
    }

    public void setIdQuestionnaireModel(String idQuestionnaireModel) {
        this.idQuestionnaireModel = idQuestionnaireModel;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<String> getRequiredNomenclatureIds() {
        return requiredNomenclatureIds;
    }

    public void setRequiredNomenclatureIds(ArrayList<String> requiredNomenclatureIds) {
        this.requiredNomenclatureIds = requiredNomenclatureIds;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public QuestionnaireModel(String idQuestionnaireModel, String label, ArrayList<String> requiredNomenclatureIds) {
        this.idQuestionnaireModel = idQuestionnaireModel;
        this.label = label;
        this.requiredNomenclatureIds = requiredNomenclatureIds;
    }
}
