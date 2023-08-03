import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int s;
    static int p;
    static int answer = 0;
    static String[] dna;
    static List<DNA> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(token.nextToken());
        p = Integer.parseInt(token.nextToken());
        dna = br.readLine().split("");


        list = new ArrayList<>();
        token = new StringTokenizer(br.readLine(), " ");
        list.add(new DNA("A", Integer.parseInt(token.nextToken())));
        list.add(new DNA("C", Integer.parseInt(token.nextToken())));
        list.add(new DNA("G", Integer.parseInt(token.nextToken())));
        list.add(new DNA("T", Integer.parseInt(token.nextToken())));

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("C", 0);
        map.put("G", 0);
        map.put("T", 0);

        for (int i = 0; i < p; i++) {
            map.put(dna[i], map.get(dna[i]) + 1);
        }
        if (canUse(map)) {
            answer++;
        }

        int lt = 0;
        for (int rt = p; rt < s; rt++) {
            map.put(dna[lt], map.get(dna[lt]) - 1);
            map.put(dna[rt], map.get(dna[rt]) + 1);
            lt++;
            if (canUse(map)) {
                answer++;
            }
        }


        System.out.println(answer);
    }

    static boolean canUse(Map<String, Integer> map) {
        for (DNA dna : list) {
            if (map.get(dna.info) < dna.need) {
                return false;
            }
        }

        return true;
    }
}

class DNA {
    String info;
    int need;

    public DNA(String info, int need) {
        this.info = info;
        this.need = need;
    }
}