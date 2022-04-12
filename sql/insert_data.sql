CREATE PROCEDURE insert_data(m date, d integer)
LANGUAGE SQL
AS $$
 	insert into public.borrowed(user_id, book_id, date)
 	select (random()*3)::int+1, (random()*3)::int+1,
 		(m + '1 day'::INTERVAL * ((RANDOM()*d)::int) ):: date
	from generate_series(1, 100000);
$$;

CALL insert_data('2022-01-01', 30);
CALL insert_data('2022-02-01', 27);
CALL insert_data('2022-03-01', 29);
CALL insert_data('2022-04-01', 30);
CALL insert_data('2022-05-01', 29);
CALL insert_data('2022-06-01', 30);
CALL insert_data('2022-07-01', 29);
CALL insert_data('2022-08-01', 30);
CALL insert_data('2022-09-01', 29);
CALL insert_data('2022-10-01', 30);
CALL insert_data('2022-11-01', 29);
CALL insert_data('2022-12-01', 30);