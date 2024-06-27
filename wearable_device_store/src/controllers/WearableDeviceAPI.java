package controllers;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import models.SmartBand;
import models.SmartGlasses;
import models.SmartWatch;
import models.WearableDevice;
import utils.ISerializer;
import utils.ManufacturerNameUtility;
import utils.Utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements from ISerializer and implements further methods for use in this program
 */
public class WearableDeviceAPI implements ISerializer {

    // list to store wearable devices
    private List<WearableDevice> wearableDevices;

    // file name for storing of data
    private String fileName = "devices.xml";

    // constructor of the WearableDeviceAPI
    public WearableDeviceAPI() {
        wearableDevices = new ArrayList<>();

    }


    /**
     * This method checks to see if the id passed is already associated with another object
     *
     * @param id string id associated with an object
     * @return false if is not already in use, indicating it can be used. Returns true if is in use already
     */
    public boolean isValidId(String id) {
        for (WearableDevice wearableDevice : wearableDevices) {
            if (wearableDevice.getId().equals(id))
                return false;
        }
        return true;
    }


    //-----------------------------------
    //----------CRUD Methods-------------
    //-----------------------------------


    /**
     * This method adds the wearableDevice provided to the wearableDevices ArrayList
     *
     * @param wearableDevice the WearableDevice to be added to the ArrayList
     * @return true if is added successfully
     */
    public boolean addWearableDevice(WearableDevice wearableDevice) {
        return wearableDevices.add(wearableDevice);
    }


    /**
     * This method takes an index of a device and then removes it if it exists
     *
     * @param indexOfDeviceToDelete index of the device to be removed
     * @return if device exists, returns the object containing that device. If does not exist, returns null
     */
    public WearableDevice deleteWearableDeviceByIndex(int indexOfDeviceToDelete) {
        if (Utilities.isValidIndex(wearableDevices, indexOfDeviceToDelete)) {
            WearableDevice device = wearableDevices.get(indexOfDeviceToDelete);
            wearableDevices.remove(indexOfDeviceToDelete);
            return device;
        }
        return null;
    }

    /**
     * This method takes an id and if it is the id of one of the objects in wearableDevices, it removes it
     *
     * @param idOfDeviceToDelete the id we want to locate in the wearableDevices ArrayList
     * @return the object if successfully found and removed. returns null otherwise
     */
    public WearableDevice deleteWearableDeviceById(String idOfDeviceToDelete) {
        for (WearableDevice wearableDev : wearableDevices) {
            if (wearableDev.getId().equals(idOfDeviceToDelete)) {
                wearableDevices.remove(wearableDev);
                return wearableDev;
            }
        }
        return null;
    }

    /**
     * This method gets an object by its index and fist validates if the index exists
     *
     * @param index the index of the object to get
     * @return the object at specified index. If it doesn't exist, return null
     */
    public WearableDevice getWearableDeviceByIndex(int index) {
        if (Utilities.isValidIndex(wearableDevices, index)) {
            return wearableDevices.get(index);
        } else {
            return null;
        }
    }

    /**
     * This method gets an object by its id
     *
     * @param id the id of the object to get
     * @return the object at specified id. If it doesn't exist, return null
     */
    public WearableDevice getWearableDeviceByID(String id) {
        for (WearableDevice wearableDev : wearableDevices) {
            if (wearableDev.getId().equals(id)) {
                return wearableDev;
            }
        }
        return null;
    }


