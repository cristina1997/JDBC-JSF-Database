# JDBC-JSF-Database

This is JSF dynamic web application that updates two types of Databases
* MySQL 
* MongoDB

***

## Run
First and foremost, you will need to install the following (if not already installed):
  * [Eclipse](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/oxygen/R/eclipse-inst-win64.exe) and [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
  * [MongoDB](https://www.mongodb.com/download-center#community)
  * [Wamp](http://www.wampserver.com/en/)
  
  
**1. Clone Repo**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open your terminal/cmd in the folder you wish to download the repository and execute the following

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;``` git clone https://github.com/cristina1997/JDBC-JSF-Database.git```

**2. Run Wamp**
  * Terminal
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open your terminal/cmd 
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to ```cd \wamp64\bin\mysql\mysql5.7.19\bin``` **the version number can differ depending on which one you have downloaded**
    
    
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type ```mysql -u root -p <Full Path\filename.sql``` for the [Geography](https://github.com/cristina1997/JDBC-JSF-Database/blob/master/geography.sql) database

  *. Open Wamp
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to the Icons section and click on Wamp
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```Go to MySQL -> MySQL Console```

**3. Run MongoDB**
  * Mongod
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open your terminal/cmd 
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to ```cd C:\Program Files\MongoDB\Server\3.6\bin``` **the version number can differ depending on which one you have downloaded**
    * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type ```mongod```
  * Mongo
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open a new terminal/cmd 
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to the same MongoDB location as shown above
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Write mongo
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type ```use headsOfStateDB```
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type [This Query](https://github.com/cristina1997/JDBC-JSF-Database/blob/master/headsOfStateDB.txt) to create a collection
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type ```use collection```
    - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type ```show collections``` to show the collection you have created
    

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open eclipse and create a new Java Project

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;``` Go to File > New > Project > Java Project give it a name, click Next > Finish```

**3. Copy Source Code**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go to the folder where you downloaded the repository and copy the src folder.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Paste the src folder into the Java Project **in Eclipse** and to replace the empty src folder in there.

**4 Run**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;``` Run > Run```
