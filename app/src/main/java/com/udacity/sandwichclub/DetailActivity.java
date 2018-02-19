package com.udacity.sandwichclub;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;
    private static final String NEWLINE = "\n";

    //Sandwich mSandwich;
    private ImageView mivSandwich;
    private TextView mtvOrigin;
    private TextView mtvAKA;
    private TextView mtvDescription;
    private TextView mtvIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        mivSandwich= findViewById(R.id.image_iv);
        mtvAKA= findViewById(R.id.also_known_tv);
        mtvDescription= findViewById(R.id.description_tv);
        mtvOrigin= findViewById(R.id.origin_tv);
        mtvIngredients= findViewById(R.id.ingredients_tv);

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich= JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        if (!TextUtils.isEmpty(sandwich.getMainName()))
            setTitle(sandwich.getMainName());

        populateUI(sandwich);

        if (!TextUtils.isEmpty(sandwich.getImage())) {
            Picasso.with(this)
                    .load(sandwich.getImage())
                    .into(mivSandwich);
        }
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {
        //mtvDescription.setText(TextUtils.isEmpty(sandwich.getDescription()) ? getString(R.string.detail_notavailable) : sandwich.getDescription());
        writeToTextView(mtvDescription,sandwich.getDescription(),getString(R.string.detail_notavailable));

        //mtvOrigin.setText(TextUtils.isEmpty(sandwich.getPlaceOfOrigin()) ? getString(R.string.detail_unknown) : sandwich.getPlaceOfOrigin());
        writeToTextView(mtvOrigin,sandwich.getPlaceOfOrigin(),getString(R.string.detail_unknown));

        //String sAka = stringFromList(sandwich.getAlsoKnownAs());
        //mtvAKA.setText(TextUtils.isEmpty(sAka) ? getString(R.string.detail_unknown)+NEWLINE : sAka);
        writeToTextView(mtvAKA,stringFromList(sandwich.getAlsoKnownAs()),getString(R.string.detail_unknown)+NEWLINE);

        //String sIngred = stringFromList(sandwich.getIngredients());
        //mtvIngredients.setText(TextUtils.isEmpty(sIngred) ? getString(R.string.detail_notavailable) : sIngred);
        writeToTextView(mtvIngredients,stringFromList(sandwich.getIngredients()),getString(R.string.detail_notavailable));
    }

    private void writeToTextView(TextView textView, String text, String errorText){
        if(TextUtils.isEmpty(text)){
            textView.setText(errorText);
            textView.setTypeface(null, Typeface.ITALIC);
            return;
        }
        textView.setText(text);
    }

    private static String stringFromList(List<String> list){
        StringBuilder builder = new StringBuilder();
        for (String item:list){
            builder.append(item).append(NEWLINE);
        }
        return builder.toString();
    }

}
