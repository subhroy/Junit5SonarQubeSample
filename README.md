# Demonstrate JUNIT5 and SonarQube Implementation with Maven Project
This project demonstrate JNUT5 and SonarQube integration with Maven project

## Required Dependencies
Below dependencies are required for Junit5 and SonarQube Testcase
### Junit5
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.8.2</version>
    </dependency>

### SonarQube Scanner
    <dependency>
        <groupId>org.sonarsource.scanner.maven</groupId>
        <artifactId>sonar-maven-plugin</artifactId>
        <version>3.9.1.2184</version>
    </dependency>

## Setting plugins

### Sonar Scanner
     <build>
        <plugins>
            <plugin>
                <groupId>org.sonarsource.scanner.maven</groupId>
                <artifactId>sonar-maven-plugin</artifactId>
            </plugin>
        </plugins>
    <build>

### Jacoco Report
    <plugin>
        <groupId>org.jacoco</groupId>
        <artifactId>jacoco-maven-plugin</artifactId>
        <version>0.8.8</version>
        <configuration>
            <!-- specify classes for excluding in code coverage -->
            <!-- <excludes>
                 <exclude>org/division/*.class</exclude>
             </excludes>-->
        </configuration>
        <executions>
            <execution>
                <goals>
                    <goal>prepare-agent</goal>
                </goals>
            </execution>
            <execution>
                <id>jacoco-report</id>
                <phase>test</phase>
                <goals>
                    <goal>report</goal>
                </goals>
                <!-- default target/site/jacoco/* ,
                but you can specify location as your want -->
                <configuration>
                    <outputDirectory>target/jacoco-report</outputDirectory>
                    <skip>${jacoco.skip}</skip>
                </configuration>
            </execution>
            <!-- Add this part for specify rules of checking -->
            <execution>
                <id>jacoco-check</id>
                <goals>
                    <goal>check</goal>
                </goals>
                <configuration>
                    <rules>
                        <rule>
                            <element>PACKAGE</element>
                            <!-- Specify the limit of your code Coverage rules-->
                            <limits>
                                <limit>
                                    <counter>LINE</counter>
                                    <value>COVEREDRATIO</value>
                                    <minimum>0.5</minimum>
                                </limit>
                                <limit>
                                    <counter>CLASS</counter>
                                    <value>MISSEDCOUNT</value>
                                    <maximum>0</maximum>
                                </limit>-
                            </limits>
                        </rule>
                    </rules>
                </configuration>
            </execution>
    
            <!--Added for code coverage report aggregation -->
            <execution>
                <id>report-aggregate</id>
                <phase>verify</phase>
                <goals>
                    <goal>report-aggregate</goal>
                </goals>
            </execution>
        </executions>
    </plugin>    

## Specify SonarQube profile
    <profiles>
        <profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <!-- 
                Default url is http://localhost:9000, 
                You can speficy your any sonarqube url value which you are using
                -->
                <sonar.host.url>
                    http://localhost:9000
                </sonar.host.url>
                <sonar.projectKey>
                    junit5AndSonarQubeSample
                </sonar.projectKey>
                <!-- Generate token by login as admin User in your SonarQube site, 
                steps given below -->
                <!--
                     User > My Account > Security -> Enter Token Name
                     Click the Generate button, you will see the token value.
                     (Copy it immediately; 
                     Once you dismiss the notification you will not be able to retrieve it.)
                -->
                <sonar.login>8w43453ac7185d0456b72h4770f0d6bccfg6547</sonar.login>
                <sonar.coverage.jacoco.xmlReportPaths>
                    ${project.basedir}/target/jacoco-report/jacoco.xml
                </sonar.coverage.jacoco.xmlReportPaths>
            </properties>
        </profile>
    </profiles>

## Build Project with Test case and Push code to SonarQube
### Command:
_mvn clean test install sonar:sonar -Pcoverage_

You will be able to see the result by opening SonarQube url (http://localhost:9000)



