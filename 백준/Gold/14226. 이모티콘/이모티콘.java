import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());
		System.out.println(simulation(s));
	}

	public static int simulation(int s) {

		Set<Status> set = new HashSet<>();
		Queue<Status> q = new LinkedList<>();
		Status startPoint = new Status(1, 0);
		set.add(startPoint);
		q.offer(startPoint);
		int time = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				Status tmp = q.poll();
				if (tmp.monitor == s) {
					return time;
				}

				Status one = new Status(tmp.monitor, tmp.monitor);
				if (!set.contains(one)) {
					set.add(one);
					q.offer(one);
				}

				if (tmp.clipBoard != 0) {
					Status two = new Status(tmp.monitor + tmp.clipBoard, tmp.clipBoard);
					if (!set.contains(two)) {
						set.add(two);
						q.offer(two);
					}
				}

				Status three = new Status(tmp.monitor - 1, tmp.clipBoard);
				if (!set.contains(three)) {
					set.add(three);
					q.offer(three);
				}

			}
			time++;
		}
		return time;
	}
}

class Status {
	int monitor;
	int clipBoard;

	public Status(int monitor, int clipBoard) {
		this.monitor = monitor;
		this.clipBoard = clipBoard;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Status status = (Status)o;
		return monitor == status.monitor && clipBoard == status.clipBoard;
	}

	@Override
	public int hashCode() {
		return Objects.hash(monitor, clipBoard);
	}
}