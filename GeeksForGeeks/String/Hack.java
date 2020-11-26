package GeeksForGeeks.String;

import java.io.*; 
import java.util.*;
public class Hack  
{
  
  public static int gridOfNodes(int[][] ip, int rows, int col){
    System.out.println("list is : - heyyyyyyyy");
    int count=0, result =0, temp=0;
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<rows; i++){
      count = 0;
      for(int j=0; j<col; j++){
        if(ip[i][j]==1)
          count++;
      }
      list.add(count);
      
    }
    System.out.println("list is : - "+ list);
    int k = 0;
    for(int i=0; i<list.size(); i++){
      if(list.get(i)!=0){
        if(list.get(i+1)==0){
        result += list.get(i)*list.get(i+1);
      }
      else{
         temp = list.get(i);
        k=i;
        while(k<rows &&list.get(++k)==0){
          
          //i=i+2;
        }
        if(k<rows)
        result += temp*list.get(k);
        i=k-1;
      }
        
      }
                            
               }
    
    
    return result;
  }
  
 	public static void main (String[] args) throws java.lang.Exception 
 	{

     	//use the following code to fetch input from console 
     	//String line; 
     	BufferedReader inp = new BufferedReader (new InputStreamReader(System.in)); 
     	//line=inp.readLine();

     	//Use the following code to print output
//System.out.println(line);
      int n = Integer.parseInt(inp.readLine());
      int m = Integer.parseInt(inp.readLine());
      int[][] array = new int[n][m];
      int i=0; 
      while(n>0){
        String[] line=inp.readLine().split(" ");
        int j=0;
        while(j<m){
          array[i][j] = Integer.parseInt(line[j]);
          ++j;
                  
        }
        ++i;
        --n;
      }
      
      System.out.println(gridOfNodes(array, n, m)); 
      System.out.println("hey");
     
    }
}