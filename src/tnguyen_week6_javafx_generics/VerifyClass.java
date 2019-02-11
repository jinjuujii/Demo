package tnguyen_week6_javafx_generics;

import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import static tnguyen_week6_javafx_generics.Main.intTextField;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Trinh Nguyen
 * @Assignment Name:
 * @Date: Oct 4, 2018
 * @Subclass VerifyClass Description: subclass to verify error in a TextField
 * given the conditions of the assignment.
 */
//Imports
//Begin Subclass VerifyClass
public class VerifyClass {

    static ArrayList<String> errorArr = new ArrayList<>();
    TextField textfield = new TextField();
    static double a;
    static int b;

    //setter
    public void setTextfield(TextField textfield) {
        this.textfield = textfield;
    }

    //getter 
    public TextField getTextfield() {
        return textfield;
    }

    /**
     * check to see if the textfield is empty
     *
     * @return
     */
    static boolean has_entry(TextField textfield1) {
        if (!textfield1.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * check to see if the textfield is in numbers only
     *
     * @return
     */
    boolean check_digit() {
        if (textfield.getText().matches("^\\d+$")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * check to see if a field contains a double
     *
     * @param textfield1
     * @return
     */
    static boolean check_double(TextField textfield1) {
        try {
            a = Double.parseDouble(textfield1.getText());
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }

    } // end check double

    /**
     * check to see if the field has a integer
     *
     * @param textfield1
     * @return
     */
    static boolean check_int(TextField textfield1) {
        try {
            a = Integer.parseInt(textfield1.getText());
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }

    } // end check_int  

    /**
     * check to see if the field contains a zero
     *
     * @param textfield1
     * @return
     */
    static boolean check_zero(TextField textfield1) {
        if ("0".equals(textfield1.getText())) {
            return true;
        } else {
            return false;
        }
    }

} //End Subclass VerifyClass
