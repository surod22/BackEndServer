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

        if(words.length <=1){
            return text;
        }

        String currentCommonWord = "";
        for(String word: words){
            if(frequency.containsKey(word)){
                frequency.put(word, frequency.get(word)+1);

            } else{
                frequency.put(word,1);
                if(currentCommonWord == ""){
                    currentCommonWord = word;
                }
            }

            if(frequency.get(word)==frequency.get(currentCommonWord)){
                currentCommonWord = getLowerAlphabetic(currentCommonWord, word);
            }
            if(frequency.get(word)>frequency.get(currentCommonWord)){
                currentCommonWord = word;
            }
        }

        return  currentCommonWord;

    }

    public String getLowerAlphabetic(String currentMaxWord, String word) {
        String firstWordAlphabetical = "";
        String firstWordLower = currentMaxWord.toLowerCase();
        String secondWordLower = word.toLowerCase();
        if(firstWordLower.compareTo(secondWordLower)<0){
            firstWordAlphabetical = currentMaxWord;

        }if(firstWordLower.compareTo(secondWordLower)>0){
            firstWordAlphabetical = word;

        }else{
            firstWordAlphabetical = currentMaxWord;
        }
        return firstWordAlphabetical;
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

