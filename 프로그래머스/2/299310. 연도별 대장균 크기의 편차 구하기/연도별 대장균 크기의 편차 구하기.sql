SELECT 
    B.year AS YEAR, 
    B.year_max - A.SIZE_OF_COLONY AS YEAR_DEV,
    A.ID 
FROM 
    ECOLI_DATA A
JOIN 
    (
        SELECT 
            YEAR(DIFFERENTIATION_DATE) AS year,
            MAX(SIZE_OF_COLONY) AS year_max
        FROM 
            ECOLI_DATA 
        GROUP BY 
            YEAR(DIFFERENTIATION_DATE)
    ) AS B
ON 
    YEAR(A.DIFFERENTIATION_DATE) = B.year
ORDER BY 
    YEAR, YEAR_DEV;
