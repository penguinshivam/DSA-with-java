import java.util.PriorityQueue;

public class heapQues {
    static class cars implements Comparable<cars>{
        int distance;
        int i;
        public cars(int distance,int i){
            this.distance=distance;
            this.i=i;
        }
        @Override
        public int compareTo(cars c2){
            return this.distance-c2.distance;
        }
    }
    public static void nearbycar(int pts[][],int k){
        PriorityQueue<cars> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int dis=pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new cars(dis,i));
        }
        for (int i = 0; i < k; i++) {
           System.out.println("C"+pq.remove().i); 
        }
    }
    public static void ropes(int ropes[]) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost=0;
        while (pq.size()>1) {
            int min1=pq.remove();
            int min2=pq.remove();
            cost+=min1+min2;
            pq.add(min1+min2);
        }
        System.out.println("cost of connecting n ropes = " +cost );
    }
    static class weakt implements Comparable<weakt>{
        int noofsol,idx;
        public weakt(int noofsol,int idx){
            this.noofsol=noofsol;
            this.idx=idx;
        }
        @Override
        public int compareTo(weakt w2){
            if (this.noofsol==w2.noofsol) {
                return this.idx-w2.idx;
            }else{
                return this.noofsol-w2.noofsol;
            }
        }
    }
    public static void weaksol(int army[][],int k) {
        PriorityQueue<weakt> pq= new PriorityQueue<>();
        for (int i = 0; i < army.length; i++) {
            int count=0;
            for (int j = 0; j < army[0].length; j++) {
                count+=army[i][j]==1?1:0;
            }
            pq.add(new weakt(count, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("R"+pq.remove().idx);
        }
    }
    public static void main(String[] args) {
        int pts[][]={{3,3},{5,-1},{-2,4}};
        int k=2;
        nearbycar(pts, k);
        int ropes []={2,3,3,4,6};
        ropes(ropes);
        int army[][]={{1,0,0,0},
                      {1,1,1,1},
                      {1,1,0,0},
                      {1,0,0,0},};
        int t =2;
        weaksol(army,t);    
    }
}
