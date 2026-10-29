public class Solution2069 {
    private int mod;
    private int loc;
    private int w, h;
    private int temp;
    private int[] pos;
    private String[] direction = { "East", "North", "West", "South" };
    private String dir;

    public Solution2069(int width, int height) {
        w = width;
        h = height;
        mod = 2 * width + 2 * height - 4;
        loc = 0;
        pos = new int[] { 0, 0 };
        dir = "East";
    }

    public void step(int num) {
        loc += num;
        temp = loc % mod;
        if (0 <= temp && temp <= w - 1) {
            pos = new int[] { temp, 0 };                         // 底边 East
            dir = (temp == 0 && loc != 0) ? "South" : "East";   // 修正：绕回起点为 South
        } else if (w <= temp && temp <= h + w - 2) {
            pos = new int[] { w - 1, temp - w + 1 };            // 右边 North
            dir = direction[1];
        } else if (h + w - 1 <= temp && temp <= 2 * w + h - 3) {
            pos = new int[] { 2 * w + h - 3 - temp, h - 1 };    // 修正：上边 West 的 x 公式
            dir = direction[2];
        } else {
            pos = new int[] { 0, mod - temp };                  // 左边 South
            dir = direction[3];
        }
    }

    public int[] getPos() {
        return pos;
    }

    public String getDir() {
        return dir;
    }
}
