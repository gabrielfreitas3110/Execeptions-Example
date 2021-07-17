/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gabriel Augusto
 */
public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
    
    public long duration() {
        long diference = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diference,TimeUnit.MILLISECONDS);
    }
    
    public String updateDates(Date checkIn, Date checkOut) { 
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)) {
            return "Reservation dates for update must be future dates";
        }
        if(!checkOut.after(checkIn)) {
         return " Check-out date must be after check-in date";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + ", check-in: " 
                + sdf.format(checkIn) + ", check-out: " 
                + sdf.format(checkOut) + ", duration: " 
                + duration() + " nights";
    }
}
