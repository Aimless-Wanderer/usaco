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
        
        //Testing
        //String [][] record = new String [6][3];

        writer.println(getChange(record));
        reader.close();
        writer.close();
    }

    public static int getChange(String [][] record) {

        int change = 0;
        int Bessie = 7;
        int Elsie = 7;
        int Mildred = 7;
        int difference = 0;
        int currentMax = 0;
        String[] maxName = new String[3];

        selectionSort(record);

        for(int i = 0; i < record.length; i++) {
            difference = 0;
            if(record[i][2].charAt(0) == '+') {
                difference += Integer.parseInt(record[i][2].substring(1));
            } else {
                difference -= Integer.parseInt(record[i][2].substring(1));
            }

            if(record[i][1].equals("Bessie")) {
                Bessie += difference;
            } else if (record[i][1].equals("Elsie")) {
                Elsie += difference;
            } else {
                Mildred += difference;
            }

            //the code here is kind of scuffed lol

            currentMax = Math.max(Bessie, Math.max(Elsie, Mildred));
            
            if(currentMax == Bessie){
                boolean occupied = false;
                for(int j = 0; j < maxName.length; j++) {
                    if(maxName[j] != null) {
                        if(maxName[j].equals("Bessie")) {
                            occupied = true;
                            break;
                        }
                    }
                }
                if(!occupied) {
                    change++;
                    for(int j = 0; j < maxName.length; j++) {
                        if(maxName[j] == null) {
                            maxName[j] = "Bessie";
                            break;
                        }
                    } 
                }
            } else {
                for(int j = 0; j < maxName.length; j++) {
                    if(maxName[j] != null) {
                        if(maxName[j].equals("Bessie")) {
                            maxName[j] = null;
                        }
                    }
                }
            }

            if(currentMax == Elsie){
                boolean occupied = false;
                for(int j = 0; j < maxName.length; j++) {
                    if(maxName[j] != null) {
                        if(maxName[j].equals("Elsie")) {
                            occupied = true;
                            break;
                        }
                    }
                }
                if(!occupied) {
                    change++;
                    for(int j = 0; j < maxName.length; j++) {
                        if(maxName[j] == null) {
                            maxName[j] = "Elsie";
                            break;
                        }
                    } 
                }
            } else {
                for(int j = 0; j < maxName.length; j++) {
                    if(maxName[j] != null) {
                        if(maxName[j].equals("Elsie")) {
                            maxName[j] = null;
                        }
                    }
                }
            }

            if(currentMax == Mildred){
                boolean occupied = false;
                for(int j = 0; j < maxName.length; j++) {
                    if(maxName[j] != null) {
                        if(maxName[j].equals("Mildred")) {
                            occupied = true;
                            break;
                        }
                    }
                }
                if(!occupied) {
                    change++;
                    for(int j = 0; j < maxName.length; j++) {
                        if(maxName[j] == null) {
                            maxName[j] = "Mildred";
                            break;
                        }
                    } 
                }
            } else {
                for(int j = 0; j < maxName.length; j++) {
                    if(maxName[j] != null) {
                        if(maxName[j].equals("Mildred")) {
                            maxName[j] = null;
                        }
                    }
                }
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
