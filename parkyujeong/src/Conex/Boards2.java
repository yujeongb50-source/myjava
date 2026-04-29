package Conex;

import java.sql.Blob;
import java.sql.Date;

public class Boards2 {

    private Integer bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private String date;
    private String bfilename;
    private Blob bfiledata;
    private String bdate2;

    
    public void setBno(Integer bno) {
        this.bno = bno;
    }
    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }
    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }
    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }
    public void setBdate(Date date2) {
        this.date = bdate2;
    }
    public void setBfilename(String bfilename) {
        this.bfilename = bfilename;
    }
    public void setBfiledata(Blob blob) {
        this.bfiledata = blob;
    }
    public Integer getBno() {
        return bno;
    }
    public String getBtitle() {
        return btitle;
    }
    public String getBcontent() {
        return bcontent;
    }
    public String getBwriter() {
        return bwriter;
    }
    public String getBdate() {
        return date;
    }
    public String getBfilename() {
        return bfilename;
    }
    public Blob getBfiledata() {
        return bfiledata;
    }
    @Override
    public String toString() {
        return "Boards2 [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
                + ", Bdate=" + date + ", bfilename=" + bfilename + ", Bfiledata=" + bfiledata + "]";
    }


    

    

    
}