CREATE TABLE nps_data(
	nps_id int primary key auto_increment,
	claim_number varchar(25),
	policy_number varchar(25),
	process_center varchar(25),
	company_code varchar(25),
	insured_name varchar(25),
	group_line varchar(25),
	line_code varchar(25),
	transaction_code varchar(25),
	transaction_description varchar(25),
	loss_date date,
	loss_amount decimal(25,2)
);