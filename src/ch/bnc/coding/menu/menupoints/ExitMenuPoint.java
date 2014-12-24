package ch.bnc.coding.menu.menupoints;

import ch.bnc.coding.menu.MenuPoint;
import java.util.List;

public class ExitMenuPoint implements MenuPoint {

    @Override
    public String run(List<String> arguments) {
        System.exit(0);
        return "";
    }

    @Override
    public String getLabel() {
        return "Schliessen";
    }

    @Override
    public String getDescription() {
        return "Das Programm schliessen";
    }

}
