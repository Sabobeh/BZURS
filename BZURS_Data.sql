insert into Faculty (Faculty_id, faculty_Phone_number, Faculty_name, Faculty_Fax, Faculty_Email)
values (1, '2955661', 'Engineering and Technology', '29955771', 'ENIT@birzeit.edu'),
(2, '2955662', 'Science', '29955772', 'sci@birzeit.edu'),
(3, '2955663', 'Medicine', '29955773', 'bui@birzeit.edu'),
(4, '2955664', 'Law and Public Administration', '29955774', 'LPA@birzeit.edu'); 


insert into Department (department_ID, department_name, department_phone_number, department_Email, department_Fax, Faculty_id) 
values (11, 'Civil and Environmental Engineering', '2944661', 'ENCE@birzeit.edu', '2944771', 1), 
(12, 'Mechanical and Mechatronics Engineering', '2944662', 'ENME@birzeit.edu', '2944772', 1), 
(13, 'Computer Science', '2944663', 'COMP@birzeit.edu', '2944773', 1), 
(14, 'Chemistry', '2944664', 'CHEM@birzeit.edu', '2944774', 2), 
(15, 'Mathematics', '2944665', 'MATH@birzeit.edu', '2944775', 2), 
(16, 'Physics', '2944666', 'PHYS@birzeit.edu', '2944776', 2), 
(17, 'Law', '2944667', 'LAW@birzeit.edu', '2944777', 4), 
(18, 'Public Administration', '2944668', 'PUAD@birzeit.edu', '2944778', 4);


insert into professor (Professor_ID, professor_Name, professor_NID, professor_BDate, professor_gender, professor_phoneNo, professor_address, professor_Degree, professor_email,department_id)
values (112, 'Murad Nijem', 406456481, '1991-3-12', 'M', 0596546238, "Nablus", 'PHD', 'muradnj@birzeit.edu', 11),
(113, 'Ahmad Ismael', 406426481, '1979-2-22', 'M', 0596546253, "Jerusalem", 'MA', 'ahmadIS@birzeit.edu', 11),
(114, 'Muna Idrees', 406486481, '1969-2-25', 'F', 0596546254, "Hebron", 'PHD', 'munaid@birzeit.edu', 12),
(115, 'Mutasem Juma ', 406456451, '1970-2-27', 'M', 0596546255, "Qalqelyeh", 'PHD', 'mutju@birzeit.edu', 12),
(116, 'Sara Mustafa', 406456486, '1982-3-22', 'F', 0596546256, "Ramallah", 'PHD', 'saramus@birzeit.edu', 12),
(117, 'Nihad Zorba', 406456484, '1983-8-22', 'F', 0596546257, "AL-Naqab", 'MA', 'nihzo@birzeit.edu', 13),
(118, 'Amani kahook', 406456485, '1978-12-22', 'F', 0596546258, "Al-jaleel", 'PHD', 'AmaKA@birzeit.edu', 13),
(119, 'Mona Howari', 406456488, '1988-11-22', 'F', 0596546259, "Nazareth", 'PHD', 'Howari@birzeit.edu', 14),
(120, 'Zakariya Zenati', 506456481, '1986-07-02', 'M', 0556546258, "Al-Bireh", 'PHD', 'ZAK@birzeit.edu', 14),
(121, 'Doha Barakat', 516456481, '1977-12-21', 'F', 0566546258, "Beesan", 'PHD', 'DOHAB@birzeit.edu', 15),
(122, 'Tala karkar', 426456481, '1978-1-29', 'F', 0596046258, "Jerusalem", 'MA', 'TALAK@birzeit.edu', 15),
(123, 'Issam Abbas', 436456481, '1991-1-1', 'M', 0590546258, "Ako", 'PHD', 'ISSAb@birzeit.edu', 16),
(124, 'Mohammed Leema', 456456481, '1987-1-22', 'M', 0596500258, "Tulkarm", 'MA', 'MoewLee@birzeit.edu', 16),
(125, 'Kareem Noor', 476456481, '1985-2-12', 'M', 0596546008, "Safad", 'PHD', 'KareemN@birzeit.edu', 17),
(126, 'Bassem Mahmoud', 496456481, '1969-8-22', 'M', 0597500058, "Jericho", 'PHD', 'BassMZ@birzeit.edu', 17),
(127, 'Suha Jallad', 406336481, '1987-9-22', 'F', 0596546222, "Yafa", 'MA', 'SUHAJ@birzeit.edu', 18),
(128, 'Noor Nijem', 406452281, '1989-4-12', 'F', 0596546111, "Safad", 'PHD', 'NOORNI@birzeit.edu', 18),
(129, 'Jehan Nijem', 406411481, '1979-6-27', 'F', 0596546000, "Tulkarm", 'MA', 'Jehanni@birzeit.edu', 18);


