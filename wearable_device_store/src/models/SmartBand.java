package models;

import jdk.jshell.execution.Util;
import utils.Utilities;

/**
 * This  class extends the WearableDevice class to represent Smart Bands.
 * Additional functionality is added here, that is unique to Smart Bands.
 * Abstract methods declared in WearableDevices are implemented here.
 */
public class SmartBand extends WearableDevice {

    // fields
    private boolean heartRateMonitor = false;
    private boolean isWaterResistant = false;
    private int waterResistanceDepth = 0;


    /**
     * Constructs a new WearableDevice with specified attributes, applying validations and default values.
     *
     * @param size                 the size of the device truncated to 10 characters.
     * @param price                the price of the device and price must be greater than 20. Default set to 20.
     * @param manufacturerName     the name of the manufacturer, ensuring the manufacturer is stored in the manufacturersName HashSet.
     * @param material             the material of the device truncated to 20 characters.
     * @param modelName            the model name of the device truncated to 30 characters.
     * @param id                   an ID for the device truncated to 10 characters.
     * @param batteryLife          the battery life of the device in hours, must be more than 1. Default set to 1.
     * @param colour               the color of the device truncated to 12 characters.
     * @param isWaterResistant     records if the device is water-resistant.
     * @param heartRateMonitor     records if the device has a heart rate monitor.
     * @param waterResistanceDepth records the depth to which the device is water-resistant.
     */
    public SmartBand(String size, double price, String manufacturerName, String material, String modelName, String id, int batteryLife, String colour, char isWaterResistant, char heartRateMonitor, int waterResistanceDepth) {
        super(size, price, manufacturerName, material, modelName, id, batteryLife, colour);
        this.heartRateMonitor = Utilities.YNtoBoolean(heartRateMonitor);

        this.isWaterResistant = Utilities.YNtoBoolean(isWaterResistant);

        if (Utilities.YNtoBoolean(isWaterResistant)) {
            // range must be 1-20 metres, if not set default as 1 as isWaterResistant has already confirmed it has some water resistance
            if (Utilities.validRange(waterResistanceDepth, 1, 20)) {
                this.waterResistanceDepth = waterResistanceDepth;
            } else {
                this.waterResistanceDepth = 1;
            }
        }
    }

    /**
     * Gets record of if device has a heart rate monitor. Boolean is converted to a Y or N char.
     *
     * @return Y or N indicating if device has a heart rate monitor.
     */
    public char isHeartRateMonitor() {
        return Utilities.booleanToYN(heartRateMonitor);
    }

    /**
     * Sets if device has a heart rate monitor. Char converted to boolean for storing.
     *
     * @param heartRateMonitor takes a char Y or N to indicate if has a heart rate monitor.
     */
    public void setHeartRateMonitor(char heartRateMonitor) {
        this.heartRateMonitor = Utilities.YNtoBoolean(heartRateMonitor);
    }

    /**
     * Gets record of if device is water-resistant. Boolean is converted to a Y or N char.
     *
     * @return Y or N indicating if device is water-resistant.
     */
    public char isWaterResistant() {
        return Utilities.booleanToYN(isWaterResistant);
    }

    /**
     * Sets if device is water-resistant. Char converted to boolean for storing.
     *
     * @param waterResistant takes a char Y or N to indicate if is water-resistant.
     */
    public void setWaterResistant(char waterResistant) {
        this.isWaterResistant = Utilities.YNtoBoolean(waterResistant);
    }

    /**
     * Gets water resistance depth (metres).
     *
     * @return water resistance depth in metres.
     */
    public int getWaterResistanceDepth() {
        return waterResistanceDepth;
    }

    /**
     * Sets the water resistance depth if the device is confirmed to be water-resistant in field isWaterResistant
     *
     * @param waterResistanceDepth Depth of water resistance in metres.
     */
    public void setWaterResistanceDepth(int waterResistanceDepth) {
        if (Utilities.YNtoBoolean(isWaterResistant())) {
            if (Utilities.validRange(waterResistanceDepth, 1, 20)) {
                this.waterResistanceDepth = waterResistanceDepth;
            }
        }
    }

    /**
     * Calculates the insurance premium for this device to two decimal places.
     *
     * @return the insurance premium as a double and to two decimal places.
     */
    @Override
    public double getInsurancePremium() {
        return Utilities.toTwoDecimalPlaces(getPrice() * 0.07);
    }

    /**
     * Describes how the device connects to the internet.
     *
     * @return a string describing the internet connection capability.
     */
    @Override
    public String connectToInternet() {
        return "Connects to the internet via Companion App";
    }

    /**
     * Provides a detailed string of the device features.
     */
    @Override
    public String toString() {
        return super.toString() +
                ",\n\tHas heart rate monitor: '" + heartRateMonitor + '\'' +
                ",\n\tIs water resistant: " + isWaterResistant + '\'' +
                ",\n\tWater resistance depth (metres): " + waterResistanceDepth + '\'' +
                ",\n\tInsurance Premium cost: '" + getInsurancePremium() + '\'' +
                ",\n\tInternet connection method: '" + connectToInternet() + '\'';
    }
}

