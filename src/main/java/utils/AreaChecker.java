package utils;

public class AreaChecker {

    public static boolean checkArea(double x, double y, double r) {
        return checkCircle(x, y, r) || checkTriangle(x, y, r) || checkRect(x, y, r);
    }

    private static boolean checkCircle(double x, double y, double r) {
        if (x <= 0 && x >= -r / 2 && y >= 0 && y <= r / 2) {
            double v = Math.pow(x, 2) + Math.pow(y, 2);
            return v <= Math.pow(r / 2, 2);
        }
        return false;
    }

    private static boolean checkTriangle(double x, double y, double r) {
        if (x <= 0 && x >= -r / 2  &&
                y <= 0 && y >= -r) {
            return y >= -2 * x - r;
        }
        return false;
    }


    private static boolean checkRect(double x, double y, double r) {
        return x >= 0 && x <= r &&
                y <= 0 && y >= -r / 2;
    }
}
