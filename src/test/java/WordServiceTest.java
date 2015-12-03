import backendsytem.WordService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by srodriguez on 12/3/15.
 */
public class WordServiceTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void extractWordsThrowsErrorGivenStringWithDigit(){
        WordService wordService = new WordService();

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("One or more words have digits");

        wordService.extractWords("1");
    }

    @Test
    public void extractWordsReturnsEmptyArrayWhenStringIsEmpty(){
        WordService wordService = new WordService();

        String[] words = wordService.extractWords("");

        assertThat(words).isEmpty();
    }

    @Test
    public void extractWordsReturnsWordsGivenStringHasSpaces(){
        WordService wordService = new WordService();

        String[] words = wordService.extractWords("you are funny");

        assertThat(words).hasSize(3);
    }

    @Test
    public void extractWordsReturnsTwoWordsGiveWordsAndPeriod(){
        WordService wordService = new WordService();

        String[] words = wordService.extractWords("you.me");

        assertThat(words).hasSize(2);
    }


    @Test
    public void extractWordsReturnsTwoWordsGiveWordsAndComma(){
        WordService wordService = new WordService();

        String[] words = wordService.extractWords("you,me");

        assertThat(words[0]).isEqualTo("you");
        assertThat(words[1]).isEqualTo("me");
        assertThat(words).hasSize(2);
    }

    @Test
    public void extractWordsReturnsOneWordGiveStringWithOneCharacter(){
        WordService wordService = new WordService();

        String[] words = wordService.extractWords("y");

        assertThat(words[0]).isEqualTo("y");
        assertThat(words).hasSize(1);
    }


    @Test
    public void averageWordLengthReturnsZeroGivenEmptyString(){
        WordService wordService = new WordService();

        Integer result = wordService.averageWordLength("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void averageWordLengthReturnsOneGivenOneCharString(){
        WordService wordService = new WordService();

        Integer result = wordService.averageWordLength("a");

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void averageWordLengthReturnsTwoGivenTwoWordString(){
        WordService wordService = new WordService();

        Integer result = wordService.averageWordLength(" I con");

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void averageWordLengthReturnsLowerBoundGivenOddTotalLength(){
        WordService wordService = new WordService();

        Integer result = wordService.averageWordLength("I total i");

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void averageWordLengthReturnsLowerBoundGivenThreeWordsWithDot(){
        WordService wordService = new WordService();

        Integer result = wordService.averageWordLength("I.total.i");

        assertThat(result).isEqualTo(2);
    }


}
