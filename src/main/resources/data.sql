DROP TABLE user_role;
DROP TABLE user;
DROP TABLE role;
DROP TABLE banner;

CREATE TABLE IF NOT EXISTS role (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role varchar(255) DEFAULT NULL,
  PRIMARY KEY (role_id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS user (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  active int(11) DEFAULT NULL,
  user_type_id TINYINT(1) DEFAULT NULL,
  social_media_id varchar(255) DEFAULT NULL,
  user_image_url varchar(255) DEFAULT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS user_role (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  KEY `FKa68196081fvovjhkek5m97n3y` (role_id),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (user_id) REFERENCES user (user_id),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (role_id) REFERENCES role (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS banner (
  banner_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  data varchar(10000) NOT NULL,
  PRIMARY KEY (banner_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT IGNORE INTO role VALUES (1, 'USER');
INSERT IGNORE INTO role VALUES (2, 'SUPERVISOR');
INSERT IGNORE INTO role VALUES (3, 'ADMIN');
INSERT IGNORE INTO role VALUES (4, 'FACEBOOK_USER');
INSERT IGNORE INTO role VALUES (5, 'GOOGLE_USER');

INSERT IGNORE INTO banner(name, data) VALUES ('afterLogin', '<h4 class="display-inline">You are currently logged as </h4>
${username}<h4 class="display-inline">! It\'s nice to see you.</h4>');
INSERT IGNORE INTO banner(name, data) VALUES ('afterRegistration', '<h4 class="text-center">It\'s cool that you joined us.
</h4><h4 class="display-inline">You are currently logged as </h4>${username}<h4 class="display-inline">!');