update faculty set faculty_manager_id = 112 where faculty_id = 1;
update faculty set faculty_manager_id = 119 where faculty_id = 2;
update faculty set faculty_manager_id = 129 where faculty_id = 4;

update department set department_manager_id = 112 where department_id = 11;
update department set department_manager_id = 115 where department_id = 12;
update department set department_manager_id = 118 where department_id = 13;
update department set department_manager_id = 120 where department_id = 14;
update department set department_manager_id = 121 where department_id = 15;
update department set department_manager_id = 124 where department_id = 16;
update department set department_manager_id = 126 where department_id = 17;
update department set department_manager_id = 128 where department_id = 18;

insert into Program (Program_ID, Program_Name, abbreviation, credit_hours, Credit_hour_price, major_minor, program_department_id)
values (1111, 'Civil Engineering Program', 'ENCE', 158, 45, 'major', 11),
(1112, 'Mechanical Engineering Program', 'ENME', 160, 45, 'major', 12),
(1113, 'Mechatronics Engineering Program', 'ENMC', 162, 50, 'major', 12),
(1114, 'Computer Science Program', 'COMP', 129, 55, 'major', 13),
(2115, 'Computer Science Minor', 'COMP',22, 0, 'minor', 13),
(1116, 'Chemistry Program', 'CHEM', 125, 40, 'major', 14),
(1117, 'Mathematics Program', 'MATH', 126, 40, 'major', 15),
(2118, 'Mathematics Minor', 'MATH', 21, 0, 'minor', 15),
(1119, 'Physics Program', 'PHYS', 130, 30, 'major', 16),
(1120, 'Law Program', 'LAWS', 120, 50, 'major', 17),
(1121, 'Public Administration Program', 'PUAD', 122, 50, 'major', 18),
(2122, 'Public Administration Minor', 'PUAD', 20, 0, 'minor', 18)
;

insert into Student( student_Name, National_ID, BirthDate, gender, phone_Number, address, graduation_Status, balance, email, community_Hours, major_id, GPA)
values ('Ahmad Sabobeh', 506456481,'2001-12-2', 'M', 0568123300, 'Safad', 'Graduated', -1000, 'ah999madd@student.birzet.edu', 120, 1111, 88),
('Mohammad Azzam', 506456482,'2001-12-2', 'M', 0568123321, 'Nablus', 'Enrolled', 6, 'MOe@student.birzet.edu', 100, 1112, 78),
('Rahaf Abu Gharbeyeh', 506456483,'2001-12-2', 'F', 0568123322, 'Ramallah', 'Graduated', -900, 'ahm976add@student.birzet.edu', 90, 1121, 68),
('Sana Al Sous', 506456484,'2001-12-2', 'F', 0568123323, 'Gaza', 'Graduated', -800, 'ahma45dd@student.birzet.edu', 10, 1113, 79),
('Jad Abdul Samad', 506456485,'2001-12-2', 'M', 0568123324, 'Rafah', 'Enrolled', -3251, 'ahmadd66@student.birzet.edu', 0, 1117, 80)
;

alter table student auto_increment = 1190001;
insert into Student( student_Name, National_ID, BirthDate, gender, phone_Number, address, graduation_Status, balance, email, community_Hours, major_id, GPA)
values ('Mutasem Khateeb', 506456486,'2001-12-2', 'M', 0568123325, 'Ramallah', 'Graduated', -1423, 'ahmad1d@student.birzet.edu', 90, 1120, 88),
('Lamya Hammoudeh', 506456487,'2001-12-2', 'F', 0568123326, 'Ramallah', 'Enrolled', 0, 'ah1madd@student.birzet.edu', 70, 1111, 68),
('Fariz Fawwaz', 506456488,'2001-12-2', 'M', 0568123327, 'Nablus', 'Enrolled', -9, 'ahmad2d@student.birzet.edu', 50, 1113, 77),
('Naser Awwad', 506456489,'2001-12-2', 'M', 0568123328, 'Ramallah', 'Enrolled', 0, 'ahm3add@student.birzet.edu', 20, 1116, 89),
('Hasna hassoun', 506456480,'2001-12-2', 'F', 0568123329, 'Yafa', 'Enrolled', 20, 'ahmad4d@student.birzet.edu', 120, 1116, 74)
;

