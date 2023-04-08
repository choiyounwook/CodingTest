-- 코드를 입력하세요
SELECT HOUR(DATETIME) as 'HOUR', count(HOUR(DATETIME)) as 'COUNT'
from ANIMAL_OUTS 
where HOUR(DATETIME) >= 9 AND HOUR(DATETIME) <= 19
group by HOUR
order by HOUR
