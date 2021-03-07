package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.TextArea;

public class SecondTask {
    public void initialize() {
        input_text.textProperty().addListener((observable, oldValue, newValue) -> {
            result_text.setText(new_string);
            String text = input_text.getText();
            Matcher matcher = date.matcher(text);
            while (matcher.find()) {
                result_text.appendText(matcher.group() + "\n");
            }
        });
    }

    private final static String new_string = "";
    private static Pattern date = Pattern.compile("([0]?[1-9]|[1-2][0-9]|(3)[0-1])((-)|(.))(((0)[1-9])|(1)[1-2])((-)|(.))([1-9]([0-9]{3}))");
    public TextArea input_text;
    public TextArea result_text;
}
