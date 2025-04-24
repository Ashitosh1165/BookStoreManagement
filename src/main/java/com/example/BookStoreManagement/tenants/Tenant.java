package com.example.BookStoreManagement.tenants;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tbrelationwarecompany")
public class Tenant {
	@Id
	@Column(name = "relationwareCompanyID")
	Integer id;
	@Column(name = "companyCode")
	private String companyCode;
	@Column(name = "companyName")
	private String companyName;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "pinCode")
	private String pinCode;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
	@Column(name = "telephone1")
	private String telephone1;
	@Column(name = "telephone2")
	private String telephone2;
	@Column(name = "fax")
	private String fax;
	@Column(name = "website")
	private String website;
	@Column(name = "technicalContactName")
	private String technicalContactName;
	@Column(name = "techConTelephone")
	private String techConTelephone;
	@Column(name = "techConEMail")
	private String techConEMail;
	@Column(name = "billingContactName")
	private String billingContactName;
	@Column(name = "billConTelephone")
	private String billConTelephone;
	@Column(name = "billConEMail")
	private String billConEMail;
	@Column(name = "CSTNo")
	private String CSTNo;
	@Column(name = "BSTNo")
	private String BSTNo;
	@Column(name = "PANNo")
	private String PANNo;
	@Column(name = "longCurrency")
	private String longCurrency;
	@Column(name = "shortCurrency")
	private String shortCurrency;
	@Column(name = "companyDB")
	private String companyDB;
	@Column(name = "dbUserName")
	private String dbUserName;
	@Column(name = "dbPassword")
	private String dbPassword;
	@Column(name = "adminUser")
	private String adminUser;
	@Column(name = "adminPassword")
	private String adminPassword;
	@Column(name = "licenseEndDate")
	private Date licenseEndDate;
	@Column(name = "licenseStartDate")
	private Date licenseStartDate;
	@Column(name = "CompanyLogoURL")
	private String CompanyLogoURL;
	@Column(name = "flag")
	private Character flag = 'N';
	@Column(name = "servicecallstatusflag")
	private Character servicecallstatusflag = 'N';
	@Column(name = "crmadmin")
	private String crmadmin;
	@Column(name = "nooflicenses")
	private Long nooflicenses;
	@Column(name = "productconfigmodeuleflg")
	private Character productconfigmodeuleflg;
	@Column(name = "quotationworkflow")
	private Character quotationapproval;
	@Column(name = "taxgroup")
	private Character taxgroup;
	@Column(name = "activeStatus")
	private Character activeStatus = 'Y';
	@Column(name = "dateTime")
	private Date dateTime;
	@Column(name = "multiproductquotation")
	private Character multiproductquotation = 'Y';
	@Column(name = "singleproductquotation")
	private Character singleproductquotation = 'N';

	@Column(name = "expenseflag")
	private Character expenseflag = 'Y';

	@Column(name = "groupcompanyflag")
	private Character groupcompany = 'N';

	@Column(name = "coveringletterflag")
	private Character coveringletterflag = 'N';

