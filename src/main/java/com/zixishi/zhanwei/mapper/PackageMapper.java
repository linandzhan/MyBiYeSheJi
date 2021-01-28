package com.zixishi.zhanwei.mapper;

import com.zixishi.zhanwei.model.Area;
import com.zixishi.zhanwei.model.Package;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PackageMapper {

    public Package findOne(Long id);


}
