import aes.AES;

import java.util.HexFormat;

public class Main {
    public static void main(String[] args) {
        AES aes = new AES("000102030405060708090a0b0c0d0e0f");
        System.out.println(HexFormat.of().formatHex(aes.encrypt("Hola")));
    }
}
