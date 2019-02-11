package tnguyen_week6_javafx_generics;

/**
 * @Course: SDEV 350 ~ Java Programming II
 * @Author Name: Trinh Nguyen
 * @Assignment Name: Week 56 - JavaFX Generics
 * @Date: Oct 14, 2018
 * @Description: A Simple program that implements a Generic class for adding and
 * removing objects to an array list
 */
//Imports
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//Begin Class Main

public class Main extends Application {

    static TextArea displayTxt = new TextArea();
    static TextField stTextField = new TextField();
    static TextField intTextField = new TextField();
    static TextField dblTextField = new TextField();
    static Generic<Object> list = new Generic<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        root.setTop(getTop());
        root.setBottom(getBot());
        root.setRight(getRight());
        root.setLeft(getLeft());

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Generic Class - Trinh Nguyen");
        primaryStage.show();

    }

    /**
     * top node
     *
     * @return
     */
    private VBox getTop() {
        VBox top = new VBox(1);
        top.setAlignment(Pos.CENTER);
        Text text1 = new Text("Generic Class Implementation");
        Text text2 = new Text("Enter a character, word, or number of "
                + "any type and click enter.");
        text1.setFont(new Font(26));
        text2.setFont(new Font(16));
        text1.setFill(Color.BLUEVIOLET);
        text2.setFill(Color.BLUEVIOLET);

        top.getChildren().addAll(text1, text2);
        return top;
    } // end getTOP

    /**
     * bottom node
     *
     * @return
     */
    private HBox getBot() {
        HBox bot = new HBox(5);
        bot.setPadding(new Insets(10, 10, 10, 10));
        Button enterBtn = new Button("Enter");
        Button clearBtn = new Button("Clear");
        Button removeBtn = new Button("Remove");
        Button exitBtn = new Button("Exit");

        exitBtn.setOnAction(new exitHandler());
        clearBtn.setOnAction(new clearHandler());
        enterBtn.setOnAction(new enterHanlder());
        removeBtn.setOnAction(new removeHanlder());
        bot.getChildren().addAll(enterBtn, clearBtn, removeBtn, exitBtn);
        bot.setAlignment(Pos.CENTER);

        return bot;

    }

    /**
     * left node
     *
     * @return
     */
    private VBox getLeft() {
        VBox left = new VBox(5);

        HBox insideLeft = new HBox(5);
        Label enterst = new Label("Input a String:     ");
        insideLeft.getChildren().addAll(enterst, stTextField);

        HBox middle = new HBox(5);
        Label integer = new Label("Input an Integer: ");
        middle.getChildren().addAll(integer, intTextField);

        HBox bott = new HBox(5);
        Label dbllbl = new Label("Input a Double:   ");
        bott.getChildren().addAll(dbllbl, dblTextField);

        left.getChildren().addAll(insideLeft, middle, bott);

        left.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

        left.setAlignment(Pos.CENTER);

        return left;
    }//ends getLeft() 

    /**
     * right node
     *
     * @return
     */
    private HBox getRight() {
        HBox right = new HBox(5);
        right.setMaxSize(250, 150);
        right.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        right.getChildren().add(displayTxt);
        return right;
    }

    /**
     * exit the program
     */
    private static class exitHandler implements EventHandler<ActionEvent> {

        public exitHandler() {
        }

        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    }

    private static class clearHandler implements EventHandler<ActionEvent> {

        public clearHandler() {
        }

        @Override
        public void handle(ActionEvent event) {
            list.Clear();
            displayTxt.clear();
            intTextField.clear();

            dblTextField.clear();
            stTextField.clear();
            stTextField.requestFocus();

        }
    }

    private static class enterHanlder implements EventHandler<ActionEvent> {

        public enterHanlder() {
        }

        @Override
        public void handle(ActionEvent event) {
            ArrayList<String> alerts = new ArrayList<>();
            boolean counter;
            if (stTextField.getText() != "" || dblTextField.getText() != ""
                    || intTextField.getText() != "") {
                counter = true;
            } else {
                counter = false;
            }

            if (((VerifyClass.check_double(dblTextField)) == false || 
                    VerifyClass.check_zero(dblTextField)) && 
                    VerifyClass.has_entry(dblTextField)) {
                alerts.add("Please enter a Double that is not 0");
            }
            if ((VerifyClass.check_int(intTextField) == false || 
                    VerifyClass.check_zero(intTextField)) && 
                    VerifyClass.has_entry(intTextField)) {
                alerts.add("Please enter an Integer that is not 0");
            }

            if (alerts.isEmpty()) {
                if (counter = true && VerifyClass.has_entry(stTextField)) {
                    list.Add(stTextField.getText());
                }
                if (counter = true && VerifyClass.has_entry(intTextField)
                        && VerifyClass.check_zero(intTextField) == false) {
                    list.Add(intTextField.getText());
                }
                if (counter = true && VerifyClass.has_entry(dblTextField)
                        && VerifyClass.check_zero(dblTextField) == false) {
                    list.Add(dblTextField.getText());
                }
            }

            //   } 
            // else if {
            if (alerts.isEmpty()) {
                displayTxt.clear();
                for (int i = 0; i < list.getSize(); i++) {
                    displayTxt.appendText((String) list.get(i));
                    displayTxt.appendText(" ");
                }

            } else {
                String display = "";
                for (String x : alerts) {
                    display = display + x + "\n";
                }
                Alert Warning = new Alert(Alert.AlertType.WARNING);
                Warning.setHeaderText("Error(s)");
                Warning.setContentText(display);
                Warning.showAndWait();
            }

        }

    } //end enterhandler class

    private static class removeHanlder implements EventHandler<ActionEvent> {

        public removeHanlder() {
        }

        @Override
        public void handle(ActionEvent event) {

            displayTxt.clear();
            list.Remove();
            for (int i = 0; i < list.getSize(); i++) {
                displayTxt.appendText(list.get(i) + " ");
            }

        }
    }

} //End Class Main
