package br.gov.sp.fatec.recrutatech.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usr_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;
   
    @Column(name = "usr_name")
    private String name;

    @Column(name = "usr_password")
    private String password;

    @Column(name = "usr_email")
    private String email;

    @Column(name = "usr_cpf_cnpj")
    private String cpf_cnpj;
    
    @Column(name = "usr_type")
    private String userType;

    public User() {
    }

    public User(String name, String password, String email, String cpf_cnpj, String userType) {
        this();
        this.name = name;
        this.password = password;
        this.email = email;
        this.cpf_cnpj = cpf_cnpj;
        this.userType = userType;
    }

    public User(String email, String password, String userType) {
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public User(String name, String password, String email, String cpf_cnpj) {
        this();
        this.name = name;
        this.password = password;
        this.email = email;
        this.cpf_cnpj = cpf_cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userType));
    }

    @Override
    public String getUsername() {
       return email;
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
    

}
