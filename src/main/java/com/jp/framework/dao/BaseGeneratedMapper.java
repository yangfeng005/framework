package com.jp.framework.dao;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseGeneratedMapper<EntityAO, EntityCriteria> extends DataMapper<EntityAO, EntityCriteria> {
    int countByCriteria(EntityCriteria var1);

    int deleteByCriteria(EntityCriteria var1);

    int deleteByPrimaryKey(String var1);

    int insert(EntityAO var1);

    int insertSelective(EntityAO var1);

    List<EntityAO> selectByCriteria(EntityCriteria var1);

    List<EntityAO> selectByCriteriaWithBLOBs(EntityCriteria var1);

    EntityAO selectByPrimaryKey(String var1);

    int updateByCriteriaSelective(@Param("record") EntityAO var1, @Param("example") EntityCriteria var2);

    int updateByCriteria(@Param("record") EntityAO var1, @Param("example") EntityCriteria var2);

    int updateByPrimaryKeySelective(EntityAO var1);

    int updateByPrimaryKey(EntityAO var1);

    int updateByCriteriaWithBLOBs(@Param("record") EntityAO record, @Param("example") EntityCriteria var2);

    int updateByPrimaryKeyWithBLOBs(EntityAO var1);
}

