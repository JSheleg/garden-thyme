create schema if not exists garden_thyme;

use garden_thyme;

create table if not exists grow_zone(
	zone_id int primary key,
	low_temp int not null,
    high_temp int not null
);

insert into grow_zone (zone_id, low_temp, high_temp) values ('1','-60','-50');
insert into grow_zone (zone_id, low_temp, high_temp) values ('2','-50','-40');
insert into grow_zone (zone_id, low_temp, high_temp) values ('3','-40','-30');
insert into grow_zone (zone_id, low_temp, high_temp) values ('4','-30','-20');
insert into grow_zone (zone_id, low_temp, high_temp) values ('5','-20','-10');
insert into grow_zone (zone_id, low_temp, high_temp) values ('6','-10','0');
insert into grow_zone (zone_id, low_temp, high_temp) values ('7','0','10');
insert into grow_zone (zone_id, low_temp, high_temp) values ('8','10','20');
insert into grow_zone (zone_id, low_temp, high_temp) values ('9','20','30');
insert into grow_zone (zone_id, low_temp, high_temp) values ('10','30','40');
insert into grow_zone (zone_id, low_temp, high_temp) values ('11','40','50');
insert into grow_zone (zone_id, low_temp, high_temp) values ('12','50','60');
insert into grow_zone (zone_id, low_temp, high_temp) values ('13','60','70');

select * from grow_zone
