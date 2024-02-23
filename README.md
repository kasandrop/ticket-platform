# Microservices 


![alt text](diagram.png)

This repository contains a demo project showcasing a microservices-based application, designed to provide a hands-on understanding of microservices architecture and implementation. The project consists of an API Gateway, Config Server, Discovery Server, and two microservices: Student and School.



## Getting Started

Follow the instructions below to set up the project on your local machine for development and testing purposes.

### Prerequisites

Ensure you have the following software installed on your system before proceeding:

- Java Development Kit (JDK) 17 or later
- Maven
- Docker (optional, for containerization)

### Installation

1. Clone the repository:



2. Navigate to the project directory:
3. Build and package each component with Maven:
## Order of starting the services
1. Config Server
2. Discovery Server
3. The order of starting the rest of the services does not matter


## Project Components

### API Gateway

The API Gateway serves as the single entry point for all client requests, managing and routing them to the appropriate microservices.

### Config Server

The Config Server centralizes configuration management for all microservices, simplifying application maintenance and consistency across environments. All *.yml files are stored in one place.

### Discovery Server  Eureka Server

In essence, the Eureka Server simplifies the management of microservices in a Spring Boot environment by supporting service discovery and registration, load balancing, and health checks. It’s a crucial component in modern microservices architectures.

## 1. User Service  which is now Authorisation Service
   o API: /register,/login,/logout,/profile
   o Communicates with: Seller Service, Buyer Service, Notification Service
   o Database: Users (UserID, Name, Email, Password, UserType)
   o SQL:
   CREATE TABLE Users (
   ) ;
   UserID INT PRIMARY KEY,
   Name VARCHAR (100),
   Email VARCHAR (100),
   Password VARCHAR (100),
   UserType VARCHAR (50)
## 2. Seller Service
   o API: /registerSeller,/listTicket,/manageListing
   o Communicates with: User Service, Ticket Service, Notification Service
   o Database: Sellers (SellerID, UserID, BusinessName), Listings (ListingID, SellerID, TicketID,
   Price, Quantity)
   o SQL:
   CREATE TABLE Sellers (
   SellerID INT PRIMARY KEY,
   UserID INT,
   BusinessName VARCHAR(100),
   FOREIGN KEY (UserID) REFERENCES Users(UserID)
   ) ;
   CREATE TABLE Listings (
   ListingID INT PRIMARY KEY,
   SellerID INT,
   TicketID INT,
   Price DECIMAL (10, 2),
   Quantity INT,
   FOREIGN KEY (SellerID) REFERENCES Sellers(SellerID)
   ) ;
## 3. Buyer Service
   o API: /searchTickets,/purchaseTicket,/manageOrders
   o Communicates with: User Service, Ticket Service, Payment Service, Notification Service
   o Database: Buyers (BuyerID, UserID), Orders (OrderID, BuyerID, ListingID, Quantity, Status)
   o SQL:
   CREATE TABLE Buyers (
   BuyerID INT PRIMARY KEY,
   UserID INT,
   FOREIGN KEY (UserID) REFERENCES Users(UserID)
   ) ;
   CREATE TABLE Orders (
   OrderID INT PRIMARY KEY,
   BuyerID INT,
   ListingID INT,
   Quantity INT,
   ) j
   Status VARCHAR (50),
   FOREIGN KEY (BuyerID) REFERENCES Buyers(BuyerID),
   FOREIGN KEY (ListingID) REFERENCES Listings(ListingID)
 ## 4. Ticket Service
   o API: /ticketDetails,/updateTicket,/deleteTicket
   o Communicates with: Seller Service, Buyer Service
   o Database: Tickets (TicketID, EventName, EventDate, Venue)
   o SQL:
   CREATE TABLE Tickets (
   TicketID INT PRIMARY KEY,
   EventName VARCHAR (100),
   EventDate DATE ,
   Venue VARCHAR (100)
   ) j
## 5. Payment Service
   o API: /initiatePayment,/confirmPayment,/refund
   o Communicates with: Buyer Service
   o Database: Payments (PaymentID, OrderID, Amount, Status)
   o SQL:
   CREATE TABLE Payments (
   PaymentID INT PRIMARY KEY,
   Order ID INT,
   Amount DECIMAL (10, 2),
   Status VARCHAR (50),
   FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
   ) j
## 6. Notification Service
   o API: /sendNotification
   o Communicates with: User Service, Seller Service, Buyer Service
   o Database: Notifications (NotificationID, UserID, Message, Status)
   o SQL:
   CREATE TABLE Notifications (
   NotificationID INT PRIMARY KEY,
   UserID INT,
   Message TEXT,
   Status VARCHAR (50),
   FOREIGN KEY (UserID) REFERENCES Users(UserID)
   ) j
## 7. Review and Rating Service
   o API: /rate,/review, /getReviews
   o Communicates with: Buyer Service, Seller Service
   o Database: Reviews (ReviewID, BuyerID, SellerID, Rating, Comment)
   o SQL:
   CREATE TABLE Reviews (
   ReviewID INT PRIMARY KEY,
   Buyer ID INT,
   ) j
   Seller ID INT,
   Rating INT,
   Comment TEXT,
   FOREIGN KEY (BuyerID) REFERENCES Buyers(BuyerID),
   FOREIGN KEY (SellerID) REFERENCES Sellers(SellerID)
   Each of these services should have its own database to ensure data consistency and service independence. The
   services can communicate with each other using RESTful APis, gRPC, or messaging queues for asynchronous
   communication. Remember to follow best practices for microservices architecture, such as loose coupling,
   high cohesion, and database per service## Inter-Service Communication

### Using OpenFeign

This project demonstrates inter-service communication using OpenFeign, a declarative REST client that simplifies service-to-service communication within the microservices ecosystem.

## Distributed Tracing

### Using Zipkin --not using that in this project

The project showcases the use of Zipkin for distributed tracing, enhancing application observability and enabling the visualization and troubleshooting of latency issues.

## Contributing

Contributions are welcome! Please read our [CONTRIBUTING.md](CONTRIBUTING.md) for details on how to contribute to this project.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact



## Acknowledgements

- [OpenFeign](https://github.com/OpenFeign/feign)
- [Zipkin](https://zipkin.io/)
- [Spring Cloud Netflix](https://spring.io/projects/spring-cloud-netflix)
