# Utilisez une image de base Maven 3.6.0 avec Java 8
FROM maven:3.6.0-jdk-8-alpine

# Mettez à jour le répertoire de travail
WORKDIR /app

# Copiez le pom.xml et les sources dans le conteneur
COPY pom.xml .
COPY src ./src

# Construisez l'application
RUN mvn package

# Exposez le port pour votre application
EXPOSE 8080

# Commande pour exécuter votre application
CMD ["java", "-jar", "target/my-app-1.0-SNAPSHOT.jar"]