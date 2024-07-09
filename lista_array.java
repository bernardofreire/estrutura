// Algoritmos de Ordenação em Listas e Implementação da Interface Comparable



// verificarNecessidadeDeCrescimento

private void verificarNecessidadeDeCrescimento() {
	int tamanho = this.arrayInterno.length;
	if(tamanho == this.numElementos) {
		T[] novo = (T[])new Comparable[tamanho + FATOR_CRESCIMENTO];
		for(int i = 0; i < this.numElementos; i++)
			novo[i] = this.arrayInterno[i];
		this.arrayInterno = novo;
	}
}


// inserir um elemento

@Override
public boolean inserir(T elemento) {
	this.verificarNecessidadeDeCrescimento();
	this.arrayInterno[this.numElementos] = elemento;
	this.numElementos++;
	return true;
}


// Inserir elemento na posição
	
@Override
public boolean inserir(T elemento, int posicao) {
	if(posicao < 0 || posicao > this.numElementos)
		return false;
	this.verificarNecessidadeDeCrescimento();
	for(int i = this.numElementos; i > posicao; i--) 
		this.arrayInterno[i] = this.arrayInterno[i-1];
	this.arrayInterno[posicao] = elemento;
	this.numElementos++;
	return true;
}


// Obter elemento por posicao

@Override
public T obter(int posicao) {
	if(posicao < 0 || posicao >= this.numElementos)
		return null;
	return this.arrayInterno[posicao];
}


// Posicao de um elemento

@Override
public int posicaoDe(T elemento) {
	for(int i = 0; i < this.numElementos; i++) {
		if(this.arrayInterno[i] == elemento)
			return i;
	}
	return NAO_ESTA_PRESENTE;
}


// Remover por posicao

@Override
public boolean remover(int posicao) {
	if(posicao < 0 || posicao >= this.numElementos)
		return false;
	for(int i = posicao; i < this.numElementos - 1; i++)
		this.arrayInterno[i] = this.arrayInterno[i+1];
	this.arrayInterno[this.numElementos - 1] = null;
	this.numElementos--;
	return true;
}


// Remover por elemento

@Override
public boolean remover(T elemento) {
	int posicao = this.posicaoDe(elemento);
	if(posicao == NAO_ESTA_PRESENTE)
		return false;
	return this.remover(posicao);
}


// Ordernar

	
public void ordenar() {
	for(int i = 0; i < this.numElementos - 1; i++) {
		int posMenor = i;
		for(int j = i + 1; j < this.numElementos; j++) {
			if(this.arrayInterno[j].compareTo(this.arrayInterno[posMenor]) < 0)
					posMenor = j;
		}
		T aux = this.arrayInterno[i];
		this.arrayInterno[i] = this.arrayInterno[posMenor];
		this.arrayInterno[posMenor] = aux;
	}
}


public T buscaBinaria(Comparable chave) {
	int limiteInferior = 0;
	int limiteSuperior = this.numElementos - 1;

	while (true) {
		int meio = (limiteInferior + limiteSuperior) / 2;
		int resultado = this.arrayInterno[meio].getChave().compareTo(chave);			
		if(resultado == 0) 
			return this.arrayInterno[meio];
		if(resultado < 0)
			limiteInferior = meio + 1;
		else
			limiteSuperior = meio - 1;
		if (limiteSuperior < limiteInferior) {
			return null;
		}
	}
}









