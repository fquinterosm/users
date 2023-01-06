INSERT INTO USERS (ID, NAME, EMAIL, PASSWORD, CREATED, MODIFIED, LAST_LOGIN, IS_ACTIVE) VALUES ('0355b01d-9423-4191-ae1a-4a1d8c758f0d', 'Francisco Quinteros', 'admin@admin.com', 'password', '2023-01-01', '2023-01-01', '2023-01-01', true);
INSERT INTO CUSTOM_VALIDATION (NAME,PATTERN, MESSAGE) VALUES ('email', '[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$', 'invalid email');
INSERT INTO CUSTOM_VALIDATION (NAME,PATTERN, MESSAGE) VALUES ('password', '(?=^.{6,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[a-z]).*$', 'The password must be greater than 6 characters and with numbers');