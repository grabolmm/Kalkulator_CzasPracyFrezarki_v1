package code.kalkulator_czaspracyfrezarki_v1.KlasyDoList;

public class OperacjaDoTabeli {
    int operacja;
    String opisOperacji;
    String narzedzie;
    int vc;
    int d;
    double fz;
    double ap;
    int n;
    int f;
    int dlugoscObrysu;
    int glebokoscObrysu;
    int czasObrobki;

    public OperacjaDoTabeli(int operacja, String opisOperacji, String narzedzie,
                            int vc, int d, double fz, double ap, int n, int f,
                            int dlugoscObrysu, int glebokoscObrysu, int czasObrobki) {
        this.operacja = operacja;
        this.opisOperacji = opisOperacji;
        this.narzedzie = narzedzie;
        this.vc = vc;
        this.d = d;
        this.fz = fz;
        this.ap = ap;
        this.n = n;
        this.f = f;
        this.dlugoscObrysu = dlugoscObrysu;
        this.glebokoscObrysu = glebokoscObrysu;
        this.czasObrobki = czasObrobki;
    }


    public int getOperacja() {
        return operacja;
    }

    public void setOperacja(int operacja) {
        this.operacja = operacja;
    }

    public String getOpisOperacji() {
        return opisOperacji;
    }

    public void setOpisOperacji(String opisOperacji) {
        this.opisOperacji = opisOperacji;
    }

    public String getNarzedzie() {
        return narzedzie;
    }

    public void setNarzedzie(String narzedzie) {
        this.narzedzie = narzedzie;
    }

    public int getVc() {
        return vc;
    }

    public void setVc(int vc) {
        this.vc = vc;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public double getFz() {
        return fz;
    }

    public void setFz(double fz) {
        this.fz = fz;
    }

    public double getAp() {
        return ap;
    }

    public void setAp(double ap) {
        this.ap = ap;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getDlugoscObrysu() {
        return dlugoscObrysu;
    }

    public void setDlugoscObrysu(int dlugoscObrysu) {
        this.dlugoscObrysu = dlugoscObrysu;
    }

    public int getGlebokoscObrysu() {
        return glebokoscObrysu;
    }

    public void setGlebokoscObrysu(int glebokoscObrysu) {
        this.glebokoscObrysu = glebokoscObrysu;
    }

    public int getCzasObrobki() {
        return czasObrobki;
    }

    public void setCzasObrobki(int czasObrobki) {
        this.czasObrobki = czasObrobki;
    }
}
