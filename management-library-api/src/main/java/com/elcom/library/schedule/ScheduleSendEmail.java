package com.elcom.library.schedule;

import com.elcom.library.dto.BookBorrowed;
import com.elcom.library.repository.lib.BorrowedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

@Service
@EnableScheduling
public class ScheduleSendEmail {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private BorrowedRepository borrowedRepository;

    @Scheduled(cron = "0 0 7 * * *")
    public void sendMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("pqhuy27122000@gmail.com");
        message.setTo("pqhuy27122000@gmail.com");
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date date = new java.sql.Date(cal.getTimeInMillis());
        message.setSubject("Thống kê sách ngày " + new SimpleDateFormat("dd/MM/yyyy").format(date));

        StringBuilder text = new StringBuilder();
        for(BookBorrowed book : borrowedRepository.listBookBorrowedByTime(date, date)) {
            text.append(book.getName() + ": " + book.getNumber() + " cuốn\n");
        }
        message.setText(text.toString());
        emailSender.send(message);
    }
}
