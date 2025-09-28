import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int crtWordSize = 0;
        String[] crt = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String s : crt) {
            int index;
            while ((index = str.indexOf(s)) != -1) {
                crtWordSize++;
                str = str.substring(0, index) + " " + str.substring(index + s.length());
            }
        }
        int wordSize = str.replace(" ", "").length();
        System.out.println(crtWordSize + wordSize);
    }
}
