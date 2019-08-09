class AbstractClassInterfaceDemo {
    public static void main(String[] args) {
        //inst and examples
    }
    abstract class Stock {
        double amount, bought_price;
        MovingAmount<Double>[] moving_averages;
        void init(double amount, double bought_price) {
            this.amount = amount;
            this.bought_price = bought_price;
            this.moving_averages = new MovingAmount<Double>[3];
            this.moving_averages[0] = new MovingAverage<Double>(20, 0.0);
            this.moving_averages[1] = new MovingAverage<Double>(50, 0.0);
            this.moving_averages[2] = new MovingAverage<Double>(100, 0.0);
        } 
        double profitGained(double current_price) {
            return current_price / this.bought_price;
        }
        void updateMovingAverages(double closing_price) {
            for (MovingAverage<Double> average: moving_averages) {
                average.update(closing_price);
            }
        }
    }
    interface Tradeable {
        boolean isPublic();
        void buy(int amount, double bought_price, double capital_available) throws PurchaseException;
        void sell(int amount) throws PurchaseException;
    }
    //AMZN, MSFT, AAPL
    class AmazonStock extends Stock implements Tradeable {
        final String ticker = "AAPL";
        AmazonStock(double amount, double bought_price) {
            init(amount, bought_price);
        }
        boolean isPublic() {
            return true;
        }
        void buy(int amount, double bought_price, double capital_available) {
            if (amount * bought_price > capital_available)
                throw new PurchaseException(); // cannot buy
            this.bought_price *= (this.amount/(this.amount+amount));
            this.bought_price += (amount/(this.amount+amount)) * bought_price;
            this.amount += amount;
        }
        void sell(int amount) {//, double bought_price) {
            if (amount > this.amount) 
                throw new PurchaseException(); // pick an error
            this.amount -= amount;
            if (this.amount == 0) 
                this.bought_price = 0.0;
            //this.capital = bought_price * amount;
        }
    }
    private class PurchaseException extends Exception {}
    private class MovingAverage<T> {
        int n, current_n; // change name for clarity
        T average;
        public MovingAverage(int n, T starting_average) {
            this.n = n;
            this.current_n = 0;
            this.average = starting_average;
        }
        void update(T new_value) {
            if (this.current_n < this.n) {
                this.current_n++;
            } 
            if (this.current_n == 1) { //only the first 
                this.average = new_value;
            } else {
                this.average += (new_value - this.average) / (this.current_n); //+1?
            }
        }
    }
}
