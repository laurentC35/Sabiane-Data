package fr.insee.sabianedata.ws.model.queen;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "SurveyUnits")
public class SurveyUnits {

    @JacksonXmlProperty(localName = "SurveyUnit")
    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<SurveyUnit> surveyUnits;

    public ArrayList<SurveyUnit> getSurveyUnits() {
        return surveyUnits;
    }

    public void setSurveyUnits(ArrayList<SurveyUnit> surveyUnits) {
        this.surveyUnits = surveyUnits;
    }

    public SurveyUnits() {
    }
}
