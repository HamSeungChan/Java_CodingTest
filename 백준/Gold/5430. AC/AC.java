import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> answerList = new ArrayList<>();
        int testCase = Integer.valueOf(br.readLine());
        for (int t = 0; t < testCase; t++) {
            String p = br.readLine();
            int n = Integer.valueOf(br.readLine());
            String tmp = br.readLine();
            String answer = "";
            boolean direct = true;

            List<Integer> list = new ArrayList<>();
            for (String s : tmp.substring(1, tmp.length() - 1).split(",")) {
                if (!s.equals("")) {
                    list.add(Integer.valueOf(s));
                }
            }

            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    direct = !direct;
                } else {
                    if (list.size() == 0) {
                        answer = "error";
                        break;
                    }
                    if (direct) {
                        list.remove(0);
                    } else {
                        list.remove(list.size() - 1);
                    }
                }
            }


            if (!direct) {
                Collections.reverse(list);
            }

            if (answer.equals("error")) {
                answerList.add(answer);
            } else {

                StringBuilder sb = new StringBuilder("[");
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if (i != list.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                answerList.add(sb.toString());
            }
        }
        for (String s : answerList) {
            System.out.println(s);
        }
    }
}