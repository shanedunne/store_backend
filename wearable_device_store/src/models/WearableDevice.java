package models;

import java.util.Objects;

import jdk.jshell.execution.Util;
import utils.Utilities;
import utils.ManufacturerNameUtility;

/**
 * This abstract class provides the basis for all wearable devices
 * All wearable devices will inherit from this abstract class and may add further fields and methods
 */
public abstract class WearableDevice {

    // fields
    private String size = "";
    private double price = 20;
    private String manufacturerName = "";
    private String material = "";
    private String modelName = "";
    private String id = "unknown";
    private int batteryLife = 1;
    private String colour = "";


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
     */

    public WearableDevice(String size, double price, String manufacturerName, String material, String modelName, String id, int batteryLife, String colour) {

        // ensures the sie provided
        this.size = Utilities.truncateString(size, 10);
        if (price > 20) {
            this.price = price;
        }
        // check this works in driver
        if (ManufacturerNameUtility.isValidManuName(manufacturerName)) {
            this.manufacturerName = manufacturerName;
        }
        this.material = Utilities.truncateString(material, 20);
        this.modelName = Utilities.truncateString(modelName, 30);
        // must be unique - to be handled in driver
        this.id = Utilities.truncateString(id, 10);
        if (batteryLife > 1) {
            this.batteryLife = batteryLife;
        }

        this.colour = Utilities.truncateString(colour, 12);
    }

    /**
     * Gets the size of the device.
     *
     * @return the size of the device
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size of the device truncated to 10 characters.
     *
     * @param size
     */
    public void setSize(String size) {
        this.size = Utilities.truncateString(size, 10);
    }

    /**
     * Gets the price of the device.
     *
     * @return price of device as a double.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the device once it is greater than 20.
     *
     * @param price the intended price of the device.
     */
    public void setPrice(double price) {
        if (price > 20) {
            this.price = price;
        }
    }

    /**
     * gets the manufacturers name.
     *
     * @return the manufacturers name.
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * Sets the manufacturers name once it passes the validity test.
     *
     * @param manufacturerName manufacturer of the device.
     */
    public void setManufacturerName(String manufacturerName) {
        if (ManufacturerNameUtility.isValidManuName(manufacturerName)) {
            this.manufacturerName = manufacturerName;
        }
    }

    /**
     * Gets the material the device is made of.
     *
     * @return the material the device is made of.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the material the device is made of truncated to 20 characters.
     *
     * @param material the material the device is made of.
     */
    public void setMaterial(String material) {
        this.material = Utilities.truncateString(material, 20);
    }

    /**
     * Gets the model name of the device.
     *
     * @return the model name of the device.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets the model name of the device.
     *
     * @param modelName the model name of the device.
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * Gets the ID of the device.
     *
     * @return The ID of the device.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the device truncated to 10 characters.
     *
     * @param id the ID of the device.
     */
    public void setId(String id) {
        // must be unique - to be handled in driver
        this.id = Utilities.truncateString(id, 10);
    }

    /**
     * Gets the battery life of the device represented in hours.
     *
     * @return The battery life (hours) of the device.
     */
    public int getBatteryLife() {
        return batteryLife;
    }

    /**
     * Sets the battery life (hours) of the device.
     *
     * @param batteryLife the battery life (hours) of the device.
     */
    public void setBatteryLife(int batteryLife) {
        if (batteryLife > 1) {
            this.batteryLife = batteryLife;
        }
    }

    /**
     * Gets the colour of the device.
     *
     * @return the colour of the device.
     */
    public String getColour() {
        return colour;
    }

    /**
     * Sets the colour of the device truncated to 12 characters.
     *
     * @param colour the colour of the device.
     */
    public void setColour(String colour) {
        this.colour = Utilities.truncateString(colour, 12);
    }


    /**
     * Calculates the insurance premium for this device.
     *
     * @return the insurance premium as a double.
     */
    public abstract double getInsurancePremium();

    /**
     * Describes how the device connects to the internet.
     *
     * @return a string describing the internet connection capability.
     */
    public abstract String connectToInternet();

    /**
     * Provides a detailed string of the device features.
     */
    @Override
    public String toString() {
        return "\n\tSize: '" + size + '\'' +
                ",\n\tPrice: " + price +
                ",\n\tName of manufacturer: '" + manufacturerName + '\'' +
                ",\n\tMaterial made of: '" + material + '\'' +
                ",\n\tDevice model: '" + modelName + '\'' +
                ",\n\tDevice ID: '" + id + '\'' +
                ",\n\tDevice battery life (Hours): " + batteryLife +
                ",\n\tDevice colour: '" + colour + '\'';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WearableDevice that = (WearableDevice) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(size, that.size) && Objects.equals(manufacturerName, that.manufacturerName) && Objects.equals(material, that.material) && Objects.equals(modelName, that.modelName) && Objects.equals(id, that.id) && Objects.equals(batteryLife, that.batteryLife) && Objects.equals(colour, that.colour);
    }

}
