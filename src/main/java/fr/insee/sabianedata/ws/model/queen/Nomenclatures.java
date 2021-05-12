package fr.insee.sabianedata.ws.model.queen;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "Nomenclatures")
public class Nomenclatures {

    @JacksonXmlProperty(localName = "Nomenclature")
    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<Nomenclature> nomenclatures;

    public Nomenclatures() {
    }

    public ArrayList<Nomenclature> getNomenclatures() {
        return nomenclatures;
    }

    public void setNomenclatures(ArrayList<Nomenclature> nomenclatures) {
        this.nomenclatures = nomenclatures;
    }
}
