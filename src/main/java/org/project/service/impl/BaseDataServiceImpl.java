package org.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.project.dao.BaseDataMapper;
import org.project.domain.bean.BaseData;
import org.project.service.BaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author pengpeng
 * @date 2017/11/17 下午3:49
 * @desc
 */
@Service("baseDataService")
public class BaseDataServiceImpl implements BaseDataService{
    @Autowired
    private BaseDataMapper baseDataMapper;

    @Override
    public PageInfo<BaseData> queryCity(int pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<BaseData> list = baseDataMapper.queryCity();
        PageInfo<BaseData> pageInfo = new PageInfo<BaseData>(list);
        return  pageInfo;
    }
}
