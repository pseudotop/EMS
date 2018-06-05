drop table classEco;
create table classEco(
    TEMPERATURE NUMBER,
    HUMID       NUMBER,
    INNERDUST   NUMBER,
    OUTERDUST   NUMBER
);

INSERT INTO CLASSECO VALUES(1, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(2, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(3, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(4, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(5, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(6, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(7, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(8, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(9, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(10, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(11, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(12, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(13, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(14, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(15, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(16, 26, 100, 94, sysdate);
INSERT INTO CLASSECO VALUES(30, 26, 100, 94, sysdate);

commit;

select temperature, humidity, innerdust, outerdust,  to_char(sysdate-0.001,'yyyy/mm/dd hh24:mi:ss') reg_time
 from classeco 
where reg_time = (select max(reg_time) from classeco);

select * from classeco;
