-- 코드를 입력하세요
SELECT I.REST_ID, I.REST_NAME,I.FOOD_TYPE, I.FAVORITES, I.ADDRESS,
ROUND(AVG(REVIEW_SCORE),2) as SCORE
FROM REST_INFO I JOIN REST_REVIEW R ON I.REST_ID = R.REST_ID
WHERE I.ADDRESS LIKE '서울%'
GROUP BY I.REST_ID
ORDER BY SCORE DESC, FAVORITES DESC