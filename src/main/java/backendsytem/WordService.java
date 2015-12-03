package backendsytem;

/**
 * Created by srodriguez on 12/3/15.
 */
public class WordService {
    public int averageWordLength(String text) {
        String[] words = extractWords(text);
        Integer totalLength = 0;

        if(words.length == 0){
            return totalLength;
        }

        for(String word: words){
             totalLength += word.length();
        }

        return Math.floorDiv(totalLength,words.length);
    }

    public String[] extractWords(String wordsString){
        String[] words;

        if(wordsString.matches(".*\\d.*")){
            throw new RuntimeException("One or more words have digits");
        }
        if(wordsString.isEmpty()){
            words = new String[0];
        }else{
            words =wordsString.replace(".", " ")
                    .replace(",", " ").split(" ");
        }
        return words;
    }

    public String mostCommonWord(String text) {
        return null;
    }
}

