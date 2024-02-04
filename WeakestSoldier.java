
import java.util.*;
public class WeakestSoldier {
    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;

        public Row(int soldiers, int idx){
            this.soldiers=soldiers;
            this.idx=idx;
        }

        @Override
        public int compareTo(Row R){
            if(this.soldiers==R.soldiers){
                return this.idx-R.idx;
            }else{
                return this.soldiers-R.soldiers;
            }
        }
    }

    public static void main(String[] args){
        int army[][]={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k=2;

        PriorityQueue<Row> pq=new PriorityQueue<>();

        for(int i=0; i<army.length; i++){
            int count=0;
            for(int j=0;j<army[0].length;j++){
                count+=army[i][j]==1?1:0;
            }
            pq.add(new Row(count,i));
        }
        for(int i=0;i<k;i++){
            System.out.println("R" + pq.remove().idx);
        }
    }
}
