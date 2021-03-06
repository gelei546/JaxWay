package com.gateway.jaxway.admin.dao.mapper;

import com.gateway.jaxway.admin.dao.model.JaxwayServerModel;

import java.util.List;

public interface JaxwayServerModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JaxwayServerModel record);

    int insertSelective(JaxwayServerModel record);

    JaxwayServerModel selectByPrimaryKey(Integer id);

    List<JaxwayServerModel> selectJaxwayServersByUserId(Integer id);

    int updateByPrimaryKeySelective(JaxwayServerModel record);

    int updateByPrimaryKey(JaxwayServerModel record);
}