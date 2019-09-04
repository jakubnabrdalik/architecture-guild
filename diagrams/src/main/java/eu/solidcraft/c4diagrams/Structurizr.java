package eu.solidcraft.c4diagrams;

import com.structurizr.Workspace;
import com.structurizr.api.StructurizrClient;
import com.structurizr.model.Model;
import com.structurizr.model.SoftwareSystem;

import java.io.InputStream;
import java.util.Properties;

import static java.lang.Long.parseLong;

public class Structurizr {

    public static void main(String[] args) throws Exception {
        createWorkspace();
    }

    private static void createWorkspace() throws Exception {
        Workspace workspace = new Workspace("Main workspace", "Main workspace");
        Model model = workspace.getModel();
        SoftwareSystem carShare = model.addSoftwareSystem("Car sharing system", "Car sharing system");
        ExternalSystems externalSystems = CarShareContextDiagram.create(workspace, model, carShare);
        InternalContainers internalContainers = CarShareContainersDiagram.create(workspace, carShare, externalSystems);
        CarShareComponents.create(workspace, internalContainers, externalSystems);
        uploadWorkspaceToStructurizr(workspace);
    }

    private static void uploadWorkspaceToStructurizr(Workspace workspace) throws Exception {
        try(InputStream inputStream = Structurizr.class.getClassLoader()
                .getResourceAsStream("secret.properties")) {
            Properties prop = new Properties();
            prop.load(inputStream);
            long workspaceId = parseLong(prop.getProperty("workspace.id"));
            String apiKey = prop.getProperty("api.key");
            String apiSecret = prop.getProperty("api.secret");
            StructurizrClient structurizrClient = new StructurizrClient(apiKey, apiSecret);
            structurizrClient.putWorkspace(workspaceId, workspace);
        }
    }

}

