#Use the official openjdk 17 image from Docker hub
FROM openjdk:17
#Set working directory inside container
WORKDIR /app
#Copy the compiled java application JAR file into the container
COPY ./target/foodCoupon.jar /app
#Expose the port for spring boot application will run application
EXPOSE 8080
#Command to run the application
CMD ["java", "-jar", "foodCoupon.jar"]