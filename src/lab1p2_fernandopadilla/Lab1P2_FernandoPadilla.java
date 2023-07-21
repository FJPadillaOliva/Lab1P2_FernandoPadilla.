
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
            opcion = read.nextInt();
            switch(opcion){
                case 1:
                    
                    break;
                case 2:
                    
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
    
}
