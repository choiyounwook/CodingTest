-- 코드를 입력하세요
SELECT B.WRITER_ID as 'USER_ID', 
        U.NICKNAME as 'NICKNAME',
        concat(CITY,' ',STREET_ADDRESS1,' ',STREET_ADDRESS2) as '전체주소',
        concat(left(TLNO,3),'-',MID(TLNO,4,4),'-',right(TLNO,4)) as '전화번호'
from USED_GOODS_BOARD B
inner join USED_GOODS_USER U
on B.WRITER_ID = U.USER_ID
group by B.WRITER_ID
having count(B.WRITER_ID) >= 3
order by WRITER_ID desc