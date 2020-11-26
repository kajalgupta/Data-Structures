package Competition.Hackerrank.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlmostSorted2 {
   
        public static void main(String[] args) throws IOException{
           //File file = new File(); BufferedReader br = new BufferedReader(new FileReader(file));
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           int size = Integer.parseInt(br.readLine());
           int arr[] = new int[size];
           String[] str = br.readLine().split("\\s+");
           for(int i = 0; i < size; i++){
                arr[i] = Integer.parseInt(str[i]);
           }
           boolean flag = chechSorted(arr, size);
           boolean fone = true;
           if(flag){
               System.out.println("yes");
           }else{
                String tempSwap[] = swap(arr, size);
                if(tempSwap[0].equals("true")){
                    fone = false;
                    System.out.println(tempSwap[1]);
                    System.out.println(tempSwap[2]);
                }
    
                if(fone){
                    String tempreverse[] = reverse(arr, size);
                    if(tempreverse[0].equals("true") && fone){
                        fone = false;
                        System.out.println(tempreverse[1]);
                        System.out.println(tempreverse[2]);
                    }
                    if(fone){
                        System.out.println("no");
                    }
                }
               
           }
    
        }
    
        private static String[] swap(int[] array, int size){
            int arr[] = copyArray(array, size);
            int a = 0;
            int b = 0;
            int index = 0;
            if(size ==2){
                if(arr[0] > arr[1]){                                
                    String aa[] = {"true","yes",  "swap 1 2"};
                    return aa;
                }
            }
            if(arr[0] > arr[1]){
                a = 0;
                index = 1;
            }else{
                for(int i = 1; i < size-1; i++){
                    if(arr[i]>arr[i+1]){
                        a = i;
                        index = i;
                        break;    
                    }
                }
            }
           
            for(int i = index+1; i < size-1; i++){
                if(arr[i+1]<arr[i]){
                    //System.out.println(arr[i]+" "+arr[i+1]);
                    b = i+1;
                    break;    
                }
            }
            if(a > b){
                b = a+1;
            }
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            if(chechSorted(arr, size)){
                String aa[] = {"true","yes","swap "+(a+1)+" "+(b+1)};
                return aa;
            }else{
                String aa[] = {"false","no"};
                return aa;
            }
           
        }
    
        private static String[] reverse(int[] array, int size){
            int arr[] = copyArray(array, size);
            int a = 0;
            int b = 0;
            boolean flag = true;
            for(int i = 0; i < size-1; i++){
                if(arr[i] > arr[i+1] && flag){
                    //System.out.println(arr[i]+" Here "+arr[i+1]);
                    a = i;
                    flag = false;
                    break;
                }
            }
            for(int i = a; i < size-1; i++){
                //System.out.println(i+" "+(size-1));
                if(arr[i]<arr[i+1]){
                    b = i;
                    break;
                }
                if(i==size-2){
                    b = size-1;
                }
            }
            //System.out.println(a+" yo "+b);
            if(chechSorted(reversePart(arr, a, b), size)){
                String aa[] = {"true","yes","reverse "+(a+1)+" "+(b+1)};
                return aa;
            }else{
                String aa[] = {"false","no"};
                return aa;
            }
    
        }
    
        private static boolean chechSorted(int arr[], int size){
            boolean flag = true;
            for(int i = 0; i < size-1; i++){
                    if(arr[i]>arr[i+1]){
                        flag = false;
                        break;
                    }
            }
            return (flag) ?  true :  false;
        }
    
        private static int[] reversePart(int arr[], int a, int b){
            int temp[] = new int[b-a+1];
            int ind = b-a;
            //System.out.println(a+" "+b+" "+temp.length);
            for(int i = 0; i < temp.length; i++){
                temp[ind--] = arr[a+i];
            }
            int inde = 0;
            for(int i = a; i <= b; i++){
                arr[i] = temp[inde++];
            }
            //System.out.println(Arrays.toString(temp)+" here");
            //System.out.println(Arrays.toString(arr)+" here");
            return arr;
        }
    
        private static int[] copyArray(int array[], int size){
            int a[] = new int[size];
            for(int i = 0; i < size; i++){
                a[i] = array[i];
            }
            return a;
        }
    }
    
    
    
