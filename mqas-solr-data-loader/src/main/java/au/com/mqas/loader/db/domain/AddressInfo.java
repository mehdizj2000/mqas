package au.com.mqas.loader.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Data
@Entity
@Immutable
@Table(name = "address_info")
public class AddressInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_detail_pid")
	private String addressDetailPid;

	@Column(name = "street_locality_pid")
	private String streetLocalityPid;

	@Column(name = "locality_pid")
	private String localityPid;

	@Column(name = "building_name")
	private String buildingName;

	@Column(name = "lot_number_prefix")
	private String lotNumberPrefix;

	@Column(name = "lot_number")
	private String lotNumber;

	@Column(name = "lot_number_suffix")
	private String lotNumberSuffix;

	@Column(name = "flat_type")
	private String flatType;

	@Column(name = "flat_number_prefix")
	private String flatNumberPrefix;

	@Column(name = "flat_number")
	private String flatNumber;

	@Column(name = "flat_number_suffix")
	private String flatNumberSuffix;

	@Column(name = "level_type")
	private String levelType;

	@Column(name = "level_number_prefix")
	private String levelNumberPrefix;

	@Column(name = "level_number")
	private String levelNumber;

	@Column(name = "level_number_suffix")
	private String levelNumberSuffix;

	@Column(name = "number_first_prefix")
	private String numberFirstPrefix;

	@Column(name = "number_first")
	private String numberFirst;

	@Column(name = "number_first_suffix")
	private String numberFirstSuffix;

	@Column(name = "number_last_prefix")
	private String numberLastPrefix;

	@Column(name = "number_last")
	private String numberLast;

	@Column(name = "number_last_suffix")
	private String numberLastSuffix;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "street_class_code")
	private String streetClassCode;

	@Column(name = "street_class_type")
	private String streetClassType;

	@Column(name = "street_type_code")
	private String streetTypeCode;

	@Column(name = "street_suffix_code")
	private String streetSuffixCode;

	@Column(name = "street_suffix_type")
	private String streetSuffixType;

	@Column(name = "locality_name")
	private String localityName;

	@Column(name = "state_abbreviation")
	private String stateAbbreviation;

	private String postcode;

	private String latitude;

	private String longitude;

	@Column(name = "geocodeType")
	private String geocode_type;

	private String confidence;

	@Column(name = "alias_principal")
	private String aliasPrincipal;

	@Column(name = "primary_secondary")
	private String primarySecondary;

	@Column(name = "legal_parcel_id")
	private String legalParcelId;

}
