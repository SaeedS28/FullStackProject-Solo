SELECT 'drop table ', table_name, 'cascade constraints;' from user_tables;
Begin
  for c in (select table_name from user_tables) loop
    execute immediate ('drop table '||c.table_name||' cascade constraints');
  end loop;
  for s in (select sequence_name from user_sequences) loop
    execute immediate ('drop sequence '||s.sequence_name);
  end loop;
End;

-- users entered
create table users(
  email_address varchar2(50),
  password varchar2(65) not null,
  first_name varchar2(20) not null,
  last_name varchar2(20) not null,
  types varchar2(10) not null,
  primary key(email_address),
  constraint ck_types check (types in ('regular', 'admin'))
);

insert into users(email_address, password,first_name,last_name, types)
values ('saeeds28','password','Saad', 'Saeed', 'admin');

insert into users(email_address, password,first_name,last_name, types)
values ('samad','password','Samad', 'Saeed', 'regular');
-- addresses associated with users
create table address(
  email_address varchar2(50),
  street varchar2(65) not null,
  city varchar2(30) not null,
  province varchar2(20) not null,
  country varchar2(25) not null,
  postal_code varchar2(8) not null,
  primary key(email_address),
  
CONSTRAINT fk_email
  FOREIGN KEY (email_address)
  REFERENCES users(email_address) on delete cascade
);

-- create item table
create table item (
  product_id Number(6),
  name varchar2(50) not null,
  price number(6,2) not null,
  category varchar2(30) not null,
  quantity Number(4),
  description varchar(300) not null,
  primary key (product_id),
  
  constraint ck_quantity check (quantity >= 0),
  constraint ck_price check (price >= 0)
);

-- create shopping_cart table
create table shopping_cart (
  email_address varchar2(50),
  product_id Number(6),
  quantity Number(4) not null,
  primary key (email_address,product_id),
  
  CONSTRAINT fk_email_sc
  FOREIGN KEY (email_address)
  REFERENCES users(email_address) on delete cascade,
  
  CONSTRAINT fk_pid_sc
  FOREIGN KEY (product_id)
  REFERENCES item(product_id) on delete cascade
);

-- create purchase_history
create table purchase_history (
  purchase_id Number(6),
  purchase_date TIMESTAMP not null,
  email_address varchar2(50),
  product_id Number(6) NOT NULL,
  quantity Number(4) not null,
  price_per_unit number(6,2),
  primary key (purchase_id)
);

-- create review table
create table review(
    review_id Number(3),
    product_id Number(4) NOT NULL,
    email_address varchar2(50) NOT NULL,
    review_text varchar2(500) NOT NULL,
    rating Number(2) NOT NULL,    
    review_date TIMESTAMP not null,
    PRIMARY KEY (review_id),
    
    CONSTRAINT fk_email_review
    FOREIGN KEY (email_address)
    REFERENCES users(email_address) on delete cascade,
    
    CONSTRAINT fk_product_review
    FOREIGN KEY (product_id)
    REFERENCES item(product_id) on delete cascade
);

commit;