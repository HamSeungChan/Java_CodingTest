import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int t = Integer.parseInt(token.nextToken());


        int answerEatCount = -1;
        int answerDrinkCount = Integer.MAX_VALUE;

        // 타워버거를 먹는 횟수를 1부터 ~ t/n 까지 반복문을 돌린다.
        for (int i = 0; i <= t / n; i++) {

            int eatCount = i;
            int bEatCount = (t - i * n) / m;

            eatCount += bEatCount;
            int drinkCount = t - i * n - bEatCount * m;

            if (answerDrinkCount > drinkCount) {
                answerDrinkCount = drinkCount;
                answerEatCount = eatCount;
                continue;
            }

            if (answerDrinkCount == drinkCount) {
                answerEatCount = Math.max(answerEatCount, eatCount);
            }
        }

        StringBuilder sb = new StringBuilder().append(answerEatCount).append(" ").append(answerDrinkCount);
        System.out.print(sb);
    }
}