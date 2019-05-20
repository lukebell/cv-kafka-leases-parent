# Cablevision Common Utilities

Common utilities for Kafka consumers module related on:

* Error handling
* WD2K connection
* SNMP Trap Sender
* Etc.

### Application Building

Follow this steps to build the module:

    mvn clean install

### Warning

  You must add local maven dependency OJDBC to build the project
  
    mvn install:install-file -Dfile={PROJECT_FOLDER}/cv-kafka-leases-parent/cv-common-consumer-utils/libs/ojdbc6-11.2.0.3.0.jar -DgroupId=com.oracle.jdbc -DartifactId=ojdbc6 -Dversion=11.2.0.3.0 -Dpackaging=jar
  
### Support

  If you have any questions regarding this module, you can contact me via email
  at lcampana@cablevision.com.ar




