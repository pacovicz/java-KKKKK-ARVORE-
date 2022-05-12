class Node {

    private Integer idade;
    private Node esquerda;
    private Node direita;

    public Node() {
        this.idade = null;
        this.esquerda = null;
        this.direita = null;
    }

    public Node(Integer idade) {
        this.idade = idade;
        this.esquerda = null;
        this.direita = null;
    }

    public Node(Integer idade, Node esquerda, Node direita) {
        this.idade = idade;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public Integer pegaIdade() {
        return idade;
    }

    public void mudaIdade(Integer idade) {
        this.idade = idade;
    }

    public Node pegaEsquerda() {
        return esquerda;
    }

    public void mudaEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node pegaDireita() {
        return direita;
    }

    public void mudaDireita(Node direita) {
        this.direita = direita;
    }

}

class ArvoreBinaria {

    private Node arvore;

    public ArvoreBinaria(Integer raiz) {
        this.arvore = new Node(raiz);
    }

    public ArvoreBinaria() {
        this.arvore = null;
    }

    public Node pegaArvore() {
        return arvore;
    }

    public void mudaArvore(Node arvore) {
        this.arvore = arvore;
    }

    public Node insercao(Integer idade) {
        this.arvore = insercao(this.arvore, idade);
        return this.arvore;
    }

    public Node insercao(Node pRaiz, Integer idade) {
        if (pRaiz == null){
            pRaiz = new Node(idade);
            return pRaiz;
        } else if(pRaiz.pegaIdade() >= idade){
            Node aux = insercao(pRaiz.pegaEsquerda(), idade);
            pRaiz.mudaEsquerda(aux);
            return pRaiz;
        } else {
            Node aux1 = insercao(pRaiz.pegaDireita(), idade);
            pRaiz.mudaDireita(aux1);
            return pRaiz;
        }
    }

    public Node MenorEsquerda() {
        return MenorEsquerda(this.arvore);
    }

    public Node MenorEsquerda(Node no) {
        if (no.pegaEsquerda() != null) {
            return MenorEsquerda(no.pegaEsquerda());
        }  
        return no;        
    }

    public Node MaiorDireita() {
        return MaiorDireita(this.arvore);
    }

    public Node MaiorDireita(Node no) {
        if (no.pegaDireita() != null) {
            return MaiorDireita(no.pegaDireita());
        } 
        return no;
    }

    public int encontraMaior() {
        return encontraMaior(this.arvore);
    }

    public int encontraMaior(Node raiz) {
        if (raiz.pegaDireita() != null) {
            return encontraMaior(raiz.pegaDireita());
        } else {
            return raiz.pegaIdade();
        }
    }

    public Node remover(Integer idade) {
        return remover(this.arvore, new Node(idade));
    }

    public Node remover(Node raiz, Node no) {
        Node aux = raiz.pegaEsquerda();

        return null;
    }

    public Node removerMaior(Node pRaiz) {
        //VERIFICA SE A RAIZ FOR NULL ELE SE RETORNA
        if (pRaiz == null) {
            return pRaiz;
        }
        Node proximoNode = null;

        //VERIFICA SE A DIREITA E DIFERENTE DE NULL E SETTA O PROXIMO NODE DA DIREITA ANTERIOR
        if (pRaiz.pegaDireita() != null) {
            proximoNode = pRaiz.pegaDireita();
        }

        //se meu filho não tem neto ele remove o filho
        //(NAO SEI EXPLICAR APENAS FUNCIONA)

        if (pRaiz.pegaDireita() != null && proximoNode.pegaDireita() == null) {
            pRaiz.mudaDireita(null);
        }
        removerMaior(pRaiz.pegaDireita());
        return null;
    }

    public Node removerMaior() {
        removerMaior(arvore);
        return this.arvore;
    }

    public Node removerMenor(Node pRaiz) {
        if (pRaiz == null) {
            return pRaiz;
        }

        Node proximoNode = null;
        if (pRaiz.pegaEsquerda() != null) {
            proximoNode = pRaiz.pegaEsquerda();
        }

        if (pRaiz.pegaDireita() != null && proximoNode.pegaEsquerda() == null) {
            pRaiz.mudaEsquerda(null);
        }

        removerMenor(pRaiz.pegaEsquerda());
        return null;
    }

    public Node removerMenor() {
        removerMenor(arvore);
        return this.arvore;
    }

    public void PreOrdem() {
        PreOrdem(this.arvore);
        System.out.println();
    }

    public void PreOrdem(Node pRaiz) {
        if (pRaiz == null){
            return;
        }
        System.out.println(pRaiz.pegaIdade() + " ");
        PreOrdem(pRaiz.pegaEsquerda());
        PreOrdem(pRaiz.pegaDireita());
    }

    public void EmOrdem(Node pRaiz) {

        if(pRaiz == null) {
            return;
        }

        EmOrdem(pRaiz.pegaEsquerda());
        System.out.println(pRaiz.pegaIdade() + " ");
        EmOrdem(pRaiz.pegaDireita());
    }

    public void EmOrdem() {
        EmOrdem(this.arvore);
        System.out.println();
    }

    public void PosOrdem() {
        PosOrdem(this.arvore);
        System.out.println();
    }

    public void PosOrdem(Node pRaiz) {
        if (pRaiz == null) {
            return;
        }
        PosOrdem(pRaiz.pegaEsquerda());
        PosOrdem(pRaiz.pegaDireita());
        System.out.println(pRaiz.pegaIdade() + " ");
    }

    // Conta o número de elementos da árvore
    public int contarNos() {
        return contarNos(this.arvore);
    }

    // Conta o número de elementos da árvore
    private int contarNos(Node pRaiz) {
        if (pRaiz == null) {
            return 0;
        } else {
            return 1 + (contarNos(pRaiz.pegaEsquerda()) + 
                        contarNos(pRaiz.pegaDireita()));
        }
    }

    // Conta o número de folhas da árvore
    public int contarFolhas() {
        return contarFolhas(this.arvore);
    }

    // Conta o número de folhas da árvore
    private int contarFolhas(Node pRaiz) {
        if (pRaiz == null) {
            return 0;
        }
        if (pRaiz.pegaEsquerda() == null && pRaiz.pegaDireita() == null) {
            return 1;
        }
        return contarFolhas(pRaiz.pegaEsquerda()) + 
               contarFolhas(pRaiz.pegaDireita());
    }

    public int maiorQue(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // Calcula altura da árvore
    public int altura() {
        return altura(this.arvore);
    }

    // Calcula altura da árvore
    public int altura(Node pRaiz) {
        if ((pRaiz == null) || (pRaiz.pegaEsquerda() == null
                && pRaiz.pegaDireita() == null)) {
            return 0;
        } else {
            return 1 + maiorQue(altura(pRaiz.pegaEsquerda()), altura(pRaiz.pegaDireita()));
        }
    }

    // Busca um elemento na árvore
    public Node busca(int idade) {
        return busca(this.arvore, idade);
    }

    // Busca um elemento na árvore
    private Node busca(Node pRaiz, int idade) {
        if (pRaiz == null) {
            return null;
        } else if (pRaiz.pegaIdade() == idade) {
            return pRaiz;
        } else if (idade < pRaiz.pegaIdade()) {
            return busca(pRaiz.pegaEsquerda(), idade);
        }
        return busca(pRaiz.pegaDireita(), idade);
    }

}

class BuscaBinaria {
    
    public static int buscaBinaria(Integer [] V, int chave){
        return buscaBinaria(V, chave, 0, V.length - 1);
    }
    
    public static int buscaBinaria(Integer [] V, int chave, int inicio, int fim){

        int meio = (inicio + fim) / 2;
        while (V[meio] != chave) {
            meio = (inicio + fim) / 2;
            if (chave < V[meio]) {
                fim = meio - 1;
            } else if (chave > V[meio]){
                inicio = meio + 1;
            }
            if(fim == inicio-1 || inicio == fim+1) {
                System.out.printf("CHAVE INEXISTENTE!");
                return -1;
            }
        }

        return V[meio];
    }
    
}

public class API {
    
      public static void main(String[] args) {

        System.out.println("-----------Busca Binária --------------");
          
        Integer [] V = new Integer[10];
        V[0] = 4;
        V[1] = 23;
        V[2] = 41;
        V[3] = 43;
        V[4] = 56;
        V[5] = 76;
        V[6] = 81;
        V[7] = 94;
        V[8] = 95;
        V[9] = 100;

        Integer chave = 81;
        System.out.println("buscaBinaria: chave = "+chave+" "+(BuscaBinaria.buscaBinaria(V, chave)));
          
          
        System.out.println("-------------  Árvore de Binária de Busca----------");
        
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.insercao(8);
        arvore.insercao(5);
        arvore.insercao(9);
        arvore.insercao(3);
        arvore.insercao(7);
        arvore.insercao(2);
        arvore.insercao(4);
        arvore.insercao(6);
                

        System.out.println("PreOrdem (RED): "); arvore.PreOrdem();
        System.out.println("EmOrdem (ERD): "); arvore.EmOrdem();
        System.out.println("PosOrdem (EDR): "); arvore.PosOrdem();
        System.out.println("-----------------------------------------");

        //arvore.remover(8);
        //arvore.removerMaior();
        //arvore.removerMenor();
        System.out.println("PreOrdem (RED): "); arvore.PreOrdem();
        System.out.println("EmOrdem (ERD): "); arvore.EmOrdem();
        System.out.println("PosOrdem (EDR): "); arvore.PosOrdem();
        System.out.println("-----------------------------------------");
        System.out.println("busca(4): "+arvore.busca(4).pegaIdade());
        System.out.println("altura: "+arvore.altura());
        System.out.println("contarFolhas: "+arvore.contarFolhas());
        System.out.println("contarNos: "+arvore.contarNos());
        System.out.println("encontraMaior: "+arvore.encontraMaior());
        System.out.println("MaiorDireita: "+arvore.MaiorDireita().pegaIdade());
        System.out.println("MenorEsquerda: "+arvore.MenorEsquerda().pegaIdade());
    }
}
