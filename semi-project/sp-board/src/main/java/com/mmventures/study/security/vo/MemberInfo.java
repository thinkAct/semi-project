package com.mmventures.study.security.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import com.mmventures.study.core.domain.CommonField;
import com.mmventures.study.core.domain.UserInfo;
/**
 * member information.
 * @author heechanglee
 *
 */
public class MemberInfo extends UserInfo implements UserDetails {

	private static final long serialVersionUID = -4086869747130410600L;
	

	/** Set of authorities.*/
	private Set<GrantedAuthority> authorities;
	
    /**
     * set UserInfo. 
     * @param sequenceId int type sequence number
     * @param userEmail String type user id
     * @param userNickName String type user nickname
     * @param userName String type user name
     * @param userPassword String type user password
     * @param userAddress String type user address
     * @param userPhoneNumber String type user address
     * @param userCommonField CommonField
     * @param userAuthorities CollectionType authorities
     */
	public MemberInfo(final int sequenceId, final String userEmail,
			final String userNickName,
			final String userName, final String userPassword, 
			final String userAddress, final String userPhoneNumber, 
			final CommonField userCommonField, 
			final Collection <? extends GrantedAuthority> userAuthorities) {

		super.setId(sequenceId);
		super.setEmail(userEmail);
		super.setNickName(userNickName);
		super.setName(userName);
		super.setPassword(userPassword);
		super.setAddress(userAddress);
		super.setPhoneNumber(userPhoneNumber);
		super.setPhoneNumber(userPhoneNumber);
		super.setCommonField(userCommonField);

		this.authorities = Collections.unmodifiableSet(
				sortAuthorities(userAuthorities));
	}
	

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
	}
	

	
	/**
	 * user Id is Email.
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		//User id is email.
		return getEmail();
	}

	/**
	 * user account is not expired.
	 */
	@Override
	public final boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * user account is not locked.
	 */
	@Override
	public  final boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	//why this value return true? Reason???
	/**
	 * user password is not expired.
	 */
	@Override
	public final boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//why this value return true? Reason???
	@Override
	public final boolean isEnabled() {
		// TODO Auto-generated method stub

		
		return true;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getNickName() {
		// TODO Auto-generated method stub
		return super.getNickName();
	}

	@Override
	public void setNickName(String nickName) {
		// TODO Auto-generated method stub
		super.setNickName(nickName);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return super.getAddress();
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		super.setAddress(address);
	}

	@Override
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return super.getPhoneNumber();
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		super.setPhoneNumber(phoneNumber);
	}

	@Override
	public CommonField getCommonField() {
		// TODO Auto-generated method stub
		return super.getCommonField();
	}

	@Override
	public void setCommonField(CommonField commonField) {
		// TODO Auto-generated method stub
		super.setCommonField(commonField);
	}
	
	private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        // Ensure array iteration order is predictable (as per UserDetails.getAuthorities() contract and SEC-717)
        SortedSet<GrantedAuthority> sortedAuthorities =
            new TreeSet<GrantedAuthority>(new AuthorityComparator());

        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }

        return sortedAuthorities;
    }
	
	private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to the set.
            // If the authority is null, it is a custom authority and should precede others.
            if (g2.getAuthority() == null) {
                return -1;
            }

            if (g1.getAuthority() == null) {
                return 1;
            }

            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }
}
