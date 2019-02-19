package org.great.bean.vo;

public class NewRule {
	    int pam;
	    double start;
	    double over;
	    int startPrice;
	    int addPrice;
		public NewRule() {
			super();
		}
		public NewRule(int pam, double start, double over, int startPrice, int addPrice) {
			super();
			this.pam = pam;
			this.start = start;
			this.over = over;
			this.startPrice = startPrice;
			this.addPrice = addPrice;
		}
		@Override
		public String toString() {
			return "NewRule [pam=" + pam + ", start=" + start + ", over=" + over + ", startPrice=" + startPrice
					+ ", addPrice=" + addPrice + "]";
		}
		public int getPam() {
			return pam;
		}
		public void setPam(int pam) {
			this.pam = pam;
		}
		public double getStart() {
			return start;
		}
		public void setStart(double start) {
			this.start = start;
		}
		public double getOver() {
			return over;
		}
		public void setOver(double over) {
			this.over = over;
		}
		public int getStartPrice() {
			return startPrice;
		}
		public void setStartPrice(int startPrice) {
			this.startPrice = startPrice;
		}
		public int getAddPrice() {
			return addPrice;
		}
		public void setAddPrice(int addPrice) {
			this.addPrice = addPrice;
		}
	    
	    
}