    /**
     * This method finds the smartwatch by id we want to update, and then sets new details for each field
     *
     * @param idToUpdate     the id of the smart watch we want to update
     * @param updatedDetails the full object of the updated details for the smart watch
     * @return true if the object successfully updated. false if not successfully updated
     */
    public boolean updateSmartWatch(String idToUpdate, SmartWatch updatedDetails) {
        for (WearableDevice wearableDevice : wearableDevices) {
            if (wearableDevice.getId().equals(idToUpdate) && wearableDevice instanceof SmartWatch) {
                SmartWatch smartWatch = (SmartWatch) wearableDevice;

                // Update the details
                smartWatch.setSize(updatedDetails.getSize());
                smartWatch.setPrice(updatedDetails.getPrice());
                smartWatch.setManufacturerName(updatedDetails.getManufacturerName());
                smartWatch.setMaterial(updatedDetails.getMaterial());
                smartWatch.setModelName(updatedDetails.getModelName());
                smartWatch.setBatteryLife(updatedDetails.getBatteryLife());
                smartWatch.setColour(updatedDetails.getColour());
                smartWatch.setDisplayType(updatedDetails.getDisplayType());
                smartWatch.setHasAppStore(updatedDetails.isHasAppStore());

                return true;
            }
        }
        return false;
    }

    /**
     * This method finds the smartband by id we want to update, and then sets new details for each field
     *
     * @param idToUpdate     the id of the smart band we want to update
     * @param updatedDetails the full object of the updated details for the smart band
     * @return true if the object successfully updated. false if not successfully updated
     */
    public boolean updateSmartBand(String idToUpdate, SmartBand updatedDetails) {
        for (WearableDevice wearableDevice : wearableDevices) {
            if (wearableDevice.getId().equals(idToUpdate) && wearableDevice instanceof SmartBand) {
                SmartBand smartBand = (SmartBand) wearableDevice;

                // Update the details
                smartBand.setSize(updatedDetails.getSize());
                smartBand.setPrice(updatedDetails.getPrice());
                smartBand.setManufacturerName(updatedDetails.getManufacturerName());
                smartBand.setMaterial(updatedDetails.getMaterial());
                smartBand.setModelName(updatedDetails.getModelName());
                smartBand.setBatteryLife(updatedDetails.getBatteryLife());
                smartBand.setColour(updatedDetails.getColour());
                smartBand.setWaterResistant(updatedDetails.isWaterResistant());
                smartBand.setHeartRateMonitor(updatedDetails.isHeartRateMonitor());
                smartBand.setWaterResistanceDepth(updatedDetails.getWaterResistanceDepth());

                return true;
            }
        }
        return false;
    }

    /**
     * This method finds the smart glasses by id we want to update, and then sets new details for each field
     *
     * @param idToUpdate     the id of the smart glasses we want to update
     * @param updatedDetails the full object of the updated details for the smart glasses
     * @return true if the object successfully updated. false if not successfully updated
     */
    public boolean updateSmartGlasses(String idToUpdate, SmartGlasses updatedDetails) {
        for (WearableDevice wearableDevice : wearableDevices) {
            if (wearableDevice.getId().equals(idToUpdate) && wearableDevice instanceof SmartGlasses) {
                SmartGlasses smartGlasses = (SmartGlasses) wearableDevice;

                // Update the details
                smartGlasses.setSize(updatedDetails.getSize());
                smartGlasses.setPrice(updatedDetails.getPrice());
                smartGlasses.setManufacturerName(updatedDetails.getManufacturerName());
                smartGlasses.setMaterial(updatedDetails.getMaterial());
                smartGlasses.setModelName(updatedDetails.getModelName());
                smartGlasses.setBatteryLife(updatedDetails.getBatteryLife());
                smartGlasses.setColour(updatedDetails.getColour());
                smartGlasses.setHasUVProtection(updatedDetails.isHasUVProtection());
                smartGlasses.setNumberOfCameras(updatedDetails.getNumberOfCameras());

                return true;
            }
        }
        return false;
    }

    //-----------------------------------
    //----------Report Methods-----------
    //-----------------------------------


    /**
     * This method finds devices regardless of type and creates a string to list all items found
     *
     * @return string containing all items. If no devices found, returns a string indicating this
     */
    public String listAllWearableDeviceDevices() {
        String str = "";

        for (WearableDevice device : wearableDevices) {
            str += wearableDevices.indexOf(device) + ": " + device.toString() + "\n";
        }

        if (str.isEmpty()) {
            return "No WearableDevice Devices";
        } else {
            return str;
        }
    }

