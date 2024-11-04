CREATE TABLE  profile (
    id INT AUTO_INCREMENT PRIMARY KEY,          -- Unique identifier for user details
    user_id INT NOT NULL,                   -- Foreign key to users table
    first_name VARCHAR(50) NOT NULL,          -- User's first name
    last_name VARCHAR(50) NOT NULL,           -- User's last name
    phone_number VARCHAR(15),                  -- User's phone number
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Record creation timestamp
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Record update timestamp
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE -- Foreign key constraint
);