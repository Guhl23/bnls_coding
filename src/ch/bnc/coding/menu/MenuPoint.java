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

package ch.bnc.coding.menu;

import java.util.List;

/**
 *
 * @author Luca Neukom <luca.neukom@gmail.com>
 */
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
