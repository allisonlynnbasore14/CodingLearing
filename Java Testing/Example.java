//A Very Simple Example
//Run javac Example.java
//Run java ExampleProgram
import java.awt.*;

//This deck class is an example of an object that is an array of objects(cards)
class Deck{
  Card [] cards;//making an array of cards labeled card

  //This is just like the build deck function in teh cards class except it is a constructor
  // a constuctor a special method that initalizes variables of a newly constructed object
  public Deck(){
    cards = new Card[52];
    int index = 0;
    for (int suit = 0;suit<=3; suit++){
      for (int rank = 1;rank<=13; rank++){
        cards[index] = new Card(suit, rank);
        index ++;
      }
    }
  }
  public static void main(String[] args){
    System.out.println("This is the main function");
    Deck deck1 = new Deck();
    Card threeOfClubs = new Card(0,3);
    int p = FindCard(deck1, threeOfClubs);// finds the index of the card that matches the one you sent it
    System.out.println(p);
    Shuffle(deck1);
    swapCard(3,4,deck1);
  }

    public static void printdeck(Deck deck1){
      //deck1.cards is referenceing the cards in the input variable
      for (int i=0;i<deck1.cards.length;i++){
      Card.PrintCards(deck1.cards[i]);// referencing the print card function of the card class
    }
  }

    public static int FindCard(Deck deck1, Card c){
    for (int i = 0; i<deck1.cards.length; i++){
      if (Card.SameCard(deck1.cards[i], c)){
        return i;
      }
    } 
    return 0;
  }

  public static void swapCard(int a, int b, Deck deck1){
    Card m = deck1.cards[b];
    int m2 = m.suit;
    int m3 = m.rank;
    Card n = deck1.cards[a];
    m.suit = n.suit;
    n.suit = m2;
    m.rank = n.rank;
    n.rank = m3;
  }

  public static void Shuffle(Deck deck1){
    for(int i= 0;i<deck1.cards.length;i++){
      double t = Math.random()*10;
      double t2 = Math.random();
      int high = 1;
      int low = deck1.cards.length;
      double a = (t*high + t2*low)/2;
      int av = (int) a;
      swapCard(av,i,deck1);
      Card.PrintCards(deck1.cards[i]);
    }

  }

}

class Card{
  int rank, suit;

  public Card(){
    this.rank = 0; this.suit = 0;
  }

  public Card (int suit , int rank){
    this.suit = suit; this.rank = rank;
  }
  public static void main (String[] args){
  Card threeOfClubs = new Card(0,3);
  Card twoOfHearts = new Card(2,2);
  PrintCards(threeOfClubs);
  boolean m = SameCard(threeOfClubs, twoOfHearts);
  System.out.println(m);
  int mn = CompareCard(threeOfClubs, twoOfHearts);
  System.out.println(mn);
  Card [] deck = new Card [52];
  int index = 0;
  for (int suit = 0; suit <= 3; suit++){
    for (int rank = 1; rank <= 13; rank++){
      deck[index] = new Card(suit, rank);
      index ++;
    }
  }
  PrintCards(deck[4]);
  int mnm = FindCard(deck, threeOfClubs);
  PrintCards(deck[mnm]);
  int mnmm = FindBisec(deck, threeOfClubs, 0, deck.length);
  System.out.println(mnmm);
  PrintCards(deck[mnmm]);


}
  public static void PrintCards(Card c){
    //Making a string array
    String[] suits = {"Clubs", "Diamonds","Hearts","Spades"};
    String[] rank = {"narf","Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    //narf will never be used and is a placeholder for zero
    System.out.println(rank[c.rank]+" of "+suits[c.suit]);
    }

  public static int FindBisec(Card [] deck, Card c, int low, int high){
    if (high <= low){
      return -1;
    }
    int start = (low + high)/2;
    int compare = CompareCard(deck[start], c);
    if (compare == 0){
      return start;
    }
    else if (compare == 1){
      return FindBisec(deck, c, low, start-1);
    }
    else{
      return FindBisec(deck, c, start+1, high);
    }
  }


  public static int FindCard(Card [] deck, Card c){
    for (int i = 0; i<deck.length; i++){
      if (SameCard(deck[i], c)){
        return i;
      }
    } 
    return 0;
  }
  public static boolean SameCard(Card c, Card d){
    //This returns boolean of true if both are correct
    return(c.suit == d.suit && c.rank == d.rank);
  } 

  public static int CompareCard(Card c, Card d){
    //This reuturns a 1 if the first card is greater and a 2 if the second one is
    if (c.suit > d.suit) return 1;
    if (c.suit < d.suit) return 2;
    if (c.rank > d.rank) return 1;
    if (c.rank < d.rank) return 2;
    else return 0;
  }
}

//Shallow Equality is when two object are each other
//Deep Equality is when two obejects are seperate but equal

class Time{
  //Default sets them to zeros
  int hour, minute;
  double second;

  public Time(){
    this.hour = 0;
    this.minute = 0;
    this.second = 0.0;

}
    public Time (int hour, int minute, double second){
      this.hour = hour;
      this.minute = minute;
      this.second = second;
    }

