/*���ݿ������ں���201516010111_ʵ�����豸����ϵͳ*/
----------------------------------------------
-----------------����ű�1.0------------------
----------------------------------------------

/*1. ����ʵ���ҹ���Ա������Ϣ��
���й���ԱȨ����Ϊint���������ֵȼ�*/
create table ʵ���ҹ���Ա(
	����Ա���	varchar(50)	primary key,
	����Ա����	varchar(50)	not null,
	����Ա����	varchar(50)	not null,
	����ԱȨ��	int			not null
)
go

/*2. ������Ӧ�̻�����Ϣ��*/
create table ��Ӧ��(
	��Ӧ�̱��	varchar(50)	primary key,
	��������	varchar(50)	not null,
	��ϵ��ʽ	varchar(50)
)
go

/*3. ��������������Ϣ��
����������������ӳ��Ϊ��Ӧ�̱�����*/
create table ����(
	�������	varchar(50)	primary key,
	��������	varchar(50)	not null,
	��������	varchar(50)	references ��Ӧ��(��Ӧ�̱��)
							on delete cascade on update cascade,
	��ϵ��ʽ	varchar(50)
)
go

/*4. �����豸����¼��
���й�Ӧ�̱��ӳ��Ϊ��Ӧ�̱�����*/
create table �豸����¼(
	�����	varchar(50)	primary key,
	���		varchar(50),
	�豸��		varchar(50)	not null,
	�ͺ�		varchar(50),
	���		varchar(50),
	����		float,
	����		int,
	��������	date default getdate(),
	��������	varchar(50),
	��Ӧ�̱��	varchar(50) references ��Ӧ��(��Ӧ�̱��)
							on delete cascade on update cascade,
	������		varchar(50)
)
go

/*5. ����ʵ�����豸������Ϣ��
���������ӳ��Ϊ�豸����¼������
����״��������Լ������
ֻ���С����á��������ϡ��������ϡ�����״��*/
create table ʵ�����豸(
	�豸���	varchar(50)	primary key,
	�豸��		varchar(50)	not null,
	�����	varchar(50)	references �豸����¼(�����)
							on delete cascade on update cascade,
	����ʵ����	varchar(50),
	����״��	varchar(50) check(����״�� in ('����','����','����'))
)
go

/*6. �����豸�����¼��
�����豸�������������������Էֱ�Ϊ���*/
create table �豸�����¼(
	�����豸���	varchar(50)	primary key,
	��������		date,
	�豸���		varchar(50)	references ʵ�����豸(�豸���)
								on delete no action on update no action,
	�������		varchar(50)	references ����(�������)
								on delete cascade on update cascade,
	�����			float,
	�����˱��		varchar(50) references ʵ���ҹ���Ա(����Ա���)
								on delete cascade on update cascade
)
go