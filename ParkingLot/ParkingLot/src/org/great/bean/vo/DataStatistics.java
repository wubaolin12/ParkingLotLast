package org.great.bean.vo;

public class DataStatistics {
	int allCome;
	int parkinbout;
	int monthUserInCome;
	int temporaryUserInCome;
	int temporaryUserInCome1;
	int temporaryUserInCome2;
	int temporaryUserInCome3;
	int temporaryUserInCome4;
	public DataStatistics() {
		super();
	}
	public DataStatistics(int allCome, int parkinbout, int monthUserInCome, int temporaryUserInCome,
			int temporaryUserInCome1, int temporaryUserInCome2, int temporaryUserInCome3, int temporaryUserInCome4) {
		super();
		this.allCome = allCome;
		this.parkinbout = parkinbout;
		this.monthUserInCome = monthUserInCome;
		this.temporaryUserInCome = temporaryUserInCome;
		this.temporaryUserInCome1 = temporaryUserInCome1;
		this.temporaryUserInCome2 = temporaryUserInCome2;
		this.temporaryUserInCome3 = temporaryUserInCome3;
		this.temporaryUserInCome4 = temporaryUserInCome4;
	}
	@Override
	public String toString() {
		return "DataStatistics [allCome=" + allCome + ", parkinbout=" + parkinbout + ", monthUserInCome="
				+ monthUserInCome + ", temporaryUserInCome=" + temporaryUserInCome + ", temporaryUserInCome1="
				+ temporaryUserInCome1 + ", temporaryUserInCome2=" + temporaryUserInCome2 + ", temporaryUserInCome3="
				+ temporaryUserInCome3 + ", temporaryUserInCome4=" + temporaryUserInCome4 + "]";
	}
	public int getAllCome() {
		return allCome;
	}
	public void setAllCome(int allCome) {
		this.allCome = allCome;
	}
	public int getParkinbout() {
		return parkinbout;
	}
	public void setParkinbout(int parkinbout) {
		this.parkinbout = parkinbout;
	}
	public int getMonthUserInCome() {
		return monthUserInCome;
	}
	public void setMonthUserInCome(int monthUserInCome) {
		this.monthUserInCome = monthUserInCome;
	}
	public int getTemporaryUserInCome() {
		return temporaryUserInCome;
	}
	public void setTemporaryUserInCome(int temporaryUserInCome) {
		this.temporaryUserInCome = temporaryUserInCome;
	}
	public int getTemporaryUserInCome1() {
		return temporaryUserInCome1;
	}
	public void setTemporaryUserInCome1(int temporaryUserInCome1) {
		this.temporaryUserInCome1 = temporaryUserInCome1;
	}
	public int getTemporaryUserInCome2() {
		return temporaryUserInCome2;
	}
	public void setTemporaryUserInCome2(int temporaryUserInCome2) {
		this.temporaryUserInCome2 = temporaryUserInCome2;
	}
	public int getTemporaryUserInCome3() {
		return temporaryUserInCome3;
	}
	public void setTemporaryUserInCome3(int temporaryUserInCome3) {
		this.temporaryUserInCome3 = temporaryUserInCome3;
	}
	public int getTemporaryUserInCome4() {
		return temporaryUserInCome4;
	}
	public void setTemporaryUserInCome4(int temporaryUserInCome4) {
		this.temporaryUserInCome4 = temporaryUserInCome4;
	}
	
}
