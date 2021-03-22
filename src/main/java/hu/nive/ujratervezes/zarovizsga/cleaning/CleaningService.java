package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    void add(Cleanable cleanable){
        cleanables.add(cleanable);
    }

    public int cleanAll(){
        int counter= 0;
        counter = getAllPrice(counter);
        cleanables.clear();
        return counter;
    }

    private int getAllPrice(int counter) {
        for (Cleanable cleanable : cleanables) {
            counter += cleanable.clean();
        }
        return counter;
    }

    public int cleanOnlyOffices(){
        int counter = 0;
        List<Cleanable> house = new ArrayList<>(cleanables);
        for (Cleanable property : cleanables) {
            if(property instanceof Office){
                counter +=property.clean();
            } else{

                house.remove(property);
            }

        }

        cleanables.retainAll(house);
        return counter;
    }

    public List<Cleanable> findByAddressPart(String address){
        List<Cleanable> cleanableList = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if(cleanable.getAddress().contains(address)){
                cleanableList.add(cleanable);
            }
        }
        return cleanableList;
    }

    public String getAddresses(){
        StringBuilder sb = new StringBuilder();
        for (Cleanable cleanable : cleanables)
        {
            sb.append(cleanable.getAddress()).append(", ");
        }
        return sb.deleteCharAt(sb.length()).deleteCharAt(sb.length()).toString();
    }



    public List<Cleanable> getCleanables() {

        return new ArrayList<>(cleanables);
    }
}
