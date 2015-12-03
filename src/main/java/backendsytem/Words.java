package backendsytem;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by srodriguez on 12/3/15.
 */
public class Words {

    @JsonProperty("text")
    private String text;
    private int avgLength;

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
}
