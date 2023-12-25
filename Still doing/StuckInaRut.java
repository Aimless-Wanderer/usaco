import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StuckInaRut {

    // Note: the following solution doesn't account for premature stopping
    // watch following video:
    // https://starcoder.org/video/usacovideo-usaco-2020-bronze-december-p3/
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());

        Cow[] cowGrid = new Cow[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            boolean north = false;
            String direction = st2.nextToken();
            if (direction.equals("N")) {
                north = true;
            }
            long x = Long.parseLong(st2.nextToken());
            long y = Long.parseLong(st2.nextToken());
            cowGrid[i] = new Cow(x, y, north);
        }

        for (int i = 0; i < N; i++) {
            if (cowGrid[i].north) {
                // In order to check and see if a potential "stopper" has been stopped
                // prematurely by
                // another cow, search all possible "stoppers" for that cow? "endless recursion"
                long minNorthDis = Long.MAX_VALUE;
                long minEastDis = Long.MAX_VALUE; // min dN
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        if (cowGrid[j].north) {
                            if (cowGrid[j].x == cowGrid[i].x && cowGrid[j].y > cowGrid[i].y) {
                                minNorthDis = Math.min(minNorthDis, cowGrid[j].y - cowGrid[i].y);
                            }
                        } else {
                            if (cowGrid[j].y > cowGrid[i].y && cowGrid[j].x <= cowGrid[i].x) {
                                long dE = cowGrid[i].x - cowGrid[j].x;
                                long dN = cowGrid[j].y - cowGrid[i].y;
                                if (dN > dE) {
                                    minEastDis = Math.min(minEastDis, dN);
                                }
                            }
                        }
                    }
                }
                if (minNorthDis == Long.MAX_VALUE && minEastDis == Long.MAX_VALUE) {
                    cowGrid[i].rutLength = "Infinity";
                } else {
                    cowGrid[i].rutLength = Long.toString(Math.min(minNorthDis, minEastDis));
                }

            } else {
                long minEastDis = Long.MAX_VALUE;
                long minNorthDis = Long.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        if (!cowGrid[j].north) {
                            if (cowGrid[j].y == cowGrid[i].y && cowGrid[j].x > cowGrid[i].x) {
                                minEastDis = Math.min(minEastDis, cowGrid[j].x - cowGrid[i].x);
                            }
                        } else {
                            if (cowGrid[j].x > cowGrid[i].x && cowGrid[j].y <= cowGrid[i].y) {
                                long dE = cowGrid[j].x - cowGrid[i].x;
                                long dN = cowGrid[i].y - cowGrid[j].y;
                                if (dE > dN) {
                                    minNorthDis = Math.min(minEastDis, dE);
                                }
                            }
                        }
                    }
                }
                if (minNorthDis == Long.MAX_VALUE && minEastDis == Long.MAX_VALUE) {
                    cowGrid[i].rutLength = "Infinity";
                } else {
                    cowGrid[i].rutLength = Long.toString(Math.min(minNorthDis, minEastDis));
                }

            }
        }

        for (int i = 0; i < N; i++) {
            writer.println(cowGrid[i].rutLength);
        }
        reader.close();
        writer.close();
    }

    private static class Cow {
        public long x = 0;
        public long y = 0;
        public boolean north = false;
        public String rutLength = "";

        public Cow(long x, long y, boolean north) {
            this.x = x;
            this.y = y;
            this.north = north;
        }
    }
}
