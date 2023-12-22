import java.util.Scanner;

public class crcCode {

    static char exor(char a, char b) {
        if (a == b) return '0';
        else return '1';
    }

    static void crc(String data, String key) {
        int datalen = data.length();
        int keylen = key.length();
        for (int i = 0; i < keylen - 1; i++) data += '0';
        int codelen = datalen + keylen - 1;
        char[] temp = new char[20];
        char[] rem = new char[20];
        
        for (int i = 0; i < keylen; i++) rem[i] = data.charAt(i);

        for (int j = keylen; j <= codelen; j++) {
            for (int i = 0; i < keylen; i++) temp[i] = rem[i];

            if (rem[0] == '0') for (int i = 0; i < keylen - 1; i++) rem[i] = temp[i + 1];
            else for (int i = 0; i < keylen - 1; i++) rem[i] = exor(temp[i + 1], key.charAt(i + 1));

            if (j != codelen) rem[keylen - 1] = data.charAt(j);
            else rem[keylen - 1] = '\0';
        }

        for (int i = 0; i < keylen - 1; i++) data += rem[i];


        System.out.println("CRC=" + new String(rem) + "\nDataword=" + data);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the data: ");
        String data = scanner.next();

        System.out.print("Enter the key: ");
        String key = scanner.next();

        crc(data, key);

        scanner.close();
    }
}
