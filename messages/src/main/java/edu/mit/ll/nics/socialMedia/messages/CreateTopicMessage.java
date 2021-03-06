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
package edu.mit.ll.nics.socialMedia.messages;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.mit.ll.nics.common.entity.SADisplayMessageEntity;
import edu.mit.ll.nics.common.entity.social.SocialMediaSource;

public class CreateTopicMessage extends AbstractSocialMediaMessage // implements SADisplayMessageEntity
{
	public static final String USER = "user",
						 USERID = "userid",
						 TOPICNAME = "topic",
						 QUERY = "query",
						 LATITUDE = "latitude",
						 LONGITUDE = "longitude",
						 RADIUS = "radius",
						 AUTHORS = "authors",
						 SOURCES = "sources",
						 ACTIVE = "active",
						 RECORDING = "recording";
	
	protected String user,
					 topic,
					 query;
	
	protected Double latitude,
					 longitude,
					 radius;
	
	protected Integer userid;
	
	protected Integer[] authors;
	
	protected SocialMediaSource[] sources;
	
	protected boolean active,
					  recording;
	
	public CreateTopicMessage()
	{
	}
	
	public CreateTopicMessage(String user, Integer userid, String topic, String query,
				Double lat, Double lon, Double radius, Integer[] authors,
				boolean active, boolean recording)
	{
		this.user = user;
		this.userid = userid;
		this.topic = topic;
		this.query = query;
		this.latitude = lat;
		this.longitude = lon;
		this.radius = radius;
		this.authors = authors;
		this.active = active;
		this.recording = recording;
		
		// default to this - all we got
		this.sources = new SocialMediaSource[1];
		this.sources[0] = SocialMediaSource.TWITTER_REST_v1p1;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double lat) {
		this.latitude = lat;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double lon) {
		this.longitude = lon;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer[] getAuthors() {
		return authors;
	}

	public void setAuthors(Integer[] authors) {
		this.authors = authors;
	}

	public SocialMediaSource[] getSources() {
		return sources;
	}

	public void setSources(SocialMediaSource[] sources) {
		this.sources = sources;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isRecording() {
		return recording;
	}

	public void setRecording(boolean recording) {
		this.recording = recording;
	}

	@Override
	public JSONObject toJSONObject() throws JSONException 
	{
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray();
		
		try
		{
			json.put(USERID, this.userid);
			json.put(USER, this.user);
			json.put(TOPICNAME, this.topic);
			json.put(QUERY, this.query);
			json.put(LATITUDE, this.latitude);
			json.put(LONGITUDE, this.longitude);
			json.put(RADIUS, this.radius);

			// will throw error if unchecked
			if (this.authors != null)
			{
				for (int i=0; i < this.authors.length; i++)
				{
					arr.put(this.authors[i]);
				}
				json.put(AUTHORS, arr);
			}
			
			if (this.sources != null)
			{
				arr = new JSONArray();
				for (int i = 0; i < this.sources.length; i++)
				{
					arr.put(this.sources[i].toString());
				}
				json.put(SOURCES, this.sources);
			}
			
			json.put(ACTIVE, this.active);
			json.put(RECORDING, this.recording);
			
			return json;
		} catch (JSONException je)
		{
			je.printStackTrace();
			return null;
		}
	} // toJSONObject

} // class CreateTopicMessage




