CREATE TABLE IF NOT EXISTS employees (
	id VARCHAR(40) PRIMARY KEY,
  	cpf VARCHAR(11) UNIQUE NOT NULL,
  	registration VARCHAR(10) UNIQUE NOT NULL,
  	name VARCHAR(60) NOT NULL,
  	email VARCHAR(20) NOT NULL,
  	phone VARCHAR(20) NOT NULL
);

INSERT INTO 
	employees 
    	(id, cpf, registration, name, email, phone) 
	VALUES(
    	'92328503-cbae-4969-a077-8b45a9665243',
        '11111111111',
        '494229',
        'Henrique Vieira',
        'henricker@email.com',
        '5511911111111'
    );


