-- Length Units
INSERT IGNORE INTO units (name, type, base_value) VALUES ('KILOMETER','LENGTH',1000);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('METER','LENGTH',1);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('CENTIMETER','LENGTH',0.01);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('MILLIMETER','LENGTH',0.001);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('MILE','LENGTH',1609.34);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('YARD','LENGTH',0.9144);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('FEET','LENGTH',0.3048);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('INCH','LENGTH',0.0254);

-- Weight Units
INSERT IGNORE INTO units (name, type, base_value) VALUES ('KILOGRAM','WEIGHT',1000);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('GRAM','WEIGHT',1);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('MILLIGRAM','WEIGHT',0.001);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('POUND','WEIGHT',453.592);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('OUNCE','WEIGHT',28.3495);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('TON','WEIGHT',1000000);

-- Volume Units
INSERT IGNORE INTO units (name, type, base_value) VALUES ('LITER','VOLUME',1);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('MILLILITER','VOLUME',0.001);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('GALLON','VOLUME',3.785);

-- Temperature Units (base_value not used, formulas handled in service)
INSERT IGNORE INTO units (name, type, base_value) VALUES ('CELSIUS','TEMPERATURE',1);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('FAHRENHEIT','TEMPERATURE',1);
INSERT IGNORE INTO units (name, type, base_value) VALUES ('KELVIN','TEMPERATURE',1);
