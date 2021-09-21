package code.kalkulator_czaspracyfrezarki_v1;

public class Parametry {
    private double n;
    private double f;
    private String string;



    public double obliczObroty(int vc, int d){
        return n = ((1000 * vc) / (Math.PI * d));

    }

    public double obliczPosuw(int z, double fz, double n){
        return f = (z * fz * n);
    }

    public String wyswietlParametry(int vc, int d, double n,
                                    double f, double ap, double fz, int z) {

        return string = "Predkość skrawania: " + vc + " m/min" + "\n" +
                "Srednica narzedzia:   " + d + " mm" + "\n" +
                "Ilość zębów:          " + z + "" + "\n" +
                "Posuw na ząb:         " + fz + " mm/obr" + "\n" +
                "Obroty wrzeciona:     " + (int) n + " obr/min" + "\n" +
                "Posuw narzedzia:      " + (int) f + " m/min" + "\n" +
                "Głębokość skrawania:  " + ap + " mm";
    }
}
