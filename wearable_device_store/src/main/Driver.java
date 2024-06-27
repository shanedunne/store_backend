package main;

import controllers.WearableDeviceAPI;


import models.SmartBand;
import models.SmartGlasses;
import models.SmartWatch;
import models.WearableDevice;
import utils.DisplayTypeUtility;
import utils.ManufacturerNameUtility;
import utils.ScannerInput;
import utils.Utilities;

/**
 * This class is the Driver class which runs and controls the interactions with the programme.
 */
public class Driver {


    // creates an instance of the WearableDevicesAPI in the Driver class
    private WearableDeviceAPI api = new WearableDeviceAPI();

    public static void main(String[] args) throws Exception {

        new Driver().start();
    }

    public void start() {

        loadAllDevices();
        runMainMenu();
    }

    /**
     * Creates the main menu
     *
     * @return main menu in the console allowing an input to select from the options listed
     */
    private int mainMenu() {

        //TODO write menu that user will see
        return ScannerInput.readNextInt("""
                -------------------------
                -------------------------
                Wearable Device Menu
                -------------------------
                -------------------------
                1) Create, Read, Update & Delete Menu
                2) Device Reports
                -------------------------
                3) Search For Device
                4) Sort Devices
                -------------------------
                5) Save All Devices
                6) Load All Devices
                -------------------------
                                
                                
                """);
    }


    /**
     * Handles selections made from the mainMenu() method via switch method.
     */
    private void runMainMenu() {
        int option = mainMenu();

        while (option != 0) {
            switch (option) {
                case 1 -> CRUDMenu();
                case 2 -> deviceReportsMenu();
                case 3 -> searchDevicesMenu();
                case 4 -> sortDevicesMenu();
                case 5 -> saveAllDevices();
                case 6 -> loadAllDevices();
                case 0 -> exitApp();
                default -> System.out.println("Invalid option entered: " + option);
            }
            //pause the program so that the user can read what we just printed to the terminal window
            ScannerInput.readNextLine("\nPress enter key to continue...");

            option = mainMenu();
        }
        exitApp();
    }

    /**
     * Allows for the exiting of the programme when it is presented as an option in the menus
     */
    private void exitApp() {

        System.out.println("Exiting....");
        System.exit(0);
    }


    //-----------------------------------
    //--------- Main Menu Option 1 ------
    //  Create, Read, Update & Delete Menu
    //-----------------------------------

    /**
     * Handles elements of the CRUD menu. Initially presents a menu with the ability to select an option.
     * Using a switch method, the selection method is then called.
     */
    private void CRUDMenu() {
        int option = ScannerInput.readNextInt("""
                -----------------------------------
                -----------------------------------
                Create, Read, Update & Delete Menu
                -----------------------------------
                -----------------------------------
                1) Add a Wearable Device
                2) Get Wearable Devices
                3) Update Wearable Device Information
                4) Delete a Wearable Device
                -----------------------------------
                                
                                
                """);

        switch (option) {
            case 1 -> addWearableDevice();
            case 2 -> getWearableDevices();
            case 3 -> updateWearableDevices();
            case 4 -> deleteAWearableDevice();
            case 0 -> exitApp();
            default -> System.out.println("Invalid option entered: " + option);
        }
    }

