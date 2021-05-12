package fr.insee.sabianedata.ws.service.xsl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Main Saxon Service used to perform XSLT transformations
 * 
 * @author gerose
 *
 */
public class XslTransformation {

	final static Logger logger = LoggerFactory.getLogger(XslTransformation.class);

	public void xslTransform(Transformer transformer, InputStream xmlInput, OutputStream xmlOutput) throws Exception {
		logger.debug("Starting xsl transformation -Input : " + xmlInput + " -Output : " + xmlOutput);
		transformer.transform(new StreamSource(xmlInput), new StreamResult(xmlOutput));
	}

	
	public void transformFods2XML(InputStream inputFile, OutputStream outputFile, InputStream xslSheet) throws Exception {
		logger.info("Converting fods to a xml ...");
		TransformerFactory tFactory = new net.sf.saxon.TransformerFactoryImpl();
		tFactory.setURIResolver(new ClasspathURIResolver());
		Transformer transformer = tFactory.newTransformer(new StreamSource(xslSheet));
		xslTransform(transformer, inputFile, outputFile);
	}

	
	public void operationsFods2XML(InputStream input, InputStream xslSheet, OutputStream output, byte[] questionnaire)
			throws Exception {
		InputStream questionnaireIS = null;
		TransformerFactory tFactory = new net.sf.saxon.TransformerFactoryImpl();
		tFactory.setURIResolver(new ClasspathURIResolver());

		Transformer transformer = tFactory.newTransformer(new StreamSource(xslSheet));
		if (questionnaire != null) {
			questionnaireIS = new ByteArrayInputStream(questionnaire);
			Source source = new StreamSource(questionnaireIS);
			transformer.setParameter(XslParameters.QUESTIONNAIRE, source);
		}
		xslTransform(transformer, input, output);
		if (questionnaire != null) {
			questionnaireIS.close();
		}
	}

	public void generateSampleProcessing(InputStream input, InputStream xslSheet, OutputStream output, int repetitions) throws Exception {
		TransformerFactory tFactory = new net.sf.saxon.TransformerFactoryImpl();
		tFactory.setURIResolver(new ClasspathURIResolver());
		Transformer transformer = tFactory.newTransformer(new StreamSource(xslSheet));
		transformer.setParameter(XslParameters.REPETITIONS, repetitions);
		xslTransform(transformer, input, output);

	}
	
}
