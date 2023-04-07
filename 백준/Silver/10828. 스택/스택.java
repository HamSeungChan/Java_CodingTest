

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        List<Integer> stackList = new ArrayList<>();
        int topIndex = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main m = new Main();

        int size = Integer.parseInt(br.readLine());


        for (int i = 0; i < size; i++) {
            String command = br.readLine();
            if (command.startsWith("push")) {
                String[] pushCommand = command.split(" ");
                int number = Integer.parseInt(pushCommand[1]);
                topIndex++;
                stackList.add(number);
            } else if (command.equals("top")) {
                if (topIndex < 0) {
                    bw.write(-1+ "\n");
                } else {
                    bw.write(stackList.get(topIndex)+ "\n");
                }
            } else if (command.equals("size")) {
                bw.write(stackList.size()+ "\n");
            } else if (command.equals("empty")) {
                if (stackList.size()==0) {
                    bw.write("1" + "\n");
                } else {
                    bw.write("0" + "\n");
                }
            } else if (command.equals("pop")) {
                if (stackList.size() == 0) {
                    bw.write(-1+ "\n");
                } else {
                    bw.write(stackList.get(topIndex)+ "\n");
                    stackList.remove(topIndex);
                    topIndex--;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}