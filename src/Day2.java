public class Day2 {

    public static void main(String[] args) {
        String txt = "9100-11052,895949-1034027,4408053-4520964,530773-628469,4677-6133,2204535-2244247,55-75,77-96,6855-8537,55102372-55256189,282-399,228723-269241,5874512-6044824,288158-371813,719-924,1-13,496-645,8989806846-8989985017,39376-48796,1581-1964,699387-735189,85832568-85919290,6758902779-6759025318,198-254,1357490-1400527,93895907-94024162,21-34,81399-109054,110780-153182,1452135-1601808,422024-470134,374195-402045,58702-79922,1002-1437,742477-817193,879818128-879948512,407-480,168586-222531,116-152,35-54";
        long ans = 0;
        // part 1
        String[] list = txt.split(",");
        for (String range : list) {
            String[] numList = range.split("-");
            long num1 = Long.parseLong(numList[0]);
            long num2 = Long.parseLong(numList[1]);
            for (long i = num1; i <= num2; i++) {
                String test = Long.toString(i);
                if (test.length() % 2 == 0) {
                    int mid = test.length() / 2;
                    String left = test.substring(0, mid);
                    String right = test.substring(mid);
                    if (left.equals(right)) {
                        ans = i + ans;
                    }

                }

            }
        }
        System.out.println("Part 1: " + ans);
        // part 2
        ans = 0;
        for (String newrange : list) {
            String[] numList = newrange.split("-");
            long num1 = Long.parseLong(numList[0]);
            long num2 = Long.parseLong(numList[1]);
            for (long i = num1; i <= num2; i++) {
                String test = Long.toString(i);
                int len = test.length();

                boolean falseNum = false;
                for (int piece = 1; piece <= len / 2; piece++) {
                    if (len % piece == 0) {
                        String pattern = test.substring(0, piece);
                        boolean match = true; // piece test
                        for (int x = 0; x < len; x++) {
                            if (test.charAt(x) != pattern.charAt(x % piece)) {
                                match = false;
                                break;
                            }
                        }
                        if (match) {
                            falseNum = true;
                        }
                    }
                }
                if (falseNum) {
                    ans = ans + i;
                }
            }

        }

        System.out.println("Part 2: " + ans);


    }

}
