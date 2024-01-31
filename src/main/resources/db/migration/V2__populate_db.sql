INSERT INTO worker (name, birthday, level, salary)
VALUES
	('John Doe', '1990-03-15', 'Trainee', 700),
	('Jane Smith', '1985-08-22', 'Junior', 1200),
	('Alex Johnson', '1988-05-10', 'Senior', 5500),
	('Emily Davis', '1992-11-30', 'Trainee', 800),
	('Michael Brown', '1982-04-05', 'Middle', 2900),
	('Olivia Taylor',  '1995-07-18', 'Middle', 3000),
	('Ethan Miller', '1989-09-25', 'Senior', 6000),
	('Chloe Wilson', '1993-01-12', 'Senior', 5800),
	('Mason Harris', '1987-06-08', 'Junior', 1600),
	('Ava Robinson', '1994-02-28', 'Middle', 4000);

INSERT INTO client (name)
VALUES
	('Alice Johnson'),
	('Bob Smith'),
	('Claire Davis'),
	('David Miller'),
	('Emma Wilson');

INSERT INTO project (client_id, start_date, finish_date)
VALUES
   (1, CURRENT_DATE - INTERVAL '5' MONTH, CURRENT_DATE - INTERVAL '2' MONTH),
   (2, CURRENT_DATE - INTERVAL '12' MONTH, CURRENT_DATE - INTERVAL '6' MONTH),
   (3, CURRENT_DATE - INTERVAL '8' MONTH, CURRENT_DATE - INTERVAL '3' MONTH),
   (4, CURRENT_DATE - INTERVAL '20' MONTH, CURRENT_DATE - INTERVAL '10' MONTH),
   (1, CURRENT_DATE - INTERVAL '15' MONTH, CURRENT_DATE - INTERVAL '5' MONTH),
   (1, CURRENT_DATE - INTERVAL '3' MONTH, CURRENT_DATE + INTERVAL '2' MONTH),
   (2, CURRENT_DATE - INTERVAL '10' MONTH, CURRENT_DATE + INTERVAL '5' MONTH),
   (5, CURRENT_DATE - INTERVAL '6' MONTH, CURRENT_DATE + INTERVAL '3' MONTH),
   (4, CURRENT_DATE - INTERVAL '18' MONTH, CURRENT_DATE + INTERVAL '8' MONTH),
   (5, CURRENT_DATE - INTERVAL '13' MONTH, CURRENT_DATE + INTERVAL '2' MONTH);

INSERT INTO project_worker (project_id, worker_id)
VALUES
	(1, 1), (1, 2), (1, 3), (1, 4),(1, 5),
	(2, 8),
	(3, 7), (3, 9),
	(4, 10),
	(5, 10),
	(6, 9), (6, 5),
	(7, 3),
	(8, 4),
	(9, 4),
	(10, 5);