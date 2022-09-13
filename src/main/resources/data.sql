insert into crop(crop_id, name, cultivation_period_days, irrigation_gap_days)
values(1001, 'WHEAT', 120, 30);

insert into plot(plot_id, name, area_sqrmtr, cultivation_start_date, crop_id)
values(2001, 'PLOT1', 400, '2022-09-01T00:00:00', 1001);

insert into slot(slot_id, name, start_time, end_time, water_amount_ltr, irrigation_status, plot_id)
values(3001, 'SLOT1', '2022-09-01T00:00:00', '2022-09-02T00:00:00', 4000, 'COMPLETED', 2001);

insert into slot(slot_id, name, start_time, end_time, water_amount_ltr, irrigation_status, plot_id)
values(3002, 'SLOT2', '2022-10-01T00:00:00', '2022-10-01T00:00:00', 4000, 'CREATED', 2001);

insert into slot(slot_id, name, start_time, end_time, water_amount_ltr, irrigation_status, plot_id)
values(3003, 'SLOT3', '2022-11-01T00:00:00', '2022-11-01T00:00:00', 4000, 'CREATED', 2001);

insert into slot(slot_id, name, start_time, end_time, water_amount_ltr, irrigation_status, plot_id)
values(3004, 'SLOT4', '2022-12-01T00:00:00', '2022-12-01T00:00:00', 4000, 'CREATED', 2001);

insert into crop(crop_id, name, cultivation_period_days, irrigation_gap_days)
values(1002, 'PADDY', 120, 30);

insert into plot(plot_id, name, area_sqrmtr, cultivation_start_date, crop_id)
values(2002, 'PLOT2', 900, '2022-09-01T00:00:00', 1002);

insert into slot(slot_id, name, start_time, end_time, water_amount_ltr, irrigation_status, plot_id)
values(3005, 'SLOT5', '2022-09-01T00:00:00', '2022-09-02T00:00:00', 9000, 'COMPLETED', 2002);

insert into slot(slot_id, name, start_time, end_time, water_amount_ltr, irrigation_status, plot_id)
values(3006, 'SLOT6', '2022-10-01T00:00:00', '2022-10-01T00:00:00', 9000, 'CREATED', 2002);

insert into slot(slot_id, name, start_time, end_time, water_amount_ltr, irrigation_status, plot_id)
values(3007, 'SLOT7', '2022-11-01T00:00:00', '2022-11-01T00:00:00', 9000, 'CREATED', 2002);

insert into slot(slot_id, name, start_time, end_time, water_amount_ltr, irrigation_status, plot_id)
values(3008, 'SLOT8', '2022-12-01T00:00:00', '2022-12-01T00:00:00', 9000, 'CREATED', 2002);