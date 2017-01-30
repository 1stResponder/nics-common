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

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

import org.json.JSONException;
import org.json.JSONObject;

public class Alert  {

	private int alertid;
	private String username;
	private String message;
	private Timestamp created;

	public Alert() {
		super();
	}

	public Alert(int alertid, Timestamp created) {
		super();
		this.alertid = alertid;		
		this.created = created;
	}

	public Alert(int alertid, String message, Timestamp created) {
		super();
		this.alertid = alertid;
		this.message = message;
		this.created = created;		
	}	

	/**
	 * Full Constructor
	 * 
	 * @param userid
	 * @param message
	 * @param created
	 * @param workspaceid
	 * @param incidentid
	 */
	public Alert(int alertid, String username, String message, Timestamp created) {
		super();
		this.alertid = alertid;
		this.username = username;
		this.message = message;
		this.created = created;
	}
	
	public int getAlertid() {
		return this.alertid;
	}

	public void setAlertid(int alertid) {
		this.alertid = alertid;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
}
