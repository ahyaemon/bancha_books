SELECT
  s.id as sentence_id,
  s.sentence,
  s.heading,
  c.id as comment_id,
  c.account_id,
  c.comment,
  a.name as comment_name
FROM
  sentence s
  LEFT OUTER JOIN
    comment c
	ON
	  s.id = c.sentence_id
  LEFT OUTER JOIN
    account a
	ON
	  c.account_id = a.id
WHERE
  s.id = /* sentenceId */1
ORDER BY
  c.id
