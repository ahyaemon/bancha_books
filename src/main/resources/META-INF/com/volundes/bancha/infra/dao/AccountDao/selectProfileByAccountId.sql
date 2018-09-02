SELECT
  a.account_id,
  a.name,
  a.pass,
  a.role,
  a.nickname,
  h.hitokoto_id,
  h.value as hitokoto_value
FROM
  account a
  INNER JOIN
    hitokoto h
    ON
      a.account_id = h.account_id
WHERE
  a.account_id = /* accountId */0
;