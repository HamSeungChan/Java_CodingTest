import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {

            token = new StringTokenizer(br.readLine(), " ");
            int level = Integer.parseInt(token.nextToken());
            String name = token.nextToken();

            Room bestFit = null;
            for (Room room : rooms) {
                if (room.level - 10 <= level && level <= room.level + 10 && room.people.size() < m) {
                    bestFit = room;
                    break;
                }
            }

            if (bestFit == null) {
                bestFit = new Room(level);
                rooms.add(bestFit);
            }
            bestFit.people.add(new Person(name, level));
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if (room.people.size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            Collections.sort(room.people);
            for (Person person : room.people) {
                sb.append(person.level).append(" ").append(person.name).append("\n");
            }
        }
        System.out.print(sb);
    }

}

class Room {
    int level;
    List<Person> people = new ArrayList<>();

    public Room(int level) {
        this.level = level;
    }
}

class Person implements Comparable<Person> {
    String name;
    int level;

    public Person(String name, int level) {
        this.name = name;
        this.level = level;
    }


    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}