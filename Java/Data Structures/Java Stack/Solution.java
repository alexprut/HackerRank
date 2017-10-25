import java.util.*;
class Solution{

   private static boolean isBalanced(String query) {
       Stack<Character> s = new Stack<Character>();
       for (int i = 0; i < query.length(); i++) {
           if (query.charAt(i) == '(' || query.charAt(i) == '[' || query.charAt(i) == '{') {
               s.push(query.charAt(i));
           }
           if (query.charAt(i) == ')' || query.charAt(i) == ']' || query.charAt(i) == '}') {
               if (s.empty()) {
                   return false;
               }
            if (query.charAt(i) == ')') {
               if (s.peek() == '(') {
                   s.pop();
               } else {
                   return false;
               }
           }
           if (query.charAt(i) == ']') {
               if (s.peek() == '[') {
                   s.pop();
               } else {
                   return false;
               }
           }
           if (query.charAt(i) == '}') {
               if (s.peek() == '{') {
                   s.pop();
               } else {
                   return false;
               }
           }
           }
       }

       return s.empty();
   }

   public static void main(String []argh)
   {
      Scanner sc = new Scanner(System.in);

      while (sc.hasNext()) {
         String input=sc.next();
            System.out.println(Solution.isBalanced(input));
      }

   }
}
