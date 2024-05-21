CREATE DATABASE stockSync;

use stockSync;

select * from clients;

select * from employees;

select * from inventaries;

select * from items;

select * from products;

select * from stores;

select * from invoices;

-- Datos para la tabla 'clients'
INSERT INTO clients (id, document_number, document_type, email, name, phone_number) VALUES
('1', 1234567890, 'CC', 'john.doe@example.com', 'John Doe', '3001234567'),
('2', 2345678901, 'CE', 'jane.smith@example.com', 'Jane Smith', '3102345678'),
('3', 3456789012, 'PA', 'bob.jones@example.com', 'Bob Jones', '3203456789');

-- Datos para la tabla 'stores'
INSERT INTO stores (id, location, name) VALUES
('1', 'Calle 123 #45-67, Ciudad A', 'Tienda A'),
('2', 'Avenida 89 #12-34, Ciudad B', 'Tienda B');

-- Datos para la tabla 'products'
INSERT INTO products (id, color, name, price, size, stock, colum_id) VALUES
(1, 'Red', 'Product A', 10000, 'M', 50, 'bfa620aa-cda4-4d13-9cd9-8a6718c6d069'),
(2, 'Blue', 'Product B', 20000, 'L', 30, 'bfa620aa-cda4-4d13-9cd9-8a6718c6d069'),
(3, 'Green', 'Product C', 15000, 'S', 20, 'bfa620aa-cda4-4d13-9cd9-8a6718c6d069');

-- Datos para la tabla 'employees'
INSERT INTO employees (id, contact, identity, name, colum_id) VALUES
('1', '3011234567', '1234567890', 'Alice Johnson', '1'),
('2', '3022345678', '2345678901', 'Carlos Martínez', '2');

