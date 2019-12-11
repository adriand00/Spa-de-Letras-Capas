class CL {
/*         Variables Publicas        */
 //palabra actualmente siendo localizada
 public static int current_word = 1;
 //cantidad de palabras diagonales generadas
 public static int diag_word = 0;
 // direccion de la palaba 0-4
 public static int direccion;
 // Var para enteros temporales
 public static int tempINT = 0;
 // Var para strings temporales 
 public static String tempSTR = " ";

/*    Variables Publicas Arreglos    */
 //lista de 20 palabras del usuario
 public static String[] palabras20 = new String[20];
 //lista con 8 numeros random
 public static int[] listarandom8 = new int[9];
 //lista con 8 palabras random      
 public static String[] palabras8 = new String[8];
 //tabla de spa    
 public static String[][] spa = new String[12][12]; 
 //tabla de campos vacios(0) o llenos (1) 
 public static void crearCheck() {
   int[][] check = new int[12][12];
   for(int i = 0; i < check.length; i++) {
     for(int j = 0; j < check.length; j++)
     { check[i][j] = 0; }
     } 
   } // fin :D crearCheck
 
 //tabla de respuestas
 public static String[] locations_table = new String[8];
 // tabla de direcciones
 public static String[][] address_table = { 
    {"A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1", "I1", "J1", "K1", "L1"}, 
    {"A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2", "I2", "J2", "K2", "L2"}, 
    {"A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3", "I3", "J3", "K3", "L3"}, 
    {"A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4", "I4", "J4", "K4", "L4"}, 
    {"A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5", "I5", "J5", "K5", "L5"}, 
    {"A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6", "I6", "J6", "K6", "L6"}, 
    {"A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7", "I7", "J7", "K7", "L7"}, 
    {"A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8", "I8", "J8", "K8", "L8"}, 
     {"A9", "B9", "C9", "D9", "E9", "F9", "G9", "H9", "I9", "J9", "K9", "L9"}, 
    {"A10","B10","C10","D10","E10","F10","G10","H10","I10","J10","K10","L10"},
    {"A11","B11","C11","D11","E11","F11","G11","H11","I11","J11","K11","L11"}, 
    {"A12","B12","C12","D12","E12","F12","G12","H12","I12","J12","K12","L12"}};

/*              Rutinas             */
 public static void crearListaNumerosRandom() {
   //establecer un valor random entre 0 y 20
   tempINT = (int) (Math.random() * 20); 
   // bandera para salir de loop cuando sea true
   boolean random_done = false; 

   //loop para editar cada indx de listarandom8
   for (int i = 0; i < listarandom8.length; i++) { 
     //regenerar numero aleatorio
     tempINT = (int) (Math.random() * 20); 
     do { // loop para chequear que el numero no sea repetido
       for (int j = 0; j < listarandom8.length; j++) { 
       // Si el indx es igual al random_ind, vuelve a randomizar el numero 
       if (listarandom8[j] == tempINT)
       {tempINT=(int)(Math.random()*20); j = 0; 
       } else {
       // Activa bandera y sale del loop
       random_done = true;}}   
       } while (random_done = false); // sale del loop x2
     //Almacenar el numero, luego de verificar que no se repita
     listarandom8[i] = tempINT;
     }// fin for loop     
   }// fin crear8NumerosRandom
 public static void crearPalabras8() {
   for (int i = 0 ; i < palabras8.length; i++) {
     // tempINT igual al valor almacenado en listarandom8 (saltandose index 0)
     tempINT = listarandom8[i + 1]; 
     // tempSTR igual al string almacenado en palabras20, acorde a index tempINT
     tempSTR = palabras20[tempINT]; 
     // se almacena la palabra "tempSTR", tomada aleatoriamente de palabras20
     palabras8[i] = tempSTR; 
     } 
  }//fin crearPalabras8
 public static void rellenarSopa() {
   //String letras = "abcdefghijklmnñopqrstuvwxyz";
   String letras = "---------------------------"; //ADMIN TOOL
   for (int i = 0; i < spa.length; i++) {//-----*navegar por  *
     for (int j = 0; j < spa.length; j++) {//---*toda la tabla*
     int M = (int)(Math.random()*27); //variable temporal para almacenar un entero random
     spa[i][j] =  Character.toString(letras.charAt(M));} //posiciona una letra de "letras" en la sopa
     }
   for (int i = 0; i < palabras8.length; i++) {
   ubicar_palabra(palabras8[i]);
   palabras8[i] += " "+direccion+" "; // ADMIN TOOL
   }
   }//fin rellenarSopa
 public static void ubicar_palabra(String pf_palabra) { 
 int Xstart; int Ystart; 
 int Xlimit; int Ylimit;
 int Xweight = 0; int Yweight = 0;
 int largo = pf_palabra.length();
  
 // Solo palabras mas pequeñas que 7 van a ser diagonizables
 if (largo >= 7 || diag_word >= 2)
   {direccion = (int)(Math.random()*3);}
   else
   {direccion = (int)(Math.random()*4); diag_word += 1;} 
 
 // Definir pesos deacuerdo a var direccion
 switch (direccion) {
   case 0: // (0)izq-der 
     Xweight = 1;
     Yweight = 0;
     break;
   case 1: // (1)der-izq 
     Xweight = -1;
     Yweight = 0;
     break;
   case 2: // (2)arr-abj 
     Xweight = 0;
     Yweight = 1;
     break;
   case 3: // (3)abj-arr 
     Xweight = 0;
     Yweight = -1;
     break;
   case 4: // (4)diagonal SurEste
     Xweight = 1;
     Yweight = 1;
     break;
   default:
     UI.error(1);
     break;
   }
 /* Setear limites de borde, en base a la direccion en que sera escrita la palabra */
 Xlimit = (Xweight >= 0) ? 11 - (largo * Xweight) : largo; //1 > 6
 Ylimit = (Yweight >= 0) ? 11 - (largo * Yweight) : largo; //0 > 11

 /* Seteat punto inicial de palabra, teniendo en consideracion los limites Y direccion */
 // Calculo de Xlimit
 if (Xweight == 0) {Xlimit = (int)(Math.random()*11);}
 if (Xweight == 1) {Xlimit = (int)(Math.random()*(11-largo)) + 1;}  
 if (Xweight == -1) {Xlimit = largo-1;} 

 // Calculo de Ylimit
 if (Yweight == 0) {Ylimit = (int)(Math.random()*11);}
 if (Yweight == 1) {Ylimit = (int)(Math.random()*(12-largo))+1;}
 if (Yweight == -1) {Ylimit = largo-1;} 
 
 // Calculo de Xstart
 if (Xweight == 0) {Xstart = (int)(Math.random()*11);}
 if (Xweight == 1) {Xstart = (int)(Math.random()*Xlimit);}
 if (Xweight == -1) {Xstart = Xlimit + (Math.random()*(11-largo));}

 // Calculo de Ystart
 if (Yweight == 0) {Ystart = (int)(Math.random()*11);}
 if (Yweight == 1) {Ystart = (int)(Math.random()*Ylimit);}
 if (Yweight == -1) {Ystart = Ylimit + (Math.random()*(11-largo));}
 
 /* Chequear donde hay espacio disponible para localizar la palabra */
 tempINT = 0; //variable para llevar conteo
 int Repetir = 1; //bandera para romper ciclo
 while (Repetir == 1) {
   for (int i = 0; i < largo; i++) 
    {tempINT += (Xweight >= 0) ? check[Ystart + (i * Yweight)][Xstart + (i * Xweight)] : check[Ystart - (i * Yweight)][Xstart - (i * Xweight)] ;}
   if (tempINT > 0) { //Si la suma de espacios es mayor a 0 = espacions ocupados, es necesario re-posioncion
      Xstart = (Xweight >= 0) ? (int)(Math.random()*Xlimit) : (int)(Math.random()*(10-largo)) + (Xlimit);
      Ystart = (Yweight >= 0) ? (int)(Math.random()*Ylimit) : (int)(Math.random()*(10-largo)) + (Ylimit); 
     tempINT = 0;
     }else{
     Repetir = 0;}
   }
 /*Una vez encotrados los campos*/
 for (int i = 0; i < largo; i++) {
   //que no hayan unos()!!!!!!!!
   check[Ystart + (i * Yweight)][Xstart + (i * Xweight)] = current_word;//Rellenar check_table con los nuevos espacios ocupados
   spa[Ystart + (i * Yweight)][Xstart + (i * Xweight)] = Character.toString(pf_palabra.charAt(i));//Rellenar spa
   if (i == 0) // Guardar la posicion inicial de la palabra
     {locations_table[current_word] = address_table[Ystart][Xstart];}
   if (i == (largo-1)) //Guardar la posicion final de la palabra 
     {locations_table[current_word] +="-" + address_table[Ystart + (i * Yweight)][Xstart + (i * Xweight)];}
   }

   current_word += 1 ;

 } //fin ubicar_palabra
 public static void generarCordenadas() {
   // Calculo de Xstart
   if (Xweight == 0) {Xstart = (int)(Math.random()*11);}
   if (Xweight == 1) {Xstart = (int)(Math.random()*Xlimit);}
   if (Xweight == -1) {Xstart = Xlimit + (Math.random()*(11-largo));}

   // Calculo de Ystart
   if (Yweight == 0) {Ystart = (int)(Math.random()*11);}
   if (Yweight == 1) {Ystart = (int)(Math.random()*Ylimit);}
   if (Yweight == -1) {Ystart = Ylimit + (Math.random()*(11-largo));}
 } // fin generarCoordenadas()
}// fin CapaLogica