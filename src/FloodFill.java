public class FloodFill {

    public static void floodFillFila(int[][] matriz, int startX, int startY, int novaCor) {
        int corInicial = matriz[startX][startY];

        Fila fila = new Fila();
        fila.enqueue(new Pixel(startX, startY));

        while (!fila.isEmpty()) {
            Pixel atual = fila.dequeue();

            if (atual == null) continue; // segurança para caso a pilha ou fila retorne null
            // se retornar null, vai utilizar a função conitnue para pular para o próximo ciclo do loop

            int x = atual.x;
            int y = atual.y;

            // garantir que não vá sair dos limites da matriz
            if (x < 0 || y < 0 || x >= matriz.length || y >= matriz[0].length) continue;

            if (matriz[x][y] == corInicial) {
                matriz[x][y] = novaCor; // pinta o pixel

                // adicionar os vizinhos do pixel atual na fila. são colocados na fila para serem checados depois.
                fila.enqueue(new Pixel(x + 1, y));
                fila.enqueue(new Pixel(x - 1, y));
                fila.enqueue(new Pixel(x, y + 1));
                fila.enqueue(new Pixel(x, y - 1));
            }
        }
    }
    public static void floodFillPilha(int[][] matriz, int startX, int startY, int novaCor) {
        int corInicial = matriz[startX][startY];

        Pilha pilha = new Pilha();
        pilha.push(new Pixel(startX, startY));

        while (!pilha.isEmpty()) {
            Pixel atual = pilha.pop(); // tira o pixel que tá no topo da pilha e retorna ele

            if (atual == null) continue; // segurança para caso a pilha ou fila retorne null
            // se retornar null, vai utilizar a função conitnue para pular para o próximo ciclo do loop

            int x = atual.x;
            int y = atual.y;

            // garantir que não vá sair dos limites da matriz
            if (x < 0 || y < 0 || x >= matriz.length || y >= matriz[0].length) continue;

            if (matriz[x][y] == corInicial) {
                matriz[x][y] = novaCor; // pinta o pixel

                // adicionar os vizinhos do pixel atual na fila. são colocados na fila para serem checados depois.
                pilha.push(new Pixel(x + 1, y));
                pilha.push(new Pixel(x - 1, y));
                pilha.push(new Pixel(x, y + 1));
                pilha.push(new Pixel(x, y - 1));
            }
        }
    }
}
