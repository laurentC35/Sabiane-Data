package fr.insee.sabianedata.ws.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insee.sabianedata.ws.config.PearlProperties;
import fr.insee.sabianedata.ws.config.Plateform;
import fr.insee.sabianedata.ws.model.pearl.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Service
public class PearlApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PearlApiService.class);

    @Autowired
    PearlProperties pearlProperties;

    public ResponseEntity<?> postCampaignToApi(HttpServletRequest request, CampaignDto campaignDto, Plateform plateform) throws JsonProcessingException {
        LOGGER.info("Creating Campaign"+campaignDto.getCampaign());
        final String apiUri = pearlProperties.getHostFromEnum(plateform) +"/api/campaign";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = createSimpleHeadersAuth(request);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.exchange(apiUri, HttpMethod.POST, new HttpEntity<>(campaignDto, httpHeaders), String.class);
    }
    public ResponseEntity<?> postGeoLocationsToApi(HttpServletRequest request, List<GeoLocationDto> geoLocations, Plateform plateform) throws JsonProcessingException {
        LOGGER.info("Create GeoLocations ");
        final String apiUri = pearlProperties.getHostFromEnum(plateform) +"/api/geographical-locations";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = createSimpleHeadersAuth(request);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.exchange(apiUri, HttpMethod.POST, new HttpEntity<>(geoLocations, httpHeaders), String.class);
    }

    public ResponseEntity<?> postUesToApi(HttpServletRequest request, List<SurveyUnitDto> surveyUnits, Plateform plateform) throws JsonProcessingException {
        LOGGER.info("Create SurveyUnits ");
        final String apiUri = pearlProperties.getHostFromEnum(plateform) +"/api/survey-units";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = createSimpleHeadersAuth(request);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.exchange(apiUri, HttpMethod.POST, new HttpEntity<>(surveyUnits, httpHeaders), String.class);
    }
    public ResponseEntity<?> postInterviewersToApi(HttpServletRequest request, List<InterviewerDto> interviewers, Plateform plateform) throws JsonProcessingException {
        LOGGER.info("Create interviewers");
        final String apiUri = pearlProperties.getHostFromEnum(plateform) +"/api/interviewers";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = createSimpleHeadersAuth(request);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return restTemplate.exchange(apiUri, HttpMethod.POST, new HttpEntity<>(interviewers, httpHeaders), String.class);
    }

    public ResponseEntity<?> postAssignementsToApi(HttpServletRequest request, List<Assignement> assignements, Plateform plateform) {
        LOGGER.info("Create assignements");
        final String apiUri = pearlProperties.getHostFromEnum(plateform) +"/api/survey-units/interviewers";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = createSimpleHeadersAuth(request);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.exchange(apiUri, HttpMethod.POST, new HttpEntity<>(assignements, httpHeaders), String.class);
    }

    public ResponseEntity<?> postContextToApi(HttpServletRequest request, List<OrganisationUnitDto> organisationUnits, Plateform plateform) {
        LOGGER.info("Create Context (organisationUnits)");
        final String apiUri = pearlProperties.getHostFromEnum(plateform) +"/api/organization-units";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = createSimpleHeadersAuth(request);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.exchange(apiUri, HttpMethod.POST, new HttpEntity<>(organisationUnits, httpHeaders), String.class);
    }

    public HttpHeaders createSimpleHeadersAuth(HttpServletRequest request){
        String authTokenHeader = request.getHeader("Authorization");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        if (!StringUtils.isBlank(authTokenHeader)) httpHeaders.set("Authorization",authTokenHeader);
        return httpHeaders;
    }
}
