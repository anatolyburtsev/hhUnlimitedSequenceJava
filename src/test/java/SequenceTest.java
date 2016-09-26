import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

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
    public void generateSequence() throws Exception {
        assertThat("генерится правильная последовательность", sequence.generateSequence(15), equalTo("123456789101112131415"));
    }

    @Test
    public void lookingForSubstring() throws Exception {
        assertThat("поиск по подстроке", sequence.lookingForSubstring("abaa4c", "aa"), equalTo(2));
    }

    @Test
    public void checkRecreationSequence() throws BadInputException {
        // второй запуск должен быть значительно быстрее, т.к. последовательность уже сгенерированна
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