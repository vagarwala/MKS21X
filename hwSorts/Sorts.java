import java.util.Random;
public class Sorts{
	public static void printArray(int[] data){
		String res = "[";
		for (int i = 0; i < data.length; i++){
			res += data[i] + ", ";
		}
		System.out.println(res.substring(0, res.length() - 2) + "]");
	}
	public static void insertionSort(int[] data){
		int n = data.length;
        for (int j = 1; j < n; j++) {
            int key = data[j];
            int i = j-1;
            while ( (i > -1) && ( data [i] > key ) ) {
                data [i+1] = data [i];
                i--;
            }
            data[i+1] = key;
        }
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;
                }
            }
            int smallerNumber = arr[index];  
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void bubbleSort(int[] arr){
        int j;
        boolean flag = true;   // set flag to true to begin first pass
        int temp;   //holding variable
        while ( flag ){
            flag= false;    //set flag to false awaiting a possible swap
            for(j=0;  j < num.length -1;  j++ ){
               if ( num[ j ] > num[j+1] ){
                    temp = num[ j ];                //swap elements
                    num[ j ] = num[ j+1 ];
                    num[ j+1 ] = temp;
                    flag = true;              //shows a swap occurred
                }
            }
        }
    } 

    public static void fillRandom(int[] data){
        Random rand = new Random();
        for(int i = 0; i < data.length; i++){
            data[i] = rand.nextInt();
        }
    }
}