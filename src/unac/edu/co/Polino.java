package unac.edu.co;

public class Polino {
    private int coeficiente;
    private int exponente;

    public Polino(){
        this.coeficiente=0;
        this.exponente=0;

    }

    public Polino(int co, int ex){
        setPolinomio(co, ex);

    }

    public void setPolinomio(int coeficiente,int exponente){
        this.coeficiente=coeficiente;
        this.exponente=exponente;
    }

    public int getExponente(){
        return this.exponente;
    }

    public void setExponente(int ex){
        this.exponente=ex;
    }
    public int getCoeficiente(){
        return this.coeficiente;
    }


}

