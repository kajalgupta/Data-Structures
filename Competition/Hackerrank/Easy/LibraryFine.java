package Competition.Hackerrank.Easy;

import java.util.Scanner;

public class LibraryFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] d1M1Y1 = sc.nextLine().split(" ");
        int d1 = Integer.parseInt(d1M1Y1[0]);
        int m1 = Integer.parseInt(d1M1Y1[1]);
        int y1 = Integer.parseInt(d1M1Y1[2]);
        String[] d2M2Y2 = sc.nextLine().split(" ");
        
        int d2 = Integer.parseInt(d2M2Y2[0]);
        int m2 = Integer.parseInt(d2M2Y2[1]);
        int y2 = Integer.parseInt(d2M2Y2[2]);
        sc.close();
         int result = libraryFine(d1, m1, y1, d2, m2, y2);
                System.out.println(result);
        }

    private static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if ((d1<=d2) && (m1<=m2) && y1<=y2) {
            return 0;
        }
        if ((d1>d2) && (m1==m2)&& (y1==y2)) {
            return 15*(d1-d2);
        }
        if ((m1>m2)&& (y1==y2)) {
            return 500*(m1-m2);
        }
        //(y1>y2)\
        else
        return 10000*(y1-y2);
        //else
        //  return 15*(d1-d2)+500*(m1-m2);
    }
}