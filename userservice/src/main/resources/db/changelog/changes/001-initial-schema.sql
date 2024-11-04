CREATE TABLE user_roles (
    id INT AUTO_INCREMENT PRIMARY KEY,         -- Unique identifier for the role
    role_name VARCHAR(50) NOT NULL UNIQUE      -- Name of the role (e.g., ADMIN, USER)
);

INSERT INTO USER_ROLES VALUES (1,'APP_ADMIN'), (2,'APP_USER');
