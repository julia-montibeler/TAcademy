import java.lang.reflect.Array;

public class Fila<T>{

    private int n;
    private int ini;
    private int tam;
    private T[] vet;

    public Fila(int tam) {
        vet = (T[]) new Object[tam];;
        this.tam = tam;
        ini = 0;
        n = 0;
    }

    public String toString() {
        String vetor = "";
        for (int i = ini; i < n + ini; i++) {
            vetor += vet[i % tam] + " ";
        }
        return vetor;
    }
    public void enqueue(T v) throws Exception {
        if (n == tam) {
            throw new Exception("A fila está cheia");
        }
        int fim = (ini+n)%tam;
        this.vet[fim] = v;
        this.n++;
    }

    public T dequeue() throws Exception{
        if (n == 0) {
            throw new Exception("A fila está vazia");
        }
        T valor = this.vet[ini];
        ini = (ini + 1) % tam;
        this.n--;
        return valor;
    }

    public boolean isEmpty() {
        if (n > 0) {
            return false;
        }
        return true;
    }

}
