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
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to ```File > New > Other > Dynamic Web Project``` and give it a name
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select the ```Target Runtime from C:\Program Files\Apache Software Foundation\Tomcat 9.0```
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click Next until Web Module screen appears and select the ```Generate web.xml deployment description``` 
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```Press Finish```

**6. Java Facets**
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to ```WebContent > WEB-INF > lib``` and copy the jar files from my lib folder
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to ```Project > Properties > Project Facets```
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select ```JavaServer Facets```
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Click ```Further configuration required```
  - Change the JSF Implementation Library to ```Disable Library Configuration```
  - Press ```OK```
 
**7. Java Build Path**
  * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to ```Project > Properties > Java Build Path > Libraries > Add JARs```
  * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to ```WebContent > WEB-INF > lib``` nd select all the jars
  * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Press ```OK```

**8. Copy Files**
  * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Copy all the XHTML files in the ```WebContent```
  * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Paste the src folder into the Java Project **in Eclipse** to replace the empty src folder in there.

**9 Run**
  * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;``` Run > Run AS > Run on Server```
