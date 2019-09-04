package eu.solidcraft.c4diagrams;

import com.structurizr.Workspace;
import com.structurizr.model.Tags;
import com.structurizr.view.PaperSize;
import com.structurizr.view.Shape;
import com.structurizr.view.StaticView;
import com.structurizr.view.Styles;
import com.structurizr.view.ViewSet;

import java.util.function.Function;

class ViewCreator {
    static Workspace setupView(Workspace workspace, Function<ViewSet, StaticView> viewGenerator) {
        return setupView(workspace, viewGenerator, PaperSize.A4_Landscape);
    }

    static Workspace setupView(Workspace workspace, Function<ViewSet, StaticView> viewGenerator, PaperSize paperSize) {
        ViewSet views = workspace.getViews();
        StaticView contextView = viewGenerator.apply(views);
        contextView.setPaperSize(paperSize);
        contextView.addAllElements();
        setupStyles(views);
        return workspace;
    }

    private static void setupStyles(ViewSet views) {
        Styles styles = views.getConfiguration().getStyles();
        styles.addElementStyle(Tags.SOFTWARE_SYSTEM).background("#1168bd").color("#ffffff");
        styles.addElementStyle(Tags.PERSON).background("#08427b").color("#ffffff").shape(Shape.Person);
    }
}
