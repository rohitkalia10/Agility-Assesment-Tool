INSERT INTO User (UID, FIRST_NAME, LAST_NAME, EMAIL, USER_ROLE)
	VALUES('1', 'sanjay', 'kumar', 'sanjay@sanjay.com', 'user');
INSERT INTO User (UID, FIRST_NAME, LAST_NAME, EMAIL, USER_ROLE)
	VALUES('2', 'prabhu', 'mahapatro', 'prabhu@prabhu.com', 'user');
INSERT INTO User (UID, FIRST_NAME, LAST_NAME, EMAIL, USER_ROLE)
	VALUES('3', 'vinay', 'kureel', 'vinay@vinay.com', 'user');
INSERT INTO User (UID, FIRST_NAME, LAST_NAME, EMAIL, USER_ROLE)
	VALUES('4', 'rohit', 'kalia', 'rohit@rohit.com', 'admin');


INSERT INTO Question (TYPE_CODE, QUESTION_CODE, TYPE_NAME, QUESTION)
	VALUES('1', '1', 'Core Evaluators', 'Team Skills/ Competencies');
INSERT INTO Question (TYPE_CODE, QUESTION_CODE, TYPE_NAME, QUESTION)
   	VALUES('1', '2', 'Core Evaluators', 'Stability in team');
INSERT INTO Question (TYPE_CODE, QUESTION_CODE, TYPE_NAME, QUESTION)
  	VALUES('1', '3', 'Core Evaluators', 'Happiness & Satisfaction');
INSERT INTO Question (TYPE_CODE, QUESTION_CODE, TYPE_NAME, QUESTION)
    VALUES('2', '1', 'Team Agility', 'Team being self-organized');
INSERT INTO Question (TYPE_CODE, QUESTION_CODE, TYPE_NAME, QUESTION)
    VALUES('2', '2', 'Team Agility', 'Daily Stand ups');
INSERT INTO Question (TYPE_CODE, QUESTION_CODE, TYPE_NAME, QUESTION)
    VALUES('3', '1', 'Performance', 'Code Quality');
INSERT INTO Question (TYPE_CODE, QUESTION_CODE, TYPE_NAME, QUESTION)
    VALUES('3', '2', 'Performance', 'Sprint Scope');

Insert into ANSWER (USER_ID,ANSWERS,Q_CODE,SUBMISSION,T_CODE) Values (1,6,1,'Q1 2019',1);
Insert into ANSWER (USER_ID,ANSWERS,Q_CODE,SUBMISSION,T_CODE) Values (1,6,3,'Q1 2019',1);
Insert into ANSWER (USER_ID,ANSWERS,Q_CODE,SUBMISSION,T_CODE) Values (1,4,2,'Q1 2019',2);
Insert into ANSWER (USER_ID,ANSWERS,Q_CODE,SUBMISSION,T_CODE) Values (1,4,2,'Q1 2019',3);
