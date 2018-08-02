SELECT
  b.book_id,
  b.name as name,
  a.name as author
FROM
  book b
  INNER JOIN
    author a
	ON
	  b.author_id = a.author_id
ORDER BY
  b.book_id
