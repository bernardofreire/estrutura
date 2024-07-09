


// Classroom    Árvore Binária verificando Profundidade e Algoritmo de Busca em Largura

    // Inserir

    // ajusta a profundidade do nó atual apenas se a profundidade do filho recém-inserido for igual à profundidade do nó atual.


    // ======== Metodos dentro do NÓ ======

public boolean inserir(No<T> novoNo) {
			int resultado = novoNo.getElemento().compareTo(this.getElemento());
			if(resultado == 0)
				return false;
			if(resultado > 0) {
				if(this.getDireita() == null) {
					this.setDireita(novoNo);
					if(this.getProfundidade() == 0)
						this.setProfundidade(1);
					return true;
				}
				if(!this.getDireita().inserir(novoNo)) 
					return false; 
				int profundidadeDireita = this.getDireita().getProfundidade();
				if(profundidadeDireita == this.getProfundidade()) 
					this.setProfundidade(profundidadeDireita + 1);
				return true;			
			} 
			else {
				if(this.getEsquerda() == null) {
					this.setEsquerda(novoNo);
					if(this.getProfundidade() == 0)
						this.setProfundidade(1);
					return true;
				}
				if(!this.getEsquerda().inserir(novoNo))
					return false; 
				int profundidadeEsquerda = this.getEsquerda().getProfundidade();
				if(profundidadeEsquerda == this.getProfundidade()) 
					this.setProfundidade(profundidadeEsquerda + 1);
				return true;			
			}
		}

// Imprimir ordem DECRESCENTE tendo uma visão da árvore deitada no sentido anti-horário

public void imprimir(int nivel) {
			// Imprimindo o conteúdo à direita
			if(this.direita != null)
				this.direita.imprimir(nivel + 1);
			// Imprimindo o conteúdo do nó
			for(int i = 1; i < nivel; i++)
				System.out.print('\t');
			System.out.println(this.elemento);
			// Imprimindo o conteúdo à esquerda
			if(this.esquerda != null)
				this.esquerda.imprimir(nivel + 1);			
		}

// Imprimir no Sentido Horário de Forma Crescente

public void imprimirHorario(int nivel) {
    // Imprimindo o conteúdo à esquerda
    if (this.esquerda != null) {
        this.esquerda.imprimirHorario(nivel + 1);
    }
    
    // Imprimindo o conteúdo do nó
    for (int i = 1; i < nivel; i++) {
        System.out.print('\t');
    }
    System.out.println(this.elemento);
    
    // Imprimindo o conteúdo à direita
    if (this.direita != null) {
        this.direita.imprimirHorario(nivel + 1);
    }
}

// Imprimir no Sentido Horário de Forma Decrescente

public void imprimirHorarioDecrescente(int nivel) {
    // Imprimindo o conteúdo à direita
    if (this.direita != null) {
        this.direita.imprimirHorarioDecrescente(nivel + 1);
    }

    // Imprimindo o conteúdo do nó
    for (int i = 1; i < nivel; i++) {
        System.out.print('\t');
    }
    System.out.println(this.elemento);

    // Imprimindo o conteúdo à esquerda
    if (this.esquerda != null) {
        this.esquerda.imprimirHorarioDecrescente(nivel + 1);
    }
}



// Obter

public T obter(Comparable chaveDeProcura) {
			// Comparo a chaveDeProcura com a chave do elemento do nó atual
			int resultado = chaveDeProcura.compareTo(this.getElemento().getChave());
			// Se as chaves são iguais, retorno o elemento
			if(resultado == 0)
				return this.getElemento();
			if(resultado > 0 && this.getDireita() != null)
				return this.getDireita().obter(chaveDeProcura);
			if(this.getEsquerda() != null)
				return this.getEsquerda().obter(chaveDeProcura);
			return null;
		}


// =========== Metodos dentro da classe arvore =========

// Inserir na arvore

public boolean inserirNaArvore(T novoElemento) {
		// Criando um novo nó
		No<T> novoNo = new No(novoElemento);
		// Verificando se a árvore já tem raiz
		if(this.raiz == null) {
			this.raiz = novoNo;
			this.numElementos++;
			return true;
		}
		// Se a árvore tem uma raiz, vamos descobrir onde vamos 
		// inserir o novo nó. Faremos essa análise a partir do nó raiz.
		boolean inseriu = this.raiz.inserir(novoNo);
		if(inseriu)
			this.numElementos++;
		return inseriu;
	}


// Imprimir por niveis

//  Implementação da busca em Largura

	public void imprimirPorNiveis() {
		// Se a árvore está vazia, nada faço.
		if(this.raiz == null)
			return;
		// Armazena os elementos do nível que estou imprimindo 
		ListaArray<No<T>> nivelAtual  = new ListaArray<No<T>>();
		// Incluo a raiz no nível atual 
		nivelAtual.inserir(this.raiz);
		// Enquanto o nível atual tem elementos...
		while(nivelAtual.getNumElementos() > 0) {
			// Lista para guardar os filhos do nivel atual
			ListaArray<No<T>> filhosDoNivelInferior = new ListaArray<No<T>>();
			// Para cada nó presente no nível atual
			for(int i = 0; i < nivelAtual.getNumElementos(); i++) {
				// recupero o nó
				No<T> atual = nivelAtual.obter(i);
				// imprimo a chave do nó 
				System.out.print(atual.getElemento().getChave() + " ");
				// Se o nó atual tem filho à esquerda, acrescento-o na lista de filhos
				if(atual.getEsquerda() != null)
					filhosDoNivelInferior.inserir(atual.getEsquerda());
				// Se o nó atual tem filho à direita, acrescento-o na lista de filhos
				if(atual.getDireita() != null)
					filhosDoNivelInferior.inserir(atual.getDireita());
			}
			// finalizo a impressão da linha
			System.out.println();
			// indico que o nívelAtual passa a ser a dos seus filhos
			nivelAtual = filhosDoNivelInferior;
		}
	}


// Prova AV2


    // Inserir CLASSE NÓ

    // ajusta a profundidade do nó atual se a profundidade do novo nó for maior ou igual à profundidade do nó atual.

public boolean inserir(No<T> novo) {
        // Comparação entre o novo elemento e o elemento atual
        int resultado = novo.getElemento().compareTo(this.getElemento());
            
        // Se os elementos são iguais, não insere
        if (resultado == 0) {
            return false;
        }
            
        // Se o elemento do novo nó é menor, insere na esquerda
        if (resultado < 0) {
            if (this.getEsquerda() == null) {
                this.setEsquerda(novo);
                // Ajuste da profundidade do nó inserido
                novo.setProfundidade(this.getProfundidade() + 1);
                return true;
            } else {
                boolean inseriu = this.getEsquerda().inserir(novo);
                // Ajusta a profundidade se necessário
                if (inseriu && novo.getProfundidade() >= this.getProfundidade()) {
                       this.setProfundidade(novo.getProfundidade() + 1);
                }
                return inseriu;
            }
        }
            
        // Se o elemento é maior, não inserimos (segundo o requisito da questão)
        return false;
    }


    // INSERIR CLASSE ARVORE

    public boolean inserirNaArvore(T elemento) {
        No<T> novo = new No<>(elemento);
        if (this.raiz == null) {
            this.raiz = novo;
            this.numElementos++;
            return true;
        }
        boolean inseriu = this.raiz.inserir(novo);
        if (inseriu) {
            this.numElementos++;
        }
        return inseriu;
    }