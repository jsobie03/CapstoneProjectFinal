package FPutils;

import javax.swing.*;

/**
 * validate the user’s data field entries.
 *
 * @author Jonathan Sobier
 * @version 12/17/2017
 */
public class Validator {

    public boolean isNotEmpty(JTextField field, String fieldName) {
        return !fieldName.equals("");
    }

    public boolean isInteger(JTextField field, String fieldName) {
        try {
            int i = Integer.parseInt(field.getText());
            return true;
        } catch (NumberFormatException e) {
            showMessage(field, fieldName + " must be an integer.");
            field.requestFocusInWindow();
            return false;
        }
    }

    public boolean isNotInteger(JTextField field, String fieldName) {

        char[] chars = field.getText().toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)) {
                showMessage(field, fieldName + " is an invalid entry.\n"
                        + "Please re-enter.");
                field.requestFocusInWindow();
                return false;
            }
        }
        return true;
    }

    public boolean isEmail(JTextField field, String fieldName) {

        StringBuilder sb = new StringBuilder(field.getText());
        sb.trimToSize();

        if (sb.indexOf("@") != -1
                && sb.indexOf(".") != -1
                && sb.indexOf("@") > 0
                && sb.indexOf("@") + 1 < sb.indexOf(".")
                && sb.indexOf(".") < sb.length() - 1) {

            char[] chars = field.getText().toCharArray();

            int count = 0;
            for (char c : chars) {
                if (Character.compare(c, '@') == 0
                        || Character.compare(c, '.') == 0) {
                    count++;
                }
            }

            if (count != 2) {
                showMessage(field, fieldName + " is an invalid entry.\n"
                        + "Please re-enter.");
                field.requestFocusInWindow();
                return false;
            }
        } else {
            showMessage(field, fieldName + " is an invalid entry.\n"
                    + "Please re-enter.");
            field.requestFocusInWindow();
            return false;
        }
        return true;
    }

    private void showMessage(JTextField c, String message) {
        JOptionPane.showMessageDialog(c, message, "Invalid Entry",
                JOptionPane.ERROR_MESSAGE);
    }
}
