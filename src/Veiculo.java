import java.util.ArrayList;

// Definição da classe Veiculo com atributos privados e métodos para manipulação dos dados.
class Veiculo {
    private String nome;
    private ArrayList<Modelo> modelos;

    public Veiculo(String nome) {
        this.nome = nome;
        this.modelos = new ArrayList<>();
    }

    public void addModelo(Modelo modelo) {
        modelos.add(modelo);
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Modelo> getModelos() {
        return modelos;
    }
}