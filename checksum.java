public class checksum {
    public static void main(String[] args) {
        String sent_msg = "10000101011000111001010011101101";
        String recv_msg = "10000101011000111001010011101101";
        int block_size = 8;

        if (checker(sent_msg, recv_msg, block_size)) System.out.println("No Error");
        else System.out.println("Error");
    }
    
    public static String onesComplement(String s) {
        char[] data = s.toCharArray();
        
        for (int i = 0; i < data.length; i++) {
            if (data[i] == '0') data[i] = '1';
            else data[i] = '0';
        }
        
        return new String(data);
    }

    public static String check_sum(String data, int block_size) {
        int n = data.length();
        int left = n%block_size;

        data = "0".repeat(left) + data;
        String result = data.substring(0, block_size);

        for (int i = block_size; i < n; i += block_size) {
            String nextBlock = data.substring(i, i + block_size);
            String add = Integer.toBinaryString(Integer.parseInt(nextBlock, 2) + Integer.parseInt(result, 2));
            result = (add.length() > block_size) ? onesComplement(add.substring(1)) : add;
        }

        return onesComplement(result);
    }

    public static boolean checker(String sent_msg, String recv_msg, int block_size) {
        String sender = check_sum(sent_msg, block_size);
        String receiver = check_sum(recv_msg + sender, block_size);

        return !receiver.contains("1");
    }
}