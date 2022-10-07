-- 코드를 입력하세요
SELECT HOUR(DATETIME) as h, count(*) from ANIMAL_OUTS GROUP BY h having h >= 9 
and h <= 19 order by h; 