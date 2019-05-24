package com.dao.zj;


import com.pojo.zj.Selectcourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectMapper {
    int insselect(Selectcourse selectcourse);
    int updcount(int id);
    Selectcourse selBysc(Selectcourse Selectcourse);
    List<Selectcourse> selTwo(@Param("codeid") int codeid);
    int insHis(Selectcourse selectcourse);
    List<Selectcourse> selByhis(int codeid);
}
