/**
 * Copyright (c) 2008-2016, Massachusetts Institute of Technology (MIT)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package edu.mit.ll.nics.common.entity;

// Generated Oct 4, 2011 11:32:19 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

import edu.mit.ll.nics.common.entity.datalayer.DocumentUser;

/**
 * User generated by hbm2java
 */
@Entity
@Proxy(lazy=false)
@Table(name = "`user`", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@SequenceGenerator(
	name="SEQ_STORE",
	sequenceName="user_seq",
	allocationSize=1
)
public class User extends SADisplayMessageEntity implements SADisplayPersistedEntity {

	private int userId;
	private String username;
	private String passwordHash;
	private byte[] passwordEncrypted;
	private String idpPass; // used for IDP
	private String firstname;
	private String lastname;
	private Date lastupdated;
	private Date passwordchanged;
	private boolean enabled;
	private boolean active;
	private Date created;
	private Set<SystemRole> roles;
	private Set<CurrentUserSession> currentusersessions = new HashSet<CurrentUserSession>(0);
	private Set<DocumentUser> documentUsers = new HashSet<DocumentUser>(0);
	private Set<Contact> contacts = new HashSet<Contact>(0);
	private Set<UserOrg> userorgs = new HashSet<UserOrg>(0);
	//private Set<UserFeature> userfeatures = new HashSet<UserFeature>(0);
	private Set<CollabroomPermission> collabroompermissions = new HashSet<CollabroomPermission>(0);
	

	public User() {
	}

	public User(int userid, String username, String passwordHash,
			 byte[] passwordencrypted, Date lastupdated, boolean enabled,
			Date created, Date passwordchanged) {
		this.userId = userid;
		this.username = username;
		this.passwordHash = passwordHash;
		this.passwordEncrypted = passwordencrypted;
		this.lastupdated = lastupdated;
		this.enabled = enabled;
		this.created = created;
		this.passwordchanged = passwordchanged;
	}

	public User(int userid, String username, String passwordHash,
			String firstname, String lastname, Date lastupdated,
			boolean enabled, Date created, byte[] passwordencrypted,
			Date passwordchanged,
			Set<CurrentUserSession> currentusersessions,
			Set<DocumentUser> documentUsers, Set<Contact> contacts,
			Set<UserOrg> userorgs) {
		this.userId = userid;
		this.username = username;
		this.passwordHash = passwordHash;
		this.firstname = firstname;
		this.lastname = lastname;
		this.lastupdated = lastupdated;
		this.passwordchanged = passwordchanged;
		this.enabled = enabled;
		this.created = created;
		this.passwordEncrypted = passwordencrypted;
		this.currentusersessions = currentusersessions;
		this.documentUsers = documentUsers;
		this.contacts = contacts;
		this.userorgs = userorgs;
	}

	@Id
	@Column(name = "userid", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userid) {
		this.userId = userid;
	}

	@Column(name = "username", unique = true, nullable = false, length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "passwordHash", nullable = false, length = 65)
	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	@Column(name = "passwordencrypted", nullable = false, length = 65)
	public byte[] getPasswordEncrypted() {
		return this.passwordEncrypted;
	}

	public void setPasswordEncrypted(byte[] passwordencrypted) {
		this.passwordEncrypted = passwordencrypted;
	}

	@Column(name = "firstname", length = 20)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = encodeForHTML(firstname);
	}

	@Column(name = "lastname", length = 20)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = encodeForHTML(lastname);
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastupdated", nullable = false, length = 29)
	public Date getLastupdated() {
		return this.lastupdated;
	}

	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "passwordchanged", nullable = false, length = 29)
	public Date getPasswordchanged() {
		return this.passwordchanged;
	}

	public void setPasswordchanged(Date passwordchanged) {
		this.passwordchanged = passwordchanged;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Column(name = "active")
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 29)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<CurrentUserSession> getCurrentusersessions() {
		return this.currentusersessions;
	}

	public void setCurrentusersessions(
			Set<CurrentUserSession> currentusersessions) {
		this.currentusersessions = currentusersessions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<DocumentUser> getDocumentUsers() {
		return this.documentUsers;
	}

	public void setDocumentUsers(Set<DocumentUser> documentUsers) {
		this.documentUsers = documentUsers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	public Set<UserOrg> getUserorgs() {
		return this.userorgs;
	}

	public void setUserorgs(Set<UserOrg> userorgs) {
		this.userorgs = userorgs;
	}
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserFeature> getUserfeatures() {
		return this.userfeatures;
	}

	public void setUserfeatures(Set<UserFeature> userfeatures) {
		this.userfeatures = userfeatures;
	}*/
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<CollabroomPermission> getCollabroompermissions() {
		return this.collabroompermissions;
	}

	public void setCollabroompermissions(Set<CollabroomPermission> collabroompermissions) {
		this.collabroompermissions = collabroompermissions;
	}

	public void setPasswordIDP(String idpPa)
	{
		this.idpPass = idpPa;
	}

	public String getPasswordIDP()
	{
		return this.idpPass;
	}
	
	/*@ManyToMany(targetEntity = SystemRole.class, fetch=FetchType.EAGER)
	@JoinTable(name = "currentusersession",
	    joinColumns = @JoinColumn(name = "userid") ,
	    inverseJoinColumns = @JoinColumn(name = "systemroleid"))
	public Set<SystemRole> getRoles(){ return this.roles; }
	public void setRoles(Set<SystemRole> roles) { this.roles = roles; }*/

	@Override
	public JSONObject toJSONObject() throws JSONException {
		JSONObject object = new JSONObject();
		
		object.put("userId", this.userId);
		object.put("username", this.username);
		object.put("passwordHash", this.passwordHash);
		object.put("firstname", this.firstname);
		object.put("lastname", this.lastname);
		object.put("lastupdated", this.lastupdated);
		object.put("passwordchanged", this.passwordchanged);
		object.put("enabled",this.enabled);
		object.put("created", this.created);
		object.put("active", this.active);
		/*try{
			System.out.println("BYTE VALUE: " + this.passwordEncrypted);
			String decoded = new String(this.passwordEncrypted, "ISO-8859-1");
			object.put("passwordEncrypted", decoded);
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		return object;
	}
}
