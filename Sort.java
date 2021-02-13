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
   * @param database
   * @return Integer[] Listado ordenado
   */
  public void QuickSort(){

  }

  
  /**
   * @author Marco Jurado 
   * @param database
   * @return Integer[] Listado ordenado
   */
  public void RadixSort(){

  }


}