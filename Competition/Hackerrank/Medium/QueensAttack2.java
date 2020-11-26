import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueensAttack2 {

  //  private static int minTop;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        String[] str2 = br.readLine().split("\\s+");
        int qr = Integer.parseInt(str2[0]);
        int qc = Integer.parseInt(str2[1]);
        int[][] obstacles = new int[k][2];
        for (int i = 0; i < k; i++) {
             String[] str3 = br.readLine().split("\\s+");
             obstacles[i][0] = Integer.parseInt(str3[0]);
             obstacles[i][1] = Integer.parseInt(str3[1]);
        }
        System.out.println(queensAttack(n, k, qr, qc, obstacles));
    }

    // private static int queensAttack(int n, int k, int qr, int qc, int[][] obstacles) {
    //     int maxLeft = -1;
    //     int minRight = Integer.MAX_VALUE;
    //     int maxBottom = -1;
    //     int minTop = Integer.MAX_VALUE;
    //     int maxlefttopdiagonal = -1; // Integer.MIN_VALUE;
    //    int minLeftBottomDiagonal = Integer.MAX_VALUE;
    //   int maxRightBottomDiagonal = -1; //Integer.MIN_VALUE;
    //   int minRightTopDiagonal = Integer.MAX_VALUE;
    //   int moves = 0;
    //     int a =0;
    //     int b =0;
    //     int c =0;
    //     int d =0;
    //     if (k!=0) {
    //     for (int t = 0; t < k; t++) {
    //         int i = obstacles[t][0];
    //         int j = obstacles[t][1];
    //         //1. left
    //         if ((i==qr) && (j<qc)) {
    //             if(j > maxLeft) maxLeft= j;
    //            // continue label;
    //         }
    //         //2.right
    //         if ((i==qr) && (j>qc)) {
    //             if(j < minRight) minRight = j;
    //             continue;
    //         }
    //         //3. bottom
    //         if ((i<qr) && (j==qc)) {
               
    //             if (i > maxBottom)
    //                 maxBottom = i;
    //                 continue;
    //         }
    //         //4. top
    //         if ((i>qr) && (j==qc)) {
    //             if (i < minTop)
    //                 minTop = i;
    //             continue;
    //         }
    //         // 5. diagonal
    //         int slope =  (i-qr!=0) ? (j-qc)/(i-qr):0;
    //         if (slope==-1) {
    //             //left top - left diagonal
    //             if (j<qc) {
    //                 if (j>maxlefttopdiagonal) {
    //                     maxlefttopdiagonal = j;
    //                     a = i;
    //                 }
    //             } else {
    //                 if (j<minLeftBottomDiagonal) {
    //                     minLeftBottomDiagonal = j;
    //                     b = i;
    //                 }
    //             }
    //         } if(slope==1) {
    //             if (j<qc) {
    //                 if (j>maxRightBottomDiagonal) {
    //                     maxRightBottomDiagonal = j;
    //                     c = i;
    //                 }
    //             } else {
    //                 if (j<minRightTopDiagonal) {
    //                     minRightTopDiagonal = j;
    //                     d = i;
    //                 }
    //             }
                
    //         }
    //        // label: 
            
    //     }
        
    //     if(maxLeft != -1)  moves += calculateDist(qr,qc, qr, maxLeft);
    //     if(minRight != Integer.MAX_VALUE)  moves += calculateDist(qr,qc, qr, minRight);
    //     if(maxBottom != -1)  moves += calculateDist(qr,qc, maxBottom, qc);
    //     if(minTop != Integer.MAX_VALUE)  moves += calculateDist(qr,qc, minTop,qc);

    //     if(maxlefttopdiagonal != -1)  moves += calculateDist(qr,qc, a, maxlefttopdiagonal);
    //     if(minLeftBottomDiagonal != Integer.MAX_VALUE)  moves += calculateDist(qr,qc, b, minLeftBottomDiagonal);
       
    //     if(maxRightBottomDiagonal != -1)  moves += calculateDist(qr,qc, c, maxRightBottomDiagonal);
    //     if(minRightTopDiagonal != Integer.MAX_VALUE)  moves += calculateDist(qr,qc, d, minRightTopDiagonal);
        
    // }
    // else{
    //     moves += 2*(n-1);
    //     moves += 2*(Math.min(qr, qc)-1) + 2*(n - Math.max(qc, qr));// + qc - 1+n-qr;
    //     // calculateDist(qr, qc, 1, 1 );
    // }
        
    private static int queensAttack(int n, int k, int qr, int qc, int[][] obstacles) {
       
            int left = qc-1;
            int right = n-qc;
            int up = n-qr;
            int down = qr-1;
            int upLeft = (up<left)?up:left;
            int upRight = (up<right)?up:right;;
            int downleft = (down<left)?down:left;
            int downRight = (down<right)?down:right;
            for (int[] obstacle : obstacles) {
                int row = obstacle[0];
                int col = obstacle[1];

                //1. Left
                if (row==qr && col<qc) {
                   left = (qc-col-1)<left?qc-col-1:left;
                }
               else if (row==qr && col>qc) {
                    right = (col-qc-1)<right?col-qc-1:right;
                 }
                else if (row<qr && col==qc) {
                    down = (qr-row-1)<down?qr-row-1:down;
                   // System.out.println("down value"+down);
                 }
                 else if (row>qr && col==qc) {
                    up = (row-qr-1)<up?row-qr-1:up;
                 }
                 else if(Math.abs(qr-row)==Math.abs(qc-col)){
                     if (row>qr && col<qc && row-qr-1<upLeft) {
                         upLeft = row-qr-1;
                     }
                     else if (row>qr && col>qc && row-qr-1<upRight) {
                        upRight = row-qr-1;
                    }
                    else if (row<qr && col<qc && qr-row-1<downleft) {
                        downleft = qr-row-1;
                    }
                    else if (row<qr && col>qc && qr-row-1<downRight) {
                        downRight = qr-row-1;
                    }
                 }
                 
            }
            int attack = left + right + up + down + upLeft + upRight + downleft + downRight;
             //   System.out.println(left + " "+ right +" "+up +" "+down +" "+upLeft +" "+upRight +" "+downleft +" "+downRight);
        return attack;
    }

    // // moves += calculateDist(qr,qc, i, j);
    //     return moves;
    // }
   static int calculateDist(int qr, int qc, int x, int y){
        return (int) Math.sqrt((y-qc)*(y-qc)+(x-qr)*(x-qr));
    }
    
}