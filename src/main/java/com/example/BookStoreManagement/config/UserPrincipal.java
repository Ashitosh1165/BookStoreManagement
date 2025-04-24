//package com.ravish.ClinicServer.config;
//
//import java.util.Collection;
//import java.util.Objects;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.ravish.ClinicServer.data.model.Tbresource;
//
//public class UserPrincipal implements UserDetails {
//    private Integer id;
//    private String name;
//    private String username;
//    private String companyCode;
//    private String email;
//    private String password;
//    private String companyaddress;
//    private String firstName;
//    private String lastName;
//    private String mainmenulabel;
//    private String token;
//    private String dbName;
//    private String message;
//    private String status;
//    private String fullname;
//    private String companyName;
//    private String fullnamefortoggal;
//    private Character cancreateproject;
//    private Character isreporting;
//    private String telephone1;
//    private String accesstype;
//    private boolean productcompulsory;
//    private boolean productflag;
//    private Integer usergroupid;
//    private String landingpage;
//    private String resourceName;
//    private String mobile;
//    private String designation;
//    private String employeecode;
//    private Integer reportingmanager;
//    private String band;
//    private String department;
//    private Integer useridmenu;
//    private Character reshead;
//    
//
//    public String getEmployeecode() {
//		return employeecode;
//	}
//
//	public void setEmployeecode(String employeecode) {
//		this.employeecode = employeecode;
//	}
//
//	public String getResourceName() {
//		return resourceName;
//	}
//
//	public void setResourceName(String resourceName) {
//		this.resourceName = resourceName;
//	}
//
//	private Collection<? extends GrantedAuthority> authorities;
//
//    public UserPrincipal(Integer id, String name, String username, String email, String password, String companyCode) {
//	this.id = id;
//	this.name = name;
//	this.username = username;
//	this.email = email;
//	this.password = password;
//	this.companyCode = companyCode;
//
//    }
//
//    /**
//     * 
//     */
//    public UserPrincipal() {
//	// TODO Auto-generated constructor stub
//    }
//
//    public static UserPrincipal create(Tbresource user, String companyCode2) {
//
//	return new UserPrincipal(user.getResourceId(), user.getName(), user.getLoginName(), user.getEmail(),
//		user.getPassword(), companyCode2);
//    }
//
//    public Integer getId() {
//	return id;
//    }
//
//    public String getName() {
//	return name;
//    }
//
//    public String getCompanyCode() {
//	return companyCode;
//    }
//
//    public String getEmail() {
//	return email;
//    }
//
//    @Override
//    public String getUsername() {
//	return username;
//    }
//
//    @Override
//    public String getPassword() {
//	return password;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//	return authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//	return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//	return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//	return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//	return true;
//    }
//
//    public String getFirstName() {
//	return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//	this.firstName = firstName;
//    }
//
//    public String getLastName() {
//	return lastName;
//    }
//
//    public void setLastName(String lastName) {
//	this.lastName = lastName;
//    }
//
//    public String getMainmenulabel() {
//	return mainmenulabel;
//    }
//
//    public void setMainmenulabel(String mainmenulabel) {
//	this.mainmenulabel = mainmenulabel;
//    }
//
//    public String getToken() {
//	return token;
//    }
//
//    public void setToken(String token) {
//	this.token = token;
//    }
//
//    public String getDbName() {
//	return dbName;
//    }
//
//    public void setDbName(String dbName) {
//	this.dbName = dbName;
//    }
//
//    public String getMessage() {
//	return message;
//    }
//
//    public void setMessage(String message) {
//	this.message = message;
//    }
//
//    public void setId(Integer id) {
//	this.id = id;
//    }
//
//    public void setName(String name) {
//	this.name = name;
//    }
//
//    public void setUsername(String username) {
//	this.username = username;
//    }
//
//    public void setCompanyCode(String companyCode) {
//	this.companyCode = companyCode;
//    }
//
//    public void setEmail(String email) {
//	this.email = email;
//    }
//
//    public void setPassword(String password) {
//	this.password = password;
//    }
//
//    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
//	this.authorities = authorities;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//	if (this == o)
//	    return true;
//	if (o == null || getClass() != o.getClass())
//	    return false;
//	UserPrincipal that = (UserPrincipal) o;
//	return Objects.equals(id, that.id);
//    }
//
//    @Override
//    public int hashCode() {
//
//	return Objects.hash(id);
//    }
//
//    public String getCompanyName() {
//	return companyName;
//    }
//
//    public void setCompanyName(String companyName) {
//	this.companyName = companyName;
//    }
//
//    public String getFullname() {
//	return fullname;
//    }
//
//    public void setFullname(String fullname) {
//	this.fullname = fullname;
//    }
//
//    public String getStatus() {
//	return this.status;
//    }
//
//    public void setStatus(String status) {
//	this.status = status;
//    }
//
//	public String getAccesstype() {
//		return accesstype;
//	}
//
//	public void setAccesstype(String accesstype) {
//		this.accesstype = accesstype;
//	}
//
//	public boolean isProductcompulsory() {
//		return productcompulsory;
//	}
//
//	public void setProductcompulsory(boolean productcompulsory) {
//		this.productcompulsory = productcompulsory;
//	}
//
//	public boolean isProductflag() {
//		return productflag;
//	}
//
//	public void setProductflag(boolean productflag) {
//		this.productflag = productflag;
//	}
//
//	public String getCompanyaddress() {
//		return companyaddress;
//	}
//
//	public void setCompanyaddress(String companyaddress) {
//		this.companyaddress = companyaddress;
//	}
//
//	public String getTelephone1() {
//		return telephone1;
//	}
//
//	public void setTelephone1(String telephone1) {
//		this.telephone1 = telephone1;
//	}
//
//	public Integer getUsergroupid() {
//		return usergroupid;
//	}
//
//	public void setUsergroupid(Integer usergroupid) {
//		this.usergroupid = usergroupid;
//	}
//
//	public String getLandingpage() {
//		return landingpage;
//	}
//
//	public void setLandingpage(String landingpage) {
//		this.landingpage = landingpage;
//	}
//
//
//	public String getMobile() {
//		return mobile;
//	}
//
//	public void setMobile(String mobile) {
//		this.mobile = mobile;
//	}
//	public String getDesignation() {
//		return designation;
//	}
//
//	public void setDesignation(String designation) {
//		this.designation = designation;
//
//	}
//
//	public String getFullnamefortoggal() {
//		return fullnamefortoggal;
//	}
//
//	public void setFullnamefortoggal(String fullnamefortoggal) {
//		this.fullnamefortoggal = fullnamefortoggal;
//	}
//
//	public Character getCancreateproject() {
//		return cancreateproject;
//	}
//
//	public void setCancreateproject(Character cancreateproject) {
//		this.cancreateproject = cancreateproject;
//	}
//
//	public Character getIsreporting() {
//		return isreporting;
//	}
//
//	public void setIsreporting(Character isreporting) {
//		this.isreporting = isreporting;
//	}
//
//	public Integer getReportingmanager() {
//		return reportingmanager;
//	}
//
//	public void setReportingmanager(Integer reportingmanager) {
//		this.reportingmanager = reportingmanager;
//	}
//
//	public String getBand() {
//		return band;
//	}
//
//	public void setBand(String band) {
//		this.band = band;
//	}
//
//	public String getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}
//
//	public Integer getUseridmenu() {
//		return useridmenu;
//	}
//
//	public void setUseridmenu(Integer useridmenu) {
//		this.useridmenu = useridmenu;
//	}
//
//	public Character getReshead() {
//		return reshead;
//	}
//
//	public void setReshead(Character reshead) {
//		this.reshead = reshead;
//	}
//
//	
//
//
//
//	
//
//}
package com.example.BookStoreManagement.config;
/*  @author Ashitosh* */
import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.BookStoreManagement.data.model.User;


