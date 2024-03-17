
// ques 1
// {
// class Student{
//     String name;
//     int marks;
// }
// public class Oopsques {
//     public static void main(String[] args) {
//         Student c=new Student();
//         c.name="aman";
//     }
// }
// }

// ques 2
// public class Oopsques {
//         public static void main(String[] args) {
//             // student s1 = new boy();
//             // boy s1 = new student();
//         }
//     }


// class student{

// }
// class boy extends student{

// }

// ques
// public class Oopsques {
//         public static void main(String[] args) {
//             Vehicle obj1=new Car();
//         //obj1.print1();
//             obj1.print();
//             Vehicle obj2=new Vehicle();
//             obj2.print();

//         }
//     }
// class Vehicle{
//     void print(){
//         System.out.println("base class (vehicle)");
//     }
// }  
// class Car extends Vehicle{
//     // void print1(){
//     //     System.out.println("child class (car)");
//     // }
//     void print(){
//         System.out.println("child class (car)");
//     }
// }  
// ques
// public class Oopsques {
//             public static void main(String[] args) {
//                 System.out.println(Book.count);
//                 Book b1=new Book(150);
//                 Book b2=new Book(150);
//                 System.out.println(Book.count);
    
//             }
//         }
// class Book{
//     int price;
//     static int count;
//     public Book(int price){
//         count++;
//     }
// }

class Test{
    static int a=10;
    static int b;
        static void changeB(){
            b=a*3;
        }
}
public class Oopsques {
                public static void main(String[] args) {
                    // Test t=new Test();
                    // t.changeB();
                    System.out.print( Test.a + Test.b );
        
                }
            }