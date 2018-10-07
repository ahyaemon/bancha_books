SELECT
    count(1) as comment_count,
    sentence_id
FROM
    comment
WHERE
    sentence_id in /* sentenceIds */(1, 2, 3)
GROUP BY
    sentence_id
