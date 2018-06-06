drop table classEco;
create table classEco(
    REG_TIME DATE,
    TEMPERATURE NUMBER,
    HUMIDITY    NUMBER,
    INNERDUST   NUMBER,
    OUTERDUST   NUMBER
);

INSERT INTO CLASSECO VALUES(sysdate, 1, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 2, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 3, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 4, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 5, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 6, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 7, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 8, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 9, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 10, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 11, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 12, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 13, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 14, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 15, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 16, 26, 100, 94);
INSERT INTO CLASSECO VALUES(sysdate, 30, 26, 100, 94);

commit;

select temperature, humidity, innerdust, outerdust,  to_char(reg_time,'yyyy/mm/dd hh24:mi:ss')
 from classeco 
where reg_time = (select max(reg_time) from classeco);

select * from classeco;

select * from (select * from classeco order by rownum desc) where rownum<=10;
