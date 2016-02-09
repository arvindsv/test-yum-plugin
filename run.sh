javac -cp $(ls lib/* | tr '\n' ':'). TestConnection.java
java -cp $(ls lib/* | tr '\n' ':'). TestConnection
