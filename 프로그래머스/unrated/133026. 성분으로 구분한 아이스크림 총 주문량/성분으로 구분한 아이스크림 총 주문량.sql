-- 코드를 입력하세요
SELECT I.INGREDIENT_TYPE as 'INGREDIENT_TYPE',
        SUM(H.TOTAL_ORDER) as 'TOTAL_ORDER'
from ICECREAM_INFO I
inner join FIRST_HALF H 
on I.FLAVOR = H.FLAVOR
group by INGREDIENT_TYPE
order by TOTAL_ORDER