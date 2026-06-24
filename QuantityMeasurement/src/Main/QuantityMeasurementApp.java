package Main;
import Main.util.DatabaseInitializer;
import Main.controller.QuantityMeasurementController;
import Main.dto.QuantityDTO;

import Main.repository.IQuantityMeasurementRepository;
import Main.repository.QuantityMeasurementDatabaseRepository;
import Main.service.IQuantityMeasurementService;
import Main.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        //  Initialize DB
        DatabaseInitializer.init();

        IQuantityMeasurementRepository repo =
                new QuantityMeasurementDatabaseRepository();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repo);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        controller.performComparison(
                new QuantityDTO(1, "FEET", "LENGTH"),
                new QuantityDTO(12, "INCHES", "LENGTH")
        );
    }
}