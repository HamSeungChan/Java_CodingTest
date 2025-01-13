import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        for (int t = 0; t < testCase; t++) {

            int m = Integer.parseInt(br.readLine());
            Queue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> right = new PriorityQueue<>();


            List<Integer> midValueList = new ArrayList<>();

            // 초기값 설정
            token = new StringTokenizer(br.readLine(), " ");
            int mid = Integer.parseInt(token.nextToken());
            midValueList.add(mid);

            int count = 1;
            for (int i = 2; i <= m; i++) {

                if (count % 10 == 0) {
                    token = new StringTokenizer(br.readLine(), " ");
                }

                int now = Integer.parseInt(token.nextToken());
                count++;

                // 중앙값보다 크거나 같은 값이 들어왔을 때
                if (now >= mid) {
                    right.add(now);
                }

                // 중앙값보다 작은 값일 들어왔을 때
                else {
                    left.add(now);
                }

                // 홀수번째 수
                if (i % 2 != 0) {

                    // 중앙값 정렬
                    while (left.size() != right.size()) {
                        if (left.size() < right.size()) {
                            left.add(mid);
                            mid = right.poll();
                        } else if (left.size() > right.size()) {
                            right.add(mid);
                            mid = left.poll();
                        }
                    }
                    midValueList.add(mid);
                }

            }

            sb.append(midValueList.size());
            int size = 0;
            for (Integer i : midValueList) {

                if (size % 10 == 0) {
                    sb.append("\n");
                }

                sb.append(i).append(" ");
                size++;
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

}