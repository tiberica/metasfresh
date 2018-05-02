package de.metas.shipper.gateway.derkurier.restapi.models;

import static de.metas.shipper.gateway.derkurier.DerKurierConstants.TIME_FORMAT;

import java.time.LocalTime;

import org.adempiere.util.Check;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Value;

/*
 * #%L
 * de.metas.shipper.gateway.derkurier
 * %%
 * Copyright (C) 2018 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

@Value
public class Participant
{
	String stationFormatted;
	String station;
	String country;
	String zipCode;
	String zone;
	String sector;
	String dayType;
	boolean island;
	int term;

	@JsonProperty("earliestTimeOfDelivery")
	@JsonFormat(shape = Shape.STRING, pattern = TIME_FORMAT)
	LocalTime earliestTimeOfDelivery;

	@JsonProperty("saturdayDeliveryUntil")
	@JsonFormat(shape = Shape.STRING, pattern = TIME_FORMAT)
	LocalTime saturdayDeliveryUntil;

	@JsonProperty("sundayDeliveryUntil")
	@JsonFormat(shape = Shape.STRING, pattern = TIME_FORMAT)
	LocalTime sundayDeliveryUntil;

	@JsonProperty("pickupUntil")
	@JsonFormat(shape = Shape.STRING, pattern = TIME_FORMAT)
	LocalTime pickupUntil;

	String partnerManager;

	@Builder
	@JsonCreator
	public Participant(
			@JsonProperty("stationFormatted") String stationFormatted,
			@JsonProperty("station") String station,
			@JsonProperty("country") String country,
			@JsonProperty("zipCode") String zipCode,
			@JsonProperty("zone") String zone,
			@JsonProperty("sector") String sector,
			@JsonProperty("dayType") String dayType,
			@JsonProperty("island") Boolean island,
			@JsonProperty("term") Integer term,
			LocalTime earliestTimeOfDelivery,
			LocalTime saturdayDeliveryUntil,
			LocalTime sundayDeliveryUntil,
			LocalTime pickupUntil,
			@JsonProperty("partnerManager") String partnerManager)
	{
		this.stationFormatted = stationFormatted;
		this.station = Check.assumeNotEmpty(station, "Parameter station may not be empty");
		this.country = Check.assumeNotEmpty(country, "Parameter country may not be empty");
		this.zipCode = Check.assumeNotEmpty(zipCode, "Parameter zipCode may not be empty");
		this.zone = Check.assumeNotEmpty(zone, "Parameter zone may not be empty");
		this.sector = Check.assumeNotEmpty(sector, "Parameter sector may not be empty");
		this.dayType = Check.assumeNotEmpty(dayType, "Parameter dayType may not be empty");
		this.island = Check.assumeNotNull(island, "Parameter island may not be null");
		this.term = Check.assumeNotNull(term, "Parameter term may not be null");
		this.earliestTimeOfDelivery = Check.assumeNotNull(earliestTimeOfDelivery, "Parameter earliestTimeOfDelivery may not be null");
		this.saturdayDeliveryUntil = Check.assumeNotNull(saturdayDeliveryUntil, "Parameter saturdayDeliveryUntil may not be null");
		this.sundayDeliveryUntil = Check.assumeNotNull(sundayDeliveryUntil, "Parameter sundayDeliveryUntil may not be null");
		this.pickupUntil = Check.assumeNotNull(pickupUntil, "Parameter pickupUntil may not be null");
		this.partnerManager = Check.assumeNotNull(partnerManager, "Parameter partnerManager may not be null"); // note: might be empty
	}
}
