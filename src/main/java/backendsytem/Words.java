package backendsytem;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Words {

    @JsonProperty("text")
    private String text;

    @JsonProperty("avglength")
    private int avgLength;

    @JsonProperty("mostcommon")
    private String mostCommon;

    public Words(){}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAvgLength() {
        return avgLength;
    }

    public void setAvgLength(int avgLength) {
        this.avgLength = avgLength;
    }

    public void setMostCommon(String mostCommon) {
        this.mostCommon = mostCommon;
    }
}
