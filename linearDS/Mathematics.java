import java.util.*;

public class Mathematics {

    public void checkNumberDivisible(int numberTodivide, int divisibleNo){
        if(numberTodivide % divisibleNo == 0){
            System.out.println("The given number "+numberTodivide+" divisible with "+ divisibleNo);
        }
        else{
            System.out.println("The given number "+numberTodivide+" is not divisible with "+ divisibleNo);
        }
    }

    public void countNoofDigits(int number){
        int givenNo = number;
        int res = 0;
        while(number > 0){
            number = number / 10;
            res += 1;
        }
        System.out.println("Number of digits in a given Number "+givenNo+" is "+ res);
    }

    public void digitSum(int number){
        int givenNo = number;
        int sum = 0;
        while(number != 0){
            sum += (number % 10);
            number  = number / 10;
        }
        System.out.println("Sum of digits of given number "+givenNo+" is "+sum);
    }

    public void gcdandLcmOfTwoNumbers(int x, int y){
        System.out.println("The GCD of given numbers is: "+ GCD(x, y));
        System.out.println("The LCM of given numbers is: "+ LCM(x, y));
    }

    public int GCD(int a, int b){
        if(a == 0){
            return b;
        }
        return GCD(b % a, a);
    }

    public int LCM(int a, int b){
        return (a * b)/GCD(a, b);
    }

    public void Factorial(int value){
        System.out.println("The factorial of given number "+value+" : "+factorialofNumber(value) );
    }

    public int factorialofNumber(int number){
        if(number == 0){
            return 1;
        }
        return number * factorialofNumber(number - 1);
    }
    
    public void trailingZerosofFactorial(int number){
        int res = 0;
        int factorialNumber = factorialofNumber(number);
        while(factorialNumber != 0){
            if(factorialNumber % 10 == 0){
                res += 1;
            }
            factorialNumber = factorialNumber/10;
        }
        System.out.println("The Number of Trailing Zeros of factorial of given number "+number+" : "+res);
    }

    public void primeCheck(int N){
        if(prime(N)){
            System.out.println("The given number "+N+" is a prime number");
        }
        else{
            System.out.println("The given number "+N+" is not a prime number");
        }
    }

