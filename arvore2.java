// Classroom Árvore Binária (Busca em Profundidade e Inserção com Algoritmos Recursivos)



// Metodo dentro da class Nó


// Inserir


public boolean inserir(No<T> novoNo) {
			// vamos comparar o elemento apontado pelo atual com o novoElemento
			int resultado = novoNo.getElemento().compareTo(this.getElemento());
			// Se eles são iguais, não colocamos o novo nó na árvore
			if(resultado == 0)
				return false;
			// Se o elemento do novoNó é MAIOR que o elemento do 'this', vamos 
			// inseri-lo à DIREITA
			if(resultado > 0) {
				// Se o atual não tem ninguém à direita, vamos colocar o novo
				// nó nessa posição e encerramos o algoritmo
				if(this.getDireita() == null) {
					this.setDireita(novoNo);
					novoNo.setNivel(this.nivel + 1);
					return true;
				}
				// Há alguém à direita, então vamos descer para esse nó
				return this.getDireita().inserir(novoNo);
			} 
			// Se o elemento do novoNó é MENOR que o elemento do 'this', vamos 
			// inseri-lo à ESQUERDA
			else {
				// Se o atual não tem ninguém à esquerda, vamos colocar o novo
				// nó nessa posição e encerramos o algoritmo
				if(this.getEsquerda() == null) {
					this.setEsquerda(novoNo);
					novoNo.setNivel(this.nivel + 1);
					return true;
				}
				// Há alguém à esquerda, então vamos descer o atual para esse nó
				return this.getEsquerda().inserir(novoNo);
			}
		}


// Imprimir


public void imprimir() {
			// Imprimindo o conteúdo à esquerda
			if(this.esquerda != null)
				this.esquerda.imprimir();			
			// Imprimindo o conteúdo do nó
			for(int i = 1; i < this.nivel; i++)
				System.out.print('\t');
			System.out.println(this.elemento);
			// Imprimindo o conteúdo à direita
			if(this.direita != null)
				this.direita.imprimir();
		}



// =======Metodo class Arvore =======


// Inserir

public boolean inserir(T novoElemento) {
		// Criando um novo nó
		No<T> novoNo = new No(novoElemento);
		// Verificando se a árvore já tem raiz
		if(this.raiz == null) {
			this.raiz = novoNo;
			this.numElementos++;
			novoNo.setNivel(1);
			return true;
		}
		// Se a árvore tem uma raiz, vamos descobrir onde vamos 
		// inserir o novo nó. Faremos essa análise a partir do nó raiz.
		boolean inseriu = this.raiz.inserir(novoNo);
		if(inseriu)
			this.numElementos++;
		return inseriu;
	}


// Obter


public T obter(Comparable chaveDeProcura) {
		// Vamos começar nossa busca a partir da raiz
		No<T> atual = this.raiz;
		while(atual != null) {
			// Comparo a chaveDeProcura com a chave do elemento do nó atual
			int resultado = chaveDeProcura.compareTo(atual.getElemento().getChave());
			// Se as chaves são iguais, retorno o elemento
			if(resultado == 0)
				return atual.getElemento();
			if(resultado > 0)
				atual = atual.getDireita();
			else
				atual = atual.getEsquerda();
		}
		return null;
	}