
--还需要再创建几个触发器：
--1.向实验室设备表中输入的同一入库编号的设备数量不能超过入库记录表中的数量字段。
--2.修理记录表中的修理日期应该在设备入库表中的购置日期之后

------------------------------------------------
--------------创建触发器脚本1.0-----------------
------------------------------------------------

/*1. 针对增加或修改或删除设备入库记录时自动录入购置批次的触发器*/
create trigger 增加操作自动记录批次
	on 设备入库记录
	for insert
	as
	begin
		declare @入库编号 varchar(50),
				@型号 varchar(50),
				@批次数 int
		select @入库编号=入库编号,@型号=型号 from inserted
		select @批次数=(select COUNT(型号) from 设备入库记录 where 型号=@型号)
		update 设备入库记录
		set 购置批次=@批次数
		where 入库编号=@入库编号 and exists(
				select * 
				from 设备入库记录
				where 型号=@型号
		) 
	end
go

create trigger 更新操作自动修改批次
	on 设备入库记录
	for update
	as
	begin
		declare @入库编号 varchar(50),
				@老型号 varchar(50),
				@新型号 varchar(50),
				@老批次数 int,
				@新批次数 int,
				@老购置日期 date,
				@新购置日期 date
		select @老批次数=购置批次,@老型号=型号,@老购置日期=购置日期 from deleted
		select @入库编号=入库编号,@新型号=型号,@新购置日期=购置日期 from inserted
		if @老型号!=@新型号
		begin
			select @新批次数=(select COUNT(型号) from 设备入库记录 where 型号=@新型号 and 购置日期<@新购置日期)+1
			update 设备入库记录
			set 购置批次=@新批次数
			where 入库编号=@入库编号 and exists(
					select * 
					from 设备入库记录
					where 型号=@新型号
			) 
			
			update 设备入库记录
			set 购置批次=购置批次+1
			where 型号=@新型号 and 购置日期>@新购置日期
			
			update 设备入库记录
			set 购置批次=购置批次-1
			where 型号=@老型号 and 购置日期>@老购置日期
		end
	end
go

create trigger 删除操作自动更新批次
	on 设备入库记录
	for delete
	as
	begin
		declare @入库编号 varchar(50),
				@型号 varchar(50),
				@购置日期 date
		select @入库编号=入库编号,@型号=型号,@购置日期=购置日期 from deleted
		update 设备入库记录
		set 购置批次=购置批次-1
		where 型号=@型号 and 购置日期>@购置日期
	end
go

/*2. 针对增加或修改实验室设备记录时判断是否录入数量多于购置数量的触发器*/

create trigger 增加或更新操作判断数量
	on 实验室设备
	for insert,update
	as
	begin
		declare @入库编号 varchar(50),
				@数量 int
		select @入库编号=入库编号 from inserted
		select @数量=数量 from 设备入库记录 where 入库编号=@入库编号
		if (select COUNT(设备编号) from 实验室设备 where 入库编号=@入库编号)>=@数量
		begin
			print '插入的实验室设备数量超过该批次购置的设备数量！'
			rollback
		end
	end
go


insert into 实验室设备 values('40049','30004','1','正常')
go