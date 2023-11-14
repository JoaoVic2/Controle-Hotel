public class Quarto {
    private String tipoQuarto;
    private String tamanhoQuarto;
    private double valorQuarto;
    private int numeroQuarto;
    private static int id = 1;
    
    public Quarto(String tipoQuarto, String tamanhoQuarto, double valorQuarto, int numeroQuarto) {
        this.tipoQuarto = tipoQuarto;
        this.tamanhoQuarto = tamanhoQuarto;
        this.valorQuarto = valorQuarto;
        this.numeroQuarto = id++;
    }
    

    public String getTipoQuarto() {
        return tipoQuarto;
    }
    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }
    public String getTamanhoQuarto() {
        return tamanhoQuarto;
    }
    public void setTamanhoQuarto(String tamanhoQuarto) {
        this.tamanhoQuarto = tamanhoQuarto;
    }
    public double getValorQuarto() {
        return valorQuarto;
    }
    public void setValorQuarto(double valorQuarto) {
        this.valorQuarto = valorQuarto;
    }
    public int getNumeroQuarto() {
        return numeroQuarto;
    }
    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }
   
}
