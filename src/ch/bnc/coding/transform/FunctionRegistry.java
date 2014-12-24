package ch.bnc.coding.transform;

import com.google.inject.Inject;
import java.util.Map;

public class FunctionRegistry {
    Map<String, TransformFunction> functions;
    @Inject
    public FunctionRegistry(Map<String, TransformFunction> functions) {
        this.functions = functions;
    }
    
    public TransformFunction getFunction(String id) throws FunctionNotFoundException {
        if(functions.containsKey(id)) {
            return functions.get(id);
        } else {
            throw new FunctionNotFoundException(id);
        }
    }

    public Map<String, TransformFunction> getTransformFunctions() {
        return functions;
    }

    public static class FunctionNotFoundException extends Exception {

        public FunctionNotFoundException(String id) {
            super(String.format("Function with id '%s' is not registered!", id));
        }
    }
}
