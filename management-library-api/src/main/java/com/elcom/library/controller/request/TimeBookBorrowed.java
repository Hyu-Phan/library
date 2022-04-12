package com.elcom.library.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class TimeBookBorrowed {
    private Date start;
    private Date end;
}
