package company.com.mybatis.dao;

import company.com.mybatis.model.Companies;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface CompaniesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPANIES
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPANIES
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    int insert(Companies record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPANIES
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    Companies selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPANIES
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    List<Companies> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPANIES
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    int updateByPrimaryKey(Companies record);
}