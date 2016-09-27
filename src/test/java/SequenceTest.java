import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

/**
 * Created by onotole on 9/26/16.
 */
public class SequenceTest {
    private Sequence sequence;

    @Before
    public void setUp() throws Exception {
        sequence = new Sequence();
    }

    @Test
    public void findSubstringIndex1() throws Exception {
        assertThat("первый пример", sequence.findSubstringIndex("6789"), equalTo("6"));
    }

    @Test
    public void findSubstringIndex2() throws Exception {
        assertThat("второй пример", sequence.findSubstringIndex("111"), equalTo("12"));
    }

    @Test
    public void findSubstringCheckSequenceExtender() throws BadInputException {
        assumeThat("первый поиск", sequence.findSubstringIndex("10"), equalTo("10"));
        assertThat("второй поиск", sequence.findSubstringIndex("11"), equalTo("12"));
    }

    @Test
    public void generateSequence() throws Exception {
        assertThat("генерится правильная последовательность", sequence.extendSequence(15), equalTo("123456789101112131415"));
    }

    @Test
    public void lookingForSubstring() throws Exception {
        assertThat("поиск по подстроке", sequence.lookingForSubstring("abaa4c", "aa"), equalTo(2));
    }

    @Test
    public void checkRecreationSequence() throws BadInputException {
        // second and the follows launch must be more faster than first one, because Sequence generated already. (Except case with extending Sequence)
        // this test doesn't work with enabled logging
        if (Sequence.log.isTraceEnabled()) return;
        String bigNumber = "54329";
        long startTime = System.nanoTime();
        sequence.findSubstringIndex(bigNumber);
        long firstLaunchTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        sequence.findSubstringIndex(bigNumber);
        long secondLaunchTime = System.nanoTime() - startTime;
        assertThat("время работы уменьшилось", firstLaunchTime > 10 * secondLaunchTime, equalTo(true));
    }

    @Test(expected = BadInputException.class)
    public void checkValidate() throws BadInputException {
        sequence.validate("123f4");
    }


}