    /**
     * This method initially activates the Add Wearable Device Menu
     * The user selects a device type and then fills in the required information
     * The device is then added to the ArrayList
     */
    private void addWearableDevice() {

        boolean isAdded = false;

        int option = ScannerInput.readNextInt("""
                -------------------------
                -------------------------
                Add a Wearable Device
                -------------------------
                -------------------------
                1) Add a Smart Band
                2) Add a Smart Watch
                3) Add Smart Glasses
                0) Exit
                -------------------------
                                
                                
                """);

        switch (option) {
            case 1 -> {
                String size = ScannerInput.readNextLine("Enter the smart band size:   ");
                double price = ScannerInput.readNextDouble("Enter the smart band price:   ");
                String manufacturerName = isValidManufacturer();
                String material = ScannerInput.readNextLine("Enter the smart band material:   ");
                String modelName = ScannerInput.readNextLine("Enter the smart band model name:   ");
                String id = ScannerInput.readNextLine("Enter the smart band id:   ");
                int batteryLife = ScannerInput.readNextInt("Enter the battery life of the smart band in hours:   ");
                String colour = ScannerInput.readNextLine("Enter the smart band colour:   ");
                char isWaterResistant = ScannerInput.readNextChar("Is the smart band water resistant? (y or n):   ");
                int waterResistanceDepth;
                if (Utilities.YNtoBoolean(isWaterResistant)) {
                    waterResistanceDepth = ScannerInput.readNextInt("Enter water resistance depth in metres:   ");
                } else {
                    waterResistanceDepth = 0;
                }
                char heartRateMonitor = ScannerInput.readNextChar("Does the smart band have a hear rate monitor? (y or n):   ");

                isAdded = api.addWearableDevice(new SmartBand(size, price, manufacturerName, material, modelName, id, batteryLife, colour, isWaterResistant, heartRateMonitor, waterResistanceDepth));
            }
            case 2 -> {
                String size = ScannerInput.readNextLine("Enter the smart watch size:   ");
                double price = ScannerInput.readNextDouble("Enter the smart watch price:   ");
                String manufacturerName = isValidManufacturer();
                String material = ScannerInput.readNextLine("Enter the smart watch material:   ");
                String modelName = ScannerInput.readNextLine("Enter the smart watch model name:   ");
                String id = ScannerInput.readNextLine("Enter the smart watch id:   ");
                int batteryLife = ScannerInput.readNextInt("Enter the battery life of the smart watch in hours:   ");
                String colour = ScannerInput.readNextLine("Enter the smart watch colour:   ");
                String displayType = isValidDisplayType();
                char hasAppStore = ScannerInput.readNextChar("Does the smart watch have an app store? (y or n): ");


                isAdded = api.addWearableDevice(new SmartWatch(size, price, manufacturerName, material, modelName, id, batteryLife, colour, displayType, hasAppStore));
            }

            case 3 -> {
                String size = ScannerInput.readNextLine("Enter the smart glasses size:   ");
                double price = ScannerInput.readNextDouble("Enter the smart glasses price:   ");
                String manufacturerName = isValidManufacturer();
                String material = ScannerInput.readNextLine("Enter the smart glasses material:   ");
                String modelName = ScannerInput.readNextLine("Enter the smart glasses model name:   ");
                String id = ScannerInput.readNextLine("Enter the smart glasses id:   ");
                int batteryLife = ScannerInput.readNextInt("Enter the battery life of the smart glasses in hours:   ");
                String colour = ScannerInput.readNextLine("Enter the smart glasses colour:   ");
                char hasUVProtection = ScannerInput.readNextChar("Do the glasses provide UV protection? (y or n):   ");
                int numberOfCameras = ScannerInput.readNextInt("How many cameras do the smart glasses have:   ");


                isAdded = api.addWearableDevice(new SmartGlasses(size, price, manufacturerName, material, modelName, id, batteryLife, colour, hasUVProtection, numberOfCameras));
            }
            case 4 -> exitApp();
            default -> System.out.println("Invalid option entered: " + option);
        }

        if (isAdded) {
            System.out.println("Wearable Device added successfully");
        } else {
            System.out.println("No post added");
        }
    }

    private void getWearableDevices() {
        int option = ScannerInput.readNextInt("""
                ---------------------------------
                ---------------------------------
                Get Wearable Device
                ---------------------------------
                ---------------------------------
                1) Get Wearable Device by Index
                2) Get Wearable Device by ID
                0) Exit
                ---------------------------------
                                    
                                    
                """);

        switch (option) {
            case 1 -> {
                int index = ScannerInput.readNextInt("enter index of device to get:   ");
                System.out.println(api.getWearableDeviceByIndex(index));
            }
            case 2 -> {
                String id = ScannerInput.readNextLine("Enter id of device to get:   ");
                System.out.println(api.getWearableDeviceByID(id));
            }
            case 0 -> exitApp();
            default -> System.out.println("Invalid option entered:   " + option);
        }
    }


