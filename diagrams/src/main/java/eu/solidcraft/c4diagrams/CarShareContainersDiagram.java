package eu.solidcraft.c4diagrams;

import com.structurizr.Workspace;
import com.structurizr.model.Container;
import com.structurizr.model.InteractionStyle;
import com.structurizr.model.SoftwareSystem;
import com.structurizr.view.StaticView;
import com.structurizr.view.ViewSet;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

import static eu.solidcraft.c4diagrams.Protocols.WEBSOCET;
import static eu.solidcraft.c4diagrams.ViewCreator.setupView;
import static lombok.AccessLevel.PRIVATE;

class CarShareContainersDiagram {
    static InternalContainers create(Workspace workspace, SoftwareSystem carShareSystem, ExternalSystems externalSystems) {
        InternalContainers internalContainers = new InternalContainers(carShareSystem);
        internalContainers.createUsages(externalSystems);
        setupContainerView(workspace, carShareSystem);
        return internalContainers;
    }

    private static void setupContainerView(Workspace workspace, SoftwareSystem eMobility) {
        Function<ViewSet, StaticView> containerViewCreator = views ->
                views.createContainerView(eMobility,
                        "car share containers",
                        "car share container view");
        setupView(workspace, containerViewCreator);
    }
}

@Getter
@FieldDefaults(makeFinal = true, level = PRIVATE)
class InternalContainers {
    Container bigMonilithicApplication;

    InternalContainers(SoftwareSystem eMobility) {
        bigMonilithicApplication = eMobility.addContainer("Some container to be defined", "With lots of modules inside", "JAVA");
    }

    void createUsages(ExternalSystems externalSystems) {
        externalSystems.getCarsGpsGateway().uses(bigMonilithicApplication, "sends cars gps position", WEBSOCET, InteractionStyle.Asynchronous);
    }
}
