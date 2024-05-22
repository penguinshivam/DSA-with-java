import java.util.*;

public class graphBFS {
    static class edge{
        int src,dest,wt;    
        public edge(int s, int d ,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void creategraph(ArrayList<edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0, 1, 1));
        graph[0].add(new edge(0, 2, 1));

        graph[1].add(new edge(1, 0, 1));
        graph[1].add(new edge(1, 3, 1));
        
        graph[2].add(new edge(2, 0, 1));
        graph[2].add(new edge(2, 4, 1));

        graph[3].add(new edge(3, 1, 1));
        graph[3].add(new edge(3, 4, 1));
        graph[3].add(new edge(3, 5, 1));
        
        graph[4].add(new edge(4, 2, 1));
        graph[4].add(new edge(4, 3, 1));
        graph[4].add(new edge(4, 5, 1));
        
        graph[5].add(new edge(5, 3, 1));
        graph[5].add(new edge(5, 4, 1));
        graph[5].add(new edge(5, 6, 1));

        graph[6].add(new edge(6, 5, 1));
    }
    public static void bfs(ArrayList<edge> graph[]) {
        java.util.Queue<Integer> q =new java.util.LinkedList<>();
        boolean vis[]=new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()) {
            int curr=q.remove();
            if (!vis[curr]) {
                System.out.print(curr+" ");
                vis[curr]=true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V=7;
        ArrayList<edge>[] graph=new ArrayList[V];
        creategraph(graph);
        bfs(graph);
    }
}