    /**
     * This method initially activates the Update Wearable Device Menu
     * The user selects a device type and then fills in the required information
     * The device is then updated in the ArrayList
     */
    private void updateWearableDevices() {
        if (api.numberOfWearableDevices() > 0) {
            boolean isUpdated = false;

            int option = ScannerInput.readNextInt("""
                    -------------------------
                    -------------------------
                    Update Wearable Device
                    -------------------------
                    -------------------------
                    1) Update Smart Band
                    2) Update Smart Watch
                    3) Update Smart Glasses
                    0) Exit
                    -------------------------
                                        
                                        
                    """);

            switch (option) {
                case 1 -> {
                    showAllSmartBands();
                    if (api.numberOfSmartBands() > 0) {
                        String idToUpdate = ScannerInput.readNextLine("Ender the id of the smart band you want to update:  ");
                        String size = ScannerInput.readNextLine("Enter the smart band size:   ");
                        double price = ScannerInput.readNextDouble("Enter the smart band price:   ");
                        String manufacturerName = isValidManufacturer();
                        String material = ScannerInput.readNextLine("Enter the smart band material:   ");
                        String modelName = ScannerInput.readNextLine("Enter the smart band model name:   ");
                        String id = ScannerInput.readNextLine("Enter the smart band id:   ");
                        int batteryLife = ScannerInput.readNextInt("Enter the battery life of the smart band in hours:   ");
                        String colour = ScannerInput.readNextLine("Enter the smart band colour:   ");
                        char isWaterResistant = ScannerInput.readNextChar("Is the smart band water resistant? (y or n):   ");
                        int waterResistanceDepth;
                        if (Utilities.YNtoBoolean(isWaterResistant)) {
                            waterResistanceDepth = ScannerInput.readNextInt("Enter water resistance depth in metres:   ");
                        } else {
                            waterResistanceDepth = 0;
                        }
                        char heartRateMonitor = ScannerInput.readNextChar("Does the smart band have a hear rate monitor? (y or n):   ");

                        SmartBand updatedSmartBand = new SmartBand(size, price, manufacturerName, material, modelName, id, batteryLife, colour, isWaterResistant, heartRateMonitor, waterResistanceDepth);
                        isUpdated = api.updateSmartBand(idToUpdate, updatedSmartBand);
                    }

                }
                case 2 -> {
                    showAllSmartWatches();
                    if (api.numberOfSmartWatches() > 0) {
                        String idToUpdate = ScannerInput.readNextLine("Ender the id of the smart watch you want to update:  ");
                        String size = ScannerInput.readNextLine("Enter the smart watch size:   ");
                        double price = ScannerInput.readNextDouble("Enter the smart watch price:   ");
                        String manufacturerName = isValidManufacturer();
                        String material = ScannerInput.readNextLine("Enter the smart watch material:   ");
                        String modelName = ScannerInput.readNextLine("Enter the smart watch model name:   ");
                        String id = ScannerInput.readNextLine("Enter the smart watch id:   ");
                        int batteryLife = ScannerInput.readNextInt("Enter the battery life of the smart watch in hours:   ");
                        String colour = ScannerInput.readNextLine("Enter the smart watch colour:   ");
                        String displayType = isValidDisplayType();
                        char hasAppStore = ScannerInput.readNextChar("Does the smart watch have an app store? (y or n): ");

                        SmartWatch updatedSmartWatch = new SmartWatch(size, price, manufacturerName, material, modelName, id, batteryLife, colour, displayType, hasAppStore);
                        isUpdated = api.updateSmartWatch(idToUpdate, updatedSmartWatch);
                    }
                }

                case 3 -> {
                    showAllSmartGlasses();
                    if (api.numberOfSmartGlasses() > 0) {
                        String idToUpdate = ScannerInput.readNextLine("Ender the id of the smart glasses you want to update:  ");
                        String size = ScannerInput.readNextLine("Enter the smart glasses size:   ");
                        double price = ScannerInput.readNextDouble("Enter the smart glasses price:   ");
                        String manufacturerName = isValidManufacturer();
                        String material = ScannerInput.readNextLine("Enter the smart glasses material:   ");
                        String modelName = ScannerInput.readNextLine("Enter the smart glasses model name:   ");
                        String id = ScannerInput.readNextLine("Enter the smart glasses id:   ");
                        int batteryLife = ScannerInput.readNextInt("Enter the battery life of the smart glasses in hours:   ");
                        String colour = ScannerInput.readNextLine("Enter the smart glasses colour:   ");
                        char hasUVProtection = ScannerInput.readNextChar("Do the glasses provide UV protection? (y or n):   ");
                        int numberOfCameras = ScannerInput.readNextInt("How many cameras do the smart glasses have:   ");

                        SmartGlasses updatedSmartGlasses = new SmartGlasses(size, price, manufacturerName, material, modelName, id, batteryLife, colour, hasUVProtection, numberOfCameras);
                        isUpdated = api.updateSmartGlasses(idToUpdate, updatedSmartGlasses);
                    }
                }
                case 4 -> exitApp();
                default -> System.out.println("Invalid option entered: " + option);
            }
            if (isUpdated) {
                System.out.println("Post Updated Successfully");
            } else {
                System.out.println("No Post Updated");
            }
        } else {
            System.out.println("No devices to update");
        }
    }

