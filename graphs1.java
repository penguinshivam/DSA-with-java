import java.util.*;
public class graphs1 {
    static class edge{
        int src,dest,wt;    
        public edge(int s, int d ,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void main(String[] args)  {
        int V=5;
        @SuppressWarnings("unchecked")
        ArrayList<edge>[] graph=new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i]=new ArrayList<>();
        }
        // 0 verticeL
        graph[0].add(new edge(0, 1, 5));

        graph[1].add(new edge(1, 0, 5));
        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 3, 3));
        
        graph[2].add(new edge(2, 1, 1));
        graph[2].add(new edge(2, 3, 1));
        graph[2].add(new edge(2, 4, 2));
        
        graph[3].add(new edge(3, 1, 3));
        graph[3].add(new edge(3, 2, 1));
        
        graph[4].add(new edge(4, 2, 2));
        for (int i = 0; i < graph[2].size(); i++) {
            edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }
}
