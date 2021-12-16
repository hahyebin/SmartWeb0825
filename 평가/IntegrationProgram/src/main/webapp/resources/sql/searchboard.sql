DROP SEQUENCE SEARCHBOARD_SEQ;
CREATE SEQUENCE SEARCHBOARD_SEQ START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE;

DROP TABLE SEARCHBOARD;
CREATE TABLE SEARCHBOARD
(
	NO NUMBER PRIMARY KEY,
	TITLE VARCHAR2(1000),
	CONTENT VARCHAR2(4000),
	REGDATE DATE
);

INSERT INTO SEARCHBOARD VALUES (SEARCHBOARD_SEQ.NEXTVAL, 'SF��ȭ', '���忡�� ���� ���������� ���ϴ� �������� �޿� �׸��� �ְ��� ���� ���� Ŭ������ �����ϰ� �� �� ��, ����ġ ���� ���� ��ȥ�� �Ǿ� ���¾�� �� ���󡯿� ��������.', '2021-07-05');
INSERT INTO SEARCHBOARD VALUES (SEARCHBOARD_SEQ.NEXTVAL, '�ڹ̵�ȭ', '���¹ݿ��� ��õ�Ǿ� �ź���ȣ ������ �� �ð� �� ��ȥ 4�� ��', '2021-07-05');
INSERT INTO SEARCHBOARD VALUES (SEARCHBOARD_SEQ.NEXTVAL, 'SF��ȭ', 'UN�յ� ���� ������ �Ƹ��׹̽� ����(�ж� �亸��ġ)�� ���Ҹ�� �������� ã�� ���� �������� ������ �׵�� ���� �̻� �������� �Ŵ� ������ ����� ������.', '2021-07-05');
INSERT INTO SEARCHBOARD VALUES (SEARCHBOARD_SEQ.NEXTVAL, '���', '�������� ���� ��Ȱ������ �Ϸ��Ϸ� ��ƿ� �Ƶ��а� �������� ��ȣ����Ƶ� ���ƿ���(�����) ���� �ʿ��ߴ� ���ƿ����� ���� 6���� �� �Ƶ� �������̸� Ȧ�� Ű��� ��ŷ������ �ʺ� ���� ����ä��(������)�� ���̺���Ͱ� �ȴ�.', '2021-07-05');
INSERT INTO SEARCHBOARD VALUES (SEARCHBOARD_SEQ.NEXTVAL, '���', '�ڻ��� �ƺ�, �Ϳ��� �ܽ��Ϳ� �ູ�� ������ ������ �ҳ�� ���ο� ���� �����ϡ��� �������� ����ϴ� �ϻ� ��ȭ�� ã�ƿ��� �ޱ�� ������� ���� ���⿡ ó�Ѵ�.', '2021-07-05');
INSERT INTO SEARCHBOARD VALUES (SEARCHBOARD_SEQ.NEXTVAL, '�ڹ̵�ȭ', '����� ���� ���� �������̹� ���衯. ��� ���ŵ� ������ �ʴ� �پ �������� 8�Ⱓ FBI�� ������ ������ �״� ���ο� �λ��� �����ϱ� ���� �ڼ��� ����Ѵ�.', '2021-07-05');
INSERT INTO SEARCHBOARD VALUES (SEARCHBOARD_SEQ.NEXTVAL, 'SF��ȭ', '�پ �����ָ� ���� ������������ �ΰ��� ����� �Բ� ���������� ��� �� ��� ���� �ΰ����� ū ��ó�� �԰� ���� ���迡 ���� ������.', '2021-07-05');
COMMIT;