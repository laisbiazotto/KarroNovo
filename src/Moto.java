public class Moto extends Automotor {
 private boolean ptdEletrica;
 private int qtdCilindradas;

    public Moto(String codigo, String cor, String marca, String modelo, String valor, String combustivel, boolean ptdEletrica, int qtdCilindradas) {
        super(codigo, cor, marca, modelo, valor, combustivel);
        this.ptdEletrica = ptdEletrica;
        this.qtdCilindradas = qtdCilindradas;
    }

    public boolean isptdEletrica() {
        return ptdEletrica;
    }

    public void setptdEletrica(boolean ptdEletrica) {
        this.ptdEletrica = ptdEletrica;
    }

    public int getqtdCilindradas() {
        return qtdCilindradas;
    }

    public void setqtdCilindradas(int qtdCilindradas) {
        this.qtdCilindradas = qtdCilindradas;
    }
}
