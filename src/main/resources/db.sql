

delete from roles;
delete from users;

INSERT INTO users (id,dob,email,name,password) VALUES 
 (1,NULL,'admin@gmail.com','Administrator','admin'),
 (2,NULL,'siva@gmail.com','Siva','siva');

INSERT INTO roles (role_id,role_name,user_id) VALUES 
 (1,'ROLE_ADMIN',1),
 (2,'ROLE_USER',1),
 (3,'ROLE_USER',2);


INSERT INTO `topics` (`name`) VALUES ('Apple'); 
INSERT INTO `topics` (`name`) VALUES ('Jared Allen'); 
INSERT INTO `topics` (`name`) VALUES ('Bin Laden');
INSERT INTO `topics` (`name`) VALUES ('Eyedea'); 
INSERT INTO `topics` (`name`) VALUES ('Herman Cain'); 
INSERT INTO `topics` (`name`) VALUES ('Diddy Dirty Money');
INSERT INTO `topics` (`name`) VALUES ('Green Bay'); 
INSERT INTO `topics` (`name`) VALUES ('Sidney Poitier');
INSERT INTO `topics` (`name`) VALUES ('The Dark Knight');
INSERT INTO `topics` (`name`) VALUES ('Black Friday'); 
INSERT INTO `topics` (`name`) VALUES ('Amazing Grace'); 
INSERT INTO `topics` (`name`) VALUES ('Fox News Channel');
INSERT INTO `topics` (`name`) VALUES ('Bloom Box'); 
INSERT INTO `topics` (`name`) VALUES ('Aretha Franklin'); 
INSERT INTO `topics` (`name`) VALUES ('Sugarloaf Mountain');
INSERT INTO `topics` (`name`) VALUES ('Bill T Jones'); 
INSERT INTO `topics` (`name`) VALUES ('Anjelah Johnson'); 
INSERT INTO `topics` (`name`) VALUES ('Teddy Pendergrass');
INSERT INTO `topics` (`name`) VALUES ('Total Eclipse'); 
INSERT INTO `topics` (`name`) VALUES ('Russian National Anthem');
INSERT INTO `topics` (`name`) VALUES ('Merle Haggard'); 
INSERT INTO `topics` (`name`) VALUES ('Giants Stadium Demolition');
INSERT INTO `topics` (`name`) VALUES ('Family Watch Dog Sue Sylvester Vogue');
INSERT INTO `topics` (`name`) VALUES ('New York Giants');
INSERT INTO `topics` (`name`) VALUES ('National Economic Council');
INSERT INTO `topics` (`name`) VALUES ('Victoria Beckham');
INSERT INTO `topics` (`name`) VALUES ('Kennedy Center Honors');
INSERT INTO `topics` (`name`) VALUES ('Pro Bowl');
INSERT INTO `topics` (`name`) VALUES ('West Memphis Three');