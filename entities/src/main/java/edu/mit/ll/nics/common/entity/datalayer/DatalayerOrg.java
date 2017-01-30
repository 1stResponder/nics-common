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
package edu.mit.ll.nics.common.entity.datalayer;

import edu.mit.ll.nics.common.entity.Org;
import edu.mit.ll.nics.common.entity.SADisplayMessageEntity;
import edu.mit.ll.nics.common.entity.SADisplayPersistedEntity;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name = "datalayer_org", schema = "public")
public class DatalayerOrg extends SADisplayMessageEntity implements SADisplayPersistedEntity
{
    private String datalayer_orgid;
    private int orgid;
    private String datalayerid;

    private Org org;
    private Datalayer datalayer;

    public DatalayerOrg() {}

    public DatalayerOrg(String orgdatalayerid, int orgid, String datalayerid)
    {
        this.datalayer_orgid = orgdatalayerid;
        this.orgid = orgid;
        this.datalayerid = datalayerid;
    }

    @Id
    @Column(name = "datalayer_orgid", unique = true, nullable = false)
    public String getDatalayer_orgid() {
        return this.datalayer_orgid;
    }

    public void setDatalayer_orgid(String datalayer_orgid) {
        this.datalayer_orgid = datalayer_orgid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "datalayerid", insertable = false, updatable = false)
    public Datalayer getDatalayer() {
        return this.datalayer;
    }

    public void setDatalayer(Datalayer datalayer) {
        this.datalayer = datalayer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orgid", insertable = false, updatable = false)
    public Org getOrg() {
        return this.org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    @Column(name = "datalayerid", nullable = false)
    public String getDatalayerid() {
        return datalayerid;
    }

    public void setDatalayerid(String datalayerid) {
        this.datalayerid = datalayerid;
    }

    @Column(name = "orgid", nullable = false)
    public int getOrgid() {
        return this.orgid;
    }

    public void setOrgid(int orgid) {
        this.orgid = orgid;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("datalayer_orgid", this.datalayer_orgid);
            json.put("orgid", this.orgid);
            json.put("datalayerid", this.datalayerid);
        } catch (JSONException ex) {
            Logger.getLogger(Document.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
