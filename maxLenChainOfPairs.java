import java.util.*;
public class maxLenChainOfPairs{
    public static void main(String[] args) {
        // sorting
        int pairs[][]= {{5,24},{39,60},{5,28},{27,40},{50,90}};
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));


        int maxlen=1;
        int lastEnd= pairs[0][1];
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0]>lastEnd) {
                maxlen++;
                lastEnd=pairs[i][1];
            }
        } 
        System.out.println(maxlen);
        
    }
} 
