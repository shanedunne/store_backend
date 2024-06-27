package models;

import utils.Utilities;

/**
 * This  class extends the WearableDevice class to represent Smart Glasses.
 * Additional functionality is added here, that is unique to Smart Glasses.
 * Abstract methods declared in WearableDevices are implemented here.
 */
public class SmartGlasses extends WearableDevice {

    // fields
    private boolean hasUVProtection;
    private int numberOfCameras = 0;

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
     * @param hasUVProtection  records if the device provides UV protection to the eyes.
     * @param numberOfCameras  counts the number of cameras on the smart glasses.
     */
    public SmartGlasses(String size, double price, String manufacturerName, String material, String modelName, String id, int batteryLife, String colour, char hasUVProtection, int numberOfCameras) {
        super(size, price, manufacturerName, material, modelName, id, batteryLife, colour);
        this.hasUVProtection = Utilities.YNtoBoolean(hasUVProtection);
        if (Utilities.validRange(numberOfCameras, 0, 2)) {
            this.numberOfCameras = numberOfCameras;
        }
    }

    /**
     * Gets record of if the device provides UV protection to the eyes. Boolean is converted to a Y or N char.
     *
     * @return Y or N indicating if device provides UV protection.
     */
    public char isHasUVProtection() {
        return Utilities.booleanToYN(hasUVProtection);
    }

    /**
     * Sets if device provides UV protection. Char converted to boolean for storing.
     *
     * @param hasUVProtection takes a char Y or N to indicate if provides UV protection.
     */
    public void setHasUVProtection(char hasUVProtection) {
        this.hasUVProtection = Utilities.YNtoBoolean(hasUVProtection);
    }

    /**
     * Gets the number of cameras on the device.
     *
     * @return number of cameras on the device.
     */
    public int getNumberOfCameras() {
        return numberOfCameras;
    }

    /**
     * Sets the number of cameras on the device, in a range of 0 - 2.
     *
     * @param numberOfCameras number of cameras on the device.
     */
    public void setNumberOfCameras(int numberOfCameras) {
        if (Utilities.validRange(numberOfCameras, 0, 2)) {
            this.numberOfCameras = numberOfCameras;
        }
    }

    /**
     * Calculates the insurance premium for this device to two decimal places.
     *
     * @return the insurance premium as a double and to two decimal places.
     */
    public double getInsurancePremium() {
        return Utilities.toTwoDecimalPlaces(getPrice() * 0.09);
    }

    /**
     * Describes how the device connects to the internet.
     *
     * @return a string describing the internet connection capability.
     */
    public String connectToInternet() {
        return "Connects to the internet via phone";
    }

    /**
     * Provides a detailed string of the device features.
     */
    @Override
    public String toString() {
        return super.toString() +
                ",\n\tGlass provides UV protection to eyes: '" + hasUVProtection + '\'' +
                ",\n\tNumber of cameras in frame: '" + numberOfCameras + '\'' +
                ",\n\tInsurance Premium cost: '" + getInsurancePremium() + '\'' +
                ",\n\tInternet connection method: '" + connectToInternet() + '\'';
    }
}
