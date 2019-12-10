
/*
* Nombre del programa--- Spa De Letras
* Descripción----------- Proyecto de Sopa de Letras
* Fecha de creación----- 24 Sep 2019
* Autor----------------- Alonso Maria Jose ʕ •ᴥ•ʔ / Murillo Adrian =OwO=
* Fecha de modificación- 
* Modificado por-------- 
*/
import java.util.*;

class Main {
  public static void main(String[] arg) {
    UI.menu();
    CL.crearListaNumerosRandom();
    CL.crearPalabras8();
    CL.rellenarSopa();
    UI.jugar();
    }// fin main
  }//fin main

class UI {
/*Variables Globales*/
   public static Scanner in = new Scanner(System.in);
   // Var para detectar errores
   public static boolean non_error = false;
   // Var para seleccion de usuario
   public static int inputINT = 0;
   // Var para datos de usuario
   public static String inputSTR = "";
   // Var si el usuario gano
   public static int user_won = 0;

/* Rutinas */
 public static void clearScreen() {
      /* Esta rutina limpia todo el texto de la consola */
      System.out.print("\033[H\033[2J");
      System.out.flush();
      }// fin clear screen
 public static void user_Input(char pf_type){
      if (pf_type == 'n') {
       while ( !non_error ) {      
         try {inputINT = in.nextInt(); non_error = true;} 
         catch (Exception  ex )
         {System.out.println("Opcion Invalida - Utilice numeros: " ); 
         String borrar_entrada = in.next();}
         }    
       non_error = false;
       } else {
       while ( !non_error ) {      
         try {inputSTR = in.next(); non_error = true;} 
         catch (Exception  ex )
         {System.out.println("Opcion Invalida" ); 
         String borrar_entrada = in.next();}
         }    
       non_error = false;
     } // fin char t
    }// Fin user_Input
 public static void menu() {
     // Variable para detectar si el usuario ya CONFIG
     boolean user_already_CONFIG = false;  
     //Menu 
     while (user_already_CONFIG == false) {
       //Submenu INGRESO DE PALABRAS
       if (inputINT == 1) { 
         for (int i = 0; i < CL.palabras20.length; i++) {
           clearScreen();
           System.out.println("------------------------");;
           System.out.println("Ingrese una palabra que");
           System.out.println("no supere 12 caracteres");
           System.out.println("------------------------");;
           System.out.print("Palabra " + (i + 1) + " de 20 >> ");
           // Pide Palabra
           user_Input('t');
           // Revisa que no sea mayor de 12 chars
           if (inputSTR.length() > 12) {i -= 1;}
           // La guarda en minusculas 
           CL.palabras20[i] = inputSTR.toLowerCase();
           clearScreen();
           }
         user_already_CONFIG = true;
         } // fin INGRESO DE PALABRAS
       // Menu Principal
       System.out.println("   SPA DE LETRAS 3000   ");
       System.out.println("------------------------");
       System.out.println("Configurar Juego   ( 1 )");
       System.out.println("Inicializar Juego  ( 2 )");
       System.out.println("* No inicies sin configurar");
       System.out.println("------------------------");
       System.out.print("Digite su seleccion >> ");
       // Leer seleccion de usuario
       user_Input('n');
       // Permite al usuario CONFIG luego de haber CONFIG 
       if (inputINT == 1 && user_already_CONFIG == true) {
         user_already_CONFIG = false;} 
       clearScreen();
       } // fin de while
     }// fin menu()
 public static void jugar() {
     do {
      impSopa();
      impLista8();
      impPlayZone(); }
      while (user_won <= 8);
     }//fin jugar
 public static void impSopa() {
    clearScreen();
    // Imprimir una titulo para que el usuario ubique palabras
    System.out.print("   A B C D E F G H I J K L"); 
    System.out.println();
    //SPA
    for (int i = 0; i < CL.spa.length; i++) { 
      //Agrega numeros al inicio de cada fila
      if (i >= 9) {System.out.print((i + 1) + " ");}else{System.out.print(" " + (i+1) + " ");}
      //Imprime fila horizontal
      for (int j = 0; j < CL.spa.length; j++) {
        System.out.print(CL.spa[i][j] + " ");}
      //Agrega numeros al final de cada fila
      System.out.print(i + 1);
      System.out.println();
    }
    //Imprimir un subtitulo para que el usuario ubique palabras
    System.out.println("   A B C D E F G H I J K L");
    System.out.println("=============================");
    }// fin impSopa

 public static void impLista8() {
     System.out.println("Encuentra estas palabras:");
     CL.tempINT = 0;
     // Imprime palabras8 en 2 columnas
     for (int i = 0; i < CL.palabras8.length; i++) {
       CL.tempINT = i + 1;
       System.out.print(CL.tempINT + "-) " + CL.palabras8[i] + "  ");
       if (CL.tempINT % 2 == 0)
       {System.out.println();}
       }
     CL.tempINT = 0;
     }// fin impLista8
 public static void impPlayZone() {
     System.out.println();
     System.out.println("Digita las coordenadas donde la");
     System.out.println("palabra empieza y donde termina.");
     System.out.print("Ejemplo: A1-E12 >> ");
     //Leer guess del usuario
     user_Input('t');
     // Ver si el guess de usuario esta en locations_table
     for (int i = 0; i < CL.palabras8.length; i++)
       if (inputSTR.equalsIgnoreCase(CL.locations_table[i]))
       {CL.palabras8[i] = CL.palabras8[i].toUpperCase(); user_won += 1;}
   }// fin impPlayZone
/* Admin Tools */
  public static void error(int pf_Ecode) {
    switch (pf_Ecode) {
    case 1:
      System.out.println("Switch Direccion : Case out of bounds");
      break;
    default:
      System.out.println("Error Desconocido");
      break;
    }
   }// fin error

  public static void impCheckTable() {
    System.out.println();
    for (int i = 0; i < CL.check.length; i++) {
      for (int j = 0; j < CL.check.length; j++) {
        System.out.print(CL.check[i][j] + " ");
      }
      System.out.println();
    }
   }// fin impCheckTable

  public static void impLocations() {
    System.out.println();
    for (int i = 0; i < CL.locations_table.length; i++) {
      System.out.print(CL.locations_table[i] + " ");
    }
   }// fin impLocations
} // fin CapaUI