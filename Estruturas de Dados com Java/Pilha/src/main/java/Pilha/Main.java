package Pilha;

public class Main {
    public static void main(String[] args) {


        Pilha minhaPilha = new Pilha();


        minhaPilha.push(new No(1));
        minhaPilha.push(new No(2));
        minhaPilha.push(new No(3));
        minhaPilha.push(new No(4));
        minhaPilha.push(new No(5));
        minhaPilha.push(new No(6));

        System.out.println("Esta é a pilha");
        System.out.println(minhaPilha);

        System.out.println("Dando um pop");
        System.out.println(minhaPilha.pop());

        System.out.println("Pilha depois do pop()");
        System.out.println(minhaPilha);

        System.out.println("Dando um push de 999 e mostrando a nova pilha");
        minhaPilha.push(new No(999));
        System.out.println(minhaPilha);



    }
}