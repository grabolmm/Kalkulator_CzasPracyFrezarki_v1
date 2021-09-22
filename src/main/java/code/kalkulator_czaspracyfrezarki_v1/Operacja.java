package code.kalkulator_czaspracyfrezarki_v1;

public class Operacja {
    int lp;
    String nazwa;

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpisOperacji() {
        return opisOperacji;
    }

    public void setOpisOperacji(String opisOperacji) {
        this.opisOperacji = opisOperacji;
    }

    String opisOperacji;

    public Operacja(int lp, String nazwa, String opisOperacji) {
        this.lp = lp;
        this.nazwa = nazwa;
        this.opisOperacji = opisOperacji;
    }
}
