-- 코드를 입력하세요
SELECT o.ANIMAL_ID, i.NAME
from ANIMAL_OUTS o
inner join ANIMAL_INS i
on o.ANIMAL_ID = i.ANIMAL_ID
order by o.DATETIME - i.DATETIME desc
limit 2