    /**
     * This method initially activates the Delete a Wearable Device Menu
     * The user selects either Delete by ID or Delete by Index
     * The selected method is then called.
     */
    private void deleteAWearableDevice() {
        if (api.numberOfWearableDevices() > 0) {
            int option = ScannerInput.readNextInt("""
                    -----------------------------------
                    -----------------------------------
                    Delete a Wearable Device
                    -----------------------------------
                    -----------------------------------
                    1) Delete a Device by ID
                    2) Delete a Device by Index
                    -----------------------------------
                                        
                                        
                    """);
            switch (option) {
                case 1 -> deleteById();
                case 2 -> deleteByIndex();
                case 0 -> exitApp();
                default -> System.out.println("Invalid option entered:   " + option);
            }
        } else {
            System.out.println("No devices added to delete");
        }
    }

    /**
     * This method initially activates the Delete by ID menu
     * The user selects a device type and then  sees a list of these devices
     * The user then enters the ID of the devices to be deleted and it is removed from the system
     */
    private void deleteById() {
        int option = ScannerInput.readNextInt("""
                -----------------------------
                -----------------------------
                Delete by Id
                -----------------------------
                -----------------------------
                1) Delete a Smart Band
                2) Delete a Smart Watch
                3) Delete a Smart Glasses
                0) Exit
                -----------------------------
                                
                                
                """);

        switch (option) {
            case 1 -> {
                if (api.numberOfSmartBands() > 0) {
                    showAllSmartBands();
                    String idToDelete = ScannerInput.readNextLine("Enter the ID of the smart band to delete:   ");
                    WearableDevice smartBandToDelete = api.deleteWearableDeviceById(idToDelete);
                    if (smartBandToDelete != null) {
                        System.out.println("Successfully deleted: " + smartBandToDelete);
                    } else {
                        System.out.println("Delete not successful");
                    }

                } else {
                    System.out.println("No smart bands to delete");
                }
            }
            case 2 -> {
                if (api.numberOfSmartWatches() > 0) {
                    showAllSmartWatches();
                    String idToDelete = ScannerInput.readNextLine("Enter the ID of the smart watch to delete:   ");
                    WearableDevice smartWatchToDelete = api.deleteWearableDeviceById(idToDelete);
                    if (smartWatchToDelete != null) {
                        System.out.println("Successfully deleted: " + smartWatchToDelete);
                    } else {
                        System.out.println("Delete not successful");
                    }

                } else {
                    System.out.println("No smart watches to delete");
                }
            }
            case 3 -> {
                if (api.numberOfSmartGlasses() > 0) {
                    showAllSmartGlasses();
                    String idToDelete = ScannerInput.readNextLine("Enter the ID of the smart glasses to delete:   ");
                    WearableDevice smartGlassesToDelete = api.deleteWearableDeviceById(idToDelete);
                    if (smartGlassesToDelete != null) {
                        System.out.println("Successfully deleted: " + smartGlassesToDelete);
                    } else {
                        System.out.println("Delete not successful");
                    }

                } else {
                    System.out.println("No smart bands to delete");
                }
            }
        }
    }

