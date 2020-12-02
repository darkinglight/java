mvn archetype:generate
mvn archetype:generate "-DgroupId=com.companyname.bank" "-DartifactId=consumerBanking" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"
java -cp target/mq-1.0-SNAPSHOT.jar com.light.App
java -jar target/mq-1.0-SNAPSHOT.jar
mvn compile exec:java -Dexec.mainClass="com.light.test.Main"
