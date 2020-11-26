package LeetCodeHard;

import java.util.PriorityQueue;

public class MaximumProfitInJobScheduling {

    public static void main(String[] args) {
        int[] startTime = {1,2,3,4,6};
        int[] endTime = {3,5,10,6,9};
        int[] profit = {20,20,100,70,60};
        System.out.println(jobScheduling(startTime, endTime, profit));
    }

         static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            /* Keeps remaining jobs sorted by start time */
            PriorityQueue<int[]> startQ = new PriorityQueue<int[]>((a1, a2) -> a1[0]-a2[0]);
            /* Keeps different end time options with their max profit */
            PriorityQueue<int[]> endQ = new PriorityQueue<int[]>((a1, a2) -> a1[1]-a2[1]);
            
            for(int i=0; i<startTime.length; i++){
                startQ.offer(new int[]{startTime[i], endTime[i], profit[i]});
            }
            
            endQ.offer(startQ.poll());
            
            while(!startQ.isEmpty()){
                int[] cand = startQ.poll();
                int bestProfit = -1; 
                
                /* Searching the best profit we can make for a job starting at cand[0] */
                while(!endQ.isEmpty() && endQ.peek()[1] <= cand[0]){
                    bestProfit = Math.max(bestProfit, endQ.poll()[2]);
                }
                
                /* If there are no jobs ending before current cand, offer cand to the queue */
                if(bestProfit == -1) endQ.offer(cand);
                else{
                    /* Offer best option found so far as it will be a valid option for jobs starting after cand */
                    endQ.offer(new int[]{0, cand[0], bestProfit});
                    cand[2]+= bestProfit;
                    /* Offer combinations of current cand and best option */
                    endQ.offer(cand);
                }    
            }
            
            int res = 0;
            /* Getting max profit */
            while(!endQ.isEmpty()) res = Math.max(res, endQ.poll()[2]);
            
            return res;
        }
    }


