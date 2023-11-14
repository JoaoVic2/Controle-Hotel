public class Hospedagem {
    private Hospede hospede;
    private Quarto quarto;
    private int dias;
    private boolean checkin;
    private boolean checkout;

    

    public Hospedagem(Hospede hospede, Quarto quarto, int dias) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dias = dias;
        this.checkin = false;
        this.checkout = false;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public boolean isCheckin() {
        return checkin;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void realizarCheckin() {
        this.checkin = true;
    }

    public void realizarCheckout() {
        this.checkout = true;
    }

    
}
