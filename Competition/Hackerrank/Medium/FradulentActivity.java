import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//package Comp
public class FradulentActivity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int d = Integer.parseInt(str[1]);
        String[] str2 = br.readLine().split("\\s+");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
        arr[i] = Integer.parseInt(str2[i]);
        }
        System.out.println(activityNotification(arr, d));
    }

    private static int activityNotification(int[] expenditure, int d) {
        int notificationCount = 0;
        int[] data  = new int[201];
        for (int i = 0; i < d; i++) {
            data[expenditure[i]]++;
        }
        for (int i = d; i < expenditure.length; i++) {
            double median = getMedian(d, data);
            System.out.println("median is"+median);
            if (expenditure[i]>= 2*median) {
                notificationCount++;
            }
            data[expenditure[i]]++;
            data[expenditure[i-d]]--;
        }
        return notificationCount;
    }
    private static double getMedian(int d, int[] data) {
        int count = 0;
        double median = 0;
        if (d%2==0) {
            // even no. of elements
            Integer a = null;
            Integer b = null;
            for (int i = 0; i < data.length; i++) {
                count+= data[i];
                if (a==null && count>=d/2) {
                    a = i;
                }
                if (count>=d/2+1) {
                    b = i;
                    break;
                }
            }
            median = a+b/2.0;
        } else {
           
            for (int i = 0; i < data.length; i++) {
                count += data[i];
                if (count>d/2) {
                   median =  i; //median
                   break;
                }
            }
        }

        return median;
    }

    
    
}