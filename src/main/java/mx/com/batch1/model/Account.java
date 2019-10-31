package mx.com.batch1.model;

public class Account {
	
	private String customer;
	private String account;
	private String isActive;
	
	private Account() {
		
	}
	
	public static class Builder {
		
		private String customer;
		private String account;
		private String isActive;
		
		public Builder(String customer) {
			this.customer=customer;
		}
		
		public Builder withAccount(String account) {
			this.account=account;
			return this;
		}
		
		public Builder isActive(String isActive) {
			this.isActive=isActive;
			return this;
		}
		
		public Account build() {
			Account account =new Account();
				account.account = this.account;
				account.customer = this.customer;
				account.isActive = this.isActive;
			return account;
		}
		
	}
		
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(this.customer)
				.append("|")
				.append(this.account)
				.append("|")
				.append(this.isActive)
				.toString();
	}

}
