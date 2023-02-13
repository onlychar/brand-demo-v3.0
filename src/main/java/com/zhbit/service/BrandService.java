package com.zhbit.service;

import com.zhbit.mapper.BrandMapper;
import com.zhbit.pojo.Brand;
import com.zhbit.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    /**
     * 查询所有
     * @return
     */
    public List<Brand> selectAll(){
        //获取sqlsession对象，并且通过sqlsession对象获得mapper对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用BrandMapper.selectAll()
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        return brands;
    }

    /**
     * 添加一条记录
     * @param brand
     * @return
     */
    public int add(Brand brand){
        //获取sqlsession对象，并且通过sqlsession对象获得mapper对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        int i= brandMapper.add(brand);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
    /**
     * 查询所有
     * @return
     */
    public Brand selectById(int id){
        //获取sqlsession对象，并且通过sqlsession对象获得mapper对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);
        sqlSession.close();
        return brand;
    }
    /**
     * 更新一条记录
     * @param brand
     * @return
     */
    public int update(Brand brand){
        //获取sqlsession对象，并且通过sqlsession对象获得mapper对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        int i= brandMapper.update(brand);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
    /**
     * 更新一条记录
     * @param brand
     * @return
     */
    public int deleteById(int id){
        //获取sqlsession对象，并且通过sqlsession对象获得mapper对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        int i= brandMapper.deleteById(id);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
