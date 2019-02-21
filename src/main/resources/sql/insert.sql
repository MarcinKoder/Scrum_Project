INSERT INTO `day_name` (`id`, `name`, `order`) VALUES
(1, 'poniedziałek', 1),
(2, 'wtorek', 2),
(3, 'środa', 3),
(4, 'czwartek', 4),
(5, 'piątek', 5),
(6, 'sobota', 6),
(7, 'niedziela', 7);

INSERT INTO `admins` (`id`, `first_name`, `last_name`, `email`, `password`, `superadmin`) VALUES
(1, 'Arek', 'Józwiak', 'arkadiusz.jozwiak@coderslab.pl', '123qwe', 1);

INSERT INTO `plan` (`id`, `name`, `description`, `created`, `admin_id`) VALUES
(1, 'Plan Jarski', NULL, '2018-10-17 14:27:05', 1);

INSERT INTO `recipe` (`id`, `name`, `ingredients`, `description`, `created`, `updated`, `admin_id`, `preparation_time`, `preparation`) VALUES
(1, 'Przepis 1', 'sałata', 'Opis przepisu 1', '2018-10-17 00:00:00', '2018-10-17 14:24:44', 1, 30,'Sałaty dokładnie myję i jeszcze dokładniej suszę - nie powinno być na liściach żadnych kropelek wody.'),
(2, 'Przepis 2', 'sałata', 'Opis przepisu 2', '2018-10-16 00:00:00', '2018-10-17 14:24:44', 1, 30,'Sałaty dokładnie myję i jeszcze dokładniej suszę - nie powinno być na liściach żadnych kropelek wody.'),
(3, 'Przepis 3', 'sałata', 'Opis przepisu 3', '2018-10-24 00:00:00', '2018-10-17 14:24:44', 1, 30,'Sałaty dokładnie myję i jeszcze dokładniej suszę - nie powinno być na liściach żadnych kropelek wody.');

INSERT INTO `recipe_plan` (`id`, `recipe_id`,  `meal_name`, `order`, `day_name_id`, `plan_id`) VALUES
(1, 1,  'Kolacja', 2, 2, 1),
(2, 2,  'Śniadanie', 1, 1, 1),
(3, 1,  'Kolacja', 2, 1, 1),
(4, 3,  'Śniadanie', 1, 2, 1);