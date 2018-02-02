DROP DATABASE IF EXISTS ee_web_site;
CREATE DATABASE IF NOT EXISTS ee_web_site DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE ee_web_site;


DROP TABLE IF EXISTS t_comments;
CREATE TABLE t_comments (
  F_ID bigint(20) NOT NULL,
  F_MESSAGE text NOT NULL,
  F_USER_ID bigint(20) NOT NULL,
  F_NEWS_ID bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO t_comments (F_ID, F_MESSAGE, F_USER_ID, F_NEWS_ID) VALUES
(1, 'Ох как давно я этого ждал! Спасибо вам!', 3, 2),
(2, 'Каждый день заглядываю к вам, чтобы чисто поржать. Иногда нет-нет да не удержусь и куплю что-нибудь. Как, например, вчера, купил бетонный рояль, очень доволен. До сих пор не знаю, как его домой на 12 этаж поднять. Вы лучшие!  ', 3, 1),
(3, 'Спасибо Лучистый, всегда приятно читать такие отзывы! Но нас они, конечно, ещё и мотивируют на расширение товарного ассортимента. Стараемся для вас!', 1, 1);


DROP TABLE IF EXISTS t_feedback;
CREATE TABLE t_feedback (
  F_ID bigint(20) NOT NULL,
  F_MESSAGE text NOT NULL,
  F_EMAIL varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS t_news;
CREATE TABLE t_news (
  F_ID bigint(20) NOT NULL,
  F_DATE date NOT NULL,
  F_TITLE varchar(255) NOT NULL,
  F_BODY text NOT NULL,
  F_PHOTO_URI varchar(255) NOT NULL,
  F_USER_ID bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_news (F_ID, F_DATE, F_TITLE, F_BODY, F_PHOTO_URI, F_USER_ID) VALUES
(1, '2017-12-31', 'С наступающим новым годом!', 'Поздравляем всех наших клиентом с приближающимся праздником. В новом году желаем вам, конечно, денег побольше, и желания их тратить у нас в магазине! Спасибо, что остаётесь с вами, а мы постараемся радовать вас в новом году ещё более дурацкими товарами. ', '2017/12/31/hny_1516564987754.jpg', 1),
(2, '2018-01-22', 'Новое поступление!', 'Скорее в каталог. Новые, абсолютно уникальные, бесполезные, вызывающие беспричинный восторг товары уже ждут вас там. ', '2018/01/22/newItems_1516565046265.png', 2);

DROP TABLE IF EXISTS t_orders;
CREATE TABLE t_orders (
  F_ID bigint(20) NOT NULL,
  F_USER_ID bigint(20) NOT NULL,
  F_STATUS enum('NEW','REVIEWING','IN_PROGRESS','DELIVERED') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_orders (F_ID, F_USER_ID, F_STATUS) VALUES
(9, 3, 'REVIEWING'),
(16, 3, 'NEW'),
(89, 3, 'NEW');

DROP TABLE IF EXISTS t_order_positions;
CREATE TABLE t_order_positions (
  F_ID bigint(20) NOT NULL,
  F_ORDER_ID bigint(20) NOT NULL,
  F_PRODUCT_ID bigint(20) NOT NULL,
  F_COUNT int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_order_positions (F_ID, F_ORDER_ID, F_PRODUCT_ID, F_COUNT) VALUES
(8, 9, 3, 1),
(9, 9, 1, 1),
(10, 9, 2, 1),
(19, 16, 5, 1),
(20, 16, 11, 5),
(21, 16, 4, 1),
(22, 16, 8, 1),
(99, 89, 334, 2),
(100, 89, 11, 2);

DROP TABLE IF EXISTS t_products;
CREATE TABLE t_products (
  F_ID bigint(20) NOT NULL,
  F_PRICE decimal(10,2) NOT NULL,
  F_DESCRIPTION text NOT NULL,
  F_NAME varchar(255) NOT NULL,
  f_image_uri varchar(255) NOT NULL DEFAULT 'default.png',
  F_IS_ACTIVE tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_products (F_ID, F_PRICE, F_DESCRIPTION, F_NAME, f_image_uri, F_IS_ACTIVE) VALUES
(1, '199.50', 'Шкаф антикварный защитит вашу квартиру от любых типов квар. Прекрасно справляется с хранением пыли и некоторых других предметов.', 'Шкаф антикварный', 'default.png', 1),
(2, '99.00', 'Украсит ваш словарный запас. Позволит произвести впечатление на людей не живших в прошлом веке. Ну и просто полезная штука ', 'Трюмо', 'default.png', 1),
(3, '59.00', 'Специальный набор действий, который позволяет любому человеку стать столиком. Незаменимый предмет для любого Анатолия, находящегося в окружении симпатичных девушек.', 'Стол складной, воображаемый', 'default.png', 1),
(4, '599.49', 'Полноразмерная копия рояля, отлитая из особо прочного бетона с железной арматурой. Идеально подходит для людей, ищущих достойные трудности в жизни.', 'Рояль (бетон, РБ)', 'default.png', 1),
(5, '149.00', 'Многофункциональное существо найдёт применение в любой квартире или доме. В основном находится в состоянии суперпозиции (если вы смотрите на неё, то она спит. А если не смотрите, то либо спит, либо разрушает всё вокруг). Легко терпит приставания детей (пока смотрите). Приятная на ощупь и вообще.', 'Собака Хаски (в аренду на сутки)', 'default.png', 1),
(6, '19.00', 'Дисковый телефон поможет объяснить вашим детям, что цифры - это не магические константы, а вполне связанные с миром сущности. Успокаивающе воздействует на психику взрослых. Развивает мелкую моторику и чувство стиля в инженерных решениях.', 'Бабушкин дисковый телефон', 'default.png', 1),
(7, '49.89', 'Говорят, что знакомить детей со смертью - это задача хомячков. Однако есть куда более щадящий способ - это рыбки. Рыбок много, они постоянно дохнут, они тупые. Всё это в значительно более лёгкой форме показывает ребёнку сложности реальной жизни. А потом уже и хомячка можно! ', 'Аквариум с рыбками', 'default.png', 1),
(8, '75.00', 'Уницикл - это одноколёсный велосипед. Почему это круто? А ведь это такой же статусный аксессуар, как лонгборд или гироскутер. Однако отличается тем, что на нём решительно невозможно ездить без подготовки, а если получится, вы будете выглядеть как цирковой артист во время представления. Иначе говоря, никому и в голову не придёт, что вы слепо следуете трендам или копируете знаменитостей. Наоборот, люди будут чувствовать в вас дух первопроходца, дух трендсеттера!', 'Уницикл', 'default.png', 1),
(9, '18.05', 'Точно так же как тактический браслет - незаменимый аксессуар для современного мужчины, готового решить любой вопрос, так же бабушкин платок - незаменимый аксессуар для девушки, способной красиво выйти из любого положения. Инструкция на 350 вариантов применения платка идёт в комплекте.', 'Бабушкин платок', 'default.png', 1),
(10, '69.00', 'Хит сезона! Просто табуретка!', 'Табуретка', 'default.png', 1),
(11, '27.00', 'Носочки дырявенькие от бабули.', 'Носочки', 'default.png', 1),
(98, '26.00', 'Фу-фу-фу, этот товар удалёт', 'удалённый товар', 'default.png', 0),
(334, '250.00', 'Ценный значок с самой вершины Чанчахи!', 'Значок', '2018/02/02/0_1517599623827.jpg', 0);

DROP TABLE IF EXISTS t_users;
CREATE TABLE t_users (
  F_ID bigint(20) NOT NULL,
  F_FULL_NAME varchar(255) NOT NULL,
  F_ROLE enum('ROLE_USER','ROLE_ADMIN','ROLE_SUPERADMIN') NOT NULL,
  F_EMAIL varchar(255) NOT NULL,
  F_PHONE varchar(255) NOT NULL,
  F_ADDRESS varchar(255) NOT NULL,
  F_PASSWORD varchar(255) NOT NULL,
  F_IS_ACTIVE tinyint(1) NOT NULL,
  F_ADDITIONAL_INFO varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_users (F_ID, F_FULL_NAME, F_ROLE, F_EMAIL, F_PHONE, F_ADDRESS, F_PASSWORD, F_IS_ACTIVE, F_ADDITIONAL_INFO) VALUES
(1, 'Администратор Всесильный', 'ROLE_SUPERADMIN', 'super@super.com', '+375(29)111-11-11', 'адрес', '$2a$10$3zYf3xcup39l.dJk8CSDoOncBPicAaevVmkHN2mrBdAISEgYkGZsu', 1, ''),
(2, 'Василий Плечистый', 'ROLE_ADMIN', 'admin@admin.com', '375(29)123-45-67', 'vasili address ', '$2a$10$b9N3NwuDlxbe3kpLUOn9.OJCzXUxo97z599k6hmKV.rrljbaQY7L6', 1, ''),
(3, 'Пользователь Лучистый', 'ROLE_USER', 'user@user.com', '+375(33)123-45-67', 'user address', '$2a$10$jgvKKrBF.lf3Q0GPxUzoV.wi/HaZqDhi8eOY/5u7CoA.FJ7qn.jNm', 1, '');

ALTER TABLE t_comments
  ADD PRIMARY KEY (F_ID),
  ADD KEY F_USER_ID (F_USER_ID),
  ADD KEY F_NEWS_ID (F_NEWS_ID);

ALTER TABLE t_feedback
  ADD PRIMARY KEY (F_ID);

ALTER TABLE t_news
  ADD PRIMARY KEY (F_ID),
  ADD KEY F_USER_ID (F_USER_ID);

ALTER TABLE t_orders
  ADD PRIMARY KEY (F_ID),
  ADD KEY F_USER_ID (F_USER_ID);

ALTER TABLE t_order_positions
  ADD PRIMARY KEY (F_ID),
  ADD KEY F_ORDER_ID (F_ORDER_ID),
  ADD KEY F_PRODUCT_ID (F_PRODUCT_ID);

ALTER TABLE t_products
  ADD PRIMARY KEY (F_ID);

ALTER TABLE t_users
  ADD PRIMARY KEY (F_ID);

ALTER TABLE t_comments
  MODIFY F_ID bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE t_feedback
  MODIFY F_ID bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE t_news
  MODIFY F_ID bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE t_orders
  MODIFY F_ID bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

ALTER TABLE t_order_positions
  MODIFY F_ID bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

ALTER TABLE t_products
  MODIFY F_ID bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=345;

ALTER TABLE t_users
  MODIFY F_ID bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;

ALTER TABLE t_comments
  ADD CONSTRAINT t_comments_ibfk_1 FOREIGN KEY (F_USER_ID) REFERENCES t_users (F_ID) ON DELETE CASCADE,
  ADD CONSTRAINT t_comments_ibfk_2 FOREIGN KEY (F_NEWS_ID) REFERENCES t_news (F_ID) ON DELETE CASCADE;

ALTER TABLE t_news
  ADD CONSTRAINT t_news_ibfk_1 FOREIGN KEY (F_USER_ID) REFERENCES t_users (F_ID) ON DELETE CASCADE;

ALTER TABLE t_orders
  ADD CONSTRAINT t_orders_ibfk_1 FOREIGN KEY (F_USER_ID) REFERENCES t_users (F_ID) ON DELETE CASCADE;

ALTER TABLE t_order_positions
  ADD CONSTRAINT t_order_positions_ibfk_1 FOREIGN KEY (F_ORDER_ID) REFERENCES t_orders (F_ID) ON DELETE CASCADE,
  ADD CONSTRAINT t_order_positions_ibfk_2 FOREIGN KEY (F_PRODUCT_ID) REFERENCES t_products (F_ID) ON DELETE CASCADE;

