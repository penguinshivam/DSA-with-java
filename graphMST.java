import java.util.*;

public class graphMST {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge( int s, int d,int w){
            this.src= s;
            this.dest = d;
            this.wt = w;
        }
    } 
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for( int i=0; i< graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,0,30)); 
        graph[3].add(new Edge(3,1,40)); 
        graph[3].add(new Edge(3,2,50)); 
            
    }  
    
    public static void primsAlgo(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalcost=0;
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v]=true;
                finalcost+=curr.cost;
                for (int index = 0; index < graph[curr.v].size(); index++) {
                    Edge e= graph[curr.v].get(index);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }

        }
        System.out.println(finalcost);
    }
    public static void main(String[] args) {
        int V=4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        primsAlgo(graph); 
        
    }
}
