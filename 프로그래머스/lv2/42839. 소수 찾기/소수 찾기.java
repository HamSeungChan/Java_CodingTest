import java.util.HashMap;
class Solution {
    static HashMap<Integer,Integer> map = new HashMap<>();

    public int solution(String numbers) {
        int[] check = new int[numbers.length()];
        for (int i = 1; i <= numbers.length(); i++) {
            int[] array = new int[i];
            new Solution().DFS(array, 0, check, numbers);
        }
        return map.size();
    }

    public void DFS(int[] array, int value, int[] check, String numbers) {

        if (value == array.length) {
            StringBuilder sb = new StringBuilder();
            for (int x : array) {
                sb.append(numbers.charAt(x));
            }
            int number = Integer.parseInt(sb.toString());

            boolean isPrime = true;
            if(number == 0 || number ==1 ) isPrime = false;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(number);
                map.put(number,1);
            }

        } else {
            for (int i = 0; i < numbers.length(); i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    array[value] = i;
                    DFS(array,value+1,check,numbers);
                    check[i] = 0;
                }
            }
        }
    }
}
