import java.io.*;
import java.util.*;
public class UsacoTemplate {
public static void main(String[] args) throws IOException {
BufferedReader reader = new BufferedReader(new FileReader("test.in"));
PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
StringTokenizer st = new StringTokenizer(reader.readLine());
int n = Integer.parseInt(st.nextToken());
writer.println(n);
reader.close();
writer.close();
}
}