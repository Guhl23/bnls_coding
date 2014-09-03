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

package ch.bnc.coding.functions;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

/**
 *
 * @author Luca Neukom <luca.neukom@gmail.com>
 */
public class LeetFunction implements TransformFunction {
    private static final Map<String, String> REPLACE_VALUES
            = new ImmutableMap.Builder<String, String>()
            .put("e", "3")
            .put("E", "3")
            .put("a", "4")
            .put("A", "4")
            .put("i", "1")
            .put("I", "1")
            .put("t", "7")
            .put("T", "7")
            .put("o", "0")
            .put("O", "0")
            .put("h", "|-|")
            .put("H", "|-|")
            .put("m", "|V|")
            .put("M", "|V|")
            .put("n", "|\\|")
            .put("N", "|\\|")
            .build();

    @Override
    public String transfer(String value) throws FunctionException {
        String newValue = value;
        for (Map.Entry<String, String> replaceValue : REPLACE_VALUES.entrySet()) {
            newValue = newValue.replaceAll(replaceValue.getKey(), replaceValue.getValue());
        }
        return newValue;
    }

}
