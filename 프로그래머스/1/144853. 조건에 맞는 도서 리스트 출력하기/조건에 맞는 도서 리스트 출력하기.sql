-- 코드를 입력하세요
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM book
WHERE DATE_FORMAT(PUBLISHED_DATE, '%Y') = '2021' 
AND CATEGORY = '인문';