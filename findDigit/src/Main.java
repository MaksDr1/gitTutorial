import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	    String text  = readText("src/Text");

        ArrayList<String> numbers = findNums(text);

        System.out.println(numbers);
    }

    private static String readText(String filename) throws IOException {
        String content = Files.readString(Paths.get(filename), StandardCharsets.UTF_8);
        return content;
    }

    private static ArrayList<String> findNums(String text) {

        System.out.println(text);
        ArrayList<String> numList = new ArrayList<>();


        boolean startFound = false;
        int startIndex =0;
        int lastIndex=0;
        for(int i =0;i<text.length();i++){
                if (startFound != true) {
                    //start
                    if (Character.isDigit(text.charAt(i))) {
                        startIndex = i;
                        startFound = true;
                    }
                } else {
                    //end
                    if (!Character.isDigit(text.charAt(i))) {
                        lastIndex = i;
                        startFound = false;
                        numList.add(text.substring(startIndex,lastIndex));
                    }
                }
        }

        return numList;
    }
}