public class UserPrincipal implements UserDetails {
    private Integer id;
    private String name;
    private String username;
    private String companyCode;
    private String email;
    private String password;
    private String companyaddress;
    private String firstName;
    private String lastName;
    private String mainmenulabel;
    private String token;
    private String dbName;
    private String message;
    private String status;
    private String fullname;
    private String companyName;
    private String fullnamefortoggal;
    private Character cancreateproject;
    private Character isreporting;
    private String telephone1;
    private String accesstype;
    private boolean productcompulsory;
    private boolean productflag;
    private Integer usergroupid;
    private String landingpage;
    private String resourceName;
    private String mobile;
    private String designation;
    private String employeecode;
    private Integer reportingmanager;
    private String band;
    private String department;
    private Integer useridmenu;
    private Character reshead;
    private String accessToken;
    private String drflag;
   	private Integer trnid;
	private Integer doctorid;
	private String ddctype;
	private String date;
	private Integer patientid;
	private String landpage;
	private String selecteddate;
	private Integer defaultlocation;
	private String imgname;
	private String frontOfficeflag;
	private Integer doctorflag;
	private String pagetype = "a4";
	private String mtop = "0";
	private String mbottom = "0";
	private String mleft = "0";
	private String mright = "0";
	private String fontsize = "0";
    private String unit;
    private String diagnosis;
    private String symtoms;
    private String xray;


