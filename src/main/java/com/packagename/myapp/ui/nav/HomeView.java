package com.packagename.myapp.ui.nav;

import com.packagename.myapp.ui.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="", layout = MainView.class)
//
@PageTitle("Home")

@CssImport("./styles/shared-styles.css")

public class HomeView extends VerticalLayout {
    //H1 h1=new H1("Home");

    //define the main layout
    VerticalLayout vl=new VerticalLayout();

    public HomeView(){

        //layout for title "find adoptable pets near"
        HorizontalLayout findadopt=new HorizontalLayout();
        H2 title=new H2("Find an adoptable pet near you");
        findadopt.add(title);

        //css class for title "find adoptable pets near"
        title.addClassName("titletext");

        //form layout as formvert
        VerticalLayout formvert=new VerticalLayout();

        //layouts for text fields
        HorizontalLayout formlayoutr1=new HorizontalLayout();
        HorizontalLayout formlayoutr2=new HorizontalLayout();
        HorizontalLayout formlayoutr3=new HorizontalLayout();
        HorizontalLayout formlayoutr4=new HorizontalLayout();

        TextField state = new TextField(); //state
        state.setLabel("Location");
        state.setPlaceholder("State");

        NumberField miles = new NumberField(); //miles
        miles.setHasControls(true);
        miles.setLabel("Miles");
        formlayoutr1.setDefaultVerticalComponentAlignment(Alignment.END);

        formlayoutr1.add(state,miles);

        Checkbox dogs = new Checkbox("Dogs");
        Checkbox cats = new Checkbox("Cats");
        Checkbox reptiles = new Checkbox("Reptiles");
        Checkbox birds = new Checkbox("Birds");
        Checkbox rabbits = new Checkbox("Rabbits");
        Checkbox small = new Checkbox("Small");
        Checkbox big = new Checkbox("Big");

        formlayoutr2.add(dogs,cats,reptiles,birds,rabbits,small,big);

        Select<String> sex = new Select<>();//combobox
        sex.setItems("any", "male");
        sex.setLabel("Sex");
        sex.setPlaceholder("sex");

        Select<String> age = new Select<>();
        age.setItems("any","puppy", "young");
        age.setLabel("Age");
        age.setPlaceholder("any");

        Select<String> size = new Select<>();
        size.setItems("any", "small");
        size.setLabel("Size");
        size.setPlaceholder("any");

        formlayoutr3.add(sex,age,size);

        Select<String> color= new Select<>();
        color.setItems("any", "white","white");
        color.setLabel("Color");
        color.setPlaceholder("any");

        Select<String> breed= new Select<>();
        breed.setItems("any", "dogs");
        breed.setLabel("Breed");
        breed.setPlaceholder("any");

        formlayoutr4.add(color,breed);

        formvert.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Button search=new Button("Search",click->
        {
            HorizontalLayout data=new HorizontalLayout();
            Span details=new Span(state.getValue());
            data.add(details);
            vl.add(data);
        });
        search.setWidth("160px");

        formvert.add(formlayoutr1,formlayoutr2,formlayoutr3,formlayoutr4, search);

        vl.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        //add defined card layout
        HorizontalLayout workspace = new HorizontalLayout(createCard(), createCard(), createCard(), createCard(),createCard(), createCard());
        workspace.addClassName("workspace");

        //add to main layout
        vl.add(title,formvert,workspace);

        //layout add to page - main vertical unit layout
        add(vl);
    }

    //create cards
    private Component createCard() {

        //card title
        H4 card1Label = new H4("Title");
        //card details
        Span details = new Span("dogs are near to you selected area");
        details.setWidth("180px");

        Image image = new Image("icons/img.jpg", "DummyImage");
        image.addClassName("image");
        image.setWidth("160px");
        image.setHeight("140px");

        //card layout
        VerticalLayout verrticalcard=new VerticalLayout();
        verrticalcard.setAlignItems(Alignment.CENTER);
        verrticalcard.setJustifyContentMode(JustifyContentMode.CENTER);
        verrticalcard.add(image,card1Label,details);

        FlexLayout card = new FlexLayout(verrticalcard);
        card.addClassName("card");
        card.setAlignItems(Alignment.CENTER);
        card.setJustifyContentMode(JustifyContentMode.CENTER);
        card.setWidth("200px");
        card.setHeight("280px");
        return card;
    }
}