    /**
     * This method specifically locates smart band devices stored on the system and returns them in a string
     *
     * @return a string with the information of all smart bands stored in the system, or a string to indicate there are none if that is the case
     */
    public String listAllSmartBands() {
        String str = "";

        for (WearableDevice smartBand : wearableDevices) {
            if (smartBand instanceof SmartBand) {
                str += wearableDevices.indexOf(smartBand) + ": " + smartBand.toString() + "\n";
            }
        }

        if (str.isEmpty()) {
            return "No Smart band devices";
        } else {
            return str;
        }
    }

    /**
     * This method specifically locates smart watch devices stored on the system and returns them in a string
     *
     * @return a string with the information of all smart watch stored in the system, or a string to indicate there are none if that is the case
     */
    public String listAllSmartWatches() {
        String str = "";

        for (WearableDevice smartWatch : wearableDevices) {
            if (smartWatch instanceof SmartWatch) {
                str += wearableDevices.indexOf(smartWatch) + ": " + smartWatch.toString() + "\n";
            }
        }

        if (str.isEmpty()) {
            return "No Smart watch devices";
        } else {
            return str;
        }
    }

    /**
     * This method specifically locates smart glasses devices stored on the system and returns them in a string
     *
     * @return a string with the information of all smart glasses stored in the system, or a string to indicate there are none if that is the case
     */
    public String listAllSmartGlasses() {
        String str = "";

        for (WearableDevice smartGlasses : wearableDevices) {
            if (smartGlasses instanceof SmartGlasses) {
                str += wearableDevices.indexOf(smartGlasses) + ": " + smartGlasses.toString() + "\n";
            }
        }

        if (str.isEmpty()) {
            return "No Smart glasses devices";
        } else {
            return str;
        }
    }

    /**
     * This method returns a string of all devices above a specified price
     *
     * @param price the specified price we want to find products above
     * @return the string of all wearable devices meeting this criteria
     */
    public String listAllWearableDeviceDevicesAbovePrice(double price) {
        String str = "";

        for (WearableDevice device : wearableDevices) {
            if (device.getPrice() > price) {
                str += wearableDevices.indexOf(device) + ": " + device.toString() + "\n";
            }
        }
        if (str.isEmpty()) {
            return "No WearableDevice Devices above " + price;
        } else {
            return str;
        }
    }

    /**
     * This method returns a string of all devices below a specified price
     *
     * @param price the specified price we want to find products below
     * @return the string of all wearable devices meeting this criteria
     */
    public String listAllWearableDeviceDevicesBelowPrice(double price) {
        String str = "";

        for (WearableDevice device : wearableDevices) {
            if (device.getPrice() < price) {
                str += wearableDevices.indexOf(device) + ": " + device.toString() + "\n";
            }
        }
        if (str.isEmpty()) {
            return "No WearableDevice Devices below " + price;
        } else {
            return str;
        }
    }

    //-----------------------------------
    //----------Number Of Methods--------
    //-----------------------------------

    /**
     * This method returns the size of the arraylist containing all wearable devices
     *
     * @return int representing number of devices stored
     */
    public int numberOfWearableDevices() {
        return wearableDevices.size();
    }

    /**
     * This method iterates through all wearable devices and counts smart bands
     *
     * @return the number of smart bands stored in the ArrayList
     */
    public int numberOfSmartBands() {
        int number = 0;
        for (WearableDevice device : wearableDevices) {
            if (device instanceof SmartBand) {
                number++;
            }
        }
        return number;
    }

    /**
     * This method iterates through all wearable devices and counts smart watches
     *
     * @return the number of smart watches stored in the ArrayList
     */
    public int numberOfSmartWatches() {
        int number = 0;
        for (WearableDevice device : wearableDevices) {
            if (device instanceof SmartWatch) {
                number++;
            }
        }
        return number;
    }

