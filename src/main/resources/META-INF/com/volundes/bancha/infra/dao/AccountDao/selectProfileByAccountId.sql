SELECT
  a.id as account_id,
  a.name,
  a.pass,
  a.role,
  a.nickname,
  h.id as hitokoto_id,
  h.value as hitokoto_value
FROM
  account a
  INNER JOIN
    hitokoto h
    ON
      a.id = h.id
WHERE
  a.id = /* accountId */0
;