    public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Integer id, String name, String username, String email, String password, String companyCode) {
	this.id = id;
	this.name = name;
	this.username = username;
	this.email = email;
	this.password = password;
	this.companyCode = companyCode;

    }

    /**
     * 
     */
    public UserPrincipal() {
	// TODO Auto-generated constructor stub
    }

    public static UserPrincipal create(User user, String companyCode2) {

	return new UserPrincipal(
		);
    }

    public Integer getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getCompanyCode() {
	return companyCode;
    }

    public String getEmail() {
	return email;
    }

    @Override
    public String getUsername() {
	return username;
    }

    @Override
    public String getPassword() {
	return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getMainmenulabel() {
	return mainmenulabel;
    }

    public void setMainmenulabel(String mainmenulabel) {
	this.mainmenulabel = mainmenulabel;
    }

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    public String getDbName() {
	return dbName;
    }

    public void setDbName(String dbName) {
	this.dbName = dbName;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public void setCompanyCode(String companyCode) {
	this.companyCode = companyCode;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
	this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	UserPrincipal that = (UserPrincipal) o;
	return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

	return Objects.hash(id);
    }

    public String getCompanyName() {
	return companyName;
    }

    public void setCompanyName(String companyName) {
	this.companyName = companyName;
    }

    public String getFullname() {
	return fullname;
    }

    public void setFullname(String fullname) {
	this.fullname = fullname;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

	public String getAccesstype() {
		return accesstype;
	}

	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}

	public boolean isProductcompulsory() {
		return productcompulsory;
	}

	public void setProductcompulsory(boolean productcompulsory) {
		this.productcompulsory = productcompulsory;
	}

	public boolean isProductflag() {
		return productflag;
	}

	public void setProductflag(boolean productflag) {
		this.productflag = productflag;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public Integer getUsergroupid() {
		return usergroupid;
	}

	public void setUsergroupid(Integer usergroupid) {
		this.usergroupid = usergroupid;
	}

	public String getLandingpage() {
		return landingpage;
	}

	public void setLandingpage(String landingpage) {
		this.landingpage = landingpage;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;

	}

	public String getFullnamefortoggal() {
		return fullnamefortoggal;
	}

	public void setFullnamefortoggal(String fullnamefortoggal) {
		this.fullnamefortoggal = fullnamefortoggal;
	}

	public Character getCancreateproject() {
		return cancreateproject;
	}

	public void setCancreateproject(Character cancreateproject) {
		this.cancreateproject = cancreateproject;
	}

	public Character getIsreporting() {
		return isreporting;
	}

	public void setIsreporting(Character isreporting) {
		this.isreporting = isreporting;
	}

	public Integer getReportingmanager() {
		return reportingmanager;
	}

	public void setReportingmanager(Integer reportingmanager) {
		this.reportingmanager = reportingmanager;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getUseridmenu() {
		return useridmenu;
	}

	public void setUseridmenu(Integer useridmenu) {
		this.useridmenu = useridmenu;
	}

	public Character getReshead() {
		return reshead;
	}

	public void setReshead(Character reshead) {
		this.reshead = reshead;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getDrflag() {
		return drflag;
	}

	public void setDrflag(String drflag) {
		this.drflag = drflag;
	}

	public Integer getTrnid() {
		return trnid;
	}

	public void setTrnid(Integer trnid) {
		this.trnid = trnid;
	}

	public Integer getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Integer doctorid) {
		this.doctorid = doctorid;
	}

	public String getDdctype() {
		return ddctype;
	}

	public void setDdctype(String ddctype) {
		this.ddctype = ddctype;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getPatientid() {
		return patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

	public String getLandpage() {
		return landpage;
	}

	public void setLandpage(String landpage) {
		this.landpage = landpage;
	}

	public String getSelecteddate() {
		return selecteddate;
	}

	public void setSelecteddate(String selecteddate) {
		this.selecteddate = selecteddate;
	}

	public Integer getDefaultlocation() {
		return defaultlocation;
	}

	public void setDefaultlocation(Integer defaultlocation) {
		this.defaultlocation = defaultlocation;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getFrontOfficeflag() {
		return frontOfficeflag;
	}

	public void setFrontOfficeflag(String frontOfficeflag) {
		this.frontOfficeflag = frontOfficeflag;
	}

	public Integer getDoctorflag() {
		return doctorflag;
	}

	public void setDoctorflag(Integer doctorflag) {
		this.doctorflag = doctorflag;
	}

	public String getPagetype() {
		return pagetype;
	}

	public void setPagetype(String pagetype) {
		this.pagetype = pagetype;
	}

	public String getMtop() {
		return mtop;
	}

	public void setMtop(String mtop) {
		this.mtop = mtop;
	}

	public String getMbottom() {
		return mbottom;
	}

	public void setMbottom(String mbottom) {
		this.mbottom = mbottom;
	}

	public String getMleft() {
		return mleft;
	}

	public void setMleft(String mleft) {
		this.mleft = mleft;
	}

	public String getMright() {
		return mright;
	}

	public void setMright(String mright) {
		this.mright = mright;
	}

	public String getFontsize() {
		return fontsize;
	}

	public void setFontsize(String fontsize) {
		this.fontsize = fontsize;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getSymtoms() {
		return symtoms;
	}

	public void setSymtoms(String symtoms) {
		this.symtoms = symtoms;
	}

	public String getXray() {
		return xray;
	}

	public void setXray(String xray) {
		this.xray = xray;
	}

}
