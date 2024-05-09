import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Concessionaria {
    public static List<Veiculo> veiculos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void mostrarMenuPrincipal() {
        System.out.println("O que você deseja fazer?");
        System.out.println("1 – Cadastrar novo veículo");
        System.out.println("2 – Editar veículo");
        System.out.println("3 – Ver informações de um veículo específico");
        System.out.println("4 – Excluir um veículo");
        System.out.println("5 – Ver todos os veículos");
        System.out.println("6 - Sair");

        int decisao = sc.nextInt();


        switch (decisao){
            case 1:
                menuCadastroTipoVeiculo();
                break;
            case 2:
                editarVeiculo();
                break;
            case 3:
                listarVeiculoEspecifico();
                break;
            case 4:
                excluirVeiculo();
                break;
            case 5:
                listarTodosVeiculos();
                break;
            case 6:
                System.out.println("Saindo do programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        mostrarMenuPrincipal();
    }

    public static void menuCadastroTipoVeiculo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual tipo de veículo será cadastrado?");
        System.out.println("1 – Carro");
        System.out.println("2 – Moto");
        System.out.println("3 - Caminhão");
        System.out.println("4 - Bicicleta");
        System.out.println("5 - Voltar ao Menu Inicial");
        int decisao = sc.nextInt();

        switch (decisao){
            case 1:
                cadastrarCarro();
                break;
            case 2:
                cadastrarMoto();
                break;
            case 3:
                cadastrarCaminhao();
                break;
            case 4:
                cadastrarBicicleta();
                break;
            case 5:
                return;
            default:
                System.out.println("Opção Inválida");
                menuCadastroTipoVeiculo();
        }
    }

    public static String menuCombustivel() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Tipo de combustível:");
            System.out.println("G - Veículos a gasolina");
            System.out.println("A - Veículos a álcool");
            System.out.println("F - Veículos flex");
            System.out.println("E - Veículos elétricos");
            System.out.println("D - Veículos a diesel");

            String tipoCombustivel = sc.nextLine();

            switch (tipoCombustivel) {
                case "G":
                    return "Gasolina";
                case "A":
                    return "Álcool";
                case "F":
                    return "Flex";
                case "E":
                    return "Elétrico";
                case "D":
                    return "Diesel";
                default:
                    System.out.println("Opção inválida! Por favor, digite novamente.");
            }
        }
    }

    // Método auxiliar para ler atributos comuns a todos os veículos
    private static Veiculo lerAtributosComuns(String tipoVeiculo) {
        String codigo;

        if (tipoVeiculo.equals("Bicicleta")) {
             codigo = lerString("Digite o número de série da bicicleta:" );

        } else {
             codigo = lerString("Digite a placa do Veículo: ");
        }

        String cor = lerString("Digite a cor: ");
        String marca = lerString("Digite a marca: ");
        String modelo = lerString("Digite o modelo do veículo: ");
        String valor = lerString("Digite o valor do veículo: ");
        return new Veiculo(codigo, cor, marca, modelo, valor);
    }

    // Métodos de cadastro refatorados
    public static void cadastrarCarro() {
        Veiculo veiculo = lerAtributosComuns("Carro");
        int qtdePortas = lerInteiro("Digite o número de portas: ");
        String combustivel = menuCombustivel();
        veiculos.add(new Carro(veiculo.getCodigo(), veiculo.getCor(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getValor(), qtdePortas, combustivel));
        System.out.println("Carro Cadastrado com Sucesso!");
    }

    public static void cadastrarMoto() {
        Veiculo veiculo = lerAtributosComuns("Moto");
        boolean ptdEletrica = lerBoolean("A moto tem partida elétrica?(Sim ou Não): ");
        int qtd_cilindradas = lerInteiro("Digite o número de cilindradas: ");
        String combustivel = menuCombustivel();
        veiculos.add(new Moto(veiculo.getCodigo(), veiculo.getCor(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getValor(), combustivel, ptdEletrica, qtd_cilindradas));
        System.out.println("Moto Cadastrada com Sucesso!");
    }

    public static void cadastrarCaminhao() {
        Veiculo veiculo = lerAtributosComuns("Caminhão");
        int carga_max = lerInteiro("Digite a carga máxima do Caminhão(em kg): ");
        int num_eixos = lerInteiro("Digite o número de eixos do Caminhão: ");
        String combustivel = menuCombustivel();
        veiculos.add(new Caminhao(veiculo.getCodigo(), veiculo.getCor(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getValor(), carga_max, num_eixos, combustivel));
        System.out.println("Caminhão Cadastrado com Sucesso!");
    }

    public static void cadastrarBicicleta() {
        Veiculo veiculo = lerAtributosComuns("Bicicleta");
        String freio = menuFreioBicicleta();
        veiculos.add(new Bicicleta(veiculo.getCodigo(), veiculo.getCor(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getValor(), freio));
        System.out.println("Bicicleta Cadastrada com Sucesso!");
    }

    public static String menuFreioBicicleta(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Tipo de Freio da Bike:");
            System.out.println("C – Cantiléver");
            System.out.println("V – V-Brake");
            System.out.println("F – Ferradura");
            System.out.println("M – Disco Mecânico");
            System.out.println("H – Disco Hidráulico");

            String tipoCombustivel = sc.nextLine();

            switch (tipoCombustivel) {
                case "C":
                    return "Cantiléver";
                case "V":
                    return "V-Brake";
                case "F":
                    return "Ferradura";
                case "M":
                    return "Disco Mecânico";
                case "H":
                    return "Disco Hidráulico";
                default:
                    System.out.println("Opção inválida! Por favor, digite novamente.");
            }
        }
    }

    //Case 2
    public static void editarVeiculo(){
        listarTodosVeiculos();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o código do veículo que deseja editar: ");
        String codigo_edicao = sc.nextLine();

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getCodigo().equals(codigo_edicao)) {
                System.out.println("Digite a nova cor do veículo: ");
                String novaCor = sc.nextLine();
                veiculo.setCor(novaCor);

                System.out.println("Digite a nova marca do veículo: ");
                String novaMarca = sc.nextLine();
                veiculo.setMarca(novaMarca);

                System.out.println("Digite o novo modelo do veículo: ");
                String novoModelo = sc.nextLine();
                veiculo.setModelo(novoModelo);

                System.out.println("Digite o novo valor do veículo: ");
                String novoValor = sc.nextLine();
                veiculo.setValor(novoValor);

                // Verifica se o veículo é do tipo Carro
                if (veiculo instanceof Carro) {
                    Carro carro = (Carro) veiculo; // Faz o cast para Carro
                    System.out.println("Digite a nova quantidade de portas: ");
                    int novaQtdePortas = Integer.parseInt(sc.nextLine());
                    carro.setQtdePortas(novaQtdePortas);
                }

                // Verifica se o veículo é do tipo Moto
                if (veiculo instanceof Moto) {
                    Moto moto = (Moto) veiculo; // Faz o cast para Moto
                    System.out.println("A moto tem partida elétrica?(Sim ou Não): ");
                    boolean possuiPartidaEletrica = Boolean.parseBoolean(sc.nextLine());
                    moto.setptdEletrica(possuiPartidaEletrica);

                    System.out.println("Digite o novo valor das cilindradas do motor: ");
                    int novasCilindradas = Integer.parseInt(sc.nextLine());
                    moto.setqtdCilindradas(novasCilindradas);
                }

                // Verifica se o veículo é do tipo Caminhao
                if (veiculo instanceof Caminhao) {
                    Caminhao caminhao = (Caminhao) veiculo; // Faz o cast para Caminhao
                    System.out.println("Digite a nova carga máxima do caminhão: ");
                    int novaCargaMaxima = Integer.parseInt(sc.nextLine());
                    caminhao.setCargaMax(novaCargaMaxima);

                    System.out.println("Digite o novo número de eixos do caminhão: ");
                    int novoNumEixos = Integer.parseInt(sc.nextLine());
                    caminhao.setNumEixos(novoNumEixos);
                }

                // Verifica se o veículo é do tipo Bicicleta
                if (veiculo instanceof Bicicleta) {
                    Bicicleta bicicleta = (Bicicleta) veiculo; // Faz o cast para Bicicleta
                    String novoTipoFreio = menuFreioBicicleta();
                    if (novoTipoFreio != null) {
                        bicicleta.setTipoFreio(novoTipoFreio);
                    } else {
                        System.out.println("Erro ao definir o tipo de freio. Opção inválida.");
                    }
                }

                System.out.println("Veículo editado com sucesso!");
                return;
            }
        }
        System.out.println("Veículo não encontrado.");
    }

    //Case 3
    public static void listarVeiculoEspecifico(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Forneça o código do veículo a ser consultado:");
        String cod_list = sc.nextLine();

        boolean encontrado = false; // Variável para verificar se o veículo foi encontrado
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getCodigo().equals(cod_list)) {
                // Imprimir os atributos comuns a todos os veículos
                System.out.println("Placa/numero de série: " + veiculo.getCodigo());
                System.out.println("Cor: " + veiculo.getCor());
                System.out.println("Marca: " + veiculo.getMarca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Valor: " + veiculo.getValor());

                // Verificar e imprimir os atributos específicos de cada tipo de veículo
                if (veiculo instanceof Carro) {
                    Carro carro = (Carro) veiculo;
                    System.out.println("Quantidade de portas: " + carro.getQtdePortas());
                } else if (veiculo instanceof Moto) {
                    Moto moto = (Moto) veiculo;
                    System.out.println("Partida elétrica: " + (moto.isptdEletrica() ? "Sim" : "Não"));
                    System.out.println("Cilindradas do motor: " + moto.getqtdCilindradas());
                } else if (veiculo instanceof Caminhao) {
                    Caminhao caminhao = (Caminhao) veiculo;
                    System.out.println("Carga máxima: " + caminhao.getCargaMax() + "KG");
                    System.out.println("Número de eixos: " + caminhao.getNumEixos());
                } else if (veiculo instanceof Bicicleta) {
                    Bicicleta bicicleta = (Bicicleta) veiculo;
                    System.out.println("Tipo de freio: " + bicicleta.getTipoFreio());
                }

                encontrado = true;
                break; // Se encontrou o veículo, pode sair do loop
            }
        }

        if (!encontrado) {
            System.out.println("Veículo não encontrado.");
        }
    }
    //Case 4
    public static void excluirVeiculo(){
        listarTodosVeiculos();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha o veículo a ser excluído, fornecendo o seu código: ");
        String cod_exclusao = sc.nextLine();

        Iterator<Veiculo> iterator = veiculos.iterator();//Percorrer a lista de veículos
        boolean encontrado = false; // Variável para verificar se o veículo foi encontrado
        while(iterator.hasNext()) {
            Veiculo veiculo = iterator.next();
            if (veiculo.getCodigo().equals(cod_exclusao)) {
                iterator.remove();
                System.out.println("Veículo excluído com sucesso!");
                encontrado = true;
                break; //Se encontrou o veículo, pode sair do loop
            }
        }

        if (!encontrado) {
            System.out.println("Veículo não encontrado.");
        }
    }

    //Case 5
    public static void listarTodosVeiculos() {
        int contador = 1;
        for (Veiculo veiculo : veiculos) {
            System.out.println("Veículo " + contador + ":");
            veiculo.getVeiculo(); // Chama o método getVeiculo() para imprimir os atributos específicos de cada tipo de veículo
            contador++;
        }
    }

    //métodos de leitura
    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        String valor = sc.next(); // Ler apenas a próxima palavra
        sc.nextLine(); // Consumir a nova linha pendente
        return valor.trim(); // Remover espaços em branco extras
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        int valor;
        while (true) {
            try {
                valor = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número inteiro válido.");
                System.out.print(mensagem);
            }
        }
        return valor;
    }

    private static boolean lerBoolean(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String resposta = sc.nextLine().trim().toLowerCase();

            if (resposta.equals("sim")) {
                return true;
            } else if (resposta.equals("não")) {
                return false;
            } else {
                System.out.println("Por favor, responda com 'Sim' ou 'Não'.");
            }
        }
    }

}

