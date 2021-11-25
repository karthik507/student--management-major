CREATE TABLE user_info
  (
     user_id    INTEGER NOT NULL auto_increment,
     age        INTEGER,
     contact    BIGINT,
     email      VARCHAR(255),
     first_name VARCHAR(255),
     is_active  BIT,
     last_name  VARCHAR(255),
     password   VARCHAR(255),
     PRIMARY KEY (user_id)
  );
  
  
  