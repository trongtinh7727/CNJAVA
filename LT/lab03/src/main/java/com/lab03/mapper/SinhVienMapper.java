package com.lab03.mapper;

import com.lab03.modal.SinhVien;

import java.sql.ResultSet;

public class SinhVienMapper implements RowMapper<SinhVien> {
    @Override
    public SinhVien mapRow(ResultSet rs) {
        try {
            SinhVien sv = new SinhVien(rs.getString("mssv"),rs.getString("gtinh"),rs.getInt("tuoi"),rs.getFloat("dtb"));
            return sv;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
