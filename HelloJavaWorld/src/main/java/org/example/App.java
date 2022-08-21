package org.example;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
//        User user = new User();
//        user.setName("Padat");
//        System.out.println(user.getName()+" ssn is :"+user.getSSN()  );
//        user.Speak("I am in dallas.");
//
//        User motamessi = new User();
//        motamessi.setName("sachin");
//        System.out.println(motamessi.getName()+" ssn is :"+motamessi.getSSN()  );
//        motamessi.Speak("i am in seatle");
//        motamessi.Walk("seatle","dallas");
         //System.out.println(AddUpTo(1000));
 //           PrintStars(4);
    PrintStarsRecursive(4);
    }

    public static int AddUpTo(int number){
       //base case
        if(number ==0 ){
            return  number;
        }
        else{
            return number+AddUpTo(number-1 );
        }
    }
    public static void PrintStars(int number){
        for(int i=0;i<=number;i++){
            for (int j =0;j<i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static void PrintStarsRecursive(int number){
        for(int i =0; i<number;i++){
            System.out.print("*");
        }
        System.out.println("");
        if(number == 0){

        }
        else{
            PrintStarsRecursive(number-1);
        }
        for(int i =0; i<number;i++){
            System.out.print("*");
        }
        System.out.println("");
    }

// first call number = 3 so return 3 + call Add
//    *
//    **
//    ***
//    ****
    //  *

}

