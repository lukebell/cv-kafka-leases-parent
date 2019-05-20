# Cablevision Kafka Consumer Intraway

This module consumes 'leases' topic (IPv4/IPv6 Leases) and enriched them with the client id loaded from 'INTRAWAY'.'SRV_CABLEMODEMS' and produce the 'enrichedLeases' kafka messages 

## Docker Container

The following instructions will guide you for the basic usage of this image

* First build project
    
        maven clean install

* Second we need to build the image

		docker build -t sr-docker-xp01.corp.cablevision.com.ar:5000/cv-kafka-consumer-intraway:latest -t sr-docker-xp01.corp.cablevision.com.ar:5000/cv-kafka-consumer-intraway:1.0 .

* Start the API

		docker run -d --name=cv-kafka-consumer-intraway --restart=always --cpuset-cpus="0-3" --memory="2048m" --log-opt max-file=3 --log-opt max-size=50m --dns=192.168.182.46 --dns=192.168.5.11 --dns-search=corp.cablevision.com.ar sr-docker-xp01.corp.cablevision.com.ar:5000/cv-kafka-consumer-intraway:latest

Alternatively you could run the executable jar: 

* Build project
    
        maven clean install

* Start the API

        java -jar cv-kafka-consumer-intraway-1.0.0-exec.jar -Xms1024m -Xmx4096m -XX:MaxPermSize=2048m -XX:PermSize=1024
    
    or
    
        nohup java -jar cv-kafka-consumer-intraway-1.0.0-exec.jar -Xms1024m -Xmx4096m -XX:MaxPermSize=2048m -XX:PermSize=1024 &        

### Warning

  This process must run in a 'single thread' because the Spring-Kakfa client that supports 0.9 kafka version do not support message batch process.   

### Support

  If you have any questions regarding this module, you can contact me via email
  at lcampana@cablevision.com.ar
