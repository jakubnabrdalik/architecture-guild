package eu.solidcraft.c4diagrams;

import com.structurizr.Workspace;
import com.structurizr.model.InteractionStyle;
import com.structurizr.model.Model;
import com.structurizr.model.Person;
import com.structurizr.model.SoftwareSystem;
import com.structurizr.view.PaperSize;
import com.structurizr.view.StaticView;
import com.structurizr.view.ViewSet;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

import static eu.solidcraft.c4diagrams.ViewCreator.setupView;
import static lombok.AccessLevel.PRIVATE;

class CarShareContextDiagram {
    static ExternalSystems create(Workspace workspace, Model model, SoftwareSystem carShare) {
        ExternalSystems externalSystems = new ExternalSystems(model);
        externalSystems.createUsages(carShare);
        setupContextView(workspace, carShare);
        return externalSystems;
    }

    private static void setupContextView(Workspace workspace, SoftwareSystem eMobility) {
        Function<ViewSet, StaticView> contextViewCrator = views ->
                views.createSystemContextView(
                        eMobility,
                        "context diagram",
                        "context view");
        ViewCreator.setupView(workspace, contextViewCrator, PaperSize.A5_Landscape);
    }

}

@Getter
@FieldDefaults(makeFinal = true, level = PRIVATE)
class ExternalSystems {
    SoftwareSystem carsGpsGateway;
    Person carSeekingUser;


    ExternalSystems(Model model) {
        carsGpsGateway = model.addSoftwareSystem("Cars GPS gateway", "Gateway sending GPS location of cars");
        carSeekingUser = model.addPerson("Car seeking user", "A user that needs a ride");
    }

    SoftwareSystem createUsages(SoftwareSystem carShare) {
        carsGpsGateway.uses(carShare, "send gps location", Protocols.WEBSOCET, InteractionStyle.Asynchronous);
        return carShare;
    }

}
