-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/',A.BOARD_ID,'/',A.FILE_ID,A.FILE_NAME,A.FILE_EXT) as FILE_PATH
FROM USED_GOODS_FILE A
JOIN (
        SELECT *
        FROM USED_GOODS_BOARD 
        ORDER BY VIEWS DESC
        LIMIT 1
     ) B ON A.BOARD_ID = B.BOARD_ID
ORDER BY A.FILE_ID DESC


