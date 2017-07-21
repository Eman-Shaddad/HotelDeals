package com.hotelfinder;

import javax.json.JsonObject;

public class Deals {

	
	private JsonObject offerInfo;
	private JsonObject userInfo;
	private JsonObject offers;
	
	public Deals(JsonObject result) {
		setOfferInfo(result.getJsonObject("offerInfo"));
		setUserInfo(result.getJsonObject("userInfo"));
		setOffers(result.getJsonObject("offers"));
		
	}

	public JsonObject getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(JsonObject userInfo) {
		this.userInfo = userInfo;
	}

	public JsonObject getOfferInfo() {
		return offerInfo;
	}

	public void setOfferInfo(JsonObject offerInfo) {
		this.offerInfo = offerInfo;
	}

	public JsonObject getOffers() {
		return offers;
	}

	public void setOffers(JsonObject offers) {
		this.offers = offers;
	}
}
