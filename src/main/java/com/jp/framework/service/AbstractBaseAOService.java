package com.jp.framework.service;

import com.jp.framework.common.model.ServiceResult;
import com.jp.framework.common.model.ServiceResultHelper;
import com.jp.framework.common.util.Constant;
import com.jp.framework.dao.BaseGeneratedMapper;
import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public abstract class AbstractBaseAOService<EntityAO, EntityCriteria> implements IBaseAOService<EntityAO, EntityCriteria> {
    protected static final Logger LOG = LoggerFactory.getLogger(AbstractBaseAOService.class);
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public AbstractBaseAOService() {
    }

    protected abstract BaseGeneratedMapper<EntityAO, EntityCriteria> getGeneratedMapper();

    @Transactional(
            readOnly = true
    )
    public ServiceResult<EntityAO> selectByPrimaryKey(String id) {
        EntityAO sr = this.getGeneratedMapper().selectByPrimaryKey(id);
        return sr != null?ServiceResultHelper.genResultWithSuccess(sr):ServiceResultHelper.genResult(false, Constant.FAILED, "没有查找到指定数据，ID:[" + id + "]", null);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public ServiceResult<Boolean> saveOrUpdate(EntityAO entityAO) {
        boolean result = false;
        int result1;
        if(this.isSaveNew(entityAO)) {
            result1 = this.getGeneratedMapper().insert(entityAO);
        } else {
            result1 = this.getGeneratedMapper().updateByPrimaryKeySelective(entityAO);
        }

        return result1 > 0?ServiceResultHelper.genResultWithSuccess(Boolean.valueOf(true)):ServiceResultHelper.genResult(false, Constant.FAILED, "保存或更新实体对象失败", Boolean.valueOf(false));
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public ServiceResult<EntityAO> saveOrUpdateRetAO(EntityAO entityAO) {
        boolean result = true;
        int result1;
        if(this.isSaveNew(entityAO)) {
            result1 = this.getGeneratedMapper().insert(entityAO);
        } else {
            result1 = this.getGeneratedMapper().updateByPrimaryKeySelective(entityAO);
        }

        return result1 > 0?ServiceResultHelper.genResultWithSuccess(entityAO):ServiceResultHelper.genResult(false, Constant.FAILED, "保存或更新实体对象失败", null);
    }

    protected boolean isSaveNew(EntityAO entityAO) {
        Method method = ClassUtils.getMethod(entityAO.getClass(), "getId", new Class[0]);
        Object o = null;

        try {
            o = method.invoke(entityAO, new Object[0]);
        } catch (Exception var5) {
            LOG.error("检查AO对象ID是否为空失败", var5);
        }

        boolean r = false;
        if(o == null || o.toString().trim().length() == 0) {
            r = true;
        }

        return r;
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public ServiceResult<Boolean> deleteById(String id) {
        int result = this.getGeneratedMapper().deleteByPrimaryKey(id);
        return result > 0?ServiceResultHelper.genResultWithSuccess(Boolean.valueOf(true)):ServiceResultHelper.genResult(false, Constant.FAILED, "删除实体对象失败", Boolean.valueOf(false));
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public ServiceResult<Boolean> deleteByCriteria(EntityCriteria criteria) {
        boolean result = true;
        int result1 = this.getGeneratedMapper().deleteByCriteria(criteria);
        LOG.info("成功删除了{}条信息", Integer.valueOf(result1));
        return result1 > 0?ServiceResultHelper.genResultWithSuccess(Boolean.valueOf(true)):ServiceResultHelper.genResult(false, Constant.FAILED, "删除实体对象失败", Boolean.valueOf(false));
    }

    @Transactional(
            readOnly = true
    )
    public ServiceResult<List<EntityAO>> selectByCriteria(EntityCriteria criteria) {
        List list = this.getGeneratedMapper().selectByCriteria(criteria);
        return !CollectionUtils.isEmpty(list)?ServiceResultHelper.genResultWithSuccess(list):ServiceResultHelper.genResult(true, Constant.SUCCESS, "查询结果为空", list);
    }

    @Transactional(
            readOnly = true
    )
    public ServiceResult<List<Map<String, Object>>> selectAll(String sql, Object... args) throws Exception {
        SqlSession session = this.sqlSessionFactory.openSession();
        Connection conn = session.getConnection();
        SqlRunner run = new SqlRunner(conn);
        List list = run.selectAll(sql, args);
        return !CollectionUtils.isEmpty(list)?ServiceResultHelper.genResultWithSuccess(list):ServiceResultHelper.genResult(true, Constant.SUCCESS, "查询结果为空", list);
    }

    @Transactional(
            readOnly = true
    )
    public ServiceResult<Integer> countByCriteria(EntityCriteria criteria) {
        int i = this.getGeneratedMapper().countByCriteria(criteria);
        return i > 0?ServiceResultHelper.genResultWithSuccess(Integer.valueOf(i)):ServiceResultHelper.genResult(true, Constant.SUCCESS, "查询结果为空", Integer.valueOf(0));
    }

    public ServiceResult<Boolean> insert(EntityAO entityAO) {
        int result = this.getGeneratedMapper().insert(entityAO);
        return result > 0?ServiceResultHelper.genResultWithSuccess(Boolean.valueOf(true)):ServiceResultHelper.genResult(false, Constant.FAILED, "保存实体对象失败", Boolean.valueOf(false));
    }

    public ServiceResult<Boolean> insertSelective(EntityAO entityAO) {
        int result = this.getGeneratedMapper().insertSelective(entityAO);
        return result > 0?ServiceResultHelper.genResultWithSuccess(Boolean.valueOf(true)):ServiceResultHelper.genResult(false, Constant.FAILED, "保存实体对象失败", Boolean.valueOf(false));
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public ServiceResult<Boolean> update(EntityAO entityAO) {
        int result = this.getGeneratedMapper().updateByPrimaryKey(entityAO);
        return result > 0?ServiceResultHelper.genResultWithSuccess(Boolean.valueOf(true)):ServiceResultHelper.genResult(false, Constant.FAILED, "更新实体对象失败", Boolean.valueOf(false));
    }

    public ServiceResult<Integer> updateByCriteriaSelective(EntityAO entityAO, EntityCriteria criteria) {
        int result = this.getGeneratedMapper().updateByCriteriaSelective(entityAO, criteria);
        return result > 0?ServiceResultHelper.genResultWithSuccess(Integer.valueOf(result)):ServiceResultHelper.genResult(false, Constant.FAILED, "更新实体对象失败", Integer.valueOf(0));
    }

    public ServiceResult<Integer> updateByCriteria(EntityAO entityAO, EntityCriteria criteria) {
        int result = this.getGeneratedMapper().updateByCriteria(entityAO, criteria);
        return result > 0?ServiceResultHelper.genResultWithSuccess(Integer.valueOf(result)):ServiceResultHelper.genResult(false, Constant.FAILED, "更新实体对象失败", Integer.valueOf(0));
    }

    public ServiceResult<Integer> updateByPrimaryKey(EntityAO entityAO) {
        int result = this.getGeneratedMapper().updateByPrimaryKey(entityAO);
        return result > 0?ServiceResultHelper.genResultWithSuccess(Integer.valueOf(result)):ServiceResultHelper.genResult(false, Constant.FAILED, "更新实体对象失败", Integer.valueOf(0));
    }

    public ServiceResult<List<EntityAO>>  selectByCriteriaWithBLOBs(EntityCriteria entityAO){
        List list = this.getGeneratedMapper().selectByCriteriaWithBLOBs(entityAO);
        return !CollectionUtils.isEmpty(list)?ServiceResultHelper.genResultWithSuccess(list):ServiceResultHelper.genResult(true, Constant.SUCCESS, "查询结果为空", list);
    }

    public ServiceResult<Integer> updateByCriteriaWithBLOBs(EntityAO entityAO, EntityCriteria criteria) {
        int result = this.getGeneratedMapper().updateByCriteriaWithBLOBs(entityAO,criteria);
        return result > 0?ServiceResultHelper.genResultWithSuccess(Integer.valueOf(result)):ServiceResultHelper.genResult(false, Constant.FAILED, "更新实体对象失败", Integer.valueOf(0));
    }

    public ServiceResult<Integer>  updateByPrimaryKeyWithBLOBs(EntityAO entityAO){
        int result = this.getGeneratedMapper().updateByPrimaryKeyWithBLOBs(entityAO);
        return result > 0?ServiceResultHelper.genResultWithSuccess(Integer.valueOf(result)):ServiceResultHelper.genResult(false, Constant.FAILED, "更新实体对象失败", Integer.valueOf(0));
    }

}
