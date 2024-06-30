drop database bzurs;
create database BZURS;
use BZURS;

create table Student(
Student_ID int not null auto_increment, 
student_Name varchar(64) not null,
National_ID int not null unique,
BirthDate date not null,
gender character not null,
phone_Number char(10) not null unique,
address varchar(64) not null,
graduation_Status varchar(64),
balance float not null,
email varchar(32) not null unique,
community_Hours int,
major_id int not null,
GPA real ,
primary key (Student_id)
);

alter table student auto_increment = 1180001;



create table Program(
Program_ID int not null primary key,
Program_Name varchar(60) not null,
abbreviation char(4) not null,
credit_hours int not null,
Credit_hour_price int not null,
major_minor char(5) not null, -- minor or major
program_department_id int not null
);

create table course(
Course_ID varchar(8) not null primary key,
Course_name varchar(64) not null,
Credit_Hours int generated always as (convert(substring(Course_ID, 6,1), UNSIGNED INTEGER)),
course_department_ID int not null
);


create table pre_course(
Course_ID varchar(8) not null,
Pre_Course_ID varchar(8) not null,
primary key (Course_ID, Pre_Course_ID),
foreign key (Pre_Course_ID) references Course(Course_ID) on update cascade,
foreign key (Course_ID) references Course(Course_ID) on update cascade
);


create table study_plan( -- Program involves courses
Course_id varchar(8) not null,
Program_ID int not null,
foreign key (Program_ID) references Program(Program_ID) on update cascade,
foreign key (Course_id) references Course(Course_id) on update cascade,
Primary key(Program_ID, Course_id)
);


create table faculty(
Faculty_id int not null primary key,
faculty_Phone_number char(10) not null,
Faculty_name varchar(64) not null,
Faculty_Fax varchar(20),
Faculty_Email varchar(64),
faculty_manager_id int
);



create table department(
department_ID int not null primary key,
department_name varchar(64) not null,
department_phone_number varchar(15) not null,
department_Email varchar(64),
department_Fax varchar(20),
Faculty_id int not null,
department_Manager_Id int
);


create table section(
Section_ID int not null auto_increment primary key ,
Section_Academic_year int not null,
Section_semester int not null,
Professor_id int not null,
course_id varchar(8) not null,
-- year_tag int generated always as (convert(concat(section_academic_year, section_semester), UNSIGNED INTEGER)),
foreign key (course_id) references Course (Course_id) on update cascade
);


create table professor(
Professor_ID int not null primary key, 
professor_Name varchar(64) not null,
professor_NID int not null unique,
professor_BDate date not null,
professor_gender character not null,
professor_phoneNo char(10) not null unique,
professor_address varchar(64) not null,
professor_Degree varchar(64),
professor_email varchar(32) not null unique,
professor_Age int,
department_id int not null,
foreign key (department_id) references department(department_id) on update cascade
);


create table Classroom(
Classroom_ID int not null primary key,
Classroom_Name varchar(30),
Classroom_capacity int not null
);



create table Timeperiod(
Timeperiod_id int primary key,
DayComb varchar(4) not null,
TimeComb varchar(16) not null,
Course_type int not null
);

create table SectionIsIn(
classroom_id int not null,
section_id int not null,
Timeperiod_id int not null,
primary key(Timeperiod_id, classroom_id, section_id),
foreign key (section_id) references Section(Section_id) on update cascade,
foreign key (classroom_id) references classroom(classroom_id) on update cascade,
foreign key (Timeperiod_id) references Timeperiod(Timeperiod_id)on update cascade
); 


create table SenrollsS(
Student_id int not null,
section_id int not null,
Number_of_absences int default 0,
Grade real default 55,
primary key (Student_id,section_id),
foreign key(Student_id) references Student(Student_id) on update cascade,
foreign key(section_id) references Section(Section_id) on update cascade
);

create table SdoMinor (
Student_id int not null,
Minor_id int not null,
foreign key(Student_id) references Student(Student_id) on update cascade,
foreign key(Minor_id) references Program(Program_id) on update cascade,
primary key (Student_id, Minor_id)
);


alter table Student add constraint Major_Id foreign key ( Major_id) references Program(Program_id) on update cascade; 

alter table Program add constraint Program_Department_id foreign key (Program_Department_id) references Department(Department_id) on update cascade; 

alter table Course add constraint course_department_ID foreign key (course_department_ID) references Department(Department_id) on update cascade;

alter table Faculty add constraint faculty_manager_id foreign key (faculty_manager_id) references professor(professor_id) on update cascade;

alter table department add constraint department_manager_id foreign key (department_manager_id) references professor(professor_id) on update cascade;
alter table department add constraint faculty_id foreign key (faculty_id) references faculty(faculty_id) on update cascade;

alter table section add constraint professor_id foreign key (professor_id) references professor(professor_id) on update cascade;

