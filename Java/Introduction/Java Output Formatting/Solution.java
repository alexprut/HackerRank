import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                System.out.print(s1);
                for (int j = 15 - s1.length(); j > 0; j--) {
                    System.out.print(" ");
                }
                String s2 = "" + x;
                for (int j = 3 - s2.length(); j > 0; j--) {
                    System.out.print("0");
                }
                System.out.println(s2);
            }
            System.out.println("================================");

    }
}
