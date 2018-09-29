package rmugattarov.crack;

public class TimeToAngle {
    private static final int ONE_HOUR_ANGLE = 360 / 12;
    private static final double ONE_MINUTE_HOUR_HANDLE = ONE_HOUR_ANGLE / 60D;
    private static final int ONE_MINUTE_ANGLE = 360 / 60;

    public static void main(String[] args) {
        int[][] data = {
                {12, 30},
                {12, 0},
                {1, 50},
                {11, 10}
        };
        for (int[] datum : data) {
            System.out.println(timeToAngle(datum[0], datum[1]));
        }
    }

    private static double timeToAngle(int hour, int minute) {
        if (hour == 12) {
            hour = 0;
        }
        double hourHandleAngle = (hour * ONE_HOUR_ANGLE) + (ONE_MINUTE_HOUR_HANDLE * minute);
        double minuteHandleAngle = minute * ONE_MINUTE_ANGLE;
        System.out.println("hourHandleAngle : " + hourHandleAngle);
        System.out.println("minuteHandleAngle : " + minuteHandleAngle);
        return Math.abs(hourHandleAngle - minuteHandleAngle);
    }
}
