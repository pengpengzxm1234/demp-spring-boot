package org.project.service;

import com.github.pagehelper.PageInfo;
import org.project.domain.bean.BaseData;


/**
 * @author pengpeng
 * @date 2017/11/17 下午3:49
 * @desc
 */
public interface BaseDataService {

    PageInfo<BaseData> queryCity(int pageNum);
}
