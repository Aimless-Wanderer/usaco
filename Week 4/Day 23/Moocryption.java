import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Moocryption {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("moocrypt.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("moocrypt.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char [][] crossword = new char [N][M];

        for(int i = 0; i < N; i++){
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            crossword[i] = st2.nextToken().toCharArray();
        }

        String letters = "";

        for(int i = 0; i < crossword.length; i++) {
            for(int j = 0; j < crossword[0].length; j++) {
                if(letters.indexOf(crossword[i][j]) == -1) {
                    letters += crossword[i][j];
                }
            }
        }
        
        int maxMoos = 0;
        int moos = 0;
        char [] encrypted = letters.toCharArray();
        char m, o;

        //search all possible encryptions of m and o
        for(int i = 0; i < encrypted.length; i++) {
            for(int j = 0; j < encrypted.length; j++) {
                if(encrypted[i] != encrypted[j]) {
                    m = encrypted[i];
                    o = encrypted[j];
                    moos = 0;

                    //vertical
                    for(int k = 0; k < crossword.length; k++) {
                        for(int l = 0; l < crossword[0].length; l++) {
                            if(k+2 < crossword.length && crossword[k][l] == m && crossword[k+1][l] == o && crossword[k+2][l] == o) {
                                moos++;
                            }
                            if(k-2 >= 0 && crossword[k][l] == m && crossword[k-1][l] == o && crossword[k-2][l] == o) {
                                moos++;
                            }
                        }
                    }

                    //Horizontal
                    for(int k = 0; k < crossword.length; k++) {
                        for(int l = 0; l < crossword[0].length; l++) {
                            if(l+2 < crossword[0].length && crossword[k][l] == m && crossword[k][l+1] == o && crossword[k][l+2] == o) {
                                moos++;
                            }
                            if(l-2 >= 0 && crossword[k][l] == m && crossword[k][l-1] == o && crossword[k][l-2] == o) {
                                moos++;
                            }
                        }
                    }

                    //Diagonal
                    for(int k = 0; k < crossword.length; k++) {
                        for(int l = 0; l < crossword[0].length; l++) {
                            // this \ direction
                            if(k+2 < crossword.length && l+2 < crossword[0].length && crossword[k][l] == m && crossword[k+1][l+1] == o && crossword[k+2][l+2] == o) {
                                moos++;
                            }
                            if(k-2 >= 0 && l-2 >= 0 && crossword[k][l] == m && crossword[k-1][l-1] == o && crossword[k-2][l-2] == o) {
                                moos++;
                            }

                            //this / direction
                            if(k-2 >= 0 && l+2 < crossword[0].length && crossword[k][l] == m && crossword[k-1][l+1] == o && crossword[k-2][l+2] == o) {
                                moos++;
                            }
                            if(k+2 < crossword.length && l-2 >= 0 && crossword[k][l] == m && crossword[k+1][l-1] == o && crossword[k+2][l-2] == o) {
                                moos++;
                            }
                        }
                    }

                    maxMoos = Math.max(maxMoos, moos);
                }
            }
        }

       
        writer.print(maxMoos);
        reader.close();
        writer.close();
    }

    /*
    Brainstorming:
    1. Decryption Algo
        - Not needed
        - brute force all combinations of x and y in alphabet
         --> loop through every possible combination of letters present and run the search algo
        - use search algo to find x y y pattern 
    2.Search Algo
        - Objective: Vertical, Horizontal, Diagonal --> Both directions
            - for all letters [i,j] and a search length of 3 check for x y y or y y x --> always start with x first
            - Vertical: [i+1, j]
            - Horizontal:  [i, j+1]
            - Diagonal: either \ or / direction
                \ search [i+1,j+1], search [i-1, j-1]
                / search [i-1, j+1], search [i+1, j-1]
    */
}