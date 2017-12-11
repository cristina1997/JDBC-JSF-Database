# JDBC-JSF-Database

This is JSF dynamic web application that updates two types of Databases
* MySQL 
* MongoDB

***

## Run
First and foremost, you will need to install the following (if not already installed):
  * [Eclipse IDE](https://eclipse.org/downloads/eclipse-packages/)
  * [Tomcat](https://tomcat.apache.org/download-90.cgi) - **the 32-bit/64-bit Windows Service Installer**
  * [MongoDB](https://www.mongodb.com/download-center#community)
  * [Wamp](http://www.wampserver.com/en/)
  
  
**1. Clone Repo**
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open your terminal/cmd in the folder you wish to download the repository and execute the following

 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;``` git clone https://github.com/cristina1997/JDBC-JSF-Database.git```

**2. Install Tomcat**
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click on the file just downloaded to begin the installation.
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click ```Next```
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click ```I Agree```
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select type of Installation ```Normal```
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click ```Next```
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click ```Next``` on the Configuration Options screen.
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Set the ```JRE (Java Runtime Environment) Path e.g. C:\Program Files\Java\jre1.8.0_101 and click Next```
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click ```Install```
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```Unselect Show Readme and click Finish```


**3. Run Wamp**
  * Terminal
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open your terminal/cmd 
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to ```cd \wamp64\bin\mysql\mysql5.7.19\bin``` **the version number can differ depending on which one you have downloaded**
    
    
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type ```mysql -u root -p <Full Path\filename.sql``` for the [Geography](https://github.com/cristina1997/JDBC-JSF-Database/blob/master/geography.sql) database

  * Open Wamp
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to the Icons section and click on Wamp
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```Go to MySQL -> MySQL Console```

**4. Run MongoDB**
  * Mongod
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open your terminal/cmd 
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to ```cd C:\Program Files\MongoDB\Server\3.6\bin``` **the version number can differ depending on which one you have downloaded**
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type ```mongod```
  * Mongo
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open a new terminal/cmd 
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to the same MongoDB location as shown above
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Write mongo
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type ```use headsOfStateDB```
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type [This Query](https://github.com/cristina1997/JDBC-JSF-Database/blob/master/headsOfStateDB.txt) to create a collection
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type ```use collection```
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type ```show collections``` to show the collection you have created
    
**5. Run Eclipse**
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open eclipse and create a new Java Project
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;``` Go to File > New > Other > Dynamic Web Project give it a name and select the **Target Runtime** from C:\Program Files\Apache Software Foundation\Tomcat 9.0 click Next until **Web Module** screen appears and select the **Generate web.xml deployment description** and press Finish```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open eclipse and create a new Java Project

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;``` Go to File > New > Project > Java Project give it a name, click Next > Finish```

**6. Copy Source Code**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to the folder where you downloaded the repository and copy the src folder.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Paste the src folder into the Java Project **in Eclipse** and to replace the empty src folder in there.

**4 Run**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;``` Run > Run```
