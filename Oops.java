
    public class Oops {
        public static void main(String args[]){
            Pen p1 = new Pen();  //constructor,created a pen class p1
            p1.color = "yellow";
            p1.setcolor("blue");
            System.out.println(p1.getcolor());
            p1. setTip(5);
            System.out.println(p1.getTip());
            p1.setcolor("red");
            // p1.color = "red";
            System.out.println(p1.getcolor());
            
            BankAccount myAcc = new BankAccount();
            myAcc.username = " fvbnjm";
            my.password = " dfghj"    // this throw error ,password is a private variable
            myAcc.setPassword("asdfsdfc");    //we can set password 
    
    
            Student s1 = new Student("palak");
            System.out.println(s1.name);
            Pen p1 = new Pen("blue");
            System.out.println(p1.getcolor());
            System.out.println(p1.color);
            p1.setcolor("green");
            Pen p1 = new Pen("green");
            p1.color = "green";
             System.out.println(p1.color);
        }
    }
    class BankAccount{
        public String username ;
        private String password; 
        public void setPassword(String pwd){
            password = pwd; 
           }
    
    
    // }
    class Pen{
        private String color;
        public int tip;
    
        Pen (String color){
            this.color = color;
        }
    
        // function for color change
        void setcolor(String newColor){
            color = newColor;    
        }
        String getcolor(){
            return this.color;
        }
    }
         // function for tip change
        void setTip(int newTip){
            tip = newTip;    
        }
        // getter and setters
    
        int getTip(){
            return this.tip;
        }
    }
    class Student{
        String name;int age; float percentage;
        void calPrcentage(int maths,int chem ,int phy){
            percentage = (phy+ chem + maths)/3;
        }
    }
    
    //  constructor 
    class Student{
        String name;
        int roll;
    
        Student(String name){
            this.name = name;
        }
        Student (String name){
        }  
        // return null
    
        // constructor overloading 
        Student (){
            System.out.print("constructor");
        }
    }
    