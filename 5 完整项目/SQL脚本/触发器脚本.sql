
--����Ҫ�ٴ���������������
--1.��ʵ�����豸���������ͬһ����ŵ��豸�������ܳ�������¼���е������ֶΡ�
--2.�����¼���е���������Ӧ�����豸�����еĹ�������֮��

------------------------------------------------
--------------�����������ű�1.0-----------------
------------------------------------------------

/*1. ������ӻ��޸Ļ�ɾ���豸����¼ʱ�Զ�¼�빺�����εĴ�����*/
create trigger ���Ӳ����Զ���¼����
	on �豸����¼
	for insert
	as
	begin
		declare @����� varchar(50),
				@�ͺ� varchar(50),
				@������ int
		select @�����=�����,@�ͺ�=�ͺ� from inserted
		select @������=(select COUNT(�ͺ�) from �豸����¼ where �ͺ�=@�ͺ�)
		update �豸����¼
		set ��������=@������
		where �����=@����� and exists(
				select * 
				from �豸����¼
				where �ͺ�=@�ͺ�
		) 
	end
go

create trigger ���²����Զ��޸�����
	on �豸����¼
	for update
	as
	begin
		declare @����� varchar(50),
				@���ͺ� varchar(50),
				@���ͺ� varchar(50),
				@�������� int,
				@�������� int,
				@�Ϲ������� date,
				@�¹������� date
		select @��������=��������,@���ͺ�=�ͺ�,@�Ϲ�������=�������� from deleted
		select @�����=�����,@���ͺ�=�ͺ�,@�¹�������=�������� from inserted
		if @���ͺ�!=@���ͺ�
		begin
			select @��������=(select COUNT(�ͺ�) from �豸����¼ where �ͺ�=@���ͺ� and ��������<@�¹�������)+1
			update �豸����¼
			set ��������=@��������
			where �����=@����� and exists(
					select * 
					from �豸����¼
					where �ͺ�=@���ͺ�
			) 
			
			update �豸����¼
			set ��������=��������+1
			where �ͺ�=@���ͺ� and ��������>@�¹�������
			
			update �豸����¼
			set ��������=��������-1
			where �ͺ�=@���ͺ� and ��������>@�Ϲ�������
		end
	end
go

create trigger ɾ�������Զ���������
	on �豸����¼
	for delete
	as
	begin
		declare @����� varchar(50),
				@�ͺ� varchar(50),
				@�������� date
		select @�����=�����,@�ͺ�=�ͺ�,@��������=�������� from deleted
		update �豸����¼
		set ��������=��������-1
		where �ͺ�=@�ͺ� and ��������>@��������
	end
go

/*2. ������ӻ��޸�ʵ�����豸��¼ʱ�ж��Ƿ�¼���������ڹ��������Ĵ�����*/

create trigger ���ӻ���²����ж�����
	on ʵ�����豸
	for insert,update
	as
	begin
		declare @����� varchar(50),
				@���� int
		select @�����=����� from inserted
		select @����=���� from �豸����¼ where �����=@�����
		if (select COUNT(�豸���) from ʵ�����豸 where �����=@�����)>=@����
		begin
			print '�����ʵ�����豸�������������ι��õ��豸������'
			rollback
		end
	end
go


insert into ʵ�����豸 values('40049','30004','1','����')
go