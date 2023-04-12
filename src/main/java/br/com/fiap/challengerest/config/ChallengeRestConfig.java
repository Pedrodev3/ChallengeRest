package br.com.fiap.challengerest.config;

import io.github.cdimascio.dotenv.Dotenv;



public class ChallengeRestConfig {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String javaVersion = dotenv.get("JAVA_VERSION");
        String ojdbc11Path = dotenv.get("OJDBC11_PATH");

        System.setProperty("java.version", javaVersion);
        System.setProperty("oracle.jdbc.driver.OracleDriver", ojdbc11Path);
        System.out.println("java.version: " + System.getProperty("java.version"));
        System.out.println("Oracle JDBC driver path: " + System.getProperty("oracle.jdbc.driver.OracleDriver"));

    }
}
