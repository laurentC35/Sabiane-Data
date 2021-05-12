package fr.insee.sabianedata.ws.service.xsl;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import fr.insee.sabianedata.ws.Constants;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeoLocationsTransformer {

	private static XslTransformation saxonService = new XslTransformation();

	private static final Logger logger = LoggerFactory.getLogger(GeoLocationsTransformer.class);
	
	public File transform(File input, String fileName) throws Exception {

		File outputFile = new File(input.getParent(),
				fileName+".xml");

		logger.debug("Output folder : " + outputFile.getAbsolutePath());

		InputStream inputStream = FileUtils.openInputStream(input);
		OutputStream outputStream = FileUtils.openOutputStream(outputFile);

		InputStream XSL = Constants.getInputStreamFromPath(Constants.GEOGRAHICAL_LOCATIONS_FODS_TO_XML);
		try {
			saxonService.transformFods2XML(inputStream,outputStream, XSL);
		}catch(Exception e) {
			String errorMessage = "An error was occured during the geolocations fods2xml transformation. "+e.getMessage();
			logger.error(errorMessage);
			throw new Exception(errorMessage);
		}

		inputStream.close();
		outputStream.close();
		XSL.close();
		logger.info("End of geolocations transformation");

		return outputFile;
	}
}
