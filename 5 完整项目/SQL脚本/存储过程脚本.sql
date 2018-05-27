--------------------------------------------
--------------存储过程脚本1.0---------------
--------------------------------------------
/*sp_helpsort
SELECT SERVERPROPERTY ('Collation')*/

/*1. 针对供应商信息表增删改查操作的存储过程*/

create procedure 新增供应商信息
	@供应商编号 varchar(50)
	,@主管姓名 varchar(50)
	,@联系方式 varchar(50)
	as
	insert into
		供应商(供应商编号,主管姓名,联系方式)
	values(@供应商编号,@主管姓名,@联系方式)
go

create procedure 查询供应商信息
	@供应商编号 varchar(50)
	as
	select 供应商编号,主管姓名,联系方式
	from 供应商
	where 供应商编号=@供应商编号
go

create procedure 更新供应商信息
	@供应商编号 varchar(50)
	,@主管姓名 varchar(50)
	,@联系方式 varchar(50)
	as
	update 供应商
		set 供应商编号=@供应商编号
			,主管姓名=@主管姓名
			,联系方式=@联系方式
	where 供应商编号=@供应商编号
go

create procedure 删除供应商信息
	@供应商编号 varchar(50)
	as
	delete
	from 供应商
	where 供应商编号=@供应商编号
go

-------------------------------------------------
/*2. 针对修理工信息表增删改查操作的存储过程*/

create procedure 新增修理工信息
	@修理工编号 varchar(50)
	,@修理工姓名 varchar(50)
	,@所属厂家 varchar(50)
	,@联系方式 varchar(50)
	as
	insert into
		修理工(修理工编号,修理工姓名,所属厂家,联系方式)
	values(@修理工编号,@修理工姓名,@所属厂家,@联系方式)
go

create procedure 查询修理工信息
	@修理工编号 varchar(50)
	as
	select 修理工编号,修理工姓名,所属厂家,联系方式
	from 修理工
	where 修理工编号=@修理工编号
go

create procedure 更新修理工信息
	@修理工编号 varchar(50)
	,@修理工姓名 varchar(50)
	,@所属厂家 varchar(50)
	,@联系方式 varchar(50)
	as
	update 修理工
		set 修理工编号=@修理工编号
			,修理工姓名=@修理工姓名
			,所属厂家=@所属厂家
			,联系方式=@联系方式
	where 修理工编号=@修理工编号
go

create procedure 删除修理工信息
	@修理工编号 varchar(50)
	as
	delete
	from 修理工
	where 修理工编号=@修理工编号
go

-------------------------------------------------
/*3. 针对设备入库记录表增删改查操作的存储过程*/

create procedure 新增设备入库记录
	@入库编号 varchar(50)
	,@类别 varchar(50)
	,@设备名 varchar(50)
	,@型号 varchar(50)
	,@规格 varchar(50)
	,@单价 float
	,@数量 int
	,@购置日期 date
	,@供应商编号 varchar(50)
	,@购买人 varchar(50)
	as
	insert into
		设备入库记录(入库编号,类别,设备名,型号,规格
		,单价,数量,购置日期,供应商编号,购买人)
	values(@入库编号,@类别,@设备名,@型号,@规格
		,@单价,@数量,@购置日期,@供应商编号,@购买人)
go

create procedure 更新设备入库记录
	@入库编号 varchar(50)
	,@类别 varchar(50)
	,@设备名 varchar(50)
	,@型号 varchar(50)
	,@规格 varchar(50)
	,@单价 float
	,@数量 int
	,@购置日期 date
	,@供应商编号 varchar(50)
	,@购买人 varchar(50)
	as
	update 设备入库记录
	set 类别=@类别
		,设备名=@设备名
		,型号=@型号
		,规格=@规格
		,单价=@单价
		,数量=@数量
		,购置日期=@购置日期
		,供应商编号=@供应商编号
		,购买人=@购买人
	where 入库编号=@入库编号
go

create procedure 删除设备入库记录
	@入库编号 varchar(50)
	as
	delete
	from 设备入库记录
	where 入库编号=@入库编号
go

create procedure 查询所有设备入库记录
	as
	select *
	from 设备入库记录
	order by 入库编号
go

create procedure 按编号查询设备入库记录
	@入库编号 varchar(50)
	as
	select *
	from 设备入库记录
	where 入库编号=@入库编号
go

create procedure 按型号查询设备入库记录
	@型号 varchar(50)
	as
	select *
	from 设备入库记录
	where 型号=@型号
go

create procedure 按日期查询设备入库记录
	@购置日期 date
	as
	select *
	from 设备入库记录
	where 购置日期=@购置日期
	order by 入库编号
go

create procedure 按起止日期查询设备入库记录
	@起始日期 date
	,@结束日期 date
	as
	select *
	from 设备入库记录
	where 购置日期 between @起始日期 and @结束日期
	order by 购置日期
go

/*更新和删除的就不写了，都类似*/
----------------------------------------------

/*模块4. 报废设备管理*/
create procedure 查询所有报废设备记录
	as
	select *
	from dbo.设备报废状况
	order by 设备编号
go

