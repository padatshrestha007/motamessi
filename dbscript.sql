CREATE TABLE `motamessi`.`player` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(250) NOT NULL,
  `last_name` VARCHAR(250) NOT NULL,
  `email` VARCHAR(250) NULL,
  `cell` VARCHAR(25) NULL,
  `age` INT NOT NULL,
  `gender` CHAR(1) NOT NULL DEFAULT 'u',
  PRIMARY KEY (`id`));