  public static void main (String[] args){
  // The 11 is the hour, 8 is the minute and 3.14 the second
  Time t2 = new Time (11,8,3.1415926535897932384626);
  Time t1 = new Time (2,120,90.0);
  Time sum = new Time();

  //makes an array of four intergetrs, you have to make it a new instance and then fill it
  int [] arrya1 = new int [4];
  arrya1 [0] = 4;
  arrya1 [1] = 4;
  arrya1[1]++;
  arrya1 [2] += 4;
  arrya1 [3] -= 4;

  int step = 0;
  while (step < 4){
    System.out.println(arrya1[step]);
    step ++;
  }

  //this is called aliasing, assinging a single object to two variables, a change in one makes the change in the other
  double [] a = new double[3];
  a[2] = 393939;
  double [] b = a;
  double [] d = new double[3];
  double [] e = new double[3];
  // this is coping the values of one array into a diffrent one so the changes in one are not reflected in another
  double [] c = new double[3];
  int [] f = new int[3];
  a[1] = 393939.9;
  d[0] = 3;
  int step2 = 0;
  int [] m = clonearray(f);
  System.out.println(m);
  while (step2 < 3){
    c[step2] = a[step2];
    step2 += 1;
  }

  // for loop syntax: for(initalizer;condition;incrementor)
    for (int step3 = 0; step3<a.length; step3++ ){
      e[step3] = d[step3];
      System.out.println(d[step3]);
    }

  System.out.println(e[1]);

  for (int step4=0;step4<4;step4++){
    double x = Math.random();
    double x2 = Math.random();
    int high = 300;
    int low = 200;
    double av = (x*high + x2*low)/2;
    System.out.println(av);
  }

  printTime(t2);
  increment(t2, 160.4);
  printTime(t2);
  printTime(t2);
  Time mmm = addTime(t2, t1);
  printTime(mmm);
  Time sumed = addTime2(t1, t2, sum);
  printTime(sumed);
  double [] mmary = multiarray(8);
  printarray(mmary);

    }

    public static int[] clonearray(int[] m){
      int [] b = new int[m.length];
      for (int step = 0; step < m.length; step++){
        b[step] = m[step];
      }
      return b;
    }

    public static double[] multiarray(int n){
      double [] m = new double[n];
      for (int i = 0; i<m.length;i++){
        m[i] = Math.random();
      }
      return m;
    }

    public static void printarray(double[] m){
        for (int step3 = 0; step3<m.length; step3++ )
      System.out.println(m[step3]);
    }
    public static void printTime(Time t){
      System.out.println(t.hour + ":" + t.minute + ":" + t.second);
    }

    //This is an example of a pure function
    public static Time addTime(Time ta, Time tb){
      Time sum = new Time();
      sum.hour = ta.hour + tb.hour;
      sum.minute = ta.minute + tb.minute;
      sum.second = ta.second + tb.second;

      while (sum.second>60){
        sum.second -= 60.0;
        sum.minute += 1;
      }
      while (sum.minute>60){
        sum.minute -= 60;
        sum.hour += 1;
      }
      return sum;
    }
    //The while statement makes it do values over 60
    //This is an example of the modifier method
    public static void increment(Time t, double add){
      t.second += add;
      while (t.second>60){
        t.second -= 60.0;
        t.minute += 1;
      }
      while (t.minute>60){
        t.minute -= 60;
        t.hour += 1;
      }
    }
    //Example of a fill-in method, requries you to input a new object to fill
    public static Time addTime2(Time ta, Time tb, Time sum){
      sum.hour = ta.hour + tb.hour;
      sum.minute = ta.minute + tb.minute;
      sum.second = ta.second + tb.second;

      while (sum.second>60){
        sum.second -= 60.0;
        sum.minute += 1;
      }
      while (sum.minute>60){
        sum.minute -= 60;
        sum.hour += 1;
      }
      return sum;

    }


  }



class ExampleProgram {
//Math is also a class

//Point originOne = new Point(23, 94);
//int x = originOne.x;

//VARIABLES
//Primative variabels are lowercase and are int and boolean
//object variabels are uppercase
//

//You can have two functions that are called the same thing
//AS long as the two functions take diffrent number of k okparameters 

//This works for regular java functions too, so be careful with which ones you are using
  // AND is &&
  // OR is ||
  // NOT is !

  //Three types of functions:
  //A Pure functios take arguments but dose not modify them
  //A modified modified some of the arugemnet
  // Fill in method: ooe of the arguemtns is an empty obejct that gets filled in by the methdo

//STRINGS are immutable, things like toUppercase make a new string

  //Ints and doubles are not objects
  //Springs are objects

