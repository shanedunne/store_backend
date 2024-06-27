package utils;

import java.util.Set;
import java.util.HashSet;

public class DisplayTypeUtility {

    private static Set<String> displayTypes = new HashSet<>(){{
        add("AMOLED");
        add("LCD");
        add("LED");
        add("TFT");
    }};

    public static Set<String> getDisplayTypes() {
        return displayTypes;
    }


    public static boolean isValidDisplayType(String type) {
        //must not be case sensitive
        for (String disType:displayTypes){
            if (disType.equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }
}
