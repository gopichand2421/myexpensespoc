CREATE TABLE user_role_mapping (
    id INT AUTO_INCREMENT,
    user_id INT,
    role_id INT,
    assigned_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, -- timestamp when role is created
    PRIMARY KEY (user_id, role_id, id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES user_roles(id) ON DELETE CASCADE
);