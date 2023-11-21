/*
   ID: aimlesswanderer
   LANG: JAVA
   TASK: Milk Measurement
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MilkMeasurement {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int numMeasurements = Integer.parseInt(st.nextToken());
        String [][] record = new String [numMeasurements][3];

        for(int i = 0; i < numMeasurements; i++) {
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            record[i][0] = st2.nextToken();
            record[i][1] = st2.nextToken();
            record[i][2] = st2.nextToken();
        }

        writer.println(getChange(record));
        reader.close();
        writer.close();
    }

    public static int getChange(String [][] record) {

        int change = 0;
        int Bessie = 7;  int Elsie = 7;  int Mildred = 7;
        int Bessie2 = 7;  int Elsie2 = 7;  int Mildred2 = 7;
        int difference = 0;
        int dayTracker = 0;
        int currentMax = 7;
        boolean BessieMax, ElsieMax, MildredMax, BessieMax2, ElsieMax2, MildredMax2;

        selectionSort(record);

        for(int i = 0; i < record.length; i++) {

            //Accumulate all the changes on the same day
            difference = 0;

            if(record[i][2].charAt(0) == '+') {
                difference += Integer.parseInt(record[i][2].substring(1));
            } else {
                difference -= Integer.parseInt(record[i][2].substring(1));
            }

            if(record[i][1].equals("Bessie")) {
                Bessie2 += difference;
            } else if (record[i][1].equals("Elsie")) {
                Elsie2 += difference;
            } else {
                Mildred2 += difference;
            }

            //Only change on different days
            if(Integer.parseInt(record[i][0]) != dayTracker) {

                //Keep Track of the top cows from the previous (or start of current day) day and compare them to the current day
                //The current issue is that I need this to be updated only once on the previous day
                
                BessieMax = (Bessie == currentMax ? true : false);
                ElsieMax = (Elsie == currentMax ? true : false);
                MildredMax = (Mildred == currentMax ? true : false);

                currentMax = Math.max(Bessie2, Math.max(Elsie2, Mildred2));

                BessieMax2 = (Bessie2 == currentMax ? true : false);
                ElsieMax2 = (Elsie2 == currentMax ? true : false);
                MildredMax2 = (Mildred2 == currentMax ? true : false);

                if(BessieMax != BessieMax2 || ElsieMax!= ElsieMax2 || MildredMax!= MildredMax2){
                    change++;
                }

                dayTracker = Integer.parseInt(record[i][0]);

                Bessie = Bessie2;
                Elsie = Elsie2;
                Mildred = Mildred2;
            }
        }

        return change;
    }

    public static void selectionSort(String [][] record) {
        int currentMin = 0;
        int day = 0;
        String tempDay = "";
        String tempName = "";
        String tempDifference = "";
        boolean swap = false;

        for(int i = 0; i < record.length - 1; i++) {
            swap = false;
            day = Integer.parseInt(record[i][0]);
            currentMin = i;
            for(int j = i + 1; j < record.length; j++) {
                if(Integer.parseInt(record[j][0]) < day) {
                    currentMin = j;
                    swap = true;
                }
            }

            if(swap) {
                tempDay = record[i][0];
                tempName = record[i][1];
                tempDifference = record[i][2];
                record[i][0] = record[currentMin][0];
                record[i][1] = record[currentMin][1];
                record[i][2] = record[currentMin][2];
                record[currentMin][0] = tempDay;
                record[currentMin][1] = tempName;
                record[currentMin][2] = tempDifference;
            }
        }
    }
}
