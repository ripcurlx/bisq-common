/*
 * This file is part of Bisq.
 *
 * bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.common.util;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UtilitiesTest {

    @Test
    public void testConcatenateByteArrays() {
        assertTrue(Arrays.equals(new byte[]{0x01, 0x02}, Utilities.concatenateByteArrays(new byte[]{0x01}, new byte[]{0x02})));
        assertTrue(Arrays.equals(new byte[]{0x01, 0x02, 0x03}, Utilities.concatenateByteArrays(new byte[]{0x01}, new byte[]{0x02}, new byte[]{0x03})));
        assertTrue(Arrays.equals(new byte[]{0x01, 0x02, 0x03, 0x04}, Utilities.concatenateByteArrays(new byte[]{0x01}, new byte[]{0x02}, new byte[]{0x03}, new byte[]{0x04})));
        assertTrue(Arrays.equals(new byte[]{0x01, 0x02, 0x03, 0x04, 0x05}, Utilities.concatenateByteArrays(new byte[]{0x01}, new byte[]{0x02}, new byte[]{0x03}, new byte[]{0x04}, new byte[]{0x05})));
    }

    @Test
    public void testToStringList() {
        assertTrue(Utilities.commaSeparatedListToSet(null, false).isEmpty());
        assertTrue(Utilities.commaSeparatedListToSet(null, true).isEmpty());
        assertTrue(Utilities.commaSeparatedListToSet("", false).isEmpty());
        assertTrue(Utilities.commaSeparatedListToSet("", true).isEmpty());
        assertTrue(Utilities.commaSeparatedListToSet(" ", false).isEmpty());
        assertEquals(1, Utilities.commaSeparatedListToSet(" ", true).size());
        assertTrue(Utilities.commaSeparatedListToSet(",", false).isEmpty());
        assertTrue(Utilities.commaSeparatedListToSet(",", true).isEmpty());
        assertEquals(1, Utilities.commaSeparatedListToSet(",test1", false).size());
        assertEquals(1, Utilities.commaSeparatedListToSet(", , test1", false).size());
        assertEquals(2, Utilities.commaSeparatedListToSet(", , test1", true).size());
        assertEquals(1, Utilities.commaSeparatedListToSet("test1,", false).size());
        assertEquals(1, Utilities.commaSeparatedListToSet("test1, ,", false).size());
        assertEquals(1, Utilities.commaSeparatedListToSet("test1", false).size());
        assertEquals(2, Utilities.commaSeparatedListToSet("test1, test2", false).size());
    }
}
