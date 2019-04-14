/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1lab8;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
class Sanpham {
    
    private String tenSp;
    private double donGia;
    private double giamGia;
    private double thueNhapKhau;

    Sanpham() {
        
    }


    public String getTenSp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi ban nhap ten san pham: ");
        tenSp = sc.nextLine();
        return tenSp;
    }

    public void nhap() {
        getTenSp();
        getDonGia();
        getGiamGia();
        getThueNhapKhau();
    }

    public double getThueNhapKhau() {
        thueNhapKhau = (donGia - giamGia)*10/100;
        return thueNhapKhau;
    }

    public void xuat() {
        setTenSp(tenSp);
        setDonGia(donGia);
        setGiamGia(giamGia);
        setThueNhapKhau(thueNhapKhau);
    }

    public void setThueNhapKhau(double thueNhapKhau) {
        System.out.println("Thue nhap khau : " + thueNhapKhau);
        this.thueNhapKhau = thueNhapKhau;
    }

    public void setTenSp(String tenSp) {
        System.out.println("Ten sp: " + tenSp);
        this.tenSp = tenSp;
    }

    public double getDonGia() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi ban nhap don gia: ");
        donGia = Double.parseDouble(sc.nextLine());
        return donGia;
    }

    public void setDonGia(double donGia) {
        System.out.println("Don gia: " + donGia);
        this.donGia = donGia;
    }

    public double getGiamGia() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi ban nhap so tien giam: ");
        giamGia = Double.parseDouble(sc.nextLine());
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        System.out.println("Giam gia: " + giamGia);
        this.giamGia = giamGia;
    }
    public Sanpham( String tenSp, double donGia, double giamGia){
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }
    public Sanpham(String tenSp, double donGia){
        this(tenSp,donGia,0);
    }
}
