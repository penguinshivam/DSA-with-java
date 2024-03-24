import java.util.ArrayList;

public class pairsum {

    // public static boolean pairsum(ArrayList<Integer> list,int target) {
    //     for (int i = 0; i < list.size(); i++) {
    //         for (int j = i+1; j < list.size(); j++) {
    //             if (list.get(i)+list.get(j)==target) {
    //                 System.out.println(list.get(i)+","+list.get(j));
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    // optimise
    // public static void optimise(ArrayList<Integer> list, int target){
    //     int lp=0;
    //     int rp=list.size()-1;
    //     while (lp<rp) {
    //         if (list.get(lp)+list.get(rp)==target) {
    //             System.out.println(list.get(lp)+","+list.get(rp));
    //             return;
    //         }
    //         else if  (list.get(lp)+list.get(rp)>target){
    //             rp--;
    //         }
    //         if (list.get(lp)+list.get(rp)<target){
    //             lp++;
    //         }
    //         else{
    //             System.out.println("pair doesnt exist");
    //         }
            
            
            
    //     }

    // }
    public static boolean pairsumrotedandsorted(ArrayList<Integer> list,int target){
        int bp=-1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)>list.get(i+1))
            {
                bp=1;
                break;
            }
        }
        int n=list.size();
        int lp=bp+1;
        int rp=bp-1;
        while (lp!=rp) {
            if (list.get(lp)+list.get(rp)==target) {
                System.out.println(list.get(lp)+","+list.get(rp));
                return true;
            }
            if  (list.get(lp)+list.get(rp)>target){
                rp=(n+rp-1)%n;
            }
            else{
                lp=(lp+1)%n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(11);
        height.add(15);
        height.add(6);
        height.add(7);
        height.add(9);
        height.add(10);
        int target =100;
        pairsumrotedandsorted(height, target);
        System.out.println(pairsumrotedandsorted(height, target));
        // pairsum(height, target);
        // System.out.println(pairsum(height, target));
        // optimise(height, target);
        
    }
}
