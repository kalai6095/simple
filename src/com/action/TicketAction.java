package com.action;

import com.model.PassengerDetails;
import com.model.Ticket;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class TicketAction extends ActionSupport {
    private Ticket ticket;
    private List<Ticket> ticketList;
    private List<PassengerDetails> passengerDetail;
    private int rowindex;

    public int getRowindex() {
        return rowindex;
    }

    public void setRowindex(int rowindex) {
        this.rowindex = rowindex;
    }

    private PassengerDetails passgr_Det;

    public PassengerDetails getPassgr_Det() {
        return passgr_Det;
    }

    public void setPassgr_Det(PassengerDetails passgr_Det) {
        this.passgr_Det = passgr_Det;
    }

    public List<PassengerDetails> getPassengerDetail() {
        return passengerDetail;
    }

    public void setPassengerDetail(List<PassengerDetails> passengerDetail) {
        this.passengerDetail = passengerDetail;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    // to add a first blank row

    public String execute() {
        ticket = new Ticket();
        List<PassengerDetails> pds = new ArrayList<>();
        passgr_Det = new PassengerDetails();
        passgr_Det.setSno((short) 1);
        passgr_Det.setName("");
        passgr_Det.setGender("");
        passgr_Det.setAge("");
        pds.add(passgr_Det);
        ticket.setPassengerDetail(pds);
        ticket.setBusNo("7261");

        return SUCCESS;
    }

    public String delete() {

        try {
            ticket = getTicket();
            passengerDetail = ticket.getPassengerDetail();
            //passengerDetail.remove(getId());

            short sno = 1;
            for (PassengerDetails p : passengerDetail)
                p.setSno(sno++);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return SUCCESS;
    }

    public String ticketBook() {
        try {
            ticket = getTicket();
            double totalFare = 0.0;
            ticket.setBookedOn(new java.util.Date()); // for current date to store on createdOn field.
            passengerDetail = ticket.getPassengerDetail();

            System.out.println("S.No Name Gender Age");

//For printing the passengers
            for (PassengerDetails p : passengerDetail) {
                System.out.print(p.getSno());
                System.out.print(p.getName());
                System.out.print(p.getGender());
                System.out.println(p.getAge());

            }

            totalFare = ticket.getFare() * passengerDetail.size();
            ticket.setTotalFare(totalFare);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Ticket getModel() {
        return ticket;
    }


}
