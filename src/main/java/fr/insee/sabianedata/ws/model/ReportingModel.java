package fr.insee.sabianedata.ws.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportingModel {

    private List<String> success;
    private List<String> failures;


    public ReportingModel() {
        this.success = new ArrayList<String>();
        this.failures = new ArrayList<String>();
    }

    public void addSuccess(String successUeId) {
        this.success.add(successUeId);
    }

    public void addFailure(String failureUeId) {
        this.failures.add(failureUeId);
    }

    public List<String> getSuccess() {
        return success;
    }

    public void setSuccess(List<String> success) {
        this.success = success;
    }

    public List<String> getFailures() {
        return failures;
    }

    public void setFailures(List<String> failures) {
        this.failures = failures;
    }
}