alter table student auto_increment = 1200001;
insert into Student( student_Name, National_ID, BirthDate, gender, phone_Number, address, graduation_Status, balance, email, community_Hours, major_id, GPA)
values ('Karmen Lafi', 599456481,'2001-12-2', 'F', 0568124321, 'Ramallah', 'Enrolled', -99, 'ahm5add@student.birzet.edu', 50, 1121, 89),
('Zuhdi Hajali', 506456491,'2001-12-2', 'M', 0568125321, 'Yafa', 'Enrolled', 10, 'ahmad5d@student.birzet.edu', 30, 1113, 77),
('Moneeb Al Masri', 506886481,'2001-12-2', 'M', 0568126321, 'Gaza', 'Enrolled', -40, 'ahm1add@student.birzet.edu', 20, 1112, 60),
('Dareen Sabbah', 506456999,'2001-12-2', 'F', 0568127321, 'Jenin', 'Enrolled', 1, 'ahmadd0@student.birzet.edu', 10, 1117, 74),
('Jack Sam', 509956481,'2001-12-2', 'M', 0568128321, 'Rafah', 'Enrolled', 0, 'ahmad00d@student.birzet.edu', 30, 1116, 71)
;

alter table student auto_increment = 1210001;
insert into Student( student_Name, National_ID, BirthDate, gender, phone_Number, address, graduation_Status, balance, email, community_Hours, major_id, GPA)
values ('Ahmad Moneeb', 506456401,'2001-12-2', 'M', 0568223321, 'Jenin', 'Enrolled', 0, 'a00hmadd@student.birzet.edu', 20, 1121, 90),
('Mona Suboh', 506456411,'2001-12-2', 'F', 0568323321, 'Nablus', 'Enrolled', 8, 'ahmadd00@student.birzet.edu', 10, 1114, 91),
('Rana Khalid', 506456421,'2001-12-2', 'F', 0568423321, 'AlBireh', 'Enrolled', 0, 'ahmadd99@student.birzet.edu', 0, 1114, 80),
('Lana Abdo', 506456431,'2001-12-2', 'F', 0568523321, 'Gaza', 'Enrolled', 8, 'ahma99d@student.birzet.edu', 0, 1114, 79),
('Mahmoud Zidan', 506456441,'2001-12-2', 'M', 0568623321, 'Yafa', 'Enrolled', 0, '99@student.birzet.edu', 0, 1119, 71)
;


insert into course(Course_ID, Course_name, course_department_ID)
values ('ENCE231', 'Statics', 11),
('ENCE331', 'Concrete Design 1', 11),
('ENCE411', 'Concrete Design Lab', 11),
('ENME131', 'Engineering Drawing', 12),
('ENME331', 'Vibration Analysis', 12),
('COMP131', 'Introduction to Computer Programming', 13),
('COMP333', 'Database Systems', 13),
('COMP431', 'Graduation Project', 13),
('CHEM134', 'Chemistry for Engineering Students', 14),
('MATH134', 'Calculus 1', 15),
('MATH132', 'Calculus 2', 15),
('PHYS134', 'Physics 1', 16),
('PHYS131', 'Physics 2', 16),
('LAWS131', 'Introduction to Law Regulations', 17),
('LAWS222', 'Law for Engineers', 17),
('PUAD332', 'Managing Human Resources in Projects', 18),
('PUAD422', 'Arranging Hackathons',  18)
; 

insert into pre_course (Course_ID, Pre_Course_ID)
values ('ENCE331', 'ENCE231'),
('ENCE231', 'PHYS131'),
('PHYS131', 'PHYS134'),
('ENCE411', 'ENCE331'),
('MATH132', 'MATH134'),
('LAWS222', 'LAWS131'),
('PUAD422', 'PUAD332'),
('ENME331', 'ENCE231'),
('ENME331', 'ENME131'),
('ENCE231', 'MATH132')
;

insert into timeperiod (Timeperiod_id, DayComb, TimeComb, course_type)
values 
(111, 'M', '08:30 - 09:20', 1),	(112,'M', '10:00 - 10:50', 1),	(114,'M', '11:25 - 12:15', 1),	(115,'M', '12:50 - 01:40', 1),
(117,'M', '02:15 - 03:05', 1),	(118,'M', '03:30 - 04:20', 1),	
(131,'M', '08:30 - 09:45', 3),	(132,'M', '10:00 - 11:15', 3),	(134 ,'M', '11:25 - 12:40', 3),	(135, 'M', '12:50 - 02:05', 3),	
(137,'M', '02:15 - 03:30', 3),	(138,'M', '03:30 - 04:45', 3),
(120,'M', '08:00 - 11:15', 2),	(123, 'M', '11:25 - 02:05', 2),	(126, 'M', '02:15 - 04:50', 2),

