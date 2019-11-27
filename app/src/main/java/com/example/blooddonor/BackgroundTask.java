package com.example.blooddonor;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String, Void, String>
{
    AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Details");

    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://10.0.2.2/BloodDonor/register.php";
        String login_url = "http://10.0.2.2/BloodDonor/login.php";

        String method = params[0];
        if (method.equals("register"))
        {
            String name = params[1];
            String address = params[2];
            String dob = params[3];
            String phone = params[4];
            String username = params[5];
            String password = params[6];
            String bloodGroup = params[7];

            try
            {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data = URLEncoder.encode("name","UTF-8") + "=" + URLEncoder.encode(name, "UTF-8")+"&"+
                        URLEncoder.encode("address","UTF-8") + "=" + URLEncoder.encode(address, "UTF-8")+"&"+
                        URLEncoder.encode("dob","UTF-8") + "=" + URLEncoder.encode(dob, "UTF-8")+"&"+
                        URLEncoder.encode("phone","UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8") + "=" + URLEncoder.encode(username, "UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")+"&"+
                        URLEncoder.encode("bloodgroup","UTF-8") + "=" + URLEncoder.encode(bloodGroup, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                is.close();
                return "Registration success";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("login"))
        {
            String username = params[1];
            String password = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true); //to send data to the server
                httpURLConnection.setDoInput(true); // to get response from the server
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values)
    {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result)
    {
        if (result.equals("Registration success"))
        {
            Toast.makeText(ctx, result,Toast.LENGTH_LONG).show();
        }
        else
        {
            if (result.equals("fail"))
            {
                alertDialog.setMessage("Username or Password does not match");
                alertDialog.show();
            }
            else
            {
                //MainActivity mainActivity = new MainActivity();
                //mainActivity.goToMainActivity();
            }
        }

    }
}
