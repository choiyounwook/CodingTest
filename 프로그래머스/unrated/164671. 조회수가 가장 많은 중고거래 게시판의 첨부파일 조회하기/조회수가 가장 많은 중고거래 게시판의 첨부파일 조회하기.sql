select concat('/home/grep/src/',B.BOARD_ID,'/',FILE_ID,FILE_NAME,FILE_EXT) as 'FILE_PATH'
from USED_GOODS_BOARD B
inner join USED_GOODS_FILE F
on B.BOARD_ID = F.BOARD_ID
where VIEWS in (SELECT MAX(VIEWS) from USED_GOODS_BOARD)
order by FILE_ID desc