(211,'T', '08:30 - 09:20', 1),	(212,'T', '10:00 - 10:50', 1),	(214,'T', '11:25 - 12:15', 1),	(215,'T', '12:50 - 01:40', 1),
(217,'T', '02:15 - 03:05', 1),	(218,'T', '03:30 - 04:20', 1),	
(231,'T', '08:30 - 09:45', 3),	(232,'T', '10:00 - 11:15', 3),	(234,'T', '11:25 - 12:40', 3),	(235, 'T', '12:50 - 02:05', 3),	
(237,'T', '02:15 - 03:30', 3),	(238,'T', '03:30 - 04:45', 3),
(220,'T', '08:00 - 11:15', 2),	(223,'T', '11:25 - 02:05', 2),	(226,'T', '02:15 - 04:50', 2),

(311,'W', '08:30 - 09:20', 1),	(312,'W', '10:00 - 10:50', 1),	(314,'W', '11:25 - 12:15', 1),	(315,'W', '12:50 - 01:40', 1),
(317,'W', '02:15 - 03:05', 1),	(318,'W', '03:30 - 04:20', 1),	
(331,'W', '08:30 - 09:45', 3),	(332,'W', '10:00 - 11:15', 3),	(334 ,'W', '11:25 - 12:40', 3),	(335, 'W', '12:50 - 02:05', 3),	
(337,'W', '02:15 - 03:30', 3),	(338,'W', '03:30 - 04:45', 3),
(320,'W', '08:00 - 11:15', 2),	(323, 'W', '11:25 - 02:05', 2),	(326, 'W', '02:15 - 04:50', 2),

(411,'R', '08:30 - 09:20', 1),	(412,'R', '10:00 - 10:50', 1),	(414,'R', '11:25 - 12:15', 1),	(415,'R', '12:50 - 01:40', 1),
(417,'R', '02:15 - 03:05', 1),	(418,'R', '03:30 - 04:20', 1),	
(431,'R', '08:30 - 09:45', 3),	(432,'R', '10:00 - 11:15', 3),	(434,'R', '11:25 - 12:40', 3),	(435, 'R', '12:50 - 02:05', 3),	
(437,'R', '02:15 - 03:30', 3),	(438,'R', '03:30 - 04:45', 3),
(420,'R', '08:00 - 11:15', 2),	(423,'R', '11:25 - 02:05', 2),	(426,'R', '02:15 - 04:50', 2),

(511,'S', '08:30 - 09:20', 1),	(512,'S', '10:00 - 10:50', 1),	(514,'S', '11:25 - 12:15', 1),	(515,'S', '12:50 - 01:40', 1),
(517,'S', '02:15 - 03:05', 1),	(518,'S', '03:30 - 04:20', 1),	
(531,'S', '08:30 - 09:45', 3),	(532,'S', '10:00 - 11:15', 3),	(534 ,'S', '11:25 - 12:40', 3),	(535, 'S', '12:50 - 02:05', 3),	
(537,'S', '02:15 - 03:30', 3),	(538,'S', '03:30 - 04:45', 3),
(520,'S', '08:00 - 11:15', 2),	(523,'S', '11:25 - 02:05', 2),	(526, 'S', '02:15 - 04:50', 2)
; 

insert into classroom (Classroom_ID, Classroom_Name, Classroom_capacity)
values (1, 'Aggad225', 150),
(2, 'Aggad225', 45),
(3, 'Aggad325', 45),
(4, 'Aggad425', 18),
(5, 'Masri325', 18),
(6, 'Masri122', 45),
(7, 'Masri412', 150),
(8, 'BUSA123', 45),
(9, 'BUSA243', 150),
(10, 'O.Abdulhadi211', 45),
(11, 'S.Abdulhadi306', 45),
(12, 'Sadik111', 50),
(13, 'Sadik321', 35),
(14, 'Sadik222', 45)
;

