#Base Image
FROM openjdk:11  
COPY . /src/java  
WORKDIR /var/www/java  
RUN ["javac", "PhoneBookCrawler.java"]  
CMD ["java", "PhoneBookCrawler"]  
