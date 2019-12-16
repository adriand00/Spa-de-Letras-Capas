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
 // Var relativas a X
 public static int Xstart = 0;
 public static int Xweight = 0;
 public static int Xlimit = 0;
 // Var relativas a Y
 public static int Ystart = 0;
 public static int Yweight = 0;
 public static int Ylimit = 0;
 // Var largo de palabra
 public static int largo = 0;
/*    Variables Publicas Arreglos    */
 //lista de 20 palabras del usuario
 public static String[] palabras20 = new String[20];
 //lista con 8 numeros random
 public static int[] listarandom8 = new int[9];
 //lista con 8 palabras random      
 public static String[] palabras8 = new String[8];
 //tabla de spa    
 public static String[][] spa = new String[12][12]; 
 //tabla de respuestas
 public static String[] locations_table = new String[8];
 //tabla de campos vacios(0) o llenos (1) 
 public static int[][] check = { 
    {0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,0,0,0,0,0,0,0,0}, 
    {0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0}}; 
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
     int M = (int)(Math.random()*27); // variable temporal para almacenar un entero random
     spa[i][j] =  Character.toString(letras.charAt(M));} //posiciona una letra de "letras" en la sopa
     }
   for (int i = 0; i < palabras8.length; i++) {
   ubicar_palabra(palabras8[i]);
   palabras8[i] += " "+direccion+" "; // ADMIN TOOL
   }
   }//fin rellenarSopa
 public static void ubicar_palabra(String pf_palabra) { 
   largo = pf_palabra.length();
  
   // Solo palabras mas pequeñas que 7 van a ser diagonizables
   if (largo >= 7 || diag_word > 2)
     {direccion = (int)(Math.random()*3);}
     else
     {direccion = (int)(Math.random()*3) + 2; diag_word += 1;} 
 
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
   case 5: // (5)diagonal SurEste
     Xweight = 1;
     Yweight = 1;
     break;
   }
   // Calculo de limites, en base a la direccion en que sera escrita la palabra 
   // Calculo de Xlimit
   if (Xweight == 0) {Xlimit = (int)(Math.random()*11);}
   if (Xweight == 1) {Xlimit = (int)(Math.random()*(11-largo)) + 1;}  
   if (Xweight == -1) {Xlimit = largo-1;} 

   // Calculo de Ylimit
   if (Yweight == 0) {Ylimit = (int)(Math.random()*11);}
   if (Yweight == 1) {Ylimit = (int)(Math.random()*(12-largo))+1;}
   if (Yweight == -1) {Ylimit = largo-1;} 
 
   // Calculo de comienzo de palabra, en un rango dentro del limite
   generarCordenadas();
 
   // Chequear donde haya espacio disponible para localizar la palabra
   tempINT = 0;      //var para llevar suma acarreada de espacios
   int Repetir = 1;  // bandera para romper ciclo
   do { // Checar por adelantado los espacios que ocupara la palabra, y ver si estan vacios
     for (int i = 0; i < largo; i++) {
      int iXweight = i * Math.abs(Xweight);
      int iYweight = i * Math.abs(Yweight); 
      // Ver en que direccion debe hacer la suma
      if (Xweight < 0 || Yweight < 0) {  
      if (check[Ystart - iYweight][Xstart - iXweight] == 0); 
      }else{
      tempINT += check[Ystart + iYweight][Xstart + Xweight] ;} 
     }
     // Si tempINT > 0 = espacions ocupados, es necesario regenerar coordenadas
     if (tempINT > 0) { 
       palabras8[current_word - 1] += tempINT + ">"; generarCordenadas(); Repetir = 1; tempINT = 0;
       } else {
       palabras8[current_word - 1] += tempINT + "<"; tempINT = 0; Repetir = 0;} // Si no, pos romper el ciclo
     } while (Repetir == 1) // fin while

   //Una vez encotrados los campos, rellenarlos
   for (int i = 0; i < largo; i++) {
     int iXweight = i * Math.abs(Xweight);
     int iYweight = i * Math.abs(Yweight);
     if (Xweight < 0 || Yweight < 0) { 
       // Rellenar check con los nuevos espacios ocupados
       // Rellenar sopa con las letras de la palabra
       check[Ystart - iYweight][Xstart - iXweight] = current_word;
       spa[Ystart - iYweight][Xstart - iXweight] = Character.toString(pf_palabra.charAt(i));
       if (i == 0) // Guardar la posicion inicial de la palabra
       {locations_table[current_word - 1] = address_table[Ystart][Xstart];}
       if (i == (largo-1)) // Guardar la posicion final de la palabra 
       {locations_table[current_word - 1] += address_table[Ystart - iYweight][Xstart - iXweight];}
     } else {
       // Rellenar check con los nuevos espacios ocupados
       // Rellenar sopa con las letras de la palabra
       check[Ystart + iYweight][Xstart + iXweight] = current_word;
       spa[Ystart + iYweight][Xstart + iXweight] = Character.toString(pf_palabra.charAt(i));
       if (i == 0) // Guardar la posicion inicial de la palabra
       {locations_table[current_word - 1] = address_table[Ystart][Xstart];}
       if (i == (largo-1)) // Guardar la posicion final de la palabra 
       {locations_table[current_word - 1] += address_table[Ystart + iYweight][Xstart + iXweight];}
     } } // Fin loop
     // Sumar que una palabra ya fue completada
   current_word += 1 ;
   } //fin ubicar_palabra
 public static void generarCordenadas() {
   // Calculo de Xstart
   if (Xweight == 0) {Xstart = (int)(Math.random()*11);}
   if (Xweight == 1) {Xstart = (int)(Math.random()*Xlimit);}
   if (Xweight == -1) {Xstart = Xlimit + (int)(Math.random()*(11-largo));}

   // Calculo de Ystart
   if (Yweight == 0) {Ystart = (int)(Math.random()*11);}
   if (Yweight == 1) {Ystart = (int)(Math.random()*Ylimit);}
   if (Yweight == -1) {Ystart = Ylimit + (int)(Math.random()*(11-largo));}
   } // fin generarCoordenadas()
 public static void checarbateo() {
   for (int x = 0; x < palabras8.length; x++) {
     if ( UI.inputSTR.equalsIgnoreCase(locations_table[x]) ) {
       palabras8[x] = palabras8[x].toUpperCase(); 
       locations_table[x] = "n/a";
       for (int i = 0; i < check.length; i++) {
         for (int j = 0; j < check.length; j++) {
           if (check[i][j] == x+1) {spa[i][j] = spa[i][j].toUpperCase();}}
         } // fin pasar a mayus en spa

       UI.user_won += 1;
       } // fin checar variables
     } // fin revisar lista
   }// fin pasarmayus()
}// fin CapaLogica