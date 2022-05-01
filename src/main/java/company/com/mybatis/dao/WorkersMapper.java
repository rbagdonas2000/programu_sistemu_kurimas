package company.com.mybatis.dao;

import company.com.mybatis.model.Workers;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface WorkersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKERS
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKERS
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    int insert(Workers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKERS
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    Workers selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKERS
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    List<Workers> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKERS
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    int updateByPrimaryKey(Workers record);
}