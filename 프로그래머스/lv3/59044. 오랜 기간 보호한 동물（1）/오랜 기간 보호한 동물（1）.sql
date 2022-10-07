-- 코드를 입력하세요
# select name from ANIMAL_OUTs order by DATETIME;

SELECT i.NAME, i.DATETIME from ANIMAL_INS i left outer JOIN ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID where o.ANIMAL_ID is null order by i.DATETIME limit 3;