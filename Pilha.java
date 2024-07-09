// Pilha Encadeada

public void push(T elemento) {
	No<T> novo = new No(elemento, this.topo);
	this.topo = novo;
	this.numElementos++;
}
	
public T pop() {
	if(this.numElementos == PILHA_VAZIA)
		return null;

	T retorno = this.topo.getElemento();
	this.topo = this.topo.getAnterior();
	this.numElementos--;

	return retorno;		
}
	
public T getElemento(int pos) {
	if(pos < 0 || pos >= this.numElementos)
		return null;
	No<T> aux = this.topo;
	for(int i = this.numElementos - 1; i > pos; i--)
		aux = aux.getAnterior();
	return aux.getElemento();
}


// Pilha array


public void push(T novo) {
	this.topo++;

	int tamanhoArray = this.arrayInterno.length;
	if(this.topo == tamanhoArray ) {			
		Object[] novoArray = new Object[tamanhoArray + FATOR_CRESCIMENTO];
		for(int i = 0; i < tamanhoArray; i++)
			novoArray[i] = this.arrayInterno[i];
		this.arrayInterno = novoArray;
	}
	this.arrayInterno[this.topo] = novo;
}
	
public T pop() {
	if(this.topo == PILHA_VAZIA)
		return null;

	Object valorRetorno = this.arrayInterno[this.topo];
	this.arrayInterno[this.topo] = null;
	this.topo--;

	return (T)valorRetorno;		
}