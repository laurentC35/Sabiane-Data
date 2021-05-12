package fr.insee.sabianedata.ws.model.pearl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "SurveyUnits")
public class SurveyUnits {

    @JacksonXmlProperty(localName = "SurveyUnit")
    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<SurveyUnitDto> surveyUnits;

    public ArrayList<SurveyUnitDto> getSurveyUnits() {
        return surveyUnits;
    }

    public void setSurveyUnits(ArrayList<SurveyUnitDto> surveyUnits) {
        this.surveyUnits = surveyUnits;
    }

    public SurveyUnits() {
    }
}
