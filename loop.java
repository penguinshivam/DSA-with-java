import java.util.*;
public abstract class loop {
    public static void main(String args[]){

    
          // LOOPS

      // WHILE LOOP 
    int n  = 1 ;
    while(n<11){
        System.out.println(n);
         n ++;
}


//   sum of  n natural no
Scanner sc = new Scanner(System.in);
int no = sc.nextInt();
int sum = 0;
int i = 1;
while (i<=no){
    
    i ++;
    sum = sum + i;
}
System.out.println("sum of "+no+ " no is"+sum);


        FOR LOOP
int i =1;
for ( i= 1; i<=4;i++){
    System.out.println("* * * * ");
 }

// reverse of no
int  n = 10899;
   while(n>0){
   int lastdigit = n %10;
   System.out.println(lastdigit);
   n = n/10; }
 
// reverse the no
int nu = 10909;
int rev = 0;
while(nu>0){
    int lastdigit  = n%10;
    rev = (rev *10) + (int)lastdigit;
    no =no/10;

}
System.out.println(rev);
 


        //  DO WHILE
 int  n = 1;
 do{
 System.out.println("hello");
 n++;
 }while(n<=10);


        // break and continue
    for( int i =1;i<=5;i++){
        if(i==3){
            break;
        }
        System.out.println(i);
    }
    System.out.println("I am out of this loop");

// keep entering n till enter multiple
    Scanner sc = new Scanner(System.in); 

    do{
        System.out.print("enter yoour no");
        int n = sc.nextInt();

        if( n % 10 == 0){
            // break;
            continue;
        }
        System.out.println(n);
    }while(true);
    


    // prime or not
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    
    if (n ==2){
        System.out.println("prime");
    }
    else{
        boolean isprime = true;
     for(int i=2 ; i<=Math.sqrt(n) ; i++){
        if(n% i ==0){
            isprime = false;
        }

    }
    if(isprime == true){
        System.out.println("prime");
    }
    else{
        System.out.println("not prime"  );
    }
    }
    }
    
}