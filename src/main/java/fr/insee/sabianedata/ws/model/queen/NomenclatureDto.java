package fr.insee.sabianedata.ws.model.queen;

import com.fasterxml.jackson.databind.JsonNode;
import fr.insee.sabianedata.ws.utils.JsonFileToJsonNode;

import java.io.File;

public class NomenclatureDto extends Nomenclature {

    public static final String FOLDER = "nomenclatures";

    private JsonNode value;

    public NomenclatureDto(Nomenclature nomenclature, String folder){
        super(nomenclature.getId(),nomenclature.getLabel());
        File nomenclatureFile = new File(folder+"/"+FOLDER+"/"+nomenclature.getFileName());
        this.value = JsonFileToJsonNode.getJsonNodeFromFile(nomenclatureFile);
    }

    public JsonNode getValue() {
        return value;
    }

    public void setValue(JsonNode value) {
        this.value = value;
    }
}
