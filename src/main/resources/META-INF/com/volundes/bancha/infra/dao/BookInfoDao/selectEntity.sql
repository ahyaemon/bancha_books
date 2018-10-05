SELECT
  b.id as book_info_id,
  b.title,
  a.id as author_id,
  a.name as author_name,
  c.id as license_id,
  c.notice as license_notice,
  c.license_type
FROM
  book_info b
INNER JOIN
  author a
  ON
    b.author_id = a.id
LEFT OUTER JOIN
  license c
  ON
    c.book_info_id = a.id
ORDER BY
  b.id
