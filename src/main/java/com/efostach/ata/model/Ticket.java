package com.efostach.ata.model;

public class Ticket {
    private Integer ticketNumber;
    private String firstName;
    private String lastName;
    private Integer flightId;
    private Integer seatNumber;
    private SeatClass seatClass;
    private TicketStatus status;
    private Integer price;

    private Ticket() {
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(ticketNumber).append(",")
                .append(firstName).append(",")
                .append(lastName).append(",")
                .append(seatNumber).append(",")
                .append(flightId).append(",")
                .append(seatClass).append(",")
                .append(status).append(",")
                .append(price)
                .append("\n").toString();
    }

    public static Builder newBuilder() {
        return new Ticket().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setTicketNumber(Integer ticketNumber) {
            Ticket.this.ticketNumber = ticketNumber;

            return this;
        }

        public Builder setFirstName(String firstName) {
            Ticket.this.firstName = firstName;

            return this;
        }

        public Builder setLastName(String lastName) {
            Ticket.this.lastName = lastName;

            return this;
        }

        public Builder setFlightId(Integer flightId) {
            Ticket.this.flightId = flightId;

            return this;
        }

        public Builder setSeatNumber(Integer seatNumber) {
            Ticket.this.seatNumber = seatNumber;

            return this;
        }

        public Builder setSeatClass(SeatClass seatClass) {
            Ticket.this.seatClass = seatClass;

            return this;
        }

        public Builder setStatus(TicketStatus status) {
            Ticket.this.status = status;

            return this;
        }

        public Builder setPrice(Integer price) {
            Ticket.this.price = price;

            return this;
        }

        public Ticket build() {
            return Ticket.this;
        }
    }
}
