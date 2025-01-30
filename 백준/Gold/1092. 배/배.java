import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] crane = new Integer[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(crane, Collections.reverseOrder());

        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(token.nextToken()));
        }

        Collections.sort(box, Collections.reverseOrder());


        int time = 0;

        // 가장 무거운 상자를 크레인이 못드는 경우
        if (crane[0] < box.get(0)) {
            time = -1;
            box.clear();
        }

        while (!box.isEmpty()) {

            int index = 0;

            for (int i = 0; i < n; i++) {

                if (box.isEmpty()) {
                    break;
                }

                while (index < box.size()) {

                    if (crane[i] >= box.get(index)) {
                        box.remove(index);
                        break;
                    } else {
                        index++;
                    }
                }
            }
            time++;
        }
        System.out.println(time);

    }

}