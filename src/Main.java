import unac.edu.co.Lista;
import unac.edu.co.Nodo;
import unac.edu.co.Polino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));
        int salir = 1;
        do {
            System.out.println("\n1. Obtener la lista suma de dos Polinomios");
            System.out.println("2. Obtener el polinomio derivado");
            System.out.println("3. Obtener una lista que sea el producto de dos polinomios.");
            System.out.println("4. Salir");
            System.out.print("Ingrese opcion: ");
            int opcion = Integer.parseInt(dato.readLine());
            switch (opcion) {
                case 1:
                    Lista poli1=new Lista();
                    Lista poli2=new Lista();
                    System.out.print("Inicialmente ingrese cuantos terminos posee el 1 primer Polinomio: ");
                    int cant=Integer.parseInt(dato.readLine());
                    for (int i = 1; i <= cant; i++) {
                        System.out.print("Termino: "+i+"\n");
                        System.out.print("Ingrese coeficiente: ");
                        int coefi=Integer.parseInt(dato.readLine());
                        System.out.print("Ingrese exponente: ");
                        int expon=Integer.parseInt(dato.readLine());
                        if(expon==0)
                            expon=-1;
                        Polino poli= new Polino(coefi,expon);
                        poli1.insertarAlFrente(poli);
                    }
                    System.out.print("Incialmente ingrese cuantos terminos posee el 2 segundo Polinomio: ");
                    int cant2=Integer.parseInt(dato.readLine());
                    for (int i = 1; i <= cant2; i++) {
                        System.out.print("Termino: "+i+"\n");
                        System.out.print("Ingrese coeficiente: ");
                        int coefi=Integer.parseInt(dato.readLine());
                        System.out.print("Ingrese exponente: ");
                        int exponente=Integer.parseInt(dato.readLine());
                        if(exponente==0)
                            exponente=-1;
                        Polino poli= new Polino(coefi,exponente);
                        poli2.insertarAlFrente(poli);
                    }
                    System.out.println();
                    System.out.print("RESPUESTA SUMA:  ");
                    sumaPolinomios(poli1.primerNodo,poli2.primerNodo,cant,cant2);
                    System.out.println();
                    break;
                case 2:
                    Lista derivada=new Lista();
                    System.out.print("Incialmente ingrese cuantos terminos posee el 1 primer Polinomio: ");
                    cant=Integer.parseInt(dato.readLine());
                    for (int i = 1; i <= cant; i++) {
                        System.out.print("Termino: "+i+"\n");
                        System.out.print("Ingrese coeficiente: ");
                        int coeficiente=Integer.parseInt(dato.readLine());
                        System.out.print("Ingrese exponente: ");
                        int exponente=Integer.parseInt(dato.readLine());
                        Polino poli= new Polino(coeficiente,exponente);
                        derivada.insertarAlFrente(poli);
                    }
                    System.out.println();
                    System.out.print("RESPUESTA DERIVACION:  ");
                    derivadaPolinomios(derivada.primerNodo);
                    System.out.println();
                    break;
                case 3:
                    poli1=new Lista();
                    poli2=new Lista();
                    System.out.print("Incialmente ingrese cuantos terminos posee el 1 primer Polinomio: ");
                    cant=Integer.parseInt(dato.readLine());
                    for (int i = 1; i <= cant; i++) {
                        System.out.print("Termino: "+i+"\n");
                        System.out.print("Ingrese coeficiente: ");
                        int coefi=Integer.parseInt(dato.readLine());
                        System.out.print("Ingrese exponente: ");
                        int expon=Integer.parseInt(dato.readLine());
                        Polino poli= new Polino(coefi,expon);
                        poli1.insertarAlFrente(poli);
                    }
                    System.out.print("Incialmente ingrese cuantos terminos posee el 2 segundo Polinomio: ");
                    cant2=Integer.parseInt(dato.readLine());
                    for (int i = 1; i <= cant2; i++) {
                        System.out.print("Termino: "+i+"\n");
                        System.out.print("Ingrese coefi: ");
                        int coefi=Integer.parseInt(dato.readLine());
                        System.out.print("Ingrese expon: ");
                        int expon=Integer.parseInt(dato.readLine());
                        Polino poli= new Polino(coefi,expon);
                        poli2.insertarAlFrente(poli);
                    }
                    System.out.println();
                    System.out.print("RESPUESTA PRODUCTO:  ");
                    producto(poli1.primerNodo,poli2.primerNodo,  cant,  cant2);
                    System.out.println();
                    break;
                case 4:
                    salir=0;
                    break;
            }
        }while(salir!=0);
    }
    public static void producto(Nodo poli1,Nodo poli2, int cantidad, int cantidad2){
        Lista guardap1= new Lista();
        Nodo a;
        Nodo b;
        if(cantidad>cantidad2){
            a=poli1;
            b=poli2;
        }else{
            a=poli2;
            b=poli1;
        }
        int cont=0;
        while(a!=null){
            while(b!=null){
                int coefi=a.poli.getCoeficiente()*b.poli.getCoeficiente();
                int expon=a.poli.getExponente()+b.poli.getExponente();
                Polino poli= new Polino(coefi,expon);
                guardap1.insertarAlFrente(poli);
                b=b.siguiente;
                cont++;
            }
            if(cantidad>cantidad2){ b=poli2;
            }else{ b=poli1; }
            a=a.siguiente;
        }
        Lista vacio= new Lista();
        Nodo ver=guardap1.primerNodo;
        while(ver!=null){
            if(ver.poli.getExponente()==0){
                ver.poli.setExponente(-1);
            }ver=ver.siguiente; }
        sumaPolinomios(guardap1.primerNodo,vacio.primerNodo, cont,  0);
    }
    public static void derivadaPolinomios(Nodo derivada){
        Nodo p=derivada;
        int acum=0;
        int r=0;
        int cont=0;
        while(p!=null){
            acum=p.poli.getCoeficiente()*p.poli.getExponente();
            r=p.poli.getExponente();
            r--;
            if(cont==0){
                if(r>0 && acum>0)
                    System.out.print(acum +" X ^  "+r+ "   " );
                if(r>0 && acum<0)
                    System.out.print(acum+" X ^  "+r+ "   ");
                if(r==0)
                    System.out.print(acum+"  ");
                if(r<0)
                    System.out.print(" 0 ");
            }
            if(cont>0){
                if(r>0 && acum>0)
                    System.out.print(" + "+acum +" X ^  "+r+ "   " );
                if(r>0 && acum<0)
                    System.out.print(acum+" X ^  "+r+ "   ");
                if(r==0 && acum>0)
                    System.out.print(" + "+acum+"  ");
                if(r==0 && acum<0)
                    System.out.print(acum+"  ");
                if(r<0)
                    System.out.print(" +0 ");
            }
            cont++;
            acum=0;
            r=0;
            p=p.siguiente;
        }
    }
    public static void sumaPolinomios(Nodo poli1,Nodo poli2, int cantidad, int cantidad2){
        int [] numerosl1=new int[cantidad];
        int [] numerosl2=new int[cantidad2];
        int acomp=0;
        Nodo p=poli1;
        while(p!=null){
            numerosl1[acomp]=p.poli.getExponente();
            acomp++;
            p=p.siguiente;
        }
        int acomp2=0;
        Nodo q=poli2;
        while(q!=null) {
            numerosl2[acomp2]=q.poli.getExponente();
            acomp2++;
            q=q.siguiente;
        }
        int [] mipoli=new int[100];// AQUI VA A GUARDARCE MI POLINOMIO
        int aux=0;//AQUI SE VA ALMACENAR MI MAYOR NUMERO
        int vueltas=cantidad+cantidad2;
        int cambios1=0, cambios2=0;
        for (int j = 0; j < cantidad; j++) {
            mipoli[j]=numerosl1[j];
        }
        for (int j = 0; j < cantidad2; j++) {
            mipoli[cantidad++]=numerosl2[j];
        }
        int ver2=0;
        for (int i = 0; i < vueltas; i++) {
            for (int j = 0; j < vueltas; j++) {
                if(mipoli[i]==mipoli[j])
                    ver2++;
                if(ver2==2){
                    mipoli[j]=0;
                    ver2--;
                } }ver2=0;
        }
        int ccero=0;
        for (int i = 0; i < vueltas; i++) {
            if(mipoli[i]==0){ ccero++; }
        }
        int actual=vueltas-ccero;
        int [] vpolinomio=new int[actual];
        int cvpoli=0;
        for (int i = 0; i < vueltas; i++) {
            if(mipoli[i]!=0){
                vpolinomio[cvpoli]=mipoli[i];
                cvpoli++;
            }
        }
        ordBurbuja (vpolinomio, cvpoli);
        int d=0;
        acomp=vpolinomio.length;
        while(acomp!=0){
            int acum=0;
            Nodo a=poli1;
            Nodo b=poli2;
            int ver=0;
            boolean pass=false;
            boolean pass2=false;
            while(ver<2) {
                if(!pass){
                    if(a!=null){
                        if(vpolinomio[d]==a.poli.getExponente()){
                            acum+=a.poli.getCoeficiente();
                        }
                        a=a.siguiente;
                    }else{ ver++; pass=true;
                    }
                }
                if(!pass2){
                    if(b!=null){
                        if(vpolinomio[d]==b.poli.getExponente()){
                            acum+=b.poli.getCoeficiente();
                        }b=b.siguiente;
                    }else{ ver++;pass2=true;
                    }
                }
            }
            if(acomp!=0){
                if(d==0){
                    if(vpolinomio[d]!=-1 && acum>0 ){
                        System.out.print(acum+" X ^ "+ vpolinomio[d]+"    ");
                    }else
                    if(acum<0 && vpolinomio[d]!=-1){
                        System.out.print(acum+" X ^ "+ vpolinomio[d]+"    ");
                    }if(vpolinomio[d]==-1)
                        System.out.print(acum+"    ");
                }	else
                if(d>0){
                    if(vpolinomio[d]!=-1 && acum>0 )
                        System.out.print(" + "+acum+" X ^ "+ vpolinomio[d]+"    ");
                    else
                    if(acum<0 && vpolinomio[d]!=-1)
                        System.out.print(acum+" X ^ "+ vpolinomio[d]+"    ");
                    if(vpolinomio[d]==-1 && acum>0)
                        System.out.print(" + "+acum+"    ");
                    else
                    if(vpolinomio[d]==-1 && acum<0)
                        System.out.print(acum+"    ");
                } }
            d++;
            acomp--;
        } }
    static void ordBurbuja (int a[], int n) {
        boolean interruptor = true;
        for (int pasada = 0; pasada < n-1 && interruptor; pasada++){
            interruptor = false;
            for (int j = 0; j < n-pasada -1; j++)
                if(a[j] < a[j+1]) {
                    int aux;
                    interruptor = true;
                    aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                }
            }
        }
    }
