public class Guest {

    private String name;
    private int money;

    public Guest(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void payMoney(Integer price){
        this.money = this.money - price;
    }

}
