import java.util.Scanner;

public class hammingCode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of data bits: ");
        int m = scanner.nextInt();

        int r = 1;
        while (Math.pow(2, r) < m + r + 1) r++;

        int[] hamming = new int[m + r + 1];
        System.out.print("Enter the data bits: ");
        for (int i = 1; i <= m; i++) hamming[i + r] = scanner.nextInt();

        for (int i = 1; i <= m + r; i++) 
            if ((i & (i - 1)) == 0) hamming[i] = parity(hamming, i);

        System.out.print("\nHamming code is: ");
        for (int i = 1; i <= m + r; i++) System.out.print(hamming[i] + " ");
    }

    private static int parity(int[] dataBits, int position) {
        int parity = 0;
        for (int j = position; j < dataBits.length; j += position) parity += dataBits[j];
        return parity % 2;
    }
}

