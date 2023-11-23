import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;

public class SpeedingTicket {
    public static void main(String[] args) throws IOException {

        // BufferedReader reader = new BufferedReader(new FileReader("speeding.in"));
        // PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));

        // StringTokenizer st = new StringTokenizer(reader.readLine());
        // int n = Integer.parseInt(st.nextToken());
        // int m = Integer.parseInt(st.nextToken());


        // HashMap <Integer, Integer> road = new HashMap ();
        // HashMap <Integer, Integer> bessie = new HashMap ();
        // int distance1 = 0;
        // int distance2 = 0;
        // int initialSpeed1 = 0;
        // int initialSpeed2 = 0;

        // for(int i = 0; i < n; i++) {
        //     StringTokenizer st2 = new StringTokenizer(reader.readLine());
        //     if(i == 0) {
        //         initialSpeed1 = Integer.parseInt(st2.nextToken());
        //         road.put(distance1, initialSpeed1);

        //     } else {
        //         road.put(distance1, Integer.parseInt(st2.nextToken()));
        //     }
        //     distance1 += Integer.parseInt(st2.nextToken());

        // }

        // for(int i = 0; i < m; i++) {
        //     StringTokenizer st2 = new StringTokenizer(reader.readLine());
        //     if(i == 0) {
        //         initialSpeed2 = Integer.parseInt(st2.nextToken());
        //         bessie.put(distance2, initialSpeed2);

        //     } else {
        //         bessie.put(distance2, Integer.parseInt(st2.nextToken()));
        //     }
        //     distance2 += Integer.parseInt(st2.nextToken());

        // }

        // writer.println(findSpeed(road, bessie, initialSpeed1, initialSpeed2));
        // reader.close();
        // writer.close();

        HashMap <Integer,Integer> road = new HashMap <>();
        road.put(40, 75);
        road.put(50, 35);
        road.put(10, 45);

        HashMap <Integer,Integer> bessie = new HashMap <>();
        bessie.put(40,76);
        bessie.put(20,30);
        bessie.put(40,40);

        System.out.println(findSpeed(road, bessie, 75, 76));
     }

    public static int findSpeed(HashMap <Integer, Integer> road, HashMap <Integer, Integer> bessie, int initialSpeed1, int initialSpeed2) {

        int speedOver = 0;
        int legalLimit = initialSpeed1;
        int bessieSpeed = initialSpeed2;

        for(int i = 0; i <= 100; i++) {
            if(bessie.containsKey(i)) {
                bessieSpeed = bessie.get(i);
                System.out.println("distance: " + i + " ");

            }
            if (road.containsKey(i)) {
                legalLimit = road.get(i);
            }
            if(bessieSpeed > legalLimit && (bessieSpeed - legalLimit) > speedOver) {
                speedOver = bessieSpeed - legalLimit;
            }

        }

        return speedOver;

        
    }


    //Old buggy code:

    //Test:
    // int [][] road = {{40,75},{50,35},{10,45}};
    // int [][] bessie = {{40,76},{20,30},{40,40}};
    // System.out.println(findSpeed(road, bessie));

    //Method:
    //     int distance1 = 0;
    //     int distance2 = 0;

    //     for(int i = 0; i < road.length; i++) {
    //         distance1 += road[i][0];
    //         for(int j = 0; j < bessie.length; j++) {
    //             distance2 += bessie[j][0];
    //             //checks overlap between distances --> Bug is here when max dist of 2 and min dist of 1 intersect
    //             if((distance2 <= distance1 && distance2 >= distance1 - road[i][0]) || (distance1 <= distance2 && distance1 >= distance2 - bessie[j][0])) {
                    
    //                 System.out.println("1: " + distance1 + " 2: " + distance2);

    //                 if(bessie[j][1] > road[i][1]) {
    //                     System.out.println("Passed limit: " + bessie[j][1] + " & " + road[i][1] + " segment #: " + (j+1) + " speed over: " + (bessie[j][1] - road[i][1]));
    //                     if((bessie[j][1] - road[i][1]) > speedOver) {
    //                         speedOver =  (bessie[j][1] - road[i][1]);
    //                     }
    //                 }
    //             } else {
    //                 distance2 = 0;
    //                 break;
    //             }
    //         }
    //     }
}