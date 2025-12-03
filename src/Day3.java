import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static void main(String[] args) throws IOException {
        /*
            In 987654321111111, 98
            In 811111111111119, 89
            In 234234234234278, 78
            In 818181911112111, 92
         */
        String inputPath = "inputs/day3.txt";
        List<String> lines = Files.readAllLines(Path.of(inputPath));
        // part 1
        ArrayList<BigInteger> list = new ArrayList<>();
        int ans = 0;
        for (String line : lines) {
            BigInteger bn = new BigInteger(line);
            list.add(bn);
        }
        for (BigInteger num : list) {
            int maxJolt = Integer.MIN_VALUE;
            for (int i = 0; i < num.toString().length(); i++) {
                int firstDigit = num.toString().charAt(i) - '0';

                for (int j = i + 1; j < num.toString().length(); j++) {
                    int secondDigit = num.toString().charAt(j) - '0';

                    int value = firstDigit * 10 + secondDigit;

                    if (value > maxJolt) {
                        maxJolt = value;
                    }
                }
            }
            ans += maxJolt;
        }
        System.out.println(ans);

    }

}

