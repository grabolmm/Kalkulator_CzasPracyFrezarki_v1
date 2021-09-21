package code.kalkulator_czaspracyfrezarki_v1;

public class Glowica40Sdkt implements Narzedzie {
    private final String nazwa = "Glowica fi 40 SDKT";
    public final int d =40;
    public final int z =6;
    public int vc;
    public double fz;
    public double ap;

    @Override
    public int d() {
        return d;
    }

    @Override
    public int z() {
        return z;
    }

    @Override
    public int vc() {
        return vc;
    }

    @Override
    public double fz() {
        return fz;
    }

    @Override
    public double ap() {
        return ap;
    }

    @Override
    public String wyswietlNazwe() {
        return nazwa;
    }

    @Override
    public void parametryDlaStali() {
        vc = 1000;
        fz = 0.15;
        ap = 2;
    }

    @Override
    public void parametryDlaAluminium() {
        vc = 2000;
        fz = 0.25;
        ap = 3.5;
    }

    @Override
    public void parametryDlaZeliwa() {
        vc = 800;
        fz = 0.05;
        ap = 1.5;
    }

}
