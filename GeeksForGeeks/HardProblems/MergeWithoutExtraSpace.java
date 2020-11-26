package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class MergeWithoutExtraSpace {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] ip = br.readLine().split("\\s+");
            int X = Integer.parseInt(ip[0]);
            int Y = Integer.parseInt(ip[1]);
            String[] str1 =  br.readLine().split("\\s+");
            String[] str2 =  br.readLine().split("\\s+");
            final int[] arr1 = new int[X];
            int[] arr2 = new int[Y];
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = Integer.parseInt(str1[i]);
            }
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = Integer.parseInt(str2[i]);
            }
          // merge(arr1,arr2);
           buildHeap(arr2,Y);
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i]>arr2[0]) {
                   // swap1(i, 0);
                   int temp = arr1[i];
                   arr1[i] = arr2[0];
                   arr2[0] = temp;
                    heapify(arr2, Y, 0);
                }
            }
           // Arrays.sort(arr2);
           sort(arr2);
            System.out.println(Arrays.toString(arr1).replace("[","").replace("]", "").replace(",","")+" "+Arrays.toString(arr2).replace("[","").replace("]", "").replace(",",""));
  
        }
    }

    private static int sort(int[] arr) {
        int n = arr.length; 
  
        // Start with a big gap, then reduce the gap 
        for (int gap = n/2; gap > 0; gap /= 2) 
        { 
            // Do a gapped insertion sort for this gap size. 
            // The first gap elements a[0..gap-1] are already 
            // in gapped order keep adding one more element 
            // until the entire array is gap sorted 
            for (int i = gap; i < n; i += 1) 
            { 
                // add a[i] to the elements that have been gap 
                // sorted save a[i] in temp and make a hole at 
                // position i 
                int temp = arr[i]; 
  
                // shift earlier gap-sorted elements up until 
                // the correct location for a[i] is found 
                int j; 
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
                    arr[j] = arr[j - gap]; 
  
                // put temp (the original a[i]) in its correct 
                // location 
                arr[j] = temp; 
            } 
        } 
        return 0;
    }

    private static void heapify(int[] arr, int n, int i) {
        int l = 2*i+1;
        int r = 2*i+2;
        int smallest = i;
        if (l<n && arr[l]<arr[i]) {
            smallest = l;
        }
        smallest = (r<n && arr[r]<arr[smallest])?r:smallest;
        if (smallest!=i) {
           // swap(arr[smallest], arr[i]);
          int temp = arr[smallest];
          arr[smallest] = arr[i];
          arr[i] = temp;
            heapify(arr, n, smallest);
        }
    }

   

    private static void buildHeap(int[] arr2, int n) {
        for (int i=n/2-1;i>=0; i--) {
            heapify(arr2, n, i);
        }
    }

    private static void merge(int[] arr1, int[] arr2) {
        //int temp = 0, temp2 = 0;
        //int i = 
        //for ( i < arr1.length; i++) {
           for (int i = arr2.length-1; i>=0; i--) {
               //for ( j > 0; j--) {
                int j = arr1.length-2;
                int last = arr1[arr1.length-1];
                   while (j>=0 && arr1[j]>arr2[i]) {
                       arr1[j+1] = arr1[j];
                       j--;
                   }
                   if (j!=arr1.length-2 || last>arr2[i] ){
                       arr1[j+1] = arr2[i];
                       arr2[i] = last; 
                   }
               }
               
           
            
        System.out.println(Arrays.toString(arr1).replace("[","").replace("]", "").replace(",","")+" "+Arrays.toString(arr2).replace("[","").replace("]", "").replace(",",""));
    }

}