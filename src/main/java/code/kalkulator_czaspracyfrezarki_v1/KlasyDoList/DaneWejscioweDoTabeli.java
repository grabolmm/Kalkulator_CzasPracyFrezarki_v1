package code.kalkulator_czaspracyfrezarki_v1.KlasyDoList;

import java.util.Date;

public class DaneWejscioweDoTabeli {
    String nazwa;
    String numerRysunku;
    String material;
    Date dataDzisiejsza;

    public DaneWejscioweDoTabeli(String nazwa, String numerRysunku, String material, Date dataDzisiejsza) {
        this.nazwa = nazwa;
        this.numerRysunku = numerRysunku;
        this.material = material;
        this.dataDzisiejsza = dataDzisiejsza;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNumerRysunku() {
        return numerRysunku;
    }

    public void setNumerRysunku(String numerRysunku) {
        this.numerRysunku = numerRysunku;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Date getDataDzisiejsza() {
        return dataDzisiejsza;
    }

    public void setDataDzisiejsza(Date dataDzisiejsza) {
        this.dataDzisiejsza = dataDzisiejsza;
    }
}
