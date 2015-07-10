insert into Quotes 
(quote) values('Don''t cry because it''s over, smile because it happened');

insert into Quotes 
(quote) values('Be yourself; everyone else is already taken');

insert into Quotes 
(quote) values('A room without books is like a body without a soul');


insert into Categories 
(name) values('Sport');

insert into Categories 
(name) values('Business');


insert into Projects ( 
id_category, name, description, 
total_amount, final_date,  
history, link 
) 
values(1, 'velo parking', 'velo parking in Kiev', 
10000, '2015-09-30',  
'History1', 'www.project1.com');

insert into Projects ( 
id_category, name, description, 
total_amount, final_date,  
history, link 
) 
values(1, 'velo track', 'velo track in Kiev', 
100000, '2015-12-31',  
'History2', 'www.project2.com');
		
insert into Projects ( 
id_category, name, description, 
total_amount, final_date,  
history, link 
) 
values(2, 'IT-school', 'IT - future of Ukraine', 
1000000, '2016-05-31',  
'History3', 'www.project3.com');


insert into Payments ( 
id_project, amount 
) 
values(1, 500); 

insert into Payments ( 
id_project, amount 
) 
values(2, 5000); 

insert into Payments ( 
id_project, amount 
) 
values(3, 50000); 


insert into Questions ( 
id_project, question 
) 
values(1, 'Question 1?'); 

insert into Questions ( 
id_project, question 
) 
values(2, 'Question 2?'); 

insert into Questions ( 
id_project, question 
) 
values(3, 'Question 3?'); 


insert into PaymentVariants ( 
id_project, amount, description 
) 
values(1, 10, 'minimum'); 

insert into PaymentVariants ( 
id_project, amount, description 
) 
values(1, 100, 'medium'); 

insert into PaymentVariants ( 
id_project, amount, description 
) 
values(1, 500, 'high'); 

insert into PaymentVariants ( 
id_project, amount, description 
) 
values(2, 10000, 'standart'); 

insert into PaymentVariants ( 
id_project, amount, description 
) 
values(3, 50000, 'standart'); 
