package shivam.chapter11.pojoglossary;

import java.util.List;

public class GlossDef {
    private String para;
    private List<String> GlossSeeAlso;

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public List<String> getGlossSeeAlso() {
        return GlossSeeAlso;
    }

    public void setGlossSeeAlso(List<String> glossSeeAlso) {
        GlossSeeAlso = glossSeeAlso;
    }
}
