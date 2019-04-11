create database CoursemangeemntSystem;
use CoursemangeemntSystem;
create table Course(cCode varchar(30) not null primary key,
cTitle varchar(50) not null)
insert into Course(cCode,cTitle)values('CS11','OOP')
insert into Course(cCode,cTitle)values('CS12','Database')
insert into Course(cCode,cTitle)values('CS13','C++ Programing')
insert into Course(cCode,cTitle)values('CS14','Java Programong')



  create table Faculty(empID varchar(30) not null primary key,
  name varchar (30) not null,contact bigint not null,
  salary float not null)
  insert into Faculty(empID,name,contact,salary) 
  values('E11','Ibtisam Gull',0312453666,80000.0)
   insert into Faculty(empID,name,contact,salary) 
  values('E12','Mukhtiyar Zamin',03993322,80000.0)
   insert into Faculty(empID,name,contact,salary) 
  values('E13','akhter Jamil',0311116,70000.0)
   insert into Faculty(empID,name,contact,salary) 
  values('E14','Shahid Khan',0312453666,60000.0)
  
  
  create table Student(reg varchar(20) not null primary key,
  name varchar(40)  not null, contact bigint not null)
  insert into Student(reg,name,contact)values
  ('001','Zubair',015778523)
   insert into Student(reg,name,contact)values
  ('002','Bhagchand',015365467)
   insert into Student(reg,name,contact)values
  ('003','Umar',0168483903)
   insert into Student(reg,name,contact)values
  ('004','Laiq',015323221)
  
  create table Allocated(cCode varchar(30) references Course(cCode) not null,
  allocationDate date not null ) 
  insert into Allocated(cCode,allocationDate) values('CS11','2-1-2014') 
  insert into Allocated(cCode,allocationDate) values('CS12','3-2-2014') 
  insert into Allocated(cCode,allocationDate) values('CS13','5-6-2013')
  insert into Allocated(cCode,allocationDate) values('CS14','3-9-2014')
    
  create Table StudentAttendence(cCode varchar(30) references Course(cCode) not null,
  regNo varchar(20) not null references Student(reg),timeOfAtt datetime,StdStatus bit
  ,constraint myCRPKI primary key(cCode,regNo,timeOfAtt))
drop Table StudentAttendence
  insert into StudentAttendence(cCode,regNo,timeOfAtt,StdStatus)values('CS11','001','2014-11-01 8:30:45.70','0')
   insert into StudentAttendence(cCode,regNo,timeOfAtt,StdStatus)values('CS12','002','2014-11-01 8:30:45.70','1')
    insert into StudentAttendence(cCode,regNo,timeOfAtt,StdStatus)values('CS11','001','2014-11-02 8:30:45.70','0')
     insert into StudentAttendence(cCode,regNo,timeOfAtt,StdStatus)values('CS11','001','2014-11-03 8:30:45.70','0')
       insert into StudentAttendence(cCode,regNo,timeOfAtt,StdStatus)values('CS11','001','2014-11-04 8:30:45.70','0')
       insert into StudentAttendence(cCode,regNo,timeOfAtt,StdStatus)values
       ('CS11','001','2014-11-01 8:30:44.70','0')
        insert into StudentAttendence(cCode,regNo,timeOfAtt,StdStatus)values
       ('CS11','001','2014-11-01 9:30:44.70','0')
       
       
Create TRIGGER trgAfterUpdate ON StudentAttendence
FOR insert
AS 
	declare @id varchar(20);
	declare @StdStatus bit;
	declare @ccode varchar(30);
	--declare @Mycount int;
	
    select @id=i.regNo from inserted i;	
	select @ccode=i.cCode from inserted i;
	select @StdStatus=i.Std	
    Select COUNT(*) as Mycount from StudentAttendence where @StdStatus='0'
    if(Mycount=4)
	Begin
	      --delete StudentAttendence where StudentAttendence.regNo=@id 
	        --and StudentAttendence.cCode=@ccode;
	      print('Course Droped')
		  end
	GO
       
      Select *from StudentAttendence

     --create Table Attendence( idAndCode varchar(20) references Takes(regNo)
     --,course varchar(30) references Takes(cCode),)
     
     
     
     
     
     select COUNT(*) as maximumSalary from Faculty
     where salary>60000 and salary<=80000;
     
     select MAX(salary) as maxsalary from Faculty;
      select MIN(salary) as Minsalary from Faculty;
       select AVG(salary) as avergesalary from Faculty;
        select SUM(salary) as totalsalary from Faculty;