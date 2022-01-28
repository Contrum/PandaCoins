package dev.panda.coins.utilities;

import lombok.experimental.UtilityClass;

import java.util.Locale;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 22-01-2022
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

@UtilityClass
public class JavaUtil {

    public Integer parseInt(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (IllegalArgumentException ex) {
            return null;
        }
    }

    public String localeFormat(int number) {
        return String.format(Locale.US, "%,d", number);
    }
}
