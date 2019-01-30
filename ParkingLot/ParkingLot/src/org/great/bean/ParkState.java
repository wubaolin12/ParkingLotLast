package org.great.bean;
/*
 * 宏琪大哥
 * 车位实时状态类
 */
public class ParkState {
	private String p_fore ;//车区号
	private int emptyCount_open;//空车位 开放 数
	private int occupiedCount;//已占用 数
	private int emptyCount_close;//空车位 维护 数
	public ParkState() {
		super();
	}
	
	public ParkState(String p_fore, int emptyCount_open, int occupiedCount, int emptyCount_close) {
		super();
		this.p_fore = p_fore;
		this.emptyCount_open = emptyCount_open;
		this.occupiedCount = occupiedCount;
		this.emptyCount_close = emptyCount_close;
	}

	public String getP_fore() {
		return p_fore;
	}
	public void setP_fore(String p_fore) {
		this.p_fore = p_fore;
	}
	public int getEmptyCount_open() {
		return emptyCount_open;
	}
	public void setEmptyCount_open(int emptyCount_open) {
		this.emptyCount_open = emptyCount_open;
	}
	public int getOccupiedCount() {
		return occupiedCount;
	}
	public void setOccupiedCount(int occupiedCount) {
		this.occupiedCount = occupiedCount;
	}
	public int getEmptyCount_close() {
		return emptyCount_close;
	}
	public void setEmptyCount_close(int emptyCount_close) {
		this.emptyCount_close = emptyCount_close;
	}
	@Override
	public String toString() {
		return "ParkState [p_fore=" + p_fore + ", emptyCount_open=" + emptyCount_open + ", occupiedCount="
				+ occupiedCount + ", emptyCount_close=" + emptyCount_close + "]";
	}
	

}