    /**
     * This method initially activates the Delete by Index menu
     * The user selects a device type and then  sees a list of these devices
     * The user then enters the Index of the devices to be deleted and it is removed from the system
     */
    private void deleteByIndex() {
        int option = ScannerInput.readNextInt("""
                -----------------------------
                -----------------------------
                Delete by Index
                -----------------------------
                -----------------------------
                1) Delete a Smart Band
                2) Delete a Smart Watch
                3) Delete a Smart Glasses
                0) Exit
                -----------------------------
                                
                                
                """);

        switch (option) {
            case 1 -> {
                if (api.numberOfSmartBands() > 0) {
                    showAllSmartBands();
                    int indexToDelete = ScannerInput.readNextInt("Enter the index of the smart band to delete:   ");
                    WearableDevice smartBandToDelete = api.deleteWearableDeviceByIndex(indexToDelete);
                    if (smartBandToDelete != null) {
                        System.out.println("Successfully deleted: " + smartBandToDelete);
                    } else {
                        System.out.println("Delete not successful");
                    }

                } else {
                    System.out.println("No smart bands to delete");
                }
            }
            case 2 -> {
                if (api.numberOfSmartWatches() > 0) {
                    showAllSmartWatches();
                    int indexToDelete = ScannerInput.readNextInt("Enter the index of the smart band to delete:   ");
                    WearableDevice smartWatchToDelete = api.deleteWearableDeviceByIndex(indexToDelete);
                    if (smartWatchToDelete != null) {
                        System.out.println("Successfully deleted: " + smartWatchToDelete);
                    } else {
                        System.out.println("Delete not successful");
                    }

                } else {
                    System.out.println("No smart watches to delete");
                }
            }
            case 3 -> {
                if (api.numberOfSmartGlasses() > 0) {
                    showAllSmartGlasses();
                    int indexToDelete = ScannerInput.readNextInt("Enter the index of the smart band to delete:   ");
                    WearableDevice smartGlassesToDelete = api.deleteWearableDeviceByIndex(indexToDelete);
                    if (smartGlassesToDelete != null) {
                        System.out.println("Successfully deleted: " + smartGlassesToDelete);
                    } else {
                        System.out.println("Delete not successful");
                    }

                } else {
                    System.out.println("No smart bands to delete");
                }
            }
        }
    }

    //-----------------------------------
    //--------- Main Menu Option 2 ------
    //---------- Device Reports ---------
    //-----------------------------------

    /**
     * This method initially activates the Device Reports menu
     * The user selects an option from the list and the corresponding method is called
     */
    private void deviceReportsMenu() {
        if (api.numberOfWearableDevices() > 0) {
            int option = ScannerInput.readNextInt("""
                    --------------------------------------
                    --------------------------------------
                    Device Reports Menu
                    --------------------------------------
                    --------------------------------------
                    1) List Wearable Devices
                    2) Number of Devices
                    3) Number of Devices by Manufacturer
                    4) List Wearable Devices Above a Price
                    5) List Wearable Devices Below a Price
                    6) List Of Five Most Expensive Devices
                    --------------------------------------
                                        
                                        
                    """);
            switch (option) {
                case 1 -> listWearableDevices();
                case 2 -> numberOfDevices();
                case 3 -> numberOfDevicesByManufacturer();
                case 4 -> listWearableDevicesAboveAPrice();
                case 5 -> listWearableDevicesBelowAPrice();
                case 6 -> listOfFiveMostExpensiveDevicesMenu();
            }
        } else {
            System.out.println("No devices to generate reports");
        }
    }

    /**
     * This method activates the List Wearable Devices Menu
     * The user chooses which list of devices they want to see and the method calls the corresponding method
     */
    private void listWearableDevices() {
        int option = ScannerInput.readNextInt("""
                -------------------------
                -------------------------
                List Wearable Devices
                -------------------------
                -------------------------
                1) List All Wearable Devices
                2) List All Smart Bands
                3) List All Smart Watches
                4) List All Smart Glasses
                0) Exit
                -------------------------
                                
                                
                """);

        switch (option) {
            case 1 -> showAllWearableDevices();
            case 2 -> showAllSmartBands();
            case 3 -> showAllSmartWatches();
            case 4 -> showAllSmartGlasses();
            case 0 -> exitApp();
        }
    }

    // prints all wearable devices stored in the wearableDevices ArrayList
    private void showAllWearableDevices() {
        System.out.println("Below is a list of all wearable devices");
        System.out.println(api.listAllWearableDeviceDevices());
    }

    // prints all smart bands stored in the wearableDevices ArrayList
    private void showAllSmartBands() {
        System.out.println("Below is a list of all smart bands");
        System.out.println(api.listAllSmartBands());
    }

    // prints all smart watches stored in the wearableDevices ArrayList
    private void showAllSmartWatches() {
        System.out.println("Below is a list of all smart watches");
        System.out.println(api.listAllSmartWatches());
    }

