SELECT
  b.id,
  b.name as name,
  a.name as author
FROM
  book b
  INNER JOIN
    author a
	ON
	  b.author_id = a.id
ORDER BY
  b.id
