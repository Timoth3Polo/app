# -------------------------------
# Étape 1 : Compilation avec Maven
# -------------------------------
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copier uniquement les fichiers nécessaires pour optimiser le cache Docker
COPY pom.xml ./
COPY src ./src

# Construire l'application sans tests
RUN mvn clean install -DskipTests

# -------------------------------
# Étape 2 : Image finale avec Tomcat
# -------------------------------
FROM tomcat:jdk21

# Définir le répertoire de travail pour Tomcat
WORKDIR /usr/local/tomcat/webapps/

# Copier le .war généré depuis l’étape de build
COPY --from=build /app/target/lirafus-0.0.1-SNAPSHOT.war ROOT.war

# Copier la configuration personnalisée de Tomcat
COPY ./config/tomcat/server.xml /usr/local/tomcat/conf/server.xml

# Définir les permissions correctes pour le fichier WAR
RUN chmod 644 ROOT.war

# Exposer le port sur lequel l'application sera accessible
EXPOSE 4714

# Lancer Tomcat
CMD ["catalina.sh", "run"]
