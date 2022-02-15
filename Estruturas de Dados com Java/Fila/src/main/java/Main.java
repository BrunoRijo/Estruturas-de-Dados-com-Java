public class Main {

    public static void main(String[] args) {

        Fila minhaFila = new Fila();

        System.out.println("A fila é a seguinte:");
        minhaFila.enqueue(new No("primeiro"));
        minhaFila.enqueue(new No("segundo"));
        minhaFila.enqueue(new No("terceiro"));
        minhaFila.enqueue(new No("quarto"));
        minhaFila.enqueue(new No("quinto"));

        System.out.println(minhaFila);

        System.out.println("removendo o primeiro da fila");
       System.out.println(minhaFila.dequeue());

        System.out.println("A fila atual é:");
        System.out.println(minhaFila);

        System.out.println("O primeiro item da fila é:");
        System.out.println(minhaFila.first());

        System.out.println("inserindo um item na fila");
        minhaFila.enqueue(new No("ultim da fila"));

        System.out.println("Nova fila com dados inseridos:");
        System.out.println(minhaFila);

    }
}
