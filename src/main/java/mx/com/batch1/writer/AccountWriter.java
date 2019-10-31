package mx.com.batch1.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import mx.com.batch1.model.Account;

public class AccountWriter implements ItemWriter<Account> {

	@Override
	public void write(List<? extends Account> items) throws Exception {
		items.forEach(System.out::println);
	}

}
