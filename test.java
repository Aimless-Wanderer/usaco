
/*
 ID: kevin.c7
 LANG: JAVA
 TASK: test
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("test.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int integer1 = Integer.parseInt(st.nextToken());
        int integer2 = Integer.parseInt(st.nextToken());
        writer.println(integer1 + integer2);
        reader.close();
        writer.close();
    }
}
