package utils;

import java.util.Set;
import java.util.HashSet;

/**
 * A class that provides utility directly related to the manufacturers of the devies.
 */
public class ManufacturerNameUtility {

    /**
     * A HashSet that stores the Names of the manufacturers.
     * The HashSet collection was chosen here as to not allow duplicate manufacturers.
     * Some manufacturers are added.
     */
    private static Set<String> manufacturerNames = new HashSet<>() {{
        add("APPLE");
        add("SAMSUNG");
        add("Garmin");
        add("FitBit");
        add("Whoop");
        add("Google");
    }};

    /**
     * Gets the manufacturer names stored in the HashSet.
     *
     * @return set of manufacturer names.
     */
    public static Set<String> getManufacturers() {
        return manufacturerNames;
    }

    /**
     * Checks to ensure the name provided equals a manufacturer stored in the HashSet.
     *
     * @param name manufacturer name to check.
     * @return true if matches a HashSet entry, false if not.
     */
    public static boolean isValidManuName(String name) {
        //must not be case sensitive
        for (String manuName : manufacturerNames) {
            if (manuName.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
