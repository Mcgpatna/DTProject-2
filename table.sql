--Tables details used in Collaboration Project of DT course
drop table blog

create table blog
(
  blogid number(5),
  blogName varchar(100),
  blogContent varchar(300),
  loginName varchar(50),
  createDate date default sysdate,
  likes number(5),
  status varchar2(10)
  )
  
  drop sequence myblog_seq
  create sequence myblog_seq start with 1001
  drop sequence blgComment_seq
  create sequence blgComment_seq start with 1001
  
drop table forum  
 create table forum
(
  forumid number(5),
  forumName varchar(100),
  forumContent varchar(300),
  loginName varchar(50),
  createDate date default sysdate,
  likes number(5),
  status varchar2(10)
  )
  
  drop sequence myforum_seq
  create sequence myforum_seq start with 1001
  
  create table forumcomment
  (
    COMMENTID	NUMBER(10,0),
    COMMENTDATE	date default sysdate,
    COMMENTTEXT	VARCHAR2(255),
    FORUMID	NUMBER(10,0),
    LOGINNAME	VARCHAR2(255)
  )
  drop sequence forumComment_seq
  create sequence forumComment_seq start with 1001
 
 drop table job
 create table job
 (
  JOBID	NUMBER(10,0),
  COMPANY	VARCHAR2(255),
  JOBDESCRIPTION	VARCHAR2(255),
  JOBDESIGNATION	VARCHAR2(30),
  PUBLISHDATE	date default sysdate,
  LOCATION	VARCHAR2(255),
  SALARY	NUMBER(10,0)
  )
  
  drop sequence myjob_seq
  create sequence myjob_seq start with 1001
  
  drop table jobapplydetails
  create table jobapplydetails
  (
    JOBAPPLYID NOT NULL NUMBER(10),        
    APPLYDATE  date default sysdate,                                                                                                                                                                                  
    JOBID  NOT NULL NUMBER(10),                                                  
    USERNAME VARCHAR2(50)
  )
  
  drop sequence jobapply_seq
  create sequence jobapply_seq start with 1001
  
  select jobapply_seq.currval from dual
  
 
  
  drop table userdetail
  create table userdetail
  (
    LOGINNAME	VARCHAR2(50) primary key,
    ADDRESS	VARCHAR2(255) not null,
    EMAILID	VARCHAR2(50) not null,
    MOBILENO	VARCHAR2(15) not null,
    USERNAME	VARCHAR2(50) not null,
    PASSWORD	VARCHAR2(50) not null,
    ROLE	VARCHAR2(10) not null,
	is_online NUMBER(1) default '0' not null,
    STATUS	VARCHAR2(2) not null
  )
  -- creating table for profile picture
  
  drop table userprofile
  create table UserProfile
  (
     loginname varchar2(50),
     image blob
  )
  
  drop sequence myprofile_seq
  create sequence myprofile_seq start with 1001
  
  drop table friend
  create table friend
  (
    FRIENDID	NUMBER(10,0) primary key,
    FRIENDLOGINNAME	VARCHAR2(50) not null,
    LOGINNAME	VARCHAR2(50) not null,
    STATUS	VARCHAR2(10) not null
  )
  
  drop sequence myfriend_seq
  create sequence myfriend_seq start with 1001
   
  
  select * from userprofile
  
  
  
  
  
  
  