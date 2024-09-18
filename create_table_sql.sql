drop database jobportal;

create database jobportal;

use jobportal;

CREATE TABLE categories (
    id int primary key auto_increment,
    name varchar(50)
);

CREATE TABLE locations (
    id int primary key auto_increment,
    name varchar(50)
);

CREATE TABLE countries (
    id int primary key auto_increment,
    name varchar(50)
);

CREATE TABLE types (
    id int primary key auto_increment,
    name varchar(50)
);

CREATE TABLE confirmations (
    id int primary key auto_increment,
    name varchar(50)
);

CREATE TABLE recruiters (
    id int primary key auto_increment,
    uname varchar(255),
    upwd varchar(50),
    uemail varchar(50),
    umobile varchar(50)
);

CREATE TABLE users (
    id int primary key auto_increment,
    uname varchar(50),
    upwd varchar(50),
    uemail varchar(50),
    umobile varchar(50)
);

CREATE TABLE jobs (
    id int primary key auto_increment,
    id_recruiter int,
    id_category int,
    id_location int,
    id_type int,
    salary varchar(50),
    description text,
    requirement text,
    vacancy int,
    id_display int NOT NULL DEFAULT 0,
    post_date timestamp default current_timestamp,
    FOREIGN KEY (id_recruiter) REFERENCES recruiters(id) ON DELETE CASCADE,
    FOREIGN KEY (id_category) REFERENCES categories(id) ON DELETE CASCADE,
    FOREIGN KEY (id_location) REFERENCES locations(id) ON DELETE CASCADE,
    FOREIGN KEY (id_type) REFERENCES types(id) ON DELETE CASCADE
);

CREATE TABLE users_detail (
    id_user int primary key,
    id_category int,
    id_location int,
    work_experience text,
    education text,
    professional_skills text,
    img varchar(255),
    FOREIGN KEY (id_category) REFERENCES categories(id) ON DELETE CASCADE,
    FOREIGN KEY (id_location) REFERENCES locations(id) ON DELETE CASCADE
);

CREATE TABLE recruiters_detail (
    id_recruiter int primary key,
    description text,
    id_country int,
    web varchar(255),
    img varchar(255),
    FOREIGN KEY (id_country) REFERENCES countries(id) ON DELETE CASCADE
);

CREATE TABLE applications (
    id int primary key auto_increment,
    id_job int,
    id_user int,
    apply_date timestamp default current_timestamp,
    id_confirmation int,
    FOREIGN KEY (id_job) REFERENCES jobs(id) ON DELETE CASCADE,
    FOREIGN KEY (id_user) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (id_confirmation) REFERENCES confirmations(id) ON DELETE CASCADE
);

INSERT INTO confirmations (name) VALUES
('Pending'),
('Accepted'),
('Rejected');

INSERT INTO countries (name) values
('Viet Nam'),
('South Korea'),
('Japan'),
('China');

INSERT INTO categories (name) VALUES
('Information Technology'),
('Marketing'),
('Translator'),
('Accounting');

INSERT INTO locations (name) VALUES
('Ha Noi'),
('Da Nang'),
('Thua Thien Hue'),
('Ho Chi Minh');

INSERT INTO types (name) values
('Full Time'),
('Part Time'),
('Remote'),
('Freelance');

INSERT INTO users (uname, upwd, uemail, umobile) VALUES
('Admin', '123', 'admin@gmail.com', '0000000000'),
('Le Van Tuan Loc', '123', 'tuanloc782004@gmail.com', '0772910452'),
('Nguyen Hong Trang', '123', 'hongtrangqn834@gmail.com', '0983652910'),
('Tran Dinh Hung', '123', 'tranhung230904@gmail.com', '0526558142'),
('Le Quy Hoang Thuc', '123', 'thuclqh@gmail.com', '0526558142'),
('Pham Minh Hoang', '123', 'hoangdeptrai1404@gmail.com', '0914125912'),
('Nguyen Viet Tu', '123', 'viettu23@gmail.com', '0912383210'),
('Le Dinh Toan', '123', 'letoan12@gmail.com', '0912383288'),
('Ho Thanh Huy', '123', 'thanhhuy45@gmail.com', '0912283245'),
('Doan Cong Tuan Vu', '123', 'vudoan89@gmail.com', '0821397191'),
('Le Anh Tuan', '123', 'letuan123@gmail.com', '0872383223'),
('Le Minh', '123', 'leminh678@gmail.com', '0919891239'),
('Hoang Thanh Viet', '123', 'thanhviet342@gmail.com', '0948127834'),
('Vo Le Quyen', '123', 'lequyen23@gmail.com', '0846120932'),
('Hoang Huong Binh', '123', 'huongbinh888@gmail.com', '0915683200'),
('Tran Thi Thanh Phuong', '123', 'thanhphuong123@gmail.com', '0912383276'),
('Huynh Khoi Nguyen', '123', 'khoinguyen789@gmail.com', '0813383245'),
('Tran Le Duy', '123', 'duytran34@gmail.com', '0912389201'),
('Lu Thanh', '123', 'luthanh567@gmail.com', '0982910392'),
('Le Mau Toan', '123', 'mautoan12@gmail.com', '0912383308'),
('Ho Si Thao', '123', 'sithao6789@gmail.com', '0832819309'),
('Le Minh Khanh', '123', 'minhkhanh123@gmail.com', '0912383167'),
('Tran Minh Quang', '123', 'minhquang22@gmail.com', '0912383366'),
('Hoang Minh Nhat', '123', 'minhnhat87@gmail.com', '0912381803'),
('Luu Vo Hoang', '123', 'vohoang@gmail.com', '0912340912'),
('Nguyen Dinh Huy', '123', 'dinhhuy89@gmail.com', '0912383123'),
('Le Tram Anh', '123', 'tramanh34@gmail.com', '0812383245'),
('Phan Gia Bao', '123', 'giabao345@gmail.com', '0832819186'),
('Phan Thanh Kiet', '123', 'thanhkiet23@gmail.com', '0832818432'),
('Pham Phan Thanh', '123', 'phanthanh98@gmail.com', '0832817712'),
('Nguyen Ba Nam', '123', 'namnguyen123@gmail.com', '0932819901'),
('Dang Xuan Khanh', '123', 'khanhdang678@gmail.com', '0932819888'),
('Nguyen Van Chuong', '123', 'vanchuong12@gmail.com', '0832872278'),
('Le Huu Quy', '123', 'quyle821@gmail.com', '0832812245'),
('Phung Van Do', '123', 'vando345@gmail.com', '0913819386'),
('Nguyen Tuan Dung', '123', 'tuandung021@gmail.com', '0922819312'),
('Nguyen Chu Anh', '123', 'chuanh876@gmail.com', '0773281934'),
('Nguyen Tien Dung', '123', 'tiendung123@gmail.com', '0832819322'),
('Nguyen Van Long', '123', 'vanlong1406@gmail.com', '0932819777'),
('Tran Dinh Cuong', '123', 'trancuong230904@gmail.com', '0812719308'),
('Mai Le Dan', '123', 'ledan123@gmail.com', '0944819011'),
('Pham Anh Sao', '123', 'anhsao98@gmail.com', '0988819121'),
('Ta Anh Thu', '123', 'anhthu123@gmail.com', '0832818666'),
('Pham Thanh Huyen', '123', 'huyenpham89gmail.com', '0832843376'),
('Doan Van Phuong', '123', 'vanphuong123@gmail.com', '0832816678'),
('Nguyen Van Hoa', '123', 'vanhoa444@gmail.com', '0832810999'),
('Thai Phong', '123', 'thaiphong33@gmail.com', '0912819309'),
('Le Duc Hoang', '123', 'lehoang88@gmail.com', '0902819767'),
('Le Van', '123', 'vanle77@gmail.com', '0811819989'),
('Do Van Luc', '123', 'doluc11@gmail.com', '0987819222'),
('Mai Vy', '123', 'maivy55@gmail.com', '0922819987'),
('Pham Minh trang', '123', 'trangpham12@gmail.com', '0899819456'),
('Tran Huu Nghia', '123', 'nghiatran123@gmail.com', '0912819890'),
('Tran Dinh Trong', '123', 'dinhtrong0192@gmail.com', '0962819888'),
('Bui Tan Truong', '123', 'truongbui1234@gmail.com', '0902819555'),
('Le Khanh', '123', 'lekhanh987@gmail.com', '0812819333'),
('Le Cong Vinh', '123', 'vinhle222@gmail.com', '0842819787'),
('Dang Thanh Binh', '123', 'thanhbinh23@gmail.com', '0932819666'),
('Le Thang Long', '123', 'longle21@gmail.com', '0912819292'),
('Le Kha Duc', '123', 'leduc99@gmail.com', '0822819012'),
('Mai Quoc Tu', '123', 'quoctu33@gmail.com', '0962719821'),
('Mai Van Quyen', '123', 'vanquyen22@gmail.com', '0902819111'),
('Thai Trong', '123', 'thaitrong77@gmail.com', '0819203291'),
('Bui Hoang Son', '123', 'hoangson990@gmail.com', '0809328190'),
('Hoang Quang Dung', '123', 'hoangdung33@gmail.com', '0773214569'),
('Nguyen Cong Phuong', '123', 'nguyenphuong879@gmail.com', '0778012783'),
('Nguyen Gia Bao', '123', 'nguyenbao456@gmail.com', '0849100291'),
('Truong Tri Thien', '123','truongthien99@gmail.com', '0947382128'),
('Le The Quyen','123','thequyen22@gmail.com','0937564821'),
('Chau Doan Phat','123','doanphat11@gmail.com','0823045912'),
('Ho Van Y', '123', 'vany123@gmail.com', '0816558142'),
('Nguyen Anh Duy', '123', 'duynguyen32@gmail.com', '0923558121'),
('Nguyen Thinh Phat', '123', 'phatnguyen23@gmail.com', '0918282193'),
('Tu Minh Quang', '123', 'minhquang99@gmail.com', '0819271921'),
('Nguyen Van Viet', '123', 'vanviet123@gmail.com', '0301029192'),
('Nguyen Hong Phuc', '123', 'phucnguyen123@gmail.com', '0791239840'),
('Tran Quang Thinh', '123', 'tranthinh99@gmail.com', '0991283312'),
('Luong Duy Cuong', '123', 'duycuong22@gmail.com', '0862716273'),
('Hoang Van Toan', '123', 'vantoan02@gmail.com', '0819281921'),
('Nguyen Duc Viet', '123', 'vietnguyen33@gmail.com', '0726558132'),
('Vo Nguyen Hoang', '123', 'nguyenhoang@gmail.com', '0928219283'),
('Hoang Viet Nguyen', '123', 'nguyenhoang23@gmail.com', '0776123682'),
('Nguyen Thai Son', '123', 'thaison021@gmail.com', '0812390392'),
('Ho Tan Tai', '123', 'tantai88@gmail.com', '0920304756'),
('Bui Vi Hao', '123', 'vihao567@gmail.com', '0778129393'),
('Nguyen Minh Quang', '123', 'minhquang0394@gmail.com', '0901234332'),
('Ho Van Cuong', '123', 'vancuong33@gmail.com', '0891283921'),
('Chu Van Tien', '123', 'vantien09@gmail.com', '0783558142'),
('Tran Thai Huy', '123', 'tranhuy120998@gmail.com', '0912558142'),
('Nguyen Quang Linh', '123', 'quanglinh34@gmail.com', '0928371921'),
('Ngo Ngoc Son', '123', 'ngocson0923@gmail.com', '0712383943'),
('Ngo Duc Thang', '123', 'ducthang91@gmail.com', '0681293826'),
('Luu Duc Thai', '123', 'ducthai23@gmail.com', '0916558132'),
('Nguyen Thuy Hoai', '123', 'thuyhoai33@gmail.com', '09812374974'),
('Le Huynh Nhu', '123', 'huynhnhu44@gmail.com', '0891230434'),
('Mai Van Hoang', '123', 'maihoang44@gmail.com', '0902748371'),
('Phan Dinh Tri', '123', 'triphan33@gmail.com', '0728398319'),
('Le Tan Dung', '123', 'tandung2123@gmail.com', '0947289418'),
('Le Quang Truong', '123', 'quangtruong32@gmail.com', '0923910385'),
('Vo Tan Phat', '123', 'tanphat67@gmail.com', '0845819332');

