package backendsytem;

import java.util.HashMap;

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
        String[] words = extractWords(text);
        HashMap<String, Integer> frequency = new HashMap<String, Integer>();

        if(words.length == (0)){
            return text;
        }

        if(words.length == (1)){
            return text;
        }

        String currentMaxWord = words[0];
        for(String word: words){

            if(frequency.containsKey(word)){
                frequency.put(word ,frequency.get(word)+1);
            } else{
                frequency.put(word,1);
                    currentMaxWord = word;
            }

                boolean isGreaterFrequency = frequency.get(word) > frequency.get(currentMaxWord);
                if(isGreaterFrequency || isSameFrequencyLowerAlphabetic(frequency, currentMaxWord, word)) {
                    currentMaxWord = word;
                }
        }
        if(currentMaxWord.equals(words.length-1)){
            return "All words in sentence are unique";
        }
        return  currentMaxWord;

    }

    private boolean isSameFrequencyLowerAlphabetic(HashMap<String, Integer> frequency, String currentMaxWord, String word) {
        return frequency.get(word)==frequency.get(currentMaxWord)&&
                    currentMaxWord.compareTo(word)>0;
    }

    public String median(String text) {
        if(text.isEmpty()){
            return text;
        }

        String[] words = extractWords(text);

        int midPosition = words.length/2;
        String median;
        if(midPosition%2==0){
            median=words[midPosition];
        }else{
            median = words[midPosition];
        }

        return median;
    }
}

