import java.util.Comparator;
import java.util.Random;

/**
 * Freely inspired by the implementation found in "Algorithms"
 * by  Robert Sedgewick and Kevin Wayne
 */
public class Quick {

    private static Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed

    private Quick() {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    /***************************************************************************
     *  That's the core method. USes the implementation from
     *  Robert Sedgewick and Kevin Wayne's book
     ***************************************************************************/

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
        assert isSorted(a, lo, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }


    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + random.nextInt(n-i);     // between i and n-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    // is the array a[] sorted?
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {

        Movie[] movies = {
                new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 25000000, 4.8),
                new Movie("The Dark Knight", 2008, "Christopher Nolan", 185000000, 4.7),
                new Movie("Pulp Fiction", 1994, "Quentin Tarantino", 8000000, 4.6),
                new Movie("Inception", 2010, "Christopher Nolan", 160000000, 4.5),
                new Movie("The Matrix", 1999, "The Wachowskis", 63000000, 4.4),
                new Movie("Forrest Gump", 1994, "Robert Zemeckis", 55000000, 4.3),
                new Movie("The Lord of the Rings: The Return of the King", 2003, "Peter Jackson", 94000000, 4.2),
                new Movie("Spirited Away", 2001, "Hayao Miyazaki", 19000000, 4.1),
                new Movie("Saving Private Ryan", 1998, "Steven Spielberg", 70000000, 4.0),
                new Movie("The Green Mile", 1999, "Frank Darabont", 60000000, 3.9),
                new Movie("The Godfather", 1972, "Francis Ford Coppola", 6000000, 4.7),
                new Movie("The Silence of the Lambs", 1991, "Jonathan Demme", 19000000, 4.6),
                new Movie("Schindler's List", 1993, "Steven Spielberg", 22000000, 4.5),
                new Movie("12 Angry Men", 1957, "Sidney Lumet", 350000, 4.4),
                new Movie("The Lord of the Rings: The Fellowship of the Ring", 2001, "Peter Jackson", 93000000, 4.3),
                new Movie("Parasite", 2019, "Bong Joon-ho", 11400000, 4.2),
                new Movie("Interstellar", 2014, "Christopher Nolan", 165000000, 4.1),
                new Movie("Whiplash", 2014, "Damien Chazelle", 3300000, 4.0),
                new Movie("The Grand Budapest Hotel", 2014, "Wes Anderson", 25000000, 3.9),
                new Movie("The Dark Knight Rises", 2012, "Christopher Nolan", 250000000, 3.8),
                new Movie("The Godfather Part II", 1974, "Francis Ford Coppola", 13000000, 4.6),
                new Movie("The Lord of the Rings: The Two Towers", 2002, "Peter Jackson", 94000000, 4.4),
                new Movie("Seven", 1995, "David Fincher", 33000000, 4.3),
                new Movie("Life Is Beautiful", 1997, "Roberto Benigni", 20000000, 4.1)
        };

        Quick quickSort = new Quick();

        quickSort.sort(movies);
        System.out.println("Sorted by rating:"); //change the method compareTo in Movie Class to change that
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

}