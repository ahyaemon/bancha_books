SELECT
  b.book_id,
  b.name as name,
  a.name as author,
  b.isbn
FROM
  book b
  INNER JOIN
    author a
	ON
	  b.author_id = a.author_id
WHERE
  b.book_id = /* bookId */1
