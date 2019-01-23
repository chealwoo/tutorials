package cwl.string;

public class MyStringUtil {


    private String removeEscapeFromString(String input) {
        return input.replaceAll("\\\\\"", "\"");
    }

}
