drop table if exists stores_t;

create table stores_t (
id serial primary key,
name varchar(50) not null,
address varchar(50) not null,
phone_number varchar(50) not null,
email varchar(50) not null,
website varchar(50),
category varchar(30) not null
check (
    category = 'Продовольственный'
    or category = 'Хозяйственный'
    or category = 'Спортивный'
),
note varchar(400)
);


insert into stores_t (name, address, phone_number, email, website, category, note)
values
('Спортмастер', 'ул. Печкина 13', '76-30-30', 'sportmaster@mail.ru', 'https://www.sportmaster.ru/', 'Спортивный', 'Спортмастер — это доступ в мир спорта с рекордным ассортиментом! Это настоящий бренд-эксперт в спорте и активном отдыхе, который вдохновляет своих покупателей, мотивирует их и помогает регулярно заниматься спортом, чтобы радоваться жизни и менять себя к лучшему день за днем!'),
('Магнит', 'ул. Магазинная 24а', '76-95-95', 'magnit@mail.ru', 'https://magnit.ru/', 'Продовольственный', '«Магнит» — это розничная сеть, которая работает как в крупных городах, так и в небольших населённых пунктах. Группа компаний «Магнит» управляет собственной логистической системой и автопарком и является крупнейшим частным работодателем в России.'),
('Leroy Merlin', 'ул. Кутузова 94', '76-88-88', 'leroymerlin@gmail.com', 'https://www.leroymerlin.com/', 'Хозяйственный', 'Leroy Merlin - французская компания, одна из крупнейших европейских сетей хозяйственных магазинов. Основана в 1923 году, входит в группу Adeo, которая принадлежит "Ассоциации семьи Мюлье"');