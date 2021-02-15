import javax.naming.ldap.LdapContext;

import org.graalvm.compiler.nodes.spi.ArrayLengthProvider;
import org.graalvm.compiler.replacements.nodes.ArrayRegionEqualsNode;

import jdk.internal.net.http.frame.DataFrame;

/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Sort.java
* Autor: Stefano Aragoni 20261, Marco Jurado 20308 
*
********************************************************/

class Sort{

  public Sort(){

  }

  /**
   * @author Stefano Aragoni
   * @param database
   * @return Integer[] Listado ordenado
   */
  public Integer[] bubbleSort(Integer[] database){ 

    for (int i = 0; i < database.length; i++){
      for (int j = 0; j < database.length; j++){
        if (database[j].compareTo(database[i]) == 1) 
        { 
          Integer tempNumber = database[i];

          database[i] = database[j]; 
          database[j] = tempNumber; 

        } 
      }
    }
    return database;
  } 


  /**
   * @author Marco Jurado 
   * @param database
   * @return Integer[] Listado ordenado
   */
  public Integer[] GnomeSort(Integer[] database){
    for(int i = 1; i < database.length;){
      // recorre toda la base de datos desde la primra posicion 

      if(database[i - 1] <= database[i]){
        //Si el numero en la posicion anterior no es más grande
        i++;
      }else{
        //Si el numero en la posicion anterior es más grande 
        int variable_temporal_posicion;
        //Se guarda la posiion anterior del arreglo en la variable temporal de posicion.

        variable_temporal_posicion = database[i - 1];
        database[i - 1] = database[i];
        database[i] = variable_temporal_posicion;
        i--;

      }


      if(i == 0){
        i= 1;
      }
    }
    
    return database;

  }

  
  /**
   * @author Marco Jurado 
   * @param database
   * @return Integer[] Listado ordenado
   */
  public Integer[] MergeSort(Integer[] database){

    Integer[] bucket = new Integer[database.length];

    int mitad = database.length / 2;
    Integer[] Izquierda = new Integer[mitad];
    Integer[] Derecha; // No se define de una vez pues hay que crear primero izquierda para saber el tamaño de derecha.

    /**
     * Pimero se verifica si el tamaño del arreglo de base de datos
     * es menor o igual a 1 pues de este modo no se aplica el merge sort
     */ 
    if(database.length <= 1){
      return database; //Se devuelve pues no se puede aplicar merge.
    }

    if(database.length % 2 == 0){
      //Si el arreglo contiene una cantidad par de elementos
      Derecha = new Integer[mitad];
    }else{
      //El arreglo es impar y no se puede generar con tamaño de mitad. Debe ser mitad + 1.
      Derecha = new Integer[mitad + 1];
    }

    /**
     * Con los arreglos que serviran para ubicar las mitades se procede a realizar la comparacion
     * para así ubicar a los elementos. 
     */

     for(int i = 0; i < mitad; i++){
      //Se recorre la mitad del arreglo 
      Izquierda[i] = database[i];
      //Se pasan los datos de el arreglo original a el arreglo del lado izquierdo. 
    }
    for(int j = 0; j < Derecha.length; j++){
      //Se recorre la mitad del arreglo 
      Derecha[j] = database[mitad + j];
      //Se pasan los datos de el arreglo original a el arreglo del lado derecho. 
    }
    

    /**
     * Se realiza la recursividad para realizar el merge sort de ambos lados 
     */

     Izquierda = MergeSort(Izquierda);
     Derecha = MergeSort(Derecha);

     int i = 0;
     int j = 0;
     int k = 0;
     while(Izquierda.length != j && Derecha.length != k){
       if(Izquierda[j] < Derecha[k]){
        database[i] = Izquierda[j];
        i++;
        j++;
       }else{
         database[i] = Derecha[k];
         i++;
         k++;
       }
      
     }

     //Arreglo Final Ordenado
     while(Izquierda.length != j){
      database[i] = Izquierda[j];
      i++;
      j++;
     }
     while(Derecha.length != k){
       database[i] = Derecha[k];
       i++;
       k++;
     }

     return database;
    }

  
  /**
   * @author Marco Jurado 
   * @param database base de datos 
   * @param primero primera posicion del arreglo
   * @param ultimo ultima posicion del arreglo
   * @return Integer[] Listado ordenado
   */
  public Integer[] QuickSort(Integer[] database, int primero, int ultimo){
    int i,j,pivote,variable_temporal;
    i = primero;
    j = ultimo;
    pivote = database[(primero + ultimo) / 2]; // Se toma la posicion en el medio del arreglo
    while( i <= j){
      while(database[i] < pivote){
        i++;
      } 
      while(database[j] > pivote){
        j--;
      }
      /**Ahora que las posiciones cambian a se necesita hacer la comparacion 
       * y el intercambio respectivo.
       */
      if(i <= j){
        //se verifican los datos en las posiciones i y en la posicion j.
        variable_temporal = database[i];
        database[i] = database[j];
        database[j] = variable_temporal;
        i++;
        j--;
      }
    }

    /**
     * Se realiza la comparación de la variable primero con el index j del arreglo
     * así como la posicion i con el mismo arreglo para saber que tipo de recursividad
     * se debe de aplicar. Si primero es menor que j se aplica recursividad desde la 
     * primera posicion hasta el index j del arreglo. Si i es menor que ultimo se 
     * aplica la recursividad desde el index i hasta la ultima posicion del arreglo. 
     */

    if(primero < j){
      //Si la primera posicion es menor a la posicion j de database
      //Se aplica recursividad

      QuickSort(database, primero, j);
    }if(i < ultimo){
      QuickSort(database, i, ultimo);
    }

    return database;
  }






  /**
   * @author Marco Jurado 
   * @param database
   * @return Integer[] Listado ordenado
   */
  public Integer[] RadixSort(Integer[] database){

    int x,i,j;

    for(x = Integer.SIZE - 1; x >= 0; x--){
      Integer[] bucket = new Integer[database.length];
      j= 0;
      for(i = 0; i < database.length; i++){
        boolean mover = database[i] << x >= 0;
        // devuelve el boolean si es necesario mover o no el dato
        //Se utiliza el compare para saber si los numeros son menores, mayores o iguales
        /*Tambien se utiliza el operador ternario para comparar los datos en mover. Se realizo una pequeña investigacion
          sobre como se debe de utilizar este operador. 
          
            resultado = (condicion) ? valor1 : valor2*/

        if(x == 0 ? !mover:mover){
          //Si el valor de x es igual a 0 al revisar en los dos operadores mover 

          //Se pone la posicion i de database en la bucket.
          bucket[j] = database[i];
          j++;
        }else{
          //En caso de no ser verdadero, se asigna la posicion i de database en la posicion i - j del mismo arreglo. 
          database[i - j] = database[i];
        }

        /**Con esto se busca ordanar en tipo de fichero para que sea más rápido el ordenamiento.  */

        

      }

      for(i = j; i < bucket.length; i++){
        //Se copian los datos del bucket a base de datos
        bucket[i] = database[i - j];
      }
      database = bucket;
    }

 
   return database; 

  }


}