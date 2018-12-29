package com.jp.framework.service;

import com.jp.framework.common.model.ServiceResult;

import java.util.List;
import java.util.Map;

public interface IBaseAOService<EntityAO, EntityCriteria> {
    ServiceResult<Boolean> insert(EntityAO var1);

    ServiceResult<Boolean> insertSelective(EntityAO var1);

    ServiceResult<List<Map<String, Object>>> selectAll(String var1, Object... var2) throws Exception;

    ServiceResult<EntityAO> selectByPrimaryKey(String var1);

    ServiceResult<List<EntityAO>> selectByCriteria(EntityCriteria var1);


    ServiceResult<Integer> countByCriteria(EntityCriteria var1);

    ServiceResult<Boolean> deleteById(String var1);

    ServiceResult<Boolean> deleteByCriteria(EntityCriteria var1);

    ServiceResult<Boolean> update(EntityAO var1);

    ServiceResult<Integer> updateByCriteriaSelective(EntityAO var1, EntityCriteria var2);

    ServiceResult<Integer> updateByCriteria(EntityAO var1, EntityCriteria var2);

    ServiceResult<Integer> updateByPrimaryKey(EntityAO var1);

    ServiceResult<Boolean> saveOrUpdate(EntityAO var1);

    ServiceResult<EntityAO> saveOrUpdateRetAO(EntityAO var1);

    ServiceResult<List<EntityAO>> selectByCriteriaWithBLOBs(EntityCriteria entityAO);

    ServiceResult<Integer> updateByCriteriaWithBLOBs(EntityAO var1, EntityCriteria var2);

    ServiceResult<Integer> updateByPrimaryKeyWithBLOBs(EntityAO entityAO);
}
