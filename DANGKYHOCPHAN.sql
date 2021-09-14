use master
go
if(exists (select*from sysdatabases where name='Java_Nhom9'))
	Drop database Java_Nhom9
create database Java_Nhom9
on primary(name='Java_Nhom9',filename='C:\SQL\Java_Nhom9.mdf',size=2MB,maxsize=10MB,filegrowth=1MB)
log on(name='Java_Nhom9_log',filename='C:\SQL\Java_Nhom9.ldf',size=2MB,maxsize=10MB,filegrowth=1MB)
use Java_Nhom9
go
CREATE TABLE Khoa
(	MaKhoa Nvarchar(20) PRIMARY KEY not null,
	TenKhoa Nvarchar(30) not null
)
CREATE TABLE ChuyenNganh
(	MaCN Nvarchar(20) PRIMARY KEY not null,
	TenCN Nvarchar(30) not null,
	MaKhoa Nvarchar(20) not null,
	FOREIGN KEY(MaKhoa) references Khoa(MaKhoa)
	on update cascade on delete cascade
)
CREATE TABLE Lop
(	MaLop Nvarchar(20) PRIMARY KEY not null,
	TenLop Nvarchar(30) not null,
	SiSo int not null,
	KhoaHoc Nvarchar(30) not null,
	MaCN Nvarchar(20) not null,
	FOREIGN KEY(MaCN) references ChuyenNganh(MaCN)
	on update cascade on delete cascade
)
CREATE TABLE GiangVien
(	MaGV Nvarchar(20) PRIMARY KEY not null,
	TenGV Nvarchar(30) not null,
	NgaySinh Nvarchar(30) not null,
	GioiTinh Nvarchar(30) not null,
	DiaChi Nvarchar(30) not null,
)
CREATE TABLE SinhVien
(	MaSV Nvarchar(20) PRIMARY KEY not null,
	TenSV Nvarchar(30) not null,
	NgaySinh Nvarchar(30) not null,
	GioiTinh Nvarchar(30) not null,
	DiaChi Nvarchar(30) not null,
	HeDT Nvarchar(30) not null,
	MaLop Nvarchar(20) not null,
	FOREIGN KEY(MaLop) references Lop(MaLop)
	on update cascade on delete cascade
)
CREATE TABLE HocPhan
(	MaHP Nvarchar(20) PRIMARY KEY not null,
	TenHP Nvarchar(30) not null,
	TCLT int not null,
	TCTH int not null,
	DonGiaTC int not null,
	HinhThucThi Nvarchar(30) not null
)
CREATE TABLE LopHocPhan
(	MaLHP Nvarchar(20) PRIMARY KEY not null,
	MaHP Nvarchar(20) not null,
	FOREIGN KEY(MaHP) references HocPhan(MaHP)
	on update cascade on delete cascade,
	MaGV Nvarchar(20) not null,
	FOREIGN KEY(MaGV) references GiangVien(MaGV)
	on update cascade on delete cascade,
	TietHoc Nvarchar(30) not null,
	Thu Nvarchar(30) not null,
	NgayBatDau Nvarchar(30) not null,
	DiaDiem Nvarchar(30) not null
)
CREATE TABLE DangKy
(	
	MaLHP Nvarchar(20) not null,
	MaSV Nvarchar(20) not null,
	PRIMARY KEY(MaLHP,MaSV),
	FOREIGN KEY(MaLHP) references LopHocPhan(MaLHP)
	on update cascade on delete cascade,
	FOREIGN KEY(MaSV) references SinhVien(MaSV)
	on update cascade on delete cascade
)

CREATE TABLE TaiKhoan
(
	TenTK Nvarchar(20) PRIMARY KEY not null,
	MatKhau Nvarchar(20) not null
)
INSERT INTO Khoa values(N'CNTT',N'Công nghệ thông tin')
INSERT INTO Khoa values('DULICH','Dulich')
INSERT INTO Khoa values('KINHTE',N'Kinh tế')

