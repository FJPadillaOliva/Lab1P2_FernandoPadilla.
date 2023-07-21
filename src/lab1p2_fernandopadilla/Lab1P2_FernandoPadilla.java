
package lab1p2_fernandopadilla;

import java.util.Scanner;


public class Lab1P2_FernandoPadilla {

static Scanner read = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("------------MENU------------\n"
                    + "1)Ejercicio 1\n"
                    + "2)Ejercicio 2\n"
                    + "3)Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = read.nextInt();
            switch(opcion){
                case 1:
                    int a = 0;
                    int b = 0;
                    int c = 0;
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
                    break;
                case 2:
                    double numero = 0;
                    int limite = 0;
                    System.out.println("Ingrese el numero a evaluar: ");
                    numero = read.nextInt();
                    System.out.println("Ingrese el limite de la sumatoria: ");
                    limite = read.nextInt();
                    double tan = tan(numero,limite,1);
                    System.out.println("El seno de " + numero +" es de: "+sen(numero, limite, 0));
                    System.out.println("El coseno de "+ numero + " es de : "+cos(numero, limite, opcion));
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
    
    public static int newtonRaphson(int a, int b, int c, int desp){
        return 1;
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
            for (int i = 1; i < denom; i++) {
                denomF *=i; 
            }
            double parteF = Math.pow(num, 2*contador);
            double resultado = (num/denomF)*parteF;
            return resultado;
        }else{
            double num = Math.pow(-1, contador);
            double denom = 2*contador;
            double denomF = 1;
            for (int i = 1; i < denom; i++) {
                denomF *=i; 
            }
            double parteF = Math.pow(num, 2*contador);
            double resultado = (num/denomF)*parteF;
            return resultado + cos(numero, limite, contador+1);
        }
    }
    
    public static double tan(double numero,int limite, int contador){
        return 1;
    }
}
