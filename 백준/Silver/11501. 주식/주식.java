import java.util.Scanner;
import java.util.Stack;

public class Main {
    //    time out
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int test = sc.nextInt();
//        long[] testResult = new long[test];
//        for (int i = 0; i < test; i++) {
//            int day = sc.nextInt();
//            long sum = 0;
//            int max = Integer.MIN_VALUE;
//            int[] stock = new int[day];
//            for (int j = 0; j < day; j++) {
//                stock[j] = sc.nextInt();
//                max = Math.max(stock[j], max);
//            }
//            Stack<Integer> buyStock = new Stack<>();
//            for (int k = 0; k < day; k++) {
//                if (stock[k] != max) {
//                    buyStock.push(stock[k]);
//                } else {
//                    while (!buyStock.isEmpty()) {
//                        sum += stock[k] - buyStock.pop();
//                    }
//                    max = Integer.MIN_VALUE;
//                    for (int j = k + 1; j < day; j++) {
//                        max = Math.max(max, stock[j]);
//                    }
//                }
//            }
//            testResult[i] = sum;
//        }
//        for (long x : testResult) {
//            System.out.println(x);
//
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        long[] testResult = new long[test];
        for (int i = 0; i < test; i++) {
            int stockNumber = sc.nextInt();
            long[] stocks = new long[stockNumber];
            for (int j = 0; j < stockNumber; j++) {
                stocks[j] = sc.nextInt();
            }
            long sum = 0;
            long max = Long.MIN_VALUE;
            for (int j = stockNumber - 1; j >= 0; j--) {
                if (stocks[j] > max) {
                    max = stocks[j];
                } else {
                    sum += max - stocks[j];
                }
            }
            testResult[i] = sum;
        }

        for (long x : testResult) {
            System.out.println(x);
        }
    }
}