//	@Column(name = "mapintegrationflag")
//	private Character mapintegrationflag = 'N';

	public Tenant() {
		super();
	}


	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTechnicalContactName() {
		return technicalContactName;
	}

	public void setTechnicalContactName(String technicalContactName) {
		this.technicalContactName = technicalContactName;
	}

	public String getTechConTelephone() {
		return techConTelephone;
	}

	public void setTechConTelephone(String techConTelephone) {
		this.techConTelephone = techConTelephone;
	}

	public String getTechConEMail() {
		return techConEMail;
	}

	public void setTechConEMail(String techConEMail) {
		this.techConEMail = techConEMail;
	}

	public String getBillingContactName() {
		return billingContactName;
	}

	public void setBillingContactName(String billingContactName) {
		this.billingContactName = billingContactName;
	}

	public String getBillConTelephone() {
		return billConTelephone;
	}

	public void setBillConTelephone(String billConTelephone) {
		this.billConTelephone = billConTelephone;
	}

	public String getBillConEMail() {
		return billConEMail;
	}

	public void setBillConEMail(String billConEMail) {
		this.billConEMail = billConEMail;
	}

	public String getCSTNo() {
		return CSTNo;
	}

	public void setCSTNo(String cSTNo) {
		CSTNo = cSTNo;
	}

	public String getBSTNo() {
		return BSTNo;
	}

	public void setBSTNo(String bSTNo) {
		BSTNo = bSTNo;
	}

	public String getPANNo() {
		return PANNo;
	}

	public void setPANNo(String pANNo) {
		PANNo = pANNo;
	}

	public String getLongCurrency() {
		return longCurrency;
	}

	public void setLongCurrency(String longCurrency) {
		this.longCurrency = longCurrency;
	}

	public String getShortCurrency() {
		return shortCurrency;
	}

	public void setShortCurrency(String shortCurrency) {
		this.shortCurrency = shortCurrency;
	}

	public String getCompanyDB() {
		return companyDB;
	}

	public void setCompanyDB(String companyDB) {
		this.companyDB = companyDB;
	}

	public String getDbUserName() {
		return dbUserName;
	}

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Date getLicenseEndDate() {
		return licenseEndDate;
	}

	public void setLicenseEndDate(Date licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}

	public Date getLicenseStartDate() {
		return licenseStartDate;
	}

	public void setLicenseStartDate(Date licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}

	public String getCompanyLogoURL() {
		return CompanyLogoURL;
	}

	public void setCompanyLogoURL(String companyLogoURL) {
		CompanyLogoURL = companyLogoURL;
	}

	public Character getFlag() {
		return flag;
	}

	public void setFlag(Character flag) {
		this.flag = flag;
	}

	public Character getServicecallstatusflag() {
		return servicecallstatusflag;
	}

	public void setServicecallstatusflag(Character servicecallstatusflag) {
		this.servicecallstatusflag = servicecallstatusflag;
	}

	public String getCrmadmin() {
		return crmadmin;
	}

	public void setCrmadmin(String crmadmin) {
		this.crmadmin = crmadmin;
	}

	public Long getNooflicenses() {
		return nooflicenses;
	}

	public void setNooflicenses(Long nooflicenses) {
		this.nooflicenses = nooflicenses;
	}

	public Character getProductconfigmodeuleflg() {
		return productconfigmodeuleflg;
	}

	public void setProductconfigmodeuleflg(Character productconfigmodeuleflg) {
		this.productconfigmodeuleflg = productconfigmodeuleflg;
	}

	public Character getQuotationapproval() {
		return quotationapproval;
	}

	public void setQuotationapproval(Character quotationapproval) {
		this.quotationapproval = quotationapproval;
	}

	public Character getTaxgroup() {
		return taxgroup;
	}

	public void setTaxgroup(Character taxgroup) {
		this.taxgroup = taxgroup;
	}

	public Character getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Character activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Character getMultiproductquotation() {
		return multiproductquotation;
	}

	public void setMultiproductquotation(Character multiproductquotation) {
		this.multiproductquotation = multiproductquotation;
	}

	public Character getSingleproductquotation() {
		return singleproductquotation;
	}

	public void setSingleproductquotation(Character singleproductquotation) {
		this.singleproductquotation = singleproductquotation;
	}

	public Character getExpenseflag() {
		return expenseflag;
	}

	public void setExpenseflag(Character expenseflag) {
		this.expenseflag = expenseflag;
	}

	public Character getGroupcompany() {
		return groupcompany;
	}

	public void setGroupcompany(Character groupcompany) {
		this.groupcompany = groupcompany;
	}

	public Character getCoveringletterflag() {
		return coveringletterflag;
	}

	public void setCoveringletterflag(Character coveringletterflag) {
		this.coveringletterflag = coveringletterflag;
	}

//	public Character getMapintegrationflag() {
//		return mapintegrationflag;
//	}
//
//	public void setMapintegrationflag(Character mapintegrationflag) {
//		this.mapintegrationflag = mapintegrationflag;
//	}

}
