SET NAMES UTF8;

CREATE TABLE user (
  `id`            INT PRIMARY KEY AUTO_INCREMENT,
  `username`      VARCHAR(16) NOT NULL,
  `phone`         VARCHAR(20),
  `email`         VARCHAR(64),
  `create_time`   TIMESTAMP       DEFAULT CURRENT_TIMESTAMP,
  `last_login_time` TIMESTAMP NULL ,
  UNIQUE KEY (`username`),
  KEY (`phone`),
  KEY (`email`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO `user` (`username`, `phone`, `email`) VALUES ('ed', '13800138001', 'ed@bk.com');
INSERT INTO `user` (`username`, `phone`, `email`) VALUES ('stark', '13800138002', 'stark@bk.com');
INSERT INTO `user` (`username`, `phone`, `email`) VALUES ('snow', '13800138003', 'snow@bk.com');