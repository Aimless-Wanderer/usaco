import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LostCow {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // int x = 6;
        // int y = 3;

        int distance = 0;

        //if(x == y) {writer.print(0);}

        int increment = 1;
        while(x < y ? x+increment<y : x+increment>y) {
            distance += 2*Math.abs(increment);
            //System.out.println("dist " + distance);
            increment*=-2;
            //System.out.println("inc " + increment);
        }
        distance += Math.abs(x-y);
        
        //System.out.println(distance);
        
        writer.print(distance);
        reader.close();
        writer.close();
    }
}
