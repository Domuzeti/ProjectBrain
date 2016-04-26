package be.Stude.stude;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

import be.Stude.stude.db.ElementAdaptater;
import be.Stude.stude.db.ThemeAdaptater;
import be.Stude.stude.struct.Element;
import be.Stude.stude.struct.Theme;

public class Home extends Activity {


    // private ListView lv = null;
    private int selectedIdTheme = -1;
    private List<Element> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }


    /*public void onStart(){
        super.onStart();

        initExampleTheme();
        // initExampleElement();

        if (selectedIdTheme == -1) {
            setListViewWithTheme();
        } else {
            setListViewWithElement();
        }

    }*/

    private void setListViewWithTheme() {
        ThemeAdaptater adapt = new ThemeAdaptater(getApplicationContext());
        adapt.openWritable();
        ListView lv = (ListView) findViewById(R.id.lvThemes);

        Cursor c = adapt.getAllCharCursor();

        String[] from = {adapt.colonne_Name};
        int[] to = {android.R.id.text1};

        SimpleCursorAdapter sc = new SimpleCursorAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_2, c, from, to);

        lv.setAdapter(sc);
        adapt.close();
    }

    private void setListViewWithElement() {
        ElementAdaptater adapt = new ElementAdaptater(getApplicationContext());
        adapt.openWritable();
        ListView lv = (ListView) findViewById(R.id.lvThemes);

        elements = adapt.getAllCharFromThemeList(selectedIdTheme);
        Cursor c = adapt.getAllCharFromThemeCursor(selectedIdTheme);

        String[] from = {adapt.colonne_id, adapt.colonne_Word};
        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleCursorAdapter sc = new SimpleCursorAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, c, from, to);

        lv.setAdapter(sc);
        adapt.close();
    }

    public void initExampleTheme(){

        ThemeAdaptater adapt = new ThemeAdaptater(getApplicationContext());
        adapt.openWritable();

        Theme theme = new Theme("Example");
        adapt.insertTheme(theme);
        theme = new Theme("test1");
        adapt.insertTheme(theme);
        theme = new Theme("test2");
        adapt.insertTheme(theme);

        adapt.close();
    }

    public void initExampleElement() {
        ElementAdaptater adapt = new ElementAdaptater(getApplicationContext());
        adapt.openWritable();

        Element elem = new Element(1, "manger", "to eat");
        adapt.insertElement(elem);
        elem = new Element(1, "prendre", "to take");
        adapt.insertElement(elem);
        elem = new Element(1, "avoir", "to have");
        adapt.insertElement(elem);
        elem = new Element(1, "être", "to be");
        adapt.insertElement(elem);

        adapt.close();
    }

    public void delAllTheme() {
        ThemeAdaptater adapt = new ThemeAdaptater(getApplicationContext());
        adapt.openWritable();
        adapt.delAll();
        adapt.close();
    }

    public void setListView(){

    }


    public void butSet(View v) {
        setContentView(R.layout.settings);

    }

    public void butBack(View v) {
        setContentView(R.layout.home);

    }

    public void butConfirm(View v) {
        setContentView(R.layout.home);

    }

    public void butTheme(View v) {
        setContentView(R.layout.themesmanagement);

        ListView lvthemes = (ListView) findViewById(R.id.lvThemes);
       // ListView lv = (ListView) findViewById(R.id.lvThemes);

        ThemeAdaptater themeAdapt = new ThemeAdaptater(getApplicationContext());
        themeAdapt.openWritable();
        Cursor themeCursor = themeAdapt.getAllCharCursor();
        String[] from = {themeAdapt.colonne_Name};
        int [] to = {android.R.id.text1};

        SimpleCursorAdapter sc = new SimpleCursorAdapter(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, themeCursor,from, to);

        lvthemes.setAdapter(sc);
        themeAdapt.close();


    }

    public void butAddTheme(View v) {
        setContentView(R.layout.addtheme);

    }

    public void butCancelTheme(View v) {
        setContentView(R.layout.home);

    }


    public void butCreateTheme(View v) {
        setContentView(R.layout.thememanagement);

    }

    public void butAddElement(View v) {
        setContentView(R.layout.addelement);

    }

    public void butCancelElement(View v) {
        setContentView(R.layout.thememanagement);

    }

    public void butOkElement(View v) {
        setContentView(R.layout.thememanagement);

    }


    public void butStart(View v) {
        setContentView(R.layout.start);

    }






}
