package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstTask {
    private void is_match(Matcher matcher) {
        if (matcher.matches())
            my_circle.setFill(Color.GREEN);
        else
            my_circle.setFill(Color.RED);
    }

    public void initialize() {
        my_choice_box.setItems(FXCollections.observableArrayList(TYPE_OF_DATA));
        my_choice_box.setValue(natural_digit);
        my_text_field.textProperty().addListener((observable, oldValue, newValue) -> {
            switch (my_choice_box.getValue()) {
                case natural_digit:
                    is_match(natural.matcher(newValue));
                    break;

                case date_expression:
                    is_match(date.matcher(newValue));
                    break;

                case int_digit:
                    is_match(integer.matcher(newValue));
                    break;

                case email_expression:
                    is_match(email.matcher(newValue));
                    break;

                case time_expression:
                    is_match(time.matcher(newValue));
                    break;

                case float_point_digit:
                    is_match(float_point.matcher(newValue));
                    break;
            }
        });


    }

    private static final String natural_digit = "natural digits";
    private static final String int_digit = "integer digits";
    private final static String float_point_digit = "float point digits";
    private final static String date_expression = "date form";
    private final static String time_expression = "time form";
    private final static String email_expression = "email form";
    private final static String[] TYPE_OF_DATA = {natural_digit, int_digit, float_point_digit, date_expression, time_expression, email_expression};

    private static Pattern natural = Pattern.compile("([1-9]+)([0-9]*)");
    //12, 34822 : 0, -1, 1.0
    private static Pattern integer = Pattern.compile("[+-]?([0-9]*)([0-9]+)");
    //0, -1, +1,45453546 : 1.1, +-3435
    //private static Pattern float_point = Pattern.compile("[-+]?(([0-9]*(.)[0-9]+)|([0-9]+(.)[0-9]*))([eE]([-+]?)(.)[0-9]*)?");
    private final static Pattern float_point = Pattern.compile("(-?[1-9]\\d*|0)+(\\.\\d*(e(-?[1-9]\\d*|0))?|(e(-?[1-9]\\d*|0)))");
    // .1, 1. , -0.34, 10e-3434 1e9, 1.9e9, 3e-9, 23232.45454, 34343. : 35b-343, 3e23, 33.332.2, 111/11, 66 0 .46565
    private static Pattern date = Pattern.compile("([0]?[1-9]|[1-2][0-9]|(3)[0-1])((-)|(.))(((0)[1-9])|(1)[1-2])((-)|(.))([1-2]([0-9]{3}))");
    // 23.12.2222 , 08-01-1897 , 6.04-2001 : 39.11.1111, 1.13.44, 32-9.44444
    private static Pattern time = Pattern.compile("([0-1][0-9]|(2)[0-4])((.)|(-))(((0)[0-9])|([1-5][0-9]))");
    //11.21 , 24.00 , 01-59, 00.01 : 1.33, 01.333, 12.61, 25-44
    private static Pattern email = Pattern.compile("[a-zA-z]+([.]|[-]|[/])?[a-zA-z]*(@)((gmail)|(mail)|(yandex))(.)((ru)|(com)|(by))");
    //ira.mav@mail.ru , olgak@gmail.com , stasy/ss@mail.com : mm/ee@tut.by, kate?k@mail.gfdg, rrr.mail.ru, .@mail.com


    @FXML
    private TextField my_text_field;
    @FXML
    private ChoiceBox<String> my_choice_box;
    @FXML
    private Circle my_circle;
}
