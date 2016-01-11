package backendsytem;

import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@RestController
@EnableAutoConfiguration
public class WordsController {

    @RequestMapping(value="/main")
    public HashMap<String, Object> home(){
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("id", "1234");
        model.put("content", "Hello world");
        return model;
    }
    @RequestMapping(value = "/words/avg_len", method= RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Words> avglenHandler(@RequestBody Words words) throws IOException {
        WordService wordService = new WordService();
        words.setAvgLength(wordService.averageWordLength(words.getText()));
        HashMap<String, Integer> model = new HashMap<String, Integer>();
        model.put("avgLength", words.getAvgLength());
        //return model;
        return new ResponseEntity<Words>(words, HttpStatus.ACCEPTED);

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