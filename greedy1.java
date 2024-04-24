import java.util.*;
public class greedy1{
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};

        // sorting
        int activity[][]= new int [start.length][3];

        for (int i = 0; i < start.length; i++) {
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));


        int maxactiv=0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxactiv=1;
        // ans.add(0);
        ans.add(activity[0][0]);
        // int lastEnd= end[0];
        int lastEnd= activity[0][2];

        // for (int i = 0; i < end.length; i++) {
        //     if (start[i]>=lastEnd) {
        //         maxactiv++;
        //         ans.add(i);
        //         lastEnd=end[i];
        //     }
        // } 
        for (int i = 0; i < end.length; i++) {
            if (activity[i][1]>=lastEnd) {
                maxactiv++;
                ans.add(activity[i][0]);
                lastEnd=activity[i][2];
            }
        } 
        System.out.println("max activity"+maxactiv);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}