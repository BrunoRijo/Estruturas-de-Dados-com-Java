public class NoDuplo<T> {

    T conteudo;
    NoDuplo<T> refProximo;
    NoDuplo<T> refAnterior;

    public NoDuplo() {
    }

    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo(T conteudo, NoDuplo refProximo, NoDuplo refTail) {
        this.conteudo = conteudo;
        this.refProximo = refProximo;
        this.refAnterior = refTail;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo getRefProximo() {
        return refProximo;
    }

    public void setRefProximo(NoDuplo refProximo) {
        this.refProximo = refProximo;
    }

    public NoDuplo getRefAnterior() {
        return refAnterior;
    }

    public void setRefAnterior(NoDuplo refAnterior) {
        this.refAnterior = refAnterior;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