insert into Section (Section_Academic_year, Section_semester, Professor_id, course_id)
values ( 2019, 1, 112, 'ENCE231'),
( 2019, 1, 113, 'ENCE331'),
( 2019, 3, 114, 'ENCE411'),
(2019, 1, 115, 'MATH132'),
( 2019, 2, 116, 'CHEM134'), --
( 2019, 2, 115, 'COMP431'),
( 2019, 2, 113, 'ENCE231'),
( 2019, 3, 112, 'ENME331'),
( 2019, 3, 117, 'PUAD332'),
( 2021, 1, 118, 'COMP131'), -- 
( 2021, 1, 119, 'ENME331'),
( 2021, 1, 120, 'LAWS131'),
( 2021, 1, 123, 'PHYS134'),--
( 2021, 2, 124, 'MATH132'),
( 2021, 2, 128, 'ENCE411'),
(2021, 2, 122, 'ENCE231')
;

insert sectionisin(section_id, classroom_id, Timeperiod_id)
values(1, 1, 132),
(2, 2, 232),
(3, 3, 420),
(4, 5, 531),
(5, 2, 431),
(6, 5, 331),
(7, 1, 334),
(8, 7, 534),
(9, 8, 434),
(10, 8, 431),
(11, 14, 432),
(12, 13, 134),
(13, 11, 135),
(14, 9, 131),
(15, 7, 320),
(16, 11, 334)
;
select * from program;
select * from Course;

insert into study_plan(Program_ID, Course_id)
values
(1111, 'CHEM134'),
(1111, 'COMP131'),
(1111, 'ENCE231'),
(1111, 'ENME131'),
(1111, 'LAWS222'),
(1111, 'MATH134'),
(1111, 'MATH132'),
(1111, 'PHYS131'),
(1111, 'PHYS134'),
(1111, 'ENCE331'),
(1111, 'ENCE411'), 

(1112, 'CHEM134'),
(1112, 'COMP131'),
(1112, 'ENCE231'),
(1112, 'ENME131'),
(1112, 'MATH134'),
(1112, 'MATH132'),
(1112, 'PHYS131'),
(1112, 'PHYS134'),
(1112, 'ENME331'),
(1112, 'PUAD332'),

(1113, 'CHEM134'),
(1113, 'COMP131'),
(1113, 'ENCE231'),
(1113, 'ENME131'),
(1113, 'LAWS222'),
(1113, 'MATH134'),
(1113, 'MATH132'),
(1113, 'PHYS131'),
(1113, 'PHYS134'),
(1113, 'COMP431'),

(1114, 'COMP131'),
(1114, 'MATH134'),
(1114, 'MATH132'),
(1114, 'PHYS131'),
(1114, 'PHYS134'),
(1114, 'PUAD332'),
(1114, 'PUAD422'),
(1114, 'COMP333'),

(2115, 'PUAD422'),
(2115, 'COMP333'),
(2115, 'COMP131'),

(1116, 'COMP131'),
(1116, 'MATH134'),
(1116, 'PHYS131'),
(1116, 'CHEM134'),
(1116, 'LAWS131'),

(1117, 'COMP131'),
(1117, 'MATH134'),
(1117, 'MATH132'),
(1117, 'PHYS131'),
(1117, 'LAWS131'),

(2118, 'MATH134'),
(2118, 'MATH132'),
(2118, 'PHYS131'),
(2118, 'PHYS134'),

(1120, 'COMP131'),
(1120, 'MATH134'),
(1120, 'PUAD332'),
(1120, 'PUAD422'),
(1120, 'LAWS131'),
(1120, 'LAWS222'),

(1121, 'COMP131'),
(1121, 'MATH134'),
(1121, 'PUAD332'),
(1121, 'PUAD422'),
(1121, 'LAWS131'),
(1121, 'MATH132')
;






insert into senrollss values(1210005, 4, 0, 100);
insert into senrollss values(1210005, 16, 0, 100);





update classroom set classroom_capacity = 1 where classroom_id = 11;
insert into section (Section_Academic_year, Section_semester, Professor_id, course_id) values(2019, 2, 122, 'PHYS131');
insert into senrollss values(1210005, 17, 0, 100);
insert into section (Section_Academic_year, Section_semester, Professor_id, course_id) values(2021, 2, 122, 'PHYS134');
insert into sectionisin values(1, 18, 334);
insert into section (Section_Academic_year, Section_semester, Professor_id, course_id) values(2021, 2, 123, 'PHYS134');
insert into sectionisin values(1, 19, 334);
insert into section (Section_Academic_year, Section_semester, Professor_id, course_id) values(2021, 2, 123, 'PHYS134');
insert into sectionisin values(1, 20, 126);
insert into section (Section_Academic_year, Section_semester, Professor_id, course_id) values(2021, 2, 121, 'MATH134');
insert into sectionisin values(1, 21, 112);
