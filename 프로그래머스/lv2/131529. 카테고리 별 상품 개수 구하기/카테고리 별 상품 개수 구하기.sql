-- 코드를 입력하세요
SELECT left(PRODUCT_CODE, 2) as 'CATEGORY', count(PRODUCT_CODE) as 'PRODUCTS'
from PRODUCT 
group by CATEGORY
order by PRODUCT_CODE
