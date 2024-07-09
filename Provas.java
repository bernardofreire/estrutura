//AV1------------------------------------------------
//1 - STACK(PILHA)
public void push(T novoObject) {
  int tamanho = this.arrayInterno.length; 
  if(tamanho == this.topo+1) {
    Object[] aux = new Object[tamanho + FATOR_CRESCIMENTO];
    for(int i = 0; i < tamanho; i++)
      aux[i] = this.arrayInterno[i];
    this.arrayInterno = aux;
  }
  this.topo++;
  this.arrayInterno[this.topo] = novoObject;
}


public T pop() {
  if(this.topo == -1)
    return null;
  Object elemento = this.arrayInterno[this.topo];
  this.arrayInterno[this.topo] = null;
  this.topo--;
  return (T)elemento;
}

//2 - QUEUE ENCADEADA (FILA ENCADEDA)
public void push(T elemento) {
  No<T> novo = new No(elemento);		
  if(this.primeiro == null)
    this.primeiro = novo;
  else
    this.ultimo.setAnterior(novo);
  this.ultimo = novo;
  this.numElementos++;
}


public T pop() {
  if(this.numElementos == 0)
    return null;
  T retorno = this.primeiro.getElemento();
  this.primeiro = this.primeiro.getAnterior();
  this.numElementos--;
  if(this.numElementos == 0) 
    this.ultimo = null;
  return retorno;
}

//3 - LISTA ENCADEDA
public boolean inserir(T elemento) {
  No<T> novo = new No(elemento);
  if(this.numElementos == 0) {
    this.primeiro = novo;
  } else {
    No<T> aux = this.primeiro;
    while(aux.getProximo() != null)
      aux = aux.getProximo();
    aux.setProximo(novo);
  }
  this.numElementos++;
  return true;
}

public boolean inserir(T elemento, int posicao) {
  if(posicao < 0 || posicao > this.numElementos)
    return false;
  No<T> novo = new No(elemento);
  if(posicao == 0) {
    if(this.primeiro != null)
      novo.setProximo(this.primeiro);
    this.primeiro = novo; 
  } else {
    int pos = 0;
    No<T> aux = this.primeiro;
    while(pos < posicao-1) {
      aux = aux.getProximo();
      pos++;
    }
    novo.setProximo(aux.getProximo());
    aux.setProximo(novo);
  }
  this.numElementos++;
  return true;
}

public T obter(int posicao) {
    if(posicao < 0 || posicao >= this.numElementos)
        return null;
    int pos = 0;
     No<T> aux = this.primeiro;
  
    while(pos < posicao) {
        aux = aux.getProximo();
        os++;
    }

    return aux.getElemento();
}

public int posicaoDe(T elemento) {
    int pos = 0;
    No<T> aux = this.primeiro;

    while(aux != null) {
        if(aux.getElemento() == elemento)
            return pos; 
    
    pos++;
    aux = aux.getProximo();
    }
  
  return NAO_ESTA_PRESENTE;
}


//AV2 ---------------------------------------------------

//1 - LISTA ENCADEADA

public boolean inserir(T elemento, int posicao) {
    if(posicao < 0 || posicao > this.numElementos)
        return false;

    No<T> novo = new No(elemento);

    if(posicao == 0) {
    if(this.primeiro != null)
        novo.setProximo(this.primeiro);
        this.primeiro = novo; 
    } else {
        int pos = 0;
        No<T> aux = this.primeiro;

    while(pos < posicao-1) {
      aux = aux.getProximo();
      pos++;
    }

    novo.setProximo(aux.getProximo());
    aux.setProximo(novo);
  }

  this.numElementos++;
  return true;
}


//2 - LISTA ARRAY

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
    int faixaInferior = 0;
    int faixaSuperior = this.numElementos - 1;
    while(true) {			
      int meio = (faixaInferior + faixaSuperior) / 2;			
      int comparacao = this.arrayInterno[meio].getChave().compareTo(chave);
      if(comparacao == 0) 				
        return this.arrayInterno[meio];
      if(comparacao < 0) 
        faixaInferior = meio + 1;
      else
        faixaSuperior = meio - 1;				
      if(faixaInferior > faixaSuperior) 				
        return null;			
    }		
  }
}


//3 - MAPA

public boolean inserir(C chave, V valor) {
    this.verificarNecessidadeDeCrescimento();
    No<C,V> novoNo = new No(chave,valor);

    int posicaoParaInsercao = this.numElementos;
    for(int i = 0; i < this.numElementos; i++) {
      int resultado = this.arrayInterno[i].getChave().compareTo(chave);
      if(resultado == 0)
        return false;
      if(resultado > 0) {
        for(int j = this.numElementos - 1; j >= i; j--)
          this.arrayInterno[j+1] = this.arrayInterno[j];
        posicaoParaInsercao = i;
        break;
      }
    }		
    this.arrayInterno[posicaoParaInsercao] = novoNo;
    this.numElementos++;
    return true;
  }

public V obter(C chave) {
  int posicao = this.buscaBinaria(chave);
  if(posicao == NAO_ENCONTRADO)
    return null;			
  return this.arrayInterno[posicao].getValor();
}


//4 - ÁRVORE BINARIA
//IMPRESSÃO E SENTIDO HORARIO

public void imprimir(int nivel) {
  if(this.direita != null)
    this.direita.imprimir(nivel + 1);
  for(int i = 0; i < nivel; i++)
    System.out.print('\t');
  System.out.println(this.elemento);

  if(this.esquerda != null)
    this.esquerda.imprimir(nivel + 1);
}

public T obter(Comparable chave) {
  int resultado = this.getElemento().getChave().compareTo(chave);
  if(resultado == 0) 
    return this.getElemento();
  if(resultado < 0) {
    if(this.getEsquerda() == null)
      return null;
    return this.getEsquerda().obter(chave);
  }				
  else {
    if(this.getDireita() == null)
      return null;
    return this.getDireita().obter(chave);
  }					
}
