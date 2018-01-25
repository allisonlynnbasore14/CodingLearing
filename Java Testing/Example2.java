import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.*;
import java.util.BitSet;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Robot.*;

class ExampleProgram2 {


        public static void main(String[] args){

            // java.awt.Robot robot = new java.awt.Robot();
            // I cannot seems to import the Java Bit vecotr library, or colt for that matter
            // BitSet vec1000 = new BitSet(1000);

            // vec1000.set(378); // set bit 378 to 1 instead of the default 0
            // System.out.println(vec1000.get(378)); // return true, beucae the 378 bit is 1

            // //BitSet portion = vec1000.partFromTo(38,50); 

            // VARAGES
            int answers = add(2);
            System.out.println(answers);

            // CANDY STUFF
            Candy Sucker = new Candy("Cherry");
            Sucker.Setcost(3.00);
            Sucker.description = "YUMMY!";
            Sucker.suppliers.add("Europe");
            System.out.println(Sucker.suppliers);
            Sucker.flavorInten.put(5,"Sour");
            System.out.println(Sucker.flavorInten);

            // REGEX STUFF
            // So this stuff is really cool. It is about searching for patterns and strings.
            // I really wish I could have been on the team to develop this becuase it 
            // would have been really fun. So basically there are codes you can use to search for 
            // specfic things in a string. For example, //d searches for digits, also the 
            // special charaters '+, * , and ?' mean diffrent things than usual. They indicate how close
            // to the pattern thier search needs to be (kinda).
            String longString = "Allison Lynn Basore 785-983-4443 543 Main St Burdick Kansas 66838 ";
            //regexChecker("\\s\\d{5}\\s", longString);
            //regexChecker("\\s\\w+", longString);

            //DATA SCRTUCURES STUFF
            int a = 5;
            char b = 'A';
            String c = "The Count of Monty";
            System.out.println(c);

                // NANO TIME STUFF, this measures in nano seconds
                long startTime = System.nanoTime();
                ArrayList<Integer> testvar = new ArrayList<Integer>();
                testvar.add(4); // These take like, 1000 + nano seconds to add to the list
                long endTime = System.nanoTime();
                long diff = endTime - startTime;
                System.out.println(diff);

            Hashtable<String, String> testtable = new Hashtable<String, String>();
            testtable.put("A","B");
            testtable.put("C","D");

        }

    public static int add(int... list){
        // So this is a really cool feature
        // called vararg that lets you have
        // a variable number of input arguments
        // to the function, the ... notation is
        // what does it, and 'list' in this case
        // is the local variable for the function
        // to work with
        int sum = 0;
        for (int item : list){
            sum += item;
        }
        return sum;
    }

    // public class EvenNumber extends UnaryFunctor<Number, Boolean> {
    //     public Boolean fn(Number x){
    //         return (x.longValue() % 2) == 0;
    //     }
    // }

    public static void regexChecker(String theRegex, String str2Check){
            
            // You define your regular expression (REGEX) using Pattern
            
            Pattern checkRegex = Pattern.compile(theRegex);
            
            // Creates a Matcher object that searches the String for
            // anything that matches the REGEX
            
            Matcher regexMatcher = checkRegex.matcher( str2Check );
            
            // Cycle through the positive matches and print them to screen
            // Make sure string isn't empty and trim off any whitespace
            
            while ( regexMatcher.find() ){
                if (regexMatcher.group().length() != 0){
                    System.out.println( regexMatcher.group().trim() );
                    
                    // You can get the starting and ending indexs
                    
                    System.out.println( "Start Index: " + regexMatcher.start());
                    System.out.println( "Start Index: " + regexMatcher.end());
                }
            }
            
            System.out.println();
        }


}

class Candy {
    String kind;
    double cost;
    String description;
    ArrayList<String> suppliers = new ArrayList<String>();
    Hashtable<Integer, String> flavorInten = new Hashtable<Integer, String>();

    public Candy(String kind){
        this.kind = kind;
    }

    public void Setcost(double costInput){
        double tax = costInput * 0.2;
        cost = costInput + tax;
    }
}