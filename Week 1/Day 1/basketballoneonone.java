import java.util.Scanner;

public class basketballoneonone {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String s = in.next();
			System.out.println(s.charAt(s.length() - 2));
		}

	}
}