SELECT
    b.id as book_id,
    bi.id as book_info_id,
    bi.title as book_title,
    a.id as author_id,
    a.name as author_name,
    l.id as license_id,
    l.notice as license_notice,
    l.license_type as license_type,
    s.id as sentence_id,
    s.value as sentence_value,
    s.heading as sentence_heading
FROM
    book b
INNER JOIN
    book_info bi
    ON
        b.book_info_id = bi.id
INNER JOIN
    author a
    ON
        a.id = bi.author_id
LEFT OUTER JOIN
    license l
    ON
        l.book_info_id = bi.id
INNER JOIN
    sentence s
    ON
        s.book_id = b.id
WHERE
    b.id = /* bookId */'1'