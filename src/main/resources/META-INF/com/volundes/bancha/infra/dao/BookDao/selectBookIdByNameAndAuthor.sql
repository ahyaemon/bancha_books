SELECT
  b.book_id
FROM
  book b
  INNER JOIN
    author a
    ON
      b.author_id = a.author_id
      AND a.name = /* author */''
WHERE
  b.name = /* name */''