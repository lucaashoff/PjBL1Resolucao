public class Pilha {
    private No topo;
    private int tamanho;

    private class No {
        Pixel pixel;
        No abaixo;

        No(Pixel pixel) {
            this.pixel = pixel;
            this.abaixo = null;
        }
    }

    public Pilha() {
        topo = null;
        tamanho = 0;
    }

    public void push(Pixel pixel) {
        No novoNo = new No(pixel);

        if (isEmpty()) {
            topo = novoNo;
        } else {
            novoNo.abaixo = topo;
            topo = novoNo;
        }
        tamanho++;
    }

    public Pixel pop() {
        if (isEmpty()) {
            return null;
        }
        Pixel pixel = topo.pixel;

        topo = topo.abaixo;
        tamanho--;
        return pixel;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}