  //characters are single quoted
  //stings are double quoted

//main, exp, sqrt are all methods
   public static void main(String[] args){
   		//You can assin a variable type and its value at the same time
   		//double pinum = 3.14159;
   		//double root = Math.sqrt(17.0);
   		//double p = Math.exp(Math.log(10.0));
   		//You have to have the ln after print for a new line
        //You can count back from letter too
        //char bb = 'b';
        //bb--;
        //bb--;
        //int bbb = 5;

        //System.out.println(bb);
        //countdown(2);
        //int fred = 5;
        //char chartest = 'c';
        //System.out.println(chartest);
        //System.out.println(fred);
        //fred = 7;
        //System.out.println(fred);
        //System.out.println("I'm a Simple DUH Program");
        //int pp = frac(4);
        //System.out.println(pp);
        //double k = distance(1,2,4,6);
        //double c = circle(0,0,0,1);
        //double kk = fibb(5);
        //System.out.println(kk);
        //System.out.println(c);
        //System.out.println(k);
        //System.out.println(4+3);
        //System.out.println(pinum);
        //System.out.println(root);
        blankLine();
        //if (issingle(20000)) {
        //  System.out.println("N is small");
        //} else{
        //  System.out.println("N is not small");
        //}
        Point originOne = new Point(23, 94);
        int xp = originOne.x;
        System.out.println(xp);

        logicA(3);
        //boolean bm = issingle(-3);
        //System.out.println(bm);
        //double m = absolutevalue(-20);
        //System.out.println(m);
        //System.out.println(Math.PI);
        //System.out.println(p);
        //printTwice("Never say Never");
        //printLog(10);

        //Class notes:
        //Everytime you write a class definiotn you crate a new object type



        char x10 = 'c';
        x10 ++;
        System.out.println(x10);
        //x10 = x10 + '1';
        //This dose not work for characters but does for intergers
        String name = "Allison Basore";
        String nname = name.toUpperCase();
        //This is how you compare strings
        String name2 = "ALLISON BASORE";
        if (name.equals(name2)) {
          System.out.println("EQUAL NAMES");
        } else{
          System.out.println("NOT EQUAL NAMES");
        }
        
        //use compareTo to compare alphabets

        System.out.println(nname);

        char letter1 = 'J';
        while (letter1 <='Q'){
          if (letter1 == 'Q'|| letter1 == 'O'){
            System.out.println(letter1 + "uack");
            letter1++;
          } else{
          System.out.println(letter1 + "ack");
          letter1 ++;
          }
        }

        String ban = "banana";

        //Adds one to counting
        int counting = 22;
        counting++;
        System.out.println(counting);
        //invoking the charAt metod on teh obejct ban
        char letter = ban.charAt(5);
        int length = ban.indexOf('b');
        System.out.println(length);
        System.out.println(letter);
        int mm = countwords("allison lynn basore", 'l');
        System.out.println(mm);
        //Java automatically concatneates intergers and floating points and anythign with a string
        System.out.println(4 + 9.3);

        // ++ adds one and -- subtracts one to an interger or an char

        //If you do not assin it, it dose nothing with it
        double n = Math.PI;
        double x = 0;
        if (x==0) {
          System.out.println("x is zero");
        } else {
          if (x<0){
          System.out.println("x is negative");
        } else {
          System.out.println("x is postive");
        } 

      }

   }

  // The double instead of void means this will return a double instead of nothing
  public static double area (double radius) {
    double area = Math.PI * radius *radius;
    return area;
  }

  public static int countwords(String wordto, char letterto){
  int count = 0;
  int length = wordto.length();
  int index = 0;
  while (index < length) {
    if (wordto.charAt(index) == letterto){
      count = count +1;
    } 
    index = index + 1;
  }
  System.out.println(count);
  return count;
  }

  public static boolean issingle (int x) {
    if (x >= 0 && x<10){
      return true;
    } else {
      return false;
    }

  }

  public static void countdown(int n){
    while (n>0){
      System.out.println(n);
      n = n -1;
    }
    System.out.println("Blast Off");

  }

  public static int fibb(int x){
    if (x==0 || x == 1){
      return 1;
    }else{
      return fibb(x-1) + fibb(x-2);
    }
  }

  public static int frac (int x){
    if (x == 0) {
      return 1;
    }
    else{
      return x*frac(x-1);
    }
  }


  public static double circle(double xc, double yc, double cp, double yp){
    double radius = distance(xc, yc, cp, yp);
    double area = area(radius);
    return area;

  }


  public static void logicA(double x){
    if (x>0){
      if (x<10){
        System.out.println("It is a postive single digit");
      }

    }

  }

  public static double distance (double x1 , double y1, double x2, double y2) {
    double dx = x2-x1;
    double dy = y2-y1;
    double distance = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    return distance;

  }
// A function dose not have to be above its call
	public static void blankLine() {
		System.out.println("");
		System.out.println("boo!");

	}

  public static double absolutevalue(double x) {
    if (x<0) {
      return -x;
    } else {
      return x;
    }

  }

	public static void printTwice(String ToPrint) {
		System.out.println(ToPrint); System.out.println(ToPrint); 

  }
  public static void printLog(double v) {
    if (v<= 0.0) {
      System.out.println("Only positive numbers");
      return;
    } 

    double result = Math.log(v);
    System.out.println("The log of v is  " + result );
  }


	

}
