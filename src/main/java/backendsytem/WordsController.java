package backendsytem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class WordsController {

    @RequestMapping(value="/main")
    public Words home(){
        return new Words();
    }

    @RequestMapping(value = "/words/avg_len", method= RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public String avglenHandler(@RequestBody Words words) throws IOException {
        WordService wordService = new WordService();
        ObjectMapper mapper = new ObjectMapper();

        words.setAvgLength(wordService.averageWordLength(words.getText()));
        String response = mapper.writeValueAsString(words);

        return response;
    }

    @RequestMapping(value = "/words/most_com", method= RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public String mostCommonWordHandler(@RequestBody Words words) throws IOException {
        WordService wordService = new WordService();
        ObjectMapper mapper = new ObjectMapper();

        words.setMostCommon(wordService.mostCommonWord(words.getText()));
        String response = mapper.writeValueAsString(words);

        return response;
    }

    @RequestMapping(value = "/words/median", method= RequestMethod.POST,

            produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public String medianWordHandler(@RequestBody String jsonString, Model model) throws IOException {
        Gson gson = new Gson();
        Words words = gson.fromJson(jsonString, Words.class);
        WordService wordService = new WordService();
        return gson.toJson(wordService.median(words.getText())).concat("\n");
    }
}