import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by onotole on 9/26/16.
 */
public class Main {
    public static void main(String[] args) throws IOException, BadInputException {
        Sequence sequence = new Sequence();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String output;

        while(true) {
            String pattern = stdin.readLine();
            try {
                output = sequence.findSubstringIndex(pattern);
            } catch (BadInputException e) {
                output = Strings.tryOneMoreTime;
            }
            System.out.println(output);
        }

    }
}
