package unac.edu.co;

public class Lista {
    public Nodo primerNodo;
    public Nodo ultimoNodo;

    public Lista() {
        primerNodo = ultimoNodo = null;
    }

    public void insertarAlFrente(Polino est) {
        if (estaVacia())
            primerNodo = ultimoNodo = new Nodo(est);
        else
            primerNodo = new Nodo(est, primerNodo);
    }


    public boolean estaVacia() {
        return primerNodo == null;
    }

    public void insertarAlFinal(Polino est) {
        if (estaVacia())
            primerNodo = ultimoNodo = new Nodo(est);
        else
            ultimoNodo = ultimoNodo.siguiente = new Nodo(est);

    }
}