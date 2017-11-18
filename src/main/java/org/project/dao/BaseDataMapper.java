package org.project.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.project.domain.BaseData;

import java.util.List;

/**
 * @author pengpeng
 * @date 2017/11/17 下午4:32
 * @desc
 */
public interface BaseDataMapper {

    @Select("select id, name from tb_base where pid = 'area'")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    List<BaseData> queryCity();
}
