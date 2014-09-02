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

package ch.bnc.coding.transformfunctions;

import com.google.inject.Inject;
import java.util.Map;

/**
 *
 * @author Luca Neukom <luca.neukom@gmail.com>
 */
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

    private static class FunctionNotFoundException extends Exception {

        public FunctionNotFoundException(String id) {
            super(String.format("Function with id '%s' is not registered!", id));
        }
    }
}
