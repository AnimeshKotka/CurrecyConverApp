package learncodeonline.in.cuccencyconverterapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.concurrent.ExecutionException;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    Button euro, pound, dollar, yen, dinar, bitcoin, rubel, ausdollar, candollar;
    EditText editText;
    TextView textView;
    JSONObject obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findIds();
        new CConvert().execute();
        OnClickForAll();


    }

    //This is a function for set on click listener for all elements.
    public void OnClickForAll() {
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String z = editText.getText().toString();

                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n, k;

                    Toasty.normal(MainActivity.this,"Euro", Toast.LENGTH_SHORT,getDrawable(R.drawable.euro)).show();
                    n = Double.parseDouble(z);
                    textView.setText(null);
                    Formatter formatter = new Formatter();
                    //Log.i("Obj ka ", obj.toString());

                    try {
                        Double cur = obj.getDouble("EUR");
                        k = n*cur;
                        DecimalFormat numberFormat = new DecimalFormat("#.00");
                        textView.setText("" + numberFormat.format(k));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        });



        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();

                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n, k;

                    Toasty.normal(MainActivity.this,"Pound",
                            Toasty.LENGTH_SHORT,
                            getDrawable(R.drawable.pound)).show();
                    n = Double.parseDouble(z);
                    textView.setText(null);
                    try {
                        Double cur = obj.getDouble("GBP");
                        k = n*cur;
                        DecimalFormat numberFormat = new DecimalFormat("#.00");
                        textView.setText("" + numberFormat.format(k));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();

                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n, k;

                    Toasty.normal(MainActivity.this,
                            "US Dollar",Toasty.LENGTH_SHORT,
                            getDrawable(R.drawable.dollarsec)).show();

                    n = Double.parseDouble(z);
                    textView.setText(null);
                    Formatter formatter = new Formatter();
                    try {
                        Double cur = obj.getDouble("USD");
                        k = n*cur;
                        DecimalFormat numberFormat = new DecimalFormat("#.00");
                        textView.setText("" + numberFormat.format(k));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        yen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();

                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n, k;
                    Toasty.normal(MainActivity.this,
                            "Yen",Toasty.LENGTH_SHORT,
                            getDrawable(R.drawable.yensec)).show();

                    n = Double.parseDouble(z);
                    textView.setText(null);
                    Formatter formatter = new Formatter();
                    try {
                        Double cur = obj.getDouble("JPY");
                        k = n*cur;
                        DecimalFormat numberFormat = new DecimalFormat("#.00");
                        textView.setText("" + numberFormat.format(k));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        dinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();

                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n, k;

                    Toasty.normal(MainActivity.this,
                            "Korean won ",Toasty.LENGTH_SHORT,
                            getDrawable(R.drawable.dinar)).show();
                    n = Double.parseDouble(z);
                    textView.setText(null);
                    Formatter formatter = new Formatter();
                    try {
                        Double cur = obj.getDouble("KRW");
                        k = n*cur;
                        DecimalFormat numberFormat = new DecimalFormat("#.00");
                        textView.setText("" + numberFormat.format(k));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();

                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n, k;

                    Toasty.normal(MainActivity.this,
                            "Hong Kong Dollar",Toasty.LENGTH_SHORT,
                            getDrawable(R.drawable.hong)).show();
                    n = Double.parseDouble(z);
                    textView.setText(null);
                    Formatter formatter = new Formatter();
                    k = n * 0.0000013;
                    //Bitcoin

                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    textView.setText("" + numberFormat.format(k));
//                    textView.setText(""+k);
                }
            }
        });

        rubel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();

                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n, k;

                    Toasty.normal(MainActivity.this,
                            "Russian  Ruble",Toasty.LENGTH_SHORT,
                            getDrawable(R.drawable.rouble)).show();
                    n = Double.parseDouble(z);
                    textView.setText(null);
                    Formatter formatter = new Formatter();
                    try {
                        Double cur = obj.getDouble("RUB");
                        k = n*cur;
                        DecimalFormat numberFormat = new DecimalFormat("#.00");
                        textView.setText("" + numberFormat.format(k));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        ausdollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();

                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n, k;

                    Toasty.normal(MainActivity.this,
                            "Australian Dollar",Toasty.LENGTH_SHORT,
                            getDrawable(R.drawable.ausdollar)).show();
                    n = Double.parseDouble(z);
                    textView.setText(null);
                    Formatter formatter = new Formatter();
                    try {
                        Double cur = obj.getDouble("AUD");
                        k = n*cur;
                        DecimalFormat numberFormat = new DecimalFormat("#.00");
                        textView.setText("" + numberFormat.format(k));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        candollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();

                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n, k;

                    Toasty.normal(MainActivity.this,
                            "Canadian Dollar",Toasty.LENGTH_SHORT,
                            getDrawable(R.drawable.cd)).show();
                    n = Double.parseDouble(z);
                    textView.setText(null);
                    Formatter formatter = new Formatter();
                    try {
                        Double cur = obj.getDouble("CAD");
                        k = n*cur;
                        DecimalFormat numberFormat = new DecimalFormat("#.00");
                        textView.setText("" + numberFormat.format(k));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    //This is a function for find views bt ids
    void findIds(){
        euro = findViewById(R.id.euro);

        pound = findViewById(R.id.pound);

        dollar = findViewById(R.id.dollar);

        yen = findViewById(R.id.yen);

        dinar = findViewById(R.id.dinar);

        bitcoin=findViewById(R.id.bitcoin);
        //TODO: to track the value of bitcoin use apis
        rubel = findViewById(R.id.rubel);
        //TODO:
        ausdollar = findViewById(R.id.ausdollar);
        //TODO:
        candollar = findViewById(R.id.candollar);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

    }

    //This is class for load data from api
     class CConvert extends AsyncTask<Void, Void, String>{

        ProgressDialog pd = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {

            //pd.setMessage("Wait");
            //pd.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            String url__ = "https://api.exchangeratesapi.io/latest?base=INR";

            try {
                URL url = new URL(url__);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try{

                    BufferedReader bf = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuffer buffer = new StringBuffer();
                    String line;
                    while ((line = bf.readLine())!=null){
                        buffer.append(line).append("\n");
                    }
                    bf.close();
                    Log.i("Values : ",buffer.toString());
                    return buffer.toString();
                } finally {
                    urlConnection.disconnect();
                }

            } catch (Exception e){
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
           // pd.dismiss();
            try{
                JSONObject rate = new JSONObject(s);
                obj = rate.getJSONObject("rates");


            } catch (JSONException e){
                e.printStackTrace();
            }
        }
    }

}









