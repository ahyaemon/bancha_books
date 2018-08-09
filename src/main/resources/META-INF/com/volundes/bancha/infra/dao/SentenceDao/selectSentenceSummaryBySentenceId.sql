SELECT
  s.sentence_id,
  s.sentence,
  c.comment_id,
  c.name AS comment_name,
  c.comment
FROM
  sentence s
  LEFT OUTER JOIN
    comment c
	ON s.sentence_id = c.sentence_id
WHERE
  s.sentence_id = /* sentenceId */1
ORDER BY
  c.comment_id
