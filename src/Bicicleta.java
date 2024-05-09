public class Bicicleta extends Veiculo {
    private String tipoFreio;

    public Bicicleta(String codigo, String cor, String marca, String modelo, String valor, String tipoFreio) {
        super(codigo, cor, marca, modelo, valor);
        this.tipoFreio = tipoFreio;
    }

    public String getTipoFreio() {
        return tipoFreio;
    }

    public void setTipoFreio(String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }
}
