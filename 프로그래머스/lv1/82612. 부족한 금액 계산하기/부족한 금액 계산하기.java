class Solution {
    public long solution(int price, long money, int count) {

        long totalPrice = 0;
        for (long i = 1; i <= count; i++) {
            totalPrice += price * i;
        }
        System.out.println(totalPrice);
        return money-totalPrice<0?totalPrice-money:0;
    }
}