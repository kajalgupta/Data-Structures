package Competition.CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




    import java.util.*;
import java.lang.Math;
public class ChefAndWalk {
	   public static void main(String[] args)
	   {
		   Scanner sc = new Scanner(System.in);
		   int t = sc.nextInt();
		   
			   for(int b = 0;b<t;b++)
			   {       int a = sc.nextInt();
			           int temp;
			           List<Integer> l = new ArrayList<>();
			          
			            for(int j = 0;j<a;j++)
			               {  
			                 l.add(sc.nextInt());
			                 
			               }
			            System.out.println("list is"+l);
			             int max=Collections.max(l);
			             temp = Collections.max(l);
                                      for(int i=0;i<a;i++)
                                        {
                                             if(temp<l.get(i))
                                              {
                                                 max=max+(l.get(i)-temp);
                                                  temp=l.get(i);
                                                 }
                                                temp--;
                                       }
			             System.out.println(max);  
				   
			   }
			  
		
		   
		   sc.close();
	   }

    /*
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            int n = Integer.parseInt(str[0]); 
            int k = Integer.parseInt(str[1]); 
            //long[] stepsOccurence1 = new long[n+1];
           // long[] arr = new long[100000];
            // for (int i = 0; i < stepsOccurence1.length; i++) {
            //     stepsOccurence1[i] = i*i;
            // }
            if(k==1){
                //System.out.println(stepsOccurence1[n]);
                System.out.println(n*n);
            }
            else{
               int count = 1;
               int i=0;
               long value = 0;
               long time =0;
                for (i = n+1; value<=1000000000; i++) {
                    //arr[i] = 2*count;
                    value = 2*count;
                    count++;
                    if (value==k) {
                        time = i*i-(i-n);
                        break;
                    }
                    if(value>k){
                        i=i-1;
                        time = i*i+(i-n);
                        
                        break;
                    }
                }
               
                System.out.println(time);
            }

            
        }
    }
    */

}