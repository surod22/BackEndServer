package backendsytem;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Result {
    @JsonProperty
    private int result;

    public Result(){}
    public Result(int result) {
        this.result = result;
    }
}
