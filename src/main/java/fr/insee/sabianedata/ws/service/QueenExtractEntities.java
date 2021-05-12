package fr.insee.sabianedata.ws.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import fr.insee.sabianedata.ws.model.queen.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueenExtractEntities {

    @Autowired
    QueenTransformService queenTransformService;

    public CampaignDto getQueenCampaignFromXMLFile(File file) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        CampaignDto campaign = xmlMapper.readValue(file,CampaignDto.class);
        return campaign;
    }

    public CampaignDto getQueenCampaignFromFods(File fods) throws Exception {
        File file = queenTransformService.getQueenCampaign(fods);
        return getQueenCampaignFromXMLFile(file);
    }

    public List<SurveyUnitDto> getQueenSurveyUnitsFromFods(File fods, String folder) throws Exception {
        ArrayList<SurveyUnitDto> lists = new ArrayList<>();
        File file = queenTransformService.getQueenSurveyUnits(fods);
        XmlMapper xmlMapper = new XmlMapper();
        SurveyUnits surveyUnits = xmlMapper.readValue(file, SurveyUnits.class);
        List<SurveyUnitDto> surveyUnitsList = surveyUnits.getSurveyUnits().stream().map(s -> new SurveyUnitDto(s,folder)).collect(Collectors.toList());

        return surveyUnitsList!=null ? surveyUnitsList : lists;
    }

    public List<QuestionnaireModel> getQueenQuestionnaireModelsFromFods(File fods, String folder) throws Exception {
        ArrayList<QuestionnaireModel> lists = new ArrayList<>();
        File file = queenTransformService.getQueenQuestionnaires(fods);
        XmlMapper xmlMapper = new XmlMapper();
        QuestionnaireModels questionnaireModels = xmlMapper.readValue(file, QuestionnaireModels.class);
        return questionnaireModels!=null && questionnaireModels.getQuestionnaireModels()!=null ? questionnaireModels.getQuestionnaireModels() : lists;
    }

    public List<QuestionnaireModelDto> getQueenQuestionnaireModelsDtoFromFods(File fods, String folder) throws Exception {
        List<QuestionnaireModel> questionnaireModels = getQueenQuestionnaireModelsFromFods(fods,folder);
        List<QuestionnaireModelDto> questionnaireModelDtoList = questionnaireModels.stream().map(q -> new QuestionnaireModelDto(q,folder)).collect(Collectors.toList());
        return questionnaireModelDtoList;
    }

    public List<Nomenclature> getQueenNomenclatureFromFods(File fods, String folder) throws Exception {
        ArrayList<Nomenclature> lists = new ArrayList<>();
        File file = queenTransformService.getQueenNomenclatures(fods);
        XmlMapper xmlMapper = new XmlMapper();
        Nomenclatures nomenclatures = xmlMapper.readValue(file, Nomenclatures.class);
        return nomenclatures!=null && nomenclatures.getNomenclatures()!=null ? nomenclatures.getNomenclatures() : lists;
    }

    public List<NomenclatureDto> getQueenNomenclaturesDtoFromFods(File fods, String folder) throws Exception {
        List<Nomenclature> nomenclatures = getQueenNomenclatureFromFods(fods,folder);
        List<NomenclatureDto> nomenclatureDtos = nomenclatures.stream().map(n -> new NomenclatureDto(n,folder)).collect(Collectors.toList());
        return nomenclatureDtos;
    }



}
