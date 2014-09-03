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

package ch.bnc.coding.menu.menupoints;

import ch.bnc.coding.functions.FunctionRegistry;
import ch.bnc.coding.functions.TransformFunction;
import ch.bnc.coding.menu.MenuPoint;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luca Neukom <luca.neukom@gmail.com>
 */
public class TransformMenuPoint implements MenuPoint {
    private final static Joiner NEW_LINE_JOINER = Joiner.on("\n").skipNulls();
    private final static Joiner SPACE_JOINER = Joiner.on(" ").skipNulls();
    
    private final FunctionRegistry functionRegistry;
    
    @Inject
    public TransformMenuPoint(FunctionRegistry functionRegistry) {
        this.functionRegistry = functionRegistry;
    }

    @Override
    public String run(List<String> arguments) throws ArgumentsException, MenuException {
        if(arguments.size() == 1 && arguments.get(0).equals("list")) {
            Map<String, TransformFunction> functions = functionRegistry.getTransformFunctions();
            List<String> functionMessage = Lists.newArrayList();
            functionMessage.add("Available functions:");
            functions.keySet().stream().forEach((id) -> {
                functionMessage.add(String.format("--- %s", id));
            });
            return NEW_LINE_JOINER.join(functionMessage);
        }
        if(arguments.size() < 2) {
            throw new ArgumentsException("Usages of '%s' is:\n- transform <function> <value>\n- transform list");
        }
        String functionId = arguments.get(0);
        List<String> values = arguments.subList(1, arguments.size());
        String value = SPACE_JOINER.join(values);
            
        try {
            TransformFunction function = functionRegistry.getFunction(functionId);
            return function.transfer(value);
        } catch (FunctionRegistry.FunctionNotFoundException e) {
            throw new MenuException(getLabel(), e.getMessage(), e);
        } catch (TransformFunction.FunctionException e) {
            throw new MenuException(getLabel(), String.format("Function failed!"), e);
        }
    }

    @Override
    public String getLabel() {
        return "Transform";
    }

    @Override
    public String getDescription() {
        return "Transformiere einen String";
    }

}
