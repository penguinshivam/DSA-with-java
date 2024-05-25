import java.util.*;

public class graphCycleinDicected {
    static class Edge{
        int src;
        int dest;

        public Edge( int s, int d){
            this.src= s;
            this.dest = d;
        }
    } 
    static void createGraph(ArrayList<Edge> graph[]){
        for( int i=0; i< graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        // undirected
        // graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0,2));
        // graph[0].add(new Edge(0,3));

        // graph[1].add(new Edge(1,0));
        // graph[1].add(new Edge(1,2));

        // graph[2].add(new Edge(2,0));
        // graph[2].add(new Edge(2,1));

        // graph[3].add(new Edge(3,0));
        // graph[3].add(new Edge(3,4));

        // graph[4].add(new Edge(4,3));

        // directed
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
        
        
}   
// undirected graph -detect cycle
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }

            }
        }
        return false;
    }
    // O(V+E)
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr,int par){
        vis[curr] = true;

        for(int i =0; i< graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            //case3
            if(!vis[e.dest]){
                if(detectCycleUtil(graph,vis,e.dest,curr)){
                return true;
            }
        }
            //case2
            else if(vis[e.dest]&& e.dest != par){
                return true;
            }
            //case1 do nothing
        }
        return false;
    }   


    // Diercted graph detect cucle
    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for( int i=0 ;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[] , boolean stack[]){
        vis[curr] =true;
        stack[curr] =true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest,vis,stack)){
                return true;
            }
        }
        stack[curr]= false;
        return false;
    }
    public static void main(String args[]){
        // int V =5;
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));

    }
}