package patterns.in.use.task3;

/**
 * Created by eugene on 10.08.17.
 */
public class TourApp {
    public static void main(String[] args) {
        Tour tour = new TourBuilder()
                .includeFlyThere()
                .includeFlyBlack()
                .includeTransferToAirport()
                .includeTransferFromAirport()
                .includeHotelReservation()
                .includeInsurance()
                .build();
        System.out.println(tour);
    }
}
class Tour{
    private boolean transferToAirport;
    private boolean transferFromAirport;
    private boolean flyThere;
    private boolean flyBack;
    private boolean hotelReservation;
    private boolean insurance;

    public void setTransferToAirport(boolean transferToAirport) {
        this.transferToAirport = transferToAirport;
    }

    public void setTransferFromAirport(boolean transferFromAirport) {
        this.transferFromAirport = transferFromAirport;
    }

    public void setFlyThere(boolean flyThere) {
        this.flyThere = flyThere;
    }

    public void setFlyBack(boolean flyBack) {
        this.flyBack = flyBack;
    }

    public void setHotelReservation(boolean hotelReservation) {
        this.hotelReservation = hotelReservation;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "transferToAirport=" + transferToAirport +
                ", transferFromAirport=" + transferFromAirport +
                ", flyThere=" + flyThere +
                ", flyBack=" + flyBack +
                ", hotelReservation=" + hotelReservation +
                ", insurance=" + insurance +
                '}';
    }
}
class TourBuilder{
    private boolean transferToAirport = false;
    private boolean transferFromAirport = false;
    private boolean flyThere = false;
    private boolean flyBack = false;
    private boolean hotelReservation=false;
    private boolean insurance=false;

    TourBuilder includeTransferToAirport(){
        transferToAirport = true;
        return this;
    }
    TourBuilder includeTransferFromAirport(){
        transferToAirport = true;
        return this;
    }
    TourBuilder includeFlyThere(){
        flyThere = true;
        return this;
    }
    TourBuilder includeFlyBlack(){
        flyBack = true;
        return this;
    }
    TourBuilder includeHotelReservation(){
        hotelReservation = true;
        return this;
    }
    TourBuilder includeInsurance(){
        insurance = true;
        return this;
    }
    Tour build(){
        Tour tour = new Tour();
        tour.setFlyBack(flyBack);
        tour.setFlyThere(flyThere);
        tour.setTransferToAirport(transferToAirport);
        tour.setTransferFromAirport(transferFromAirport);
        tour.setHotelReservation(hotelReservation);

        return tour;
    }
}