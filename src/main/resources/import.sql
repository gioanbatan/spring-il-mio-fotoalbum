INSERT INTO `users`(`email`, `first_name`, `last_name`, `password`) VALUES('admin@email.it', 'Admin', 'Admin', '{noop}admin');
INSERT INTO `users`(`email`, `first_name`, `last_name`, `password`) VALUES('user@email.it', 'User', 'User','{noop}user');

INSERT INTO `roles`(`id`, `name`) VALUES(1, 'ADMIN');
INSERT INTO `roles`(`id`, `name`) VALUES(2, 'USER');

INSERT into `users_roles`(`user_id`, `roles_id`) VALUES(1, 1);
INSERT into `users_roles`(`user_id`, `roles_id`) VALUES(2, 2);