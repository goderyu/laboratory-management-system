/*数据库名：于好贤201516010111_实验室设备管理系统*/
----------------------------------------------
-----------------建表脚本1.0------------------
----------------------------------------------

/*1. 创建实验室管理员基本信息表
其中管理员权限设为int类型来区分等级*/
create table 实验室管理员(
	管理员编号	varchar(50)	primary key,
	管理员姓名	varchar(50)	not null,
	管理员密码	varchar(50)	not null,
	管理员权限	int			not null
)
go

/*2. 创建供应商基本信息表*/
create table 供应商(
	供应商编号	varchar(50)	primary key,
	主管姓名	varchar(50)	not null,
	联系方式	varchar(50)
)
go

/*3. 创建修理工基本信息表
其中修理工所属厂家映射为供应商表的外键*/
create table 修理工(
	修理工编号	varchar(50)	primary key,
	修理工姓名	varchar(50)	not null,
	所属厂家	varchar(50)	references 供应商(供应商编号)
							on delete cascade on update cascade,
	联系方式	varchar(50)
)
go

/*4. 创建设备入库记录表
其中供应商编号映射为供应商表的外键*/
create table 设备入库记录(
	入库编号	varchar(50)	primary key,
	类别		varchar(50),
	设备名		varchar(50)	not null,
	型号		varchar(50),
	规格		varchar(50),
	单价		float,
	数量		int,
	购置日期	date default getdate(),
	购置批次	varchar(50),
	供应商编号	varchar(50) references 供应商(供应商编号)
							on delete cascade on update cascade,
	购买人		varchar(50)
)
go

/*5. 创建实验室设备基本信息表
其中入库编号映射为设备入库记录表的外键
运行状况属性有约束条件
只能有‘良好’、‘故障’、‘报废’三种状况*/
create table 实验室设备(
	设备编号	varchar(50)	primary key,
	设备名		varchar(50)	not null,
	入库编号	varchar(50)	references 设备入库记录(入库编号)
							on delete cascade on update cascade,
	所属实验室	varchar(50),
	运行状况	varchar(50) check(运行状况 in ('正常','故障','报废'))
)
go

/*6. 创建设备修理记录表
其中设备名、修理工、负责人属性分别为外键*/
create table 设备修理记录(
	修理设备编号	varchar(50)	primary key,
	修理日期		date,
	设备编号		varchar(50)	references 实验室设备(设备编号)
								on delete no action on update no action,
	修理工编号		varchar(50)	references 修理工(修理工编号)
								on delete cascade on update cascade,
	修理费			float,
	负责人编号		varchar(50) references 实验室管理员(管理员编号)
								on delete cascade on update cascade
)
go