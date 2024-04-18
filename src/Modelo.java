import java.util.ArrayList;

// Definição da classe Modelo que contém os detalhes do modelo de um veículo e os métodos para manipulação dos dados.
class Modelo {
    private String nome;
    private double precoBase;
    private ArrayList<String> opcionaisDisponiveis;

    public Modelo(String nome, double precoBase, ArrayList<String> opcionaisDisponiveis) {
        this.nome = nome;
        this.precoBase = precoBase;
        this.opcionaisDisponiveis = opcionaisDisponiveis;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public ArrayList<String> getOpcionaisDisponiveis() {
        return opcionaisDisponiveis;
    }

    public double calcularPrecoOpcional(String opcional) {
        // Preços fixos atribuídos a cada opcional disponível
        switch (opcional) {
            case "Trio Elétrico": return 900.00;
            case "Ar Condicionado": return 1200.00;
            case "Direçao Hidráulica": return 1350.00;
            case "Bancos de Couro": return 1850.00;
            case "Multimídia": return 3200.00;
            default: return 0;
        }
    }
}