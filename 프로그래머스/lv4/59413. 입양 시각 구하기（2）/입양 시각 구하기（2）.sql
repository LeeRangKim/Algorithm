-- 코드를 입력하세요
set @hour := -1;

SELECT (@hour := @hour +1) as HOUR,
(SELECT count(*) from ANIMAL_OUTS where HOUR(DATETIME) = @hour) as COUNT
from ANIMAL_OUTS
where @hour < 23;
