/*
 * Copyright (C) 2014 Luca Neukom <luca.neukom@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ch.bnc.coding;

import ch.bnc.coding.functions.FunctionModule;
import ch.bnc.coding.menu.Menu;
import ch.bnc.coding.menu.MenuPointModule;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luca Neukom <luca.neukom@gmail.com>
 */
public class BNLS {
    private static final Splitter COMMAND_SPLITTER = Splitter.on(" ")
            .omitEmptyStrings().trimResults();
            
    private static Menu menu;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MenuPointModule(), new FunctionModule());
        menu = injector.getInstance(Menu.class);
        
        while(true) {
            displayMenuPoints();
            readCommand();
        }
    }

    private static void displayMenuPoints() {
        menu.listOptions();
    }

    private static void readCommand() {
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
        menu.runMenu(menuId, arguments);
        System.out.println();
    }

}
