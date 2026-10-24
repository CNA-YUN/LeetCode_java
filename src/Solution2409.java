public class Solution2409 {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysum = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < daysum.length; i++) {
            daysum[i] += daysum[i - 1];
        }
        int a1, a2, b1, b2;
        a1 = date(arriveAlice, daysum);
        b1 = date(arriveBob, daysum);
        a2 = date(leaveAlice, daysum);
        b2 = date(leaveBob, daysum);
        int res = Math.min(a2, b2) - Math.max(a1, b1) + 1;
        return Math.max(res, 0);
    }

    private int date(String date, int[] days) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));
        return days[month - 1] + day;
    }
}
