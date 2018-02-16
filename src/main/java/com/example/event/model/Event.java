package com.example.event.model;

import com.example.event.utils.EventDateTimeUtils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
public class Event {
    private static long numEvent =1000000L;

    @Id
    @Column
    private long id;

    @Column
    private String ssoID;

    @Column
    private String grp;
    @Column
    private String type;
    @Column
    private String subtype;
    @Column
    private String url;
    @Column
    private String orgID;
    @Column
    private String formID;
    @Column
    private String code;
    @Column
    private String ltpa;
    @Column
    private String sUDirResponce;

    @Column
    private LocalDateTime datetime;

    public Event(String ssoID, String grp,
                 String type, String subtype, String url, String orgID,
                 String formID, String code, String ltpa, String sUDirResponce, LocalDateTime datetime) {
        this.id = numEvent++;
        this.ssoID = ssoID;
        this.grp = grp;
        this.type = type;
        this.subtype = subtype;
        this.url = url;
        this.orgID = orgID;
        this.formID = formID;
        this.code = code;
        this.ltpa = ltpa;
        this.sUDirResponce = sUDirResponce;
        this.datetime = datetime;
    }
    public Event(){
        this.id = numEvent++;
    }
    public Event(String array[]){
        if (array.length != 12) {new Event();}
        else {
            this.id = numEvent++;
            this.ssoID = array[0];
            this.grp = array[2];
            this.type = array[3];
            this.subtype = array[4];
            this.url = array[5];
            this.orgID = array[6];
            this.formID = array[7];
            this.code = array[8];
            this.ltpa = array[9];
            this.sUDirResponce = array[10];
            this.datetime = EventDateTimeUtils.getLdtFromYmdhTs(array[1],array[11]);
        }
    }




    public static void main(String[] args) {/*
        System.out.println(new Event("aaa",new Timestamp(1111l),"aaa","aaa","aaa","aaa",
                "aaa","aaa","aaa","aaa","aaa","aaa"));*/
    }

    public String getSsoID() {
        return ssoID;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getFormID() {
        return formID;
    }
}