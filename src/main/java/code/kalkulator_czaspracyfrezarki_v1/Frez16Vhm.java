package code.kalkulator_czaspracyfrezarki_v1;

public class Frez16Vhm implements Narzedzie{
    private final String nazwa = "Frez 16 VHM";
    public final int d =16;
    public final int z =4;
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
        vc = 100;
        fz = 0.15;
        ap = 2;
    }

    @Override
    public void parametryDlaAluminium() {
        vc = 200;
        fz = 0.25;
        ap = 3.5;
    }

    @Override
    public void parametryDlaZeliwa() {
        vc = 80;
        fz = 0.05;
        ap = 1.5;
    }

}
