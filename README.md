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

##Your personal and company data are protected in this chat
Here are the method declarations for each service that the controller will use, along with the corresponding JPA repository interfaces and suggested controller APIs:



'''

Your personal and company data are protected in this chat
Here are the method declarations for each service that the controller will use, along with the corresponding JPA repository interfaces and suggested controller APIs:

1 User Service

Method Declarations:
public User register(User user);
public User login(String email, String password);
public void logout(User user);
public User getProfile(int userId);
JPA Repository Interface:
public interface UserRepository extends JpaRepository<User, Integer> {}
Controller APIs:
POST /register
POST /login
POST /logout
GET /profile/{userId}


2 Seller Service

Method Declarations:
public Seller registerSeller(Seller seller);
public List<Ticket> listTicket(int sellerId);
public Listing manageListing(Listing listing);
JPA Repository Interface:
public interface SellerRepository extends JpaRepository<Seller, Integer> {}
public interface ListingRepository extends JpaRepository<Listing, Integer> {}
Controller APIs:
POST /registerSeller
GET /listTicket/{sellerId}
POST /manageListing


3  Buyer Service

Method Declarations:
public List<Ticket> searchTickets(String query);
public Order purchaseTicket(Order order);
public List<Order> manageOrders(int buyerId);
JPA Repository Interface:
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {}
public interface OrderRepository extends JpaRepository<Order, Integer> {}
Controller APIs:
GET /searchTickets?query={query}
POST /purchaseTicket
GET /manageOrders/{buyerId}


4 Ticket Service

Method Declarations:
public Ticket getTicketDetails(int ticketId);
public Ticket updateTicket(Ticket ticket);
public void deleteTicket(int ticketId);
JPA Repository Interface:
public interface TicketRepository extends JpaRepository<Ticket, Integer> {}
Controller APIs:
GET /ticketDetails/{ticketId}
PUT /updateTicket
DELETE /deleteTicket/{ticketId}


5  Payment Service

Method Declarations:
public Payment initiatePayment(Payment payment);
public Payment confirmPayment(int paymentId);
public Payment refund(int paymentId);
JPA Repository Interface:
public interface PaymentRepository extends JpaRepository<Payment, Integer> {}
Controller APIs:
POST /initiatePayment
PUT /confirmPayment/{paymentId}
PUT /refund/{paymentId}


6  Notification Service

Method Declarations:
public Notification sendNotification(Notification notification);
JPA Repository Interface:
public interface NotificationRepository extends JpaRepository<Notification, Integer> {}
Controller APIs:
POST /sendNotification


7 Review and Rating Service

Method Declarations:
public Review rate(Review review);
public Review review(Review review);
public List<Review> getReviews(int sellerId);
JPA Repository Interface:
public interface ReviewRepository extends JpaRepository<Review, Integer> {}
Controller APIs:
POST /rate
POST /review
GET /getReviews/{sellerId}
'''

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
