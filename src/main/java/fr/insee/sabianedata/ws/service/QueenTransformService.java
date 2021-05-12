package fr.insee.sabianedata.ws.service;

import fr.insee.sabianedata.ws.model.queen.SurveyUnit;
import fr.insee.sabianedata.ws.model.queen.SurveyUnitDto;
import fr.insee.sabianedata.ws.service.xsl.GeoLocationsTransformer;
import fr.insee.sabianedata.ws.service.xsl.QueenCampaignTransformer;
import fr.insee.sabianedata.ws.service.xsl.SampleProcessingXMLTransformer;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class QueenTransformService {

	private GeoLocationsTransformer geoLocationsTransformer = new GeoLocationsTransformer();
	private QueenCampaignTransformer queenCampaignTransformer = new QueenCampaignTransformer();
	private SampleProcessingXMLTransformer sampleProcessingXMLTransformer = new SampleProcessingXMLTransformer();

	public File geoLocationsFods2Xml(File input, String fileName) throws Exception {
		return geoLocationsTransformer.transform(input,fileName);
	}

	public File getQueenCampaign(File fodsInput) throws Exception {
		return queenCampaignTransformer.extractCampaign(fodsInput);
	}

	public File getQueenQuestionnaires(File fodsInput) throws Exception {
		return queenCampaignTransformer.extractQuestionnaireModels(fodsInput);
	}

	public File getQueenSurveyUnits(File fodsInput) throws Exception {
		return queenCampaignTransformer.extractSurveyUnits(fodsInput);
	}

	public File getQueenNomenclatures(File fodsInput) throws Exception {
		return queenCampaignTransformer.extractNomenclatures(fodsInput);
	}

	public File sampleProcessing(File input, int repetitions) throws Exception {
		return sampleProcessingXMLTransformer.transform(input,repetitions);
	}

}
