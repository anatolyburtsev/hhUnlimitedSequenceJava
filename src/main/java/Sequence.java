import org.apache.log4j.Logger;

/**
 * Created by onotole on 9/26/16.
 */
public class Sequence {
    private String seq = "";
    private int currentSeqSize = 0;
    public static final Logger log = Logger.getLogger(Sequence.class);

    public String findSubstringIndex(String pattern) throws BadInputException {
        validate(pattern);
        int sequenceSize = Integer.valueOf(pattern);
        if (currentSeqSize < sequenceSize) {
            log.debug("Need to regenerate sequence! New size: " + sequenceSize);
            seq = generateSequence(sequenceSize);
            currentSeqSize = sequenceSize;
        }
        // +1 because numberings starts from 1 by the condition of the problem
        String result = "" + (lookingForSubstring(seq, pattern) + 1);
        log.debug("I've found pattern at position: " + result);
        return result;
    }

    String generateSequence(int size) {
        log.debug("start generating new Sequence");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < size + 1; i++) {
            stringBuilder.append("" + i);
        }
        return stringBuilder.toString();
    }

    int lookingForSubstring(String sequence, String pattern) {
        log.debug("start looking for pattern " + pattern + " in sequence");
        return sequence.indexOf(pattern);
    }

    void validate(String input) throws BadInputException {
        log.debug("start validating: " + input);
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BadInputException(Strings.badInput, e);
        }
    }

}
