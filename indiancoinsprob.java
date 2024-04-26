import java.util.*;
public class indiancoinsprob {

    public static void main(String[] args) {
        int den[]={1,2,5,10,20,50,100,500,2000};
        int v=745;
        int count=0;
        ArrayList<Integer> arr= new ArrayList<>();
        while (v!=0) {
            for (int i = den.length-1; i >=0; i--) {
                if (v >=den[i]) {
                    arr.add(den[i]);
                    count++;
                    v =v-den[i];
                    break;
                }
            }
        }
        System.out.println(count);
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i)+"+");    
            
        }
    }
}
