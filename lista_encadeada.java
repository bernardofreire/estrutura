//  Algoritmos de Ordenação em Listas e Implementação da Interface Comparable





// Inserir um elemento

public boolean inserir(T elemento) {
		No<T> novo = new No(elemento);
		if (this.numElementos == 0)
			this.primeiro = novo;
		else {
			No<T> aux = this.primeiro;
			while (aux.getProximo() != null)
				aux = aux.getProximo();
			aux.setProximo(novo);
		}
		this.numElementos++;
		return true;
}


// Inserir elemento na posição

public boolean inserir(T elemento, int posicao) {
		if (posicao < 0 || posicao > this.numElementos)
			return false;
		No<T> novo = new No(elemento);
		if (posicao == 0) {
			novo.setProximo(this.primeiro);
			this.primeiro = novo;
		} else {
			No<T> aux = this.primeiro;
			for (int i = 0; i < posicao - 1; i++)
				aux = aux.getProximo();
			novo.setProximo(aux.getProximo());
			aux.setProximo(novo);
		}
		this.numElementos++;
		return true;
}

// Obter elemento por posicao

public T obter(int posicao) {
		if (posicao < 0 || posicao >= this.numElementos)
			return null;
		No<T> aux = this.primeiro;
		for (int i = 0; i < posicao; i++)
			aux = aux.getProximo();
		return aux.getElemento();
}

// Posicao de um elemento

public int posicaoDe(T elemento) {
		No<T> aux = this.primeiro;
		for (int i = 0; i < this.numElementos; i++) {
			if (aux.getElemento() == elemento)
				return i;
			aux = aux.getProximo();
		}
		return NAO_ESTA_PRESENTE;
}


// Remover por posicao

public boolean remover(int posicao) {
		if (posicao < 0 || posicao >= this.numElementos)
			return false;

		if (posicao == 0) {
			this.primeiro = this.primeiro.getProximo();
		} else {
			No<T> aux = this.primeiro;
			for (int i = 0; i < posicao - 1; i++)
				aux = aux.getProximo();
			No<T> noParaRemocao = aux.getProximo();
			aux.setProximo(noParaRemocao.getProximo());
		}

		this.numElementos--;
		return true;
}

// Remover por elemento

public boolean remover(T elemento) {

	int posicao = this.posicaoDe(elemento);

	if (posicao == NAO_ESTA_PRESENTE)
		return false;

	return this.remover(posicao);
}


// Ordernar

public void ordenar() {
	No<T> paraOrdenar = this.primeiro;

	while (paraOrdenar.getProximo() != null) {
		No<T> menor = paraOrdenar;
		No<T> atual = paraOrdenar.getProximo();

		while(atual != null) {
			if(atual.getElemento().compareTo(menor.getElemento()) < 0)
				menor = atual;
			atual = atual.getProximo();
		}

		T aux = paraOrdenar.getElemento();

		paraOrdenar.setElemento(menor.getElemento());
		menor.setElemento(aux);
		paraOrdenar = paraOrdenar.getProximo();
	}
}


// PROVA AV2


// ordernar


public void ordenar() {
    No<T> paraOrdenar = this.primeiro;
    while (paraOrdenar != null && paraOrdenar.getProximo() != null) {
        No<T> menor = paraOrdenar;
        No<T> atual = paraOrdenar.getProximo();
        while(atual != null) {
            if(atual.getElemento().compareTo(menor.getElemento()) < 0) {
                menor = atual;
            }
            atual = atual.getProximo();
        }
        T aux = paraOrdenar.getElemento();
        paraOrdenar.setElemento(menor.getElemento());
        menor.setElemento(aux);
        paraOrdenar = paraOrdenar.getProximo();
    }
}


// Obter pela chave

public T obterPelaChave(Comparable chave) {
    No<T> atual = this.primeiro;
    while (atual != null) {
        if (chave.compareTo(atual.getElemento().getValor()) == 0) {
            return atual.getElemento();
        }
        atual = atual.getProximo();
    }
    return null;
}
