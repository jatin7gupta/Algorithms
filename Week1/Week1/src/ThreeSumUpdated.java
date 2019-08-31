import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ThreeSumUpdated {
    public static class ThreeNumbers {
        int first;
        int second;
        int third;
        ThreeNumbers(int a, int b, int c) {
            this.first = a;
            this.second = b;
            this.third = c;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            ThreeSum.ThreeNumbers n = (ThreeSum.ThreeNumbers) obj;
            return (n.first == this.first && n.second == this.second && n.third == this.third);
        }
    }
    private static boolean exists(HashSet<ThreeSum.ThreeNumbers> hs, ThreeSum.ThreeNumbers obj) {
        for (ThreeSum.ThreeNumbers three : hs) {
            if (three.equals(obj)) {
                return true;
            }
        }
        return false;
    }
    private static int binarySearch(int[] list, int key) {
        int beg = 0;
        int end = list.length -1;
        while (beg <= end) {
            int mid = (beg+end) / 2;
            if (list[mid] == key) {
                return mid;
            } else if (key < list[mid]) {
                end = mid-1;
            } else {
                beg = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] list = new int[10];
        Scanner s = new Scanner(System.in);
        HashSet<ThreeSum.ThreeNumbers> hs = new HashSet<>();
        int m = 0;
        while (s.hasNextInt()) {
            list[m++] = s.nextInt();
        }
        Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j < list.length; j++) {
                int k = binarySearch(list, (list[i] + list[j])*-1);
                if (k != -1 && list[i] < list[j] && list[j] < list[k] ) {

                    //System.out.println(list[i]+ " + "+ list[j] + " + " + list[k] + " = " + (list[i] + list[j] + list[k]));
                    ThreeSum.ThreeNumbers th = new ThreeSum.ThreeNumbers(list[i], list[j], list[k]);
                    //if (!exists(hs, th)) {
                        hs.add(th);
                    //}
                }

            }
        }
        for (ThreeSum.ThreeNumbers three : hs) {
            System.out.println(three.first + " + " + three.second + " + " + three.third + " = " + (three.first + three.second + three.third));
        }

    }
}
