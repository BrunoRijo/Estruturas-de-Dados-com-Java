/*
    Arvores são estruturas de dados bidimensionais, não lineares
(diferente de listas, filas e pilhas), constituidas de nós que
representam um modelo hierárquico.
    Podem ser usadas em sistemas de arquivos, banco de dados, interfaces
gráficas, páginas web, etc. A árvore recebe este nome por conta da sua
estrutura semelhante a uma árvore invertida.
    Em uma árvore o nós é composto pelo conteúdo e duas referencias, uma
apontará para o nó da esquerda e um para o da direita. É o mesmo modelo de
 nós de uma lista duplamente encadeada. Quando os nós tiverem referencias
 nulas, significa que é um nó folha, ou seja, o final da árvore.*/

public class ArvoreBinaria <T extends Comparable<T>>{

    private BinNo<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir (T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        this.raiz = inserir(raiz,novoNo);
    }

    private BinNo<T> inserir (BinNo<T> atual, BinNo<T> novoNo){
        if(atual == null){
            /*Atual nulo significa que a arvore esta vazia
                    e este nó será setado como raiz*/
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo())<0){
            /*Verifica se o conteudo do novo nó é menor do que o atual
            caso seja, utiliza recursividade para criar um 'filho' em
            sua esquerda*/
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        } else {
            /*caso contrário, onde o conteudo do novoNo seja maior que o do
                nó atual, então deverá ser criado um nó a direita.*/
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }
        return atual;
    }

    public void remover(T conteudo){
        try{
            //variaveis auxilares
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temporario = null;

            /*O atual se inicia com o conteudo da raiz e percorre a arvore
            fazendo comparações de conteudo, caso o atual seja diferente
            de nulo e ao mesmo tempo diferente do valor ja setado na raiz
            entra no looping*/
            while(atual!=null && !atual.getConteudo().equals(conteudo)){
                pai = atual;
                /*Percorrendo a lista, o pai é setado com o valor atual
                 e verifica-se se o conteudo é menor do que zero
                 (pois o método compareTo retorna 1 caso seja igual -1, caso seja menor)
                 sendo, o atual é setado com o filho da esquerda, caso contratio
                 aontece com o da direita*/
                if(conteudo.compareTo(atual.getConteudo()) < 0){
                    atual = atual.getNoEsq();
                }else{
                    atual = atual.getNoDir();
                }
            }
            //Caso o atual não seja encontrado na arvore.
            if(atual==null){
                System.out.println("Conteudo não encontrado. (Bloco try)");
            }

            //Tratativas de nulabilidade
            if(pai==null){
                /*Se nó pai for null significa que é a raiz da arvore
                nao tendo valor na direita, é setado o valor da esquerda e vice versa
                caso contrario é percorrido um for onde enquanto houver um nó filho à direita
                os nós temporario e filho são modificados
                */
                if(atual.getNoDir()==null){
                    this.raiz = atual.getNoEsq();
                }
                else if (atual.getNoEsq()==null){
                    this.raiz = atual.getNoDir();
                } else {
                    for (temporario = atual, filho = atual.getNoEsq();
                         filho.getNoDir() != null;
                         temporario = filho, filho = filho.getNoEsq()
                    ){
                        if(filho != atual.getNoEsq()){
                            temporario.setNoDir((filho.getNoEsq()));
                            filho.setNoEsq(raiz.getNoEsq());
                        }
                        filho.setNoDir(raiz.getNoDir());
                        raiz = filho;
                    }
                }
            }
            else if(atual.getNoDir() == null){
                if(pai.getNoEsq()==atual){
                    pai.setNoEsq(atual.getNoEsq());
                }
                else{
                    pai.setNoDir(atual.getNoEsq());
                }
            }
            else if (atual.getNoEsq()==null){
                if(pai.getNoEsq()==atual){
                    pai.setNoEsq(atual.getNoDir());
                }
                else{
                    pai.setNoDir(atual.getNoDir());
                }
            }
            else {
                for (
                        temporario = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;
                        temporario = filho, filho = filho.getNoDir()
                ){
                    if (filho != atual.getNoEsq()){
                        temporario.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(atual.getNoEsq());
                    }
                    filho.setNoDir(atual.getNoDir());
                    if (pai.getNoEsq() == atual){
                        pai.setNoEsq(filho);
                    }else{
                        pai.setNoDir(filho);
                    }
                }
            }


        } catch (NullPointerException erro){
            System.out.println("Conteudo nao encontrado. (Bloco Catch)");
        }
    }

    //Métodos de Exibição da àrvore.
    public void exibirInOrdem(){
        //Exibe do menor para o maior
        System.out.println("Exibindo InOrdem");
        exibirInOrdem(this.raiz);
    }

    private void exibirInOrdem(BinNo<T> atual){
        if(atual != null){
            exibirInOrdem(atual.getNoEsq());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDir());
        }
    }

    public void exibirPosOrdem(){
        System.out.println("Exibindo PosOrdem");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(BinNo<T> atual){
        if(atual != null){
            exibirInOrdem(atual.getNoEsq());
            exibirInOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");
        }
    }

    public void exibirPreOrdem(){
        System.out.println("Exibindo PreOrdem");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(BinNo<T> atual){
        if(atual != null){
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoEsq());
            exibirInOrdem(atual.getNoDir());
        }
    }

}
