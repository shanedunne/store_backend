Name : Shane Dunne

Student Number: 20108890

Part A - Inheritance Hierarchy (21 / 24)
-----------------------------

WearableDevices (9 /10)
    - I have successfully implemented the WearableDevice abstract class as per the provided UML.
    - I have initialised applicable fields to default values (or the specified default values) as we have with the Shop and Social Network projects throughout the module.
    - The constructor provides the correct validation checks and utilises the Utils provided where applicable.
    - These validation checks are carried on to the setter methods, ensuring to not include else statements, reverting to default values if conditions are not met.
    - The toString method has been refactored to be reader friendly.
    - I added some additional fields here, along with their setter and getters and some logical validation based on the field information.
        - batteryLife - Takes an int and defaults to 1 hour.
        - colour - Takes a String which is truncated to 12 characters using the utils.

SmartWatch( 7 / 8)
    - I have successfully implemented the SmartWatch class which extends the WearableDevice abstract class.
    - I have initialised applicable fields to default values (or the specified default values) as we have with the Shop and Social Network projects throughout the module.
    - The constructor provides the correct validation checks and utilises the Utils provided where applicable.
    - These validation checks are carried on to the setter methods, ensuring to not include else statements, reverting to default values if conditions are not met.
    - The insurance premium is correctly calculated and displayed in the toString method. I have ensured to use the toTwoDecimalPlace utility method on the premium value to make it user friendly.
    - The connectToInternet method also returns the correct string and is also included in the toString output.
    - The toString method has been factored to be reader friendly and also calls the super method, to display the extended fields from the WearableDevice class.
    - I added some additional fields here, along with their setter and getters and some logical validation based on the field information.
        - hasAppStore - takes a char, which is converted and stored as a boolean depending on the input. This is handled via the Utilities. The getter will return a char too, which will convert the stored boolean into y or n.
SmartBand ( 7 / 8)
    - I have successfully implemented the SmartBand class which extends the WearableDevice abstract class.
    - I have initialised applicable fields to default values (or the specified default values) as we have with the Shop and Social Network projects throughout the module.
    - The constructor provides the correct validation checks and utilises the Utils provided where applicable.
    - These validation checks are carried on to the setter methods, ensuring to not include else statements, reverting to default values if conditions are not met.
    - The insurance premium is correctly calculated and displayed in the toString method. I have ensured to use the toTwoDecimalPlace utility method on the premium value to make it user friendly.
    - The connectToInternet method also returns the correct string and is also included in the toString output.
    - The toString method has been factored to be reader friendly and also calls the super method, to display the extended fields from the WearableDevice class.
    - I added some additional fields here, along with their setter and getters and some logical validation based on the field information.
        - hasHeartRateMonitor - takes a char which is converted and stored as a boolean using the Utilities.
        - isWaterResistant - takes a char which is converted and stored as a boolean using the Utilities.
        - waterResistantDepth - takes an int representing depth in metres. Will be 0 if isWaterResistant is false.


Part B - TechnologyDeviceAPI  (27 /34)
-----------------------------
basic CRUD (9 /13 )
- All CRUD features have been implemented in the API as listed and described below:

    - addWearableDevice
        - Takes an object containing information representing the wearable device fields and adds them to the ArrayList that stores devices.
    - deleteWearableDeviceByIndex
        - Allows the user to delete a device from the ArrayList by its index in the ArrayList
    - deleteWearableDeviceById
        - Allows the user to delete a device from the ArrayList by specifying its given ID
    - updateSmartWatch
        - Takes the id of the smart watch to update along with an object containing the details to update. Returns true if successful.
    - updateSmartBand
        - Takes the id of the smart band to update along with an object containing the details to update. Returns true if successful.
    - getWearableDeviceByIndex
        - Takes an int which represents the index of the device the user wants to get from the ArrayList
    - getWearableDeviceByID
        - Takes a string representing the ID of the device the user wants to get from the ArrayList


reporting/numberOf methods (7 / 8)
- All reporting and number of methods have been implemented as requested:
    - listAllWearableDeviceDevices
        - Returns a string of all wearable devices currently stored in the ArrayList
    - listAllSmartBands
        - Checks the ArrayList for instances of smart bands, and returns a list of these devices.
    - listAllSmartWatches
        - Checks the ArrayList for instances of smart watches, and returns a list of these devices.
    - listAllWearableDeviceDevicesAbovePrice
        - Takes a price and returns a list of the devices above this price
    - listAllWearableDeviceDevicesBelowPrice
        - Takes a price and returns a list of the devices below this price
    - numberOfWearableDevices
        - returns a count on the number of devices stored in the ArrayList
    - numberOfSmartBands
        - checks the ArrayList for instances of smart bands and returns a count on how many are stored.
    - numberOfSmartWatches
        - checks the ArrayList for instances of smart watches and returns a count on how many are stored.
    - numberOfWearableDevicesByChosenManufacturer
        - Takes a string representing a manufacturer name and first checks it is a valid name. Then checks the ArrayList for devices made by this manufacturer and returns a count.

