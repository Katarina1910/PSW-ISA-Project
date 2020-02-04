package com.softwareComedians.ClinicalCenterApp.model;

import javax.persistence.*;
import java.util.Stack;

@Entity
public class RoomTerms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    Stack<String> stack;

    @Column
    String date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Room room;

    public RoomTerms() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stack<String> getStack() {
        return stack;
    }

    public void setStack(Stack<String> stack) {
        this.stack = stack;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
