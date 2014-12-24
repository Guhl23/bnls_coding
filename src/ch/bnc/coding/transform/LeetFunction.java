package ch.bnc.coding.transform;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class LeetFunction implements TransformFunction {
    private static final Map<String, String> REPLACE_VALUES
            = new ImmutableMap.Builder<String, String>()
            .put("e", "3")
            .put("a", "4")
            .put("i", "1")
            .put("t", "7")
            .put("o", "0")
            .put("h", "|-|")
            .put("m", "|V|")
            .put("n", "|\\|")
            .build();

    @Override
    public String transfer(String value) throws FunctionException {
        String newValue = value.toLowerCase();
        for (Map.Entry<String, String> replaceValue : REPLACE_VALUES.entrySet()) {
            newValue = newValue.replaceAll(replaceValue.getKey(), replaceValue.getValue());
        }
        return newValue;
    }

}
