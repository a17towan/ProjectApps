package com.example.projectapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    private String[] catRace = {"Matterbajs", "Majs", "Bitch"};
    private String[] catColor = {"Mateee", "Lamp", "Bitcccch"};
    private String[] catSize = {"Large", "Medium", "Small"};

    private ArrayList<Cats> Cats = new ArrayList<>();

    private ArrayAdapter<String> adapter;
    ListView my_listview;

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void buttonOnClick (View v){
        Button button=(Button) v;
        startActivity(new Intent(getApplicationContext(),AboutActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.list_item_textview, R.id.list_item_textviewtest);
        my_listview = (ListView) findViewById(R.id.my_listview);
        my_listview.setAdapter(adapter);

        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String korv = new String("");

                Intent intent = new Intent(MainActivity.this, CatsDetailsActivity.class);
                intent.putExtra("Race", Cats.get(i).getRace() );
                intent.putExtra("Color", Cats.get(i).getColor());
                intent.putExtra("Size", Cats.get(i).getSize());
                intent.putExtra("catImg", Cats.get(i).getCatImg());

                startActivity(intent);
                Toast.makeText(getApplicationContext(), korv+"Race:"+Cats.get(i).getRace()+ "|Color:"+Cats.get(i).getColor()+"|Cat size:"+Cats.get(i).getSize(), Toast.LENGTH_SHORT).show();
            }

        });

        new FetchData().execute();

    }

    private class FetchData extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... params) {
            // These two variables need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a Java string.
            String jsonStr = null;

            try {
                // Construct the URL for the Internet service
                URL url = new URL("http://wwwlab.iit.his.se/a17towan/Progr.%20av%20mobilapplikationer/towe.json");

                // Create the request to the PHP-service, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                jsonStr = buffer.toString();
                return jsonStr;
            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in
                // attempting to parse it.
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("Network error", "Error closing stream", e);
                    }
                }
            }
        }


        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);
            // This code executes after we have received our data. The String object o holds
            // the un-parsed JSON string or is null if we had an IOException during the fetch.

            // Implement a parsing code that loops through the entire JSON and creates objects
            // of our newly created Mountain class.

            //setContentView(R.layout.parse);
            Log.d("ToweDebugg", "Debugging starting");
            Log.d("ToweDebugg", o);

            try {
                JSONArray json1 = new JSONArray(o);

                Log.d("ToweDebugg", json1.toString());
                for(int i = 0; i < json1.length(); i++) {
                    Log.d("ToweDebugg", json1.getJSONObject(i).getString("Race"));
                    adapter.add(json1.getJSONObject(i).getString("Race"));
                    Cats.add(new Cats(
                            json1.getJSONObject(i).getString("Race"),
                            json1.getJSONObject(i).getString("Color"),
                            json1.getJSONObject(i).getString("Size"),
                            json1.getJSONObject(i).getString("catImg")
                    ));
                }
            } catch (JSONException e) {
                Log.e("ToweDebugg","E:"+e.getMessage());
            }
            /*

             */
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
