package com.android.iit.chrs.gosari;


    import android.content.Intent;
    import android.graphics.drawable.ColorDrawable;
    import android.net.Uri;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.Button;
    import android.widget.ListView;
    import android.widget.Toast;

    import org.json.JSONArray;

    import java.util.ArrayList;

    public class ViewFood extends AppCompatActivity {

        public static ArrayList<ItemCategory> foodList;

        static ItemAdapter adapter;

        public static JSONArray catergories = null;

        public static String message;

        Button ViewCart;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setContentView(R.layout.activity_view_food);

            AsyncTaskItem.UrlChoice = 1;

            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

            foodList = new ArrayList<ItemCategory>();

            new AsyncTaskItem(this).execute();

            ListView listview = (ListView) findViewById(R.id.list);

            adapter = new ItemAdapter(getApplicationContext(), R.layout.row_food, foodList);

            assert listview != null;
            listview.setAdapter(adapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                    int test = Integer.parseInt(foodList.get(position).getPk());
                    int choice = test;
                    ViewFoodItems.title=foodList.get(position).getCategory();

                    switch (choice) {
                        case 1:
                            AsyncTaskFoodItem.url = "http://192.168.1.11/shop/api/items/list.php?categories_pk=1&archived=false";
                            break;
                        case 2:
                            AsyncTaskFoodItem.url = "http://192.168.1.11/shop/api/items/list.php?categories_pk=2&archived=false";
                            break;
                        case 3:
                            AsyncTaskFoodItem.url = "http://192.168.1.11/shop/api/items/list.php?categories_pk=3&archived=false";
                            break;
                        case 4:
                            AsyncTaskFoodItem.url = "http://192.168.1.11/shop/api/items/list.php?categories_pk=4&archived=false";
                            break;
                        case 5:
                            AsyncTaskFoodItem.url = "http://192.168.1.11/shop/api/items/list.php?categories_pk=5&archived=false";
                            break;
                    }
                    Toast.makeText(getApplicationContext(), String.valueOf(test), Toast.LENGTH_SHORT).show();

                    Intent ShowFoodItem = new Intent(getApplicationContext(), ViewFoodItems.class);
                    startActivity(ShowFoodItem);

                }
            });

        }

    }