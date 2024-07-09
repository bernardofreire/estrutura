// Fila encadeada

public void push(T elemento) {
	No<T> novo = new No(elemento);
	if(this.numElementos == 0)
		this.primeiro = novo;
	else
		this.ultimo.setAnterior(novo);
	this.ultimo = novo;
	this.numElementos++;
}
	
public T pop() {
	if(this.numElementos == FILA_VAZIA)
		return null;
	T retorno = this.primeiro.getElemento();
	this.primeiro = this.primeiro.getAnterior();
	this.numElementos--;
	if(this.primeiro == null)
		this.ultimo = null;
	return retorno;		
}
	
public T getElemento(int pos) {
	if(pos < 0 || pos >= this.numElementos)
		return null;
	No<T> aux = this.primeiro;
	for(int i = 0; i < pos; i++)
		aux = aux.getAnterior();
	return aux.getElemento();
}

// Fila array


public void push(T novo) {
	int tamanhoArray = this.arrayInterno.length;
	if(this.numElementos == tamanhoArray) {			
		Object[] novoArray = new Object[tamanhoArray + FATOR_CRESCIMENTO];

		for(int i = 0; i < tamanhoArray; i++)
			novoArray[i] = this.arrayInterno[i];
		this.arrayInterno = novoArray;
	}

	this.arrayInterno[this.numElementos] = novo;
	this.numElementos++;
}
	
public T pop() {
	if(this.numElementos == FILA_VAZIA)
		return null;

	Object valorRetorno = this.arrayInterno[0];
	for(int i = 0; i < this.numElementos - 1; i++) {
		this.arrayInterno[i] = this.arrayInterno[i+1];
	}		

	this.arrayInterno[this.numElementos - 1] = null;
	this.numElementos--;

	return (T)valorRetorno;		
}