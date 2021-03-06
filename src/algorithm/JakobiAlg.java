package algorithm;

public class JakobiAlg {


    public static int compute(int a, int b) {
        // a ... -2, -1, 0, 1, 2 ...
        if (a == 0 || b == 0) {
            throw new IllegalArgumentException("a or b == 0");
        }

        // b > 1 b % 2 == 1
        if (b <= 1 || b % 2 != 1) {
            throw new IllegalArgumentException("b must be > 1 and odd (b % 2 == 1)");
        }

        if (nod(a, b) != 1) {
            throw new IllegalArgumentException("nod(a, b) != 1");
        }

        int result = 1;

        if (a < 0) {
            a = -a;
            if (b % 4 == 3) {
                result = -result;
            }
        }

        do {
            int t = 0;
            while (a % 2 == 0) {
                t = t + 1;
                a = a / 2;
            }

            if (t % 2 == 1) {
                if (b % 8 == 3 || b % 8 == 5) {
                    result = -result;
                }
            }

            if (a % 4 == 3 && b % 4 == 3) {
                result = -result;
            }

            int z = a;
            a = b % z;
            b = z;
        } while(a != 0);
        return result;
    }

    private static int nod(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        while (x != 0 && y != 0) {
            if (x > y) {
                x = x % y;
            } else {
                y = y % x;
            }
        }
        return x + y;
    }
}
