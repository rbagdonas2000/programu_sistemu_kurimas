package company.com.mybatis.model;

public class Companies {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMPANIES.ID
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMPANIES.NAME
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMPANIES.ID
     *
     * @return the value of PUBLIC.COMPANIES.ID
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMPANIES.ID
     *
     * @param id the value for PUBLIC.COMPANIES.ID
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMPANIES.NAME
     *
     * @return the value of PUBLIC.COMPANIES.NAME
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMPANIES.NAME
     *
     * @param name the value for PUBLIC.COMPANIES.NAME
     *
     * @mbg.generated Tue Apr 26 21:32:44 EEST 2022
     */
    public void setName(String name) {
        this.name = name;
    }
}