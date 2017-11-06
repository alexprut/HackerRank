 public PerformOperation isOdd() {
     return (num) -> num % 2 != 0;
 }

 public PerformOperation isPrime() {
     return (num) -> {
         for (int i = 2; i <= num/2; i++) {
             if (num % i == 0) { return false; }
         }
         return true;
     };
 }

 public PerformOperation isPalindrome() {
    return (num) -> Integer.toString(num).equals( new StringBuilder(Integer.toString(num)).reverse().toString() );
 }
}
