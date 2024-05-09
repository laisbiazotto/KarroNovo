import java.util.Scanner;

public class Automotor extends Veiculo {
    private String combustivel;

    public Automotor(String codigo, String cor, String marca, String modelo, String valor, String combustivel) {
        super(codigo, cor, marca, modelo, valor); // Chamada ao construtor da classe Automotor
        this.combustivel = combustivel;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

}
