package com.qing.pojo;

public class Sort {
    public static void bubbleSort(int A[], int n) {
        int i, j;
        for (i = 0; i < n - 1; i ++) {
            for (j = 0; j < n - i - 1; j ++) {
                if (A[j] > A[j + 1]) {
                    A[j] = A[j] ^ A[j + 1];
                    A[j + 1] = A[j] ^ A[j + 1];
                    A[j] = A[j] ^ A[j + 1];
                }
            }
        }
    }

    public static void insertSort(int A[], int n) {
        int i, j, tmp;

        for (i = 1; i < n; i++) {
            tmp = A[i];

            for (j = i - 1; j >= 0; j--) {
                if (A[j] > tmp) {
                    A[j + 1] = A[j];
                } else {
                    break;
                }
            }

            A[j + 1] = tmp;
        }
    }

    public static void selectSort(int A[], int n) {
        int i, j, loc;

        for (i = 0; i < n; i++) {
            loc = i;

            for (j = i + 1; j < n; j++) {
                if (A[j] < A[loc]) {
                    loc = j;
                }
            }

            if (loc != i) {
                A[i] = A[i] ^ A[loc];
                A[loc] = A[i] ^ A[loc];
                A[i] = A[i] ^ A[loc];
            }
        }
    }

    public static void heapSort(int A[], int n) {
        int tmp;

        // 构建大根堆
        buildMaxHeap(A, n);

        for (int j = n - 1; j >= 1; j--) {
            tmp = A[0];
            A[0] = A[j];
            A[j] = tmp;

            maxheapIfy(A, 0, j);
        }
    }

    private static void buildMaxHeap(int A[], int n) {
        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxheapIfy(A, i, n);
        }
    }

    private static void maxheapIfy(int A[], int i, int n) {
        int left, right, loc;

        while (i < n) {
            left = 2 * i + 1;
            right = 2 * i + 2;
            loc = i;

            if (left < n && A[left] > A[i]) {
                i = left;
            }

            if (right < n && A[right] > A[i]) {
                i = right;
            }

            if (loc != i) {
                A[i] = A[loc] ^ A[i];
                A[loc] = A[loc] ^ A[i];
                A[i] = A[loc] ^ A[i];
            } else {
                break;
            }
        }
    }

    public static void quickSort(int A[], int bt, int ed) {
        if (bt < ed) {
            int pivot = pivotPartition(A, bt, ed);

            quickSort(A, bt, pivot - 1);

            quickSort(A, pivot + 1, ed);
        }
    }

    private static void swapVar(int A[], int bt, int ed) {
        int mid = bt + (ed - bt) / 2;

        if (mid != bt) {
            A[bt] = A[bt] ^ A[mid];
            A[mid] = A[bt] ^ A[mid];
            A[bt] = A[bt] ^ A[mid];
        }
    }

    private static int pivotPartition(int A[], int bt, int ed) {
        // 取中间值作为stand，防止数组有序出现O(n^2)情况
        swapVar(A, bt, ed);

        int stand = A[bt];

        while (bt < ed) {
            while (bt < ed && A[ed] >= stand) {
                ed--;
            }
            if (bt < ed) {
                A[bt++] = A[ed];
            }

            while (bt < ed && A[bt] <= stand) {
                bt++;
            }
            if (bt < ed) {
                A[ed--] = A[bt];
            }
        }

        A[bt] = stand;

        return bt;
    }

    public static void mergeSort(int A[], int bt, int ed) {
        if (bt < ed) {
            int mid = bt + (ed - bt) / 2;

            mergeSort(A, bt, mid);

            mergeSort(A, mid + 1, ed);

            mergeArray(A, bt, mid, ed);
        }
    }

    private static void mergeArray(int A[], int bt, int mid, int ed) {
        int i, j, k, len = ed - bt + 1;
        int tmp[] = new int[len];

        for (i = bt, j = mid + 1, k = 0; i <= mid && j <= ed; k++) {
            if (A[i] <= A[j]) {
                tmp[k] = A[i++];
            } else {
                tmp[k] = A[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = A[i++];
        }

        while (j <= ed) {
            tmp[k++] = A[j++];
        }

        for (i = 0; i < k; i++) {
            A[bt + i] = tmp[i];
        }
    }
}
