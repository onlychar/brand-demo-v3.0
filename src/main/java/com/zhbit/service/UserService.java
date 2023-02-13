package com.zhbit.service;

import com.zhbit.mapper.BrandMapper;
import com.zhbit.mapper.UserMapper;
import com.zhbit.pojo.Brand;
import com.zhbit.pojo.User;
import com.zhbit.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    /**
     * 登录方法
     * @param uname
     * @param pwd
     * @return
     */
    public User login(String uname,String pwd){
        //获取sqlsession对象，并且通过sqlsession对象获得mapper对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.select(uname,pwd);
        sqlSession.close();
        return user;
    }

    /**
     * 注册方法
     * @param user
     * @return
     */
    public boolean register(User user){
        //获取sqlsession对象，并且通过sqlsession对象获得mapper对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //判断用户吗是否存在
        User u = userMapper.selectByUsername(user.getUsername( ));
        if(u==null){
            userMapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return  u==null;
    }

    public User selectUserByUsername(String username){
        //获取sqlsession对象，并且通过sqlsession对象获得mapper对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //判断用户吗是否存在
        User user = userMapper.selectByUsername(username);
        return  user;
    }



}
