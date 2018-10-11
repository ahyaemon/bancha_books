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
  b.id as book_id,
  b.name,
  a.id as author_id,
  a.name AS author_name,
  l.id as license_id,
  l.notice,
  l.license_type,
  s.id as sentence_id,
  s.value,
  s.heading,
  CASE WHEN c.comment_count is null THEN 0
    ELSE c.comment_count
  END
FROM
  book b
  INNER JOIN
    author a
	  ON b.author_id = a.id
  INNER JOIN
    sentence s
	  ON b.id = s.book_id
  LEFT OUTER JOIN
    c
	  ON s.id = c.sentence_id
  LEFT OUTER JOIN
    license l
    ON b.id = l.book_id
WHERE
  b.id = /* bookId */1
ORDER BY
  s.id
