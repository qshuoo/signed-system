package com.qys.pojo;

public class Sign {
    private Integer sid;

    private String uname;

    private String stime;

    private Integer status;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime == null ? null : stime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "Sign [sid=" + sid + ", uname=" + uname + ", stime=" + stime + ", status=" + status + "]";
	}
    
    
}