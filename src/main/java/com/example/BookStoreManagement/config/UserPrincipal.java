//
//package com.example.BookStoreManagement.config;
//
//import java.util.Collection;
//import java.util.Objects;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.example.BookStoreManagement.data.model.User;
//
//
//public class UserPrincipal implements UserDetails {
//    private Long id;
//
//    private String name;
//
//    private String username;
//
//    private String companyCode;
//
//    private String email;
//
//    private String password;
//
//    private String firstName;
//    private String lastName;
//    private String mainmenulabel;
//    private String token;
//    private String dbName;
//
//    private String message;
//    private String status;
//    private String fullname;
//    private String companyName;
//    
//    private String level2;
//    private String  level1;
//    
//    private String accesstype;
//    private Integer usergroupid;
//    private Integer noofusers;
//    private String loginName;
//
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserPrincipal(Long id, String username, String loginName, String password, String companyCode) {
//        this.id = id;
//        this.username = username;
//        this.loginName = loginName;
//        this.password = password;
//        this.companyCode = companyCode;
//    }
//
//    /**
//     * 
//     */
//    public UserPrincipal() {
//	// TODO Auto-generated constructor stub
//    }
//
//    public static UserPrincipal create(User user, String companyCode2) {
//
//	return new UserPrincipal(user.getId(), user.getUsername(),user.getPassword(), companyCode2);
//    }
//
//    public Long getId() {
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
//    public String getUsername() {
//	return username;
//    }
//
//    public String getPassword() {
//	return password;
//    }
//
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//	return authorities;
//    }
//
//    public boolean isAccountNonExpired() {
//	return true;
//    }
//
//    public boolean isAccountNonLocked() {
//	return true;
//    }
//
//    public boolean isCredentialsNonExpired() {
//	return true;
//    }
//
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
//    public void setId(Long id) {
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
//	public String getLevel2() {
//		return level2;
//	}
//
//	public void setLevel2(String level2) {
//		this.level2 = level2;
//	}
//
//	public String getLevel1() {
//		return level1;
//	}
//
//	public void setLevel1(String level1) {
//		this.level1 = level1;
//	}
//
//	public String getAccesstype() {
//		return accesstype;
//	}
//
//	public void setAccesstype(String accesstype) {
//		this.accesstype = accesstype;
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
//	public Integer getNoofusers() {
//		return noofusers;
//	}
//
//	public void setNoofusers(Integer noofusers) {
//		this.noofusers = noofusers;
//	}
//
//	public String getLoginName() {
//		return loginName;
//	}
//
//	public void setLoginName(String loginName) {
//		this.loginName = loginName;
//	}
//
//	
//
//}
