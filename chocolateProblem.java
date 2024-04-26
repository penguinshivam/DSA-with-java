import java.util.*;
public class chocolateProblem {
    public static void main(String[] args) {
        Integer constver[] = {2,1,3,1,4};
        Integer consthor[] = {4,1,2};
        Arrays.sort(constver,Collections.reverseOrder());
        Arrays.sort(consthor,Collections.reverseOrder());
        int h=0,v=0,hp=1,vp=1,cost=0;
        while (h<consthor.length&&v<constver.length) {
            if (constver[v]<=consthor[h]) {
                cost+=(consthor[h]*vp);
                hp++;
                h++;
            }
            else{
                cost+=(constver[v]*hp);
                vp++;
                v++;
            }
        }
        while (h<consthor.length) {
            cost+=(consthor[h]*vp);
            hp++;
            h++;
        }
        while (v<constver.length) {
            cost+=(constver[v]*hp);
            vp++;
            v++;
        }
        System.out.println(cost);

    }

}
