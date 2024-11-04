package com.legalnod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PromoCodeWithBonusPriceInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "promo_code_with_bonus_price_info", schema = "bs")
public class PromoCodeWithBonusPriceInfo implements java.io.Serializable {

	// Fields

	private Integer promoCodeWithBonusPriceInfoId;
	private String promoCodeOption;
	private Integer bonusPrice;

	// Constructors

	/** default constructor */
	public PromoCodeWithBonusPriceInfo() {
	}
	
	// Property accessors
	
	@Id
	@Column(name = "promo_code_with_bonus_price_info_id", unique = true, nullable = false)	
	public Integer getPromoCodeWithBonusPriceInfoId() {
		return this.promoCodeWithBonusPriceInfoId;
	}

	public void setPromoCodeWithBonusPriceInfoId(
			Integer promoCodeWithBonusPriceInfoId) {
		this.promoCodeWithBonusPriceInfoId = promoCodeWithBonusPriceInfoId;
	}

	@Column(name = "promo_code_option", length = 30)
	public String getPromoCodeOption() {
		return this.promoCodeOption;
	}

	public void setPromoCodeOption(String promoCodeOption) {
		this.promoCodeOption = promoCodeOption;
	}

	@Column(name = "bonus_price")
	public Integer getBonusPrice() {
		return this.bonusPrice;
	}

	public void setBonusPrice(Integer bonusPrice) {
		this.bonusPrice = bonusPrice;
	}

}