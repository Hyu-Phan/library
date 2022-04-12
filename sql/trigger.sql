CREATE OR REPLACE FUNCTION borrowed_insert_trigger()
RETURNS TRIGGER AS $$
BEGIN
    IF ( NEW.date >='2022-01-01' AND
         NEW.date < '2022-02-01' ) THEN
        INSERT INTO borrowed_m01 VALUES (NEW.*);
		
    ELSIF ( NEW.date >= DATE '2022-02-01' AND
         NEW.date < DATE '2022-03-01' ) THEN
        INSERT INTO borrowed_m02 VALUES (NEW.*);
		
    ELSIF ( NEW.date >= DATE '2022-03-01' AND
         NEW.date < DATE '2022-04-01' ) THEN
        INSERT INTO borrowed_m03 VALUES (NEW.*);
		
	ELSIF ( NEW.date >= DATE '2022-04-01' AND
         NEW.date < DATE '2022-05-01' ) THEN
        INSERT INTO borrowed_m04 VALUES (NEW.*);
		
	ELSIF ( NEW.date >= DATE '2022-05-01' AND
         NEW.date < DATE '2022-06-01' ) THEN
        INSERT INTO borrowed_m05 VALUES (NEW.*);
		
	ELSIF ( NEW.date >= DATE '2022-06-01' AND
         NEW.date < DATE '2022-07-01' ) THEN
        INSERT INTO borrowed_m06 VALUES (NEW.*);
		
	ELSIF ( NEW.date >= DATE '2022-07-01' AND
         NEW.date < DATE '2022-08-01' ) THEN
        INSERT INTO borrowed_m07 VALUES (NEW.*);
		
	ELSIF ( NEW.date >= DATE '2022-08-01' AND
         NEW.date < DATE '2022-09-01' ) THEN
        INSERT INTO borrowed_m08 VALUES (NEW.*);
		
	ELSIF ( NEW.date >= DATE '2022-09-01' AND
         NEW.date < DATE '2022-10-01' ) THEN
        INSERT INTO borrowed_m09 VALUES (NEW.*);
		
	ELSIF ( NEW.date >= DATE '2022-10-01' AND
         NEW.date < DATE '2022-11-01' ) THEN
        INSERT INTO borrowed_m10 VALUES (NEW.*);
		
	ELSIF ( NEW.date >= DATE '2022-11-01' AND
         NEW.date < DATE '2022-12-01' ) THEN
        INSERT INTO borrowed_m11 VALUES (NEW.*);
	ELSIF ( NEW.date >= DATE '2022-12-01' AND
         NEW.date < DATE '2023-01-01' ) THEN
        INSERT INTO borrowed_m12 VALUES (NEW.*);
		
    ELSE
        RAISE EXCEPTION 'Date out of range.  Fix the borrowed_insert_trigger() function!';
    END IF;
    RETURN NULL;
END;
$$
LANGUAGE plpgsql;