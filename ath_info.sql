CREATE DATABASE ath_info;

USE ath_info;

DROP TABLE IF EXISTS `male_info`;

CREATE TABLE `male_info`
(
	'Place' Integer,
	'FirstName' char(12),
	'LastName' char(12).
	'Number' Integer,
	'RunTime' char(12),
	'RunSpeed' char(12),
	'BikeTime' char(12),
	'BikeSpeed' char(12),
	'SwimTime' char(12),
	'SwimSpeed' char(12),
	'TotalTime' char(12),
	'Gender' char(8)
}

DROP TABLE IF EXISTS 'female_info';
CREATE TABLE `female_info`
(
	'Place' Integer,
	'FirstName' char(12),
	'LastName' char(12).
	'Number' Integer,
	'RunTime' char(12),
	'RunSpeed' char(12),
	'BikeTime' char(12),
	'BikeSpeed' char(12),
	'SwimTime' char(12),
	'SwimSpeed' char(12),
	'TotalTime' char(12),
	'Gender' char(8)
}
