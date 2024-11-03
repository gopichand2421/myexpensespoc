CREATE TABLE user_roles (
    id INT AUTO_INCREMENT PRIMARY KEY,         -- Unique identifier for the role
    role_name VARCHAR(50) NOT NULL UNIQUE      -- Name of the role (e.g., ADMIN, USER)
);
