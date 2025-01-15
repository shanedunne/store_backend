# Wearable Device Management System

This Java console application provides a menu-driven program to manage a wearable devices store. The main entry point for the application is the `Driver` class, which orchestrates user interaction through a series of menus and submenus.  

## Features

1. **CRUD Operations**  
   - **Create**: Add new wearable devices (Smart Band, Smart Watch, or Smart Glasses).  
   - **Read**: Retrieve devices by index or ID.  
   - **Update**: Update existing device details.  
   - **Delete**: Remove devices by index or ID.

2. **Device Reports**  
   - **Listing**: View lists of all devices, or filter by type.  
   - **Counting**: See how many devices exist by type or by manufacturer.  
   - **Price-based Filtering**: List devices above or below a specific price.  
   - **Top Five Most Expensive**: Generate a report of the five costliest devices (by type or across all devices).

3. **Search Menu**  
   - Find devices by model name, ID, or manufacturer name.

4. **Sorting**  
   - Sort devices in ascending or descending order by price, manufacturer, ID, or battery life.

5. **Data Persistence**  
   - **Save**: Save all wearable devices to an XML file.  
   - **Load**: Load all stored wearable devices from an XML file.

## How It Works

1. **Main Method**  
   - The application starts in `public static void main(String[] args)` within `Driver`.  
   - Calls `start()`, which then loads any previously stored devices and displays the main menu.

2. **Main Menu**  
   - Guides you through various options:
     ```
     1) CRUD Menu
     2) Device Reports
     3) Search for Device
     4) Sort Devices
     5) Save All Devices
     6) Load All Devices
     0) Exit
     ```

3. **Menus and Submenus**  
   - Each main menu option leads to a submenu (CRUD, device reports, searching, sorting, etc.).  
   - Input is handled by the `ScannerInput` utility (e.g., `readNextInt`, `readNextLine`).

4. **WearableDeviceAPI**  
   - Core functionality for adding, updating, deleting, listing, and sorting devices.  
   - `Driver` delegates actions to the `WearableDeviceAPI`, which manages the internal `ArrayList` of `WearableDevice` objects.

5. **Utilities**  
   - `ManufacturerNameUtility` and `DisplayTypeUtility`: Validate input against known manufacturers and display types.  
   - `Utilities`: Contains helpful methods (like converting Y/N to boolean).  
   - `ScannerInput`: Reads user input safely from the console.

## How to Run

1. Clone or download the repository with the source files.  
2. Ensure you have a Java development environment (JDK 17+ recommended).  
3. Navigate to the project directory in your terminal/IDE.  
4. Compile and run `Driver.java`:
   ```bash
   javac Driver.java
   java Driver
