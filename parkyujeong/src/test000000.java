Array
Arrat list 차이

LinkedList

제네릭형

iterator

hasNext
iter.next

empty


add

integer

print/println

wrapper

tostring

comareTo

try / catch

오버라이드 오버로드

update shop_productset price = price*1.1 where zkeprhfl 가전 and stok <10





begin
insert into del_log (p_id)
values(:old.prod_id);
end;
/

CREATE OR REPLACE TRIGGER trg_ins_log
AFTER INSERT ON shop_product
FOR EACH ROW
BEGIN
    INSERT INTO shop_product_del_log(p_id)
    VALUES(:NEW.prod_id);
END;
/