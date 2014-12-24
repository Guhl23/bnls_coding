package ch.bnc.coding.menu;

import java.util.List;

public interface MenuPoint {
    String run(List<String> arguments) throws MenuException, ArgumentsException;
    String getLabel();
    String getDescription();

    public static class MenuException extends Exception {

        public MenuException(String label, String message) {
            super(String.format("Menu point '%s' failed!\n%s", label, message));
        }

        public MenuException(String label, String message, Exception e) {
            super(String.format("Menu point '%s' failed!\n%s", label, message), e);
        }
    }

    public static class ArgumentsException extends Exception {

        public ArgumentsException(String message) {
            super(String.format("Error in arguments: %s", message));
        }
    }
}
