INSERT INTO USERS(USER_ID,PASSWORD,CUS_TYPE) VALUES ('Jeetu','jadon@123','regular'),
('Gursheen','Aura@2020','premium'),
('Shruti','sh@2020','gold');


INSERT INTO CUSTOMER_TYPE_DISCOUNT VALUES('regular',0,5000, 0),
('regular',5000,10000, 10),
('regular',10000,null, 20),
('premium',0,4000, 10),
('premium',4000,8000, 15),
('premium',8000,12000, 20),
('premium',12000,null, 30);
