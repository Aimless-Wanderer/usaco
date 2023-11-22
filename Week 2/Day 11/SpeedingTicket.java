import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SpeedingTicket {
    public static void main(String[] args) throws IOException {

        // BufferedReader reader = new BufferedReader(new FileReader("speeding.in"));
        // PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));

        // StringTokenizer st = new StringTokenizer(reader.readLine());
        // int n = Integer.parseInt(st.nextToken());
        // int m = Integer.parseInt(st.nextToken());

        // int [][] road = new int [n][2];
        // int [][] bessie = new int [m][2];

        // for(int i = 0; i < n; i++) {
        //     StringTokenizer st2 = new StringTokenizer(reader.readLine());
        //     road[i][0] = Integer.parseInt(st2.nextToken());
        //     road[i][1] = Integer.parseInt(st2.nextToken());
        // }

        // for(int i = 0; i < m; i++) {
        //     StringTokenizer st2 = new StringTokenizer(reader.readLine());
        //     bessie[i][0] = Integer.parseInt(st2.nextToken());
        //     bessie[i][1] = Integer.parseInt(st2.nextToken());
        // }

        // writer.println(findSpeed(road, bessie));
        // reader.close();
        // writer.close();

            int [][] road = {{40,75},{50,35},{10,45}};
            int [][] bessie = {{40,76},{20,30},{40,40}};
            System.out.println(findSpeed(road, bessie));
     }

    public static int findSpeed(int [][] road, int [][] bessie) {

        int speedOver = 0;
        int distance1 = 0;
        int distance2 = 0;

        for(int i = 0; i < road.length; i++) {
            distance1 += road[i][0];
            for(int j = 0; j < bessie.length; j++) {
                distance2 += bessie[j][0];
                //checks overlap between distances --> Bug is here when max dist of 2 and min dist of 1 intersect
                if((distance2 <= distance1 && distance2 >= distance1 - road[i][0]) || (distance1 <= distance2 && distance1 >= distance2 - bessie[j][0])) {
                    
                    System.out.println("1: " + distance1 + " 2: " + distance2);

                    if(bessie[j][1] > road[i][1]) {
                        System.out.println("Passed limit: " + bessie[j][1] + " & " + road[i][1] + " segment #: " + (j+1) + " speed over: " + (bessie[j][1] - road[i][1]));
                        if((bessie[j][1] - road[i][1]) > speedOver) {
                            speedOver =  (bessie[j][1] - road[i][1]);
                        }
                    }
                } else {
                    distance2 = 0;
                    break;
                }
            }
        }

        

        return speedOver;
    }
}