import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChefAndWork {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       // int t = Integer.parseInt(br.readLine());
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
        String[] str = br.readLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        List<Integer> weightsList = new ArrayList<>();
        String[] str2 = br.readLine().split("\\s+");
        for(int i=0; i<n; i++){
            weightsList.add(Integer.parseInt(str2[i]));
        }
        System.out.println(roundTrips(weightsList, k, n));
    }
}

    private static int roundTrips(List<Integer> list, int k, int n) {
        if (n==1) {
            if (list.get(0)>k) {
                return -1;
            }
            else{
                return 1;
            }
        }
        int days = 0;
        int sum = 0;
        while(!list.isEmpty()){
            sum = 0;
            if(list.get(0)>k){
                return -1;
            }
            while (!list.isEmpty() && sum + list.get(0)<=k ) {
                sum += list.get(0);
                list.remove(0);
            }
           days++;

        }
        return days;
    }
    
}