CREATE TABLE IF NOT EXISTS person2 (
	id serial primary key not null,
	email varchar(100) unique not null,
	first_name varchar not null,
	last_name varchar not null,
    login varchar not null,
	password varchar(60) not null,
	role varchar(60) not null,
	status varchar(60) not null
);
CREATE TABLE IF NOT EXISTS publishing_house(
	id serial primary key not null,
	title_publishing varchar not null,
	amount integer,
	external_key integer not null,
	url varchar not null

);
CREATE TABLE IF NOT EXISTS books(
	id serial  primary key not null,
	url_image varchar not null,
	count integer not null,
	external_id_publishing integer not null ,
	name_book varchar not null,
	price integer not null

);
CREATE TABLE IF NOT EXISTS basket(
        id serial  primary key not null,
        count integer not null,
        externa_key integer not null ,
        name_product varchar not null,
        price double precision not null,
        sum_price integer not null

);
INSERT INTO public.books (id, url_image, count, external_id_publishing, name_book, price) VALUES (3, 'https://cv9.litres.ru/pub/c/elektronnaya-kniga/cover_120/66732098-sergey-lukyanenko-mesyac-za-rubikonom.jpg', 1, 3, 'Месяц за Рубиконом', 149);
INSERT INTO public.books (id, url_image, count, external_id_publishing, name_book, price) VALUES (1, 'https://cv2.litres.ru/pub/c/elektronnaya-kniga/cover_200/65843121-elena-saulite-31584588-shveycarskiy-schet.jpg', 1, 3, 'Швейцарский счет', 249);



INSERT INTO public.publishing_house (id, title_publishing, amount, external_key, url) VALUES (1, 'Алтапресс', 3, 1, 'https://sjak.ru/images/news/pic/201911/4898_1.jpeg');
INSERT INTO public.publishing_house (id, title_publishing, amount, external_key, url) VALUES (2, 'Дрофа', 123, 2, 'https://www.syl.ru/misc/i/ai/328096/1887764.jpg');
INSERT INTO public.publishing_house (id, title_publishing, amount, external_key, url) VALUES (3, 'ЛитРес', 15, 3, 'https://www.arsvest.ru/photo/img/2015/image/25012020qnqx97efcopy.jpg');