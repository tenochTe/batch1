package mx.com.batch1.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import mx.com.batch1.model.Account;

public class AccountMapper implements FieldSetMapper<Account> {

	@Override
	public Account mapFieldSet(FieldSet fieldSet) throws BindException {
		
		return new Account.Builder( fieldSet.readString("CUSTOMER") )
						  .withAccount( fieldSet.readString("ACCOUNT") )
						  .isActive( fieldSet.readString("IS_ACTIVE") )
						  .build();
	}

}
