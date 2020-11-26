import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3SurfaceArea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int h = Integer.parseInt(str[0]);
        int w = Integer.parseInt(str[1]);
        int[][] arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            String[] str2 = br.readLine().split("\\s+");
            for (int j = 0; j < w; j++) {
            arr[i][j] = Integer.parseInt(str2[j]);      
            }
        }
        int area = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                area += 2+4*arr[i][j];
            }
        }
        //UP
        for (int i = 1; i < h; i++) {
            for (int j = 0; j < w; j++) {
                area -= (arr[i][j]>arr[i-1][j])?arr[i-1][j]:arr[i][j];
            }
        }
        //DOWN
        for (int i = 0; i < h-1; i++) {
            for (int j = 0; j < w; j++) {
                area -= (arr[i][j]>arr[i+1][j])?arr[i+1][j]:arr[i][j];
            }
        }
        //left
        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                area -= (arr[i][j]>arr[i][j-1])?arr[i][j-1]:arr[i][j];
            }
        }
        //right
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w-1; j++) {
                area -= (arr[i][j]>arr[i][j+1])?arr[i][j+1]:arr[i][j];
            }
        }
        //cuboid = 2*(lb+bh+hl) //sa = 4h+2;
        System.out.println(area);

    }
    
}