    // prints all smart glasses stored in the wearableDevices ArrayList
    private void showAllSmartGlasses() {
        System.out.println("Below is a list of all smart glasses");
        System.out.println(api.listAllSmartGlasses());
    }

    /**
     * This method initially activates the Number of Devices menu
     * The user selects a device type and then sees a return indicating how many of this device type is in the system
     */
    private void numberOfDevices() {
        int option = ScannerInput.readNextInt("""
                ----------------------------
                ----------------------------
                Number of Devices Menu
                ----------------------------
                ----------------------------
                1) Number of Wearable Devices
                2) Number of Smart Bands
                3) Number of Smart Watches
                4) Number of Smart Glasses
                0) Exit
                ----------------------------
                                
                                
                """);
        switch (option) {
            case 1 -> {
                System.out.println("The number of Wearable Devices currently stored on the system is " + api.numberOfWearableDevices());
            }
            case 2 -> {
                System.out.println("The number of Smart Bands currently stored on the system is " + api.numberOfSmartBands());
            }
            case 3 -> {
                System.out.println("The number of Smart Watches currently stored on the system is " + api.numberOfSmartWatches());
            }
            case 4 -> {
                System.out.println("The number of Smart Glasses currently stored on the system is " + api.numberOfSmartGlasses());
            }
            case 0 -> exitApp();
            default -> System.out.println("Invalid option entered: " + option);
        }
    }

    /**
     * This method requests a manufacturer name and then returns an indication on how many devices by this manufacturer exist in the system
     */
    private void numberOfDevicesByManufacturer() {
        String inputManufacturer = ScannerInput.readNextLine("Enter the manufacturer name:   ");
        if (ManufacturerNameUtility.isValidManuName(inputManufacturer)) {
            int count = api.numberOfWearableDevicesByChosenManufacturer(inputManufacturer);
            System.out.println("Number of devices by " + inputManufacturer + ": " + count);
        } else {
            System.out.println("Invalid manufacturer name. Please try again.");
        }
    }

    /**
     * This method requests a price and then returns an indication on how many devices above this price exist in the system
     */
    private void listWearableDevicesAboveAPrice() {
        double price = ScannerInput.readNextDouble("Enter a price you wish to see items above:   ");
        System.out.println("Items above " + price + ": \n");
        System.out.println(api.listAllWearableDeviceDevicesAbovePrice(price));
    }

    /**
     * This method requests a price and then returns an indication on how many devices below this price exist in the system
     */
    private void listWearableDevicesBelowAPrice() {
        double price = ScannerInput.readNextDouble("Enter a price you wish to see items below:   ");
        System.out.println("Items below " + price + ": \n");
        System.out.println(api.listAllWearableDeviceDevicesBelowPrice(price));
    }

    /**
     * This method initially activates the Five Most Expensive Device Reports menu
     * The user selects an option from the list and the corresponding method is called
     * Report information will then be displayed
     */
    private void listOfFiveMostExpensiveDevicesMenu() {
        int option = ScannerInput.readNextInt("""
                ---------------------------------------
                ---------------------------------------
                Five Most Expensive Devices
                ---------------------------------------
                ---------------------------------------
                1) Five Most Expensive Wearable Devices
                2) Five Most Expensive Smart Bands
                3) Five Most Expensive Smart Watches
                4) Five Most Expensive Smart Glasses
                0) Exit
                ---------------------------------------
                                
                                
                """);

        switch (option) {
            case 1 -> {
                System.out.println(api.topFiveExpensiveWearableDevices());
            }
            case 2 -> {
                System.out.println(api.topFiveExpensiveSmartBands());
            }
            case 3 -> {
                System.out.println(api.topFiveExpensiveSmartWatches());
            }
            case 4 -> {
                System.out.println(api.topFiveExpensiveSmartGlasses());
            }
            case 0 -> exitApp();
            default -> System.out.println("Invalid option entered: " + option);
        }
    }

    //-----------------------------------
    //--------- Main Menu Option 3 ------
    //----------Search for Devices-------
    //-----------------------------------

