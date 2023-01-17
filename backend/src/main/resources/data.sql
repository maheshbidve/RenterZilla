INSERT INTO renterZilla.property (property_id, type, city, pincode, address, available) VALUES (1, '1 BHK', 'Pune', 411011, 'Near Mall 1', true);
INSERT INTO renterZilla.property (property_id, type, city, pincode, address, available) VALUES (2, '2 BHK', 'Pune', 411027, 'Near Mall 2', false);
INSERT INTO renterZilla.property (property_id, type, city, pincode, address, available) VALUES (3, '3 BHK', 'Mumbai', 421306, 'Near Mall 3', true);
INSERT INTO renterZilla.property (property_id, type, city, pincode, address, available) VALUES (4, 'Studio',' Delhi', 110233, 'Near Mall 4', true);
INSERT INTO renterZilla.property (property_id, type, city, pincode, address, available) VALUES (5, 'Villa', 'Latur', 413510, 'Near Mall 5', false);

INSERT INTO renterZilla.roles(id, name) VALUES(1, 'ROLE_ADMIN');
INSERT INTO renterZilla.roles(id, name) VALUES(2, 'ROLE_TENANT');
INSERT INTO renterZilla.roles(id, name) VALUES(3, 'ROLE_OWNER');
INSERT INTO renterZilla.roles(id, name) VALUES(4, 'ROLE_BROKER');


INSERT INTO users(user_id, username, email, password) VALUES(1, 'Admin', 'admin@user.com', '$2a$10$zrXbTIf/.cyjBYCxwIsbqOvObemZxeRbCKx2MoUi5zLi5OqnbHo9K'); --admin123
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
