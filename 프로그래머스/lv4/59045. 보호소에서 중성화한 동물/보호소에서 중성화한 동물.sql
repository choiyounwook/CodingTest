-- 코드를 입력하세요
SELECT i.ANIMAL_ID as 'ANIMAL_ID',
        i.ANIMAL_TYPE as 'ANIMAL_TYPE',
        i.NAME as 'NAME'
from ANIMAL_INS i
inner join ANIMAL_OUTS o
on i.ANIMAL_ID = o.ANIMAL_ID
where i.SEX_UPON_INTAKE like 'Intact%' AND (o.SEX_UPON_OUTCOME like 'Spayed%' OR o.SEX_UPON_OUTCOME like 'Neutered%')
order by i.ANIMAL_ID