-- Drop table

-- DROP TABLE public.heroes;

CREATE TABLE public.heroes (
	nombre varchar(100) NULL,
	casa varchar(100) NULL,
	bio varchar(500) NULL
);

INSERT INTO public.heroes (nombre,casa,bio) VALUES 
('Groot','Marvel','bio de groot')
,('War Machine','Marvel','bio de war machine')
,('Green Arrow','DC','bio de green arrow')
,('Steppenwolf','DC','bio de Steppenwolf')
;