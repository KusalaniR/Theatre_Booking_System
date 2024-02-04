public class Ticket {

    private final int row;

    private final int seat;
    private final double price;

    public Person object1;


    public Ticket(int row, int seat, double price, Person object1) {


        this.row = row;
        this.seat = seat;
        this.object1 = object1;
        this.price = price;
    }

    public void print() {


        System.out.print("\nPerson name: " + object1.name);
        System.out.print("\nPerson surname: " + object1.surname);
        System.out.print("\nPerson email: " + object1.email);
        System.out.print("\nPerson row_no: " + row);
        System.out.print("\nPerson seat_no: " + seat);
        System.out.print("\nPrice: " + price);
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

}
