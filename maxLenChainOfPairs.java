import java.util.*;
public class maxLenChainOfPairs{
    public static void main(String[] args) {
        int start[]={5,39,5,27,50};
        int end[]={24,60,28,40,90};

        // sorting
        int activity[][]= new int [start.length][2];

        for (int i = 0; i < start.length; i++) {
            activity[i][0]=start[i];
            activity[i][1]=end[i];
        }
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[1]));


        int maxlen=1;
        int lastEnd= activity[0][1];
        for (int i = 0; i < end.length; i++) {
            if (activity[i][0]>lastEnd) {
                maxlen++;
                lastEnd=activity[i][1];
            }
        } 
        System.out.println(maxlen);
        
    }
} 
