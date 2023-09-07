package ex12;

public class Main {
    public static <E extends Comparable<E>> void heapSort(E[] arr) {
        var n = arr.length;

        /**
         * tạo max heap từ mảng ban đầu (tìm giá trị max cho lên đầu )
         */
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, n, i);
        }


        /**
         * đổi chỗ giá trị đầu ( giá trị max )  với giá trị cuối sau đó lại đẩy max lên đầu
         * giam gia tri i di 1
         */
        for (int i = n - 1; i > 0; i--) {
            E tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            siftDown(arr, i, 0);
        }
    }

    private static <E extends Comparable<E>> void siftDown(E[] data, int n, int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < n && data[left].compareTo(data[largest]) < 0) {
            largest = left;
        }

        if (right < n && data[right].compareTo(data[largest]) < 0) {
            largest = right;
        }

        if (largest != index) {
            E tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            siftDown(data, n, largest);
        }
    }

    public static <E> void showElements(E[] arr) {
        for (var e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 1, 4, 2, 9, 7, 8, 6, 5};
        String[] names = new String[]{"Phong", "Mai", "Nam", "Nhan", "Loan", "Huong", "Anh", "Tung"};
        System.out.println("Trước khi sắp xếp: ");
        showElements(arr);
        showElements(names);
        // gọi phương thức sắp xếp heap sort
        heapSort(arr);
        heapSort(names);
        // hiển thị kết quả
        System.out.println("Sau khi sắp xếp: ");
        showElements(arr);
        showElements(names);
    }
}
