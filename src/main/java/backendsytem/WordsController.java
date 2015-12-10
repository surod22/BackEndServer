package backendsytem;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by srodriguez on 12/2/15.
 */

@Controller
public class WordsController {

    @RequestMapping(value = "/words/avg_len", method= RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public String avglenHandler(@RequestBody String jsonString, Model model) throws IOException {
        Gson gson = new Gson();
        Words words = gson.fromJson(jsonString, Words.class);
        WordService wordService = new WordService();
        return gson.toJson(wordService.averageWordLength(words.getText())).concat("\n");
    }

    @RequestMapping(value = "/words/most_com", method= RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public String mostCommonWordHandler(@RequestBody String jsonString, Model model) throws IOException {
        Gson gson = new Gson();
        Words words = gson.fromJson(jsonString, Words.class);
        WordService wordService = new WordService();
        return gson.toJson(wordService.mostCommonWord(words.getText())).concat("\n");
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