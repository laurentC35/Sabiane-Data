package fr.insee.sabianedata.ws.model.pearl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "Interviewers")
public class InterviewersDto {

    @JacksonXmlProperty(localName = "Interviewer")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<InterviewerDto> interviewers;

    public List<InterviewerDto> getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(List<InterviewerDto> interviewers) {
        this.interviewers = interviewers;
    }

    public InterviewersDto() {
    }
}
