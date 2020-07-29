import java.util.Arrays;
import java.io.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class BinarySearch
{
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        float result = (float)1234/100;
        StdOut.println(result);
        return;
        //int[] whitelist = In.readInts(args[0]);

        //Arrays.sort(whitelist);

        //while (!StdIn.isEmpty()) {
        //    int key = StdIn.readInt();
        //    if (rank(key, whitelist) == -1)
        //        StdOut.println(key);
        //}
    }
}
