WITH
  c
  AS (
    SELECT
      count(1) as comment_count,
	    sentence_id
    FROM
      comment
    GROUP BY
      sentence_id
  )
SELECT
  b.book_id,
  b.name,
  a.author_id,
  a.name AS author_name,
  s.sentence_id,
  s.sentence,
  s.heading,
  CASE WHEN c.comment_count is null THEN 0
    ELSE c.comment_count
  END
FROM
  book b
  INNER JOIN
    author a
	ON b.author_id = a.author_id
  INNER JOIN
    sentence s
	ON b.book_id = s.book_id
  LEFT OUTER JOIN
    c
	ON s.sentence_id = c.sentence_id
WHERE
  b.book_id = /* bookId */1
ORDER BY
  s.sentence_id
