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
