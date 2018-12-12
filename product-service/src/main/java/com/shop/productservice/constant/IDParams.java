/**
 * 
 */
package com.shop.productservice.constant;

/**
 * @author Arnaud
 *
 */


public class IDParams {

	private final String IDSOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private int idsLength = 20;
	
	public int getIdsLength() {
		return idsLength;
	}
	public void setIdsLength(int idsLength) {
		this.idsLength = idsLength;
	}
	public String getIDSOURCE() {
		return IDSOURCE;
	}
}
