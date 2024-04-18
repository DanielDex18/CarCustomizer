import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

// Classe principal que executa o programa
public class Main {
    private static DecimalFormat df = new DecimalFormat("#,##0.00");

    public static void main(String[] args) {
        List<Veiculo> veiculos = criarVeiculos();

        Scanner scanner = new Scanner(System.in);
        Veiculo veiculoEscolhido = escolherVeiculo(veiculos, scanner);
        Modelo modeloEscolhido = escolherModelo(veiculoEscolhido, scanner);
        double precoFinal = calcularPrecoFinal(modeloEscolhido, scanner);

        System.out.println("Preço final do veículo: R$ " + df.format(precoFinal));
        scanner.close();
    }

    // Método que cria e retorna uma lista de veículos com modelos pré-definidos
    private static List<Veiculo> criarVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        // Veículos adicionados com diferentes modelos e preços
        veiculos.add(criarVeiculo("Fusca", new String[]{"Basic", "Sedan", "Sport", "Executive"}, new double[]{20000, 27000, 28500, 32000}));
        veiculos.add(criarVeiculo("Brasília", new String[]{"Basic", "Sedan", "Sport", "Executive"}, new double[]{20700, 27900, 30500, 35000}));
        veiculos.add(criarVeiculo("Opala", new String[]{"Basic", "Sedan", "Sport", "Executive"}, new double[]{25000, 29200, 31500, 37000}));
        return veiculos;
    }

    // Método que cria e retorna um veículo com modelos e preços
    private static Veiculo criarVeiculo(String nome, String[] modelosNomes, double[] modelosPrecos) {
        Veiculo veiculo = new Veiculo(nome);
        for (int i = 0; i < modelosNomes.length; i++) {
            ArrayList<String> opcionais = new ArrayList<>();
            // Adiciona os opcionais correspondentes a cada modelo
            switch (modelosNomes[i]) {
                case "Basic":
                    opcionais.addAll(List.of("Trio Elétrico", "Ar Condicionado", "Direçao Hidráulica", "Bancos de Couro", "Multimídia"));
                    break;
                case "Sedan":
                    opcionais.addAll(List.of("Direção Hidráulica", "Bancos de Couro", "Multimídia"));
                    break;
                case "Sport":
                case "Executive":
                    opcionais.add("Multimídia");
                    break;
            }
            veiculo.addModelo(new Modelo(modelosNomes[i], modelosPrecos[i], opcionais));
        }
        return veiculo;
    }

    // Método para escolher um veículo da lista
    private static Veiculo escolherVeiculo(List<Veiculo> veiculos, Scanner scanner) {
        System.out.println("Escolha um veículo:");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println((i + 1) + ". " + veiculos.get(i).getNome());
        }
        int escolhaVeiculo = scanner.nextInt();
        if (escolhaVeiculo < 1 || escolhaVeiculo > veiculos.size()) {
            System.out.println("Escolha inválida!");
            System.exit(1);
        }
        return veiculos.get(escolhaVeiculo - 1);
    }

    // Método para escolher um modelo do veículo selecionado
    private static Modelo escolherModelo(Veiculo veiculo, Scanner scanner) {
        System.out.println("Escolha o modelo:");
        ArrayList<Modelo> modelos = veiculo.getModelos();
        for (int i = 0; i < modelos.size(); i++) {
            Modelo modelo = modelos.get(i);
            System.out.println((i + 1) + ". " + modelo.getNome() + " - Preço: R$ " + df.format(modelo.getPrecoBase()));
        }
        int escolhaModelo = scanner.nextInt();
        if (escolhaModelo < 1 || escolhaModelo > modelos.size()) {
            System.out.println("Escolha inválida!");
            System.exit(1);
        }
        return modelos.get(escolhaModelo - 1);
    }

    // Método para calcular o preço final do modelo escolhido com opcionais
    private static double calcularPrecoFinal(Modelo modelo, Scanner scanner) {
        double precoFinal = modelo.getPrecoBase();
        ArrayList<String> opcionaisDisponiveis = modelo.getOpcionaisDisponiveis();
        
        // Se o modelo não for Sport ou Executive, permite a escolha de opcionais
        if (!modelo.getNome().equals("Sport") && !modelo.getNome().equals("Executive")) {
            System.out.println("Escolha até 2 opcionais:");
            for (int i = 0; i < opcionaisDisponiveis.size(); i++) {
                String opcional = opcionaisDisponiveis.get(i);
                double precoOpcional = modelo.calcularPrecoOpcional(opcional);
                System.out.println((i + 1) + ". " + opcional + " - Preço: R$ " + df.format(precoOpcional));
            }
            for (int i = 0; i < 2; i++) {
                System.out.println("Insira o número do opcional desejado ou 0 para nenhum:");
                int escolhaOpcional = scanner.nextInt();
                if (escolhaOpcional > 0 && escolhaOpcional <= opcionaisDisponiveis.size()) {
                    precoFinal += modelo.calcularPrecoOpcional(opcionaisDisponiveis.get(escolhaOpcional - 1));
                }
            }
        } else {
            // Se o modelo for Sport ou Executive, só permite a escolha de Multimídia
            double precoMultimidia = modelo.calcularPrecoOpcional("Multimídia");
            System.out.println("Deseja adicionar a central multimídia por R$ " + df.format(precoMultimidia) + "? (S/N)");
            String escolhaMultimidia = scanner.next();
            if (escolhaMultimidia.equalsIgnoreCase("S")) {
                precoFinal += modelo.calcularPrecoOpcional("Multimídia");
            }
        }
        
        return precoFinal;
    }
}