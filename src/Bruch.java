public class Bruch {
    private int zaehler;
    private int nenner;

    public Bruch(int zaehler, int nenner) {
        if (nenner == 0) {
            throw new IllegalArgumentException("Nenner darf nicht 0 sein.");
        }
        this.zaehler = zaehler;
        this.nenner = nenner;
        kuerzen();
    }

    public int getZaehler() {
        return zaehler;
    }

    public int getNenner() {
        return nenner;
    }

    public Bruch addiere(Bruch anderer) {
        int neuerZaehler = this.zaehler * anderer.nenner + anderer.zaehler * this.nenner;
        int neuerNenner = this.nenner * anderer.nenner;
        return new Bruch(neuerZaehler, neuerNenner);
    }

    public Bruch subtrahiere(Bruch anderer) {
        int neuerZaehler = this.zaehler * anderer.nenner - anderer.zaehler * this.nenner;
        int neuerNenner = this.nenner * anderer.nenner;
        return new Bruch(neuerZaehler, neuerNenner);
    }

    public Bruch multipliziere(Bruch anderer) {
        int neuerZaehler = this.zaehler * anderer.zaehler;
        int neuerNenner = this.nenner * anderer.nenner;
        return new Bruch(neuerZaehler, neuerNenner);
    }

    public Bruch dividiere(Bruch anderer) {
        if (anderer.zaehler == 0) {
            throw new IllegalArgumentException("Division durch 0 ist nicht erlaubt.");
        }
        int neuerZaehler = this.zaehler * anderer.nenner;
        int neuerNenner = this.nenner * anderer.zaehler;
        return new Bruch(neuerZaehler, neuerNenner);
    }

    private void kuerzen() {
        int ggt = ggt(zaehler, nenner);
        zaehler /= ggt;
        nenner /= ggt;
    }

    private int ggt(int a, int b) {
        if (b == 0) {
            return a;
        }
        return ggt(b, a % b);
    }

    @Override
    public String toString() {
        return zaehler + "/" + nenner;
    }
}