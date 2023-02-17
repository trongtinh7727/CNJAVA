package com.lab03.dao;

import com.lab03.modal.SinhVien;


import java.util.ArrayList;
import java.util.List;

public interface ISinhVienDAO extends genericDAO<SinhVien> {
            List<SinhVien> sellectAll();
            public int insert(SinhVien t);
            public int upate(SinhVien t);
            public int delete(SinhVien t);

            public SinhVien selectById(String id);
            public List<SinhVien> selectByCondition(String condition);
}
