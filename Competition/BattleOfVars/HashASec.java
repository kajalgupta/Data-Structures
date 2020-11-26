package Competition.BattleOfVars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashASec {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    System.out.println(toHexString(getSHA(str)));
}
private static byte[] getSHA(String str) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-256");

    return md.digest(str.getBytes(StandardCharsets.UTF_8));
}

private static String toHexString(byte[] hash) {
    BigInteger num = new BigInteger(1, hash);
    StringBuilder hexString = new StringBuilder(num.toString(16));
    while (hexString.length() < 32) {
        hexString.insert(0, '0');
    }
    return hexString.toString();
}


}