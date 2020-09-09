public class Main {
    public static void main(String[] args) {

        int[] array = {5, 2, 4, 6, 1, 3, 2, 6};

        sort(array, 0, array.length);

        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        if (n1 >= 0) {
            System.arraycopy(arr, l, L, 0, n1);
        }

        if (n2 >= 0) {
            System.arraycopy(arr, m, R, 0, n2);
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
