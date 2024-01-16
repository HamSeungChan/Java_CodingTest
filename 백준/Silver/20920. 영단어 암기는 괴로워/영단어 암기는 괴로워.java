import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        // 단어를 입력 받는다
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            // 단어의 길이 확인
            if (tmp.length() >= m) {
                // 단어의 갯수를 파악하기 위해서
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }

        List<Info> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(new Info(s, map.get(s)));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Info info : list) {
            sb.append(info.s).append("\n");
        }
        System.out.println(sb);
    }
}

class Info implements Comparable<Info> {
    String s;
    int count;

    public Info(String s, int count) {
        this.s = s;
        this.count = count;
    }

    @Override
    public int compareTo(Info o) {
        if (o.count == this.count) {
            if (o.s.length() == this.s.length()) {
                return this.s.compareTo(o.s);
            }
            return o.s.length() - this.s.length();
        }
        return o.count - this.count;
    }
}