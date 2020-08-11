package com.packagename.myapp.ui;

import com.packagename.myapp.ui.nav.AboutView;
import com.packagename.myapp.ui.nav.ContactView;
import com.packagename.myapp.ui.nav.HomeView;
import com.packagename.myapp.ui.nav.MorehView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.*;
import org.junit.rules.ExternalResource;

@CssImport("./styles/shared-styles.css")
public class MainView extends AppLayout {

    /**

     */

    public MainView() {

        //nav bar side icon
        H1 logo = new H1("Pet");
        logo.addClassName("logo");

        //nav bar item layout
        HorizontalLayout header = new HorizontalLayout( logo);
        header.setDefaultVerticalComponentAlignment(
                FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.setHeight("40px");
        header.addClassName("header");

        //make link for route
        RouterLink home = new RouterLink("Home", HomeView.class);
        RouterLink about = new RouterLink("About", AboutView.class);
        RouterLink contact = new RouterLink("Contact", ContactView.class);
        RouterLink more = new RouterLink("More", MorehView.class);

        //icon add
        Icon logoV = new Icon(VaadinIcon.HEART_O);
        logoV.getStyle().set("cursor", "pointer");
        logoV.addClickListener(e ->
                logoV.getUI().ifPresent(ui ->
                        ui.navigate("likeview"))
        );
        logoV.addClassName("heart");

        //icon add to header layout horizontaly
        HorizontalLayout likelayout=new HorizontalLayout(logoV);
        likelayout.setSizeFull();
        likelayout.setHeight("40px");

        //add links to headertab
        header.add(home,about,contact,more,likelayout);

        addToNavbar(header);

    }




}
