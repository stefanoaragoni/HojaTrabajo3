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

    int index = 0; //Se define un index para ubicarse en el listado

    while(index < database.length){
      if(index == 0){
        //El index es 0, avanza a siguiente elemento
        index++;
      }
      if(database[index].compareTo(database[index - 1]) >= database[index - 1] ){
        //El elemento en el cual se encuentra el index es mayor o igual que el anterior. Continua
        index++;
      }
      else{
        //El elemento en el que se encuentra debe de ser ordenado
        int variable_temporal = 0; //Variable que sirve para guardar la posicion que se evalua

        variable_temporal = database[index];
        database[index] = database[index - 1]; // se mueve el elemento pues a la posicion menor
        database[index - 1] = variable_temporal; // Se pone el elemento de la posicion anterior en la siguiente, pues es mayor. 
        index--;

      }
    }
    
    /**
     * Una vez se encuentran ordenados los elementos se procede a devolver el arreglo. 
     */

    return database;

  }

  
  /**
   * @author Marco Jurado 
   * @param database
   * @return Integer[] Listado ordenado
   */
  public Integer[] MergeSort(Integer[] database){

    /**
     * Cabe mencionar que este tipo de sort es recursivo.
     */

    int medio = database.length / 2;

    /**Se crearan dos arreglos los cuales serviran para 
     * que se dividan los datos y se puedan realizar las comparaciones en ambos lados.
     */
    
    Integer[] Izquierda = new Integer[medio];
    Integer[] Derecha = new Integer[database.length - medio];

    for(int i = 0; i < medio; i++){
      //Se especifican que las posiciones en el arrgelo son las mismas que en la base de datos. 
      Izquierda[i] = database[i];
    }
    for(int i = 0; i < medio; i++){
      //Se especifican que las posiciones en el arrgelo son las mismas que en la base de datos. 
      Derecha[i - medio] = database[i];
    }

    MergeSort(Izquierda);
    MergeSort(Derecha);

    //Ahora se juntan todas las piezas

    int a = 0;
    int b = 0;
    int c = 0;

    while(a < Izquierda.length && b < Derecha.length){
      if(Izquierda[a].compareTo(Derecha[b]) <= Derecha[b]){
        database[c++] = Izquierda[a++];
      }
      else {
        database[c++] = Derecha[b++];
      }
      }
      while (a < Izquierda.length) {
        database[c++] = Izquierda[a++];
      }
      while (b < Derecha.length) {
        database[c++] = Derecha[b++];
      }

      /**
       * Ahora que todas las piezas estan juntas se devuelve la base de datos ordenada
       */

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

    if(primero < ultimo){
      /**El largo de la base de datos permite aplicar sort */
      int Index = 0;

      //Se debe de definir el index para comenzar el quick sort
      Integer Pivote = database[ultimo];
      primero = (ultimo - 1);
      for(int i = 0; i < ultimo; i++){
        if(database[i].compareTo(Pivote) < Pivote){

          primero++;

          int variable_temporal = database[primero];
          database[primero] = database[i];
          database[i] = variable_temporal;
        }
      }

      int variable_temporal_2 = database[primero + 1];
      database[primero + 1] = database[ultimo];
      database[ultimo] = variable_temporal_2;

      Index = primero;

      /**Ahora que ya se sabe cual es el index por el cual comienza el programa se 
       * realiza la recursividad para ordenar. 
       */

      QuickSort(database, primero, Index -1);
      QuickSort(database, Index -1, ultimo);
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