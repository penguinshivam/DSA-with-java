import java.util.ArrayList;

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
    public static void main(String[] args) {
        
    }
}
