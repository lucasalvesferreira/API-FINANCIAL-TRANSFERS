INSERT INTO account(agency,bank_name, account, balance,owner) VALUES
        ('0001','Nubank','123456',2000,'lucas'),
        ('0001','C6','654321',10000,'Diego'),
        ('0001','Inter','123123',100,'Maria');


INSERT INTO scheduling
        (id, appointment_date, rate, source_account, target_account, transfer_date, transfer_value) VALUES
        (default,'2023-01-20', 3.40, '123456', '654321', '2023-06-05', 200.0),
        (default,'2023-01-20', 33.0, '123456', '123123', '2023-01-20', 1000.0),
        (default,'2023-02-20', 23.50, '123123', '654321', '2023-02-20', 500.0);