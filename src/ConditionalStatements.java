import java.util.Scanner;

public class ConditionalStatements {
    public static void main(String[] args) {
        //1
        Scanner sc = new Scanner(System.in);
//        int Num= sc.nextInt();
//        if (Num%2==0){
//            System.out.println("Num is even");
//        }
//        else {
//            System.out.println("Num is odd");
//        }
        //2
//        int check= sc.nextInt();
//        if (check>0){
//            System.out.println("Check is positive");
//        }
//        else if (check<0) {
//            System.out.println("Check is negative");
//        }
//        else {
//            System.out.println("Check is zero");
//        }
        //3
//        int a= sc.nextInt() ,b= sc.nextInt();
//        if (a>b){
//            System.out.println(a);
//        }
//        else if (a<b) {
//            System.out.println(b);
//        }
//        else {
//            System.out.println("a equal to b");
//        }
        //4
//        int score = sc.nextInt();
//        if (score<0 || score>100){
//            System.out.println("Invalid score");
//        }
//        else if (score>50) {
//            System.out.println("Pass");
//        }
//        else {
//            System.out.println("Fail");
//        }
        //5
//        int year=sc.nextInt();
//        if ((year%4==0 && year%100!=0) || (year%400==0)){
//            System.out.println("Leap year");
//        }
//        else {
//            System.out.println("Not leap year");
//        }
        //6
//        int point = sc.nextInt();
//        if (point < 0 || point > 100) {
//            System.out.println("Invalid point");}
//        else {
//            switch (point / 10) {
//                case 9,10 -> System.out.println("A");
//                case 8 -> System.out.println("B");
//                case 7 -> System.out.println("C");
//                case 6 -> System.out.println("D");
//                default -> System.out.println("E");
//            }
//        }
        //7
//        int num1= sc.nextInt(), num2= sc.nextInt(), num3 = sc.nextInt();
//        if (num1>num2 && num1>num3){
//            System.out.println(num1);
//        }
//        else if (num2>num1 && num2>num3) {
//            System.out.println(num2);
//        }
//        else {
//            System.out.println(num3);
//        }
        //8
//        System.out.println("first write operator than numbers");
//        String operator = sc.next();
//        double c= sc.nextInt(),d= sc.nextInt();
//        switch (operator){
//            case "+" -> System.out.println(c+"+"+d+"="+(c+d));
//            case "-" -> System.out.println(c+"-"+d+"="+(c-d));
//            case "*" -> System.out.println(c+"*"+d+"="+(c*d));
//            case "/" -> {
//                if (d == 0)
//                    System.out.println("Cannot divide by zero");
//                else
//                    System.out.println(c+"/"+d+"="+(c/d));
//            }
//            default -> System.out.println("Invalid operator");
//        }
        //9
//        int day= sc.nextInt();
//        switch (day){
//            case 1 -> System.out.println("Monday");
//            case 2 -> System.out.println("Tuesday");
//            case 3 -> System.out.println("Wednesday");
//            case 4 -> System.out.println("Thursday");
//            case 5 -> System.out.println("Friday");
//            case 6 -> System.out.println("Saturday");
//            case 7 -> System.out.println("Sunday");
//            default -> System.out.println("Invalid day");
//        }
        //10
        int TPA= sc.nextInt();
        if (TPA>=1000){
            TPA=TPA-(TPA/100*20);
            System.out.println(TPA);
        }
        else if (TPA>=500){
            TPA=TPA-(TPA/100*10);
            System.out.println(TPA);
        }
        else {
            System.out.println("No discount");
        }
    }
}
