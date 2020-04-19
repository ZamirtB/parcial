package unac.edu.co;

public class Nodo {
    public Nodo siguiente;
    public Polino poli;
    Polino polinomio;
    //Nodo siguiente;
    public Nodo (Polino x)
    {
        this.polinomio =x;
        siguiente = null;
    }

    public Nodo(Polino x, Nodo nuevoelemento){

        this.polinomio =x;
        siguiente=nuevoelemento;

    }

    Polino getPolinomio()
    {
        return this.polinomio;
    }

    Nodo getsiguientet()
    {
        return siguiente;
    }


}