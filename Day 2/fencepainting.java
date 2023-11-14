/*
   ID: aimlesswanderer
   LANG: JAVA
   TASK: fencepainting
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class fencepainting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("paint.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
       
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int johna = Integer.parseInt(st.nextToken());
        int johnb = Integer.parseInt(st.nextToken());
      
        StringTokenizer st2 = new StringTokenizer(reader.readLine());
        int bessiea = Integer.parseInt(st2.nextToken());
        int bessieb = Integer.parseInt(st2.nextToken());

        writer.print(findLength(johna, johnb, bessiea, bessieb));
        reader.close();
        writer.close();
    }

    public static int findLength(int a1, int b1, int a2, int  b2) {
        int length = 0;

        int[] fence = new int[100];
        for(int i = a1; i < b1; i++) {
            fence[i] = 1;
           // System.out.println(i);
        }
        for (int i = a2; i < b2; i++) {
            fence[i] = 1;
            //System.out.println(i);
        }

        for(int i = 0; i < fence.length; i++) {
            if(fence[i] == 1) {
                length++;
                //System.out.println(i);
            }
        }

        return length;
    }
}
