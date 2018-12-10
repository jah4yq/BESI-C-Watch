package edu.virginia.cs.mooncake.wada;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.virginia.cs.mooncake.wada.utils.DateTimeUtil;
import edu.virginia.cs.mooncake.wada.utils.FileUtil;
import edu.virginia.cs.mooncake.wada.utils.ServiceUtil;
import edu.virginia.cs.mooncake.wada.utils.SharedPrefUtil;
import edu.virginia.cs.mooncake.wada.utils.WadaUtils;

import static edu.virginia.cs.mooncake.wada.utils.FileUtil.saveStringToFile;


public class EMAActivity extends Activity{

    int EMAcount, i;
    String question;
    private TextView questionView, answerView;
    private TextView q,a;
    String[] answer;
    int EMA_FLAG;
    long EMA_time;
    String painText0,painText1,painText2,painText3,painText4;
    Button minusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memento_ema);

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(500);

        Log.i("EMA_FLAG = ", Integer.toString(EMA_FLAG));

        EMAcount = 0;
        i = 10000000;


        if (EMAcount == 0) {

            //minusButton.setEnabled(false);

            //question = "Are you in pain now?";
            question = "Is the patient having cancer pain now?";

            String[] answer = {"YES", "NO"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%2]);


        }
        if (EMAcount == 1) {

            //i=5;

            //question = "What is your pain level?";
            question = "What is the patient's pain level?";

            String[] answer = {"0","1","2","3","4","5","6","7","8","9","10"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%11]);

        }
        if (EMAcount == 2) {

            //i=2;

            question = "How distressed are you?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 3) {

            //i=2;

            //question = "How distressed is your caregiver?";
            question = "How distressed is the patient?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very", "Unsure"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%5]);

        }
        if (EMAcount == 4){

            //question = "Did you take an opioid for the pain?";
            question = "Did the patient take an opoid for the pain?";

            String[] answer = {"YES", "NO"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%2]);

        }





    }


    public void incClick(View v) {
        i++;

        if (EMAcount == 0) {

            //minusButton.setEnabled(false);

            //question = "Are you in pain now?";
            question = "Is the patient having cancer pain now?";

            String[] answer = {"YES", "NO"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%2]);


        }
        if (EMAcount == 1) {

            //i=5;

            //question = "What is your pain level?";
            question = "What is the patient's pain level?";

            String[] answer = {"0","1","2","3","4","5","6","7","8","9","10"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%11]);

        }
        if (EMAcount == 2) {

            //i=2;

            question = "How distressed are you?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 3) {

            //i=2;

            //question = "How distressed is your caregiver?";
            question = "How distressed is the patient?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very", "Unsure"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%5]);

        }
        if (EMAcount == 4){

            //question = "Did you take an opioid for the pain?";
            question = "Did the patient take an opoid for the pain?";

            String[] answer = {"YES", "NO"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%2]);

        }


        //setEMA(answer,question,answer[i]);

    }


    public void nextClick(View v) {

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        //Save answer

        if (EMAcount == 0) {

            //minusButton.setEnabled(false);

            String response = a.getText().toString();

            painText0 = "PAIN EMA 1, " + response +", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "pain";
            FileOutputStream fos = null;

            //saveStringToFile(fileName, painText);

            if (i%2 == 1){

                EMAcount = 0;
                i = 0;

                startActivity(new Intent(this, ClockfaceActivity.class));


            }
        }
        if (EMAcount == 1) {
            String response = a.getText().toString();
            painText1 = "PAIN EMA 2, " + response +", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "pain";
            FileOutputStream fos = null;

            //saveStringToFile(fileName, painText);
        }
        if (EMAcount == 2) {
            String response = a.getText().toString();
            painText2 = "PAIN EMA 3, " + response +", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "pain";
            FileOutputStream fos = null;

            //saveStringToFile(fileName, painText);

        }
        if (EMAcount == 3) {
            String response = a.getText().toString();
            painText3 = "PAIN EMA 4, " + response +", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "pain";
            FileOutputStream fos = null;

            //saveStringToFile(fileName, painText);

        }
        if (EMAcount == 4){
            String response = a.getText().toString();
            painText4 = "PAIN EMA 5, " + response +", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "pain";
            FileOutputStream fos = null;

            //saveStringToFile(fileName, painText);

        }

        EMAcount++;

        if (EMAcount == 0) {

            //minusButton.setEnabled(false);

            //question = "Are you in pain now?";
            question = "Is the patient having cancer pain now?";

            String[] answer = {"YES", "NO"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%2]);


        }

        if (EMAcount == 1) {

            i = 5*100000000;

            //question = "What is your pain level?";
            question = "What is the patient's pain level?";

            String[] answer = {"0","1","2","3","4","5","6","7","8","9","10"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%11]);

        }
        if (EMAcount == 2) {

            question = "How distressed are you?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 3) {

            //i=2;

            //question = "How distressed is your caregiver?";
            question = "How distressed is the patient?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very", "Unsure"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%5]);

        }
        if (EMAcount == 4){

            //question = "Did you take an opioid for the pain?";
            question = "Did the patient take an opioid for the pain?";

            String[] answer = {"YES", "NO"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (Button)findViewById(R.id.answerView);
            a.setText(answer[i%2]);






        }
        if (EMAcount >= 5){
            //special conditions

            //Toast.makeText(this,"Thank you!",Toast.LENGTH_SHORT).show();

            String fileName = "pain";

            saveStringToFile(fileName, painText0);
            saveStringToFile(fileName, painText1);
            saveStringToFile(fileName, painText2);
            saveStringToFile(fileName, painText3);
            saveStringToFile(fileName, painText4);

            EMA_time = System.currentTimeMillis();
            //Toast.makeText(this, "EMA_FLAG = TRUE", Toast.LENGTH_SHORT).show();

            Calendar EMA_cal = Calendar.getInstance();

            EMA_cal.setTimeInMillis(EMA_time + 1800000L);

            Intent EMA_intent = new Intent(this, EMA2Activity.class);

            PendingIntent pIntent = PendingIntent.getActivity(this, 10, EMA_intent, PendingIntent.FLAG_UPDATE_CURRENT);

            ((AlarmManager) getSystemService(ALARM_SERVICE)).set(AlarmManager.RTC_WAKEUP, EMA_cal.getTimeInMillis(), pIntent);

            Toast.makeText(this,"Thank you!",Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, ClockfaceActivity.class));



        }


    }

    public void backClick(View v) {

        EMAcount--;

        if (EMAcount == 0) {

            //minusButton.setEnabled(false);

            //question = "Are you in pain now?";
            question = "Is the patient having cancer pain now?";

            String[] answer = {"YES", "NO"};

            q = (TextView) findViewById(R.id.questionView);
            q.setText(question);

            a = (Button) findViewById(R.id.answerView);
            a.setText(answer[i % 2]);


        }

        if (EMAcount == 1) {

            i = 5 * 100000000;

            //question = "What is your pain level?";
            question = "What is the patient's pain level?";

            String[] answer = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            q = (TextView) findViewById(R.id.questionView);
            q.setText(question);

            a = (Button) findViewById(R.id.answerView);
            a.setText(answer[i % 11]);

        }
        if (EMAcount == 2) {

            question = "How distressed are you?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView) findViewById(R.id.questionView);
            q.setText(question);

            a = (Button) findViewById(R.id.answerView);
            a.setText(answer[i % 4]);

        }
        if (EMAcount == 3) {

            //i=2;

            //question = "How distressed is your caregiver?";
            question = "How distressed is the patient?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very", "Unsure"};

            q = (TextView) findViewById(R.id.questionView);
            q.setText(question);

            a = (Button) findViewById(R.id.answerView);
            a.setText(answer[i % 5]);

        }
        if (EMAcount == 4) {

            //question = "Did you take an opioid for the pain?";
            question = "Did the patient take an opioid for the pain?";

            String[] answer = {"YES", "NO"};

            q = (TextView) findViewById(R.id.questionView);
            q.setText(question);

            a = (Button) findViewById(R.id.answerView);
            a.setText(answer[i % 2]);

        }

    }





}
