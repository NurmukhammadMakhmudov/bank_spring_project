-- Employees Table
--
-- insert into employees (id, first_name, last_name, position)
-- values (1, 'Lise', 'Hevner', 'Dental Hygienist');
-- insert into employees (id, first_name, last_name, position)
-- values (2, 'Chancey', 'Ales0', 'Statistician II');
-- insert into employees (id, first_name, last_name, position)
-- values (3, 'Early', 'Rey', 'Web Designer II');
--
--
-- -- Interns Table
--
-- insert into interns (id, first_name, last_name, date_of_birth, hobby)
-- values (4, 'Karmen', 'Hoodspeth', '1997-04-28 04:32:17', 'convallis morbi');
-- insert into interns (id, first_name, last_name, date_of_birth, hobby)
-- values (5, 'Torre', 'Leaburn', '1994-07-10 04:02:33', 'faucibus orci');
-- insert into interns (id, first_name, last_name, date_of_birth, hobby)
-- values (6, 'Christyna', 'Poter', '1991-12-29 00:00:39', 'nullam');
--
--

-- -- Card Info Table

insert into card_info (id, email, bank_account_number, full_name, card_number, creation_date, date_of_expiration, cvv,phone_number)
values (1, 'Admin@admin.com', '11111111111110000001', 'Admin Adminov', '86004903123123','2022-07-07','2022-07-07','123', '998933396677' );
--
-- insert into card_info (id, email, bank_account_number, full_name, card_number, creation_date, date_of_expiration, cvv,phone_number)
-- values (2, 'Admin@admin2.com', '11111111111110000002', 'Admin Adminov', '86004903123124','2022-07-07','2022-07-07','123', '998933396677' );

insert  into account(id, cash, bank_account_number)
values (1, 36000, '11111111111110000001');


-- Users table failed_attempts INT2 DEFAULT 0,
--     lock_time

insert into users (id, role_name, first_name, last_name, email, pass_word, isactive,  failed_attempts, lock_time)
values (1, 'ADMIN', 'Admin', 'Adminov', 'Admin@admin.com', '$2a$12$pIu9w4w0d0XDL9ZLShbbAOrpfzgrAUEpLMf.GxbNLYzTfn669.1Bm',  true, 0, null);
-- insert into users (id, role_name, first_name, last_name, email, pass_word, isactive,  failed_attempts, lock_time))
-- values (12, 'USER', 'Manager', 'Managerov', 'Manager@manager.com', '$2a$12$A0SJ.QxAPdg/nmEdAmk4F.Jzoe/ZMoAU3drlLQkH7GwchJIhWC.ka', false, 1112233345550000002, 0, null);
-- insert into users (id, role_name, first_name, last_name, email, pass_word, isactive,  failed_attempts, lock_time))
-- values (13, 3, 'Mentor', 'Mentorov', 'Mentor@mentorov.com', '$2a$12$8FR0VOgKXevk3D5CCvBs8uYSp6NQ6kI6FW2s5N9dTjAKlfPOMLfY.', false, 1112233345550000003, 0, null);

