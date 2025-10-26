package p2043

class Bank(val balance: LongArray) {

    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        val accountId1 = account1 - 1
        val accountId2 = account2 - 1
        if (!isValidAccountId(accountId1) || !isValidAccountId(accountId2)) {
            return false
        }
        if (withdraw(account1, money)) {
            deposit(account2, money)
            return true
        }
        return false
    }

    fun deposit(account: Int, money: Long): Boolean {
        val accountId = account - 1
        if (!isValidAccountId(accountId)) {
            return false
        }
        balance[accountId] += money
        return true
    }

    fun withdraw(account: Int, money: Long): Boolean {
        val accountId = account - 1
        if (!isValidAccountId(accountId)) {
            return false
        }
        if (balance[accountId] < money) {
            return false
        }
        balance[accountId] -= money
        return true
    }

    fun isValidAccountId(accountId: Int): Boolean {
        return 0 <= accountId && accountId < balance.size
    }
}
