package fr.insee.sabianedata.ws.model.pearl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JacksonXmlRootElement(localName = "Visibility")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Visibility {
    // peut-être changer les date en type "long" au lieu de "String"




    @JacksonXmlProperty(localName = "OrganisationalUnit")
    private String organizationalUnit;
    @JacksonXmlProperty(localName = "CollectionStartDate")
    private String collectionStartDateString;
    @JacksonXmlProperty(localName = "CollectionEndDate")
    private String collectionEndDateString;
    @JacksonXmlProperty(localName = "IdentificationPhaseStartDate")
    private String identificationPhaseStartDateString;
    @JacksonXmlProperty(localName = "InterviewerStartDate")
    private String interviewerStartDateString;
    @JacksonXmlProperty(localName = "ManagementStartDate")
    private String managementStartDateString;
    @JacksonXmlProperty(localName = "EndDate")
    private String endDateString;

    private Long collectionStartDate;
    private Long collectionEndDate;
    private Long identificationPhaseStartDate;
    private Long interviewerStartDate;
    private Long managementStartDate;
    private Long endDate;

    public Long getCollectionStartDate() {
        return collectionStartDate;
    }

    public void setCollectionStartDate(Long collectionStartDate) {
        this.collectionStartDate = collectionStartDate;
    }

    public Long getCollectionEndDate() {
        return collectionEndDate;
    }

    public void setCollectionEndDate(Long collectionEndDate) {
        this.collectionEndDate = collectionEndDate;
    }

    public Long getIdentificationPhaseStartDate() {
        return identificationPhaseStartDate;
    }

    public void setIdentificationPhaseStartDate(Long identificationPhaseStartDate) {
        this.identificationPhaseStartDate = identificationPhaseStartDate;
    }

    public Long getInterviewerStartDate() {
        return interviewerStartDate;
    }

    public void setInterviewerStartDate(Long interviewerStartDate) {
        this.interviewerStartDate = interviewerStartDate;
    }

    public Long getManagementStartDate() {
        return managementStartDate;
    }

    public void setManagementStartDate(Long managementStartDate) {
        this.managementStartDate = managementStartDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    private Long dateStringToDateLong(String date){
        String pattern = "dd/MM/yyyy HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(date));
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        return timestamp.getTime();
    }

    public Visibility(Visibility visibility){
        this.organizationalUnit = visibility.getOrganizationalUnit();
        this.collectionStartDate = dateStringToDateLong(visibility.getCollectionStartDateString());
        this.collectionEndDate = dateStringToDateLong(visibility.getCollectionEndDateString());
        this.identificationPhaseStartDate = dateStringToDateLong(visibility.getIdentificationPhaseStartDateString());
        this.interviewerStartDate = dateStringToDateLong(visibility.getInterviewerStartDateString());
        this.managementStartDate = dateStringToDateLong(visibility.getManagementStartDateString());
        this.endDate = dateStringToDateLong(visibility.getEndDateString());
    }


    public Visibility() {
    }

    public String getOrganizationalUnit() {
        return organizationalUnit;
    }

    public void setOrganizationalUnit(String organizationalUnit) {
        this.organizationalUnit = organizationalUnit;
    }

    public String getCollectionStartDateString() {
        return collectionStartDateString;
    }

    public void setCollectionStartDateString(String collectionStartDateString) {
        this.collectionStartDateString = collectionStartDateString;
    }

    public String getCollectionEndDateString() {
        return collectionEndDateString;
    }

    public void setCollectionEndDateString(String collectionEndDateString) {
        this.collectionEndDateString = collectionEndDateString;
    }

    public String getIdentificationPhaseStartDateString() {
        return identificationPhaseStartDateString;
    }

    public void setIdentificationPhaseStartDateString(String identificationPhaseStartDateString) {
        this.identificationPhaseStartDateString = identificationPhaseStartDateString;
    }

    public String getInterviewerStartDateString() {
        return interviewerStartDateString;
    }

    public void setInterviewerStartDateString(String interviewerStartDateString) {
        this.interviewerStartDateString = interviewerStartDateString;
    }

    public String getManagementStartDateString() {
        return managementStartDateString;
    }

    public void setManagementStartDateString(String managementStartDateString) {
        this.managementStartDateString = managementStartDateString;
    }

    public String getEndDateString() {
        return endDateString;
    }

    public void setEndDateString(String endDateString) {
        this.endDateString = endDateString;
    }
}
