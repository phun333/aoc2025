import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException {
        String inputPath = "inputs/day1.txt";

        List<String> lines = Files.readAllLines(Path.of(inputPath));

        // part 1
        /*
        start number : 50
        L68 82
        L30 52
        R48 100 ans++;
        L5 95
        R60 55
        L55 ans++;
        L1
        L99 ans ++;
        R14
        L82
        sp 10
        l250
        ans: 3
        */

        int startPoint = 50;
        int ans = 0;

        for (String number : lines) {
            int turn = Integer.parseInt(number.substring(1));
            if (number.startsWith("L")) {
                startPoint = Math.floorMod(startPoint - turn, 100);
            } else {
                startPoint = (startPoint + turn) % 100;
            }
            if (startPoint == 0) {
                ans++;
            }
        }

        System.out.println("part 1: " + ans);

        // part 2
        /*
        The dial starts by pointing at 50.
        The dial is rotated L68 to point at 82; during this rotation, it points at 0 once. click++;
        The dial is rotated L30 to point at 52.
        The dial is rotated R48 to point at 0. click++;
        The dial is rotated L5 to point at 95.
        The dial is rotated R60 to point at 55; during this rotation, it points at 0 once. click++;
        The dial is rotated L55 to point at 0. click++;
        The dial is rotated L1 to point at 99.
        The dial is rotated L99 to point at 0. click++;
        The dial is rotated R14 to point at 14.
        The dial is rotated L82 to point at 32; during this rotation, it points at 0 once. click++;
        */

        startPoint = 50;
        ans = 0;

        for (String number : lines) {
            int turn = Integer.parseInt(number.substring(1));
            int clickCycle = turn / 100;
            ans += clickCycle;
            int remaining = turn % 100;

            if (number.startsWith("L")) {
                for (int i = 0; i < remaining; i++) {
                    startPoint = (startPoint - 1 + 100) % 100;
                    if (startPoint == 0) {
                        ans++;
                    }
                }
            } else {
                for (int i = 0; i < remaining; i++) {
                    startPoint = (startPoint + 1) % 100;
                    if (startPoint == 0) {
                        ans++;
                    }
                }
            }
        }

        System.out.println("part 2: " + ans);
    }
}