INSERT INTO ChuyenNganh values('CNTT',N'Công nghệ thông tin','CNTT')
INSERT INTO ChuyenNganh values('KHMT',N'Khoa học máy tính','CNTT')
INSERT INTO ChuyenNganh values('HTTT',N'Hệ thống thông tin','CNTT')
INSERT INTO ChuyenNganh values('DULICH',N'Du lịch','DULICH')
INSERT INTO ChuyenNganh values('KHACHSAN',N'Khách sạn','DULICH')
INSERT INTO ChuyenNganh values('QTKD',N'Quản trị kinh doanh','KINHTE')

INSERT INTO Lop values('CNTT001',N'Công nghệ thông tin 1',75,'DH-K13','CNTT')
INSERT INTO Lop values('CNTT002',N'Công nghệ thông tin 2',77,'DH-K13','CNTT')
INSERT INTO Lop values('CNTT003',N'Công nghệ thông tin 3',70,'DH-K13','CNTT')
INSERT INTO Lop values('KHMT001',N'Khoa học máy tính 1',80,'DH-K13','KHMT')
INSERT INTO Lop values('KHMT002',N'Khoa học máy tính 2',82,'DH-K13','KHMT')
INSERT INTO Lop values('HTTT001',N'Hệ thống thông tin 1',71,'DH-K13','HTTT')
INSERT INTO Lop values('HTTT002',N'Hệ thống  thông tin 2',75,'DH-K13','HTTT')
INSERT INTO Lop values('DULICH001',N'Du lịch 1',77,'DH-K13','DULICH')
INSERT INTO Lop values('DULICH002',N'Du lịch 2',75,'DH-K13','DULICH')
INSERT INTO Lop values('KHACHSAN001',N'Khách sạn 1',70,'DH-K13','KHACHSAN')
INSERT INTO Lop values('KHACSHAN002',N'Khách sạn 2',75,'DH-K13','KHACHSAN')
INSERT INTO Lop values('QTKD001',N'Quản trị kinh doanh 1',84,'DH-K13','QTKD')

INSERT INTO SinhVien values('SV001',N'Lê Thị Hà','11-11-2000',N'Nữ',N'Thanh Hóa',N'Đại học','CNTT001')
INSERT INTO SinhVien values('SV002',N'Phạm Văn Huy','07-08-2001','Nam',N'Hà Nội',N'Đại học','CNTT001')
INSERT INTO SinhVien values('SV003',N'Vũ Ngọc Tâm','04-02-2000',N'Nữ',N'Nam Định',N'Đại học','CNTT001')
INSERT INTO SinhVien values('SV004',N'Nguyễn Minh Trang','15-11-2002',N'Nữ',N'Bắc Giang',N'Đại học','CNTT002')
INSERT INTO SinhVien values('SV005',N'Lê Mạnh Đạt',N'21-10-2000','Nam',N'Hà Nội',N'Cao đẳng','KHMT001')
INSERT INTO SinhVien values('SV006',N'Phan Anh Dương','8-03-2000','Nam',N'Thái Bình',N'Đại học','DULICH001')
INSERT INTO SinhVien values('SV007',N'Trần Văn Tiến','01-05-2000','Nam',N'Thanh Hóa',N'Cao đẳng','KHACHSAN001')

INSERT INTO GiangVien values('GV001',N'Nguyễn Viết Mạnh','01-05-1987','Nam',N'Hà Nội')
INSERT INTO GiangVien values('GV002',N'Lê Thị Anh','01-11-1985',N'Nữ',N'Hà Nội')
INSERT INTO GiangVien values('GV003',N'Trần Mai Thúy','01-12-1988',N'Nữ',N'Hà Nam')
INSERT INTO GiangVien values('GV004',N'Vũ Văn Thịnh','17-08-1990',N'Nam',N'Thanh Hóa')
INSERT INTO GiangVien values('GV005',N'Nguyễn Tiến Tùng','21-09-1995',N'Nam',N'Hải Dương')

