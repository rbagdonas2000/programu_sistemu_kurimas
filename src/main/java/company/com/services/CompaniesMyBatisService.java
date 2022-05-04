/*
package company.com.services;

import company.com.mybatis.dao.CompaniesMapper;
import company.com.mybatis.model.Companies;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class CompaniesMyBatisService {

    @Inject
    private CompaniesMapper companiesMapper;

*/
/*
@Inject
    private WorkersMapper workersMapper;

*//*



    @Getter
    private List<Companies> allCompanies;

    @Getter
    @Setter
    private Companies newCompany = new Companies();

    @PostConstruct
    public void init() {
        loadAllCompanies();
    }

    private void loadAllCompanies() {
        allCompanies = companiesMapper.selectAll();
    }

*/
/*public List<Workers> loadCompanyWorkers(Integer companyId){
        return workersMapper.getByCompanyId(companyId);
    }

    @Transactional
    public String createCompany(){
        companiesMapper.insert(newCompany);
        return "/myBatis/companies.xhtml?faces-redirect=true";
    }*//*



}
*/
