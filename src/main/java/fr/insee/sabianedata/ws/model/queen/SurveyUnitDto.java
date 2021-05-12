package fr.insee.sabianedata.ws.model.queen;

import com.fasterxml.jackson.databind.JsonNode;
import fr.insee.sabianedata.ws.utils.JsonFileToJsonNode;

import java.io.File;

public class SurveyUnitDto extends SurveyUnit {

    public static final String FOLDER = "surveyUnits";

    private JsonNode data;
    private JsonNode comment;
    private JsonNode personalization;

    public SurveyUnitDto(SurveyUnit surveyUnit, String folder) {
        super(surveyUnit.getId(), surveyUnit.getQuestionnaireId(), surveyUnit.getStateData());
        String finalFolder = folder + "/" + FOLDER;
        File dataFile = new File(finalFolder + "/" + surveyUnit.getDataFile());
        File commentFile = new File(finalFolder + "/" + surveyUnit.getCommentFile());
        File personalizationFile = new File(finalFolder + "/" + surveyUnit.getPersonalizationFile());
        this.data = JsonFileToJsonNode.getJsonNodeFromFile(dataFile);
        this.comment = JsonFileToJsonNode.getJsonNodeFromFile(commentFile);
        this.personalization = JsonFileToJsonNode.getJsonNodeFromFile(personalizationFile);
    }

    public SurveyUnitDto(SurveyUnit surveyUnit) {
        super(surveyUnit.getId(), surveyUnit.getQuestionnaireId(), surveyUnit.getStateData());
    }

    public JsonNode getData() {
        return data;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public JsonNode getComment() {
        return comment;
    }

    public void setComment(JsonNode comment) {
        this.comment = comment;
    }

    public JsonNode getPersonalization() {
        return personalization;
    }

    public void setPersonalization(JsonNode personalization) {
        this.personalization = personalization;
    }


}
