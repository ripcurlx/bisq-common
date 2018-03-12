/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.common.locale;

import java.util.Locale;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CurrencyUtilTest {

    @Before
    public void setup() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @Test
    public void testGetTradeCurrency() {
        Optional<TradeCurrency> euro = CurrencyUtil.getTradeCurrency("EUR");
        Optional<TradeCurrency> naira = CurrencyUtil.getTradeCurrency("NGN");
        Optional<TradeCurrency> fake = CurrencyUtil.getTradeCurrency("FAK");


        assertTrue(euro.isPresent());
        assertTrue(naira.isPresent());
        assertFalse("Fake currency shouldn't exist",fake.isPresent());
    }
}