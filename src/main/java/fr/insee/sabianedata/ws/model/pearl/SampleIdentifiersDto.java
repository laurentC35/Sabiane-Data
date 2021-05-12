package fr.insee.sabianedata.ws.model.pearl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "SampleIdentifiers")
public class SampleIdentifiersDto {

    @JacksonXmlProperty(localName="Bs")
    private String bs;
    @JacksonXmlProperty(localName="Ec")
    private String ec;
    @JacksonXmlProperty(localName="Le")
    private String le;
    @JacksonXmlProperty(localName="Noi")
    private String noi;
    @JacksonXmlProperty(localName="Numfa")
    private String numfa;
    @JacksonXmlProperty(localName="Rges")
    private String rges;
    @JacksonXmlProperty(localName="Ssech")
    private String ssech;
    @JacksonXmlProperty(localName="Nolog")
    private String nolog;
    @JacksonXmlProperty(localName="Nole")
    private String nole;
    @JacksonXmlProperty(localName="Autre")
    private String autre;
    @JacksonXmlProperty(localName="Nograp")
    private String nograp;

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public String getLe() {
        return le;
    }

    public void setLe(String le) {
        this.le = le;
    }

    public String getNoi() {
        return noi;
    }

    public void setNoi(String noi) {
        this.noi = noi;
    }

    public String getNumfa() {
        return numfa;
    }

    public void setNumfa(String numfa) {
        this.numfa = numfa;
    }

    public String getRges() {
        return rges;
    }

    public void setRges(String rges) {
        this.rges = rges;
    }

    public String getSsech() {
        return ssech;
    }

    public void setSsech(String ssech) {
        this.ssech = ssech;
    }

    public String getNolog() {
        return nolog;
    }

    public void setNolog(String nolog) {
        this.nolog = nolog;
    }

    public String getNole() {
        return nole;
    }

    public void setNole(String nole) {
        this.nole = nole;
    }

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public String getNograp() {
        return nograp;
    }

    public void setNograp(String nograp) {
        this.nograp = nograp;
    }
}
