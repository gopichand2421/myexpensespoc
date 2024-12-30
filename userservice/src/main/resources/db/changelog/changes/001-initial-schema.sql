CREATE TABLE user_roles (
    id INT AUTO_INCREMENT PRIMARY KEY,         -- Unique identifier for the role
    role_name VARCHAR(50) NOT NULL UNIQUE,      -- Name of the role (e.g., ADMIN, USER)
    assigned_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP -- timestamp when role is created
);

INSERT INTO USER_ROLES(id,role_name) VALUES (1,'APP_ADMIN'), (2,'APP_USER');
