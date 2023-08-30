public class Fila {
    private No inicio, fim;
    private int tamanho;

    private class No { // Nó
        Pixel pixel;
        No prox;

        No(Pixel pixel) {
            this.pixel = pixel;
            this.prox = null;
        }
    }

    public Fila() {
        inicio = fim = null;
        tamanho = 0;
    }

    public void enqueue(Pixel pixel) { // enfileirar
        No novoNo = new No(pixel);

        if (isEmpty()) {
            inicio = fim = novoNo;
        } else {
            fim.prox = novoNo;
            fim = novoNo; // atualiza quem é o último nó da fila
        }
        tamanho++;
    }

    public Pixel dequeue() { // desenfileirar
        if (isEmpty()) {
            return null;
        }

        Pixel pixel = inicio.pixel;

        inicio = inicio.prox;
        tamanho--;
        if (isEmpty()) {
            fim = null;
        }
        return pixel;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}