INSERT INTO users_detail (id_user, id_category, id_location, work_experience, education, professional_skills, img) VALUES
(2, 1, 2, '2 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/levantuanloc.jpg'),
(3, 2, 1, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/nguyenhongtrang.jpg'),
(4, 3, 3, '1 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/trandinhhung.jpg'),
(5, 4, 3, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/lequyhoangthuc.jpg'),
(6, 1, 2, '3 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(7, 3, 3, '1 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(8, 1, 2, 'No work experience', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(9, 1, 2, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(10, 2, 1, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(11, 4, 3, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(12, 2, 1, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(13, 1, 2, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(14, 3, 3, '1 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(15, 1, 2, '2 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(16, 3, 3, '2 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(17, 3, 3, '1 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(18, 1, 4, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(19, 4, 3, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(20, 1, 3, '2 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(21, 2, 2, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(22, 3, 2, '2 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(23, 4, 2, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(24, 1, 3, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(25, 2, 2, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(26, 3, 2, '3 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(27, 4, 2, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(28, 1, 3, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(29, 1, 2, '2 years of experience as a Python App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(30, 1, 1, '1 years of experience as a Python App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(31, 2, 1, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(32, 3, 2, '2 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(33, 4, 1, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(34, 1, 3, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(35, 1, 1, '2 years of experience as a Python App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(36, 2, 2, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(37, 3, 2, '2 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(38, 4, 2, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(39, 1, 3, '1 years of experience as a Python App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(40, 2, 2, 'No work experience', ' National Economics University ', 'ommunication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(41, 3, 2, '3 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(42, 4, 2, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(43, 1, 2, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(44, 2, 3, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(45, 3, 1, '2 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(46, 4, 1, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(47, 1, 3, '3 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(48, 2, 2, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(49, 3, 1, '3 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(50, 4, 1, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(51, 1, 2, '1 years of experience as a Python App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(52, 1, 1, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(53, 2, 3, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(54, 3, 2, '3 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(55, 4, 1, 'No work experience', 'Da Nang University of Economy ','Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(56, 1, 3, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(57, 2, 2, 'No work experience', ' National Economics University ', 'Cmmunication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(58, 3, 1, '2 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(59, 4, 1, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(60, 1, 2, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(61, 2, 3, 'No work experience', ' National Economics University ', 'ommunication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(62, 3, 3, '3 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(63, 4, 3, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(64, 1, 1, '1 years of experience as a Python App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(65, 2, 2, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(66, 3, 1, '2 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(67, 4, 1, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(68, 1, 3, '2 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(69, 2, 2, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(70, 3, 1, '1 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(71, 4, 1, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(72, 1, 1, '1 years of experience as a Python App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(73, 2, 1, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(74, 3, 1, '2 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(75, 4, 1, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(76, 1, 1, '2 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(77, 2, 2, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(78, 3, 2, '3 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(79, 4, 2, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(80, 1, 3, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(81, 2, 2, 'No work experience', ' National Economics University ',' Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(82, 3, 1, '1 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(83, 4, 3, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(84, 1, 1, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(85, 2, 2, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(86, 3, 1, '3 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(87, 4, 3, 'No work experience', 'Da Nang University of Economy ','‘Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(88, 1, 3, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(89, 2, 3, 'No work experience', ' National Economics University ','Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(90, 3, 1, '3 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(91, 4, 2, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(92, 1, 3, '1 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(93, 2, 2, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(94, 3, 1, '3 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(95, 4, 1, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(96, 1, 1, '3 years of experience as a Java App Developer', 'Da Nang University of Science and Technology ', 'Java, MySQL, HTML, CSS, JS, Japanese, English', '/all_component/user.jpg'),
(97, 2, 3, 'No work experience', ' National Economics University ','Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg'),
(98, 3, 3, '1 year as a language center lecturer', 'Danang University of Foreign Languages ', 'Language skills, Memory skills, English', '/all_component/user.jpg'),
(99, 4, 1, 'No work experience', 'Da Nang University of Economy ', 'Skills in using accounting software, Financial management skills, Auditing skills ,English', '/all_component/user.jpg'),
(100, 2, 1, 'No work experience', ' National Economics University ', 'Communication skills, Financial management skills, Technology skills, English', '/all_component/user.jpg');

INSERT INTO recruiters (uname, upwd, uemail, umobile) VALUES
('FPT Software', '123', 'contact@fptsoftware.com', '0947628315'),
('Viettel Group', '123', 'contact@viettelgroup.com', '0876543291'),
('FPT Telecom', '123', 'contact@fpttelecom.com', '0965482173'),
('VinGroup', '123', 'contact@vingroup.com', '0923451786'),
('Bamboo Airways', '123', 'contact@bambooairways.com', '0832746195'),
('Masan Group', '123', 'contact@masangroup.com', '0915347286'),
('Mobifone', '123', 'contact@mobifone.com', '0851297462'),
('TMA Solutions', '123', 'contact@tmasolutions.com', '0851297462'),
('Niteco', '123', 'contact@niteco.com', '0851297462'),
('VNG Corporation', '123', 'contact@vngcorporation.com', '0851297462'),
('Ogilvy Vietnam', '123', 'contact@ogilvyvietnam.com', '0851297462'),
('Dentsu Group Vietnam', '123', 'contact@dentsugroupvietnam.com', '0851297462'),
('Havas Media Vietnam', '123', 'contact@havasmediavietnam.com', '0851297462'),
('Alpha Translation Vietnam', '123', 'contact@alphatranslationvietnam.com', '0851297462'),
('GTE Localize', '123', 'contact@gtelocalize.com', '0851297462'),
('KPMG Vietnam', '123', 'contact@kpmgvietnam.com', '0851297462'),
('PwC Vietnam', '123', 'contact@pwcvietnam.com', '0851297462'),
('Samsung Electronics', '123', 'contact@samsungelectronics.com', '0851297462'),
('LG Electronics', '123', 'contact@lgelectronics.com', '0851297462'),
('SK Hynix', '123', 'contact@skhynix.com', '0851297462'),
('Naver Corporation', '123', 'contact@navercorporation.com', '0851297462'),
('Kakao Corporation', '123', 'contact@kakaocorporation.com', '0851297462'),
('Cheil Worldwide', '123', 'contact@cheilworldwide.com', '0851297462'),
('DDB Korea', '123', 'contact@ddbkorea.com', '0851297462'),
('Yulchon LLC', '123', 'contact@yulchonllc.com', '0851297462'),
('Deloitte Korea', '123', 'contact@deloittekorea.com', '0851297462'),
('PwC Korea', '123', 'contact@pwckorea.com', '0851297462'),
('Sony Corporation', '123', 'contact@sonycorporation.com', '0851297462'),
('Nintendo', '123', 'contact@nitendo.com', '0851297462'),
('SoftBank Group Corp', '123', 'contact@softbankgroupcorp.com', '0851297462'),
('Dentsu Group Inc', '123', 'contact@dentsugroupinc.com', '0851297462'),
('Honyaku Center Inc', '123', 'contact@honyakucenterinc.com', '0851297462'),
('Alibaba Group', '123', 'contact@alibabagroup.com', '0851297462'),
('Tencent Holdings Limited', '123', 'contact@tencentholdingslimited.com', '0851297462'),
('Huawei Technologies', '123', 'contact@huaweitechnologies.com', '0851297462'),
('WPP China', '123', 'contact@wppchina.com', '0851297462'),
('China Translation Corporation', '123', 'contact@chinatranslationcorporation.com', '0851297462'),
('PricewaterhouseCoopers Zhong Tian LLP', '123', 'contact@pricewaterhousecooperszhongtianllp.com', '0851297462'),
('Deloitte Touche Tohmatsu Certified Public Accountants LLP', '123', 'contact@dtt.com', '0851297462');

INSERT INTO recruiters_detail (id_recruiter, description, id_country, web, img) VALUES
(1, 'FPT Software is a global technology leader specializing in digital transformation, software development, and IT services. Trusted by Fortune Global 500 companies, FPT Software delivers innovative solutions across diverse sectors such as application development, cloud computing, cybersecurity, and IoT. With expertise in emerging technologies like AI, machine learning, and blockchain, FPT Software helps clients worldwide stay ahead in the digital landscape. Committed to excellence and continuous improvement, FPT Softwares dedicated team delivers scalable solutions and drives digital transformation initiatives to empower businesses and individuals alike.', 1, 'https://fptsoftware.com/', '/all_component/fptsoftware.jpg'),
(2, 'Viettel Group, established in 1989, is Vietnams largest telecommunications company, providing mobile, fixed-line, broadband, and digital solutions to millions of customers. Renowned for its innovation, Viettel invests heavily in research and development to advance its technology infrastructure, ensuring high-quality service and introducing cutting-edge products. With a global presence in over 10 countries across Asia, Africa, and the Americas, Viettel offers a comprehensive range of telecommunications and digital services.', 1, 'https://vietteltelecom.vn/', '/all_component/viettelgroup.jpg'),
(3, 'FPT Telecom is one of Vietnams leading internet service providers, offering high-speed broadband, fiber-optic internet, and digital TV services to millions nationwide. Known for its commitment to innovation, FPT Telecom invests in advanced technology and infrastructure to deliver reliable and fast internet services, ensuring a superior customer experience. Emphasizing customer satisfaction, the company provides 24/7 support, flexible service packages, and a user-friendly digital platform for easy management of accounts and services. Dedicated to corporate social responsibility, FPT Telecom engages in community projects, educational programs, and environmental initiatives. Additionally, FPT Telecom offers a range of digital solutions including cloud computing, cybersecurity, and smart home services, aiming to create an integrated digital ecosystem for its users.', 1, 'https://fpt.vn/vi', '/all_component/fpttelecom.jpg'),
(4, 'VinGroup is one of Vietnams largest private enterprises, operating across various sectors including real estate, retail, healthcare, education, and technology. Known for its high-quality developments, VinGroup has established iconic projects such as Vinhomes residential communities, Vincom shopping malls, and Vinpearl resorts. The company is committed to innovation and sustainability, integrating advanced technologies and green practices into its operations. VinGroup also emphasizes social responsibility, supporting numerous community programs, educational initiatives, and healthcare services. With a vision to improve the quality of life in Vietnam, VinGroup continues to expand its influence and contribute to the nations development.', 1, 'https://vingroup.net/', '/all_component/vingroup.jpg'),
(5, 'Bamboo Airways is a Vietnamese airline known for its high-quality service and commitment to safety. Launched in 2019, the airline offers both domestic and international flights, connecting Vietnam to various destinations in Asia, Europe, and beyond. Bamboo Airways distinguishes itself with its modern fleet, excellent customer service, and punctuality. The airline aims to provide a seamless travel experience with its range of services, including premium lounges and in-flight amenities. Dedicated to sustainable practices, Bamboo Airways also focuses on reducing its environmental footprint through efficient operations and eco-friendly initiatives.', 1, 'https://www.bambooairways.com/', '/all_component/bambooairways.jpg'),
(6, 'Masan Group is one of Vietnams leading conglomerates, operating in sectors such as consumer goods, financial services, and natural resources. Known for its strong brands, Masan produces a wide range of popular food and beverage products, including sauces, instant noodles, and coffee. The company is committed to innovation and quality, continuously investing in research and development to meet consumer needs. Masan Group also prioritizes sustainability, implementing eco-friendly practices and focusing on social responsibility through various community and environmental initiatives. With a vision to enhance the quality of life in Vietnam, Masan Group continues to expand its market presence and influence.', 1, 'https://www.masangroup.com/vi', '/all_component/masangroup.jpg'),
(7, 'Mobifone is a leading telecommunications provider in Vietnam, renowned for its extensive network coverage and reliable mobile services. Established in 1993, Mobifone has grown to become one of the largest mobile network operators in the country, serving millions of subscribers nationwide. The company offers a wide range of telecommunications services, including voice calls, SMS, mobile data, and value-added services such as mobile banking and entertainment. Mobifone is committed to innovation and customer satisfaction, continuously expanding its service offerings and investing in advanced technologies to meet the evolving needs of its customers. With a strong focus on quality and efficiency, Mobifone plays a pivotal role in connecting people and businesses across Vietnam, contributing to the countrys digital transformation and economic development.', 1, 'https://www.mobifone.vn/', '/all_component/mobifone.jpg'),
(8, 'TMA Solutions is a leading software outsourcing company in Vietnam, providing high-quality IT services to clients worldwide. Established in 1997, TMA Solutions specializes in software development, testing, and maintenance across various industries, including telecommunications, finance, healthcare, and retail. Known for its skilled workforce and cutting-edge technologies, the company is committed to delivering innovative and cost-effective solutions. TMA Solutions places a strong emphasis on customer satisfaction, ensuring timely project delivery and robust support. Dedicated to continuous improvement, TMA Solutions invests in employee training and development, fostering a culture of excellence and innovation.', 1, 'https://www.tmasolutions.vn/', '/all_component/tmasolutions.jpg'),
(9, 'Niteco is a prominent global software development company based in Vietnam, specializing in digital transformation and e-commerce solutions. Founded in 2010, Niteco provides comprehensive services in web and mobile development, digital marketing, and IT consulting to clients across various industries. Renowned for its expertise in platforms like Episerver, Sitecore, and Magento, Niteco delivers tailored solutions that drive business growth and enhance customer experiences. The company prioritizes quality and innovation, employing a skilled team of developers and digital strategists to ensure high standards. With a strong commitment to customer satisfaction, Niteco offers reliable support and flexible solutions that meet the evolving needs of businesses worldwide.', 1, 'https://niteco.com/', '/all_component/niteco.jpg'),
(10, 'VNG Corporation is a leading technology company in Vietnam, known for its extensive portfolio of digital services and products. Founded in 2004, VNG specializes in online gaming, digital content, social networking, and e-commerce, with popular platforms such as Zalo, Zing, and Zalopay. The company is dedicated to innovation, continually investing in research and development to deliver cutting-edge technologies and services. VNG places a strong emphasis on user experience, ensuring high-quality and reliable products that cater to millions of users. Committed to social responsibility, VNG engages in various community and educational initiatives, contributing positively to the society.', 1, 'https://vng.com.vn/', '/all_component/vngcorporation.jpg'),
(11, 'Ogilvy Vietnam is a leading marketing and communications agency, part of the renowned Ogilvy network. Established in Vietnam, the agency provides a wide range of services including advertising, branding, digital marketing, and public relations. With a focus on creativity and innovation, Ogilvy Vietnam delivers impactful campaigns that resonate with audiences and drive business results for clients across diverse industries. The agency combines global expertise with local insights to develop strategies tailored to the Vietnamese market.', 1, 'https://www.ogilvy.com/', '/all_component/ogilvyvietnam.jpg'),
(12, 'Dentsu Group Vietnam is a prominent marketing and advertising agency operating as part of the global Dentsu network. Established in Vietnam, the agency offers a comprehensive range of services encompassing advertising, media planning, digital marketing, and creative solutions. Leveraging its international expertise and local insights, Dentsu Group Vietnam develops innovative campaigns that resonate with Vietnamese audiences and drive business growth for clients across various industries. With a focus on strategic thinking and creativity, the agency delivers integrated marketing solutions that address the evolving needs of the market.', 1, 'https://www.group.dentsu.com/en/', '/all_component/dentsugroupvietnam.jpg'),
(13, 'Havas Media Vietnam is a prominent marketing and communications agency, operating as part of the global Havas network. Established in Vietnam, the agency offers a wide range of services including media planning, digital marketing, creative content, and data analytics. Leveraging its international expertise and local market insights, Havas Media Vietnam develops innovative and strategic campaigns tailored to the needs of Vietnamese audiences and brands. With a focus on creativity, technology, and data-driven solutions, the agency helps clients navigate the evolving media landscape and achieve their business objectives.', 1, 'https://vn.havas.com/vi/', '/all_component/havasmediavietnam.jpg'),
(14, 'Alpha Translation Vietnam is a prominent language services provider specializing in translation and interpretation solutions. Established in Vietnam, the company offers a comprehensive range of language services including document translation, localization, transcription, and interpretation in various languages. With a team of skilled linguists and industry experts, Alpha Translation Vietnam delivers accurate and high-quality language solutions tailored to the specific needs of clients across diverse sectors. Committed to excellence and client satisfaction, the company combines linguistic expertise with advanced technology to ensure efficient and precise communication. Whether its translating legal documents, technical manuals, or marketing materials, Alpha Translation Vietnam helps clients bridge language barriers and reach their global audience effectively.', 1, 'https://alphatranslation.com/our-languages/', '/all_component/alphatranslationvietnam.jpg'),
(15, 'GTE Localize is a reputable language service provider based in Vietnam, specializing in translation and localization solutions. Established with a focus on Southeast Asian languages, the company offers a wide range of services including document translation, software localization, website localization, and multimedia localization. With a team of experienced linguists and subject matter experts, GTE Localize delivers accurate and culturally appropriate translations tailored to the target audience. The companys commitment to quality is reflected in its rigorous quality assurance processes and adherence to industry standards. GTE Localize also leverages advanced technology and tools to streamline the localization workflow and ensure timely delivery of projects. Trusted by clients worldwide, GTE Localize is dedicated to facilitating cross-cultural communication and helping businesses expand their global reach effectively.', 1, 'https://gtelocalize.com/', '/all_component/gtelocalize.jpg'),
(16, 'KPMG Vietnam is a leading professional services firm offering a wide range of audit, tax, and advisory services to clients across various industries. As part of the global KPMG network, the firm combines international expertise with deep local insights to provide innovative solutions tailored to the Vietnamese market. With a team of skilled professionals, including auditors, tax advisors, and consultants, KPMG Vietnam helps clients navigate complex business challenges, optimize performance, and achieve sustainable growth. The firm is committed to upholding the highest standards of professionalism, integrity, and quality in all its engagements. With its broad expertise and global network, KPMG Vietnam plays a vital role in driving business success and contributing to the development of Vietnams economy.', 1, 'https://kpmg.com/vn/vi/home.html', '/all_component/kpmgvietnam.jpg'),
(17, 'PwC Vietnam is a leading professional services firm providing audit, tax, and advisory services to clients across diverse industries. As a member of the global PwC network, the firm offers a comprehensive range of services tailored to meet the specific needs of Vietnamese businesses and organizations. With a team of experienced professionals, including auditors, tax advisors, consultants, and industry specialists, PwC Vietnam delivers innovative solutions that help clients address complex challenges, seize opportunities, and achieve their strategic objectives. Committed to quality, integrity, and professionalism, PwC Vietnam adheres to the highest standards of service delivery and ethical conduct in all its engagements.', 1, 'https://www.pwc.com/vn/vn.html', '/all_component/pwcvietnam.jpg'),
(18, 'Samsung Electronics is a global technology leader renowned for its innovative consumer electronics, mobile devices, semiconductors, and other cutting-edge products. Established in South Korea in 1969, Samsung has evolved into one of the worlds largest technology companies, with a presence in over 70 countries and a diverse portfolio of products and services. The companys flagship smartphones, televisions, home appliances, and memory chips are widely recognized for their quality, performance, and design excellence. Samsung is committed to research and development, investing heavily in advancing technology and driving industry innovation. With a focus on sustainability and corporate social responsibility, Samsung actively engages in environmental conservation, community development, and social welfare initiatives worldwide. As a pioneer in the tech industry, Samsung continues to shape the future of technology and enhance the lives of people globally through its innovative solutions.', 2, 'https://www.samsung.com/vn/', '/all_component/samsungelectronics.jpg'),
(19, 'LG Electronics is a global leader in consumer electronics, home appliances, and mobile communications, known for its innovative products and cutting-edge technology. Established in South Korea in 1958, LG has grown into a diversified multinational corporation with a presence in over 100 countries worldwide. The companys extensive product portfolio includes televisions, refrigerators, washing machines, air conditioners, smartphones, and more, all designed to enhance the lives of consumers with advanced features and sleek designs. LG is committed to research and development, investing in groundbreaking technologies such as OLED displays, artificial intelligence, and smart home solutions. With a focus on sustainability, LG prioritizes eco-friendly practices in its operations, manufacturing processes, and product designs. Through its dedication to innovation, quality, and environmental responsibility, LG Electronics continues to shape the future of technology and improve the everyday lives of people around the world.', 2, 'https://www.lg.com/vn', '/all_component/lgelectronics.jpg'),
(20, 'SK Hynix is a global semiconductor manufacturer headquartered in South Korea, specializing in dynamic random-access memory (DRAM) and NAND flash memory chips. Established in 1983, SK Hynix has emerged as one of the worlds leading memory solutions providers, supplying components for a wide range of electronic devices including smartphones, computers, servers, and automotive systems. With state-of-the-art manufacturing facilities and cutting-edge technology, SK Hynix delivers high-performance memory solutions that power the digital world. The company is committed to innovation and research, investing in the development of next-generation memory technologies to meet the growing demands of the industry. With a focus on sustainability and corporate social responsibility, SK Hynix prioritizes environmental conservation, ethical business practices, and community engagement in its operations. As a key player in the semiconductor industry, SK Hynix plays a vital role in driving technological advancements and shaping the future of computing and communication.', 2, 'https://www.skhynix.com/', '/all_component/skhynix.jpg'),
(21, 'Naver Corporation is a leading South Korean technology company known for its diverse portfolio of online services and platforms. Founded in 1999, Naver has established itself as a major player in the digital space, offering a wide range of services including search engines, web portals, e-commerce platforms, and content creation tools. Navers flagship search engine, Naver Search, is one of the most popular in South Korea, providing users with access to a vast array of information and multimedia content. The company also operates several other successful services such as Naver Webtoon, a digital comics platform, and Naver Pay, a mobile payment service. With a strong focus on innovation and user experience, Naver continues to develop new technologies and services to meet the evolving needs of its users. Additionally, Naver Corporation is actively involved in corporate social responsibility initiatives, including environmental sustainability and community development projects, further solidifying its position as a responsible corporate citizen.', 2, 'https://m.naver.com/', '/all_component/navercorporation.jpg'),
(22, 'Kakao Corporation is a leading South Korean technology company renowned for its diverse range of digital services and platforms. Established in 2010, Kakao has become a dominant force in the countrys digital landscape, offering a wide array of services including messaging, social networking, gaming, content, and fintech. Kakaos flagship messaging app, KakaoTalk, boasts millions of users and is widely used for communication, multimedia sharing, and commerce. The company also operates KakaoPay, a mobile payment platform, KakaoBank, a digital bank, and KakaoTalk Games, a gaming platform. Known for its innovation and user-centric approach, Kakao continues to develop new services and features to enhance the digital experiences of its users. With a strong commitment to social responsibility, Kakao is involved in various community initiatives and environmental sustainability efforts, demonstrating its dedication to making a positive impact on society. As a leader in the tech industry, Kakao Corporation plays a vital role in shaping the future of digital innovation and connectivity in South Korea and beyond.', 2, 'https://www.kakaocorp.com/page/?lang=en', '/all_component/kakaocorporation.jpg'),
(23, 'Cheil Worldwide is a global marketing solutions company headquartered in South Korea, with a presence in over 40 countries worldwide. Founded in 1973 as the in-house agency of Samsung Group, Cheil has since evolved into a full-service advertising and marketing agency offering a wide range of services including advertising, digital marketing, branding, retail marketing, and content creation. The companys client roster includes leading global brands across various industries. With a focus on creativity, innovation, and technology, Cheil develops integrated marketing campaigns that drive business results and create meaningful connections with consumers. As part of its commitment to innovation, Cheil invests in research and development, leveraging data and insights to deliver personalized and impactful marketing solutions. Additionally, Cheil is dedicated to corporate social responsibility, supporting various social and environmental initiatives to make a positive impact on society. As a key player in the marketing industry, Cheil Worldwide continues to push boundaries and shape the future of advertising and brand communication globally.', 2, 'https://www.cheil.com/vn', '/all_component/cheilworldwide.jpg'),
(24, 'DDB Korea is a prominent advertising agency operating as part of the global DDB Worldwide network. Established in South Korea, the agency offers a wide range of services including advertising, branding, digital marketing, and strategic consulting. With a focus on creativity and innovation, DDB Korea develops impactful campaigns that resonate with audiences and drive business results for clients across diverse industries. The agency combines global expertise with local insights to create culturally relevant and effective marketing solutions. Committed to excellence and client satisfaction, DDB Koreas team of professionals works collaboratively to deliver creative and strategic solutions that meet the unique needs of each client. With its strong creative legacy and dedication to innovation, DDB Korea continues to be a trusted partner for brands looking to make a meaningful impact in the Korean market and beyond.', 2, 'https://www.ddbkorea.com/', '/all_component/ddbkorea.jpg'),
(25, 'Yulchon LLC is a prominent law firm based in South Korea, known for its expertise in various areas of legal practice. Established in 1997, Yulchon has grown into one of the largest and most reputable law firms in the country, with a diverse team of legal professionals specializing in areas such as corporate law, finance, mergers and acquisitions, intellectual property, litigation, and arbitration. The firm serves a wide range of clients including multinational corporations, financial institutions, government agencies, and emerging businesses. With a commitment to excellence and innovation, Yulchon provides comprehensive legal solutions tailored to meet the specific needs and objectives of its clients.', 2, 'https://www.yulchon.com/', '/all_component/yulchonllc.jpg'),
(26, 'Deloitte Korea is a prominent member firm of Deloitte Touche Tohmatsu Limited (DTTL), a global professional services network providing audit, tax, consulting, and advisory services. With a presence in over 150 countries, Deloitte is one of the largest professional services firms in the world. In Korea, Deloitte offers a comprehensive range of services to clients across various industries, including financial services, manufacturing, technology, telecommunications, and healthcare. The firms expertise encompasses areas such as audit and assurance, tax advisory, risk advisory, financial advisory, and consulting services. Deloitte Korea is known for its commitment to excellence, integrity, and client service, helping organizations navigate complex business challenges, seize opportunities, and achieve their strategic objectives. Through its global network and local expertise, Deloitte Korea plays a key role in driving business success and contributing to the growth and development of the Korean economy.', 2, 'https://www2.deloitte.com/kr/en.html', '/all_component/deloittekorea.jpg'),
(27, 'PwC Korea is the Korean member firm of PricewaterhouseCoopers (PwC) International Limited, one of the worlds largest professional services networks. With a rich history dating back to 1973, PwC Korea offers a comprehensive range of services including audit, tax, consulting, and advisory services to clients across various industries.', 2, 'https://www.pwc.com/kr/en.html', '/all_component/pwckorea.jpg'),
(28, 'Sony Corporation is a global conglomerate headquartered in Tokyo, Japan, known for its diverse range of consumer electronics, entertainment, and gaming products and services. Founded in 1946, Sony has grown into one of the worlds largest and most influential technology companies. The companys product portfolio includes televisions, audio equipment, cameras, smartphones, gaming consoles (PlayStation), and various entertainment content such as movies, music, and television shows.', 3, 'https://www.sony.net/', '/all_component/sonycorporation.jpg'),
(29, 'Nintendo is a Japanese multinational consumer electronics and video game company headquartered in Kyoto, Japan. Founded in 1889, Nintendo initially started as a playing card company and gradually transitioned into various ventures including toys and games. However, it wasnt until the 1980s that Nintendo became a household name with the launch of its groundbreaking gaming console, the Nintendo Entertainment System (NES).', 3, 'https://www.nintendo.com/us/', '/all_component/nitendo.jpg'),
(30, 'SoftBank Group Corp. is a Japanese multinational conglomerate headquartered in Tokyo, Japan. Founded in 1981 by Masayoshi Son, SoftBank has grown into one of the largest and most influential technology investment firms in the world. The company operates through various subsidiaries and invests in a diverse range of industries including telecommunications, internet services, e-commerce, finance, robotics, and artificial intelligence.', 3, 'https://group.softbank/en', '/all_component/softbankgroupcorp.jpg'),
(31, 'Dentsu Group Inc. is a multinational advertising and public relations company headquartered in Tokyo, Japan. Founded in 1901, Dentsu has grown into one of the largest advertising agencies in the world, with a presence in over 145 countries. The company operates through its various subsidiaries, offering a wide range of services including advertising, media planning and buying, digital marketing, content creation, and consulting.', 3, 'https://www.group.dentsu.com/en/', '/all_component/dentsugroupinc.jpg'),
(32, 'Honyaku Center Inc. is a prominent translation and interpretation services company based in Japan. Established in 1976, Honyaku Center has built a strong reputation for providing high-quality language solutions to clients across various industries. The company offers a wide range of services including document translation, localization, website translation, software localization, and interpretation for conferences, meetings, and other events.', 3, 'https://www.honyakuctren.com/', '/all_component/honyakucenterinc.jpg'),
(33, 'Alibaba Group is a multinational conglomerate headquartered in Hangzhou, China, founded by Jack Ma and his colleagues in 1999. The companys diverse portfolio of businesses includes e-commerce, cloud computing, digital entertainment, and financial services.', 4, 'https://www.alibabagroup.com/en-US/', '/all_component/alibabagroup.jpg'),
(34, 'Tencent Holdings Limited, established in 1998, stands as a Chinese multinational conglomerate with a vast presence across various sectors including technology, entertainment, and artificial intelligence. At its core lies WeChat, the ubiquitous social media and messaging app that boasts billions of users worldwide, integrating messaging, social networking, and mobile payments seamlessly. Beyond WeChat, Tencents portfolio includes a diverse array of businesses such as gaming, e-commerce, fintech, cloud computing, and digital content. Tencent Games, for instance, is one of the worlds largest gaming companies, with popular titles like Honor of Kings and PUBG Mobile under its belt. Additionally, Tencent Video offers a comprehensive streaming service, while Tencent Music Entertainment Group provides music streaming and social entertainment platforms.', 4, 'https://www.tencent.com/', '/all_component/tencentholdingslimited.jpg'),
(35, 'Huawei Technologies Co., Ltd., established in 1987, is a global technology leader headquartered in Shenzhen, China. Renowned for its telecommunications equipment and consumer electronics, Huawei operates across a wide spectrum of industries, including telecommunications networks, smartphones, tablets, wearable technology, and cloud computing.', 4, 'https://www.huawei.com/vn/', '/all_component/huaweitechnologies.jpg'),
(36, 'WPP China is the Chinese division of WPP plc, one of the worlds largest advertising and communications companies. With a presence in over 100 countries, WPP operates through a network of agencies specializing in advertising, media buying, public relations, branding, digital marketing, and market research.', 4, 'https://www.wpp.com/zh-cn', '/all_component/wppchina.jpg'),
(37, 'China Translation Corporation (CTC) is a leading language services provider based in China, specializing in translation and interpretation solutions. Established in 1983, CTC has extensive experience in providing language services to clients across various industries, including government agencies, multinational corporations, and international organizations.', 4, 'https://en.cnpubg.com/portal/article/index/id/47/cid/4.html', '/all_component/chinatranslationcorporation.jpg'),
(38, 'PricewaterhouseCoopers Zhong Tian LLP (PwC Zhong Tian) is a leading professional services firm in China, providing a comprehensive range of audit, tax, consulting, and advisory services to clients across various industries. Established in 1992, PwC Zhong Tian is a member firm of the PricewaterhouseCoopers (PwC) global network, which operates in over 150 countries.', 4, 'https://www.pwccn.com/en/about-site-provider.html', '/all_component/pricewaterhousecooperszhongtianllp.jpg'),
(39, 'Deloitte Touche Tohmatsu Certified Public Accountants LLP (Deloitte China) is a leading professional services firm providing audit, tax, consulting, and advisory services in China. As a member firm of Deloitte Touche Tohmatsu Limited (DTTL), Deloitte China operates with a global network of firms in over 150 countries.', 4, 'https://deloittehuayong.com.cn/en.html', '/all_component/dtt.jpg');

INSERT INTO jobs (id_display, id_recruiter, id_category, id_location, id_type, salary, description, requirement, vacancy) VALUES
(0, 1, 1, 1, 3, '5000$ - 7000$', 'Experienced software engineer to lead development projects.', '5+ years experience in software development and project management', 2),
(1, 2, 1, 2, 4, '3000$- 5000$', 'Creative graphic designer needed for marketing materials.', 'Proficiency in Adobe Creative Suite and a strong portfolio', 5),
(2, 3, 1, 3, 1, '7000$ - 10000$', 'Senior data scientist to analyze and interpret complex data.', 'PhD in Computer Science or related field and 5 years experience', 1),
(0 ,4, 1, 4, 2, '5000$', 'Marketing manager to oversee digital marketing strategies.', 'Bachelor\'s degree in Marketing and 3 years experience', 6),
(1, 5, 1, 1, 3, '5000$ - 9000$', 'Full-stack developer with strong backend and frontend skills.', 'Expertise in React.js, Node.js, and MongoDB', 2),
(0,6, 1, 2, 4, '4000$ - 5000$', 'Business analyst to improve operational efficiency.', 'Experience with data analysis and business process modeling', 2),
(1,7, 1, 3, 1, '1000$ - 2000$', 'Junior web developer with a focus on frontend technologies.', 'Knowledge of HTML, CSS, and JavaScript', 7),
(2,8, 1, 4, 2, '3000$', 'Content writer to create engaging and original content.', 'Excellent writing skills and experience in SEO', 4),
(0,9, 1, 1, 3, '10000$ - 12000$', 'Chief Technology Officer (CTO) to lead tech strategy.', 'Proven leadership experience in a tech company', 1),
(1,10, 1, 2, 4, '5000$ - 8000$', 'Product manager to lead product development.', 'Strong background in product lifecycle management', 3),
(0,11, 2, 3, 1, '3000$ - 4000$', 'IT support specialist to assist with technical issues.', 'Experience with various operating systems and software', 6),
(1,12, 2, 4, 2, '9000$ - 10000$', 'Head of sales to drive company revenue growth.', '5+ years experience in sales management', 4),
(2,13, 2, 1, 3, '2000$ - 2500$', 'Customer service representative to handle client inquiries.', 'Excellent communication skills and customer service experience', 8),
(0,14, 3, 2, 4, '4000$ - 5000$', 'Financial analyst to provide financial insights.', 'Bachelor\'s degree in Finance and 3 years experience', 1),
(1,15, 3, 3, 1, '10000$ - 12000$', 'Software architect to design scalable software solutions.', 'Extensive experience in software architecture and design', 3),
(0,16, 4, 4, 2, '7000$ - 10000$', 'Operations manager to oversee daily operations.', 'Proven experience in operational management', 7),
(1,17, 4, 1, 3, '5000$', 'HR manager to handle recruitment and employee relations.', 'Experience in HR management and strong interpersonal skills', 2),
(0,18, 1, 2, 4, '7000$ - 10000$', 'UX/UI designer to improve user experience.', 'Portfolio showcasing UX/UI design projects', 1),
(1,19, 1, 3, 1, '3000$ - 4000$', 'Mobile app developer to create iOS and Android apps.', 'Proficiency in Swift and Kotlin', 2),
(0,20, 1, 4, 2, '9000$ - 10000$', 'Data engineer to build and maintain data pipelines.', 'Experience with ETL processes and big data technologies', 4),
(1,21, 1, 1, 3, '5000$', 'System administrator to manage IT infrastructure.', 'Experience with network and server management', 7),
(2,22, 1, 2, 4, '5000$', 'Project coordinator to assist in project planning.', 'Strong organizational skills and attention to detail', 4),
(0,23, 2, 3, 1, '3000$ - 4000$', 'Research analyst to conduct market research.', 'Analytical skills and experience with research methodologies', 1),
(1,24, 2, 4, 2, '5000$', 'Sales executive to close deals and build relationships.', 'Proven track record in sales', 1),
(2,25, 3, 1, 3, '3000$ - 4000$', 'Content strategist to plan and execute content strategy.', 'Experience in content creation and strategy', 3),
(0,26, 4, 2, 4, '9000$ - 10000$', 'Lead software developer to manage development team.', 'Experience in leading a development team', 5),
(1,27, 4, 3, 1, '5000$', 'IT consultant to provide technical advice to clients.', 'Strong problem-solving skills and technical knowledge', 3),
(0,28, 1, 4, 2, '3000$ - 4000$', 'Social media manager to handle social media accounts.', 'Experience with social media management tools', 1),
(1,29, 1, 1, 3, '3000$ - 4000$', 'QA engineer to ensure software quality.', 'Experience with automated testing frameworks', 7),
(0,30, 1, 2, 4, '5000$', 'Digital marketer to run online marketing campaigns.', 'Knowledge of SEO, SEM, and PPC', 5),
(1,31, 2, 3, 1, '7000$', 'Network engineer to maintain network systems.', 'Experience with network infrastructure and protocols', 6),
(1,32, 3, 4, 2, '5000$', 'Technical writer to create technical documentation.', 'Strong writing skills and technical background', 1),
(1,33, 4, 1, 3, '3000$- 5000$', 'Event planner to organize company events.', 'Excellent organizational and planning skills', 2),
(1, 34, 4, 2, 4, '3000$- 5000$', 'HR coordinator to support HR functions.', 'Experience in HR and strong administrative skills', 3),
(1, 35, 1, 3, 1, '3000$- 5000$', 'SEO specialist to optimize website content.', 'Experience with SEO tools and techniques', 4),
(1, 36, 1, 4, 2, '9000$', 'Chief Financial Officer (CFO) to manage financial operations.', 'Extensive experience in financial management', 6),
(1, 37, 1, 1, 3, '9000$ - 10000$', 'Senior software engineer with expertise in AI.', 'Experience with machine learning algorithms and frameworks', 4),
(0, 38, 2, 2, 4, '5000$', 'Account manager to manage client accounts.', 'Strong relationship-building skills and sales experience', 3),
(1, 39, 3, 3, 3, '5000$', 'Data analyst to analyze business data.', 'Proficiency in SQL and data visualization tools', 3),
(0, 1, 4, 4, 4, '5000$', 'Operations analyst to optimize business processes.', 'Experience with process improvement methodologies', 1),
(1, 2, 4, 1, 1, '9000$ - 10000$', 'Director of Engineering to lead engineering teams.', 'Proven leadership in an engineering role', 2),
(0, 3, 1, 2, 2, '9000$ - 10000$', 'Marketing director to develop marketing strategies.', 'Strong background in marketing and team leadership', 6),
(1, 4, 2, 3, 3, '5000$', 'Support engineer to assist with technical issues.', 'Strong troubleshooting skills and technical knowledge', 7),
(0, 5, 3, 4, 4, '3000$- 5000$', 'Graphic artist to create visual content.', 'Proficiency in graphic design software and creativity', 1),
(1, 6, 4, 1, 2, '5000$', 'Sales manager to lead sales team.', 'Proven experience in sales management', 3),
(1, 7, 1, 2, 2, '3000$- 5000$', 'HR assistant to support HR functions.', 'Experience in HR and strong administrative skills', 3),
(1, 8, 2, 3, 2, '5000$', 'Content creator to produce digital content.', 'Strong writing and content creation skills', 3),
(1, 9, 3, 4, 3, '9000$ - 10000$', 'Chief Data Officer to oversee data strategy.', 'Extensive experience in data management', 5),
(1, 10, 4, 1, 4, '5000$', 'Training coordinator to organize employee training.', 'Experience in training and development', 5),
(1, 11, 1, 2, 1, '5000$', 'Web designer to design website layouts.', 'Proficiency in web design tools and principles', 1),
(1, 12, 2, 3, 2, '9000$ - 10000$', 'Head of HR to manage HR department.', 'Extensive experience in HR management', 2),
(1, 13, 3, 4, 3, '5000$', 'Digital strategist to plan digital marketing strategies.', 'Experience with digital marketing and strategy', 2),
(1, 14, 4, 1, 4, '5000$', 'Administrative assistant to support office operations.', 'Strong organizational and administrative skills', 3),
(0, 15, 1, 2, 1, '9000$ - 10000$', 'VP of Sales to lead sales initiatives.', 'Proven experience in sales leadership', 6),
(0, 16, 2, 3, 2, '5000$', 'Product owner to manage product backlog.', 'Experience in product management and agile methodologies', 7),
(1, 17, 3, 4, 3, '3000$- 5000$', 'IT technician to provide technical support.', 'Experience with hardware and software troubleshooting', 4),
(1, 18, 4, 1, 4, '5000$', 'Office manager to oversee office operations.', 'Experience in office management and strong organizational skills', 3),
(1, 19, 1, 2, 1, '5000$', 'Customer success manager to ensure client satisfaction.', 'Experience in customer success and relationship management', 1),
(0, 20, 2, 3, 2, '3000$- 5000$', 'Research scientist to conduct scientific research.', 'PhD in a relevant field and research experience', 3),
(1, 21, 3, 4, 3, '5000$', 'Legal advisor to provide legal counsel.', 'Degree in law and legal advisory experience', 6),
(2, 22, 4, 1, 4, '5000$', 'Public relations specialist to manage PR campaigns.', 'Experience in public relations and media relations', 4),
(0, 23, 1, 2, 1, '10000$', 'Chief Marketing Officer (CMO) to lead marketing efforts.', 'Extensive experience in marketing leadership', 2),
(1, 24, 2, 3, 2, '3000$- 5000$', 'Financial advisor to provide financial planning advice.', 'Certified financial planner and financial advisory experience', 6),
(2, 25, 3, 4, 3, '5000$', 'Data scientist to develop data models.', 'Experience with statistical analysis and data modeling', 1),
(0, 26, 4, 1, 4, '9000$ - 10000$', 'Head of Product to oversee product development.', 'Proven experience in product leadership', 6),
(1, 27, 1, 2, 1, '1000$', 'Junior IT support specialist to assist with IT issues.', 'Basic knowledge of IT systems and support', 7),
(2, 28, 2, 3, 2, '9000$ - 10000$', 'Strategy consultant to provide business strategy advice.', 'Experience in business strategy and consulting', 2),
(0, 29, 3, 4, 3, '5000$', 'Customer service manager to oversee customer support.', 'Strong leadership skills and customer service experience', 4),
(1, 30, 4, 1, 4, '5000$', 'Sales representative to sell products and services.', 'Proven sales experience and strong communication skills', 1),
(1, 31, 1, 2, 1, '6000$', 'Network administrator to manage network systems.', 'Experience with network administration and troubleshooting', 7),
(0, 32, 2, 3, 2, '3000$- 5000$', 'HR generalist to handle HR tasks.', 'Experience in HR and strong administrative skills', 8),
(1, 33, 3, 4, 3, '5000$', 'Software tester to ensure software quality.', 'Experience with software testing and QA methodologies', 3),
(1, 34, 4, 1, 4, '9000$ - 10000$', 'Head of IT to manage IT department.', 'Proven experience in IT leadership', 1),
(1, 35, 1, 2, 2, '5000$', 'Marketing coordinator to support marketing activities.', 'Experience in marketing and strong organizational skills', 2),
(1, 36, 2, 3, 3, '5000$', 'Technical support specialist to assist with tech issues.', 'Experience in technical support and troubleshooting', 2),
(0, 37, 3, 4, 4, '9000$ - 10000$', 'VP of Engineering to lead engineering team.', 'Extensive experience in engineering leadership', 2),
(0, 38, 4, 1, 1, '5000$', 'Product marketing manager to promote products.', 'Experience in product marketing and go-to-market strategies', 2),
(1, 39, 1, 2, 2, '5000$', 'Corporate trainer to conduct employee training.', 'Experience in training and development', 2),
(0, 1, 2, 3, 1, '5000$', 'Project manager to oversee project execution.', 'Experience in project management and PMP certification', 2),
(1, 2, 3, 4, 1, '3000$- 5000$', 'Business development manager to drive business growth.', 'Experience in business development and sales', 2),
(1, 3, 4, 1, 1, '5000$', 'Systems analyst to analyze and improve systems.', 'Experience with system analysis and design', 6),
(1, 4, 1, 2, 2, '5000$', 'Content manager to manage content creation.', 'Strong writing skills and content management experience', 5),
(1, 5, 2, 3, 3, '5000$', 'Social media strategist to develop social media strategies.', 'Experience with social media platforms and strategy', 4),
(0, 6, 3, 4, 4, '5000$', 'Database administrator to manage databases.', 'Experience with database management and SQL', 3),
(0, 7, 4, 1, 1, '5000$', 'Public relations manager to handle PR activities.', 'Experience in public relations and media relations', 7),
(0, 8, 1, 2, 2, '9000$ - 10000$', 'Chief Operating Officer (COO) to oversee operations.', 'Proven experience in operational leadership', 8),
(1, 7, 2, 3, 3, '5000$', 'Legal assistant to support legal department.', 'Experience in legal assistance and strong organizational skills', 6),
(1, 7, 3, 4, 4, '9000$ - 10000$', 'Director of Finance to manage financial operations.', 'Extensive experience in financial management', 4),
(1, 7, 4, 1, 1, '5000$', 'Technical support engineer to assist with technical issues.', 'Experience in technical support and troubleshooting', 2),
(1, 7, 4, 2, 2, '5000$', 'Administrative coordinator to manage office tasks.', 'Strong organizational and administrative skills', 2),
(1, 7, 4, 3, 3, '5000$', 'Customer support representative to handle client issues.', 'Excellent communication skills and customer service experience', 2),
(1, 7, 1, 4, 4, '5000$', 'Business operations manager to optimize business processes.', 'Experience in business operations and process improvement', 2),
(1, 7, 2, 1, 1, '9000$ - 10000$', 'VP of Marketing to lead marketing strategies.', 'Proven experience in marketing leadership', 2),
(1, 7, 3, 2, 2, '5000$', 'IT support technician to assist with technical issues.', 'Experience in IT support and troubleshooting', 2),
(2, 7, 4, 3, 3, '5000$', 'Product designer to create product designs.', 'Proficiency in design software and creativity', 2),
(0, 7, 1, 4, 4, '5000$', 'Compliance officer to ensure regulatory compliance.', 'Experience in compliance and regulatory affairs', 2),
(0, 7, 2, 1, 1, '9000$ - 10000$', 'Chief Technology Officer (CTO) to lead tech initiatives.', 'Proven leadership in a tech company', 1),
(1, 7, 3, 2, 2, '5000$', 'Data engineer to develop data pipelines.', 'Experience with big data technologies and ETL processes', 1),
(0, 7, 4, 3, 3, '5000$', 'Operations manager to oversee operations.', 'Experience in operational management', 1),
(1, 7, 1, 4, 4, '5000$', 'Financial analyst to provide financial insights.', 'Experience in financial analysis and modeling', 6),
(1, 7, 1, 1, 1, '5000$', 'Customer success specialist to ensure client satisfaction.', 'Experience in customer success and relationship management', 7);

INSERT INTO applications (id_job, id_user, id_confirmation) VALUES
(2, 2, 1), (5, 3, 2), (7, 4, 3), (10, 5, 1), (12, 6, 2),
(15, 7, 3), (17, 8, 1), (19, 9, 2), (21, 10, 3), (24, 11, 1),
(27, 12, 2), (29, 13, 3), (31, 14, 1), (32, 15, 2), (33, 16, 3),
(34, 17, 1), (35, 18, 2), (36, 19, 3), (37, 20, 1), (39, 21, 2),
(41, 22, 3), (43, 23, 1), (45, 24, 2), (46, 25, 3), (47, 26, 1),
(48, 27, 2), (49, 28, 3), (50, 29, 1), (51, 30, 2), (52, 31, 3),
(53, 32, 1), (53, 33, 2), (56, 34, 3), (57, 35, 1), (58, 36, 2),
(60, 37, 3), (63, 38, 1), (66, 39, 2), (69, 40, 3), (70, 41, 1),
(72, 42, 2), (73, 43, 3), (74, 44, 1), (75, 45, 2), (78, 46, 3),
(80, 47, 1), (81, 48, 2), (82, 49, 3), (83, 50, 1), (87, 51, 2),
(88, 52, 3), (89, 53, 1), (90, 54, 2), (91, 55, 3), (92, 56, 1),
(93, 57, 2), (94, 58, 3), (98, 59, 1), (100, 60, 2), (101, 61, 3),
(2, 62, 1), (5, 63, 2), (7, 64, 3), (10, 65, 1), (12, 66, 2),
(15, 67, 3), (17, 68, 1), (19, 69, 2), (21, 70, 3), (24, 71, 1),
(27, 72, 2), (29, 73, 3), (31, 74, 1), (32, 75, 2), (33, 76, 3),
(34, 77, 1), (35, 78, 2), (36, 79, 3), (37, 80, 1), (39, 81, 2),
(41, 82, 3), (43, 83, 1), (45, 84, 2), (46, 85, 3), (47, 86, 1),
(48, 87, 2), (49, 88, 3), (50, 89, 1), (51, 90, 2), (52, 91, 3),
(53, 92, 1), (53, 93, 2), (56, 94, 3), (57, 95, 1), (58, 96, 2),
(60, 97, 3), (63, 98, 1), (66, 99, 2), (69, 100, 3), (70, 2, 1),
(72, 3, 2), (73, 4, 3), (74, 5, 1), (75, 6, 2), (78, 7, 3),
(80, 8, 1), (81, 9, 2), (82, 10, 3), (83, 11, 1), (87, 12, 2),
(88, 13, 3), (89, 14, 1), (90, 15, 2), (91, 16, 3), (92, 17, 1),
(93, 18, 2), (94, 19, 3), (98, 20, 1), (100, 21, 2), (101, 22, 3),
(2, 23, 1), (5, 24, 2), (7, 25, 3), (10, 26, 1), (12, 27, 2),
(15, 28, 3), (17, 29, 1), (19, 30, 2), (21, 31, 3), (24, 32, 1),
(27, 33, 2), (29, 34, 3), (31, 35, 1), (32, 36, 2), (33, 37, 3),
(34, 38, 1), (35, 39, 2), (36, 40, 3), (37, 41, 1), (39, 42, 2),
(41, 43, 3), (43, 44, 1), (45, 45, 2), (46, 46, 3), (47, 47, 1),
(15, 2, 3), (17, 2, 2), (19, 2, 2), (21, 2, 1), (24, 2, 3),
(33, 2, 1), (34, 2, 2), (35, 2, 3), (36, 2, 1), (37, 2, 3),
(15, 3, 3), (17, 3, 2), (19, 3, 2), (21, 3, 1), (24, 3, 3),
(33, 3, 1), (34, 3, 2), (35, 3, 3), (36, 3, 1), (37, 3, 3), (7, 2, 3), (7, 3, 1), (7, 4, 2), (7, 5, 3),
(7, 67, 1), (7, 68, 2), (7, 69, 3), (7, 70, 1), (7, 71, 2),
(7, 72, 1), (7, 73, 2), (7, 74, 3), (7, 75, 1), (7, 76, 2);

UPDATE jobs SET post_date = '2022-01-01' WHERE id = 1;
UPDATE jobs SET post_date = '2022-01-01' WHERE id = 2;
UPDATE jobs SET post_date = '2022-01-01' WHERE id = 3;
UPDATE jobs SET post_date = '2022-02-01' WHERE id = 4;
UPDATE jobs SET post_date = '2022-02-01' WHERE id = 5;
UPDATE jobs SET post_date = '2022-03-01' WHERE id = 6;
UPDATE jobs SET post_date = '2022-03-01' WHERE id = 7;
UPDATE jobs SET post_date = '2022-04-01' WHERE id = 8;
UPDATE jobs SET post_date = '2022-04-01' WHERE id = 9;
UPDATE jobs SET post_date = '2022-04-01' WHERE id = 10;
UPDATE jobs SET post_date = '2022-04-01' WHERE id = 11;
UPDATE jobs SET post_date = '2022-05-01' WHERE id = 12;
UPDATE jobs SET post_date = '2022-05-01' WHERE id = 13;
UPDATE jobs SET post_date = '2022-06-01' WHERE id = 14;
UPDATE jobs SET post_date = '2022-06-01' WHERE id = 15;
UPDATE jobs SET post_date = '2022-07-01' WHERE id = 16;
UPDATE jobs SET post_date = '2022-07-01' WHERE id = 17;
UPDATE jobs SET post_date = '2022-07-01' WHERE id = 18;
UPDATE jobs SET post_date = '2022-08-01' WHERE id = 19;
UPDATE jobs SET post_date = '2022-09-01' WHERE id = 20;
UPDATE jobs SET post_date = '2022-09-01' WHERE id = 21;
UPDATE jobs SET post_date = '2022-09-01' WHERE id = 22;
UPDATE jobs SET post_date = '2022-10-01' WHERE id = 23;
UPDATE jobs SET post_date = '2022-10-01' WHERE id = 24;
UPDATE jobs SET post_date = '2022-11-01' WHERE id = 25;
UPDATE jobs SET post_date = '2022-11-01' WHERE id = 26;
UPDATE jobs SET post_date = '2022-11-01' WHERE id = 27;
UPDATE jobs SET post_date = '2022-11-01' WHERE id = 28;
UPDATE jobs SET post_date = '2022-12-01' WHERE id = 29;
UPDATE jobs SET post_date = '2022-12-01' WHERE id = 30;
UPDATE jobs SET post_date = '2023-01-01' WHERE id = 31;
UPDATE jobs SET post_date = '2023-02-01' WHERE id = 32;
UPDATE jobs SET post_date = '2023-02-01' WHERE id = 33;
UPDATE jobs SET post_date = '2023-02-01' WHERE id = 34;
UPDATE jobs SET post_date = '2023-03-01' WHERE id = 35;
UPDATE jobs SET post_date = '2023-03-01' WHERE id = 36;
UPDATE jobs SET post_date = '2023-04-01' WHERE id = 37;
UPDATE jobs SET post_date = '2023-04-01' WHERE id = 38;
UPDATE jobs SET post_date = '2023-04-01' WHERE id = 39;
UPDATE jobs SET post_date = '2023-04-01' WHERE id = 40;
UPDATE jobs SET post_date = '2023-05-01' WHERE id = 41;
UPDATE jobs SET post_date = '2023-05-01' WHERE id = 42;
UPDATE jobs SET post_date = '2023-06-01' WHERE id = 43;
UPDATE jobs SET post_date = '2023-07-01' WHERE id = 44;
UPDATE jobs SET post_date = '2023-07-01' WHERE id = 45;
UPDATE jobs SET post_date = '2023-08-01' WHERE id = 46;
UPDATE jobs SET post_date = '2023-08-01' WHERE id = 47;
UPDATE jobs SET post_date = '2023-08-01' WHERE id = 48;
UPDATE jobs SET post_date = '2023-09-01' WHERE id = 49;
UPDATE jobs SET post_date = '2023-09-01' WHERE id = 50;
UPDATE jobs SET post_date = '2023-10-01' WHERE id = 51;
UPDATE jobs SET post_date = '2023-10-01' WHERE id = 52;
UPDATE jobs SET post_date = '2023-11-01' WHERE id = 53;
UPDATE jobs SET post_date = '2023-12-01' WHERE id = 54;
UPDATE jobs SET post_date = '2023-12-01' WHERE id = 55;
UPDATE jobs SET post_date = '2023-12-01' WHERE id = 56;
UPDATE jobs SET post_date = '2023-12-01' WHERE id = 57;
UPDATE jobs SET post_date = '2024-01-01' WHERE id = 58;
UPDATE jobs SET post_date = '2024-01-01' WHERE id = 59;
UPDATE jobs SET post_date = '2024-01-01' WHERE id = 60;
UPDATE jobs SET post_date = '2024-01-01' WHERE id = 61;
UPDATE jobs SET post_date = '2024-02-01' WHERE id = 62;
UPDATE jobs SET post_date = '2024-02-01' WHERE id = 63;
UPDATE jobs SET post_date = '2024-02-01' WHERE id = 64;
UPDATE jobs SET post_date = '2024-02-01' WHERE id = 65;
UPDATE jobs SET post_date = '2024-02-01' WHERE id = 66;
UPDATE jobs SET post_date = '2024-02-01' WHERE id = 67;
UPDATE jobs SET post_date = '2024-03-01' WHERE id = 68;
UPDATE jobs SET post_date = '2024-03-01' WHERE id = 69;
UPDATE jobs SET post_date = '2024-03-01' WHERE id = 70;
UPDATE jobs SET post_date = '2024-04-01' WHERE id = 71;
UPDATE jobs SET post_date = '2024-04-01' WHERE id = 72;
UPDATE jobs SET post_date = '2024-04-01' WHERE id = 73;
UPDATE jobs SET post_date = '2024-04-01' WHERE id = 74;
UPDATE jobs SET post_date = '2024-04-01' WHERE id = 75;
UPDATE jobs SET post_date = '2024-04-01' WHERE id = 76;
UPDATE jobs SET post_date = '2024-04-01' WHERE id = 77;
UPDATE jobs SET post_date = '2024-04-01' WHERE id = 78;
UPDATE jobs SET post_date = '2024-05-01' WHERE id = 79;
UPDATE jobs SET post_date = '2024-05-01' WHERE id = 80;
UPDATE jobs SET post_date = '2024-05-01' WHERE id = 81;
UPDATE jobs SET post_date = '2024-05-01' WHERE id = 82;
UPDATE jobs SET post_date = '2024-05-01' WHERE id = 83;
UPDATE jobs SET post_date = '2024-05-01' WHERE id = 84;
UPDATE jobs SET post_date = '2024-05-01' WHERE id = 85;
UPDATE jobs SET post_date = '2024-05-01' WHERE id = 86;
UPDATE jobs SET post_date = '2024-05-01' WHERE id = 87;

select * from users;
select * from users_detail;
select * from recruiters;
select * from recruiters_detail;
select * from jobs;
select * from applications;
select * from categories;
select * from locations;
select * from types;
select * from confirmations;
select * from countries;