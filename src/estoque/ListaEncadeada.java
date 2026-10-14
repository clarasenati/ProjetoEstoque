package estoque;

public class ListaEncadeada {

    public class No {
        public Produto produto;
        public No proximo;

        public No(Produto produto) {
            this.produto = produto;
            this.proximo = null;
        }
    }

    private No inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    // 1. Inserir no Início
    public void inserirInicio(Produto produto) {
        No novo = new No(produto);
        novo.proximo = inicio;
        inicio = novo;
        tamanho++;
        System.out.println(">> Produto inserido no início com sucesso!");
    }

    // 2. Inserir no Fim
    public void inserirFim(Produto produto) {
        No novo = new No(produto);
        if (estaVazia()) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
        System.out.println(">> Produto inserido no fim com sucesso!");
    }

    // 3. Inserir em Posição Específica
    public void inserirPosicao(int posicao, Produto produto) {
        if (posicao < 0 || posicao > tamanho) {
            System.out.println(">> Erro: Posição inválida!");
            return;
        }
        if (posicao == 0) {
            inserirInicio(produto);
        } else if (posicao == tamanho) {
            inserirFim(produto);
        } else {
            No novo = new No(produto);
            No atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            atual.proximo = novo;
            tamanho++;
            System.out.println(">> Produto inserido na posição " + posicao + " com sucesso!");
        }
    }

    // 4. Remover no Início
    public void removerInicio() {
        if (estaVazia()) {
            System.out.println(">> Erro: O estoque está vazio!");
            return;
        }
        inicio = inicio.proximo;
        tamanho--;
        System.out.println(">> Produto removido do início!");
    }

    // 5. Remover no Fim
    public void removerFim() {
        if (estaVazia()) {
            System.out.println(">> Erro: O estoque está vazio!");
            return;
        }
        if (inicio.proximo == null) {
            inicio = null;
        } else {
            No atual = inicio;
            while (atual.proximo.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = null;
        }
        tamanho--;
        System.out.println(">> Produto removido do fim!");
    }

    // 6. Remover em Posição Específica
    public void removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println(">> Erro: Posição inválida!");
            return;
        }
        if (posicao == 0) {
            removerInicio();
        } else {
            No atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
            tamanho--;
            System.out.println(">> Produto removido da posição " + posicao + "!");
        }
    }

    // 7. Pesquisar Produto por Código
    public Produto pesquisar(int codigo) {
        No atual = inicio;
        while (atual != null) {
            if (atual.produto.getCodigo() == codigo) {
                return atual.produto;
            }
            atual = atual.proximo;
        }
        return null;
    }

    // 8. Verificar Posição de um Produto
    public int verificarPosicao(int codigo) {
        No atual = inicio;
        int index = 0;
        while (atual != null) {
            if (atual.produto.getCodigo() == codigo) {
                return index;
            }
            atual = atual.proximo;
            index++;
        }
        return -1;
    }

    // 9. Listar Geral
    public void listarGeral() {
        if (estaVazia()) {
            System.out.println(">> O estoque está vazio.");
            return;
        }
        No atual = inicio;
        int i = 0;
        System.out.println("\n========== LISTA DE PRODUTOS NO ESTOQUE ==========");
        while (atual != null) {
            System.out.println("Posição [" + i + "] -> " + atual.produto);
            atual = atual.proximo;
            i++;
        }
        System.out.println("==================================================\n");
    }
}