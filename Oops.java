// import java.util.Scanner;

public class Oops {
        public static void main(String args[]){
            // Pen p1 = new Pen();  //constructor,created a pen class p1
            // p1.color = "yellow";
            // p1.setcolor("blue");
            // System.out.println(p1.getcolor());
            // p1. setTip(5);
            // System.out.println(p1.getTip());
            // p1.setcolor("red");
            // // p1.color = "red";
            // System.out.println(p1.getcolor());
            
            // BankAccount myAcc = new BankAccount();
            // myAcc.username = " fvbnjm";
            // my.password = " dfghj"    // this throw error ,password is a private variable
            // myAcc.setPassword("asdfsdfc");    //we can set password 
    
    
            // Student s1 = new Student();
            // s1.name="shivam";
            // s1.roll=34;
            // s1.password="abcd";
            // s1.marks[0]=100;
            // s1.marks[1]=80;
            // s1.marks[2]=20;
            // Student s2 =new Student(s1);
            // s2.password="hello";
            // for (int i = 0; i < 3; i++) {
            //     System.out.println(s2.marks[i]);
            // }
            // Fish shark=new Fish();
            // shark.eat();
            // Dogs doby=new Dogs();
            // doby.legs=4;
            // System.out.println(doby.legs);
            // System.out.println(doby);
            // Calculator calc =new Calculator();
            // System.out.println(calc.sum((float)1.5,(float)1.5 ));
            // System.out.println(calc.sum(1,2,4));\
            // Deer d=new Deer();
            // d.eat();
            // Scanner sc = new Scanner(System.in);
            // Queen q=new Queen();
            // q.moves();
            // Student s1=new Student();
            // s1.Schoolname="njms";
            // Student s2=new Student();
            
            // System.out.println(s2.Schoolname);
            // Student s3=new Student();
            // s3.Schoolname="jawc";
            // System.out.println(s1.Schoolname);
            // System.out.println(s2.Schoolname);
            // System.out.println(s3.Schoolname);
                Deer d=new Deer();
                System.out.println(d.color);

        }
    }

    // {
    //  constructor 
    // class Student{
    //     String name;
    //     int roll;
    //     String password;
    //     int marks[];
    //     Student(Student s1){
    //         this.name=s1.name;
    //         this.roll=s1.roll;
    //         this.marks=s1.marks;
    //     }    
    //Student (){
    //  marks=new int[3];
    //         System.out.println("constructor");
    //     }
    //     Student(String name){
    //         marks=new int[3];
    //         this.name = name;
    //     }
    // }
// class Animal{
//     void eat(){
//         System.out.println("eats");
//     }
//     void breath(){
//         System.out.println("breaths");       
//     }
// }
// class Deer extends Animal{
//     // int legs;
//     void eat(){
//         System.out.println("eats grass");
//     }
// }
// class Dogs extends Mammal{
//     int bread;
// }
// class Fish extends Animal{
//     void swim(){
//         System.out.println("swims");
//     }
// }
// function over loading and function over riding
// class Calculator{
//     int sum(int a,int b){
//         return a+b;
//     }
//     float sum(float a,float b){
//         return a+b;
//     }
//     int sum(int a,int b,int c){
//         return a+b+c;
//     }
// }
// Abstract
// abstract class Animal{
//     String color;
//     abstract void walk();
//     Animal(){
//         color="brown";
//     }
// }
// class Horse extends Animal{
//     void walk(){
//         System.out.println("walk on 4 legs");
//     }
// }
// interfaces (multiple inhertance)(total abstraction)
// interface ChessPlayer {
//     void moves();
    
// }
// class Queen implements ChessPlayer{
//     public void moves(){
//         System.out.println("up,down,left,right,diagonal");
//     }
// }
// class rook implements ChessPlayer{
//     public void moves(){
//         System.out.println("up,down,left,right");
//     }
// }
// class king implements ChessPlayer{
//     public void moves(){
//         System.out.println("up,down,left,right,diagonal(by 1 step)");
//     }
// }
//} 

// class Student{
//     static int returnpercentage(int phy,int maths,int chem){
//         return (maths+phy+chem)/3;
//     }
//     String name;
//     int roll;
//     static String Schoolname;
//     void setname(String name){
//         this.name=name;
//     }
//     String getname(){
//         return this.name;
//     }
// }

class Animal{
    String color="black";
    Animal(){
        System.out.println("animal constuctor");
    }
    void eat(){
        System.out.println("eats");
    }
    void breath(){
        System.out.println("breaths");       
    }
}
class Deer extends Animal{
    
    Deer(){
        super.color="brown";
        
        System.out.println("deer constuctor");
    }
    void eat(){
        System.out.println("eats grass");
    }
}