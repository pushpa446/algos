import java.util.ArrayList;
import java.util.Arrays;

public class EncodeDecode {
        public static void main(String[] args) {
                String encodedString = encode(new String[]{"i am fine how are you welcome onboard", "world"});
                System.out.println(encodedString);
                String[] decoded = decode(encodedString);
                for (String str:
                     decoded) {
                        System.out.println(str);
                }
        }

        public static String encode(String[] list) {
                return Arrays.stream(list).reduce("", (acc, str) -> String.format("%s%d#%s", acc, str.length(), str));
        }

        public static String[] decode(String encoded) {
                ArrayList<String> result = new ArrayList<>();
                int i = 0;
                while (i < encoded.length() - 1) {
                        int j = i;
                        StringBuilder length = new StringBuilder("");
                        while (j < encoded.length() - 1) {
                                if (encoded.charAt(j) == '#') {
                                        break;
                                }
                                length.append(encoded.charAt(j));
                                j++;
                        }
                        int wordLength = Integer.parseInt(String.valueOf(length));
                        StringBuilder word = new StringBuilder("");
                        int k = j + 1;
                        while (k <= j + wordLength) {
                                word.append(encoded.charAt(k));
                                k++;
                        }
                        result.add(String.valueOf(word));
                        i = k;
                }
                return result.toArray(new String[]{});
        }
}
