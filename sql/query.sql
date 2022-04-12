-- select b.name as name, count(*) as number
--             from borrowed br join book b on br.book_id = b.id
--             where extract(month from br.date) >= 2 and extract(month from br.date) < 4
--             group by b.id
-- 			order by number desc

select b.name as name, count(*) as number
            from borrowed br join book b on br.book_id = b.id
            where br.date >= '2022-01-01' and br.date <= '2022-02-02'
            group by b.id
			order by number desc