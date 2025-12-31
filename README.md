# inventory-management-system

This project is a Java-based Inventory Management System designed to efficiently manage inventory data for a business. It helps in handling products, stock levels, suppliers, customers, purchases, and sales using a structured and database-driven approach.

The application is built using Java, Hibernate ORM, and MySQL, where Hibernate is used to map Java objects to database tables and simplify database operations. The system supports full CRUD (Create, Read, Update, Delete) functionality, allowing users to add, view, update, and remove inventory-related records easily.

The database is designed using relational concepts with proper primary keys and foreign keys to maintain data integrity. Separate tables are maintained for products, current stock, suppliers, customers, purchase transactions, and sales transactions. Purchase records help increase stock, while sales records help track inventory reduction.

The project follows a layered architecture, consisting of:

Model Layer: Entity classes mapped to database tables using Hibernate annotations

Data Access Layer (DAO): Handles all database operations

Application Layer: Contains the main business logic and user interactions

This project demonstrates a strong understanding of Java backend development, ORM concepts, and database management. It also serves as a solid foundation for future enhancements such as adding a GUI, authentication, reporting features, or converting it into a web application using Spring Boot.
