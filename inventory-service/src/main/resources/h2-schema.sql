CREATE TABLE IF NOT EXISTS part (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    available_qty BIGINT NOT NULL,
    min_order_qty BIGINT NOT NULL,
    threshold DOUBLE NOT NULL,
    supplier VARCHAR(255)
);

INSERT INTO part (name, available_qty, min_order_qty, threshold, supplier) VALUES
('Brake Pads (Front)', 50, 20, 10.0, 'SUPPLIER_A'),
('Brake Discs (Front)', 30, 10, 5.0, 'SUPPLIER_B'),
('Air Filter', 100, 50, 25.0, 'SUPPLIER_A'),
('Oil Filter', 75, 25, 15.0, 'SUPPLIER_B'),
('Spark Plugs (Set of 4)', 40, 10, 8.0, 'SUPPLIER_A'),
('Headlight Bulb (H4)', 60, 20, 12.0, 'SUPPLIER_B'),
('Tail Light Bulb', 80, 30, 15.0, 'SUPPLIER_A'),
('Battery (12V)', 20, 5, 3.0, 'SUPPLIER_B'),
('Wiper Blades (Set of 2)', 90, 40, 20.0, 'SUPPLIER_A'),
('Engine Oil (5W-30)', 120, 60, 30.0, 'SUPPLIER_B'),
('Timing Belt', 15, 5, 2.0, 'SUPPLIER_B'),
('Coolant (1 Gallon)', 100, 50, 25.0, 'SUPPLIER_A'),
('Alternator', 8, 2, 1.0, 'SUPPLIER_B'),
('Starter Motor', 5, 1, 0.5, 'SUPPLIER_B'),
('Clutch Kit', 12, 3, 1.5, 'SUPPLIER_A');