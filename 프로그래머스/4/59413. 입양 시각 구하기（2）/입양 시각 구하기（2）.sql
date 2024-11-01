# WITH RECURSIVE TIME (HOUR) AS
# (
#     SELECT 0
#     UNION ALL
#     SELECT HOUR + 1 FROM TIME WHERE HOUR < 23 
# )

# WITH RECURSIVE TIME (HOUR) AS 
# (
#     SELECT 0
#     UNION ALL
#     SELECT HOUR + 1
#     FROM TIME 
#     WHERE HOUR < 23
# ) 

WITH RECURSIVE TIME (HOUR) AS
(
    SELECT 0
    UNION ALL
    SELECT HOUR +1
    FROM TIME
    WHERE HOUR < 23
)

SELECT A.HOUR, IF(ANIMAL_ID IS NULL, 0, COUNT(*)) as COUNT
FROM TIME A LEFT JOIN ANIMAL_OUTS B
ON A.HOUR = HOUR(B.DATETIME)
GROUP BY A.HOUR