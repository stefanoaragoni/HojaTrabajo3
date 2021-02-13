/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Main.java 
* Autor: Stefano Aragoni 20261, Marco Jurado 20308 
*
********************************************************/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Scanner; 

class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in); //Se crea el scanner para recibir ingresos del usuario 

    System.out.println("--SORTS--\n"); 

    System.out.println("Cuantos numeros quieres que el archivo tenga?"); 

    /**
     * Se le realiza la pregunta al usuario sobre que cantidad
     * de datos quiere que el archivo contenga para luego estos
     * ser ordenados por alguno de los metodos de sorting. 
     */
    int cantTotal = scanner.nextInt(); 

    int opcion1 = 0;

    int total = cantTotal;

    File file = null;

    /**
     * Se crea la base de datos con el tipo de dato Integer[]
     * pues este tipo de dato aplica la interfaz Compare[]. 
     * Por lo tanto se pueden utilizar los métodos de la interfaz
     * y se permite la conversion de los datos tipo integer para
     * facilitar el funcionamiento. 
     */
    Integer[] database = new Integer[total];;  

    boolean test = false;

    while(!test){

      /**
       * Se abre un ciclo while en donde se le pregunta al usuario que tipo de orden 
       * quiere que tengan los datos del archivo de texto. Estos pueden ser:
       * 1. Ordenados
       * 2. Desordenados 
       */

      System.out.println("\nQuieres crear un .txt con  numeros ordenados o desordenados?\n1. Desordenados \n2. Ordenados");

      opcion1 = scanner.nextInt(); //El usuario ingresa su seleccion

      if(opcion1 == 1){ //Opcion Desordenados
        try {
          BufferedWriter output = null;

          file = new File("numbers.txt");
          
          output = new BufferedWriter(new FileWriter(file));

          int tempLine2 = 0;
          int line;

          Random random = new Random();

          while (total > 0) {
            /**
             * En un ciclo se crean todos los números que se encontrarán en el archivo de texto. 
             */

            line = random.nextInt(1000);
            database[tempLine2] = Integer.valueOf(line);
            tempLine2 = tempLine2 +1;
            output.write(new Integer(line).toString());
            output.newLine();
            total--;
            test = true;
          }
          output.close();
        }catch (IOException e) {
          e.printStackTrace();
          System.exit(0);
        }
        

      }else if (opcion1 == 2){ //Opcion Ordenados
        try {
          BufferedWriter output = null;

          file = new File("numbers.txt");
          
          output = new BufferedWriter(new FileWriter(file));
          int line = 0;

          while (total > 0) {

            /**
             * En un ciclo se crean todos los números que se encontrarán en el archivo de texto.
             * A diferencia del pasado este los genera ordenadamente.  
             */

            database[line] = Integer.valueOf(line);
            output.write(new Integer(line).toString());
            line = line + 1;
            output.newLine();
            total--;
            test = true;
          }
          output.close();

        }catch (IOException e) {
          e.printStackTrace();
          System.exit(0);
        }
      }
      

    }

    


    /**
     * Ahora que los archivos fueron creados, se le pregunta al usuario que tipo de sort desea
     * utilizar para ordenar el contenido númerico de estos mismos. Se le mostrarán los sorts de:
     * 1. Bubble Sort
     * 2. Gnome Sort
     * 3. Merge Sort
     * 4. Quick Sort
     * 5. Radix Sort
     */
    int opcion = 0;

    while(opcion != 6){

      System.out.println("\nCon qué sort quieres ordenar los números?\n1. Bubble Sort\n2. Gnome Sort\n3. Merge Sort\n4. Quick Sort\n5. Radix Sort\n6. SALIR");

      opcion = scanner.nextInt(); //Ingreso del usuario 
      Sort sortMethods = new Sort();
      Integer[] tComparable = new Integer[cantTotal];

      if(opcion == 1){ //Bubble
        tComparable = sortMethods.bubbleSort(database);
      }else if(opcion == 2){ //Gnome

      }else if(opcion == 3){ //Merge

      }else if(opcion == 4){ //Quick

      }else if(opcion == 5){ //Radix

      }else if(opcion == 6){ //Salir
        System.out.println("Adios."); 
        System.exit(0); 
      }


      /**
       * Una vez ejecutados los metodos de cada tipo de sort se generan los nuevos archivos 
       * con los datos en la base de datos "database". Este es el archivo final. 
       */
      try {
        
        BufferedWriter output = null;

        File newFile = new File("ordered.txt");
        
        output = new BufferedWriter(new FileWriter(newFile));

        for(int i = 0; i < tComparable.length; i++){

          Integer tempNumber = tComparable[i];
          output.write(tempNumber.toString());
          output.newLine();

        }
        output.close();

      }catch (IOException e) {
        e.printStackTrace();
        System.exit(0);
      }


    }

  }
}