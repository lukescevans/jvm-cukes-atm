package support.model;

/**
 * Created by luke.evans on 13/07/15.
 */
public class TransactionHistoryModel {
        private AtmModel.transactionType transType;
        public int amount;

        public AtmModel.transactionType getTransType() {
                return transType;
        }

        public void setTransType(AtmModel.transactionType transType) {
                this.transType = transType;
        }
}