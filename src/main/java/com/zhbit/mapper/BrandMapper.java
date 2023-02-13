package com.zhbit.mapper;

import com.zhbit.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有品牌记录
     *
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 添加一条品牌记录
     * @param brand
     * @return
     */
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    int add(Brand brand);

    /**
     * 通过id选择一条品牌记录
     * @param id
     * @return
     */
    @Select("Select * from tb_brand where id=#{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    /**
     * 通过id更新一条记录
     * @param brand
     */
    @Update("update tb_brand set " +
            "brand_name = #{brandName}," +
            "company_name = #{companyName}," +
            "ordered = #{ordered}," +
            "description = #{description},"+
            "status = #{status} where id=#{id}")
    int update(Brand brand);

    /**
     * 通过id删除一条记录
     * @param id
     * @return
     */
    @Delete("delete from tb_brand where id = #{id}")
    int  deleteById(int id);
}
