-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d'), 
IF(OUT_DATE > '2022-05-01', "출고대기",
   if(isnull(OUT_DATE), "출고미정", "출고완료"))
from FOOD_ORDER;