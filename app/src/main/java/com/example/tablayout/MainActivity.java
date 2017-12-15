package com.example.tablayout;

import android.content.res.TypedArray;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * OPCION 1:
 * En este ejercicio hemos visto como crear un TabLayout de forma independiente a ViewPager
 * Para ello hay que implementar listener en TabLayout y también en ViewPager
 * Se vinculan de forma que se actualicen mutuamente
 * También usamos transiciones, animaciones, externas (DepthPageTransformer)
 *
 * OPCION 2:
 * Vincular TabLayout a ViewPager con método setupWithViewPager()
 * Solo se debe cumplir ÚNICAMENTE EL SIGUIENTE REQUISITO:
 * El titulo de las pestañas del Tab se inicializan mediante getTitle
 *
 * @author Elena Guzmán Blanco
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    TypedArray iconos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconos = getResources().obtainTypedArray(R.array.iconos);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Configurando TabLayout
        // > Movimiento de pestañas
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        // > Añadir titulo a tabs mediante string[] (recurso)
        for (String title:getResources().getStringArray(R.array.tabs))
        {
            //tabLayout.addTab(tabLayout.newTab().setText(title));
            tabLayout.addTab(tabLayout.newTab());
        }

        // Configurar ViewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), 5, new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.tabs)))));
        viewPager.setPageTransformer(true, new DepthPageTransformer());

        // OPCION 2:

        tabLayout.setupWithViewPager(viewPager);

        // Si se quiere personalizar las pestañas de TabLayout siempre se debe realizar después
        //del método setupTabIcons()
        goodSetupTabIcons();

        /* OPCION 1:
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabLayout.setScrollPosition(position, positionOffset, true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        */
    }

    // Mal método
    private void setupTabIcons()
    {
        tabLayout.getTabAt(0).setIcon(R.drawable.blogger);
        tabLayout.getTabAt(1).setIcon(R.drawable.linkedin);
        tabLayout.getTabAt(2).setIcon(R.drawable.snapchat);
        tabLayout.getTabAt(3).setIcon(R.drawable.tumblr);
        tabLayout.getTabAt(4).setIcon(R.drawable.fb);
    }

    // Método ideal
    private void goodSetupTabIcons()
    {
        for (int i = 0; i < iconos.length(); i++)
        {
            tabLayout.getTabAt(i).setIcon(iconos.getResourceId(i, 0));
        }
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
