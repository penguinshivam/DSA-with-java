public class question {

    public static int similar(int a1[],int a2[]){
        int result[]=new int[100];
        int count=0;
        for (int i = 0; i < a2.length; i++) {
            for (int j = i; j < a1.length; j++) {
                if (a1[i]==a2[j]) {
                    result[count]=a2[j];
                    count++;
                }
            }
        }
        return (a1.length+a2.length)-count;
    }
    public static void main(String[] args) {
        int a1[]={11,45,32,87,12,55,64};
        int a2[]={13,46,33,83,12,55,89};
        System.out.println(similar(a1, a2));
    }
}
