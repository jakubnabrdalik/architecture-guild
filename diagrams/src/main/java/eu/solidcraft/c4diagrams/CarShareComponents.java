package eu.solidcraft.c4diagrams;

import com.structurizr.Workspace;
import com.structurizr.model.Component;
import com.structurizr.model.Container;
import com.structurizr.model.InteractionStyle;
import com.structurizr.view.PaperSize;
import com.structurizr.view.StaticView;
import com.structurizr.view.ViewSet;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

import static eu.solidcraft.c4diagrams.Protocols.WEBSOCET;
import static eu.solidcraft.c4diagrams.ViewCreator.setupView;

class CarShareComponents {
    static SampleCarShareModules create(Workspace workspace, InternalContainers internalContainers, ExternalSystems externalSystems) {
        SampleCarShareModules sampleCarShareModules = new SampleCarShareModules(internalContainers.getBigMonilithicApplication());
        sampleCarShareModules.createUsages(internalContainers, externalSystems);
        setupComponentView(workspace, internalContainers.getBigMonilithicApplication());
        return sampleCarShareModules;
    }

    private static void setupComponentView(Workspace workspace, Container oldBackend) {
        Function<ViewSet, StaticView> componentViewCreator = views ->
                views.createComponentView(oldBackend,
                        "Car sharing monolith components",
                        "Car sharing monolith components");
        setupView(workspace, componentViewCreator, PaperSize.A2_Landscape);
    }
}

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class SampleCarShareModules {
    ExternalSystemsInteractor externalSystemsInteractor = new ExternalSystemsInteractor();
    InternalModulesInteractor internalModulesInteractor = new InternalModulesInteractor();
    Component sampleComponent1;
    Component sampleComponent2;

    SampleCarShareModules(Container carSharing) {
        sampleComponent1 = carSharing.addComponent("Sample component 1", "Sample component 1");
        sampleComponent2 = carSharing.addComponent("Sample component 2", "Sample component 2");
    }

    void createUsages(InternalContainers internalContainers, ExternalSystems externalSystems) {
        externalSystemsInteractor.createCallsFromExternalSystems(internalContainers, externalSystems);
        internalModulesInteractor.createCallsFromInternalModules(internalContainers.getBigMonilithicApplication());
    }

    private class InternalModulesInteractor {
        private void createCallsFromInternalModules(Container bigApp) {
            sampleComponent1.uses(sampleComponent2, "a direct rest call", Protocols.REST, InteractionStyle.Synchronous);
        }
    }

    private class ExternalSystemsInteractor {
        private void createCallsFromExternalSystems(InternalContainers internalContainers, ExternalSystems externalSystems) {
            externalSystems.getCarsGpsGateway().uses(sampleComponent1, "sends cars gps position", WEBSOCET, InteractionStyle.Asynchronous);
        }
    }
}