INSERT INTO HocPhan values('HP001',N'Lập trình Java',1,3,350000,N'Thực hành')
INSERT INTO HocPhan values('HP002',N'Cơ sở dữ liệu đa phương tiện',3,0,350000,N'Lý thuyết')
INSERT INTO HocPhan values('HP003',N'Lập trình Window',1,2,350000,N'Thực hành')
INSERT INTO HocPhan values('HP004',N'Nguyên lý Mac-Lenin',5,0,350000,N'Lý thuyết')
INSERT INTO HocPhan values('HP005',N'Pháp luật đại cương',2,0,350000,N'Lý thuyết')
INSERT INTO HocPhan values('HP006',N'Đường lối CM của DCSVN',3,0,350000,N'Lý thuyết')
INSERT INTO HocPhan values('HP007',N'Phương pháp tính',3,0,350000,N'Lý thuyết')

INSERT INTO LopHocPhan values('LHP001','HP001','GV001','1,2,3,4,5',N'Thứ 2','01-06-2021','301-A9')
INSERT INTO LopHocPhan values('LHP002','HP001','GV001','7,8,9,10,11',N'Thứ 2','01-06-2021','301-A9')
INSERT INTO LopHocPhan values('LHP003','HP002','GV002','1,2,3,4',N'Thứ 3','01-06-2021','303-A9')
INSERT INTO LopHocPhan values('LHP004','HP003','GV003','7,8,9,10',N'Thứ 4','01-06-2021','303-A9')
INSERT INTO LopHocPhan values('LHP005','HP003','GV003','1,2,3,4',N'Thứ 4','01-06-2021','801-A10')
INSERT INTO LopHocPhan values('LHP006','HP004','GV004','1,2,3,4',N'Thứ 5','01-06-2021','802-A10')
INSERT INTO LopHocPhan values('LHP007','HP004','GV004','7,8,9,10',N'Thứ 2','01-06-2021','702-A10')
INSERT INTO LopHocPhan values('LHP008','HP005','GV004','5,6',N'Thứ 7','01-06-2021','702-A10')
INSERT INTO LopHocPhan values('LHP009','HP006','GV005','1,2,3,4',N'Thứ 6','01-06-2021','601-A10')
INSERT INTO LopHocPhan values('LHP0010','HP007','GV005','9,10,11,12',N'Thứ 6','01-06-2021','605-A10')

INSERT INTO DangKy values('LHP001','SV004')
INSERT INTO DangKy values('LHP001','SV001')
INSERT INTO DangKy values('LHP001','SV002')
INSERT INTO DangKy values('LHP002','SV001')
INSERT INTO DangKy values('LHP002','SV002')
INSERT INTO DangKy values('LHP002','SV004')
INSERT INTO DangKy values('LHP003','SV007')
INSERT INTO DangKy values('LHP003','SV005')
INSERT INTO DangKy values('LHP004','SV001')
INSERT INTO DangKy values('LHP004','SV002')
INSERT INTO DangKy values('LHP004','SV003')
INSERT INTO DangKy values('LHP005','SV006')
INSERT INTO DangKy values('LHP005','SV001')
INSERT INTO DangKy values('LHP005','SV003')
INSERT INTO DangKy values('LHP006','SV006')
INSERT INTO DangKy values('LHP006','SV001')
INSERT INTO DangKy values('LHP006','SV005')
INSERT INTO DangKy values('LHP007','SV001')
INSERT INTO DangKy values('LHP008','SV003')
INSERT INTO DangKy values('LHP009','SV001')
INSERT INTO DangKy values('LHP009','SV002')
INSERT INTO DangKy values('LHP0010','SV003')
INSERT INTO DangKy values('LHP0010','SV001')
INSERT INTO DangKy values('LHP0010','SV007')

INSERT INTO TaiKhoan values('Admin1','123456')
INSERT INTO TaiKhoan values('Admin2','123456')
INSERT INTO TaiKhoan values('SV001','123456')
INSERT INTO TaiKhoan values('SV002','123456')
INSERT INTO TaiKhoan values('SV003','123456')

