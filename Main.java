import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import java.util.Scanner; 

class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in); 

    int total = 3000;
    BufferedWriter output = null;

    try {

      File file = new File("numbers.txt");
      
      output = new BufferedWriter(new FileWriter(file));

      int line;

      Random random = new Random();

      while (total > 0) {

        line = random.nextInt(1000);
        output.write(Integer(line).toString());
        output.newLine();
        total--;

      }
      output.close();
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(0);
    }

    int opcion = 0;

    while(opcion != 6){

      System.out.println("Con qué sort quieres ordenar los 3000 números?\n1. Bubble Sort\n2.Gnome Sort\n3. Merge Sort\n4.Quick Sort\n5.Radix Sort\n6. SALIR");

      opcion = scanner.nextInt(); 

      switch(opcion){

        case 1:{
          BubbleSort bubble = new BubbleSort();
        }case 2:{
          GnomeSort gnome = new GnomeSort();
        }case 3:{
          MergeSort merge = new MergeSort();
        }case 4:{
          QuickSort quick = new QuickSort();
        }case 5:{
          RadixSort radix = new RadixSort();
        }case 6:{
          System.out.println("Adios."); 
        }
        

      }


    }

  }
}