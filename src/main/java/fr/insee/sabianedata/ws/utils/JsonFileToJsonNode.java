package fr.insee.sabianedata.ws.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonFileToJsonNode {

    public static JsonNode getJsonNodeFromFile(File file)  {
        JsonNode result;
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = mapper.readTree(file);
        } catch (IOException e) {
            result = null;
            e.printStackTrace();
        }
        return result;
    }
}
