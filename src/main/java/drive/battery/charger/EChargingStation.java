package drive.battery.charger;

public class EChargingStation implements I1PoleConnector {
    private final int chargingSpeed;
    private final ChargingPole chargingPole;
    private I1PoleConnector connector;

    public EChargingStation(int chargingSpeed) {
        this.chargingSpeed = chargingSpeed;
        chargingPole = new ChargingPole();
    }

    public int getChargingSpeed() {
        return chargingSpeed;
    }

    @Override
    public void plugIn(I1PoleConnector onePoleConnector) {
        if (connector == null) {
            connector = onePoleConnector;
            chargingPole.connect(connector);
        }
    }

    @Override
    public void plugOut() {
        connector = null;
        chargingPole.connect(null);
    }

    @Override
    public void pushEnergy(int amount) {
        chargingPole.pushCharge(Math.min(chargingSpeed, amount));
    }

    public void pushEnergy() {
        chargingPole.pushCharge(chargingSpeed);
    }
}
