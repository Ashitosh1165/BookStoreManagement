package com.example.BookStoreManagement.tenants;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TenantRepository extends CrudRepository<Tenant, String> {

	Tenant findByCompanyCode(String companyCode);


}
