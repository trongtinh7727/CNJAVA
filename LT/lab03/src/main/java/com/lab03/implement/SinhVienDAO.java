package com.lab03.implement;

import com.lab03.dao.ISinhVienDAO;
import com.lab03.mapper.SinhVienMapper;
import com.lab03.modal.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO extends AbstractDAO<SinhVien> implements ISinhVienDAO {

    public SinhVienDAO() {
    }

    @Override
    public List<SinhVien> sellectAll() {
        String sql = "Select * from sinhvien";
        return query(sql,new SinhVienMapper());
    }

    @Override
    public int insert(SinhVien t) {
        String sql = "INSERT INTO `sinhvien` (`MSSV`, `GTINH`, `TUOI`, `DTB`) VALUES (?, ?, ?, ?);";
        return  update(sql,t.getMssv(),t.getGender(),t.getAge(),t.getAvg());
    }

    @Override
    public int upate(SinhVien t) {
        String sql ="UPDATE `sinhvien` SET `MSSV` = ?, `GTINH` = ?, `TUOI` = ?, `DTB` = ? WHERE `sinhvien`.`MSSV` = ?";
        return update(sql,t.getMssv(),t.getGender(),t.getAge(),t.getAvg(),t.getMssv());
    }

    @Override
    public int delete(SinhVien t) {
        String sql = "DELETE FROM sinhvien WHERE `sinhvien`.`MSSV` = ?";
        return update(sql, t.getMssv());
    }

    @Override
    public SinhVien selectById(String id) {
        String sql = "Select * from sinhvien where mssv = ?";
        List<SinhVien> list = query(sql,new SinhVienMapper(),id);
        if (list.isEmpty()){
            return  null;
        }else
        return list.get(0);
    }

    @Override
    public List<SinhVien> selectByCondition(String condition) {
        return null;
    }
}
