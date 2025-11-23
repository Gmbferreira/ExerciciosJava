# Projeto: Mapeamento de Terreno com Algoritmo Flood Fill

## Descrição do Projeto

Este projeto implementa um **sistema de mapeamento inteligente** para robôs autônomos, utilizando o **Algoritmo Flood Fill (Preenchimento por Inundação)**. O objetivo é identificar e classificar todas as **regiões navegáveis conectadas** (`0`) em um terreno bidimensional, respeitando os **obstáculos** (`1`) e preenchendo cada área com uma **cor única e sequencial** (valores `2`, `3`, `4`, ...).

O sistema não apenas executa o Flood Fill a partir de uma coordenada inicial, mas também **automatiza a busca** por regiões não mapeadas, garantindo que todo o terreno navegável seja classificado e colorido, facilitando o planejamento de rotas para o robô.

---

## Introdução ao Problema (Flood Fill)

O Flood Fill é um algoritmo amplamente utilizado em edição de imagens (a ferramenta "balde de tinta") e, neste contexto, em sistemas de mapeamento.

O terreno é representado por um **grid $N \times M$**, onde:

- **`0`**: Terreno navegável (área livre). É o valor que o algoritmo procura e substitui.
- **`1`**: Obstáculo (barreira). O algoritmo não pode atravessar ou modificar esta célula.
- **`2, 3, 4, ...`**: Regiões já mapeadas (cores). O algoritmo ignora estas células, pois já foram processadas.

O algoritmo funciona por **conectividade ortogonal** (apenas cima, baixo, esquerda e direita). Ele usa uma abordagem de **Busca em Largura (BFS)** para garantir que todas as células `0` adjacentes à célula inicial sejam encontradas e coloridas antes de avançar para a próxima camada de vizinhos.

---

## Estrutura e Funcionamento do Código

O projeto é dividido em três arquivos para modularidade:

### 1. `FloodFill.py` (Lógica Principal)

Este arquivo contém a classe `FloodFiller` com os métodos cruciais:

- **`flood_fill(start_r, start_c, new_color)`**: Executa a **Busca em Largura (BFS)** a partir de `(start_r, start_c)`. A função usa uma fila (`queue`) e, a cada passo, verifica os 4 vizinhos ortogonais. Se um vizinho for um `0` válido, ele é colorido e adicionado à fila.
- **`map_all_regions(initial_start_coords)`**: Este é o método que automatiza o mapeamento:
  1.  Tenta executar o `flood_fill` nas `initial_start_coords` com a cor **2**.
  2.  Inicia uma **varredura completa** (`for` loops aninhados) sobre o grid.
  3.  Se encontrar qualquer célula com valor **`0`** (uma região não mapeada), inicia um novo `flood_fill` a partir daquela célula, usando a próxima cor sequencial (**3, 4, 5, ...**), garantindo que todas as regiões desconectadas sejam coloridas.

### 2. `user_input.py` (Interação com o Usuário)

Contém a função `get_user_grid()` que lida com a entrada de dados do usuário (dimensões, grid e coordenadas iniciais), incluindo validação básica de entrada.

### 3. `main.py` (Execução)

Contém a função `main()` que apresenta o menu principal, permitindo ao usuário escolher entre:

- **Rodar Testes Padrões** (exemplos fixos).
- **Inserir uma Matriz Nova** (usando `user_input.get_user_grid()`).

---

## Como Configurar e Executar o Projeto

### 1. Pré-requisitos

- **Python 3.x**

### 2. Estrutura de Arquivos

Certifique-se de que os três arquivos estejam no mesmo diretório:

. ├── FloodFill.py ├── user_input.py └── main.py

### 3. Execução

Abra o terminal na pasta do projeto e execute o arquivo principal:

python main.py

Siga as instruções do menu para rodar os exemplos fixos ou inserir sua própria matriz.

Exemplos de Funcionamento
O algoritmo garante que todas as áreas navegáveis serão mapeadas com uma cor única.

Exemplo 1: Regiões Isoladas
Entrada:
Grid inicial (6x6)Coordenadas Iniciais: (0,0)
0 0 1 1 0 0
0 1 1 1 1 0
1 1 1 1 1 0
0 0 1 0 1 1
0 1 1 0 1 1
0 0 0 1 1 0

**Saída:**

O algoritmo executa 4 preenchimentos sequenciais. A ordem das cores é determinada pela varredura linha-coluna.

| Grid preenchido | Explicação |

2 2 1 1 3 3
2 1 1 1 1 3
1 1 1 1 1 3
4 4 1 5 1 1
4 1 1 5 1 1
4 4 4 1 1 6

**Região 2:** Preenchida a partir do início $(0, 0)$.
**Região 3:** Encontrada em $(0, 4)$ e preenchida.
**Região 4:** Encontrada em $(3, 0)$ e preenchida.
**Região 5:** Encontrada em $(3, 3)$ e preenchida.
**Região 6:** Encontrada em $(5, 5)$ e preenchida. |

### Exemplo 2: Início Deslocado

**Entrada:**

| Grid inicial (4x5) | Coordenadas Iniciais: $(0, 2)$ |
0 1 0 0 1
0 1 0 0 1
0 1 1 1 1
0 0 1 0 0

**Saída:**

O preenchimento inicial começa com **Cor 2** em $(0, 2)$.

| Grid preenchido | Explicação |

3 1 2 2 1
3 1 2 2 1
3 1 1 1 1
3 3 1 4 4

**Região 2:** Preenchida a partir do ponto inicial $(0, 2)$.
**Região 3:** Encontrada automaticamente em $(0, 0)$ (próxima célula `0`) e preenchida.
**Região 4:** Encontrada automaticamente em $(3, 3)$ e preenchida. |
