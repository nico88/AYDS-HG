START TRANSACTION;

DELETE FROM owners;
DELETE FROM buildings;
DELETE FROM real_estates;
DELETE FROM owners_real_estates;

INSERT INTO owners (id, first_name, last_name, city, street, neighborhood, email)
VALUES
    (1, 'oscar', 'cordoba', 'rio cuarto', 'san martin 1', 'centro', 'oscar@gmail.com' ),
    (2, 'jorge', 'bermudez', 'comodoro rivadavia', 'bs as 2', 'microcentro', 'jorge@gmail.com' ),
    (3, 'rodolfo', 'arruabarrena', 'rio cuarto', 'colon 3', 'macrocentro', 'rodolfo@gmail.com' ),
    (4, 'hugo', 'ibarra', 'comodoro rivadavia', 'moreno 4', 'centro', 'hugo@gmail.com' ),
    (5, 'mauricio', 'serna', 'rio cuarto', 'san juan 5', 'microcentro', 'mauricio@gmail.com' ),
    (6, 'walter', 'samuel', 'comodoro rivadavia', 'goudard 6', 'macrocentro', 'walter@gmail.com' ),
    (7, 'guillermo', 'b.schelloto', 'rio cuarto', 'dinkeldein 7', 'centro', 'guillermo@gmail.com' ), 
    (8, 'diego', 'cagna', 'comodoro rivadavia', 'roma 8', 'microcentro', 'diego@gmail.com' ), 
    (9, 'martin', 'palermo', 'rio cuarto', 'mendoza 9', 'macrocentro', 'martin@gmail.com' ), 
    (10, 'juan roman', 'riquelme', 'comodoro rivadavia', 'mitre 10', 'centro', 'juanroman@gmail.com' ), 
    (11, 'gustavo', 'b.schelloto', 'rio cuarto', 'cabrera 11', 'microcentro', 'gustavo@gmail.com' ); 
                
INSERT INTO buildings (id, type, city, street, neighborhood, description, price, operation, owner_id )
VALUES 
	(1, 'land', 'comodoro rivadavia', 'bs as 54', 'centro', 'campo', 1000, 'rent', 1 ),  
	(2, 'farm', 'rio cuarto', 'colon 46', 'microcentro', 'quinta', 2000, 'sale', 7 ),  
	(3, 'house', 'comodoro rivadavia', 'moreno 39', 'macrocentro', 'casa', 3000, 'rent', 5 ),  
	(4, 'apartment', 'rio cuarto', 'san juan 879', 'centro', 'departamento', 4000, 'sale', 9 ),  
	(5, 'office', 'comodoro rivadavia', 'mitre 12', 'microcentro', 'oficina', 5000, 'rent', 11 ),  
	(6, 'garage', 'rio cuarto', 'cordoba 10', 'macrocentro', 'cochera', 6000, 'sale', 10 );
	
INSERT INTO real_estates (id, name, city, street, neighborhood, email, website )
VALUES
	(1, 'lapegue', 'comodoro rivadavia', 'irigoyen 540', 'centro', 'lapegue@gmail.com', 'www.lapegue.com.ar' ),  
	(2, 'ottonelli', 'rio cuarto', 'alberdi 98', 'microcentro', 'ottonelli@gmail.com', 'www.ottonelli.com.ar' ),  
	(3, 'pedrueza', 'comodoro rivadavia', '25 de mayo 234', 'macrocentro', 'pedrueza@gmail.com', 'www.pedrueza.com.ar' ),  
	(4, 'gutierrez', 'rio cuarto', 'alvear 356', 'centro', 'gutierrez@gmail.com', 'www.gutierrez.com.ar' ),  
	(5, 'alvarez', 'comodoro rivadavia', 'ituzaingo 578', 'microcentro', 'alvarez@gmail.com', 'www.alvarez.com.ar' );  
	
INSERT INTO owners_real_estates (owner_id, real_estate_id )
VALUES
	(2, 1),
	(4, 2),
	(6, 3),
	(8, 4),
	(10, 5);
	
COMMIT;	
