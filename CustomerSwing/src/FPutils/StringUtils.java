package FPutils;

/**
 * Use spaces to align the customer data in columns on the console.
 *
 * @author Jonathan Sobier
 * @version 12/17/2017
 */
public class StringUtils {

    public static String padWithSpaces(String s, int length) {
        if (s.length() < length) {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < length) {
                sb.append(" ");
            }
            return sb.toString();
        } else {
            return s.substring(0, length);
        }
    }
}
