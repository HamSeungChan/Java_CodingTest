import java.util.*;

public class Main {

    static final int PEOPLE_COUNT = 3;

    public static void main(String[] args) {
        List<Info> infoList = new ArrayList<>();
        int [] years = new int[PEOPLE_COUNT];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < PEOPLE_COUNT; i++) {
            int solveCount = sc.nextInt();
            int year = sc.nextInt();
            years[i] = year % 100;
            String name = sc.next();
            infoList.add(new Info(name,solveCount));
        }

        Arrays.sort(years);
        for(int x : years){
            System.out.print(x);
        }
        System.out.println();

        Collections.sort(infoList);
        for(Info info : infoList){
            System.out.print(info.name.charAt(0));
        }
    }
}


class Info implements Comparable<Info> {
    String name;
    int solveCount;

    Info(String name, int solveCount) {
        this.name = name;
        this.solveCount = solveCount;
    }
    @Override
    public int compareTo(Info o) {
        return o.solveCount - this.solveCount;
    }
}