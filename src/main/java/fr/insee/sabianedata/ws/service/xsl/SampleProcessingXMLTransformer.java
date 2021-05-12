package fr.insee.sabianedata.ws.service.xsl;

import fr.insee.sabianedata.ws.Constants;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class SampleProcessingXMLTransformer {

	private static XslTransformation saxonService = new XslTransformation();

	private static final Logger logger = LoggerFactory.getLogger(SampleProcessingXMLTransformer.class);
	
	public File transform(File input, int repetitions) throws Exception {

		File outputFile = new File(input.getParent(),
				"sampleProcessing.xml");

		logger.debug("Output folder : " + outputFile.getAbsolutePath());

		InputStream inputStream = FileUtils.openInputStream(input);
		OutputStream outputStream = FileUtils.openOutputStream(outputFile);

		InputStream XSL = Constants.getInputStreamFromPath(Constants.SAMPLE_PROCESSING_GENERATOR);
		try {
			saxonService.generateSampleProcessing(inputStream, XSL, outputStream, repetitions);
		}catch(Exception e) {
			e.printStackTrace();
			String errorMessage = "An error was occured during the sampleProcessing generation. "+e.getMessage();
			logger.error(errorMessage);
			throw new Exception(errorMessage);
		}

		inputStream.close();
		outputStream.close();
		XSL.close();
		logger.info("End of sampleProcessing generation");

		return outputFile;
	}
}
