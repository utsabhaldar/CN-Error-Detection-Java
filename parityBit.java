public class parityBit {

    static void findParity(int n) {
        int b = n ^ (n >> 1) ^ (n >> 2) ^ (n >> 4) ^ (n >> 8) ^ (n >> 16);
        System.out.println((b & 1) == 0 ? "Even Parity" : "Odd Parity");
    }

    public static void main(String[] args) {
        int n = 15;
        findParity(n);
    }
}
