package fr.insee.sabianedata.ws.service.xsl;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.insee.sabianedata.ws.Constants;

public class QueenCampaignTransformer {

	private static XslTransformation saxonService = new XslTransformation();

	private static final Logger logger = LoggerFactory.getLogger(QueenCampaignTransformer.class);


	public File transform(File input, File questionnaire, String folderTemp) throws Exception {

		File outputFile = new File(input.getParent(),
				"queenCampaign.xml");

		logger.debug("Output folder : " + outputFile.getAbsolutePath());

		InputStream inputStream = FileUtils.openInputStream(input);
		OutputStream outputStream = FileUtils.openOutputStream(outputFile);
		byte[] questionnaireByte =FileUtils.readFileToByteArray(questionnaire);

		InputStream XSL = Constants.getInputStreamFromPath(Constants.QUEEN_CAMPAIGN_FODS_TO_XML);
		try {
			saxonService.operationsFods2XML(inputStream, XSL, outputStream, questionnaireByte);
		}catch(Exception e) {
			e.printStackTrace();
			String errorMessage = "An error was occured during the operations fods2xml transformation. "+e.getMessage();
			logger.error(errorMessage);
			throw new Exception(errorMessage);
		}

		inputStream.close();
		outputStream.close();
		XSL.close();
		logger.info("End of geolocations transformation");

		return outputFile;
	}

	public File extractCampaign(File input) throws Exception {
		return extract(input, Constants.CAMPAIGN);
	}

	public File extractQuestionnaireModels(File input) throws Exception {
		return extract(input, Constants.QUESTIONNAIRE_MODELS);
	}
	public File extractSurveyUnits(File input) throws Exception {
		return extract(input, Constants.SURVEY_UNITS);
	}

	public File extractNomenclatures(File input) throws Exception {
		return extract(input, Constants.NOMENCLATURES);
	}

	public File extract(File input, String type) throws Exception {
		File outputFile = new File(input.getParent(),
				type+".xml");
		logger.debug("Output folder : " + outputFile.getAbsolutePath());

		InputStream inputStream = FileUtils.openInputStream(input);
		OutputStream outputStream = FileUtils.openOutputStream(outputFile);

		InputStream XSL = null;
		switch (type) {
			case Constants.CAMPAIGN:
				XSL = Constants.getInputStreamFromPath(Constants.QUEEN_EXTRACT_CAMPAIGN);
				break;
			case Constants.QUESTIONNAIRE_MODELS:
				XSL = Constants.getInputStreamFromPath(Constants.QUEEN_EXTRACT_QUESTIONNAIRE);
				break;
			case Constants.SURVEY_UNITS:
				XSL = Constants.getInputStreamFromPath(Constants.QUEEN_EXTRACT_SURVEYUNITS);
				break;
			case Constants.NOMENCLATURES:
				XSL = Constants.getInputStreamFromPath(Constants.QUEEN_EXTRACT_NOMENCLATURES);
				break;
		}
		;
		try {
			saxonService.transformFods2XML(inputStream, outputStream, XSL);
		}catch(Exception e) {
			e.printStackTrace();
			String errorMessage = "An error was occured during the operations fods2xml transformation. "+e.getMessage();
			logger.error(errorMessage);
			throw new Exception(errorMessage);
		}
		inputStream.close();
		outputStream.close();
		XSL.close();
		logger.info("End of extract queen "+type);

		return outputFile;
	}
}