    /**
     * This method initially activates the Search menu
     * The user selects an option from the list and the corresponding method is called
     * The user will then be required to input some information based on their selection
     * The item required will be returned if it is in existence.
     */
    private void searchDevicesMenu() {
        if (api.numberOfWearableDevices() > 0) {
            int option = ScannerInput.readNextInt("""
                -------------------------------
                -------------------------------
                Search Menu
                -------------------------------
                -------------------------------
                1) Search by Model Name
                2) Search by ID
                3) Search by Manufacturer Name
                -------------------------------
                                
                                
                """);

            switch (option) {
                case 1 -> {
                    String modelName = ScannerInput.readNextLine("Enter the name of the model you are searching for:   ");
                    System.out.println(api.searchByModelName(modelName));
                }
                case 2 -> {
                    String id = ScannerInput.readNextLine("Enter the ID you are searching for:   ");
                    System.out.println(api.searchById(id));
                }
                case 3 -> {
                    String manufacturerName = ScannerInput.readNextLine("Enter the name of the manufacturer you are searching for:   ");
                    System.out.println(api.searchByManufacturer(manufacturerName));
                }
            }
        } else {
            System.out.println("No devices stored to search");
        }

    }


    //-----------------------------------
    //--------- Main Menu Option 4 ------
    //------------Sort Devices-----------
    //-----------------------------------


    /**
     * This method initially activates the Sort Devices menu
     * The user selects an option from the list and the corresponding method is called
     * The devices will now be sorted as per the users preference.
     */
    private void sortDevicesMenu() {
        int option = ScannerInput.readNextInt("""
                ---------------------------------------
                ---------------------------------------
                Sort Devices menu
                ---------------------------------------
                ---------------------------------------
                1) Sort by Price Ascending
                2) Sort by Price Descending
                3) Sort by Manufacturer Ascending
                4) Sort by Manufacturer Descending
                5) Sort by ID Ascending
                6) Sort by ID Descending
                7) Sort by Battery Life Ascending
                8) Sort by Battery Life Descending
                0) Exit
                ---------------------------------------
                                
                                
                """);

        switch (option) {
            case 1 -> {
                api.sortWearableDevicesByPriceAscending();
            }
            case 2 -> {
                api.sortWearableDevicestByPriceDescending();
            }
            case 3 -> {
                api.sortByDeviceManufacturerAscending();
            }
            case 4 -> {
                api.sortByDeviceManufacturerDescending();
            }
            case 5 -> {
                api.sortByDeviceIDAscending();
            }
            case 6 -> {
                api.sortByDeviceIDDescending();
            }
            case 7 -> {
                api.sortByDeviceBatteryLifeAscending();
            }
            case 8 -> {
                api.sortByDeviceBatteryLifeDescending();
            }
            case 0 -> exitApp();
            default -> System.out.println("Invalid option entered: " + option);
        }
    }

    //-----------------------------------
    //--------- Main Menu Option 5 ------
    //-----------Save All Devices--------
    //-----------------------------------

    /**
     * This method saves all items added to the ArrayList to the XML file for loading later
     */
    private void saveAllDevices() {
        try {
            api.save();
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e);
        }
    }


    //-----------------------------------
    //--------- Main Menu Option 6 ------
    //-----------Load All Devices--------
    //-----------------------------------

    /**
     * This method loads all devices already saved to the XML file for continued use.
     */
    private void loadAllDevices() {
        try {
            api.load();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }
    }

    //---------------------
    //  Helper Methods
    //---------------------


    /**
     * Checks to make sure that the user inputs a valid manufacturer already saved in the manufacturer name Set
     * The valid options will be listed and the user can input based on this.
     *
     * @return a valid manufacturer name.
     */
    private String isValidManufacturer() {
        do {
            String manufacturerName = ScannerInput.readNextLine("Enter the manufacturer " + ManufacturerNameUtility.getManufacturers() + ": ");
            if (ManufacturerNameUtility.isValidManuName(manufacturerName)) {
                return manufacturerName;
            } else {
                System.err.println("\tManufacturer name not valid.");
            }
        } while (true);
    }

    /**
     * Checks to make sure that the user inputs a valid display type already saved in the display type Set
     * The valid options will be listed and the user can input based on this.
     *
     * @return a valid display type.
     */
    private String isValidDisplayType() {
        do {
            String displayType = ScannerInput.readNextLine("Enter the display type " + DisplayTypeUtility.getDisplayTypes() + ": ");
            if (DisplayTypeUtility.isValidDisplayType(displayType)) {
                return displayType;
            } else {
                System.err.println("\tDisplay type not valid.");
            }
        } while (true);
    }

}

