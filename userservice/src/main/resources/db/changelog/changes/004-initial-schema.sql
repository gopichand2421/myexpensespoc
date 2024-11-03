CREATE TABLE  address (
    id INT AUTO_INCREMENT PRIMARY KEY,          -- Unique identifier for the address
    user_id INT NOT NULL,                   -- Foreign key to users table
    street VARCHAR(100) NOT NULL,              -- Street address
    city VARCHAR(50) NOT NULL,                 -- City
    state VARCHAR(50) NOT NULL,                -- State
    postal_code VARCHAR(20) NOT NULL,          -- Postal code
    zip_code VARCHAR(8) NOT NULL,
    country VARCHAR(50) NOT NULL,              -- Country
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Record creation timestamp
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Record update timestamp
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE -- Foreign key constraint
);