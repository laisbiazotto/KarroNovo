public class Caminhao extends Automotor{
   private int cargaMax;
   private int numEixos;

    public Caminhao(String codigo, String cor, String marca, String modelo, String valor, int cargaMax, int numEixos, String combustivel) {
        super(codigo, cor, marca, modelo, valor, combustivel);
        this.cargaMax = cargaMax;
        this.numEixos = numEixos;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getNumEixos() {
        return numEixos;
    }

    public void setNumEixos(int numEixos) {
        this.numEixos = numEixos;
    }
}
