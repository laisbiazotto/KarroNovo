import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Veiculo {
    private String codigo;
    private String cor;
    private String marca;
    private String modelo;
    private String valor;

    public List<Veiculo> veiculos;

    public Veiculo(String codigo, String cor, String marca, String modelo, String valor){
        this.codigo = codigo;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
    }
    public void getVeiculo() {
        // Imprime o tipo de veículo
        System.out.println("Tipo de Veículo: " + this.getClass().getSimpleName());

        // Imprime os atributos padrões em linhas separadas
        System.out.println("Placa/numero de série: " + this.getCodigo());
        System.out.println("Cor: " +  this.getCor());
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Valor: " + this.getValor());

        // Verifica se o veículo é do tipo Automotor
        if (this instanceof Automotor) {
            Automotor automotor = (Automotor) this; // Faz o cast para Automotor
            System.out.println("Tipo de combustível: " + automotor.getCombustivel());
        }

        // Se for um carro, imprime a quantidade de portas
        if (this instanceof Carro) {
            Carro carro = (Carro) this; // Faz o cast para Carro
            System.out.println("Quantidade de portas: " + carro.getQtdePortas());
        }

        // Se for uma moto, imprime se possui partida elétrica e quantas cilindradas o motor possui
        if (this instanceof Moto) {
            Moto moto = (Moto) this; // Faz o cast para Moto
            System.out.println("Possui partida elétrica: " + (moto.isptdEletrica() ? "Sim" : "Não"));
            System.out.println("Cilindradas do motor: " + moto.getqtdCilindradas());
        }

        // Se for um caminhão, imprime a carga máxima e o número de eixos
        if (this instanceof Caminhao) {
            Caminhao caminhao = (Caminhao) this; // Faz o cast para Caminhao
            System.out.println("Carga máxima: " + caminhao.getCargaMax() + "KG");
            System.out.println("Número de eixos: " + caminhao.getNumEixos());
        }

        // Se for uma bicicleta, imprime o tipo de freio
        if (this instanceof Bicicleta) {
            Bicicleta bicicleta = (Bicicleta) this; // Faz o cast para Bicicleta
            System.out.println("Tipo de freio: " + bicicleta.getTipoFreio());
        }

        // Pula uma linha para separar os detalhes de diferentes veículos
        System.out.println();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
