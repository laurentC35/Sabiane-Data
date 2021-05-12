package fr.insee.sabianedata.ws.model.pearl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "PhoneNumber")
public class PhoneNumber {

    @JacksonXmlProperty(localName="Source")
    private String source;
    @JacksonXmlProperty(localName="Favorite")
    private boolean favorite;
    @JacksonXmlProperty(localName="Number")
    private String number;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneNumber() {
    }
}
