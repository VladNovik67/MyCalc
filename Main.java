import java.sql.SQLOutput;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        String input;
        input = str.nextLine();
        input = Calc(input);
        System.out.println(input);
    }

    public static String Calc(String input) {
        switch (input.charAt(0)) {
            case 'I':
                input = obrabROME(input);
                break;
            case 'V':
                input = obrabROME(input);
                break;
            case 'X':
                input = obrabROME(input);
                break;
            default:
                input=obrabArab(input);
        }
    return input;
    }
   public static String obrabArab(String input) {
        int res = 0, np = 0 , zn = 0, y = 0, nzn = 0, x = 0, x_i = 0;
        int symlen = input.length();
        if (symlen < 5 || symlen > 7 ) {
            System.out.println("throws Exception-1");
            System.exit(0);
        }
        int [] masInt = new int[symlen];
        char [] masChar = input.toCharArray();
        for (int i = 0; i < symlen; i ++ ) {
            masInt[i] = Character.digit((input.charAt(i)), 10);
        }
        for (int i = 0; i < symlen; i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                zn = i;
                nzn++;
                if (nzn > 1) {
                    System.out.println("throws Exception-6");
                    System.exit(0);
                }
            }
        }
        x = masInt[np];
        x_i = masInt[np + 1];
        if (x <= 0) {
            System.out.println("throws Exception-2");
            System.exit(0);        }
        switch(masChar[np +1]) {
            case '0' :
                x = x * 10;
                np++;
                if (x != 10)
                {
                    System.out.println("throws Exception-3");
                    System.exit(0);        }
                break;
            case ' ' :
                x = x;
                break;
            default:
                System.out.println("throws Exception-4");
                System.exit(0);
        }
        for (int i = zn + 2; i <= symlen-1; i++) {
            y = y * 10 + masInt[i]; }
        if (y > 10 || y <= 0) {
            System.out.println("throws Exception-5");
            System.exit(0);        }
        switch(input.charAt(zn)) {
            case 43 :
                x = x + y;
                break;
            case 45 :
                x = x - y;
                break;
            case 47 :
                x = x / y;
                break;
            case 42 :
                x = x * y;
                break;
        }
        return String.valueOf(x);
    }

    public static String obrabROME (String input) {
        String a = "";
        char b;
        int np = 0 , zn = 0, y = 0, nzn = 0, x = 0, x_i = 0;
        int symlen = input.length();
        if (symlen < 5 || symlen > 11 ) {
            System.out.println("throws Exception-6");
            System.exit(0);
        }
        int [] masInt = new int[symlen];
        char [] masChar = input.toCharArray();
        for (int i = 0; i < symlen; i ++ ) {
              masChar[i] = input.charAt(i);
        }
        for (int i = 0; i < symlen; i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                zn = i;
                nzn++;
                if (nzn > 1) {
                    System.out.println("throws Exception-6");
                    System.exit(0);
                }

            }
        }
        if (zn == 0)
            System.exit(0);
//        System.out.println("i= "+(symlen-1));
//        System.out.println("zn+1= "+(zn+1));
        for (int i = symlen-1; i != zn+1; i--) {
            switch (masChar[i]) {
                case ' ':
                    break;
                case 'X':
                    if (y == 10 || y != 0) {
                        System.out.println("throws Exception-7");
                        System.exit(0);
                    }
                    y = 10;
                    break;
                case 'V':
                    if (y == 10) {
                        System.out.println("throws Exception-8");
                        System.exit(0);
                    }
                    if (y >= 1 && y <= 3)
                        y = y + 5;
                    else
                        y = 5;
                    break;
                case 'I':
                    if (y == 3 || y == 4) {
                        System.out.println("throws Exception-9");
                        System.exit(0);
                    }
                    if (y < 3)
                        y = y + 1;
                    if (y == 5)
                        y = 4;
                    if (y == 10)
                        y = y - 1;
                    break;
            }
        }
        for (int i = zn - 1; i > -1; i--){
            switch(masChar[i]) {
                case ' ':
                    break;
                case 'X':
                    if (x == 10 || x != 0) {
                        System.out.println("throws Exception-10");
                        System.exit(0);
                    }
                    x = 10;
                    break;
                case 'V':
                    if (x == 10) {
                        System.out.println("throws Exception-11");
                        System.exit(0);
                    }
                    if (x >= 1 && x <= 3)
                        x = x + 5;
                    else
                        x = 5;
                    break;
                case 'I':
                    if (x == 3 || x == 4) {
                        System.out.println("throws Exception-12");
                        System.exit(0);
                    }
                    if (x < 3)
                        x = x + 1;
                    if (x == 5)
                        x = 4;
                    if (x == 10)
                        x = x - 1;
                    break;
            }
        }
        if (y > 10 || y <= 0) {
            System.out.println("throws Exception-13");
            System.exit(0);        }
        switch(input.charAt(zn)) {
            case 43 :
                x = x + y;
                break;
            case 45 :
                x = x - y;
                break;
            case 47 :
                x = x / y;
                break;
            case 42 :
                x = x * y;
                break;
        }
        if (x < 1) {
            System.out.println("throws Exception-14");
            System.exit(0);
        }
        if (x/10 != 0) {
            switch (x/10) {
                case 1:
                    a="X";
                    break;
                case 2:
                    a="XX";
                    break;
                case 3:
                    a="XXX";
                    break;
                case 4:
                    a="XL";
                    break;
                case 5:
                    a="L";
                    break;
                case 6:
                    a="LX";
                    break;
                case 7:
                    a="LXX";
                    break;
                case 8:
                    a="LXXX";
                    break;
                case 9:
                    a="XC";
                    break;
                case 10:
                    a="C";
                    break;
            }
        }
        switch (x%10) {
            case 1:
                a = a + 'I';
                break;
            case 2:
                b = 'I';
                a = a + b + b;
                break;
            case 3:
                b = 'I';
                a = a + b + b + b;
                break;
            case 4:
                b = 'I';
                a = a + b;
                b = 'V';
                a = a + b;
                break;
            case 5:
                b = 'V';
                a = a + b;
                break;
            case 6:
                b = 'V';
                a = a + b;
                b = 'I';
                a = a + b;
                break;
            case 7:
                b = 'V';
                a = a + b;
                b = 'I';
                a = a + b + b;
                break;
            case 8:
                b = 'V';
                a = a + b;
                b = 'I';
                a = a + b + b + b;
                break;
            case 9:
                b = 'I';
                a = a + b;
                b = 'X';
                a = a + b;
                break;
        }
        return a;
    }
}
