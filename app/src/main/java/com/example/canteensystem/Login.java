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
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private EditText email, password;
    private Button login, register;
    private String url_login = "http://nbisdb.000webhostapp.com/login.php";
    private ProgressBar loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.email);
        password =(EditText)findViewById(R.id.password);
        loading = (ProgressBar)findViewById(R.id.loading);
        login = (Button)findViewById(R.id.login);
        register = (Button)findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temail = email.getText().toString().trim();
                String tpassword = password.getText().toString().trim();

                if(!temail.isEmpty() || !tpassword.isEmpty()){
                    Login(temail, tpassword);
                }else{
                    email.setError("Username required!");
                    password.setError("Password Required");
                }

            }

        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
    private  void Login(final String email, final String password){
        loading.setVisibility(View.VISIBLE);
        login.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");

                    if(success.equals("1")){
                        for(int i = 0; i < jsonArray.length(); i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String name = object.getString("name").trim();
                            String email = object.getString("email").trim();

                        }
                        Toast.makeText(Login.this, "Login Success!", Toast.LENGTH_LONG).show();
                        loading.setVisibility(View.GONE);
                        login.setVisibility(View.VISIBLE);
                        Intent i = new Intent(Login.this,home.class );
                        startActivity(i);
                    }else if(success.equals("0")){
                        Toast.makeText(Login.this, "Login Error!", Toast.LENGTH_LONG).show();
                        loading.setVisibility(View.GONE);
                        login.setVisibility(View.VISIBLE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Login.this, "Login Error!:" + e.toString(), Toast.LENGTH_LONG).show();
                    loading.setVisibility(View.GONE);
                    login.setVisibility(View.VISIBLE);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, "Login Error!:" + error.toString(), Toast.LENGTH_LONG).show();
                loading.setVisibility(View.GONE);
                login.setVisibility(View.VISIBLE);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username",email);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

}
