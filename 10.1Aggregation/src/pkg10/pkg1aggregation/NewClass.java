/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10.pkg1aggregation;

/**
 *
 * @author asus
 */
public class NewClass {
    
}


public class PhongBan {
private String tenPhongBan;
private byte soNhanVien;
public static final SO_NV_MAX = 100;
private NhanVien[] dsnv;
public PhongBan(String tenPB, NhanVien ds[]){
dsnv = new NhanVien[SO_NV_MAX];
tenPhongBan = tenPB;
soNhanVien = ds.length;
dsnv = ds;
}
public byte getSoNhanVien(){ return soNhanVien; }
public setTenPhongBan(String tenPB){
tenPhongBan = tenPB;
}
public String getTenPhongBan(){ return soNhanVien; }
// (cont)...
public boolean themNhanVien(NhanVien nv){
if (soNhanVien < SO_NV_MAX) {
dsnv[soNhanVien] = nv;
soNhanVien++;
return true;
} else
return false;
}
public NhanVien xoaNhanVien(){
if (soNhanVien > 0) {
NhanVien tmp = dsnv[soNhanVien-1];
dsnv[soNhanVien-1] = null;
soNhanVien--;
return tmp;
} else return null;
}
public double tongLuong(){
double tong = 0.0;
for (int i=0;i<soNhanVien;i++)
tong += dsnv[i].tinhLuong();
return tong;
}
public void inTTin(){
System.out.println("Ten phong: "+tenPhong);
System.out.println("So NV: "+soNhanVien);
System.out.println("Thong tin cac NV");
for (int i=0;i<soNhanVien;i++)
dsnv[i].inTTin();
}
}