    /**
     * This method iterates through all wearable devices and counts smart glasses
     *
     * @return the number of smart glasses stored in the ArrayList
     */
    public int numberOfSmartGlasses() {
        int number = 0;
        for (WearableDevice device : wearableDevices) {
            if (device instanceof SmartGlasses) {
                number++;
            }
        }
        return number;
    }

    /**
     * This method takes a manufacturers name, ensures it is a valid manufacturer name and then counts the amount of devices made by this manufacturer
     *
     * @param manufacturerName the manufacturer of whose devices we want to count. Initially this param is checked for validity
     * @return the number of devices made by the provided manufactuer
     */
    public int numberOfWearableDevicesByChosenManufacturer(String manufacturerName) {
        int number = 0;
        if (ManufacturerNameUtility.isValidManuName(manufacturerName)) {
            for (WearableDevice device : wearableDevices) {
                if (device.getManufacturerName().equals(manufacturerName)) {
                    number++;
                }
            }
        }
        return number;

    }

    //-----------------------------------
    //----------Sort Methods-------------
    //-----------------------------------

    /**
     * This method is used in the sorting methods to provide a way to swap items by given indexes
     *
     * @param wearableDevices the list we want to swap items in
     * @param i               index of the smaller item
     * @param j               index of the bigger item
     */
    private void swapWearableDevice(List<WearableDevice> wearableDevices, int i, int j) {
        WearableDevice smaller = wearableDevices.get(i);
        WearableDevice bigger = wearableDevices.get(j);

        wearableDevices.set(i, bigger);
        wearableDevices.set(j, smaller);

    }


