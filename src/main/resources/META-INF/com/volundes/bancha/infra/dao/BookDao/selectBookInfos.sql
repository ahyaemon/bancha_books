SELECT
  b.book_id,
  b.name,
  a.name AS author
FROM
  book b
  INNER JOIN
    author a
	ON b.author_id = a.author_id
ORDER BY
  b.book_id
