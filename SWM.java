/*  Sliding Window Maximum
 * 
 * Maximum of all subarray of size K
 * 1, 2, 3, 4, 5, 6, 7, 8, 10       k=3
 * 
 * ans= 3, 4, 5,6 ,7 ,8, 9, 10 
 */
import java.util.*;
public class SWM {
    static class pair implements Comparable<pair>{
        int val;
        int idx;

        public pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }

        @Override
        public int compareTo(pair P){
            return P.val-this.val;
        }
    }

    public static void main(String[] args){
        int arr[]= {1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]=new int[arr.length-k+1];

        PriorityQueue<pair> pq= new PriorityQueue<>();

        //1st window
        for(int i=0;i<k;i++){
            pq.add(new pair(arr[i], i));
        }

        res[0]= pq.peek().val;

        for(int i=k;i<arr.length;i++){
            while(pq.size()>0 && pq.peek().idx<=(i-k)){
                pq.remove();
            }
            pq.add(new pair(arr[i],i));
            res[i-k+1]=pq.peek().val;
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+ " ");
        }
    }
}
