import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your numbers to divide and divisible with: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        Mathematics m = new Mathematics();
        m.checkNumberDivisible(x, y);
        m.countNoofDigits(2341);
        m.digitSum(23456);
        m.Factorial(5);
        m.trailingZerosofFactorial(5);
        m.primeCheck(5);
        m.primeCheck(6);
        m.primeNumbers(12);
        m.digitsinFactorial(5);
        m.Numberswith3Divisors(5);
        m.rootsofQuadraticequ(752, 904, 164);
        m.printModInv(10, 17);
        Arrays array = new Arrays();
        array.Insert(2, 0);
        array.Insert(3, 1);
        array.Insert(5, 2);
        array.Insert(7, 1);
        array.Insert(6,3);
        array.Insert(6,4);
        array.printArray();
        array.removeDuplicateSize();
        array.delete(7);
        array.printArray();
        array.printRotated(8);
        array.maxSumOfk(2);
        array.prefixsumPrint();
    }
}