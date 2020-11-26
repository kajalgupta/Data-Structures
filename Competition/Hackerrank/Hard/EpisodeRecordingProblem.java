package Hackerrank.Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EpisodeRecordingProblem {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int episodes = Integer.parseInt(br.readLine());
            int[][] timing = new int[episodes][4];
            for (int i = 0; i < episodes; i++) {
                String[] str = br.readLine().split("\\s+");
                
                timing[i][0] = Integer.parseInt(str[0]);
                timing[i][1] = Integer.parseInt(str[1]);
                timing[i][2] = Integer.parseInt(str[2]);
                timing[i][3] = Integer.parseInt(str[3]);                  
            }
            System.out.println(recordingEpisodes(timing, episodes));
           
        }
    }

    private static int recordingEpisodes(int[][] timing, int episodes) {
        
        int result = 0;
        int lastEnd  = 0;
        int lastStart = 0;
        int lastEpisode = 0;
        int record = 1;
        List<List<Integer>> result = new ArrayList<>();
        if (timing[0][0] < timing[0][2]) {
            lastStart = timing[0][0];
            lastEnd = timing[0][1];
        } else {
            lastStart = timing[0][2];
            lastEnd = timing[0][3];
        }
        for (int i = 1; i < episodes; i++) {
            if (timing[i][0]>lastEnd) {
                record++;
            }
            else if (timing[i][2] > lastEnd) {
                record++;
            }
        }
        return 0;
    }
    
}