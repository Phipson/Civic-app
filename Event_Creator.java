package ecomap.a2017.lahacks.ecomap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by 14leec1 on 1/4/2017.
 */

public class Event_Creator extends Activity {


        EditText editEvent_Name, editEvent_Descr;

        Date time = Calendar.getInstance().getTime();

        String GetName, GetDescr, GetTime, User;

        Random r = new Random();

        int id;

        Button buttonSubmit, buttonDelete ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            editEvent_Name = (EditText)findViewById(R.id.editText1);
            editEvent_Descr = (EditText)findViewById(R.id.editText2);

            buttonSubmit = (Button)findViewById(R.id.button1);

            buttonDelete = (Button)findViewById(R.id.button2);

            buttonSubmit.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    GetDataFromEditText();

                    id = r.nextInt();

                    String ID = Integer.toString(id);

                    String ar[] = {ID, GetName, GetDescr, GetTime, User};

                    MySQL_Java Object = new MySQL_Java();

                    Object.getConnection(ar);

                }
            });

            buttonSubmit.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    GetDataFromEditText();

                    id = r.nextInt();

                    String[] ar = new String[6];

                    MySQL_JavaGetValues Object = new MySQL_JavaGetValues();

                    Object.getData(ar, id);

                }
            });


        }

        public void GetDataFromEditText(){

            GetName = editEvent_Name.getText().toString();
            GetDescr = editEvent_Descr.getText().toString();
            GetTime = time.toString();

        }
}