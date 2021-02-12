class Sort{

  public Sort(){

  }

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

  public void GnomeSort(){

  }

  public void MergeSort(){

  }

  public void QuickSort(){

  }

  public void RadixSort(){

  }


}