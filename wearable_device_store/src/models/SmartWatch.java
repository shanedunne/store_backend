package models;

import utils.DisplayTypeUtility;
import utils.Utilities;

/**
 * This  class extends the WearableDevice class to represent Smartwatches.
 * Additional functionality is added here, that is unique to Smartwatches.
 * Abstract methods declared in WearableDevices are implemented here.
 */
public class SmartWatch extends WearableDevice {

    // fields
    private String displayType = "LCD";
    private boolean hasAppStore;

    /**
     * Constructs a new WearableDevice with specified attributes, applying validations and default values.
     *
     * @param size             the size of the device truncated to 10 characters.
     * @param price            the price of the device and price must be greater than 20. Default set to 20.
     * @param manufacturerName the name of the manufacturer, ensuring the manufacturer is stored in the manufacturersName HashSet.
     * @param material         the material of the device truncated to 20 characters.
     * @param modelName        the model name of the device truncated to 30 characters.
     * @param id               an ID for the device truncated to 10 characters.
     * @param batteryLife      the battery life of the device in hours, must be more than 1. Default set to 1.
     * @param colour           the color of the device truncated to 12 characters.
     * @param displayType      records the type of display the device has.
     * @param hasAppStore      records if the device has an app store.
     */
    public SmartWatch(String size, double price, String manufacturerName, String material, String modelName, String id, int batteryLife, String colour, String displayType, char hasAppStore) {
        super(size, price, manufacturerName, material, modelName, id, batteryLife, colour);

        if (DisplayTypeUtility.isValidDisplayType(displayType)) {
            this.displayType = displayType;
        }

        this.hasAppStore = Utilities.YNtoBoolean(hasAppStore);
    }

    /**
     * Gets the display type of the device.
     *
     * @return the display type of the device.
     */
    public String getDisplayType() {
        return displayType;
    }

    /**
     * Sets the display type of the device ensuring it is a valid display type.
     *
     * @param displayType valid display type for device.
     */
    public void setDisplayType(String displayType) {
        if (DisplayTypeUtility.isValidDisplayType(displayType)) {
            this.displayType = displayType;
        }
    }

    /**
     * Gets record of if the device has an app store. Boolean is converted to a Y or N char.
     *
     * @return Y or N indicating if device has an app store.
     */
    public char isHasAppStore() {
        return Utilities.booleanToYN(hasAppStore);
    }

    /**
     * Sets if device has an app store. Char converted to boolean for storing.
     *
     * @param hasAppStore takes a char Y or N to indicate if device has an app store.
     */
    public void setHasAppStore(char hasAppStore) {
        this.hasAppStore = Utilities.YNtoBoolean(hasAppStore);
    }

    /**
     * Calculates the insurance premium for this device to two decimal places.
     *
     * @return the insurance premium as a double and to two decimal places.
     */
    public double getInsurancePremium() {
        return Utilities.toTwoDecimalPlaces((getPrice() * 0.06));
    }

    /**
     * Describes how the device connects to the internet.
     *
     * @return a string describing the internet connection capability.
     */
    public String connectToInternet() {
        return "Connects to the internet via bluetooth";
    }

    /**
     * Provides a detailed string of the device features.
     */
    @Override
    public String toString() {
        return super.toString() +
                ",\n\tDisplay type: '" + displayType + '\'' +
                ",\n\tHas app store: '" + hasAppStore + '\'' +
                ",\n\tInsurance Premium cost: '" + getInsurancePremium() + '\'' +
                ",\n\tInternet connection method: '" + connectToInternet() + '\'';
    }

}
