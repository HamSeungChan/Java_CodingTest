import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            List<Integer> friendList = graph.get(i);
            String[] array = br.readLine().split("");
            for (int j = 0; j < array.length; j++) {
                if (array[j].equals("Y")) {
                    friendList.add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            List<Integer> frinedList = graph.get(i);
            for (Integer friend : frinedList) {
                set.add(friend);
                List<Integer> friendList2 = graph.get(friend);
                for (Integer friend2 : friendList2) {
                    set.add(friend2);
                }
            }
            answer = Math.max(answer, set.size() - 1);
        }
        System.out.println(answer);
    }
}