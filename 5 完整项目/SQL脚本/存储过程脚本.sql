--------------------------------------------
--------------�洢���̽ű�1.0---------------
--------------------------------------------
/*sp_helpsort
SELECT SERVERPROPERTY ('Collation')*/

/*1. ��Թ�Ӧ����Ϣ����ɾ�Ĳ�����Ĵ洢����*/

create procedure ������Ӧ����Ϣ
	@��Ӧ�̱�� varchar(50)
	,@�������� varchar(50)
	,@��ϵ��ʽ varchar(50)
	as
	insert into
		��Ӧ��(��Ӧ�̱��,��������,��ϵ��ʽ)
	values(@��Ӧ�̱��,@��������,@��ϵ��ʽ)
go

create procedure ��ѯ��Ӧ����Ϣ
	@��Ӧ�̱�� varchar(50)
	as
	select ��Ӧ�̱��,��������,��ϵ��ʽ
	from ��Ӧ��
	where ��Ӧ�̱��=@��Ӧ�̱��
go

create procedure ���¹�Ӧ����Ϣ
	@��Ӧ�̱�� varchar(50)
	,@�������� varchar(50)
	,@��ϵ��ʽ varchar(50)
	as
	update ��Ӧ��
		set ��Ӧ�̱��=@��Ӧ�̱��
			,��������=@��������
			,��ϵ��ʽ=@��ϵ��ʽ
	where ��Ӧ�̱��=@��Ӧ�̱��
go

create procedure ɾ����Ӧ����Ϣ
	@��Ӧ�̱�� varchar(50)
	as
	delete
	from ��Ӧ��
	where ��Ӧ�̱��=@��Ӧ�̱��
go

-------------------------------------------------
/*2. ���������Ϣ����ɾ�Ĳ�����Ĵ洢����*/

create procedure ����������Ϣ
	@������� varchar(50)
	,@�������� varchar(50)
	,@�������� varchar(50)
	,@��ϵ��ʽ varchar(50)
	as
	insert into
		����(�������,��������,��������,��ϵ��ʽ)
	values(@�������,@��������,@��������,@��ϵ��ʽ)
go

create procedure ��ѯ������Ϣ
	@������� varchar(50)
	as
	select �������,��������,��������,��ϵ��ʽ
	from ����
	where �������=@�������
go

create procedure ����������Ϣ
	@������� varchar(50)
	,@�������� varchar(50)
	,@�������� varchar(50)
	,@��ϵ��ʽ varchar(50)
	as
	update ����
		set �������=@�������
			,��������=@��������
			,��������=@��������
			,��ϵ��ʽ=@��ϵ��ʽ
	where �������=@�������
go

create procedure ɾ��������Ϣ
	@������� varchar(50)
	as
	delete
	from ����
	where �������=@�������
go

-------------------------------------------------
/*3. ����豸����¼����ɾ�Ĳ�����Ĵ洢����*/

create procedure �����豸����¼
	@����� varchar(50)
	,@��� varchar(50)
	,@�豸�� varchar(50)
	,@�ͺ� varchar(50)
	,@��� varchar(50)
	,@���� float
	,@���� int
	,@�������� date
	,@��Ӧ�̱�� varchar(50)
	,@������ varchar(50)
	as
	insert into
		�豸����¼(�����,���,�豸��,�ͺ�,���
		,����,����,��������,��Ӧ�̱��,������)
	values(@�����,@���,@�豸��,@�ͺ�,@���
		,@����,@����,@��������,@��Ӧ�̱��,@������)
go

create procedure �����豸����¼
	@����� varchar(50)
	,@��� varchar(50)
	,@�豸�� varchar(50)
	,@�ͺ� varchar(50)
	,@��� varchar(50)
	,@���� float
	,@���� int
	,@�������� date
	,@��Ӧ�̱�� varchar(50)
	,@������ varchar(50)
	as
	update �豸����¼
	set ���=@���
		,�豸��=@�豸��
		,�ͺ�=@�ͺ�
		,���=@���
		,����=@����
		,����=@����
		,��������=@��������
		,��Ӧ�̱��=@��Ӧ�̱��
		,������=@������
	where �����=@�����
go

create procedure ɾ���豸����¼
	@����� varchar(50)
	as
	delete
	from �豸����¼
	where �����=@�����
go

create procedure ��ѯ�����豸����¼
	as
	select *
	from �豸����¼
	order by �����
go

create procedure ����Ų�ѯ�豸����¼
	@����� varchar(50)
	as
	select *
	from �豸����¼
	where �����=@�����
go

create procedure ���ͺŲ�ѯ�豸����¼
	@�ͺ� varchar(50)
	as
	select *
	from �豸����¼
	where �ͺ�=@�ͺ�
go

create procedure �����ڲ�ѯ�豸����¼
	@�������� date
	as
	select *
	from �豸����¼
	where ��������=@��������
	order by �����
go

create procedure ����ֹ���ڲ�ѯ�豸����¼
	@��ʼ���� date
	,@�������� date
	as
	select *
	from �豸����¼
	where �������� between @��ʼ���� and @��������
	order by ��������
go

/*���º�ɾ���ľͲ�д�ˣ�������*/
----------------------------------------------

