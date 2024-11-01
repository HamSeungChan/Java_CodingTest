SELECT MONTH(START_DATE) as MONTH, CAR_ID, COUNT(*) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
                    SELECT CAR_ID
                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
                    GROUP BY CAR_ID
                    HAVING COUNT(*) >= 5                
                )
AND START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY MONTH(START_DATE), CAR_ID
HAVING COUNT(*) >= 1
ORDER BY MONTH, CAR_ID DESC