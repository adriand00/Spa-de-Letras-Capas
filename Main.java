
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
    UI.impSopa();
    UI.impLista8();
    UI.impPlayZone();
    /* Admin Tools */
    UI.impCheckTable();
    UI.impLocations();
    }// fin main
  }//fin main

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
    /* Rutina para inicializar el menu */
    int user_select = 0; // Variable para detectar lo que el usuario seleccione
    int user_already_init = 0; // Variable para detectar si el usuario ya CONFIG antes de JUGAR
    String user_input_word = ""; // Variable para almacenar las palabras que el usuario ingrese
    
    while (user_already_init == 0) {
      if (user_select == 1) { // INGRESO DE PALABRAS que solamente se da si el usuario selecciona CONFIG
        for (int i = 0; i < CL.palabras20.length; i++) {
          clearScreen();
          System.out.println("----------------------------");
          System.out.println("ʕ •ᴥ•ʔ Ingrese 20 palabras ʕ •ᴥ•ʔ");
          System.out.println("ʕ •ᴥ•ʔ no mas de 12 caracteres por palabraʕ •ᴥ•ʔ");
          System.out.println("----------------------------");
          System.out.println("Palabra " + (i + 1) + " de 20");
          CL.palabras20[i] = in.next();
          if (CL.palabras20[i].length() > 12) {
            i -= 1;} // el conteo no continua si se inserta una palabra de mas de 12 chars
          clearScreen();
        }
        user_already_init = 1; // Declarar que el usuario ya CONFIG las 20 palabras
      } // fin INGRESO DE PALABRAS
      System.out.println("ʕ •ᴥ•ʔ SPA DE LETRAS 3000 ʕ •ᴥ•ʔ");
      System.out.println("------------------");
      System.out.println("ʕ •ᴥ•ʔ ( 1 )  Configurar Juego");
      System.out.println("ʕ •ᴥ•ʔ ( 2 )  Inicializar Juego");
      System.out.println("* debes configurar el juego antes de comenzar");
      System.out.println("------------------");
      System.out.print("ʕ •ᴥ•ʔ Digite su seleccion presione ENTER: ( ");

      while ( !non_error ) {      
       try {user_select = in.nextInt(); non_error = true;} 
       catch (Exception  ex )
       {System.out.println("Opcion Invalida" ); String borrar_entrada = in.next();}
       }    
      
     if (user_select == 1 && user_already_init == 1) {// Permite al usuario reCONFIG el juego
     user_already_init = 0;} // seteando user_already_init en 0 
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
    int x = 0;
    // Imprime palabras8 en 2 columnas
    for (int i = 0; i < CL.palabras8.length; i++) {
      x = i + 1;
      System.out.print(x + "-) " + CL.palabras8[i] + "  ");
      if (x % 2 == 0)
      {System.out.println();}
     }
   }// fin impLista8
  public static void impPlayZone() {
    System.out.println();
    String test_var = "A1-E1"; // ESTA VARIABLE NO DEBE QUEDAR EN LA VERSION FINAL
    String user_guess = " "; // lee el bateo del cliente
    System.out.println("Digita las coordenadas donde la");
    System.out.println("palabra empieza y donde termina");
    System.out.println("(ejemplo: " + test_var + ")");
    user_guess = in.next(); // lee el bateo del cliente
    if (test_var.equalsIgnoreCase(user_guess)) // compara el bateo con location_table, pero esta INCOMPLETO el codigo
    {
      System.out.println("yes");
    } else {
      System.out.println("no");
    }
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