/*ģ��4. �����豸����*/
create procedure ��ѯ���б����豸��¼
	as
	select *
	from dbo.�豸����״��
	order by �豸���
go

create procedure �����ڲ�ѯ�����豸��¼
	@��ʼ���� date
	,@�������� date
	as
	select *
	from dbo.�豸����״��
	where �������� between @��ʼ���� and @��������
	order by �豸���,��������
go

create procedure ������ͳ��ÿ���豸������Ѻ��������
	@��ʼ���� date
	,@�������� date
	as
	select @��ʼ���� as ��ʼ����,@�������� as ��������,�豸���,COUNT(*) as �������,SUM(�����) as �������
	from dbo.�豸����״��
	where �������� between @��ʼ���� and @��������
	group by �豸���
go



/*ģ��2. �豸����״����ѯͳ��*/
create procedure ��ѯ�����豸�������
	as
	select *
	from dbo.�豸����״��
go

create procedure ���������Ʋ�ѯ�豸�������
	@ʵ���� varchar(50)
	as
	select *
	from dbo.�豸����״��
	where ����ʵ����=@ʵ����
go

create procedure ����������ͳ���豸�������
	@ʵ���� varchar(50)
	as
	select ����״��,COUNT(�豸���) as �豸����
	from dbo.�豸����״��
	where ����ʵ����=@ʵ����
	group by ����״��
go


/*ģ��5. Ȩ�޹�����������*/
create procedure ���ù���ԱȨ��
	@����Ա��� varchar(50)
	,@����ԱȨ�� int
	as
	update ʵ���ҹ���Ա
	set ����ԱȨ��=@����ԱȨ��
	where ����Ա���=@����Ա���
go

create procedure ��������
	@����Ա��� varchar(50)
	,@������ varchar(50)
	as
	if exists(select * from ʵ���ҹ���Ա where ����Ա���=@����Ա���)
	begin
		update ʵ���ҹ���Ա
		set ����Ա����=@������
		where ����Ա���=@����Ա���
	end
go

create procedure ��ȡԭ����
	@����Ա��� varchar(50)
	,@ԭ���� varchar(50) output
	as
	select @ԭ����=����Ա���� from ʵ���ҹ���Ա where ����Ա���=@����Ա���
go

create procedure ��ȡȨ��
	@����Ա��� varchar(50)
	,@Ȩ�� int output
	as
	select @Ȩ��=����ԱȨ�� from ʵ���ҹ���Ա where ����Ա���=@����Ա���
go





/*ģ��3. �����豸����*/
create procedure ��ѯ�����豸�����¼
	as
	select �豸�����¼.�豸���,�豸��,��������,�������,�����,�����˱��
	from dbo.�豸�����¼,dbo.ʵ�����豸,dbo.�豸����¼
	where �豸�����¼.�豸���=ʵ�����豸.�豸���
		and ʵ�����豸.�����=�豸����¼.�����
go

create procedure ������ѯ�豸�����¼
	@��� varchar(50)
	as
	select �豸�����¼.�豸���,�豸��,��������,�������,�����,�����˱��
	from dbo.�豸�����¼,dbo.ʵ�����豸,dbo.�豸����¼
	where �豸�����¼.�豸���=ʵ�����豸.�豸���
		and ʵ�����豸.�����=�豸����¼.�����
		and ���=@���
	order by ��������
go

create procedure �����ͳ���豸�����¼
	@��� varchar(50)
	as
	select ���,SUM(�����) as �������
	from dbo.�豸�����¼,dbo.ʵ�����豸,dbo.�豸����¼
	where �豸�����¼.�豸���=ʵ�����豸.�豸���
		and ʵ�����豸.�����=�豸����¼.�����
		and ���=@���
	group by ���
go

create procedure ���������ڲ�ѯ�豸�����¼
	@��ʼ���� date,
	@�������� date
	as
	select �豸�����¼.�豸���,�豸��,��������,�������,�����,�����˱��
	from dbo.�豸�����¼,dbo.ʵ�����豸,dbo.�豸����¼
	where �������� between @��ʼ���� and @��������
		and �豸�����¼.�豸���=ʵ�����豸.�豸���
		and ʵ�����豸.�����=�豸����¼.�����
	order by ��������
go

create procedure ����������ͳ���豸�����¼
	@��ʼ���� date,
	@�������� date
	as
	select @��ʼ���� as ��ʼ����,@�������� as ��������,SUM(�����) as �������
	from dbo.�豸�����¼
	where �������� between @��ʼ���� and @��������
go

create procedure �������Ҳ�ѯ�豸�����¼
	@���� varchar(50)
	as
	select �豸�����¼.�豸���,�豸��,��������,�豸�����¼.�������,�����,�����˱��
	from dbo.�豸�����¼,dbo.ʵ�����豸,dbo.�豸����¼,dbo.����
	where ��������=@����
		and �豸�����¼.�豸���=ʵ�����豸.�豸���
		and ʵ�����豸.�����=�豸����¼.�����
		and �豸�����¼.�������=����.�������
go

create procedure ��������ͳ���豸�����¼
	@���� varchar(50)
	as
	select ��������,SUM(�����) as �������,��������
	from dbo.�豸�����¼,dbo.����
	where ��������=@����
		and �豸�����¼.�������=����.�������
	group by ��������,��������
go