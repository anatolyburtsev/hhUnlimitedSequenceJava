import org.apache.log4j.Logger;

/**
 * Created by onotole on 9/26/16.
 */
public class Sequence {
    public static final Logger log = Logger.getLogger(Sequence.class);
    private String seq = "";
    private int currentSeqSize = 0;
    private int maxNumberInSequence = 0;
    private static final int START_SEQUENCE_LENGTH = 100;

    public Sequence() {
        this(START_SEQUENCE_LENGTH);
    }

    public Sequence(int size) {
        seq = extendSequence(size);
    }

    public String findSubstringIndex(String pattern) throws BadInputException {
        validate(pattern);
        int position = lookingForSubstring(seq, pattern);;
        while ( position == -1) {
            doubledSequence();
            position = lookingForSubstring(seq, pattern);
        }

        // +1 because numberings starts from 1 by the condition of the problem
        String result = "" + (position + 1);
        log.debug("I've found pattern at position: " + result);
        return result;
    }

    String extendSequence(int newMaxNumber) {
        log.debug("start generating new Sequence");
        StringBuilder stringBuilder = new StringBuilder(seq);
        for (int i = maxNumberInSequence + 1; i < newMaxNumber + 1; i++) {
            stringBuilder.append(String.valueOf(i));
        }
        String resultSequence = stringBuilder.toString();
        maxNumberInSequence = newMaxNumber;
        log.debug("new Sequence: " + resultSequence);
        return resultSequence;
    }

    void doubledSequence() {
        seq = extendSequence(maxNumberInSequence * 2);
    }

    int lookingForSubstring(String sequence, String pattern) {
        log.debug("start looking for pattern " + pattern + " in sequence");
        return sequence.indexOf(pattern);
    }

    void validate(String input) throws BadInputException {
        log.debug("start validating: " + input);
        for (Character ch: input.toCharArray()) {
            if( ! Character.isDigit(ch)) {
                throw new BadInputException(Strings.badInput);
            }
        }
    }

}


