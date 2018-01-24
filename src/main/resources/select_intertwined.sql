SELECT *
FROM (SELECT
        2 * row_number()
        OVER () AS ROWNUM,
        NAME,
        SEX
      FROM PEOPLE
      WHERE SEX = 'M'
      UNION SELECT
              2 * row_number()
              OVER () + 1 AS ROWNUM,
              NAME,
              SEX
            FROM PEOPLE
            WHERE SEX = 'F') T
ORDER BY ROWNUM