SELECT
  COUNT(1) as url_key_count
FROM
  account_register
WHERE
  url_key = /* urlKey */''
