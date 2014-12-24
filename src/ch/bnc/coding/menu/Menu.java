package ch.bnc.coding.menu;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final Splitter COMMAND_SPLITTER = Splitter.on(" ")
            .omitEmptyStrings().trimResults();
    
    private final MenuPointRegistry menuRegistry;
    
    @Inject
    public Menu(MenuPointRegistry menuRegistry) {
        this.menuRegistry = menuRegistry;
    }
    
    
    public void run() {
    	displayMenuPoints();
    	readCommand();
    }

    private void displayMenuPoints() {
        listOptions();
    }

    public void listOptions() {
        menuRegistry.getMenuPoints().entrySet().stream().map((menuPointEntry) -> {
            MenuPoint menuPoint = menuPointEntry.getValue();
            Object[] functionValues = {
                menuPointEntry.getKey(),
                menuPoint.getLabel(),
                menuPoint.getDescription()
            };
            return functionValues;
        }).forEach((functionValues) -> {
            System.out.println(String.format("%s\n--- %s: %s", functionValues));
        });
    }

    private void readCommand() {
        System.out.println();
        System.out.println("ID des gewünschten Menüpunkt: ");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        List<String> commandWithArguments = COMMAND_SPLITTER.splitToList(line);
        String menuId = commandWithArguments.get(0);
        List<String> arguments;
        if(commandWithArguments.size() > 1) {
            arguments = commandWithArguments.subList(1, commandWithArguments.size());
        } else {
            arguments = Lists.newArrayList();
        }
        runMenu(menuId, arguments);
        System.out.println();
    }

    public void runMenu(String id, List<String> arguments) {
    	try {
    		MenuPoint menuPoint = menuRegistry.getMenuPoint(id);
    		System.out.println(menuPoint.run(arguments));
    	} catch (MenuPointRegistry.MenuPointNotFoundException
    			| MenuPoint.MenuException
    			| MenuPoint.ArgumentsException e) {
    		System.out.println(e.getMessage());
    	}
    }
}
