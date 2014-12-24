package ch.bnc.coding.transform;

public interface TransformFunction {
    String transfer(String value) throws FunctionException;

    public static class FunctionException extends Exception {

        public FunctionException(String label) {
            super(String.format("Function '%s' failed!", label));
        }
    }
}
