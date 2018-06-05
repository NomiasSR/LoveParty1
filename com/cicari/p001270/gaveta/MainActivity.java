package com.cicari.p001270.gaveta;

import android.content.Intent;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener, OnCommunicateInterface {
    HashMap<String, String> list = new HashMap();
    public int mapTilt;
    public int mapType;
    public MapFragment mf;
    public Tab tabTrocarTexto;
    public TabLayout tbl_pages;
    public String textToSearch;
    public TextView tvUserEmail;
    public TextView tvUserName;
    private User user;

    class FragmentAdapter extends FragmentPagerAdapter {
        public int getCount() {
            return 3;
        }

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    MainActivity.this.mf = new MapFragment();
                    return MainActivity.this.mf;
                case 1:
                    return new MyTopicsFragment();
                case 2:
                    return new MyFriendsFragment();
                default:
                    return 0;
            }
        }

        public CharSequence getPageTitle(int i) {
            switch (i) {
                case 0:
                    return MainActivity.this.getApplicationContext().getString(C0346R.string.MAP);
                case 1:
                    return MainActivity.this.getApplicationContext().getString(C0346R.string.TEXT_MYTOPICS);
                case 2:
                    return MainActivity.this.getApplicationContext().getString(C0346R.string.CONTACTS);
                default:
                    return 0;
            }
        }
    }

    protected void onCreate(android.os.Bundle r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        super.onCreate(r8);
        r8 = 2131361823; // 0x7f0a001f float:1.834341E38 double:1.0530326556E-314;
        r7.setContentView(r8);
        r8 = 2131230950; // 0x7f0800e6 float:1.8077967E38 double:1.0529679957E-314;
        r8 = r7.findViewById(r8);
        r3 = r8;
        r3 = (android.support.v7.widget.Toolbar) r3;
        r7.setSupportActionBar(r3);
        r8 = 2131230799; // 0x7f08004f float:1.807766E38 double:1.052967921E-314;
        r8 = r7.findViewById(r8);
        r8 = (android.support.v4.widget.DrawerLayout) r8;
        r6 = new android.support.v7.app.ActionBarDrawerToggle;
        r4 = 2131558512; // 0x7f0d0070 float:1.8742342E38 double:1.053129833E-314;
        r5 = 2131558511; // 0x7f0d006f float:1.874234E38 double:1.0531298324E-314;
        r0 = r6;
        r1 = r7;
        r2 = r8;
        r0.<init>(r1, r2, r3, r4, r5);
        r8.addDrawerListener(r6);
        r6.syncState();
        r8 = 2131230865; // 0x7f080091 float:1.8077795E38 double:1.052967954E-314;
        r0 = r7.findViewById(r8);
        r0 = (android.support.design.widget.NavigationView) r0;
        r0.setNavigationItemSelectedListener(r7);
        r0 = 0;
        r8 = r7.findViewById(r8);	 Catch:{ Exception -> 0x0071 }
        r8 = (android.support.design.widget.NavigationView) r8;	 Catch:{ Exception -> 0x0071 }
        r8 = r8.getHeaderView(r0);	 Catch:{ Exception -> 0x0071 }
        r1 = 2131230961; // 0x7f0800f1 float:1.807799E38 double:1.052968001E-314;	 Catch:{ Exception -> 0x0071 }
        r1 = r8.findViewById(r1);	 Catch:{ Exception -> 0x0071 }
        r1 = (android.widget.TextView) r1;	 Catch:{ Exception -> 0x0071 }
        r7.tvUserEmail = r1;	 Catch:{ Exception -> 0x0071 }
        r1 = 2131230962; // 0x7f0800f2 float:1.8077992E38 double:1.0529680017E-314;	 Catch:{ Exception -> 0x0071 }
        r8 = r8.findViewById(r1);	 Catch:{ Exception -> 0x0071 }
        r8 = (android.widget.TextView) r8;	 Catch:{ Exception -> 0x0071 }
        r7.tvUserName = r8;	 Catch:{ Exception -> 0x0071 }
        r8 = r7.tvUserEmail;	 Catch:{ Exception -> 0x0071 }
        r1 = com.google.firebase.auth.FirebaseAuth.getInstance();	 Catch:{ Exception -> 0x0071 }
        r1 = r1.getCurrentUser();	 Catch:{ Exception -> 0x0071 }
        r1 = r1.getEmail();	 Catch:{ Exception -> 0x0071 }
        r8.setText(r1);	 Catch:{ Exception -> 0x0071 }
    L_0x0071:
        r8 = 2131230971; // 0x7f0800fb float:1.807801E38 double:1.052968006E-314;
        r8 = r7.findViewById(r8);
        r8 = (android.support.v4.view.ViewPager) r8;
        r1 = new com.cicari.p001270.gaveta.MainActivity$FragmentAdapter;
        r2 = r7.getSupportFragmentManager();
        r1.<init>(r2);
        r8.setAdapter(r1);
        r1 = 2131230931; // 0x7f0800d3 float:1.8077929E38 double:1.0529679864E-314;
        r1 = r7.findViewById(r1);
        r1 = (android.support.design.widget.TabLayout) r1;
        r7.tbl_pages = r1;
        r1 = r7.tbl_pages;
        r1.setupWithViewPager(r8);
        r8 = r7.tbl_pages;
        r1 = 1;
        r8 = r8.getTabAt(r1);
        r7.tabTrocarTexto = r8;
        r8 = r7.tabTrocarTexto;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = 2131558402; // 0x7f0d0002 float:1.8742119E38 double:1.0531297785E-314;
        r3 = r7.getString(r3);
        r2.append(r3);
        r3 = "( ";
        r2.append(r3);
        r3 = r7.getDadosMapa();
        r3 = r3.size();
        r2.append(r3);
        r3 = ")";
        r2.append(r3);
        r2 = r2.toString();
        r8.setText(r2);
        r7.mapType = r1;
        r7.mapTilt = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cicari.p001270.gaveta.MainActivity.onCreate(android.os.Bundle):void");
    }

    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(C0346R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            drawerLayout.closeDrawer((int) GravityCompat.START);
        } else if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0346R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == C0346R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem = menuItem.getItemId();
        if (menuItem == C0346R.id.nav_user) {
            menuItem = new Intent(this, UserActivity.class);
            menuItem.addFlags(67108864);
            startActivity(menuItem);
        } else if (menuItem == C0346R.id.nav_logout) {
            this.user = new User(getResources(), getApplicationContext());
            this.user.updateUserLogin("n");
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } else if (menuItem == C0346R.id.nav_mapbuilding_mode) {
            this.mapType = this.mapType == 1 ? 2 : 1;
            this.mf.changeMapType(this.mapType);
        }
        ((DrawerLayout) findViewById(C0346R.id.drawer_layout)).closeDrawer((int) GravityCompat.START);
        return true;
    }

    public void limparDadosMapa() {
        this.list.clear();
    }

    public void setDadosMapa(String str, String str2) {
        this.list.put(str, str2);
        setTotalMyTopicsOnTab();
    }

    public HashMap<String, String> getDadosMapa() {
        return this.list;
    }

    public void setTotalMyTopicsOnTab() {
        Tab tab = this.tabTrocarTexto;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getString(C0346R.string.TEXT_MYTOPICS));
        stringBuilder.append("( ");
        stringBuilder.append(getDadosMapa().size());
        stringBuilder.append(")");
        tab.setText(stringBuilder.toString());
    }

    public void removeDadosMapa(String str) {
        Iterator it = this.list.entrySet().iterator();
        while (it.hasNext()) {
            if (((Entry) it.next()).getKey().toString().split("||")[0].equalsIgnoreCase(str.split("||")[0])) {
                it.remove();
                break;
            }
        }
        setTotalMyTopicsOnTab();
    }
}
