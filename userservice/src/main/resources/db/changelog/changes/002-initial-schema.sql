
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,        -- Unique identifier for each user
    username VARCHAR(50) NOT NULL UNIQUE,     -- Unique username for the user
    email VARCHAR(100) NOT NULL UNIQUE,        -- Unique email for the user
    password VARCHAR(255) NOT NULL,            -- User password (hashed)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Record creation timestamp
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Record update timestamp
    role_id INT,                            -- Foreign key for user roles
    FOREIGN KEY (role_id) REFERENCES user_roles(id) ON DELETE SET NULL -- Foreign key constraint
);