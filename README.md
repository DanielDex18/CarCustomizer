# Relatório do Projeto: Sistema de Configuração de Veículos em Java

## Introdução
Este relatório detalha a implementação de um sistema em Java para a configuração e compra de veículos. O código foi desenvolvido com foco em práticas de Programação Orientada a Objetos (POO) e é destinado a ser um projeto educativo para explorar conceitos como classes, objetos, encapsulamento e coleções.

## Estrutura do Projeto
O sistema é composto por três classes principais: `Veiculo`, `Modelo` e `Main`, além de fazer uso de classes da biblioteca padrão do Java como `ArrayList`, `List`, `Scanner` e `DecimalFormat`.

### Classe Veículo
**Atributos:**
- `nome`: Nome do veículo.
- `modelos`: Lista de modelos disponíveis para o veículo.

**Construtor:**
Inicializa o nome do veículo e a lista de modelos.

**Métodos:**
- `addModelo(Modelo modelo)`: Adiciona um modelo à lista de modelos.
- `getNome()`: Retorna o nome do veículo.
- `getModelos()`: Retorna a lista de modelos do veículo.

### Classe Modelo
**Atributos:**
- `nome`: Nome do modelo do veículo.
- `precoBase`: Preço base do modelo.
- `opcionaisDisponiveis`: Lista de opcionais disponíveis para o modelo.

**Construtor:**
Inicializa o nome, preço base e opcionais disponíveis do modelo.

**Métodos:**
- `getNome()`: Retorna o nome do modelo.
- `getPrecoBase()`: Retorna o preço base do modelo.
- `getOpcionaisDisponiveis()`: Retorna a lista de opcionais disponíveis.
- `calcularPrecoOpcional(String opcional)`: Retorna o preço de um opcional específico.

### Classe Main
**Métodos Estáticos:**
- `main(String[] args)`: Ponto de entrada do programa. Executa os métodos para configurar e calcular o preço final do veículo.

Métodos auxiliares como `criarVeiculos()`, `criarVeiculo()`, `escolherVeiculo()`, `escolherModelo()` e `calcularPrecoFinal()` que facilitam a seleção e configuração do veículo.

## Funcionalidades
### Seleção de Veículo e Modelo:
O usuário pode escolher entre diferentes veículos e modelos predefinidos.
Cada modelo possui uma lista de opcionais e um preço base que pode ser aumentado com adicionais.

### Configuração de Opcionais:
O usuário pode adicionar até dois opcionais ao modelo escolhido, com cada opcional tendo um preço fixo definido.

### Cálculo do Preço Final:
O preço final do veículo é calculado com base no preço base do modelo e no preço dos opcionais escolhidos.

## Considerações Técnicas
- **Encapsulamento:** Os atributos das classes são privados, garantindo que sejam acessados e modificados apenas através de métodos públicos.
- **Reutilização:** A estrutura do código promove a reutilização, facilitando a expansão ou modificação de funcionalidades.
- **Formato de Moeda:** Uso de `DecimalFormat` para garantir que os preços sejam exibidos em um formato amigável.

## Conclusão
Este projeto demonstra a implementação de um sistema básico de configuração de veículos usando Java. Serve como uma excelente base para aprendizado e aprimoramento das habilidades em POO, oferecendo oportunidades para implementar novas funcionalidades, como persistência de dados, interface gráfica e mais interações do usuário.
