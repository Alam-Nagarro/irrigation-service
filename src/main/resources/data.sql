insert into crop(crop_id, name, cultivation_period_days, irrigation_gap_days)
values(1001, 'WHEAT', 120, 30);

insert into plot(plot_id, name, area_sqrmtr, cultivation_start_date, crop_id)
values(2001, 'PLOT1', 400, current_date(), 1001);

insert into slot(slot_id, name, start_time, end_time, water_amount_ltr, irrigation_status, plot_id)
values(3001, 'SLOT1', current_date(), current_date(), 4000, 'CREATED', 2001);
