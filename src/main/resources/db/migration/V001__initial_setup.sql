-- Create Customer Table
CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    created_date TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP,
    created_by BIGINT NOT NULL,
    last_modified_by BIGINT,
    is_active BOOLEAN DEFAULT TRUE,
    name VARCHAR(255) NOT NULL
);

-- Create WishlistItem Table
CREATE TABLE wishlist_items (
    id SERIAL PRIMARY KEY,
    created_date TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP,
    created_by BIGINT NOT NULL,
    last_modified_by BIGINT,
    is_active BOOLEAN DEFAULT TRUE,
    name VARCHAR(255) NOT NULL,
    customer_id BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- Create Item Table
CREATE TABLE items (
    id SERIAL PRIMARY KEY,
    created_date TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP,
    created_by BIGINT NOT NULL,
    last_modified_by BIGINT,
    is_active BOOLEAN DEFAULT TRUE,
    name VARCHAR(255) NOT NULL
);

-- Create Sale Table with Customer Reference
CREATE TABLE sales (
    id SERIAL PRIMARY KEY,
    created_date TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP,
    created_by BIGINT NOT NULL,
    last_modified_by BIGINT,
    is_active BOOLEAN DEFAULT TRUE,
    sale_date DATE NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    item_id BIGINT,
    customer_id BIGINT,
    FOREIGN KEY (item_id) REFERENCES items(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- Insert initial data into Customer
INSERT INTO customers (created_date, last_modified_date, created_by, last_modified_by, is_active, name) VALUES
(NOW(), NOW(), 1, 1, TRUE, 'Customer 1'),
(NOW(), NOW(), 1, 1, TRUE, 'Customer 2'),
(NOW(), NOW(), 1, 1, TRUE, 'Customer 3'),
(NOW(), NOW(), 1, 1, TRUE, 'Customer 4'),
(NOW(), NOW(), 1, 1, TRUE, 'Customer 5'),
(NOW(), NOW(), 1, 1, TRUE, 'Customer 6'),
(NOW(), NOW(), 1, 1, TRUE, 'Customer 7'),
(NOW(), NOW(), 1, 1, TRUE, 'Customer 8'),
(NOW(), NOW(), 1, 1, TRUE, 'Customer 9'),
(NOW(), NOW(), 1, 1, TRUE, 'Customer 10');

-- Insert initial data into Item
INSERT INTO items (created_date, last_modified_date, created_by, last_modified_by, is_active, name) VALUES
(NOW(), NOW(), 1, 1, TRUE, 'Item 1'),
(NOW(), NOW(), 1, 1, TRUE, 'Item 2'),
(NOW(), NOW(), 1, 1, TRUE, 'Item 3'),
(NOW(), NOW(), 1, 1, TRUE, 'Item 4'),
(NOW(), NOW(), 1, 1, TRUE, 'Item 5'),
(NOW(), NOW(), 1, 1, TRUE, 'Item 6'),
(NOW(), NOW(), 1, 1, TRUE, 'Item 7'),
(NOW(), NOW(), 1, 1, TRUE, 'Item 8'),
(NOW(), NOW(), 1, 1, TRUE, 'Item 9'),
(NOW(), NOW(), 1, 1, TRUE, 'Item 10');

-- Insert initial data into WishlistItem
INSERT INTO wishlist_items (created_date, last_modified_date, created_by, last_modified_by, is_active, name, customer_id) VALUES
(NOW(), NOW(), 1, 1, TRUE, 'Wishlist Item 1', 1),
(NOW(), NOW(), 1, 1, TRUE, 'Wishlist Item 2', 2),
(NOW(), NOW(), 1, 1, TRUE, 'Wishlist Item 3', 3),
(NOW(), NOW(), 1, 1, TRUE, 'Wishlist Item 4', 4),
(NOW(), NOW(), 1, 1, TRUE, 'Wishlist Item 5', 5),
(NOW(), NOW(), 1, 1, TRUE, 'Wishlist Item 6', 6),
(NOW(), NOW(), 1, 1, TRUE, 'Wishlist Item 7', 7),
(NOW(), NOW(), 1, 1, TRUE, 'Wishlist Item 8', 8),
(NOW(), NOW(), 1, 1, TRUE, 'Wishlist Item 9', 9),
(NOW(), NOW(), 1, 1, TRUE, 'Wishlist Item 10', 10);

-- Insert initial data into Sale
INSERT INTO sales (created_date, last_modified_date, created_by, last_modified_by, is_active, sale_date, amount, item_id, customer_id) VALUES
(NOW(), NOW(), 1, 1, TRUE, CURRENT_DATE, 100.0, 1, 1),
(NOW(), NOW(), 1, 1, TRUE, CURRENT_DATE, 200.0, 2, 2),
(NOW(), NOW(), 1, 1, TRUE, CURRENT_DATE, 150.0, 3, 3),
(NOW(), NOW(), 1, 1, TRUE, CURRENT_DATE, 250.0, 4, 4),
(NOW(), NOW(), 1, 1, TRUE, CURRENT_DATE, 300.0, 5, 5),
(NOW(), NOW(), 1, 1, TRUE, CURRENT_DATE, 350.0, 6, 6),
(NOW(), NOW(), 1, 1, TRUE, CURRENT_DATE, 400.0, 7, 7),
(NOW(), NOW(), 1, 1, TRUE, CURRENT_DATE, 450.0, 8, 8),
(NOW(), NOW(), 1, 1, TRUE, CURRENT_DATE, 500.0, 9, 9),
(NOW(), NOW(), 1, 1, TRUE, CURRENT_DATE, 550.0, 10, 10);
