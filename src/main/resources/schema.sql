

DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;


CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  dob datetime DEFAULT NULL,
  email varchar(255) NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname  VARCHAR(50) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_email (email)
);

CREATE TABLE roles (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(255) NOT NULL,
  user_id int(11) DEFAULT NULL,
  PRIMARY KEY (role_id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);
CREATE TABLE `topics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

