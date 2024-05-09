import java.util.Scanner;

public class Carro extends Automotor{
    private int qtdePortas;

    public Carro(String codigo, String cor, String marca, String modelo, String valor, int qtdePortas, String combustivel) {
        super(codigo, cor, marca, modelo, valor, combustivel); // Chamada ao construtor da classe Automotor
        this.qtdePortas = qtdePortas;
    }

    public int getQtdePortas() {
        return qtdePortas;
    }

    public void setQtdePortas(int qtdePortas) {
        this.qtdePortas = qtdePortas;
    }
}