validation methods  & persistence  (4 / 5)
- All validation and persistence methods have been implemented as per the specifications:
    - isValidId
        - already provided
    - save
        - saves the records of the ArrayList to the file specified
    - load
        - loads the records from the specified file to the Arraylist when the driver is active
    - fileName
        - returns the file name where data is saved to and loaded from.


sorting / top 5 (7 / 8)
    - swapWearableDevice
        - A method to assist the sorting of devices by different criteria. It swaps devices at specified indexes.
    - sortWearableDevicestByPriceDescending
        - A method that sorts devices by price descending, utilising the swapWearableDevice method
    - sortWearableDevicesByPriceAscending
        - A method that sorts devices by price ascending, utilising the swapWearableDevice method
    - topFiveExpensiveWearableDevices
        - This method returns the top 5 most expensive devices, or the top x amount if the ArrayList is less than 5
    - topFiveExpensiveSmartWatches
        - This method returns the top 5 most expensive smart watches, or the top x amount if the ArrayList is less than 5

Part C - UX (user experience) and Driver:Mark (17 /23)
-----------------------------
Good Menu Structure  (3 / 4)
    - I have implemented a multilayer menu system, split by out main requirements of CRUD, reports, search, sort, load and save
    - There is sub menus to handle different functionality or where actions can be taken on a specific chosen device type
    - The menu is consistent in appearance throughout each layers with dividers and spacing to ensure sub menu separation is evident.
ArrayListCRUD  - all  types handled  (5 / 7)
    - All types of Arraylist CRUD have been handled through the menu options.
    - Sub menus help simplify the chose for the user
Reports Menu - for all wearables (6 / 7)
    - The reports menu has been clearly laid out to achieve the specifications with additional reports available
    - In some report instances, an option will lead to a sub menu where the user can chose the report type on all devices, or by specific device type.
Search, Sort, top5   (3 / 4)
    - I have included separate submenus for 'search' and 'sort', with the top 5 lists existing in the reports menu
    - Search options include by ID, Model Name and Manufacturer
    - There is a substantial list of sorting options initially based on the specifications, with additional options added based on other field types etc. I have added to the devices.
Save, Load, Exit   (1 / 1)
    - All implemented as required.



Part D - DX (Overall style) (11%)	 (8 /11)
-----------------------------
Code correctly commented (2 / 3)
    - all methods have comments explaining the intention of the method
Standard naming, indentation, DRY Code etc. (4 / 5)
    - naming conventions should be self explanatory throughout
    - indentation is standardised by IntelliJ's formatting tool.
    - I have implemented DRY code as much as possible to reduce clutter and code copies.
Javadoc written for WearableDeviceAPI  (2 / 3)
    - I have completed extensive Javadoc comments as per standard conventions on the API file, along with the rest of the files

Part E - For Extra Credit (10%)  (7 / 10)
-----------------------------
- Device Classes
        - WearableDevices
                - I added some additional fields here, along with their setter and getters and some logical validation based on the field information.
                    - batteryLife - Takes an int and defaults to 1 hour.
                    - colour - Takes a String which is truncated to 12 characters using the utils.
        - SmartBands
                - I added some additional fields here, along with their setter and getters and some logical validation based on the field information.
                    - hasHeartRateMonitor - takes a char which is converted and stored as a boolean using the Utilities.
                    - isWaterResistant - takes a char which is converted and stored as a boolean using the Utilities.
                    - waterResistantDepth - takes an int representing depth in metres. Will be 0 if isWaterResistant is false.
        - SmartWatches
                - I added some additional fields here, along with their setter and getters and some logical validation based on the field information.
                    - hasAppStore - takes a char, which is converted and stored as a boolean depending on the input. This is handled via the Utilities. The getter will return a char too, which will convert the stored boolean into y or n.
        - SmartGlasses
                - I have added an entire new device type here:
                    - The class extends the WearableDevices class and is for the most part is implemented the same as SmartBands and SmartWatches
                    - Includes a boolean hasUVProtection to note if the close is UV glass
                    - Includes an int count for the number of cameras on the class
                    - Further utility has been added to the API class and menus to handle this extra device type.
