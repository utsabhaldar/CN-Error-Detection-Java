import java.util.Arrays;

public class bitStuffing {

    static void bitStuff(int[] arr) {
        int[] brr = new int[30];
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                int count = 1;
                brr[j++] = arr[i];

                for (int k = i + 1; k < arr.length && arr[k] == 1 && count < 5; k++) {
                    brr[j++] = arr[k];
                    count++;

                    if (count == 5) brr[j++] = 0;
                    i = k;
                }
            } 
            
            else brr[j++] = arr[i];
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(brr, 0, j)));
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 1, 1 };
        bitStuff(arr);
    }
}
