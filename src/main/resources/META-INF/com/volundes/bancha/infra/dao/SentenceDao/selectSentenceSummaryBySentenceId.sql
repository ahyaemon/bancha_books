SELECT
  s.sentence_id,
  s.sentence,
  c.comment_id,
  c.account_id,
  c.comment,
  a.nickname as comment_name
FROM
  sentence s
  LEFT OUTER JOIN
    comment c
	ON 
	  s.sentence_id = c.sentence_id
  LEFT OUTER JOIN
    account a
	ON
	  c.account_id = a.account_id
WHERE
  s.sentence_id = /* sentenceId */1
ORDER BY
  c.comment_id
