package com.service.zj;


import com.pojo.zj.Selectcourse;

import java.util.List;

public interface SelectService {
    int ins(Selectcourse selectcourse);
    int setcount(int id);
    Selectcourse show(Selectcourse selectcourse);
    List<Selectcourse> showt(int codeid);
    int insH(Selectcourse selectcourse);
    List<Selectcourse> showhis(int codeid);

}
