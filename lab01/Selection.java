import java.util.Comparator;

/**
<<<<<<< HEAD
 * 이 코드는 Selection Sort(선택 정렬)를 사용하여 Comparable 인터페이스를 구현한 객체 배열을 정렬하는 예제입니다.
 * Robert Sedgewick과 Kevin Wayne의 "Algorithms" 책을 기반으로 한 구현입니다.
=======
 * Freely inspired by the implementation found in "Algorithms"
 * by  Robert Sedgewick and Kevin Wayne
>>>>>>> 083028864b6af73c0c46ea3af9b1fb4cd0b0ca46
 */
public class Selection {

    /***************************************************************************
<<<<<<< HEAD
     *  Selection Sort 알고리즘을 구현한 메서드
     ***************************************************************************/

    public void sort(Comparable[] a) { // Comparable 인터페이스를 구현한 배열을 정렬
        int n = a.length; // 배열의 길이
        for (int i = 0; i < n; i++) { // 배열을 처음부터 끝까지 순회
            int min = i; // 현재 위치(i)를 최소값의 인덱스로 가정
            for (int j = i+1; j < n; j++) { // i 이후의 요소들과 비교
                if (less(a[j], a[min])) // a[j]가 현재 최소값(a[min])보다 작다면
                    min = j; // 최소값 인덱스 업데이트
            }
            exch(a, i, min); // 최소값을 현재 i 위치로 이동 (교환)
            assert isSorted(a, 0, i); // i번째까지 정렬되었는지 확인 (디버깅용)
        }
        assert isSorted(a); // 전체 배열이 정렬되었는지 확인 (디버깅용)
    }

    /***************************************************************************
     *  비교 및 교환을 위한 보조 함수들
     ***************************************************************************/

    // 비교 함수: v < w인지 확인
    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0; // compareTo()를 사용해 비교 (음수면 v < w)
    }

    // Comparator을 활용한 비교 함수 (추가적인 비교 기준을 제공할 때 사용)
    private boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0; // Comparator 인터페이스를 활용
    }

    // 배열 내 요소 위치 변경 함수 (i와 j의 값을 교환)
=======
     *  That's the core method. USes the implementation from
     *  Robert Sedgewick and Kevin Wayne's book
     ***************************************************************************/

    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }


    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }


    // exchange a[i] and a[j]
>>>>>>> 083028864b6af73c0c46ea3af9b1fb4cd0b0ca46
    private void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

<<<<<<< HEAD
    /***************************************************************************
     *  배열이 정렬되었는지 확인하는 함수 (디버깅용)
     ***************************************************************************/

    // 배열이 정렬되었는지 확인
=======

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    // is the array a[] sorted?
>>>>>>> 083028864b6af73c0c46ea3af9b1fb4cd0b0ca46
    private boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

<<<<<<< HEAD
    // 특정 범위(lo부터 hi까지)가 정렬되었는지 확인
    private boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false; // 앞의 요소가 뒤의 요소보다 크면 정렬되지 않은 것
        return true;
    }

    // Comparator을 활용하여 배열이 정렬되었는지 확인
=======
    // is the array sorted from a[lo] to a[hi]
    private boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array a[] sorted?
>>>>>>> 083028864b6af73c0c46ea3af9b1fb4cd0b0ca46
    private boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

<<<<<<< HEAD
    // 특정 범위에서 Comparator을 활용하여 정렬 여부 확인
    private boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i-1])) return false; // 앞의 요소가 뒤의 요소보다 크면 정렬되지 않음
        return true;
    }

    // 배열을 출력하는 함수
=======
    // is the array sorted from a[lo] to a[hi]
    private boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i-1])) return false;
        return true;
    }



    // print array to standard output
>>>>>>> 083028864b6af73c0c46ea3af9b1fb4cd0b0ca46
    private void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {

<<<<<<< HEAD
        // Movie 객체 배열 생성 (영화 정보 저장)
=======
>>>>>>> 083028864b6af73c0c46ea3af9b1fb4cd0b0ca46
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
<<<<<<< HEAD
                new Movie("The Green Mile", 1999, "Frank Darabont", 60000000, 3.9)
        };

        Selection selectionSort = new Selection();

        // 영화 배열을 정렬 (Movie의 compareTo() 기준)
        selectionSort.sort(movies);

        System.out.println("Sorted by rating:"); // compareTo() 메서드에서 변경하면 정렬 기준을 바꿀 수 있음
=======
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
        
        Selection selectionSort = new Selection();

        selectionSort.sort(movies);
        System.out.println("Sorted by rating:"); //change the method compareTo in Movie Class to change that
>>>>>>> 083028864b6af73c0c46ea3af9b1fb4cd0b0ca46
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
