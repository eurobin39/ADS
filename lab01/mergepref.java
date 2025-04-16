import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * Freely inspired by the implementation found in "Algorithms"
 * by  Robert Sedgewick and Kevin Wayne
 */
public class Merge_Perf {

    /***************************************************************************
     *  That's the core method. USes the implementation from
     *  Robert Sedgewick and Kevin Wayne's book
     ***************************************************************************/

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }


    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    // is the array a[] sorted?
    private boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /***************************************************************************
     *  Helpers for Performance Testing
     ***************************************************************************/

    public static String generateRandomString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static int generateRandomDate() {
        Random random = new Random();
        return random.nextInt(2020 - 1970 + 1) + 1970;
    }

    public static double generateRandomRating() {
        Random random = new Random();
        return 0.0 + (5.0 - 0.0) * random.nextDouble();
    }

    public static int generateRandomBudget() {
        Random random = new Random();
        return random.nextInt(10000000);
    }

    public static void main(String[] args) {

        Merge_Perf merge_Perf = new Merge_Perf();

        for (int i = 1000; i < 50001; i=i+1000) {
            //create the array of Movies
            ArrayList<Movie> movies_array = new ArrayList<>();
            for(int j=0; j < i; j++) {
                movies_array.add(new Movie(generateRandomString(20), generateRandomDate(), generateRandomString(10), generateRandomBudget(), generateRandomRating()));
            }
            Movie[] movies = movies_array.toArray(new Movie[0]);
            double startTime = System.nanoTime();
            merge_Perf.sort(movies);
            double endTime = System.nanoTime();
            System.out.println(i+"  "+((endTime - startTime)));
        }
    }

}