- API CLASS
    CRUD
        - updateSmartGlasses
                - Added to handle the added device type of smart glasses
                - Takes the id of the smart glasses to update along with an object containing the details to update. Returns true if successful.
    Sorting:
        - sortByPriceDescending
            - this method takes a List as its parameter. I wrote this method so the top 5 methods can sort the data without disturbing the order of the ArrayList
            - The ArrayList is passed and a clone is made, which is then sorted to identify the top 5 most expensive items
        - sortByDeviceManufacturerDescending
            - Sorts the ArrayList of devices in a descending alphabetical order based on manufacturers
        sortByDeviceManufacturerAscending
            - Sorts the ArrayList of devices in an ascending alphabetical order based on manufacturers
        sortByDeviceIDDescending
            - Sorts the ArrayList of devices in a descending alphabetical order based on ID
        sortByDeviceIDAscending
            - Sorts the ArrayList of devices in an ascending alphabetical order based on ID
        sortByDeviceBatteryLifeDescending
            - Sorts the ArrayList of devices in a descending order based on battery life
        sortByDeviceBatteryLifeAscending
            - Sorts the ArrayList of devices in an ascending alphabetical order based on manufacturers

    Reporting/Number Of
    - listAllSmartGlasses
            - Added to handle the added device type of smart glasses
            - Checks the ArrayList for instances of smart glasses, and returns a list of these devices.
    - numberOfSmartGlasses
            - Added to handle the added device type of smart glasses
            - checks the ArrayList for instances of smart glasses and returns a count on how many are stored.

- UTILITIES
    - ManufacturerNameUtility
        - I changed the manufacturerNames ArrayList to a HashSet as I felt it was a more appropriate data type as to not allow for duplicates
    - DisplayTypeUtility
        - I changed the displayTypes ArrayList to a HashSet as I felt it was a more appropriate data type as to not allow for duplicates

- DRIVER
    - I added a detailed, multilayer menu system with consistent layout to allow for a good user experience.
    - I added an isValueManufacturer helper method to ensure the user inputs a valid manufacturer that exists in the HashSet
    - I added an isValueDisplayType helper method to ensure the user inputs a valid display type that exists in the HashSet



Part F - Reflection (5 / 8)
-----------------------------
Filled out parts A - D above (2 / 3)

Rest(3 / 5)
Chronology of my implementation (what I did first, etc.. )
    - I generally followed the layout of the specifications in implementing the device classes, followed by the API, and then the driver.
    - When adding additional functionality, this sometimes happened while following the steps layed out, while some came at the end, when the basic system was working.
        - I added the Smart Glasses class in the earlier stage as I knew i wanted to expand on device types.
        - The extra field types for all devices were also added at this stage.
    - With the majority of the API witten, I begun to structure my menu setup, and one by one, added the functionality to handle the API methods.
    - As each piece of functionality was added, I boundary and generally tested to ensure everything worked as intended.
    - This final thing i completed was the persistence set up with load and save.

Main difficulties I came across in your development of solution and how I solved them.
    - Top 5 Devices and Sorting
        - When writing the top 5 device methods, I wanted to be able to sort the order of devices, without disturbing the current order of the devices as this would be a flaw of the system in use.
        - I created a specific sorting method that allowed me to pass in the ArrayList and duplicate it, and sort this list, causing no change to the main list
        - I wanted to write all of my sorting methods in this manner, to implement further DRY coding but ran into some stumbling blocks so had to seperate it out.

Any bugs remaining in the solution or unfinished elements of spec (no need if you have detailed these in the rubric section)
    - While completing my final testing, i have realised i have not implemented the isValidId method, allowing for the creation of duplicate IDs. Due to timing, i must leave it the way it is now, which I have reflected in my CRUD scoring.
    - Currently, updating a device does not allow for the updating of the ID
    - When updating, if a Smart Band is changed from water resistant to not water resistant, the water resistance depth does not change to 0 as it should

Main learnings from my engagement with assignment
    - I feel i have achieved a great understanding of Javas class system and feel more comfortable fitting the pieces together
    - The implementation of abstract classes and interfaces in this project has helped me to understand their importance and see other use cases

Mandatory : PLease list any references used in your development/ implementation of your submission.
    - Lecture videos
    - Labs from the module
    - W3Schools helped a lot in quick refreshers or deeper implementations of concepts.

Please consider the following statements and choose one (delete the inappropriate one)

- This is my work apart from the specific references noted above (and any code from class notes). I understand the code and can decribe any parts of the solution if needs be;
