import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] array = {5, 2, 4, 6, 1, 3, 2, 6};
        int p = 0;
        array = Sort(array, p, array.length - 1);
        String intArrayString = Arrays.toString(array);
        System.out.println(intArrayString);
    }

    public static int[] Sort(int[] A, int firstIndex, int lastIndex) {
        int q = 0;
        int lenNewArray = lastIndex - firstIndex + 1;
        int[] leftArr;
        int[] rightArr;

        int[] arrResult = new int[lenNewArray];
        if (firstIndex < lastIndex) {
            q = (firstIndex + lastIndex) / 2;
            leftArr = new int[q - firstIndex + 1];
            rightArr = new int[lastIndex - q];
            leftArr = Sort(A, firstIndex, q);
            rightArr = Sort(A, q + 1, lastIndex);
            arrResult = Merge(A, leftArr, rightArr, firstIndex, q, lastIndex);
        }
        if (arrResult[0] != 0){
            String resString = Arrays.toString(arrResult);
            System.out.println(resString);}
        return arrResult;

    }

    public static int[] Merge(int[] A, int[] arrListLeft, int[] arrListRight, int firstIndex, int q, int lastIndex) {
        int lengthArray = lastIndex - firstIndex + 1;
        int[] arrResult = new int[lengthArray];

        if(q == firstIndex) {
            arrListLeft = FillArray(A, arrListLeft, firstIndex, q);
        }
        if(lastIndex == q+1) {
            arrListRight = FillArray(A, arrListRight, q + 1, lastIndex);
        }
        int i = 0, j = 0, k = 0;

        for (k = 0; k < lengthArray; k++){
            if (i < arrListLeft.length && (j >= arrListRight.length || arrListLeft[i] < arrListRight[j]) )
            {
                arrResult[k] = arrListLeft[i];
                i++;
            } else {
                arrResult[k] = arrListRight[j];
                j++;
            }
        }
        return arrResult;
    }

    public static int[] FillArray(int[] A, int[] arrResult, int firstIndex, int lastIndex) {
        int k = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            arrResult[k] = A[i];
            k+=1;
        }
        return arrResult;
    }
}




