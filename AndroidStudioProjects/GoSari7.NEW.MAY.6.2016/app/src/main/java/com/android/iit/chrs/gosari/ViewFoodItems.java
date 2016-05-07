package com.android.iit.chrs.gosari;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import android.content.ContentValues;

import android.content.Context;


public class ViewFoodItems extends AppCompatActivity {

    public static ArrayList<ItemFood> ItemfoodList;

    static ItemFoodAdapter adapter;

    public static JSONArray result = null;


    public static String message;

    //int count = 1, totalprice = 0, newcount = 0;

    //String getCount;

    //  Button btnViewCart;

    String pk;
    String pk_categories;
    String items;
    String description;
    String price;
    String delivery_time;

    //DbHelper db;

    String dbmessage;

    //   String totalcount, s_totalprice;

    //static ArrayList<ItemCart> itemlist;

    String date;

    GridView listitem;

    static String title=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_items);


        this.setTitle(title);

        ItemfoodList = new ArrayList<ItemFood>();

        AsyncTaskFoodItem.test = true;

        new AsyncTaskFoodItem(ViewFoodItems.this).execute();

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

        listitem = (GridView) findViewById(R.id.list_food);

        adapter = new ItemFoodAdapter(getApplicationContext(), R.layout.row_food_items, ItemfoodList);

        listitem.setAdapter(adapter);


        listitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                pk = ItemfoodList.get(position).getPk();
                pk_categories = ItemfoodList.get(position).getPk_categories();
                items = ItemfoodList.get(position).getItems();
                description = ItemfoodList.get(position).getDescription();
                price = ItemfoodList.get(position).getPrice();
                delivery_time = ItemfoodList.get(position).getDeliverytime();

            }


        });
    }
}