create procedure 按日期查询报废设备记录
	@起始日期 date
	,@结束日期 date
	as
	select *
	from dbo.设备报废状况
	where 修理日期 between @起始日期 and @结束日期
	order by 设备编号,修理日期
go

create procedure 按日期统计每个设备总修理费和修理次数
	@起始日期 date
	,@结束日期 date
	as
	select @起始日期 as 起始日期,@结束日期 as 结束日期,设备编号,COUNT(*) as 修理次数,SUM(修理费) as 总修理费
	from dbo.设备报废状况
	where 修理日期 between @起始日期 and @结束日期
	group by 设备编号
go



/*模块2. 设备运行状况查询统计*/
create procedure 查询所有设备运行情况
	as
	select *
	from dbo.设备运行状况
go

create procedure 按机房名称查询设备运行情况
	@实验室 varchar(50)
	as
	select *
	from dbo.设备运行状况
	where 所属实验室=@实验室
go

create procedure 按机房名称统计设备运行情况
	@实验室 varchar(50)
	as
	select 运行状况,COUNT(设备编号) as 设备数量
	from dbo.设备运行状况
	where 所属实验室=@实验室
	group by 运行状况
go


/*模块5. 权限管理、更改密码*/
create procedure 设置管理员权限
	@管理员编号 varchar(50)
	,@管理员权限 int
	as
	update 实验室管理员
	set 管理员权限=@管理员权限
	where 管理员编号=@管理员编号
go

create procedure 更改密码
	@管理员编号 varchar(50)
	,@新密码 varchar(50)
	as
	if exists(select * from 实验室管理员 where 管理员编号=@管理员编号)
	begin
		update 实验室管理员
		set 管理员密码=@新密码
		where 管理员编号=@管理员编号
	end
go

create procedure 获取原密码
	@管理员编号 varchar(50)
	,@原密码 varchar(50) output
	as
	select @原密码=管理员密码 from 实验室管理员 where 管理员编号=@管理员编号
go

create procedure 获取权限
	@管理员编号 varchar(50)
	,@权限 int output
	as
	select @权限=管理员权限 from 实验室管理员 where 管理员编号=@管理员编号
go





/*模块3. 保修设备管理*/
create procedure 查询所有设备修理记录
	as
	select 设备修理记录.设备编号,设备名,修理日期,修理工编号,修理费,负责人编号
	from dbo.设备修理记录,dbo.实验室设备,dbo.设备入库记录
	where 设备修理记录.设备编号=实验室设备.设备编号
		and 实验室设备.入库编号=设备入库记录.入库编号
go

create procedure 按类别查询设备修理记录
	@类别 varchar(50)
	as
	select 设备修理记录.设备编号,设备名,修理日期,修理工编号,修理费,负责人编号
	from dbo.设备修理记录,dbo.实验室设备,dbo.设备入库记录
	where 设备修理记录.设备编号=实验室设备.设备编号
		and 实验室设备.入库编号=设备入库记录.入库编号
		and 类别=@类别
	order by 修理日期
go

create procedure 按类别统计设备修理记录
	@类别 varchar(50)
	as
	select 类别,SUM(修理费) as 总修理费
	from dbo.设备修理记录,dbo.实验室设备,dbo.设备入库记录
	where 设备修理记录.设备编号=实验室设备.设备编号
		and 实验室设备.入库编号=设备入库记录.入库编号
		and 类别=@类别
	group by 类别
go

create procedure 按修理日期查询设备修理记录
	@起始日期 date,
	@结束日期 date
	as
	select 设备修理记录.设备编号,设备名,修理日期,修理工编号,修理费,负责人编号
	from dbo.设备修理记录,dbo.实验室设备,dbo.设备入库记录
	where 修理日期 between @起始日期 and @结束日期
		and 设备修理记录.设备编号=实验室设备.设备编号
		and 实验室设备.入库编号=设备入库记录.入库编号
	order by 修理日期
go

create procedure 按修理日期统计设备修理记录
	@起始日期 date,
	@结束日期 date
	as
	select @起始日期 as 起始日期,@结束日期 as 结束日期,SUM(修理费) as 总修理费
	from dbo.设备修理记录
	where 修理日期 between @起始日期 and @结束日期
go

create procedure 按修理厂家查询设备修理记录
	@厂家 varchar(50)
	as
	select 设备修理记录.设备编号,设备名,修理日期,设备修理记录.修理工编号,修理费,负责人编号
	from dbo.设备修理记录,dbo.实验室设备,dbo.设备入库记录,dbo.修理工
	where 所属厂家=@厂家
		and 设备修理记录.设备编号=实验室设备.设备编号
		and 实验室设备.入库编号=设备入库记录.入库编号
		and 设备修理记录.修理工编号=修理工.修理工编号
go

create procedure 按修理厂家统计设备修理记录
	@厂家 varchar(50)
	as
	select 所属厂家,SUM(修理费) as 总修理费,修理工姓名
	from dbo.设备修理记录,dbo.修理工
	where 所属厂家=@厂家
		and 设备修理记录.修理工编号=修理工.修理工编号
	group by 所属厂家,修理工姓名
go