    /**
     * This method sorts price in descending order by using an implementation of the selection sorting algorithm
     * This is intended for use by allowing the user to pass a list to sort as a paramater.
     * Currently this is only used in the methods calculating top 5 devices, where a clone arraylist is madde.
     *
     * @param devices the list that we want to sort in an descending order.
     */
    public void sortByPriceDescending(List<WearableDevice> devices) {
        for (int i = devices.size() - 1; i >= 0; i--) {
            int lowestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (devices.get(j).getPrice() < devices.get(lowestIndex).getPrice()) {
                    lowestIndex = j;
                }
            }
            swapWearableDevice(devices, i, lowestIndex);
        }
    }


    // DIRECT SORTING OF THE MAIN ARRAYLIST

    /**
     * This method sorts price in descending order by using an implementation of the selection sorting algorithm
     */
    public void sortWearableDevicestByPriceDescending() {
        for (int i = wearableDevices.size() - 1; i >= 0; i--) {
            int lowestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (wearableDevices.get(j).getPrice() < wearableDevices.get(lowestIndex).getPrice()) {
                    lowestIndex = j;
                }
            }
            swapWearableDevice(wearableDevices, i, lowestIndex);
        }
    }


    /**
     * This method sorts price in ascending order by using an implementation of the selection sorting algorithm
     */
    public void sortWearableDevicesByPriceAscending() {
        for (int i = wearableDevices.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (wearableDevices.get(j).getPrice() > wearableDevices.get(highestIndex).getPrice()) {
                    highestIndex = j;
                }
            }
            swapWearableDevice(wearableDevices, i, highestIndex);
        }
    }

    /**
     * This method sorts the wearableDevices ArrayList by manufacturer name in descending order by using an implementation of the selection sorting algorithm
     */
    public void sortByDeviceManufacturerDescending() {
        for (int i = wearableDevices.size() - 1; i >= 0; i--) {
            int lowestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (wearableDevices.get(j).getManufacturerName().compareTo(wearableDevices.get(lowestIndex).getManufacturerName()) < 0) {
                    lowestIndex = j;
                }
            }
            swapWearableDevice(wearableDevices, i, lowestIndex);
        }
    }


    /**
     * This method sorts the wearableDevices ArrayList by manufacturer name in ascending order by using an implementation of the selection sorting algorithm
     */
    public void sortByDeviceManufacturerAscending() {
        for (int i = wearableDevices.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (wearableDevices.get(j).getManufacturerName().compareTo(wearableDevices.get(highestIndex).getManufacturerName()) > 0) {
                    highestIndex = j;
                }
            }
            swapWearableDevice(wearableDevices, i, highestIndex);
        }
    }

    /**
     * This method sorts the wearableDevices ArrayList by ID in descending order by using an implementation of the selection sorting algorithm
     */
    public void sortByDeviceIDDescending() {
        for (int i = wearableDevices.size() - 1; i >= 0; i--) {
            int lowestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (wearableDevices.get(j).getId().compareTo(wearableDevices.get(lowestIndex).getId()) < 0) {
                    lowestIndex = j;
                }
            }
            swapWearableDevice(wearableDevices, i, lowestIndex);
        }
    }


    /**
     * This method sorts the wearableDevices ArrayList by ID in ascending order by using an implementation of the selection sorting algorithm
     */
    public void sortByDeviceIDAscending() {
        for (int i = wearableDevices.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (wearableDevices.get(j).getId().compareTo(wearableDevices.get(highestIndex).getId()) > 0) {
                    highestIndex = j;
                }
            }
            swapWearableDevice(wearableDevices, i, highestIndex);
        }
    }

    /**
     * This method sorts the wearableDevices ArrayList by ID in descending order by using an implementation of the selection sorting algorithm
     */
    public void sortByDeviceBatteryLifeDescending() {
        for (int i = wearableDevices.size() - 1; i >= 0; i--) {
            int lowestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (wearableDevices.get(j).getBatteryLife() < wearableDevices.get(lowestIndex).getBatteryLife()) {
                    lowestIndex = j;
                }
            }
            swapWearableDevice(wearableDevices, i, lowestIndex);
        }
    }


    /**
     * This method sorts the wearableDevices ArrayList by ID in ascending order by using an implementation of the selection sorting algorithm
     */
    public void sortByDeviceBatteryLifeAscending() {
        for (int i = wearableDevices.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (wearableDevices.get(j).getBatteryLife() > wearableDevices.get(highestIndex).getBatteryLife()) {
                    highestIndex = j;
                }
            }
            swapWearableDevice(wearableDevices, i, highestIndex);
        }
    }

    //-----------------------------------
    //----------Search Methods-----------
    //-----------------------------------

    /**
     * This method searches for devices with the provided model name and returns them in a string
     *
     * @param model name of model the user is searching
     * @return if matches found, returns details on the device. Returns an unsuccessful string otherwise.
     */
    public String searchByModelName(String model) {
        String matchingDevices = "";
        for (WearableDevice device : wearableDevices) {
            if (device.getModelName().toUpperCase().contains(model.toUpperCase())) {
                matchingDevices += wearableDevices.indexOf(device) + ": " + device + "\n";
            }
        }
        if (matchingDevices.equals("")) {
            return "No products found with this model name";
        } else {
            return matchingDevices;
        }
    }

    /**
     * This method searches for devices with the provided ID and returns them in a string
     *
     * @param id name of id the user is searching
     * @return if matches found, returns details on the device. Returns an unsuccessful string otherwise.
     */
    public String searchById(String id) {
        String matchingDevices = "";
        for (WearableDevice device : wearableDevices) {
            if (device.getId().toUpperCase().contains(id.toUpperCase())) {
                matchingDevices += wearableDevices.indexOf(device) + ": " + device + "\n";
            }
        }
        if (matchingDevices.equals("")) {
            return "No products found with this ID";
        } else {
            return matchingDevices;
        }
    }

    /**
     * This method searches for devices made by the provided manufacturer and returns them in a string
     *
     * @param manufacturerName name of manufacturer the user is searching
     * @return if matches found, returns details on the device. Returns an unsuccessful string otherwise.
     */
    public String searchByManufacturer(String manufacturerName) {
        String matchingDevices = "";
        for (WearableDevice device : wearableDevices) {
            if (device.getManufacturerName().toUpperCase().contains(manufacturerName.toUpperCase())) {
                matchingDevices += wearableDevices.indexOf(device) + ": " + device + "\n";
            }
        }
        if (matchingDevices.equals("")) {
            return "No products found with this manufacturer";
        } else {
            return matchingDevices;
        }
    }


    //-----------------------------------
    //------Top 5 Devices Methods--------
    //-----------------------------------

    /**
     * This method  returns the top 5 most expensive devices
     * It first checks to make sure there is at least some devices stored
     * It then creates a copy of the wearableDevices ArrayList so we can sort without disturbing the records
     * If there are 5 or more devices, it creates a string and returns this string
     * If there are some devices but less than 5, it creates a string of these devices and includes a message to say we do not have the 5 required
     *
     * @return a string indicating no devices if none have been added, info on 5 most expensive devices if 5 or more stored, and most expensive devices if less than 5 are stored
     */
    public String topFiveExpensiveWearableDevices() {

        if (wearableDevices.isEmpty()) {
            return "There is no devices in the store";
        }
        ArrayList<WearableDevice> topFiveList = new ArrayList<>();
        topFiveList.addAll(wearableDevices);

        sortByPriceDescending(topFiveList);

        String topFiveString = "";
        if (topFiveList.size() >= 5) {
            topFiveString += "Here is the top 5 most expensive wearable devices\n";
            for (int i = 0; i <= 4; i++) {
                topFiveString += topFiveList.get(i).toString() + "\n";
            }
            return topFiveString;
        } else {
            topFiveString += "Less than 5 devices are available. Here are the top " + topFiveList.size();
            for (int i = 0; i < topFiveList.size(); i++) {
                topFiveString += topFiveList.get(i).toString() + "\n";
            }
            return topFiveString;
        }
    }

    /**
     * This method intends to return the top 5 most expensive smart watches
     * It first checks to make sure there is at least some smart watches stored
     * It then creates a copy of the wearableDevices ArrayList so we can sort without disturbing the records, only adding smart watches
     * If there are 5 or more smart watches, it creates a string and returns this string
     * If there are some some smart watches but less than 5, it creates a string of these devices and includes a message to say we do not have the 5 required
     *
     * @return a string indicating no devices if no smart watches are stored, info on 5 most expensive smart watches if 5 or more stored, and most expensive smart watches if less than 5 are stored
     */
    public String topFiveExpensiveSmartWatches() {

        ArrayList<WearableDevice> topFiveList = new ArrayList<>();

        for (WearableDevice device : wearableDevices) {
            if (device instanceof SmartWatch) {
                topFiveList.add(device);
            }
        }

        sortByPriceDescending(topFiveList);

        String topFiveString = "";
        if (topFiveList.size() >= 5) {
            topFiveString += "Here is the top 5 most expensive wearable devices\n";
            for (int i = 0; i <= 4; i++) {
                topFiveString += topFiveList.get(i).toString() + "\n";
            }
            return topFiveString;
        } else if (topFiveList.size() > 0 && topFiveList.size() < 5) {
            topFiveString += "Less than 5 smart watches are available. Here are the top " + topFiveList.size();
            for (int i = 0; i < topFiveList.size(); i++) {
                topFiveString += topFiveList.get(i).toString() + "\n";
            }
            return topFiveString;
        } else {
            return "There are no smart watches in the store";
        }
    }

    /**
     * This method intends to return the top 5 most expensive smart bands
     * It first checks to make sure there is at least some smart bands stored
     * It then creates a copy of the wearableDevices ArrayList so we can sort without disturbing the records, only adding smart bands
     * If there are 5 or more smart bands, it creates a string and returns this string
     * If there are some some smart bands but less than 5, it creates a string of these devices and includes a message to say we do not have the 5 required
     *
     * @return a string indicating no devices if no smart bands are stored, info on 5 most expensive smart bands if 5 or more stored, and most expensive smart bands if less than 5 are stored
     */
    public String topFiveExpensiveSmartBands() {

        ArrayList<WearableDevice> topFiveList = new ArrayList<>();

        for (WearableDevice device : wearableDevices) {
            if (device instanceof SmartBand) {
                topFiveList.add(device);
            }
        }

        sortByPriceDescending(topFiveList);

        String topFiveString = "";
        if (topFiveList.size() >= 5) {
            topFiveString += "Here is the top 5 most expensive wearable devices\n";
            for (int i = 0; i <= 4; i++) {
                topFiveString += topFiveList.get(i).toString() + "\n";
            }
            return topFiveString;
        } else if (topFiveList.size() > 0 && topFiveList.size() < 5) {
            topFiveString += "Less than 5 smart bands are available. Here are the top " + topFiveList.size() + "\n";
            for (int i = 0; i < topFiveList.size(); i++) {
                topFiveString += topFiveList.get(i).toString() + "\n";
            }
            return topFiveString;
        } else {
            return "There are no smart bands in the store";
        }
    }

    /**
     * This method intends to return the top 5 most expensive smart glasses
     * It first checks to make sure there is at least some smart glasses stored
     * It then creates a copy of the wearableDevices ArrayList so we can sort without disturbing the records, only adding smart glasses
     * If there are 5 or more smart glasses, it creates a string and returns this string
     * If there are some smart glasses but less than 5, it creates a string of these devices and includes a message to say we do not have the 5 required
     *
     * @return a string indicating no smart glasses if no smart glasses are stored, info on 5 most expensive smart glasses if 5 or more stored, and most expensive smart glasses if less than 5 are stored
     */
    public String topFiveExpensiveSmartGlasses() {

        ArrayList<WearableDevice> topFiveList = new ArrayList<>();

        for (WearableDevice device : wearableDevices) {
            if (device instanceof SmartGlasses) {
                topFiveList.add(device);
            }
        }

        sortByPriceDescending(topFiveList);

        String topFiveString = "";
        if (topFiveList.size() >= 5) {
            topFiveString += "Here is the top 5 most expensive wearable devices\n";
            for (int i = 0; i <= 4; i++) {
                topFiveString += topFiveList.get(i).toString() + "\n";
            }
            return topFiveString;
        } else if (topFiveList.size() > 0 && topFiveList.size() < 5) {
            topFiveString += "Less than 5 smart glasses are available. Here are the top " + topFiveList.size() + "\n";
            for (int i = 0; i < topFiveList.size(); i++) {
                topFiveString += topFiveList.get(i).toString() + "\n";
            }
            return topFiveString;
        } else {
            return "There are no smart glasses in the store";
        }
    }


    //-----------------------------------
    //------Persistence Methods----------
    //-----------------------------------


    /**
     * The load method uses the XStream component to get all the objects in XML file for use in the programme
     *
     * @throws Exception An exception is thrown if an error occurred during the save e.g. drive is full.
     */
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{WearableDevice.class, SmartBand.class, SmartGlasses.class, SmartWatch.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader(fileName));
        wearableDevices = (List<WearableDevice>) in.readObject();
        in.close();
    }

    /**
     * The save method uses the XStream component to write all the objects in the posts ArrayList
     * to the devices.xml file stored on the hard disk.
     *
     * @throws Exception An exception is thrown if an error occurred during the save e.g. drive is full.
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(fileName));
        out.writeObject(wearableDevices);
        out.close();

    }

    /**
     * This method returns the file name where the devices are saved to.
     *
     * @return String containing the file name where devices are saved.
     */
    @Override
    public String fileName() {
        return fileName;
    }


}
