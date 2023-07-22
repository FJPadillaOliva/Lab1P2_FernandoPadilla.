
package lab1p2_fernandopadilla;

import java.util.Scanner;


public class Lab1P2_FernandoPadilla {

static Scanner read = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("------------MENU------------\n"
                    + "1)Aproximacion de ceros\n"
                    + "2)Serie de Taylor\n"
                    + "3)Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = read.nextInt();
            switch(opcion){
                case 1:
                    int a = 0;
                    int b = 0;
                    int c = 0;
                    int iteraciones = 100;
                    int desp = 200;
                    while(a==0){
                      System.out.println("Ingrese el valor de a: ");
                      a = read.nextInt();
                        if (a==0) {
                            System.out.println("El valor de a no puede ser 0");
                        }
                    }
                    System.out.println("Ingrese el valor de b: ");
                    b = read.nextInt();
                    System.out.println("Igrese el valor de c: ");
                    c = read.nextInt();
                    double[] respuesta = metodoP(a, b, c, desp, iteraciones);
                    System.out.println("Raiz 1: "+ respuesta[0]);
                    System.out.println("Raiz 2: "+ respuesta[1]);
                    System.out.println("Iteraciones: "+iteraciones);
                    break;
                case 2:
                    double numero = 0;
                    int limite = 0;
                    double resultado = 0;
                    System.out.println("Ingrese el numero a evaluar: ");
                    numero = read.nextInt();
                    System.out.println("Ingrese el limite de la sumatoria: ");
                    limite = read.nextInt();
                    System.out.println("El seno de " + numero +" es de: "+sen(numero, limite, 0));
                    System.out.println("El coseno de "+ numero + " es de : "+cos(numero, limite, 0));
                    if (numero < 90) {
                        System.out.println("El tangente de "+ numero + " es de : "+tan(numero, limite, 1,resultado));
                    }else{
                        System.out.println("La operacion para tangente no es valida");
                    }
                    break;
                case 3:
                    opcion = 3;
                    break;
                default :
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion!=3);
    }
    
    public static double f(double x,int a, int b,int c){
        return a * Math.pow(x, 2) + b * x + c;
    }
    
    public static double fprima(double x,int a, int b){
        return 2 * a * x + b;
    }
    
    public static double[] vertices(int a, int b, int c){
        double verticeX = -(b) / (2 * a);
        double verticeY = f((int)verticeX, a, b, c);
        return new double[]{verticeX,verticeY};
    }
    
    public static double[] metodoP(int a, int b, int c, int desplazamiento, int iteraciones){
        double[] vertices = vertices(a, b, c);
        double x0D = vertices[0] + desplazamiento;
        double x0I = vertices[0] - desplazamiento;
        double raizD = newtonRaphson(a, b, c, (int)x0D, iteraciones);
        double raizI = newtonRaphson(a, b, c, (int)x0I, iteraciones);
        return new double[]{raizI,raizD};
    }
    
    
    public static double newtonRaphson(int a, int b, int c, double x,int iteraciones){
        if (iteraciones == 0) {
            return x;
        }else{
            double funcion = f(x, a, b, c);
            double funcionp = fprima(x, a, b);
            double funcionN = x - (funcion/funcionp);
            return newtonRaphson(a, b, c, funcionN, iteraciones-1);
        }
    }
    
    public static double sen(double numero,int limite, int contador){
        if (contador == limite) {
            double num = Math.pow(-1, contador);
            double denom = ((2*numero)+1);
            double denomF = 1;
            for (int i = 1; i <= denom; i++) {
                denomF*=i;
            }
            double parteF = Math.pow(num, (2*contador)+1);
            double resultado = (num/denomF)*parteF;
            return resultado;
        }else{
            double num = Math.pow(-1, contador);
            double denom = ((2*numero)+1);
            double denomF = 1;
            for (int i = 1; i <= denom; i++) {
                denomF*=i;
            }
            double parteF = Math.pow(num, (2*contador)+1);
            double resultado = (num/denomF)*parteF;
            return resultado+sen(numero, limite, contador+1);
        }
    }
    
    public static double cos(double numero,int limite, int contador){
        if (contador == limite) {
            double num = Math.pow(-1, contador);
            double denom = 2*contador;
            double denomF = 1;
            for (int i = 1; i <= denom; i++) {
                denomF *=i; 
            }
            double parteF = Math.pow(num, 2*contador);
            double resultado = (num/denomF)*parteF;
            return resultado;
        }else{
            double num = Math.pow(-1, contador);
            double denom = 2*contador;
            double denomF = 1;
            for (int i = 1; i <= denom; i++) {
                denomF *=i; 
            }
            double parteF = Math.pow(num, 2*contador);
            double resultado = (num/denomF)*parteF;
            return resultado + cos(numero, limite, contador+1);
        }
    }
    
    public static double tan(double numero,int limite, int contador,double resultado){
        double m = (3.1416/2);
        if (contador == limite) {
            if (resultado>m) {
                resultado = 0;
                return resultado;
            }else{
                double num = Math.pow(2, contador)*(Math.pow(-4, contador))*(1-Math.pow(4, contador));
                double denom = 2*contador;
                double denomF = 0;
                for (int i = 1; i <= denom; i++) {
                denomF *=i;
                }
                double parteF = Math.pow(num, 2*contador-1);
                resultado = (num/denomF)*parteF;
                return resultado;
            }
        }else{
            double num = Math.pow(2, contador)*(Math.pow(-4, contador))*(1-Math.pow(4, contador));
            double denom = 2*contador;
            double denomF = 0;
            for (int i = 1; i <= denom; i++) {
                denomF *=i;
            }
            double parteF = Math.pow(num, 2*contador-1);
            resultado = (num/denomF)*parteF;
            return resultado + tan(numero, limite, contador+1,resultado);
        }
        
    }
}
