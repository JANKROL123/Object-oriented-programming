class Walec {
    private double wysokosc;
    private double promien;
    public Walec() {}
    public Walec(double wartoscWysokosci, double wartoscPromienia) {
        this.wysokosc = wartoscWysokosci;
        this.promien = wartoscPromienia;
    }
    public void ustawWysokosc(double nowaWysokosc) {
        this.wysokosc = nowaWysokosc;
    }
    public void ustawPromien(double nowyPromien) {
        this.promien = nowyPromien;
    }
    public double zwrocWysokosc() {
        return wysokosc;
    }
    public double zwrocPromien() {
        return this.promien;
    }
    public double obliczPolePodstawy() {
        return Math.PI * Math.pow(promien, 2);
    }
    public double obliczPolePowierzchniBocznej() {
        return 2 * this.promien * this.wysokosc * Math.PI;
    }
    public double obliczPolePowierzchniCalkowitej() {
        return 2 * this.obliczPolePodstawy() + + this.obliczPolePowierzchniBocznej();
    }
    public double obliczObjetosc() {
        return this.obliczPolePodstawy() * this.wysokosc;
    }
}