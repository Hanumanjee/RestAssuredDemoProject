package shivam.chapter11.pojoglossary;

import java.util.List;

public class glossEntry {
    private String ID;
    private String SortAs;
    private String GlossTerm;
    private String Acronym;
    private String Abbrev;
    private GlossDef GlossDef;
    private String GlossSee;
    private List<String> GlossSeeAlso;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSortAs() {
        return SortAs;
    }

    public void setSortAs(String sortAs) {
        SortAs = sortAs;
    }

    public String getGlossTerm() {
        return GlossTerm;
    }

    public void setGlossTerm(String glossTerm) {
        GlossTerm = glossTerm;
    }

    public String getAcronym() {
        return Acronym;
    }

    public void setAcronym(String acronym) {
        Acronym = acronym;
    }

    public String getAbbrev() {
        return Abbrev;
    }

    public void setAbbrev(String abbrev) {
        Abbrev = abbrev;
    }


    public String getGlossSee() {
        return GlossSee;
    }

    public void setGlossSee(String glossSee) {
        GlossSee = glossSee;
    }

    public shivam.chapter11.pojoglossary.GlossDef getGlossDef() {
        return GlossDef;
    }

    public void setGlossDef(shivam.chapter11.pojoglossary.GlossDef glossDef) {
        GlossDef = glossDef;
    }

    public List<String> getGlossSeeAlso() {
        return GlossSeeAlso;
    }

    public void setGlossSeeAlso(List<String> glossSeeAlso) {
        GlossSeeAlso = glossSeeAlso;
    }
}
