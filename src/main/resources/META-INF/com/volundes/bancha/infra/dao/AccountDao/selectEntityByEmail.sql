SELECT
  a.id as account_id,
  a.name,
  ai.id as auth_info_id,
  ai.email,
  ai.password,
  ai.role,
  h.id as hitokoto_id,
  h.value as hitokoto_value
FROM
  account a
INNER JOIN
  auth_info ai
  ON
    ai.account_id = a.id AND
    ai.email = /* email */''
LEFT OUTER JOIN
  hitokoto h
  ON
    h.account_id = a.id
