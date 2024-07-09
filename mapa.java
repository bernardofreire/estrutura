// CLASSROOM

    // Inserir

public boolean inserir(C chaveIndexacao, V elemento) {
	this.verificarNecessidadeDeCrescimento();

	No<C, V> novoNo = new No(chaveIndexacao, elemento);

	int posicaoParaInsercao = this.numElementos;
	for (int i = 0; i < this.numElementos; i++) {
		int resultado = this.arrayInterno[i].getChave().compareTo(chaveIndexacao);

			if (resultado == 0)
				return false;
	
			if (resultado > 0) {
				
				for (int j = this.numElementos - 1; j >= i; j--)
					this.arrayInterno[j + 1] = this.arrayInterno[j];
		
				posicaoParaInsercao = i;
				break;
			}
		}
		this.arrayInterno[posicaoParaInsercao] = novoNo;
		this.numElementos++;
		return true;
}


    // Obter

    public V obter(C chave) {
		int limiteInferior = 0;
		int limiteSuperior = this.numElementos - 1;

		while (true) {
			int meio = (limiteInferior + limiteSuperior) / 2;
			int resultado = this.arrayInterno[meio].getChave().compareTo(chave);
			if (resultado == 0)
				return this.arrayInterno[meio].getValor();
			if (resultado < 0)
				limiteInferior = meio + 1;
			else
				limiteSuperior = meio - 1;
			if (limiteSuperior < limiteInferior) {
				return null;
			}
		}
	}





// PROVA AV2

    // Busca binaria


private int buscaBinaria(C chave) {
    int limiteInferior = 0;
    int limiteSuperior = this.numElementos - 1;

    while (limiteInferior <= limiteSuperior) {
        int meio = (limiteInferior + limiteSuperior) / 2;
        int resultado = this.arrayInterno[meio].getChave().compareTo(chave);

        if (resultado == 0) {
            return meio; // Chave encontrada
        } else if (resultado < 0) {
            limiteInferior = meio + 1; // Buscar na metade superior
        } else {
            limiteSuperior = meio - 1; // Buscar na metade inferior
        }
    }

    return NAO_ENCONTRADO; 
}


    // Inserir

public boolean inserir(C chave, V valor) {
    this.verificarNecessidadeDeCrescimento();

    int posicao = this.buscaBinaria(chave);
    if (posicao != NAO_ENCONTRADO) {
        return false; // Chave já existe
    }

    int posicaoParaInsercao = this.numElementos;
    for (int i = 0; i < this.numElementos; i++) {
        int resultado = this.arrayInterno[i].getChave().compareTo(chave);
        if (resultado > 0) {
            posicaoParaInsercao = i;
            break;
        }
    }

    for (int j = this.numElementos; j > posicaoParaInsercao; j--) {
        this.arrayInterno[j] = this.arrayInterno[j - 1];
    }

    this.arrayInterno[posicaoParaInsercao] = new No<>(chave, valor);
    this.numElementos++;
    return true;
}



// verificarNecessidadeDeCrescimento

private void verificarNecessidadeDeCrescimento() {
	int tamanho = this.arrayInterno.length;
	if (tamanho == this.numElementos) {
		No[] novo = new No[tamanho + FATOR_CRESCIMENTO];
		for (int i = 0; i < this.numElementos; i++){
	    	novo[i] = this.arrayInterno[i];
			this.arrayInterno = novo;
        }
	}
}