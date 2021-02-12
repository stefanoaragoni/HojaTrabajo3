import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import java.util.Scanner; 

class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in); 

    System.out.println("--SORTS--\n"); 

    System.out.println("Cuantos numeros quieres que el archivo tenga?"); 

    int cantTotal = scanner.nextInt(); 

    int opcion1 = 0;

    int total = cantTotal;

    File file = null;

    Integer[] database = new Integer[total];; 

    boolean test = false;

    while(!test){

      System.out.println("\nQuieres crear un .txt con  numeros ordenados o desordenados?\n1. Desordenados \n2. Ordenados");

      opcion1 = scanner.nextInt(); 

      if(opcion1 == 1){
        try {
          BufferedWriter output = null;

          file = new File("numbers.txt");
          
          output = new BufferedWriter(new FileWriter(file));

          int tempLine2 = 0;
          int line;

          Random random = new Random();

          while (total > 0) {

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
        

      }else if (opcion1 == 2){
        try {
          BufferedWriter output = null;

          file = new File("numbers.txt");
          
          output = new BufferedWriter(new FileWriter(file));
          int line = 0;

          while (total > 0) {

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

    
    int opcion = 0;

    while(opcion != 6){

      System.out.println("\nCon qué sort quieres ordenar los números?\n1. Bubble Sort\n2. Gnome Sort\n3. Merge Sort\n4. Quick Sort\n5. Radix Sort\n6. SALIR");

      opcion = scanner.nextInt(); 
      Sort sortMethods = new Sort();
      Integer[] tComparable = new Integer[cantTotal];

      if(opcion == 1){
        tComparable = sortMethods.bubbleSort(database);
      }else if(opcion == 2){

      }else if(opcion == 3){

      }else if(opcion == 4){

      }else if(opcion == 5){

      }else if(opcion == 6){
        System.out.println("Adios."); 
        System.exit(0); 

      }

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