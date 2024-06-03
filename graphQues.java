import java.util.*;

public class graphQues {
    class Solution {
    int ans=-1,val=0;
        public void dfs(int n,ArrayList<ArrayList<Integer>> adj,boolean vis[],int quiet[]){
            vis[n]=true;
            for(int x:adj.get(n)){
                if(!vis[x]){
                if(val>quiet[x]){
                    val=quiet[x];
                    ans=x;
                }
                if(ans==-1) ans=n;
                dfs(x,adj,vis,quiet);
                }
            }
        
        }
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
            int i,n=quiet.length;
            int res[]=new int[n];
            for(i=0;i<n;i++){
                res[i]=i;
            }
            for(i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int r[]:richer){
                int u=r[0];
                int v=r[1];
                adj.get(v).add(u);
            }
        for(i=0;i<n;i++){
            boolean vis[]=new boolean[n];
            val=quiet[i];
            dfs(i,adj,vis,quiet);
            if(ans==-1) ans=i;
            res[i]=ans;
            ans=-1;
            }
            return res;
        }
        

    }
    static class info{
        int src,dest,wt;    
        public info(int s, int d ,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void createGraph(int flights[][],ArrayList<info>[] graph)  {
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt=flights[i][2];

            info e =new info(src, dest, wt);
            graph[src].add(e);
        }
    }
    static class pair {
        int v,cost,stop;
        public pair(int v,int cost,int stop){
            this.v=v;
            this.cost=cost;
            this.stop=stop;
        }
    }
    public static int cheapestFlightKStop(int n,int flights[][],int src,int dest,int k){
        @SuppressWarnings("unchecked")
        ArrayList<info> graph[]=new ArrayList[n];
        createGraph(flights, graph);

        int dist[]=new int[n];
        for (int i = 0; i < graph.length; i++) {
            if (i!=src) {
                dist[i]=Integer.MAX_VALUE;
            }
        }        
        // boolean vis[]=new boolean[graph.length];
        java.util.Queue<pair> q=new LinkedList<>();
        q.add(new pair(src, 0,0));
        while (!q.isEmpty()) {
            pair curr =q.remove();
            if (curr.stop>k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                info e= graph[curr.v].get(i);
                @SuppressWarnings("unused")
                int u =e.src;
                int v =e.dest;
                int wt =e.wt;
                if (curr.cost+wt<dist[v] && curr.stop<=k) {
                    dist[v]=curr.cost+wt;
                    q.add(new pair(v, dist[v],curr.stop+1));
                }
            }
            
        }
        if (dist[dest]==Integer.MAX_VALUE) {
            return -1;
        }
        else{
            return dist[dest];
        }
    }
    static class Edge implements Comparable<Edge>{
        int dest,cost;
        public Edge(int d, int c){
            this.dest=d;
            this.cost=c;
        }@Override
        public int compareTo(Edge e2){
            return this.cost-e2.cost;
        }
    }
    public static int connectCitties(int cities[][]) {
        PriorityQueue<Edge> pq =new PriorityQueue<>();
        boolean vis[]=new boolean[cities.length];
        pq.add(new Edge(0, 0));
        int finalcost=0;
        while (!pq.isEmpty()) {
            Edge curr=pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest]=true;
                finalcost+=curr.cost;
                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i]!=0) {
                        
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalcost;
    }
    public static void main(String[] args) {
        int src=0,dest=3,k=1,n=4;
        int flight[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(cheapestFlightKStop(n,flight,src,dest,k));
        int cities[][]={{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        System.out.println(connectCitties(cities));
        
    }
}
