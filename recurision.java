public class recurision {
    // tiling problem fitting a 2x1 tile in 2xn area of flooring(find no. of ways to fill the floor)
    public static int tilingprob (int n) {
        if (n==1 || n==0) {
            return 1;
        }
        // int verticaltile=tilingprob(n-1);
        // int horizontal = tilingprob(n-2);
        // int totalways=verticaltile+horizontal;
        return tilingprob(n-2)+tilingprob(n-1);
    }

    // duplicate char remove
    public static void removeduplicate(String str,int idx,StringBuilder newstr,boolean map[]) {
        
        if (idx==str.length()) {
            System.out.println(newstr);
            return;
        }
        char currchar=str.charAt(idx);
        if (map[currchar-'a']==true) {
            removeduplicate(str, idx+1, newstr,map);
            
        }
        else{
            map[currchar-'a']=true;
            removeduplicate(str, idx+1, newstr.append(currchar),map);
        }
    }

    //Friend pairing prob
    public static int friendsprob(int n) {
        if (n==1||n==2) {
            return n;
        }
        return friendsprob(n-1)+((n-1)*friendsprob(n-2));
    }

    // binary string without consecutive ones
    public static void binarystr(int n,int lastplace,String str ) {
        
        if (n==0) {
            System.out.println(str);
            return;
        }
        binarystr(n-1, 0, str+"0");
        if (lastplace==0) {
            binarystr(n-1, 1, str+"1");
        }
        
    }
    
    public static void main(String[] args) {
        // String str="hello";                                                    remove duplicate      
        // removeduplicate(str,0,new StringBuilder(""),new boolean[26]);
        
        // int n = 3;
        // System.out.println(friendsprob(n));
        // binarystr(n,0,"");

    }
    
}
