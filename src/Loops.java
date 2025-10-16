import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        ////////////////////////////////////////////////////////1
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
        ////////////////////////////////////////////////////////2
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        for (int i = 0; i <= N; i++) {
            sum+=i;
        }
        System.out.println(sum);
        ////////////////////////////////////////////////////////3
        for (int i = 1; i <=50; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
        ////////////////////////////////////////////////////////4
        int  a=11;
        while (a>1){
            a--;
            System.out.println(a);
        }
        ////////////////////////////////////////////////////////5
        int B= sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i*B);
        }
        ////////////////////////////////////////////////////////6
        int M= sc.nextInt();
        int even = 0,odd = 0;
        for (int i = 1; i <=M; i++) {
            if (i%2==0){
                even+=i;
            }
            else {
                odd+=i;
            }
        }
        System.out.println(even+" "+odd);
        ////////////////////////////////////////////////////////7
        int T= sc.nextInt();
        int facT=1;
        for (int i = 1; i <= T; i++) {
            facT*=i;
        }
        System.out.println(facT);
        ////////////////////////////////////////////////////////8
        int R= sc.nextInt();
        int F=0;
        while (R>0){
            int qaliq = R%10;
            F=F*10+qaliq;
            R=R/10;
        }
        System.out.println(F);
        ////////////////////////////////////////////////////////9
        int Y= sc.nextInt();
        int digitSum=0;
        while (Y>0){
            int digit=Y%10;
            digitSum+=digit;
            Y=Y/10;
        }
        System.out.println(digitSum);
        ////////////////////////////////////////////////////////10
        int P = sc.nextInt();
        int count = 0;
        for (int i = 1; i < P; i++) {
            if (P % i == 0){
                count++;
            }
        }
        if (count<=2){
            System.out.println("number is prime");
        }
        else {
            System.out.println("number is not prime");
        }
        ////////////////////////////////////////////////////////11
        int o= sc.nextInt();
        for (int i = 0; i < o; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }


}
