package banking;

import java.util.Set;

public class Customer {

  private Set<BankAccount> bankAccounts;

  public void updateAddresses(Address address) {
    for (BankAccount bankAccount : bankAccounts) {
      //
      bankAccount.setAddress(address);
    }
    System.out.println("Addresses updated successfully!");
  }
}
