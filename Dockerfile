FROM java:8
ADD https://s3.us-east-2.amazonaws.com/revature.com.eureka/account-service.jar .
EXPOSE 2223
CMD java -jar account-service.jar