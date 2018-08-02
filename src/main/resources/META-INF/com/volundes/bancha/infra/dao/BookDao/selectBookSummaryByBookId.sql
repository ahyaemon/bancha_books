SELECT
  b.book_id,
  b.name,
  a.author_id,
  a.name AS author_name,
  s.sentence_id,
  s.sentence,
  c.comment_id,
  c.name AS comment_name,
  c.comment
FROM
  book b
  INNER JOIN
    author a
	ON b.author_id = a.author_id
  INNER JOIN
    sentence s
	ON b.book_id = s.book_id
  LEFT OUTER JOIN
    comment c
	ON s.sentence_id = c.sentence_id
WHERE
  b.book_id = /* bookId */1
ORDER BY
  s.sentence_id
