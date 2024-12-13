CREATE TABLE household (
                           eircode VARCHAR(10) PRIMARY KEY,
                           number_occupants INT NOT NULL,
                           max_number_occupants INT NOT NULL,
                           owner_occupied BOOLEAN NOT NULL
);

-- Create the pet table with a foreign key reference to household
CREATE TABLE pet (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(50) NOT NULL,
                     animal_type VARCHAR(30) NOT NULL,
                     breed VARCHAR(30) NOT NULL,
                     age INT NOT NULL,
                     household_eircode VARCHAR(10),
                     FOREIGN KEY (household_eircode) REFERENCES household(eircode)
);

CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       unlocked BOOLEAN NOT NULL
);

create table authorities (
                             username varchar_ignorecase(50) not null,
                             authority varchar_ignorecase(50) not null,
                             constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username,authority);