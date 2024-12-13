INSERT INTO pets (name, animal_type, breed, age, eircode) VALUES ('Buddy', 'Dog', 'Golden Retriever', 3,'A94B6F3' );
INSERT INTO pets (name, animal_type, breed, age, eircode) VALUES ('Mittens', 'Cat', 'Siamese', 2, 'R67CD01');
INSERT INTO pets (name, animal_type, breed, age, eircode) VALUES ('Charlie', 'Dog', 'Beagle', 4, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, eircode) VALUES ('Whiskers', 'Cat', 'Persian', 5, 'P90QR78');
INSERT INTO pets (name, animal_type, breed, age, eircode) VALUES ('Coco', 'Rabbit', 'Holland Lop', 1, 'Z01YZ23');
INSERT INTO pets (name, animal_type, breed, age, eircode) VALUES ('Goldie', 'Fish', 'Goldfish', 1, 'F12GH89');
INSERT INTO pets (name, animal_type, breed, age, eircode) VALUES ('Polly', 'Bird', 'Parakeet', 2,'S23EF45');
INSERT INTO pets (name, animal_type, breed, age, eircode) VALUES ('Max', 'Dog', 'German Shepherd', 5,'V23ST01');
INSERT INTO pets (name, animal_type, breed, age, eircode) VALUES ('Luna', 'Cat', 'Maine Coon', 3,'C15DE67');
INSERT INTO pets (name, animal_type, breed, age, eircode) VALUES ('Nibbles', 'Hamster', 'Syrian Hamster', 1,'X45UV67');


INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied) VALUES
                                                                                                  ('D02XY45', 3, 5, 1),
                                                                                                  ('A94B6F3', 4, 6, 0),
                                                                                                  ('T12AB34', 2, 4, 1),
                                                                                                  ('C15DE67', 5, 7, 1),
                                                                                                  ('F12GH89', 1, 2, 0),
                                                                                                  ('B78IJ01', 3, 5, 1),
                                                                                                  ('M34KL56', 4, 6, 0),
                                                                                                  ('P90QR78', 2, 4, 1),
                                                                                                  ('V23ST01', 5, 7, 1),
                                                                                                  ('X45UV67', 1, 2, 0),
                                                                                                  ('Y67WX89', 3, 5, 1),
                                                                                                  ('Z01YZ23', 4, 6, 0),
                                                                                                  ('Q45AB78', 2, 4, 1),
                                                                                                  ('R67CD01', 5, 7, 1),
                                                                                                  ('S23EF45', 1, 2, 0);
INSERT INTO myusers (username, password, first_name, last_name, role, lockedFlag, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('jack.connor@example.com', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'Jack', 'Connor', 'ROLE_ADMIN', TRUE, TRUE, TRUE,TRUE);

INSERT INTO myusers (email, password, first_name, last_name, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('john.smith@example.com', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'John', 'Smith', 'ROLE_API', TRUE, TRUE, TRUE,TRUE);

INSERT INTO myusers (email, password, first_name, last_name, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('david.tennant@example.com', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'David', 'Tennant', 'ROLE_USER', TRUE, TRUE, TRUE,TRUE);

INSERT INTO myusers (email, password, first_name, last_name, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('matt.smith@example.com', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'Math', 'Smith', 'ROLE_USER', TRUE, TRUE, TRUE,TRUE);

INSERT INTO myusers (email, password, first_name, last_name, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('john.snow@example.com', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'John', 'Snow', 'ROLE_ADMIN', TRUE, TRUE, TRUE,TRUE);