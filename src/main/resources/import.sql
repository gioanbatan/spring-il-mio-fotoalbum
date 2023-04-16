INSERT INTO `users`(`email`, `first_name`, `last_name`, `password`) VALUES('admin@email.it', 'Admin', 'Admin', '{noop}admin');
INSERT INTO `users`(`email`, `first_name`, `last_name`, `password`) VALUES('user@email.it', 'User', 'User','{noop}user');

INSERT INTO `roles`(`id`, `name`) VALUES(1, 'ADMIN');
INSERT INTO `roles`(`id`, `name`) VALUES(2, 'USER');

INSERT into `users_roles`(`user_id`, `roles_id`) VALUES(1, 1);
INSERT into `users_roles`(`user_id`, `roles_id`) VALUES(2, 2);

INSERT INTO `photos`(`title`, `description`, `url`, `visible`) VALUES('prima', 'lorem ipsum', '/images/img_1.jpg', true);
INSERT INTO `photos`(`title`, `description`, `url`, `visible`) VALUES('seconda', 'quisquam sed totam voluptate, voluptatibus. Dolore eos ut vel.', '/images/img_2.jpg', true);
INSERT INTO `photos`(`title`, `description`, `url`, `visible`) VALUES('terza', 'distinctio eos eum illo ipsum molestiae nam natus nulla porro quam', '/images/img_3.jpg', true);
INSERT INTO `photos`(`title`, `description`, `url`, `visible`) VALUES('quarta', 'ipsum dolor sit amet, consectetur adipisicing elit', '/images/img_4.jpg', true);
INSERT INTO `photos`(`title`, `description`, `url`, `visible`) VALUES('quinta', 'Lorem Architecto aut', '/images/img_5.jpg', true);
INSERT INTO `photos`(`title`, `description`, `url`, `visible`) VALUES('sesta', 'lorem ipsum', '/images/img_6.jpg', true);
INSERT INTO `photos`(`title`, `description`, `url`, `visible`) VALUES('settima', 'quisquam sed totam voluptate, voluptatibus. Dolore eos ut vel.', '/images/img_7.jpg', true);
INSERT INTO `photos`(`title`, `description`, `url`, `visible`) VALUES('ottava', 'distinctio eos eum illo ipsum molestiae nam natus nulla porro quam', '/images/img_8.jpg', true);
INSERT INTO `photos`(`title`, `description`, `url`, `visible`) VALUES('nona', 'ipsum dolor sit amet, consectetur adipisicing elit', '/images/img_9.jpg', true);

INSERT INTO `categories`(`name`) VALUES('B-W');
INSERT INTO `categories`(`name`) VALUES('Potrait');
INSERT INTO `categories`(`name`) VALUES('Urbex');
INSERT INTO `categories`(`name`) VALUES('Landscape');
INSERT INTO `categories`(`name`) VALUES('Street');
INSERT INTO `categories`(`name`) VALUES('Macro');
INSERT INTO `categories`(`name`) VALUES('Fashion');
INSERT INTO `categories`(`name`) VALUES('Food');