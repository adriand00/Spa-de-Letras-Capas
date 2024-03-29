
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
  /* Admin Tools */
   UI.impCheckTable();
   UI.impLocations();
  /*             */
   }// fin main
}// fin main

class UI {
  
  /*Variables Globales*/
  public static Scanner in = new Scanner(System.in);
  public static boolean non_error = false;// Var para detectar errores
  public static int inputINT = 0;// Var para seleccion de usuario
  public static String inputSTR = "";// Var para datos de usuario
  public static int user_won = 0;//Var si el usuario gano
  
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
   } //fin char N
   if (pf_type == 't') {
     while ( !non_error ) {      
       try {inputSTR = in.next(); non_error = true;} 
       catch (Exception  ex )
       {System.out.println("Opcion Invalida" ); 
        String borrar_entrada = in.next();}
       }    
       non_error = false;
   } //fin char t
    } 
  public static void menu() {
    // Variable para detectar si el usuario ya CONFIG
    boolean user_already_CONFIG = false; 
    //Menu
    while (user_already_CONFIG = false) {
     // INGRESO DE PALABRAS (if User select 1)
      if (inputINT == 1) { 
        for (int i = 0; i < CapaLogica.palabras20.length; i++) {
          clearScreen();
          System.out.println("----------------------------");
          System.out.println("Ingrese 20 palabras");
          System.out.println("(*)No mas de 12 caracteres por palabra");
          System.out.println("----------------------------");
          System.out.println("Palabra " + (i + 1) + " de 20");
          user_Input('t');
          inputSTR.toLowerCase();
          CapaLogica.palabras20[i] = inputSTR;
          if (CapaLogica.palabras20[i].length() > 12) {
            i -= 1;} // No avanzar con palabras de mas de 12 chars
          clearScreen();
         }
        user_already_CONFIG = true; // Declarar que el usuario ya CONFIG las 20 palabras
      } // fin INGRESO DE PALABRAS
      // MENU PRINCIPAL
      System.out.println("ʕ •ᴥ•ʔ SPA DE LETRAS 3000 ʕ •ᴥ•ʔ");
      System.out.println("-----------------------");
      System.out.println("( 1 )  Configurar Juego");
      System.out.println("( 2 )  Inicializar Juego");
      System.out.println("*Configura el juego antes de comenzar");
      System.out.println("-----------------------");
      System.out.print("Digite el numero y presione ENTER: ");

      user_Input('n'); //Leer opcion de usuario

      if (inputINT == 2 && user_already_CONFIG == true) { //User ya CONFIG y select 2
      clearScreen(); break;} //Permite al usuario continuar 
      
      if (inputINT == 1 && user_already_CONFIG == true) {// User ya CONFIG y select 1 
      user_already_CONFIG = false;} // Permite al usuario reCONFIG
      clearScreen();
     } // fin de while 
   }// fin menu
  public static void jugar() {
    do {
     impSopa();
     impLista8();
     impPlayZone();
     }
     while (user_won <= 8);
   }
  public static void impSopa() {
    clearScreen();
    // Imprimir un titulo para que el usuario ubique palabras
    System.out.print("   A B C D E F G H I J K L"); 
    System.out.println();
    //SPA
    for (int i = 0; i < CapaLogica.spa.length; i++) {
      //Agrega numeros al inicio de cada fila
      if (i >= 9) {System.out.print((i + 1) + " ");} else {System.out.print(" " + (i + 1) + " ");} 
      //Imprime fila horizontal
      for (int j = 0; j < CapaLogica.spa.length; j++) {
        System.out.print(CapaLogica.spa[i][j] + " ");}
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
    int x = 0;
    // Imprime palabras8 en 2 columnas
    for (int i = 0; i < CapaLogica.palabras8.length; i++) {
      x = i + 1;
      System.out.print(x + "-) " + CapaLogica.palabras8[i] + "  ");
      if (x % 2 == 0)
      {System.out.println();}
    }
   }// fin impLista8

  public static void impPlayZone() {
    System.out.println();
    System.out.println("Digita las coordenadas donde la");
    System.out.println("palabra empieza y donde termina");
    System.out.println("(ejemplo: ");
    
    user_Input('t');
   
    for (int i = 0; i < CapaLogica.palabras8.length; i++)
     if (inputSTR.equalsIgnoreCase(CapaLogica.palabras8[i]))
     {CapaLogica.palabras8[i].toUpperCase(); user_won += 1;}
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
    for (int i = 0; i < CapaLogica.check.length; i++) {
      for (int j = 0; j < CapaLogica.check.length; j++) {
        System.out.print(CapaLogica.check[i][j] + " ");
      }
      System.out.println();
    }
   }// fin impCheckTable

  public static void impLocations() {
    System.out.println();
    for (int i = 0; i < CapaLogica.locations_table.length; i++) {
      System.out.print(CapaLogica.locations_table[i] + " ");
    }
   }// fin impLocations
} // fin CapaUI