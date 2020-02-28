package com.example.canteensystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText name, email, password, phone, username;
    private Button register, login;
    private ProgressBar loading;
    private static String url_register = "http://nbisdb.000webhostapp.com/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loading = (ProgressBar) findViewById(R.id.loading);
        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        username = (EditText)findViewById(R.id.username);
        email = (EditText)findViewById(R.id.email);
        password =(EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.login);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namet = name.getText().toString().trim();
                String emailt = email.getText().toString().trim();
                String usernamet = username.getText().toString().trim();
                String phonet = phone.getText().toString().trim();
                String passwordt = password.getText().toString().trim();

                    if(namet.isEmpty()){
                        name.setError("Enter the NameField!");
                    }else if(emailt.isEmpty()){
                        email.setError("Enter the EmailField!");

                    }else if(usernamet.isEmpty()){
                        username.setError("Enter the UsernameField!");

                    }else if(phonet.isEmpty()){
                        phone.setError("Enter the PhoneNumberField!");

                    }else if(passwordt.isEmpty()){
                        password.setError("Enter the PasswordField!");

                    }
                    else {

                        Register();
                        Intent i = new Intent(MainActivity.this, Login.class);
                        startActivity(i);
                    }

                }


        });

    }

    private void Register(){
        loading.setVisibility(View.VISIBLE);
        register.setVisibility(View.INVISIBLE);

        final String name = this.name.getText().toString();
        final String email = this.email.getText().toString();
        final String password = this.password.getText().toString();
        final String phone = this.phone.getText().toString();
        final String userame = this.username.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_register,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            System.out.println(jsonObject);
                            String success = jsonObject.getString("success");
                            if(success.equals("1")){
                                loading.setVisibility(View.GONE);
                                register.setVisibility(View.VISIBLE);
                                Toast.makeText(MainActivity.this, "Register Successfully!", Toast.LENGTH_LONG).show();
                            } else if (success.equals("0")) {
                                loading.setVisibility(View.GONE);
                                register.setVisibility(View.VISIBLE);
                                Toast.makeText(MainActivity.this, "Register Unsuccessful!", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Register Error!" + e.toString(), Toast.LENGTH_LONG).show();
                            loading.setVisibility(View.GONE);
                            register.setVisibility(View.VISIBLE);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.setVisibility(View.GONE);
                register.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Register Error!" + error.toString(), Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("password", password);
                params.put("phone", phone);
                params.put("username", userame);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);

    }
}
