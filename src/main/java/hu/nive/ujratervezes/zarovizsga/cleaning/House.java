package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {

    private String address;
    private int area;


    public House(String address, int place) {
        this.address = address;
        this.area = place;
    }

    @Override
    public int clean() {
        return area * 80;
    }

    @Override
    public String getAddress() {
        return address;
    }
}