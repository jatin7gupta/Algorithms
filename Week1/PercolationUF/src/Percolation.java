import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    // creates n-by-n grid, with all sites initially blocked
    //public Percolation(int n)

    // opens the site (row, col) if it is not open already
    //public void open(int row, int col)

    // is the site (row, col) open?
    //public boolean isOpen(int row, int col)

    // is the site (row, col) full?
    //public boolean isFull(int row, int col)

    // returns the number of open sites
    //public int numberOfOpenSites()

    // does the system percolate?
    //public boolean percolates()
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        StdOut.print(reverse(-23));
    }

}
