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


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import org.hibernate.annotations.Proxy;
import org.json.JSONException;
import org.json.JSONObject;


@Entity
@Proxy(lazy=false)
@Table(name = "orgcap")
public class OrgCap extends SADisplayMessageEntity implements SADisplayPersistedEntity {

	private int orgcapid;
	private Cap cap;
	private int orgid;
	private boolean activemobile;
	private boolean activeweb;
	private Date lastupdate;
	
	public OrgCap(){
		
	}
	
	public OrgCap(int orgcapid, Cap cap, int orgid, boolean activemobile, boolean activeweb, Date lastupdate){
		this.orgcapid = orgcapid;
		this.cap = cap;
		this.orgid = orgid;
		this.activemobile = activemobile;
		this.activeweb = activeweb;
		this.lastupdate = lastupdate;		
	}
	
	@Id
	@Column(name = "orgcapid", nullable = false)
	public int getOrgCapId(){
		return this.orgcapid;
	}
	
	public void setOrgCapId(int orgcapid){
		this.orgcapid = orgcapid;
	}
	
	@Column(name = "capid", nullable = false)
	public Cap getCap(){
		return this.cap;
	}
	
	public void setCapId(Cap cap){
		this.cap = cap;
	}
	
	@Column(name = "orgid", nullable = false)
	public int getOrgId(){
		return this.orgid;
	}
	
	public void setOrgId(int orgid){
		this.orgid = orgid;
	}

	@Column(name = "activemobile", nullable = false)
	public boolean getActiveMobile(){
		return this.activemobile;
	}
	
	public void setActiveMobile(boolean activemobile){
		this.activemobile = activemobile;
	}
	@Column(name = "activeweb", nullable = false)
	public boolean getActiveWeb(){
		return this.activeweb;
	}
	
	public void setActiveWeb(boolean activeweb){
		this.activeweb = activeweb;
	}

	@Column(name = "lastupdate", nullable = false, length = 29)
	public Date getUpdated(){
		return this.lastupdate;
	}
	
	public void setUpdated(Date lastupdate){
		this.lastupdate = lastupdate;
	}
	
	@Override
	public JSONObject toJSONObject() throws JSONException {
		JSONObject object = new JSONObject();
		object.put("orgcapid", this.orgcapid);
		object.put("cap", this.cap);
		object.put("orgid", this.orgid);
		object.put("activeweb",this.activeweb);
		object.put("activemobile",this.activemobile);
		object.put("lastupdate",this.lastupdate);
		
		return object;
	}


}