    private boolean prime(int number){
        if(number < 2){
            return false;
        }
        for(int i = 2; i <= number - 1; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public void primeNumbers(int number){
        int prime_numbers[] = generatePrimes(number);
        for(int x : prime_numbers){
            System.out.print(x+" , ");
        }
        System.out.println();
    }

    private int[] generatePrimes(int N){
        if(N < 2){
            return new int[0];
        }
        boolean isPrime[] = new boolean[N+1];
        for(int i = 2; i<=N; i++){
            isPrime[i] = true;
        }
        for(int i = 2; i*i <= N ; i++){
            if(isPrime[i]){
                for(int j = i*i; j <= N ; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        int primesCount = 0;
        for(int i = 2;i <= N; i++){
            if(isPrime[i]){
                primesCount++;
            }
        }
        int primes[] = new int[primesCount];
        int index = 0;
        for(int i = 2; i <= N; i++){
            if(isPrime[i]){
                primes[index++] = i;
            }
        }
        return primes;
    }

    /* 
     To find the number of digits in the factorial of a given integer we can use Logarithms to avoid computing very large factorial directly. 
     The number of digits d in a number x can be found using the formula : d = |Log10(x)| + 1;
     For a Factorial we use the properties of logarithms to calculate digits of every number ,
     Log10(N!) = Log10(1) + Log10(2) + --- + Log10(N). Therefore, No of digits in a factorila is d = |Log10(N!)| + 1.
     
     */

     public void digitsinFactorial(int num){
        double noofDigits = 0;
        for(int i = 1;i<=num;i++){
            noofDigits += Math.log10(i);
        }
        int Digits = (int) Math.floor(noofDigits) + 1;
        System.out.println("No of Digits of given factorial of number : "+Digits);
    }

    /* To determine how many numbers less than or equal to N have exactly three divisors , we need to recognize 
    a key mathematical property : a number has exactly three divisors if and only if it is a square of a prime number
    Prime Number p has exactly two divisors 1 and p. the square of a prime number p*p has three divisors 1, p, p*p.
    */

    public void Numberswith3Divisors(int num){
        System.out.println(threeDivisorsuptoN(num)+" numbers up to N has exactly three divisors");
    }

    public int threeDivisorsuptoN(int N){
        int numberswith3Divisors = 0;
        if(N < 2){
            return 0;
        }
        for(int i=2;i*i<=N;i++){
            if(prime(i)){
                if(i*i <= N){
                    numberswith3Divisors++;
                }
            }
        }
        return numberswith3Divisors;
    }

    /* When its time to find roots of a quadratic equation (generaaly has two roots), we generally arises at 3 conditions
     * if b*b < 4ac roots are complex or imaginary, b*b = 4ac roots are real and equal, b*b > 4ac roots are real and different
    */

    public int[] rootsofeq(int a, int b, int c){
        int roots[] = new int[2];
        if(b * b < 4*a*c){
            roots[0] = -1;
            return roots;
        }
        else if(b * b == 4*a*c){
            roots[0] = (-b)/(2*a);
            roots[1] = (-b)/(2*a);
        }
        else if(b*b > 4*a*c){
            double root1 = (-b + Math.sqrt(b*b - 4*a*c)) / (2.0*a);
            double root2 = (-b - Math.sqrt(b*b - 4*a*c)) / (2.0*a);
            roots[0] = (int) Math.floor(root1);
            roots[1] = (int) Math.floor(root2);
        }
        return roots;
    }

    public void rootsofQuadraticequ(int a, int b, int c){
        int quaRoots[] = rootsofeq(a, b, c);
        for(int i=0;i<2;i++){
            System.out.print(quaRoots[i]+" ");
        }
        System.out.println();
    }

    //HCF or GCD of two numbers without using recursion or Euclidean algorithm.

    public int HCF(int a, int b){
        int min = Math.min(a, b);

        if(a % min == 0 && b % min == 0){
            return min;
        }

        for(int i = min/2;i>=2;i--){
            if(a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }
    // Steins algorithm is the optimized version of Euclidean algorithm , it is more efficient by using the bitwise shift operator.

    /* To find modular multiplicative inverse  we using the extended euclidean algorithm . If we want to find modular multiplicative inverse of an integer a under modulo m 
       we need to find an integer x such that (a * x) mod m = 1. The extended euclidean algorithm is the efficient method which provides a way to find the coefficients of bezout's identity.
       ax + by = gcd(a,b), if gcd(a, b) = 1 then x is the modulo multiplicative inverse of under m. Otherwise, The modular inverse does not exist ( return -1).
    */

    public void printModInv(int a, int m){
        System.out.println("The multiplicative inverse of "+a+" and "+m+" is "+modInv(a, m));
    }

    public int modInv(int a, int b){
        if(b <= 1){      //Special case where b = 1, any integer a and b = 1 the result is always 0 because any number mod 1 is always zero, so we can't able to find an integer x such that a*x mod m = 1. 
            return -1;
        }
        int x[] = new int[2];
        int gcd = gcdExtended(a, b, x);

        if(gcd != 1){
            return -1;
        }
        else{
            int res = (x[0]%b + b) % b;
            return res;
        }
    }

    public int gcdExtended(int a, int b, int[] x){
        if(a == 0){
            x[0] = 0;
            x[1] = 1;
            return b;
        }
        int x1[] = new int[2];
        int gcd = gcdExtended(b%a, a, x1);

        x[0] = x1[1] -(b/a)*x1[0];
        x[1] = x1[0];

        return gcd;
    }

    
}
     

